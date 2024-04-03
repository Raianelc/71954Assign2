package com.stu71954.a71954assign2.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.stu71954.a71954assign2.MainScreen
import com.stu71954.a71954assign2.MovieScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.MainScreen,
    ) {
        composable(route = Routes.MainScreen)
        {
            MainScreen(navController = navController)
        }
        composable(route = Routes.MovieScreen) { backStackEntry ->
            val movieName = backStackEntry.arguments?.getString("movieName")
            MovieScreen(movieName = movieName, navController = navController)
        }
    }
}

