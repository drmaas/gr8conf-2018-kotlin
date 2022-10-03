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

    // when
    val y = 1
    when (y) {
        in -1..0-> println("a")
        in 1..10 -> println("b")
        else -> println("c")
    }

    // could also do sealed classes, which eliminate else statements as conditions are 'sealed'

    // kotlin also supports break and return labels
    // see https://kotlinlang.org/docs/reference/returns.html#break-and-continue-labels
}