package me.kjgleh.n_plus_one.oneToManyAndMultifleJoinFetch

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.TestPropertySource
import java.util.*

@SpringBootTest
@TestPropertySource(properties = ["spring.jpa.properties.hibernate.default_batch_fetch_size=1000"]) // 옵션 적용
internal class StoreServiceTest {

    @Autowired
    private lateinit var storeRepository: StoreRepository

    @Autowired
    private lateinit var storeService: StoreService

    @BeforeEach
    fun setup() {
        val stores = List(10) {
            Store(
                name = UUID.randomUUID().toString()
            ).apply {
                repeat(4) {
                    this.addProduct(
                        product = Product(
                            name = UUID.randomUUID().toString()
                        )
                    )
                }
                repeat(3) {
                    this.addEmployee(
                        employee = Employee(
                            name = UUID.randomUUID().toString()
                        )
                    )
                }
            }
        }

        storeRepository.saveAll(stores)
    }

//    Join Fetch를 두번 실행하면 MultipleBagFetchException 발생
//    @Test
//    fun `find all product and employee with join fetch`() {
//        storeService.findAllProductAndEmployeeWithJoinFetch()
//    }

    @Test
    fun `find all product with join fetch`() {
        storeService.findAllProductWithJoinFetch()
        storeService.findAllEmployeeWithJoinFetch()
    }
}