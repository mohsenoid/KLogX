package com.mohsenoid.klogx.android.sample.log.instabug

import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel
import com.mohsenoid.klogx.KLogTarget

class SampleInstabugLogFilter : KLogFilter {
    override fun isLoggable(
        target: KLogTarget,
        level: KLogLevel,
        tag: String,
        throwable: Throwable?,
    ): Boolean = level.priority >= KLogLevel.INFO.priority
}
