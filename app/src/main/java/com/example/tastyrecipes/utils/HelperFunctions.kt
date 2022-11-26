package com.example.tastyrecipes.utils

fun getStarRating(score: Double): Int {
    val scoreAsInt = score.convertDoubleToNumber()
    return when {
        scoreAsInt >= 90 -> 5
        scoreAsInt >= 80 -> 4
        scoreAsInt >= 70 -> 3
        scoreAsInt >= 60 -> 2
        else -> 1
    }
}
