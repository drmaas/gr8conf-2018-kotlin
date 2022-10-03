package gr8conf.kotlin

fun main(args: Array<String>) {
    val x = Constructors("aa", "bb")
    println(x)
    val y = Constructors(3)
    println(y)
    assert(x == y) // oops
}

data class Constructors(
        var a: String = "a",
        var b: String = "b") {
    constructor(c: Int = 2): this("a", "b") {
        a *= c
        b *= c
    }
}

// operator overload - *
// extension function
// single expression function
// map reduce on collection
// iterator over sequence of elements
operator fun String.times(i: Int) = (1..i).map { this }.reduce { a, b -> "$a$b" }
