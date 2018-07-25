package gr8conf.kotlin

import org.slf4j.event.Level

fun main(args: Array<String>) {

    log {
        tag { "main" }
        info { "hello" }
    }

    log {
        level { Level.WARN }
        tag { "main" }
        message { "Something went wrong" }
        throwable { Exception("aaaaaah") }
    }

}

// inline compiles function code into call site to reduce call stack size
// crossinline allows lambdas to be executed from some other nested context (not inline fun directly)

class LogWriter {
    fun log(level: Level, tag: String?, throwable: Throwable?, message: String?) {
        println("level: $level, tag: $tag, throwable: ${throwable?.message}, message: $message")
    }
}

val writer = LogWriter()

inline fun log(configure: Log.() -> Unit) {
    Log().let {
        it.configure() // function receiver FTW again!
        write(it)
    }
}

fun write(log: Log) = writer.log(log.level, log.tag, log.throwable, log.message)

class Log {
    var level: Level = Level.DEBUG
    var tag: String? = null
    var throwable: Throwable? = null
    var message: String? = null

    inline fun info(message: () -> String?) {
        level { Level.INFO }
        this.message = message()
    }

    inline fun tag(tag: () -> String) {
        this.tag = tag()
    }

    inline fun throwable(throwable: () -> Throwable) {
        this.throwable = throwable()
    }

    inline fun level(level: () -> Level) {
        this.level = level()
    }

    inline fun message(message: () -> String) {
        this.message = message()
    }
}
