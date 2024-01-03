package com.alxgrbdev.amphibians

import com.alxgrbdev.amphibians.fake.FakeDataSource
import com.alxgrbdev.amphibians.fake.FakeNetworkAmphibiansRepository
import com.alxgrbdev.amphibians.rules.TestDispatcherRule
import com.alxgrbdev.amphibians.ui.viewmodel.AmphibiansUiState
import com.alxgrbdev.amphibians.ui.viewmodel.AmphibiansViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AmphibiansViewModelTest {
    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibiansViewModel_getAmphibians_verifyUiStateSuccess() =
        runTest {
            val amphibiansViewModel = AmphibiansViewModel(
                amphibiansRepository = FakeNetworkAmphibiansRepository()
            )
            assertEquals(
                AmphibiansUiState.Success(FakeDataSource.amphibiansList),
                amphibiansViewModel.amphibiansUiState
            )
        }
}