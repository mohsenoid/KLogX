package com.mohsenoid.klogx

/**
 * The default log writer that uses [KLogLogger] to log the message.
 * Any feature that wants to log a message should extend this interface and provide a decent tag.
 */
interface DefaultKLogWriter : KLogWriter {
    val tag: String

    /**
     * Logs a verbose message.
     * It is the least important and most casual log level, and it should only be used for debugging purposes.
     *
     * Example: DownloadRate 184166 bytes per sec. Downloaded Bytes 5643/34714
     *
     * @param message the message to log
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun v(
        message: String,
        target: KLogTarget,
        throwable: Throwable?,
    ) {
        KLogLogger.log(KLogLevel.VERBOSE, tag, target, throwable) { message }
    }

    /**
     * Logs a verbose message.
     * It is the least important and most casual log level, and it should only be used for debugging purposes.
     *
     * Example: DownloadRate 184166 bytes per sec. Downloaded Bytes 5643/34714
     *
     * @param lazyMessage the message to log in a lazy way
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun v(
        target: KLogTarget,
        throwable: Throwable?,
        lazyMessage: () -> String,
    ) {
        KLogLogger.log(KLogLevel.VERBOSE, tag, target, throwable, lazyMessage)
    }

    /**
     * Logs a debug message.
     * Designates fine-grained informational events that are most useful to debug an application.
     *
     * Example: HeapWorker thread shutting down
     *
     * @param message the message to log
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun d(
        message: String,
        target: KLogTarget,
        throwable: Throwable?,
    ) {
        KLogLogger.log(KLogLevel.DEBUG, tag, target, throwable) { message }
    }

    /**
     * Logs a debug message.
     * Designates fine-grained informational events that are most useful to debug an application.
     *
     * Example: HeapWorker thread shutting down
     *
     * @param lazyMessage the message to log in a lazy way
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun d(
        target: KLogTarget,
        throwable: Throwable?,
        lazyMessage: () -> String,
    ) {
        KLogLogger.log(KLogLevel.DEBUG, tag, target, throwable, lazyMessage)
    }

    /**
     * Logs an info message.
     * Designates informational messages that highlight the progress of the application at a coarse-grained level.
     *
     * Example: Debugger is active
     *
     * @param message the message to log
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun i(
        message: String,
        target: KLogTarget,
        throwable: Throwable?,
    ) {
        KLogLogger.log(KLogLevel.INFO, tag, target, throwable) { message }
    }

    /**
     * Logs an info message.
     * Designates informational messages that highlight the progress of the application at a coarse-grained level.
     *
     * Example: Debugger is active
     *
     * @param lazyMessage the message to log in a lazy way
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun i(
        target: KLogTarget,
        throwable: Throwable?,
        lazyMessage: () -> String,
    ) {
        KLogLogger.log(KLogLevel.INFO, tag, target, throwable, lazyMessage)
    }

    /**
     * Logs a warning message.
     * Designates potentially harmful situations.
     *
     * Example: Launch timeout has expired, giving up wake Lock!
     *
     * @param message the message to log
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun w(
        message: String,
        target: KLogTarget,
        throwable: Throwable?,
    ) {
        KLogLogger.log(KLogLevel.WARN, tag, target, throwable) { message }
    }

    /**
     * Logs a warning message.
     * Designates potentially harmful situations.
     *
     * Example: Launch timeout has expired, giving up wake Lock!
     *
     * @param lazyMessage the message to log in a lazy way
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun w(
        target: KLogTarget,
        throwable: Throwable?,
        lazyMessage: () -> String,
    ) {
        KLogLogger.log(KLogLevel.WARN, tag, target, throwable, lazyMessage)
    }

    /**
     * Logs an error message.
     * Designates error events that might still allow the application to continue running.
     *
     * Example: Uncaught handler: thread main exiting due to uncaught exception
     *
     * @param message the message to log
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun e(
        message: String,
        target: KLogTarget,
        throwable: Throwable?,
    ) {
        KLogLogger.log(KLogLevel.ERROR, tag, target, throwable) { message }
    }

    /**
     * Logs an error message.
     * Designates error events that might still allow the application to continue running.
     *
     * Example: Uncaught handler: thread main exiting due to uncaught exception
     *
     * @param lazyMessage the message to log in a lazy way
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun e(
        target: KLogTarget,
        throwable: Throwable?,
        lazyMessage: () -> String,
    ) {
        KLogLogger.log(KLogLevel.ERROR, tag, target, throwable, lazyMessage)
    }

    /**
     * Logs a "What A Terrible Failure" message.
     *
     * @param message the message to log
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun wtf(
        message: String,
        target: KLogTarget,
        throwable: Throwable?,
    ) {
        KLogLogger.log(KLogLevel.ERROR, tag, target, throwable) { message }
    }

    /**
     * Logs a "What A Terrible Failure" message.
     *
     * @param lazyMessage the message to log in a lazy way
     * @param target the target of the log
     * @param throwable the throwable to log
     * @see KLogTarget
     * @see KLogWriter
     */
    override fun wtf(
        target: KLogTarget,
        throwable: Throwable?,
        lazyMessage: () -> String,
    ) {
        KLogLogger.log(KLogLevel.ERROR, tag, target, throwable, lazyMessage)
    }
}
