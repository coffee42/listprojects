package listprojects

import grails.transaction.Transactional
import grails.plugins.rest.client.*
import org.codehaus.groovy.grails.web.json.*

@Transactional
class ListprojectsService {

    static LIST_PROJECTS_API_URL = "https://cloud.memsource.com/web/api/v3/project/list"
    LoginService loginService
    RestService restService

    def listprojects() {
      String token = loginService.fetchToken();
      RestResponse jsonProjects = null;
      def result = []
      if (token != null) {
        jsonProjects = fetchProjects(token);
        result = parseResponse(jsonProjects.json)
      }
      return result
    }

    private def fetchProjects(String token) {
      RestResponse resp = restService.callApi(LIST_PROJECTS_API_URL,[token:token])
      return resp
    }

    private def parseResponse(JSONArray jsonResp) {
      JSONArray response = new JSONArray();
      if (jsonResp == null) {
        return response
      }
      def props = ["id", "name", "status", "sourceLang", "targetLangs"]
      def objectList = []

      jsonResp.each { object ->
        JSONObject respObject = new JSONObject(object, props.toArray(new String[props.size()]));
        String targetLangs = object['targetLangs'].toArray().join(", ");
        respObject.put('targetLangs', targetLangs)
        response.add(respObject)
        }
        return response
    }
}
