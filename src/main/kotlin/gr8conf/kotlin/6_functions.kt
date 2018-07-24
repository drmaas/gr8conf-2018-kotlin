package gr8conf.kotlin

fun main(args: Array<String>) {
    println(a("arg"))
    println(b("arg"))
    println(b(arg = "arg"))
    println(c("arg1"))
    println(c.invoke("arg2"))
    val commands = Commands()
    commands.commands {
        m1() // receiver!
        println("inside")
        m2() // receiver!
    }
    // closure return
    add(1)(2)
    add(1).invoke(2)
    // function expansion
    append("a") { "b" }
    // vararg
    val a = arrayOf("1", "2", "3")
    v(*a)

}

// single expression function
fun a(arg: String) = "a: closure: $arg"

// traditional
fun b(arg: String): String {
    return "b: method: $arg"
}

// function literal
val c: (String) -> String = { arg -> "c: method: $arg"}

// function expansion
fun append(a : String,  calc : (String) -> String) : String {
    return "$a${calc.invoke(a)}"
}

// closure
fun add(a : Int) : (Int) -> Int {
    return { x -> a + x }
}

//  closure in expression form
fun add2(a:Int) = { x: Int -> a + x }

// closure with function receiver
class Commands {
    fun m1() {
        println("Method1")
    }

    fun m2() {
        println("Method2")
    }

    fun commands(closure: Commands.() -> Unit) { // Commands is the receiver, like groovy delegate
        println("before")
        closure()
        println("after")
    }
}

// local functions
fun x(a: String): String {
    fun y() = "y"
    return "$a${y()}"
}

// vararg
fun v(vararg a: String) {
    val x: Array<out String> = a
    println(x[1])
}
