package com.mohsenoid.klogx.firebase

import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.mohsenoid.klogx.KLogAppender
import com.mohsenoid.klogx.KLogFilter
import com.mohsenoid.klogx.KLogLevel

class KLogFirebaseAppender(override val filter: KLogFilter) : KLogAppender {
    private val crashlytics = FirebaseCrashlytics.getInstance()

    override fun appendLog(
        level: KLogLevel,
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        crashlytics.log("(${level.name[0]}) $tag >> $message")
        throwable?.let { crashlytics.recordException(it) }
    }
}
