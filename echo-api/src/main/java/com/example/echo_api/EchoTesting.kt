package com.example.echo_api

import android.util.Log

class EchoTesting(avStatisticsProvider: AVStatisticsProvider)  {

    val avStatisticsProvider: AVStatisticsProvider = avStatisticsProvider

    fun play() {
        avStatisticsProvider.trackPlayInitiated()
        Log.i("ECHO TEST", "Is Playing")
        avStatisticsProvider.trackEnd()
    }

}


