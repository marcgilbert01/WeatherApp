package com.nowtv.domain.common

interface UseCase<out Type, in Params> where Type : Any {
    fun buildUseCase(params: Params): Type
}