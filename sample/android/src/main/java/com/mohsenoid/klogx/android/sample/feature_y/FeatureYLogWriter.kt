package com.mohsenoid.klogx.android.sample.feature_y

import com.mohsenoid.klogx.DefaultKLogWriter

class FeatureYLogWriter : DefaultKLogWriter {
    override val tag: String = TAG

    companion object {
        const val TAG = "FeatureY"
    }
}
