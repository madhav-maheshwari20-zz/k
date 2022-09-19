package com.madhav.maheshwari.newsx.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.Lifecycle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.madhav.maheshwari.newsx.bookmark.BookMarkScreen
import com.madhav.maheshwari.newsx.home.HomeScreen
import com.madhav.maheshwari.newsx.latestnews.LatestNewsScreen
import com.madhav.maheshwari.newsx.settings.SettingsScreen

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomNavItem.Home.route) {
        composable(BottomNavItem.Home.route) { backStackEntry ->
            HomeScreen(
                navigateToCategoryNews = {
                    if (backStackEntry.lifecycleIsResumed()) {
                        navController.navigate(Screen.LatestNews.createCategoryUri(it))
                    }
                }
            )
        }
        composable(BottomNavItem.LatestNews.route) {
            val category = it.arguments?.getString(categoryKey).toString()
            LatestNewsScreen(
                category = category
            )
        }
        composable(BottomNavItem.BookMark.route) {
            BookMarkScreen()
        }
        composable(BottomNavItem.Settings.route) {
            SettingsScreen()
        }
    }
}

/**
 * If the lifecycle is not resumed it means this NavBackStackEntry already processed a nav event.
 * This is used to de-duplicate navigation events.
 */
private fun NavBackStackEntry.lifecycleIsResumed() =
    this.lifecycle.currentState == Lifecycle.State.RESUMED
