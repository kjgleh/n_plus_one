package me.kjgleh.n_plus_one.oneToMany

import javax.persistence.*

@Entity
data class Subject(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String
) {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "academy_id")
    lateinit var academy: Academy

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    lateinit var teacher: Teacher

    fun updateAcademy(academy: Academy) {
        this.academy = academy
    }
}