import spock.lang.Specification
import spock.lang.Unroll

class Holder {
    Held m
    Holder(Held m) {
        this.m = m
    }
    def processString(String a) {
        m.processString(a)
    }
}
class Held {
    def processString(String a) {
        "$a was processed"
    }
}

// mock and verifications go together
class HolderSpec extends Specification {

    @Unroll
    def "test process string - #param"() {
        given: "a thing"
        def c = Mock(Held) { // Or Spy, Stub
            1 * processString(_) >> { "${it[0]} was mock processed" }
        }
        Holder h = new Holder(c)

        when: "I test it"
        def r = h.processString(param)

        then: "it works"
        r == "$param was mock processed"

        where: "values are provided"
        param << ["a", "b", "c"]

    }

}