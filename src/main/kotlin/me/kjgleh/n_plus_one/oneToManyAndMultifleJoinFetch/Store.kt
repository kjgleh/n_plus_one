package me.kjgleh.n_plus_one.oneToManyAndMultifleJoinFetch

import javax.persistence.*

@Entity
data class Store(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String
) {
    @OneToMany(mappedBy = "store", cascade = [CascadeType.ALL])
    val products: MutableList<Product> = mutableListOf()

    @OneToMany(mappedBy = "store", cascade = [CascadeType.ALL])
    val employees: MutableList<Employee> = mutableListOf()

    fun addProduct(product: Product) {
        this.products.add(product)
        product.updateStore(this)
    }

    fun addEmployee(employee: Employee) {
        this.employees.add(employee)
        employee.updateStore(this)
    }
}