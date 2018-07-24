import groovy.transform.Canonical
import groovy.transform.TupleConstructor

@TupleConstructor(force = true)
@Canonical
class Constructors {
    String a = "a"
    String b = "b"
    Constructors(int c) {
        a *= c
        b *= c
    }
    static void main(String[] args) {
        def x = new Constructors("aa", "bb")
        println(x)
        def y = new Constructors(2)
        println(y)
        assert x == y
    }
}

