package com.example.echo_api;

import android.util.Log;

public interface AVStatisticsProvider {

    default void trackPlayInitiated() {
        Log.i("ECHO TEST", "Default Player Initiated");
    }

    default void trackEnd() {
        Log.i("ECHO TEST", "Default Player Ended");
    }
}
