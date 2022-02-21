package com.example.imagegallery.util

import android.app.Activity
import android.widget.Toast

    fun Activity.showToast(toastText : String?){
        Toast.makeText(applicationContext, toastText, Toast.LENGTH_SHORT).show()
    }
