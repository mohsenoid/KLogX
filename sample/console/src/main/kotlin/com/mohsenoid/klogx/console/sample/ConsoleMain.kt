package com.mohsenoid.klogx.console.sample

import com.mohsenoid.klogx.DefaultKLogFilter
import com.mohsenoid.klogx.KLogConsoleAppender
import com.mohsenoid.klogx.KLogLogger
import com.mohsenoid.klogx.console.sample.log.FeatureLogWriter

val featureLogWriter = FeatureLogWriter()

fun main() {
    setupLogAppender()
    featureLogWriter.d("Hello Logs!")
}

private fun setupLogAppender() {
    val consoleLogFilter = DefaultKLogFilter()
    val consoleLogAppender = KLogConsoleAppender(consoleLogFilter)
    KLogLogger.registerAppender(consoleLogAppender)
}
