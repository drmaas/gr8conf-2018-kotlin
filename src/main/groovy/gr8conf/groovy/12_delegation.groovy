class Delegation {
    static void main(String[] args) {
        A a = new A()
        // delegation
        assert a.x == "x"
        assert a.y == "y"

        // lazy is cached
        println a.x
        println a.x
    }
}

class A {
    @Delegate
    B b = new B()
}

class B {
    @Lazy
    String x = {
        println "initializing" // only happens once
        "x"
    }()
    String y = "y"
}