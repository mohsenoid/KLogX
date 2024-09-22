package com.mohsenoid.klogx.android.sample.log

import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel
import com.mohsenoid.klogx.KLogTarget

class SampleLogFilter : KLogFilter {
    override fun isLoggable(
        target: KLogTarget,
        level: KLogLevel,
        tag: String,
        throwable: Throwable?,
    ): Boolean = target == KLogTarget.EXTERNAL
}
