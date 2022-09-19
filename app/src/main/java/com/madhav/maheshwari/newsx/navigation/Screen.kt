package com.madhav.maheshwari.newsx.navigation

const val categoryKey = "category"

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object LatestNews : Screen("latest_news/{$categoryKey}") {
        fun createCategoryUri(uri: String) = "latest_news/$uri"
    }
    object BookMark : Screen("bookmark")
    object Settings : Screen("settings")
}
