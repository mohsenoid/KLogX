package com.mohsenoid.klogx.android.sample.featureX

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

val logWriter = FeatureXLogWriter()

@Composable
fun FeatureX(modifier: Modifier = Modifier) {
    Button(
        onClick = {
            logWriter.d { "Feature X clicked" }
        },
        modifier = modifier,
    ) {
        Text("Feature X")
    }
}
