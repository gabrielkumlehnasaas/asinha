package com.asinha.domain

import grails.compiler.GrailsCompileStatic
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@GrailsCompileStatic
@EqualsAndHashCode(includes='username')
@ToString(includes='username', includeNames=true, includePackage=false)
class User implements Serializable {

    private static final Long serialVersionUID = 1

    String username

    String password

    Boolean enabled = true

    Boolean accountExpired

    Boolean accountLocked

    Boolean passwordExpired
    
    Customer customer
    
    Set<Role> getAuthorities() {
        (UserRole.findAllByUser(this) as List<UserRole>)*.role as Set<Role>
    }

    static constraints = {
        password nullable: false, blank: false, password: true
        username nullable: false, blank: false, unique: true
        customer nullable: false
    }

    static mapping = {
	    password column: '`password`'
    }
    
    public Boolean isAdmin() {
        return this.getAuthorities().any { it.isAdmin() }
    }
}
