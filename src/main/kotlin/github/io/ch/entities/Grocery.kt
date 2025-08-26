package github.io.ch.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "groceries")
data class Grocery(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    val name: String,
    val buyableAt: String? = null,
    val measureUnit: String,
    val createdAt: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    val createdBy: User
)