import groovyx.gpars.GParsPool

import java.util.concurrent.atomic.AtomicInteger

class Concurrency {
    static void main(String[] args) {
        GParsPool.withPool {
            AtomicInteger result = new AtomicInteger(0)
            def start = System.currentTimeMillis()
            (1..100000).eachParallel { result.incrementAndGet() ; println "${Thread.currentThread().name} $it" }
            println System.currentTimeMillis() - start // about 1.3 seconds
            println result.intValue()
        }
    }
}