package com.nowtv.domain.common

interface UseCaseVoid<out Type> where Type : Any {
    fun buildUseCase(): Type
}