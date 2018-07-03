package ii_collections

fun moreUndeliveredOrdersThanDelivered(customer: Customer): Boolean {
    val (delivered, undelivered) = customer.orders.partition { it.isDelivered }
    return undelivered.size > delivered.size
}

fun Shop.getCustomersWithMoreUndeliveredOrdersThanDelivered(): Set<Customer> = customers.filter { moreUndeliveredOrdersThanDelivered(it) }.toSet()
