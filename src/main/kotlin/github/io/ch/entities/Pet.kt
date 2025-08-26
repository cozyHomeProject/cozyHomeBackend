package github.io.ch.entities

import jakarta.persistence.*
import java.time.LocalDate
import java.time.LocalDateTime

@Entity
@Table(name = "pets")
data class Pet(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    val name: String,
    val birthDate: LocalDate? = null,
    val age: Long?,
    val type: String,
    val breed: String?,
    val createdAt: LocalDateTime,
    @OneToMany(mappedBy = "pet", cascade = [(CascadeType.ALL)], orphanRemoval = true)
    val appointments: List<PetAppointment> = mutableListOf(),
    @OneToMany(mappedBy = "pet", cascade = [(CascadeType.ALL)], orphanRemoval = true)
    val petImages: List<PetImage> = mutableListOf(),
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    val createdBy: User
)