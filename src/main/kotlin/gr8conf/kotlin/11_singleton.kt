package gr8conf.kotlin

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue

// 1. reified types
// 2. object reference
// 3. object declaration
// 4. companion

fun main(args: Array<String>) {
    // use of reified types and object reference in TypeReference
    val o = jacksonObjectMapper()
    val s = o.readValue<List<String>>("[]")
    println(s)

    // singletons can implement interfaces
    Vole.x()

    // static companion function
    Rabbit.x()

    // reification
    println(Rabbit().name<Int>())
}

object Vole: Animal {
    override fun x(): String {
        return "x"
    }
}

// interfaces can have default implementations - TODO throws exception
interface Animal {
    fun x(): String {
        TODO("not implemented")
    }
}

// companion singleton for all instances of Rabbit
class Rabbit {
    companion object {
        // companion ref for easy interop with Java
        @JvmStatic
        fun x(): String = "x"
    }

    // reification
    fun <T> desc(clazz: Class<T>): String = clazz.simpleName
}

inline fun <reified T> Rabbit.name() = this.desc(T::class.java)

