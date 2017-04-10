package listprojects

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Setup)
class SetupSpec extends Specification {

    def "test empty token is user not logged in"() {
      given : "Setup with empty token"
      Setup setup = new Setup(userName:"John", password:"Smith")
      expect:
        setup.userLogged() == false
    }

    def "test token expiration"() {
      given: "non empty token and tomorow as expiration"
      Setup setup = new Setup(userName:"John", password:"Smith",
                              token:"something", expires: new Date().previous())
      expect:
        setup.userLogged() == false
    }

    def "test not expired is logged in"() {
      given: "non empty token and now as expiration"
      Setup setup = new Setup(userName:"John", password:"Smith",
                              token:"something", expires: new Date().next())

      expect:
        setup.userLogged() == true
    }

    def "test parsing date"() {
      setup: def dateString = "2017-04-09T21:34:56+0000"
      when: def date = Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", dateString)
      then:  date != null
    }
}
