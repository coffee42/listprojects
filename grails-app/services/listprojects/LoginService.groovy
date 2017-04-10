package listprojects

import grails.transaction.Transactional
import grails.plugins.rest.client.*
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap


@Transactional
class LoginService {
  SetupService setupService
  static LOGIN_API_URL = "https://cloud.memsource.com/web/api/v3/auth/login"

  def login() {
    Setup setup = setupService.findExisting()
    RestResponse resp = callAuth(setup)
    saveAuthentication(resp)
    return
  }

  def callAuth(Setup setup) {
    RestBuilder rest = new RestBuilder()
    rest.restTemplate.messageConverters.removeAll {
           it.class.name == 'org.springframework.http.converter.json.GsonHttpMessageConverter'
       }
     MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>()
     map.add("userName",setup.userName)
     map.add("password",setup.password)


    def resp = rest.post(LOGIN_API_URL) {
      accept 'application/json'
      contentType "application/x-www-form-urlencoded"
      body map
    }
    log.debug(resp.json)
    return resp
  }

  def parseResponse(RestResponse resp) {
      def map = ['token': resp.json.token,
                'expires': resp.json.expires]
      return map
  }

  def saveAuthentication(RestResponse resp) {
    if (resp.status == 200) {
      def loginData = parseResponse(resp)
      setupService.persistLoginData(loginData)
    }
  }

  boolean userIsLoggedIn() {
    boolean result = false
    Setup setup = setupService.findExisting()
    result = setup?.userLogged() == true
    return result;
  }

  String fetchToken() {
    log.info("fetching token")
    Setup setup = setupService.findExisting()
    if (setup != null && setup.userLogged()) {
        log.info("token found ${setup.token}")
        return setup.token
    }
    else {
      return null
      }
  }


}
