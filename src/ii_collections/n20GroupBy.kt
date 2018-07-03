package ii_collections

fun Shop.groupCustomersByCity(): Map<City, List<Customer>> = customers.groupBy { it.city }
