import edu.rpi.*

class BootStrap {

    def init = { 
    
    //servletContext ->

        // println "Creating base Roles and Users configuration" 
        
        // def adminRole = MyRole.findByAuthority('BAN_DEFAULT_M') ?: new MyRole(authority: 'BAN_DEFAULT_M').save(flush: true, failOnError: true)
        // def bannerRole = MyRole.findByAuthority('ROLE_BAN_DEFAULT_M') ?: new MyRole(authority: 'ROLE_BAN_DEFAULT_M').save(flush: true, failOnError: true)
        
        // def testUser = MyUser.findByUsername('glosej') ?: new MyUser(username: 'glosej', password: 'password', enabled: true).save(flush: true, failOnError: true) 
        
//        if (!testUser.authorities.contains('ROLE_ADMIN')) {
            // MyUserMyRole.create testUser, adminRole
            // MyUserMyRole.create testUser, bannerRole
//        }
    
    }
    def destroy = {
    }
}
