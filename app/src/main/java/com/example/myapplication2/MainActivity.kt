package com.example.myapplication2

import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.echo_api.EchoTesting
import com.example.echo_stats_old.EchoTestingOldInterface

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // build before the new method existed ( Old Interface )
        val avStatisticsProvider = EchoTestingOldInterface()
        val echoTest = EchoTesting(avStatisticsProvider)
        echoTest.play()

        // build using the new method ( New Method Interface )
        val customAvStatisticsProvider = ClientCustomAVStatsImplementation()
        val echoTestCustom = EchoTesting(customAvStatisticsProvider)
        echoTestCustom.play()
    }
}