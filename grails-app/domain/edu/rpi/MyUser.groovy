package edu.rpi

class MyUser {

	transient springSecurityService

	String id
    String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

	static constraints = {
		username blank: false, unique: true
		password blank: false
	}

	static mapping = {
//		password column: '`password`'
		version false
		lazy: true
//        id column: 'username'
	}

	Set<MyRole> getAuthorities() {
		MyUserMyRole.findAllByMyUser(this).collect { it.myRole } as Set
	}

	def beforeInsert() {
		encodePassword()
	}

	def beforeUpdate() {
		if (isDirty('password')) {
			encodePassword()
		}
	}

	protected void encodePassword() {
		password = springSecurityService.encodePassword(password)
	}
}
