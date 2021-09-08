package com.nadir.travelapp

import android.app.Application
import dagger.android.DaggerApplication

class TravelApplication: Application() {

    val appComponent = DaggerApplicationGraph.create()
}