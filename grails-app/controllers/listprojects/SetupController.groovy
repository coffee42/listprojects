package listprojects

import listprojects.SetupService

class SetupController {
  SetupService setupService
  LoginService loginService

    def index() {
      def setup = setupService.findExisting()
      render view: "index",  model: [setup: setup]
    }

    def save() {
      log.info "Action save: ${params}"
      Setup setup = new Setup(params)
      log.info "Setup: ${setup}"
      setupService.save(setup)

      log.info "Setup: ${setup.id}"

      loginService.login();

      log.info "Setup: ${setup}"
      chain action: 'index'
    }
}
