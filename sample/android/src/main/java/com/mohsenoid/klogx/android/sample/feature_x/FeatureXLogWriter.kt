package com.mohsenoid.klogx.android.sample.feature_x

import com.mohsenoid.klogx.DefaultKLogWriter

class FeatureXLogWriter : DefaultKLogWriter {
    override val tag: String = TAG

    companion object {
        const val TAG = "FeatureX"
    }
}
