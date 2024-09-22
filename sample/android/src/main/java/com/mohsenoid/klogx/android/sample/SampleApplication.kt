package com.mohsenoid.klogx.android.sample

import android.app.Application
import com.mohsenoid.klogx.DefaultKLogFilter
import com.mohsenoid.klogx.KLogLogger
import com.mohsenoid.klogx.android.sample.log.firebase.SampleFirebaselLogFilter
import com.mohsenoid.klogx.android.sample.log.instabug.SampleInstabugLogFilter
import com.mohsenoid.klogx.android.sample.log.logcat.SampleLogcatLogFilter
import com.mohsenoid.klogx.firebase.KLogFirebaseAppender
import com.mohsenoid.klogx.instabug.KLogInstabugAppender
import com.mohsenoid.klogx.logcat.KLogLogcatAppender
import com.mohsenoid.klogx.timber.KLogTimberAppender
import timber.log.Timber

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize Timber
        Timber.plant(Timber.DebugTree())

        // Initialize KLog
        val logcatLogFilter = SampleLogcatLogFilter()
        val logcatLogAppender = KLogLogcatAppender(logcatLogFilter)
        KLogLogger.registerAppender(logcatLogAppender)

        val timberLogFilter = DefaultKLogFilter()
        val timberLogAppender = KLogTimberAppender(timberLogFilter)
        KLogLogger.registerAppender(timberLogAppender)

        val firebaseLogFilter = SampleFirebaselLogFilter()
        val firebaseLogAppender = KLogFirebaseAppender(firebaseLogFilter)
        KLogLogger.registerAppender(firebaseLogAppender)

        val instabugLogFilter = SampleInstabugLogFilter()
        val instabugLogAppender = KLogInstabugAppender(instabugLogFilter)
        KLogLogger.registerAppender(instabugLogAppender)
    }
}
