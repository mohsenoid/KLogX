package com.mohsenoid.klogx

class KLogConsoleAppender(override val filter: KLogFilter) : KLogAppender {
    override fun appendLog(
        level: KLogLevel,
        tag: String,
        message: String,
        throwable: Throwable?,
    ) {
        println("(${level.name[0]}) $tag >> $message")
    }
}
