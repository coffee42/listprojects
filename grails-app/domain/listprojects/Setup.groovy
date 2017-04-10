package listprojects

class Setup {

  String userName
  String password
  String token
  Date   expires


    static constraints = {
      userName blank: false, maxsize:50
      password blank: false, maxsize:50
      token    nullable: true
      expires  nullable: true
    }

  boolean userLogged() {
    return token != null && expires!= null && !loginExpired()
  }

  boolean loginExpired() {
    Date now = new Date()
    return now > expires
  }
}
