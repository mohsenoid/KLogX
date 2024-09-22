package com.mohsenoid.klogx.android.sample.log.logcat

import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel
import com.mohsenoid.klogx.KLogTarget
import com.mohsenoid.klogx.android.sample.BuildConfig

class SampleLogcatLogFilter : KLogFilter {
    override fun isLoggable(
        target: KLogTarget,
        level: KLogLevel,
        tag: String,
        throwable: Throwable?,
    ): Boolean {
        val targetIsExternal = target == KLogTarget.EXTERNAL
        val targetIsInternal = target == KLogTarget.INTERNAL
        return targetIsExternal || (targetIsInternal && BuildConfig.DEBUG)
    }
}
