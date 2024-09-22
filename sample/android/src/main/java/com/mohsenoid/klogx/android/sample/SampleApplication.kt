package com.mohsenoid.klogx.android.sample

import android.app.Application
import com.mohsenoid.klogx.KLogLogger
import com.mohsenoid.klogx.android.sample.log.SampleLogAppender
import com.mohsenoid.klogx.android.sample.log.SampleLogFilter

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val logFilter = SampleLogFilter()
        val logAppender = SampleLogAppender(logFilter)
        KLogLogger.registerAppender(logAppender)
    }
}
