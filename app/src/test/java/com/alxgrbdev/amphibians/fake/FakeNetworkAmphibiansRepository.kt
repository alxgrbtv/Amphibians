package com.alxgrbdev.amphibians.fake

import com.alxgrbdev.amphibians.data.AmphibiansRepository
import com.alxgrbdev.amphibians.model.Amphibian

class FakeNetworkAmphibiansRepository : AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return FakeDataSource.amphibiansList
    }
}
