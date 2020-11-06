package me.kjgleh.n_plus_one.oneToManyAndMultifleJoinFetch

import javax.persistence.*

@Entity
data class Employee(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    lateinit var store: Store

    fun updateStore(store: Store) {
        this.store = store
    }
}