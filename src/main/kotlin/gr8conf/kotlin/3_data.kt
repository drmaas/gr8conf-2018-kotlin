package gr8conf.kotlin

fun main(args: Array<String>) {
    val a = POKO(name = "maas")
    val b = POKO("maas", "???")
    assert(a == b) // needs -ea runtime option to throw AssertionError
    val c = b.copy(name = "dan")
    val d = POKO()
    assert(c == d)
    assert(a == d) // oops
}

data class POKO(
        val name: String = "dan",
        val job: String = "???"
)