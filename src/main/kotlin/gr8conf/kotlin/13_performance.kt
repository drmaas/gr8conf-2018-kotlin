package gr8conf.kotlin

import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    for (i in 0..2) {
        val r = forLoop()
        println("total time: $r")
    }
}

fun forLoop(): Long {
    return measureTimeMillis {
        for (i in 0..1000000000L) {
            val x = 1 + 1
            x + 1
        }
    }
}