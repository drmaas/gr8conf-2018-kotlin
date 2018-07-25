package gr8conf.kotlin

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.atomic.AtomicInteger

fun main(args: Array<String>) = runBlocking {
    val result = AtomicInteger(0)
    for (i in 1..100000) {
        launch(CommonPool) {
            result.incrementAndGet()
            println("${Thread.currentThread().name} $i")
        }
    }

    delay(800) // rough estimate, about 800ms
    println(result)
}

// can also produce values to a channel, read values from channel, fanout/fanin etc
// see https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md#fan-out