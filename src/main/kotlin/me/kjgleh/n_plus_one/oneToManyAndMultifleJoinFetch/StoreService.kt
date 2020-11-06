package me.kjgleh.n_plus_one.oneToManyAndMultifleJoinFetch

import org.springframework.stereotype.Service

@Service
class StoreService(
    private val storeRepository: StoreRepository
) {
//    fun findAllProductAndEmployeeWithJoinFetch() {
//        storeRepository.findAllProductAndEmployeeWithJoinFetch()
//    }

    fun findAllProductWithJoinFetch() {
        storeRepository.findAllProductWithJoinFetch()
    }

    fun findAllEmployeeWithJoinFetch() {
        storeRepository.findAllEmployeeWithJoinFetch()
    }
}