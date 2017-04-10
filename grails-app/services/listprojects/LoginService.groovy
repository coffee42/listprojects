package listprojects

import grails.transaction.Transactional
import grails.plugins.rest.client.*
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap


@Transactional
class LoginService {
  SetupService setupService
  RestService restService
  static LOGIN_API_URL = "https://cloud.memsource.com/web/api/v3/auth/login"

  def login() {
    Setup setup = setupService.findExisting()
    RestResponse resp = callAuth(setup)
    saveAuthentication(resp)
    return
  }

  def callAuth(Setup setup) {
    def resp = restService.callApi(LOGIN_API_URL,[userName:setup.userName, password:setup.password])
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
