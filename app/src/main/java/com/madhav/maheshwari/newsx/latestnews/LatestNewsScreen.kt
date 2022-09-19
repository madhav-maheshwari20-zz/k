package com.madhav.maheshwari.newsx.latestnews

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LatestNewsScreen(
    category: String? = null,
    latestNewsViewModel: LatestNewsViewModel = viewModel()
) {
    Text(text = "latestnews")
}
