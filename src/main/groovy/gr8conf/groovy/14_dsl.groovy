import org.slf4j.event.Level

import static Log.log

class DSL {
    static void main(String[] args) {

        log {
            tag { "main" }
            info { "hello" }
        }

        log {
            level { Level.WARN }
            tag { "main" }
            message { "Something went wrong" }
            throwable { new Exception("aaaaaah") }
        }

    }
}


class LogWriter {
    def log(Level level, String tag, Throwable throwable, String message) {
        println("level: $level, tag: $tag, throwable: ${throwable?.message}, message: $message")
    }
}

class Log {

    Level level = Level.DEBUG
    String tag = null
    Throwable throwable = null
    String message = null
    static LogWriter writer = new LogWriter()

    static def log(@DelegatesTo(Log) Closure logDefinition) {
        def log = new Log()
        logDefinition.delegate = log
        logDefinition()
        writer.log(log.level, log.tag, log.throwable, log.message)
    }

    def info(Closure<String> message) {
        level { Level.INFO }
        this.message = message()
    }

    def tag(Closure<String> tag) {
        this.tag = tag()
    }

    def throwable(Closure<Throwable> throwable) {
        this.throwable = throwable()
    }

    def level(Closure<Level> level) {
        this.level = level()
    }

    def message(Closure<String> message) {
        this.message = message()
    }

}