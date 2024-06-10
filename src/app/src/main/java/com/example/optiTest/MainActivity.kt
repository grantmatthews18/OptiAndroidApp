package com.example.optiTest

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.optiTest.ui.theme.OptimizelySDKTestAppTheme
import com.optimizely.ab.android.sdk.OptimizelyManager
import com.optimizely.ab.optimizelydecision.OptimizelyDecision
import java.util.concurrent.TimeUnit


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Specify SDK of env
        val sdkKey: String = "SDK_Key_Here"

        //Flag Key
        val flagKey = "Flag_key_here"

        //Add user attributes here
        val attributes: MutableMap<String, Any> = HashMap<String, Any>()
        //attributes["attribute"] = "value"

        //Set User ID
        val userID = "user123"

        //Execute Code
        val optimizelyManager = OptimizelyManager.builder()
            .withSDKKey(sdkKey)
            .withDatafileDownloadInterval(15, TimeUnit.MINUTES)
            .withEventDispatchInterval(30, TimeUnit.SECONDS)
            .build(applicationContext)

        optimizelyManager.initialize(this, null) { optimizely ->
            val user = optimizely.createUserContext(userID, attributes)!!
            val decision = user.decide(flagKey)
            setContent {
                OptimizelySDKTestAppTheme {
                    Spacer(modifier = Modifier.padding(100.dp))
                    if (decision != null) {
                        Greeting(
                            decision = decision,
                            modifier = Modifier.padding(100.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(decision: OptimizelyDecision, modifier: Modifier = Modifier) {
    Column (
        modifier = Modifier
    ){
        Spacer(modifier = Modifier)
        Text(
            text = "isEnabled: ${decision.enabled}",
            fontSize = 20.sp,
            lineHeight = 25.sp,
        )
        Text(
            text = "Variation Key: ${decision.variationKey}",
            fontSize = 20.sp,
            lineHeight = 25.sp,
        )
        Text(
            text = "Rule Key: ${decision.ruleKey}",
            fontSize = 20.sp,
            lineHeight = 25.sp,
        )
        Text(
            text = "Flag Key: ${decision.flagKey}",
            fontSize = 20.sp,
            lineHeight = 25.sp,
        )
        Text(
            text = "Reason: ${decision.reasons}",
            fontSize = 20.sp,
            lineHeight = 25.sp,
        )
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    OptimizelySDKTestAppTheme {
//        Greeting("Android")
//    }
//}