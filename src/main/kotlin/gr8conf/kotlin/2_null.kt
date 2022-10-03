package gr8conf.kotlin

fun main(args: Array<String>) {
    var o: NPE? = null // ? means nullable
    //println(o.npe()) // oops
    println(o?.npe()) // ok
    println(o!!.npe()) // will throw NPE
    o = NPE() // var can be reassigned
    println(o.npe())

    val p: NPE
    //println(p.npe())  // oops
    p = NPE()
    println(p.npe())
    //p = NPE() // val cannot be reassigned
}

class NPE {
    fun npe(): String {
        return "npe"
    }
}