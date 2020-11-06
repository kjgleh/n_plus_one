package me.kjgleh.n_plus_one.oneToMany

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class AcademyService(
    private val academyRepository: AcademyRepository
) {

    fun findAllSubjectNames(): List<String> {
        val academies = academyRepository.findAll()
        return getSubjectName(academies)
    }

    fun findAllSubjectNamesWithJoinFetch(): List<String> {
        val academies = academyRepository.findAllWithJoinFetch()
        return getSubjectName(academies)
    }

    fun findAllSubjectNamesWithEntityGraph(): List<String> {
        val academies = academyRepository.findAllWithEntityGraph()
        return getSubjectName(academies)
    }

    fun findAllSubjectAndTeacherWithJoinFetch() {
        academyRepository.findAllSubjectAndTeacherWithJoinFetch()
    }

    fun findAllSubjectAndTeacherWithEntityGraph() {
        academyRepository.findAllSubjectAndTeacherWithEntityGraph()
    }

    private fun getSubjectName(academies: List<Academy>): List<String> {
        return academies.flatMap { academy ->
            academy.subjects.map { subject ->
                subject.name
            }
        }
    }
}