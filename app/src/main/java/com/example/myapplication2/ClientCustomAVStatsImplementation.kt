package com.example.myapplication2

import android.util.Log
import com.example.echo_api.AVStatisticsProvider

// Client Custom Implementation Using New API
class ClientCustomAVStatsImplementation : AVStatisticsProvider {

    override fun trackPlayInitiated() {
        Log.i("ECHO-CUSTOM-NEW", "Custom Client AVStats: Playing")
    }

    override fun trackEnd() {
        Log.i("ECHO-CUSTOM-NEW", "Custom Client AVStats: Ended")
    }

    override fun newMethod() {
        Log.i("ECHO-CUSTOM-NEW", "Custom Client AVStats: New Method Called")
    }
}