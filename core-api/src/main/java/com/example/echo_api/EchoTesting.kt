package com.example.echo_api

import android.util.Log

class EchoTesting(avStatisticsProvider: AVStatisticsProvider)  {

    val avStatisticsProvider: AVStatisticsProvider = avStatisticsProvider

    fun play() {
        Log.i("ECHO CORE API", "Is Playing")
        avStatisticsProvider.trackPlayInitiated()
        avStatisticsProvider.trackEnd()
        avStatisticsProvider.newMethod()
    }

}


