package gr8conf.kotlin

fun main(args: Array<String>) {
    val test = Test()
    println(test.template("myself"))
    println(test.bigString("the audience"))
}

class Test {
    fun template(arg: String): String {
        return "templating $arg"
    }

    fun bigString(arg: String): String {
        return """
This is a big piece of text.
It is formatted.
It has a template value.
$arg has been templated.
The end.
"""
    }
}