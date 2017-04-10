package listprojects

import grails.test.spock.IntegrationSpec
import grails.test.mixin.*
import spock.lang.*

class LoginServiceIntegrationSpec extends IntegrationSpec {

    def loginService

    void "test get api call"() {
      setup:
      def setup = new Setup(userName: "Some Username", password:"topSecret")
      SetupService setupService = Mock() {
        findExisting() >> setup
      }
      loginService.setupService = setupService

      when:
      def resp = loginService.callAuth(setup);
      then:
      resp != null
      resp.status >= 200
      }
}
