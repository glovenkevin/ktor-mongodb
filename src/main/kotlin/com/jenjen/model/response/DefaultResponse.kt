package com.jenjen.model.response

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class DefaultResponse(
    val code: Int,
    val status: String,
    var data: Any? = null
)
