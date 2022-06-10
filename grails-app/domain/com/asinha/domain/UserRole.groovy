package com.asinha.domain

import grails.compiler.GrailsCompileStatic
import grails.gorm.DetachedCriteria
import groovy.transform.ToString
import org.codehaus.groovy.util.HashCodeHelper

@GrailsCompileStatic
@ToString(cache=true, includeNames=true, includePackage=false)
class UserRole implements Serializable {

	private static final long serialVersionUID = 1

	User user

	Role role

	@Override
	Boolean equals(other) {
		if (other instanceof UserRole) {
			other.userId == user?.id && other.roleId == role?.id
		}
	}

    @Override
	Integer hashCode() {
	    Integer hashCode = HashCodeHelper.initHash()
        if (user) {
            hashCode = HashCodeHelper.updateHash(hashCode, user.id)
		}
		if (role) {
		    hashCode = HashCodeHelper.updateHash(hashCode, role.id)
		}
		hashCode
	}

	static UserRole get(long userId, long roleId) {
		criteriaFor(userId, roleId).get()
	}

	static Boolean exists(long userId, long roleId) {
		criteriaFor(userId, roleId).count()
	}

	private static DetachedCriteria criteriaFor(long userId, long roleId) {
		UserRole.where {
			user == User.load(userId) &&
			role == Role.load(roleId)
		}
	}

	static UserRole create(User user, Role role, Boolean flush = false) {
		def instance = new UserRole(user: user, role: role)
		instance.save(flush: flush)
		instance
	}

	static Boolean remove(User u, Role r) {
		if (u != null && r != null) {
			UserRole.where { user == u && role == r }.deleteAll()
		}
	}

	static Integer removeAll(User u) {
		u == null ? 0 : UserRole.where { user == u }.deleteAll() as Integer
	}

	static Integer removeAll(Role r) {
		r == null ? 0 : UserRole.where { role == r }.deleteAll() as Integer
	}

	static constraIntegers = {
		role validator: { Role r, UserRole ur ->
			if (ur.user?.id) {
				if (UserRole.exists(ur.user.id, r.id)) return ['userRole.exists']
			}
		}
	}

	static mapping = {
		id composite: ['user', 'role']
		version false
	}
}
