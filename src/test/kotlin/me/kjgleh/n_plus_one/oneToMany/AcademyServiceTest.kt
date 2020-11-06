package me.kjgleh.n_plus_one.oneToMany

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class AcademyServiceTest {

    @Autowired
    private lateinit var academyRepository: AcademyRepository

    @Autowired
    private lateinit var academyService: AcademyService

    @BeforeEach
    fun setup() {
        val academies = List(10) {
            Academy(
                name = "academy name $it"
            ).apply {
                this.addSubject(
                    subject = Subject(
                        name = "subject name $it"
                    )
                )
            }
        }

        academyRepository.saveAll(academies)
    }

    @Test
    fun `find all`() {
        academyRepository.findAll()
    }

    @Test
    fun `find all name of subjects`() {
        val actual = academyService.findAllSubjectNames()
        actual.forEach {
            println(it)
        }
    }

    @Test
    fun `find all with join fetch`() {
        academyService.findAllSubjectNamesWithJoinFetch()
    }

    @Test
    fun `find all with entity graph`() {
        academyService.findAllSubjectNamesWithEntityGraph()
    }

    @Test
    fun `find all subject and teacher with join fetch`() {
        academyService.findAllSubjectAndTeacherWithJoinFetch()
    }

    @Test
    fun `find all subject and teacher with entity graph`() {
        academyService.findAllSubjectAndTeacherWithEntityGraph()
    }
}