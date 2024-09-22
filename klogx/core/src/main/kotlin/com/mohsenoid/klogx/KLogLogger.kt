package com.mohsenoid.klogx

/**
 * The logger that receives the log from the [KLogWriter] and sends it to the [KLogAppender] if the [KLogFilter] allows it.
 */
object KLogLogger {
    private val appenders: MutableList<KLogAppender> = mutableListOf()

    /**
     * Register a [KLogAppender] to the logger
     */
    fun registerAppender(appender: KLogAppender) {
        appenders.add(appender)
    }

    fun log(
        level: KLogLevel,
        tag: String,
        target: KLogTarget,
        throwable: Throwable?,
        lazyMessage: () -> String,
    ) {
        appenders
            .toList() // thread safety
            .filter { it.filter.isLoggable(target, level, tag, throwable) }
            .forEach { it.appendLog(level, tag, lazyMessage(), throwable) }
    }
}
