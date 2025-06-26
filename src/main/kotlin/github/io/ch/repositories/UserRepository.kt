package github.io.ch.repositories

import github.io.ch.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository : CrudRepository<User, Long> {
    fun findByUsername(username: String): User?
    fun findByEmail(email: String): User?
    fun findByUsernameAndPassword(username: String, password: String): User?
    fun findByEmailAndPassword(email: String, password: String): User?
}