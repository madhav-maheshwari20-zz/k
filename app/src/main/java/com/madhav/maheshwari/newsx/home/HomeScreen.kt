package com.madhav.maheshwari.newsx.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    navigateToCategoryNews: (String) -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFE2A8A8))
    ) {
        Text(text = "home")
        TextButton(onClick = { navigateToCategoryNews("sports") }) {
            Text(text = "Navigate")
        }
    }
}
