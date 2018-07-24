package gr8conf.kotlin

import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Holder(val m: Held) {
    fun processString(a: String): String {
        return m.processString(a)
    }
}
// need open to mock :)
open class Held {
    open fun processString(a: String): String {
        return "$a was processed"
    }
}

// junit5 has more boilerplate, but mockito has clearer separations between mock and verifications
class HolderSpec {

    @DisplayName("test process string")
    @ParameterizedTest(name = "{index} ==> {0}")
    @CsvSource(value = ["a", "b", "c"])
    fun testProcessString(param: String) {
        /* given: "a thing" */
        val c = mock<Held> { // Or spy
            on { processString(param) } doReturn "$param was mock processed"
        }
        val h = Holder(c)

        /* when: "I test it" */
        val r = h.processString(param)

        /* then: "it works" */
        assertEquals(r, "$param was mock processed")
        verify(c, times(1)).processString(param)
    }

}