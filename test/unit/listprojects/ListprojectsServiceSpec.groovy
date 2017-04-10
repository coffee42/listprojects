package listprojects

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.*


/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ListprojectsService)
class ListprojectsServiceSpec extends Specification {

      def mockedResponse = '[{"dateDue":null,"workflowSteps":[],"owner":{"firstName":"Ondřej","lastName":"Tecl","role":"ADMIN","deleted":false,"dateCreated":"2017-03-27T17:50:21+0000","terminologist":false,"timezone":"Europe/Prague","active":true,"id":193321,"userName":"ondrejtecl","email":"ondrejtecl@seznam.cz"},"note":"","shared":false,"businessUnit":null,"subDomain":null,"analyseSettings":{"includeConfirmedSegments":true,"includeTransMemory":true,"includeNumbers":true,"includeFuzzyRepetitions":true,"includeLockedSegments":true,"countSourceUnits":true,"type":"PreAnalyse","compareWorkflowLevel":null},"qualityAssuranceSettings":{"regexp":null,"segmentNotConfirmed":true,"inconsistentTranslation":true,"targetLengthPercent":{"max":130.0,"enabled":false},"excludeLockedSegments":false,"ignoreInAllWorkflowSteps":false,"extraNumbers":false,"forbiddenTerms":false,"joinTags":true,"spellCheck":true,"targetSourceIdentical":false,"missingNumbers":true,"terminology":true,"emptyTagContent":true,"targetLength":{"max":1000,"enabled":false},"targetLengthPerSegment":true,"newerAtPrecedingWorkflowStep":true,"multipleSpaces":true,"unresolvedComment":true,"leadingAndTrailingSpaces":true,"trailingPunctuation":false,"forbiddenStrings":{"list":[],"enabled":false},"repeatedWords":true,"emptyTranslation":true,"ignoreNotApprovedTerms":false,"inconsistentTagContent":true,"trailingSpace":true,"emptyPairTags":true,"strictJobStatus":false,"xliffTags":true,"formatting":true,"unmodifiedFuzzyTranslation":false},"uid":"W5gaRUrbCk8279jUSQY2H2","internalId":2,"dateCreated":"2017-04-09T12:51:54+0000","createdBy":{"firstName":"Ondřej","lastName":"Tecl","role":"ADMIN","deleted":false,"dateCreated":"2017-03-27T17:50:21+0000","terminologist":false,"timezone":"Europe/Prague","active":true,"id":193321,"userName":"ondrejtecl","email":"ondrejtecl@seznam.cz"},"sourceLang":"cs","domain":null,"name":"testproject2","client":null,"machineTranslateSettings":{"args":{"category":null},"default":true,"name":"Microsoft with Feedback","id":49453,"type":"MicrosoftTranslatorWithFeedback"},"id":10057734,"langSettings":[],"accessSettings":{"emailNotifications":true,"strictWorkflowFinish":false,"webEditorEnabledForLinguists":true,"showUserDataToLinguists":true,"downloadEnabled":true,"useVendors":true},"status":"NEW","targetLangs":["en","sk"]},{"dateDue":"2017-04-12T22:00:00+0000","workflowSteps":[],"owner":{"firstName":"Ondřej","lastName":"Tecl","role":"ADMIN","deleted":false,"dateCreated":"2017-03-27T17:50:21+0000","terminologist":false,"timezone":"Europe/Prague","active":true,"id":193321,"userName":"ondrejtecl","email":"ondrejtecl@seznam.cz"},"note":"nejaka poznamka","shared":false,"businessUnit":null,"subDomain":null,"analyseSettings":{"includeConfirmedSegments":true,"includeTransMemory":true,"includeNumbers":true,"includeFuzzyRepetitions":true,"includeLockedSegments":true,"countSourceUnits":true,"type":"PreAnalyse","compareWorkflowLevel":null},"qualityAssuranceSettings":{"regexp":null,"segmentNotConfirmed":true,"inconsistentTranslation":true,"targetLengthPercent":{"max":130.0,"enabled":false},"excludeLockedSegments":false,"ignoreInAllWorkflowSteps":false,"extraNumbers":false,"forbiddenTerms":false,"joinTags":true,"spellCheck":true,"targetSourceIdentical":false,"missingNumbers":true,"terminology":true,"emptyTagContent":true,"targetLength":{"max":1000,"enabled":false},"targetLengthPerSegment":true,"newerAtPrecedingWorkflowStep":true,"multipleSpaces":true,"unresolvedComment":true,"leadingAndTrailingSpaces":true,"trailingPunctuation":false,"forbiddenStrings":{"list":[],"enabled":false},"repeatedWords":true,"emptyTranslation":true,"ignoreNotApprovedTerms":false,"inconsistentTagContent":true,"trailingSpace":true,"emptyPairTags":true,"strictJobStatus":false,"xliffTags":true,"formatting":true,"unmodifiedFuzzyTranslation":false},"uid":"AUxAXcG68wafflOpCe4V72","internalId":1,"dateCreated":"2017-03-31T22:28:17+0000","createdBy":{"firstName":"Ondřej","lastName":"Tecl","role":"ADMIN","deleted":false,"dateCreated":"2017-03-27T17:50:21+0000","terminologist":false,"timezone":"Europe/Prague","active":true,"id":193321,"userName":"ondrejtecl","email":"ondrejtecl@seznam.cz"},"sourceLang":"en","domain":null,"name":"testproject","client":null,"machineTranslateSettings":null,"id":10027741,"langSettings":[],"accessSettings":{"emailNotifications":true,"strictWorkflowFinish":false,"webEditorEnabledForLinguists":true,"showUserDataToLinguists":true,"downloadEnabled":true,"useVendors":true},"status":"NEW","targetLangs":["cs_cz"]}]'


    def cleanup() {
    }

    void "test something"() {
      def props = ["id", "name", "status", "sourceLang", "targetLangs"]
      when: def json = JSON.parse(mockedResponse)
            def objectList = []
            json.each { object ->
            def map = [:]
              props.each() { key ->

                if (key == "targetLangs") {
                  map[key]= object[key].toArray().join(", ")
                }
                else {
                  map[key]=object[key]
                }
              }
              objectList << map
            }
      then: objectList.size == 2
    }

}
