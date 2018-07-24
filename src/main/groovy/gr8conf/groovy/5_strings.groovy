class Strings {
    static void main(String[] args) {
        def test = new Test()
        println(test.template("myself"))
        println(test.bigString("the audience"))
    }
}

class Test {
    def template(String arg) {
        "templating $arg"
    }

    def bigString(String arg) {
"""
This is a big piece of text.
It is formatted.
It has a template value.
$arg has been templated.
The end.
"""
    }
}