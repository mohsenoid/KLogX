package com.mohsenoid.klogx.android.sample.log.firebase

import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel
import com.mohsenoid.klogx.KLogTarget

class SampleFirebaselLogFilter : KLogFilter {
    override fun isLoggable(
        target: KLogTarget,
        level: KLogLevel,
        tag: String,
        throwable: Throwable?,
    ): Boolean = level.priority >= KLogLevel.INFO.priority && (target == KLogTarget.REMOTE || target == KLogTarget.EXTERNAL)
}
