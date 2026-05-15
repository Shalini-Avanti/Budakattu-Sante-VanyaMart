package com.budakattusante

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Application class — entry point for Hilt dependency injection.
 * Must be declared in AndroidManifest.xml via android:name=".BudakattsuSanteApp"
 */
@HiltAndroidApp
class BudakattsuSanteApp : Application()
