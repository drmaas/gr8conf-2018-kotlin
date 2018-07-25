package gr8conf.kotlin

fun main(args: Array<String>) {
    val a = A(B1())
    // delegation
    assert(a.x == "x")
    assert(a.y() == "y")

    // lazy is cached
    println(a.x)
    println(a.x)
}

// only interfaces can be delegated to
class A(val b: B) : B by b {
    val x: String by lazy {
        println("initializing") // only happens once
        "x"
    }
}

interface B {
    fun y() = "y"
}

class B1: B