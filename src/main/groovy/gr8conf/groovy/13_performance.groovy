import groovy.transform.CompileStatic

@CompileStatic // speeds up execution by factor of 10
class Perf {
    static void main(String[] args) {
        def p = new Perf()
        for (i in 0..2) {
            def r = p.forLoop()
            println("total time: $r")
        }
    }

    def forLoop() {
        def start = System.currentTimeMillis()
        for (long i = 0; i < 1000000000l; i++) {
            def x = 1+1
            x+1
        }
        System.currentTimeMillis() - start
    }
}