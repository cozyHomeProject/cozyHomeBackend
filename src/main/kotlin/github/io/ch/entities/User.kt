package github.io.ch.entities

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    val username: String,
    val email: String,
    val password: String,
    val name: String
)
