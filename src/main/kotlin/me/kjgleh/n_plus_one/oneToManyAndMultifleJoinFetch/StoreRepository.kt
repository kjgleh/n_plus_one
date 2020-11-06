package me.kjgleh.n_plus_one.oneToManyAndMultifleJoinFetch

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StoreRepository : JpaRepository<Store, Long> {

//    @Query("select s from Store s join fetch s.products join fetch s.employees")
//    fun findAllProductAndEmployeeWithJoinFetch(): List<Store>

    @Query("select s from Store s join fetch s.products")
    fun findAllProductWithJoinFetch(): List<Store>

    @Query("select s from Store s join fetch s.employees")
    fun findAllEmployeeWithJoinFetch(): List<Store>
}