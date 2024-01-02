package com.alxgrbdev.amphibians.ui.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.alxgrbdev.amphibians.model.Amphibian
import com.alxgrbdev.amphibians.ui.viewmodel.AmphibiansUiState

@Composable
fun MainScreen(
    amphibiansUiState: AmphibiansUiState,
    retryAction: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (amphibiansUiState) {
        is AmphibiansUiState.Loading -> LoadingScreen(modifier = modifier)
        is AmphibiansUiState.Success -> AmphibiansScreen(amphibians = amphibiansUiState.amphibians, modifier = modifier)
        else -> ErrorScreen(retryAction, modifier = modifier)
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier) {
    Text(text = "Error")
}

@Composable
fun AmphibiansScreen(amphibians: List<Amphibian>, modifier: Modifier) {
    Text(text = "Amphibians")
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Text(text = "Loading")
}
