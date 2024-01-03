package com.alxgrbdev.amphibians.fake

import com.alxgrbdev.amphibians.model.Amphibian
import com.alxgrbdev.amphibians.network.AmphibiansApiService

class FakeAmphibiansApiService : AmphibiansApiService {
    override suspend fun getAmphibians(): List<Amphibian> {
        return FakeDataSource.amphibiansList
    }
}