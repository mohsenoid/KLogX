package com.mohsenoid.klogx

/**
 * The log target that could be the library internal, host app external, or remote server
 */
enum class KLogTarget {
    EXTERNAL,
    INTERNAL,
    REMOTE,
}
