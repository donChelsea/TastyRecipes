package com.example.tastyrecipes.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tastyrecipes.R
import com.example.tastyrecipes.ui.detail.RecipeDetailScreen
import com.example.tastyrecipes.ui.home.HomeScreen
import com.example.tastyrecipes.ui.navigation.NAV_ARG_RECIPE_DETAIL
import com.example.tastyrecipes.ui.navigation.NavigationItem
import com.example.tastyrecipes.ui.search.SearchScreen
import com.example.tastyrecipes.ui.theme.TastyRecipesTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalComposeUiApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TastyRecipesTheme {
                MainScreen()
            }
        }
    }
}

@ExperimentalComposeUiApi
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar(navController) },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = colorResource(R.color.white)
    )
}

@ExperimentalComposeUiApi
@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Home.route) {
        composable(NavigationItem.Home.route) {
            HomeScreen(navController)
        }
        composable(
            route = "${NavigationItem.RecipeDetail.route}/{id}",
            arguments = listOf(navArgument(NAV_ARG_RECIPE_DETAIL) { type = NavType.IntType })
        ) { backStackEntry ->
            RecipeDetailScreen(navController, backStackEntry.arguments?.getInt(NAV_ARG_RECIPE_DETAIL) ?: 0)
        }
        composable(NavigationItem.Search.route) {
            SearchScreen(navController)
        }
    }
}

@Composable
fun TopBar(navController: NavController) {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name_formatted), fontSize = 18.sp) },
        backgroundColor = colorResource(id = R.color.purple_700),
        contentColor = Color.White,
        navigationIcon = {
            IconButton(onClick = {
                navController.navigateUp()
            }) {
                Icon(Icons.Rounded.ArrowBack, "")
            }
        },
    )
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Search,
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.purple_700),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = true,
                selected = false,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}