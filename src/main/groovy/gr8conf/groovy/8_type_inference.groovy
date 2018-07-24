package gr8conf.groovy

import groovy.transform.CompileStatic

@CompileStatic
class TypeInference {
    static void main(String[] args) {
        def test = new Test()
        // without arg type: // [Static type checking] error
        // with arg type: ok
        def v = test.test { String r ->
            r
        }
        println v
    }
}

@CompileStatic
class Test {
    def a ="a"
    def b = "b"

    String test(Closure<String> f) {
        return f("$a$b".toString()) // toString needed on GStringImpl
    }
}