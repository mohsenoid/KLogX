package com.mohsenoid.klogx

/**
 * The log writer is the interface that is used for sending logs to the [KLogLogger]
 */
interface KLogWriter {
    fun v(
        message: String,
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
    )

    fun v(
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
        lazyMessage: () -> String,
    )

    fun d(
        message: String,
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
    )

    fun d(
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
        lazyMessage: () -> String,
    )

    fun i(
        message: String,
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
    )

    fun i(
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
        lazyMessage: () -> String,
    )

    fun w(
        message: String,
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
    )

    fun w(
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
        lazyMessage: () -> String,
    )

    fun e(
        message: String,
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
    )

    fun e(
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
        lazyMessage: () -> String,
    )

    fun wtf(
        message: String,
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
    )

    fun wtf(
        target: KLogTarget = KLogTarget.INTERNAL,
        throwable: Throwable? = null,
        lazyMessage: () -> String,
    )
}
