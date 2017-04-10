package listprojects

import grails.transaction.Transactional

@Transactional
class SetupService {

    Setup findExisting() {
      def existing = Setup.get(1)      
      return existing
    }

    def save(Setup setup) {
      log.info "Savin setup ${setup}"
      Setup existing = findExisting();
      def result
      if (existing != null) {
        existing.userName = setup.userName;
        existing.password = setup.password;
        result = existing.save(failOnError: true, flush:true)
      }
      else {
        setup.id=1
        result = setup.save(failOnError: true, flush:true)
      }
    }

    def persistLoginData(Map loginData) {
      log.info("persisting Login Data")
      Setup setup = findExisting()
      setup.token = loginData['token']
      Date date = Date.parse("yyyy-MM-dd'T'HH:mm:ssZ", loginData['expires'])
      setup.expires = date
      setup.save(flush:true);
    }

}
