package v_builders

import v_builders.data.getProducts
import v_builders.htmlLibrary.*

fun getTitleColor() = "#b9c9fe"
fun getCellColor(row: Int, column: Int) = if ((row + column) %2 == 0) "#dce4ff" else "#eff2ff"

fun renderProductTable(): String {
    return html {
        table {
            tr(getTitleColor()) {
                td {
                    text("Product")
                }
                td {
                    text("Price")
                }
                td {
                    text("Popularity")
                }
            }

            getProducts().forEachIndexed { index, (name, price, popularity) -> tr {
                td(getCellColor(index, 0)) {
                    text(name)
                }
                td(getCellColor(index, 1)) {
                    text(price)
                }
                td(getCellColor(index, 2)) {
                    text(popularity)
                }
            } }
        }
    }.toString()
}
