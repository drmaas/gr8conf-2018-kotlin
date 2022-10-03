import groovy.transform.Canonical
import groovy.transform.TupleConstructor

class Data {
    static void main(String[] args) {
        def a = new POGO(name: "maas")
        def b = new POGO("maas", "???")
        assert a == b
    }
}

@Canonical
@TupleConstructor
class POGO {
    String name = "dan"
    String job = "???"
}