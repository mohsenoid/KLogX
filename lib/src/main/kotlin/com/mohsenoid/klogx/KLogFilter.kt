package com.mohsenoid.klogx

/**
 * The log filter which allows [KLogLogger] to decide if a log should be sent to a [KLogAppender] or not
 */
fun interface KLogFilter {
    fun isLoggable(
        target: KLogTarget,
        level: KLogLevel,
        tag: String,
        throwable: Throwable?,
    ): Boolean
}
