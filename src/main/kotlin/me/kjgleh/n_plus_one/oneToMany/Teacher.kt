package me.kjgleh.n_plus_one.oneToMany

import javax.persistence.*

@Entity
data class Teacher(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String
) {

    @OneToMany(mappedBy = "teacher", cascade = [CascadeType.ALL])
    val teachers: MutableList<Subject> = mutableListOf()
}