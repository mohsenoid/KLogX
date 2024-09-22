package com.mohsenoid.klogx.android.sample.feature_y

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

val logWriter = FeatureYLogWriter()

@Composable
fun FeatureY(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            logWriter.d { "Feature Y clicked" }
        },
        modifier = modifier,
    ) {
        Text("Feature Y")
    }
}
