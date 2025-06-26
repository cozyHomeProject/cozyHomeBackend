package github.io.ch.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "meals")
data class Meal(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    val name: String,
    val recipe: String? = null,
    val recipeUrl: String? = null,
    val createdAt: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    val createdBy: User
)
