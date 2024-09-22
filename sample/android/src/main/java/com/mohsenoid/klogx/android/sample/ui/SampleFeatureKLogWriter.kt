package com.mohsenoid.klogx.android.sample.ui

import com.mohsenoid.klogx.DefaultKLogWriter

class SampleFeatureKLogWriter : DefaultKLogWriter {
    override val tag: String = TAG

    companion object {
        const val TAG = "SampleFeature"
    }
}
