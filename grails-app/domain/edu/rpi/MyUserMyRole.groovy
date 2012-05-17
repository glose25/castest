package edu.rpi

import org.apache.commons.lang.builder.HashCodeBuilder

class MyUserMyRole implements Serializable {

	MyUser myUser
	MyRole myRole

	boolean equals(other) {
		if (!(other instanceof MyUserMyRole)) {
			return false
		}

		other.myUser?.id == myUser?.id &&
			other.myRole?.id == myRole?.id
	}

	int hashCode() {
		def builder = new HashCodeBuilder()
		if (myUser) builder.append(myUser.id)
		if (myRole) builder.append(myRole.id)
		builder.toHashCode()
	}

	static MyUserMyRole get(long myUserId, long myRoleId) {
		find 'from MyUserMyRole where myUser.id=:myUserId and myRole.id=:myRoleId',
			[myUserId: myUserId, myRoleId: myRoleId]
	}

	static MyUserMyRole create(MyUser myUser, MyRole myRole, boolean flush = false) {
		new MyUserMyRole(myUser: myUser, myRole: myRole).save(flush: flush, insert: true)
	}

	static boolean remove(MyUser myUser, MyRole myRole, boolean flush = false) {
		MyUserMyRole instance = MyUserMyRole.findByMyUserAndMyRole(myUser, myRole)
		if (!instance) {
			return false
		}

		instance.delete(flush: flush)
		true
	}

	static void removeAll(MyUser myUser) {
		executeUpdate 'DELETE FROM MyUserMyRole WHERE myUser=:myUser', [myUser: myUser]
	}

	static void removeAll(MyRole myRole) {
		executeUpdate 'DELETE FROM MyUserMyRole WHERE myRole=:myRole', [myRole: myRole]
	}

	static mapping = {
		id composite: ['myRole', 'myUser']
		version false
	}
}
