package com.nowtv.domain.common

abstract class BaseMapperToDomain<SOURCE, TARGET> {

    abstract fun mapToDomain(toBeTransformed: SOURCE): TARGET

    open fun mapToDomain(list: List<SOURCE>): List<TARGET> {
        return list.map { mapToDomain(it) }
    }

    var argument: Any? = null
}
