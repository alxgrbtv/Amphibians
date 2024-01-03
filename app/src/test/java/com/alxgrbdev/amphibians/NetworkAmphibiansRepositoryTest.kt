package com.alxgrbdev.amphibians

import com.alxgrbdev.amphibians.data.NetworkAmphibiansRepository
import com.alxgrbdev.amphibians.fake.FakeAmphibiansApiService
import com.alxgrbdev.amphibians.fake.FakeDataSource
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class NetworkAmphibiansRepositoryTest {
    @Test
    fun networkAmphibiansRepository_getAmphibians_verifyAmphibiansList() =
        runTest {
            val repository = NetworkAmphibiansRepository(
                amphibiansApiService = FakeAmphibiansApiService()
            )
            assertEquals(FakeDataSource.amphibiansList, repository.getAmphibians())
        }
}