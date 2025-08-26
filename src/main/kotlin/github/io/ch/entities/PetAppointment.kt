package github.io.ch.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "pet_appointments")
data class PetAppointment(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    val pet: Pet,
    val title: String,
    val description: String? = null,
    val dueDate: LocalDateTime,
    val frequency: String,
    val finished: Boolean,
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    val createdBy: User,
    val createdAt: LocalDateTime,
)