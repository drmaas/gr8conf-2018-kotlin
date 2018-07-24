package gr8conf.kotlin

fun main(args: Array<String>) {
    val test = TestInference()
    //always ok, param is inferred
    val v = test.test { r ->
        r
    }
    println(v)
}

class TestInference {
    var a ="a"
    var b = "b"

    fun test(f: (String) -> String): String {
        return f("$a$b")
    }
}