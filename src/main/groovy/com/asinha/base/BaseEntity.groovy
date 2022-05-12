package com.asinha.base

abstract class BaseEntity{

    Boolean deleted = false

    Date dateCreated = new Date()

    Date lastUpdate = dateCreated

    Date dateDeleted

    static mapping = {
        tablePerHierarchy false
    }

    static constraints = {
        deleted nullable: false
        dateCreated nullable: false
        lastUpdate nullable: false
        dateDeleted nullable: true
    }
}
