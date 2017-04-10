package listprojects

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SetupService)
class SetupServiceSpec extends Specification {

    void "test findExisting"() {

      setup:
        Setup toFind = new Setup(userName:"something", password: "topSecret")
        Setup _internal = new Setup(userName:"something", password: "topSecret")
        GroovyMock(Setup, global: true)
        Setup.get(_) >> _internal

     when:
        Setup found = service.findExisting()

     then:        
        found.password == toFind.password
        found.userName == toFind.userName


    }
}
