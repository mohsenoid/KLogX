package com.mohsenoid.klogx

/**
 * The log priorities that map to [android.util.Log] priority
 */
enum class KLogLevel(val priority: Int) {
    VERBOSE(priority = 2),
    DEBUG(priority = 3),
    INFO(priority = 4),
    WARN(priority = 5),
    ERROR(priority = 6),
    ASSERT(priority = 7),
}
