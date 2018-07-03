package iv_properties

class PropertyExample {
    var counter = 0
    var propertyWithCounter: Int? = 14
        set(value) {
            counter += 1
            field = value
        }
}
