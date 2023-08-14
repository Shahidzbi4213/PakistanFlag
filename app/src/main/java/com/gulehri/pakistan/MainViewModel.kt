package com.gulehri.pakistan

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

/*
 * Created by Shahid Iqbal on 8/14/2023.
 */

class MainViewModel:ViewModel() {

    var theme by mutableStateOf(false)
        private set

    fun updateTheme() {
        theme = !theme
    }

}