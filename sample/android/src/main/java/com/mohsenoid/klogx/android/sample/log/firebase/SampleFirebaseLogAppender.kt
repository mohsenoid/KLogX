package com.mohsenoid.klogx.android.sample.log.firebase

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.mohsenoid.klogx.KLogAppender
import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel

class SampleFirebaseLogAppender(override val filter: KLogFilter) : KLogAppender {
    private val crashlytics = FirebaseCrashlytics.getInstance()

    override fun appendLog(
        level: KLogLevel,
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        crashlytics.log("$tag >> $message")
        throwable?.let { crashlytics.recordException(it) }
    }
}
