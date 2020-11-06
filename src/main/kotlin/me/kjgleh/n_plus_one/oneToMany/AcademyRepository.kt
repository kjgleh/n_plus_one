package me.kjgleh.n_plus_one.oneToMany

import org.springframework.data.jpa.repository.EntityGraph
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface AcademyRepository: JpaRepository<Academy, Long> {
    /**
     * 1. join fetch를 통한 조회
     */
    @Query("select a from Academy a join fetch a.subjects")
    fun findAllWithJoinFetch(): List<Academy>

    /**
     * 2. @EntityGraph
     */
    @EntityGraph(attributePaths = ["subjects"])
    @Query("select a from Academy a")
    fun findAllWithEntityGraph(): List<Academy>

    /**
     * 3. join fetch + distinct 를 통한 조회
     */
    @Query("select DISTINCT a from Academy a join fetch a.subjects")
    fun findAllJoinFetchDistinct(): List<Academy>

    /**
     * 4. @EntityGraph + distinct 를 통한 조회
     */
    @EntityGraph(attributePaths = ["subjects"])
    @Query("select DISTINCT a from Academy a")
    fun findAllEntityGraphDistinct(): List<Academy>

    /**
     * 5. Academy+Subject+Teacher를 join fetch로 조회
     */
    @Query("select distinct a from Academy a join fetch a.subjects s join fetch s.teacher")
    fun findAllSubjectAndTeacherWithJoinFetch(): List<Academy>

    /**
     * 6. Academy+Subject+Teacher를 @EntityGraph 로 조회
     */
    @EntityGraph(attributePaths = ["subjects", "subjects.teacher"])
    @Query("select DISTINCT a from Academy a")
    fun findAllSubjectAndTeacherWithEntityGraph(): List<Academy>
}