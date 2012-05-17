package edu.rpi

class MyRole {

	String authority
    String id

	static mapping = {
		cache true
        version false
	}

	static constraints = {
		authority blank: false, unique: true
	}
}
