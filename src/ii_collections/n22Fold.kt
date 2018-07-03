package ii_collections

fun Shop.getSetOfProductsOrderedByEachCustomer(): Set<Product> {
    // Return the set of products that were ordered by each of the customers
    return customers.fold(allOrderedProducts, {
        orderedByAll, customer -> orderedByAll.intersect(customer.orderedProducts)
    })
}
