package com.example.echo_stats_old

import android.util.Log
import com.example.echo_api.AVStatisticsProvider

class EchoTestingOldInterface: AVStatisticsProvider {

    override fun trackPlayInitiated() {
        Log.i("ECHO OLD INTERFACE", "Player Initiated")
    }

    override fun trackEnd() {
        Log.i("ECHO OLD INTERFACE", "Player Ended")
    }
}