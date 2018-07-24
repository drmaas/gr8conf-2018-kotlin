package gr8conf.kotlin

fun main(args: Array<String>) {
    val l = listOf(1,2,3,4,5)
    val l2 = listOf(6,7,8,9,10)
    val l3 = l2.toMutableList() // now it's mutable
    l.forEach { println(it) }
    l.filter { it < 5 } // filter
    l.map { it*2 } // map
    println(l.reduce{ a, b -> a + b }) // reduce
    println(listOf(l, l2).flatten())
    println(tenPercent(100))
}

// curry
val percentage = { percentage: Int, x: Int -> x/100 * percentage }
val tenPercent = { x: Int -> percentage(10, x) }