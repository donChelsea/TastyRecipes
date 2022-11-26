package com.example.tastyrecipes.ui.navigation

import com.example.tastyrecipes.R

const val NAV_ARG_RECIPE_DETAIL = "id"

sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Home : NavigationItem("home", R.drawable.ic_home, "Home")
    object RecipeDetail : NavigationItem("recipe", R.drawable.ic_home, "Recipe Detail")
    object Search : NavigationItem("search", R.drawable.ic_search, "Search")
}