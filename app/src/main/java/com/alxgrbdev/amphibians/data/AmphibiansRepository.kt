package com.alxgrbdev.amphibians.data

import com.alxgrbdev.amphibians.model.Amphibian
import com.alxgrbdev.amphibians.network.AmphibiansApiService

interface AmphibiansRepository {
    suspend fun getAmphibians(): List<Amphibian>
}

class NetworkAmphibiansRepository(
    private val amphibiansApiService: AmphibiansApiService
) : AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return amphibiansApiService.getAmphibians()
    }
}