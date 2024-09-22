package com.mohsenoid.klogx.android.sample.log

import android.util.Log
import com.mohsenoid.klogx.KLogAppender
import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel

class SampleLogAppender(override val filter: KLogFilter) : KLogAppender {
    override fun appendLog(
        level: KLogLevel,
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        Log.println(level.priority, tag, message)
    }
}