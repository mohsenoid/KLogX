package com.mohsenoid.klogx.instabug

import com.instabug.library.logging.InstabugLog
import com.mohsenoid.klogx.KLogAppender
import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel

class KLogInstabugAppender(override val filter: KLogFilter) : KLogAppender {
    override fun appendLog(
        level: KLogLevel,
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        val tagPlusMessage = "$tag >> $message"

        when (level) {
            KLogLevel.VERBOSE -> InstabugLog.v(tagPlusMessage)
            KLogLevel.DEBUG -> InstabugLog.d(tagPlusMessage)
            KLogLevel.INFO -> InstabugLog.i(tagPlusMessage)
            KLogLevel.WARN -> InstabugLog.w(tagPlusMessage)
            KLogLevel.ERROR,
            KLogLevel.ASSERT,
            -> InstabugLog.e(tagPlusMessage)
        }
    }
}
