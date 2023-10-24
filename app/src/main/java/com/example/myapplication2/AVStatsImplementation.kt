package com.example.myapplication2

import android.util.Log
import com.example.echo_api.AVStatisticsProvider

class AVStatsImplementation : AVStatisticsProvider {
    override fun trackPlayInitiated() {
        Log.i("ECHO-TEST", "AVStats Playing")
    }
}