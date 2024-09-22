package com.mohsenoid.klogx.android.sample.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.mohsenoid.klogx.KLogTarget
import com.mohsenoid.klogx.android.sample.ui.theme.SampleApplicationTheme

private val logWriter = SampleFeatureKLogWriter()

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        logWriter.v(message = "onCreate", target = KLogTarget.EXTERNAL)

        enableEdgeToEdge()
        setContent {
            SampleApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding),
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier.fillMaxSize()) {
        Text(
            text = "Hello $name!",
        )

        Button(
            onClick = {
                logWriter.d(target = KLogTarget.EXTERNAL) { "Button clicked" }
            },
        ) {
            Text("Click me")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SampleApplicationTheme {
        Greeting("Android")
    }
}
