package com.mohsenoid.klogx.android.sample.log.android

import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel
import com.mohsenoid.klogx.KLogTarget
import com.mohsenoid.klogx.android.sample.BuildConfig

class SampleAndroidLogFilter : KLogFilter {
    override fun isLoggable(
        target: KLogTarget,
        level: KLogLevel,
        tag: String,
        throwable: Throwable?,
    ): Boolean = BuildConfig.DEBUG
}
