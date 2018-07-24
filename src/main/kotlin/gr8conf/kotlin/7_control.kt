package gr8conf.kotlin

fun main(args: Array<String>) {
    // for
    for (i in 0..3) {
        println(i)
    }
    // while
     var x = 0
    while (x < 3) { println(x) ; x++ }
    // if else with return, replaces ternary
    val r = if (x > 3) "help" else "ok"
    println(r)
}