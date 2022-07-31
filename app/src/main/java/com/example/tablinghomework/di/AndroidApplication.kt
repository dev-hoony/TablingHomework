package com.example.tablinghomework.di

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidApplication : Application() {

    companion object{
        const val ARG_OBJECT = "object"

    }


}