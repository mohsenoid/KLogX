package com.mohsenoid.klogx.timber

import com.mohsenoid.klogx.KLogAppender
import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel
import timber.log.Timber

class KLogTimberAppender(override val filter: KLogFilter) : KLogAppender {
    override fun appendLog(
        level: KLogLevel,
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        Timber.tag(tag).log(level.priority, message, throwable)
    }
}
