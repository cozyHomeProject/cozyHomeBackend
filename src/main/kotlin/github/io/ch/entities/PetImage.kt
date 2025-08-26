package github.io.ch.entities

import jakarta.persistence.*

@Entity
@Table(name = "pet_images")
data class PetImage(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    @ManyToOne
    @JoinColumn(name = "pet_id", nullable = false)
    val pet: Pet,
    val imageUrl: String,
    @ManyToOne
    @JoinColumn(name = "ordered_by_id", nullable = false)
    val createdBy: User
)
