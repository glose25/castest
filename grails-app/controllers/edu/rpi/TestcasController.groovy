package edu.rpi

////import org.springframework.security.annotation.Secured
import grails.plugins.springsecurity.Secured

class TestcasController {
    def springSecurityService


    def index = { 
       //render 'You made it to index okay'
       def authentication = springSecurityService.authentication
       def principal = authentication?.principal
       render "Testcas:: CAS has verified you as " + principal
    }

    @Secured(['IS_AUTHENTICATED_FULLY'])    
    def secured = { 
       def authentication = springSecurityService.authentication
       def principal = authentication?.principal
       render "SECURED:: CAS has verified you as " + principal //.username
    }
    
    @Secured(['ROLE_BAN_DEFAULT_M','IS_AUTHENTICATED_FULLY'])
    def adminOnly = { 
       def authentication = springSecurityService.authentication
       def principal = authentication?.principal
       render "ADMINONLY:: CAS has verified you as " + principal //.username
    }

    @Secured(['BAN_DEFAULT_M','IS_AUTHENTICATED_FULLY'])    
    def roletester = { 
       def authentication = springSecurityService.authentication
       def principal = authentication?.principal
//       if (hasRole(["BAN_DEFAULT_M"])) {
            render "bandefaultm:: CAS has verified you as " + principal //.username
 //      } else {
 //           render "sorry - you don't have bandefaultm:: CAS has verified you as " + principal.username
   //    }
    }
    
}
