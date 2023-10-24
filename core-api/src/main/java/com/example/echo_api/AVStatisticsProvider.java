package com.example.echo_api;

import android.util.Log;

public interface AVStatisticsProvider {

    default void trackPlayInitiated() {
        Log.i("ECHO NEW INTERFACE", "Default Player Initiated");
    }

    default void trackEnd() {
        Log.i("ECHO NEW INTERFACE", "Default Player Ended");
    }

    default void newMethod() {
        Log.i("ECHO NEW INTERFACE", "Default New Method called");
    }
}
