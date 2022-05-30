package com.asinha.base

abstract class BaseEntity {

    Boolean deleted = false

    Date dateCreated

    Date lastUpdated

    Date dateDeleted

    static mapping = {
        tablePerHierarchy false
    }

    static constraints = {
        deleted nullable: false
        dateDeleted nullable: true
    }
}
