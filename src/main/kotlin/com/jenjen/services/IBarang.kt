package com.jenjen.services

import com.jenjen.model.request.NewBarang
import com.jenjen.model.response.DefaultResponse

interface IBarang {
    suspend fun insertBarang(newBarang : NewBarang): DefaultResponse
}