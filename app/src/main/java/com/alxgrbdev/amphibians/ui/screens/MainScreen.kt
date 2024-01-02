package com.alxgrbdev.amphibians.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
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
fun AmphibiansScreen(amphibians: List<Amphibian>, modifier: Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(4.dp),
        modifier = modifier.fillMaxWidth()
    ) {
        items(
            items = amphibians,
            key = { amphibian -> amphibian.name }
        ) {
            amphibian -> AmphibianCard(
                amphibian = amphibian,
                modifier = modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
fun AmphibianCard(amphibian: Amphibian, modifier: Modifier) {
    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        Text(
            text = "${amphibian.name} (${amphibian.type})",
            fontWeight = FontWeight.Black,
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 8.dp)
        )
        AsyncImage(
            model = ImageRequest.Builder(context = LocalContext.current)
                .data(amphibian.imgSrc)
                .crossfade(true)
                .build(),
            contentDescription = "Amphibian Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )
        Text(
            text = amphibian.description,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(vertical = 16.dp, horizontal = 8.dp)
        )
    }
}

@Composable
fun LoadingScreen(modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Loading...")
    }
}

@Composable
fun ErrorScreen(retryAction: () -> Unit, modifier: Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Error!", modifier = Modifier.padding(16.dp))
        Button(onClick = retryAction) {
            Text(text = "Retry")
        }
    }
}
