package com.mohsenoid.klogx.console.sample.log

import com.mohsenoid.klogx.DefaultKLogWriter

class FeatureLogWriter : DefaultKLogWriter {
    override val tag: String = TAG

    companion object {
        const val TAG = "Feature"
    }
}
