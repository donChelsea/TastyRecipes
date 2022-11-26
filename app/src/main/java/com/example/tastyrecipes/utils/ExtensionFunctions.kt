package com.example.tastyrecipes.utils

import kotlin.math.roundToInt

fun Double.convertDoubleToNumber() = this.times(100).roundToInt()