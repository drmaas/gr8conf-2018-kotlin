package gr8conf.groovy

class Hello {
    def sayHello(String name) {
        return "Hello $name"
    }

    static void main(String[] args) {
        def s = "Dan Maas"
        println(new Hello().sayHello(s))
        // or
        println(s.sayHello())
    }
}

class HelloExtension {
    static String sayHello(String self) {
        return "Hello $self"
    }
}
