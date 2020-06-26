package com.nowtv.domain.common

abstract class BaseMapperToData<SOURCE, TARGET> {

    abstract fun mapToData(toBeTransformed: SOURCE): TARGET

    fun mapToData(list: List<SOURCE>): List<TARGET> {
        return list.map { mapToData(it) }
    }
}