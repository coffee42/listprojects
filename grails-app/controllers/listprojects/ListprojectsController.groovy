package listprojects

class ListprojectsController {
  ListprojectsService listprojectsService
  LoginService loginService

    def index() {
      if (loginService.userIsLoggedIn()) {
        log.info("User is looged in")
        render view: "index"
      }
      else {
        log.info("User not saved or authenticated, redirecting to setup")
        chain (controller: "setup")
      }
    }

    def ajaxList() {
      log.info("Ajax called")
      if (loginService.userIsLoggedIn()) {
        log.info("User is looged in")
        def resp = listprojectsService.listprojects();
        render contentType:"application/json", text:resp
      }
    }
}
