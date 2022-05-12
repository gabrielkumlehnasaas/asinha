package com.asinha.base

abstract class BaseController{

    static mapping = {
        tablePerHierarchy false
    }

    private Integer getLimitPerPage() {
        return 10
    }

    private Integer getCurrentPage() {
        if(!params.offset) params.offset = 0
        return Integer.valueOf(params.offset)
    }
}