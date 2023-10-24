package com.example.myapplication2

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.echo_api.EchoTesting
import com.example.myapplication2.ui.theme.MyApplication2Theme
import uk.co.bbc.echo.BuildConfig
import uk.co.bbc.echo.EchoClient
import uk.co.bbc.echo.EchoConfigKeys
import uk.co.bbc.echo.Media
import uk.co.bbc.echo.enumerations.ApplicationType
import uk.co.bbc.echo.enumerations.MediaAvType
import uk.co.bbc.echo.enumerations.MediaConsumptionMode
import uk.co.bbc.smpan.echostats.EchoAVStatisticsProvider
import uk.co.bbc.smpan.playercontroller.media.MediaEndTime
import uk.co.bbc.smpan.playercontroller.media.MediaPosition
import uk.co.bbc.smpan.playercontroller.media.MediaProgress
import uk.co.bbc.smpan.playercontroller.media.MediaStartTime
import uk.co.bbc.smpan.stats.av.AVStatisticsProvider

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val echoClient = initEchoClient(this)
        val media = Media(MediaAvType.VIDEO, MediaConsumptionMode.ON_DEMAND)

        val echo = EchoAVStatisticsProvider(echoClient, media)
        val mediaProgress = MediaProgress(
            MediaStartTime(111L),
            MediaPosition.UNKNOWN,
            MediaEndTime.fromMilliseconds(88888L),
            false
        )

        val avStatisticsProvider = AVStatsImplementation()
        val echoTest = EchoTesting(avStatisticsProvider)
        echoTest.play()

      //  echo.testAVI(mediaProgress, "12234")


        setContent {
            MyApplication2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }

    fun initEchoClient(context: Context): EchoClient {
        val config: HashMap<String, String> = object : HashMap<String, String>() {
            init {
                put("app_version", BuildConfig.LIBRARY_PACKAGE_NAME)
                put(EchoConfigKeys.ATI_ENABLED, "true")
                put(EchoConfigKeys.COMSCORE_ENABLED, "false")
                put(EchoConfigKeys.USE_ESS, "true")
            }
        }
        val echoClient = EchoClient("smpAndroidTestApp", ApplicationType.MOBILE_APP, "smpAndroidTest.app", context, config, null)
        echoClient.setCounterName("AvTestharnessSmpCounterName")
        return echoClient
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyApplication2Theme {
        Greeting("Android")
    }
}