package com.mohsenoid.klogx.android.sample

import android.app.Application
import com.mohsenoid.klogx.KLogLogger
import com.mohsenoid.klogx.android.sample.log.android.SampleAndroidLogAppender
import com.mohsenoid.klogx.android.sample.log.android.SampleAndroidLogFilter
import com.mohsenoid.klogx.android.sample.log.firebase.SampleFirebaseLogAppender
import com.mohsenoid.klogx.android.sample.log.firebase.SampleFirebaselLogFilter

class SampleApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        val androidLogFilter = SampleAndroidLogFilter()
        val androidLogAppender = SampleAndroidLogAppender(androidLogFilter)
        KLogLogger.registerAppender(androidLogAppender)

        val firebaseLogFilter = SampleFirebaselLogFilter()
        val firebaseLogAppender = SampleFirebaseLogAppender(firebaseLogFilter)
        KLogLogger.registerAppender(firebaseLogAppender)
    }
}
