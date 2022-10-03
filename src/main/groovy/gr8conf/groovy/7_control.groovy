class Control {
    static void main(String[] args) {
        // for
        for (i in 0..3) {
            println i
        }
        // while
        def x = 0
        while (x < 3) { println x ; x++ }
        // ternary
        def s = (x > 3) ? "help" : "ok"
        println(s)
    }
}