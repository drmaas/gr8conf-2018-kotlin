class Main9 {
    static void main(String[] args) {
        def l = [1,2,3,4,5]
        def l2 = [6,7,8,9,10]
        l.each { println it }
        l.findAll { it < 5 } // filter
        println l.grep(/[123]/) //matching
        l.collect { it*2 } // map
        println l.inject { a, b -> a + b } // reduce
        println([l, l2].flatten())
    }

    // curry
    def percentage = { percentage, x ->
        x/100 * percentage
    }
    def tenPercent = percentage.curry(10)

}