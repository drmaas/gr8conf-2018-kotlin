class Functions {
    static void main(String[] args) {
        def f = new Functions()
        println(f.a("arg"))
        println(f.b("arg"))
        f.commands {
            m1()
            println "inside"
            m2()
        }
        // higher order
        println f.c(f.a)
    }

    def a = { arg ->
        "a: closure: $arg"
    }

    def b(String arg) {
        "b: method: $arg"
    }

    def c = { closure ->
        closure("c")
    }

    def m1() {
        println "Method1"
    }

    def m2() {
        println "Method2"
    }

    def commands(@DelegatesTo(Functions) Closure closure) {
        def c = closure.clone()
        c.delegate = this
        println "before"
        c()
        println "after"
    }

}