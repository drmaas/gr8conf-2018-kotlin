package gr8conf.kotlin

fun String.sayHello(): String {
    return "Hello $this"
}

fun main(args: Array<String>) {
    val s = "Dan Maas"
    println(s.sayHello())
}