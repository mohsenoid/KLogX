# <img src="LOGO.webp" alt="Logo" style="width:54px;" /> KLogX

KLogX is a Kotlin logging library designed to provide a flexible and efficient way to log messages in your application. It supports different log levels and allows you to register custom appenders to handle log messages.

```mermaid
---
title: KLogX Parts
---
classDiagram
		direction tb
    class KLogLogger {
        -MutableList<KLogAppender> appenders
        +registerAppender(appender: KLogAppender)
        +log(level: KLogLevel, tag: String, target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
    }
    
    note for KLogAppender "The logic that receives the log from KLogLogger\nand decides what to do with it"
    class KLogAppender {
        <<interface>>
        +KLogFilter filter
        +appendLog(level: KLogLevel, tag: String, message: String, throwable: Throwable?)
    }

    class KLogLevel {
        <<enum>>
        Int priority
        VERBOSE
        DEBUG
        INFO
        WARN
        ERROR
        ASSERT
    }
   
    class KLogFilter {
        <<interface>>
        +isLoggable(target: KLogTarget, level: KLogLevel, tag: String, throwable: Throwable?): Boolean
    }

    class KLogTarget {
        <<enum>>
        EXTERNAL
        INTERNAL
        REMOTE
    }
    
    note for KLogWriter "The interface that is used for sending logs to the KLogLogger"
    class KLogWriter {
        <<interface>>
        +v(message: String, target: KLogTarget, throwable: Throwable?)
        +v(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +d(message: String, target: KLogTarget, throwable: Throwable?)
        +d(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +i(message: String, target: KLogTarget, throwable: Throwable?)
        +i(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +w(message: String, target: KLogTarget, throwable: Throwable?)
        +w(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +e(message: String, target: KLogTarget, throwable: Throwable?)
        +e(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +wtf(message: String, target: KLogTarget, throwable: Throwable?)
        +wtf(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
    }
    
    note for DefaultKLogWriter "The default Log writer with a single tag"
    class DefaultKLogWriter {
        +tag: String
        +v(message: String, target: KLogTarget, throwable: Throwable?)
        +v(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +d(message: String, target: KLogTarget, throwable: Throwable?)
        +d(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +i(message: String, target: KLogTarget, throwable: Throwable?)
        +i(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +w(message: String, target: KLogTarget, throwable: Throwable?)
        +w(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +e(message: String, target: KLogTarget, throwable: Throwable?)
        +e(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
        +wtf(message: String, target: KLogTarget, throwable: Throwable?)
        +wtf(target: KLogTarget, throwable: Throwable?, lazyMessage: () -> String)
    }

    KLogAppender <|-- KLogLogger
    KLogFilter <|-- KLogAppender
    KLogLevel <|-- KLogLogger
    KLogTarget <|-- KLogLogger
    KLogWriter --> KLogLogger
    KLogWriter <|-- DefaultKLogWriter
```

## Features

- Supports multiple log levels: INFO, WARN, ERROR, etc.
- Allows lazy message evaluation
- Customizable log targets
- Register custom appenders

## Installation

Add the following dependency to your `build.gradle` file:

```groovy
dependencies {
    implementation 'com.mohsenoid:klogx:1.0.0'
}
```

## Usage

### Basic logging

To log messages, use the `KLogWriter` interface. Here are some examples:

```kotlin
val logger: KLogWriter = DefaultKLogWriter()

// Info log
logger.i("Debugger is active", KLogTarget.CONSOLE, null)

// Warning log
logger.w("Launch timeout has expired, giving up wake Lock!", KLogTarget.CONSOLE, null)

// Error log
logger.e("Uncaught handler: thread main exiting due to uncaught exception", KLogTarget.CONSOLE, null)

// WTF log
logger.wtf("What A Terrible Failure", KLogTarget.CONSOLE, null)
```

### Lazy message evaluation

You can also log messages lazily:

```kotlin
logger.i(KLogTarget.CONSOLE, null) { "Debugger is active" }
logger.w(KLogTarget.CONSOLE, null) { "Launch timeout has expired, giving up wake Lock!" }
logger.e(KLogTarget.CONSOLE, null) { "Uncaught handler: thread main exiting due to uncaught exception" }
logger.wtf(KLogTarget.CONSOLE, null) { "What A Terrible Failure" }
```

### Custom Appenders

You can register custom log appenders to handle log messages:

```kotlin
val customAppender = object : KLogAppender {
    override val filter: KLogFilter = CustomLogFilter()

    override fun appendLog(level: KLogLevel, tag: String, message: String, throwable: Throwable?) {
        // Custom log handling
    }
}

KLogLogger.registerAppender(customAppender)
```

## License

Copyright 2024 Mohsen Mirhoseini

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.