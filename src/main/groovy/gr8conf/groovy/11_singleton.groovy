import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper

class Main11 {
    static void main(String[] args) {
        // cannot extend - in kotlin use object declaration
        Main11.getThing()

        def o = new ObjectMapper()
        // in kotlin use object reference
        def s = o.readValue('["1","2","3"]', new TypeReference<List<String>>() {})
        println(s)
    }

    static String getThing() {
        "thing"
    }
}
