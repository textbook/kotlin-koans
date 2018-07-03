package ii_collections

val Customer.orderedProducts: Set<Product> get() = orders.flatMap { it.products }.toSet()

val Shop.allOrderedProducts: Set<Product> get() = customers.flatMap { it.orders }.flatMap { it.products }.toSet()
