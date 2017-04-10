package listprojects

import grails.transaction.Transactional
import grails.plugins.rest.client.*
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap

@Transactional
class RestService {

    RestResponse callApi(String url, Map params) {
      RestBuilder rest = new RestBuilder()
      rest.restTemplate.messageConverters.removeAll {
             it.class.name == 'org.springframework.http.converter.json.GsonHttpMessageConverter'
      }

       MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>()
       params.each{ k, v -> map.add(k, v) }
      def resp = rest.post(url) {
        accept 'application/json'
        contentType "application/x-www-form-urlencoded"
        body map
      }
      return resp
    }
}
