package com.madhav.maheshwari.newsx.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.madhav.maheshwari.newsx.R

sealed class BottomNavItem(
    val route: String,
    @StringRes val titleResId: Int,
    @DrawableRes val icon: Int
) {
    object Home : BottomNavItem(
        route = Screen.Home.route,
        titleResId = R.string.title_home,
        icon = R.drawable.ic_home
    )
    object LatestNews : BottomNavItem(
        route = Screen.LatestNews.route,
        titleResId = R.string.title_latest_news,
        icon = R.drawable.ic_latest_news
    )
    object BookMark : BottomNavItem(
        route = Screen.BookMark.route,
        titleResId = R.string.title_bookmark,
        icon = R.drawable.ic_bookmark
    )
    object Settings : BottomNavItem(
        route = Screen.Settings.route,
        titleResId = R.string.title_bookmark,
        icon = R.drawable.ic_settings
    )
}

@Composable
fun BottomNavigationBar(
    navController: NavController
) {
    val items = listOf(
        BottomNavItem.Home,
        BottomNavItem.LatestNews,
        BottomNavItem.BookMark,
        BottomNavItem.Settings
    )

    BottomNavigation {
        val navBackStack by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStack?.destination?.route
        items.forEach { items ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        painter = painterResource(id = items.icon),
                        contentDescription = stringResource(id = items.titleResId)
                    )
                },
                label = {
                    Text(
                        text = stringResource(id = items.titleResId)
                    )
                },
                selected = currentRoute == items.route,
                onClick = {
                    navController.navigate(items.route) {
                        /**
                         * Pop up to the start destination of the graph to
                         * avoid building up a large stack of destinations
                         * on the back stack as users select items
                         **/
                        navController.graph.startDestinationRoute?.let {
                            popUpTo(it) {
                                saveState = true
                            }
                        }

                        // Avoid multiple copies of the same destination when re-selecting the same item
                        launchSingleTop = true
                        // Restore state when re-selecting a previously selected item
                        restoreState = true
                    }
                }
            )
        }
    }
}
