package gr8conf.kotlin

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.runBlocking
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) = runBlocking {
    val result = AtomicInteger(0)
    val time = measureTimeMillis {
        val jobs = (1..100000).map {
            async(CommonPool) {
                result.incrementAndGet()
                println("${Thread.currentThread().name} $it")
            }
        }
        jobs.forEach { it.await() }
    }

    println(result)
    println(time)
}

// can also produce values to a channel, read values from channel, fanout/fanin etc
// see https://github.com/Kotlin/kotlinx.coroutines/blob/master/coroutines-guide.md#fan-out