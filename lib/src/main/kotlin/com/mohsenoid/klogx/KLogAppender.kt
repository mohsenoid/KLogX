package com.mohsenoid.klogx

/**
 * The log appender is the logic that receives the log from [KLogLogger] and decides what to do with it
 */
interface KLogAppender {
    val filter: KLogFilter

    fun appendLog(
        level: KLogLevel,
        tag: String,
        message: String,
        throwable: Throwable?,
    )
}
