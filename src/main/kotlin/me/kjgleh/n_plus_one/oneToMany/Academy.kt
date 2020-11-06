package me.kjgleh.n_plus_one.oneToMany

import javax.persistence.*

@Entity
data class Academy(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
    val name: String
) {

    @OneToMany(mappedBy = "academy", cascade = [CascadeType.ALL])
//    @Fetch(FetchMode.SUBSELECT)
    val subjects: MutableList<Subject> = mutableListOf()

    fun addSubject(subject: Subject) {
        this.subjects.add(subject)
        subject.updateAcademy(this)
    }
}
