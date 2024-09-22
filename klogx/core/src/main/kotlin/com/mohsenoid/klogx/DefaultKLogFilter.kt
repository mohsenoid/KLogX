package com.mohsenoid.klogx

/**
 * The default log filter which allows [KLogLogger] to sent every log to a [KLogAppender]
 */
class DefaultKLogFilter : KLogFilter {
    override fun isLoggable(
        target: KLogTarget,
        level: KLogLevel,
        tag: String,
        throwable: Throwable?,
    ): Boolean = true
}
