package com.asinha.domain

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='authority')
@ToString(includes='authority', includeNames=true, includePackage=false)
class Role implements Serializable {

	private static final Long serialVersionUID = 1

	String authority

	static constraints = {
		authority nullable: false, blank: false, unique: true
	}

	static mapping = {
		cache true
	}
	
	String toString() {
  		authority
	}

	public Boolean isAdmin() {
	return this.authority == 'ROLE_ADMIN'
	}
}
