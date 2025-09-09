package github.io.ch.services

import github.io.ch.entities.User
import org.springframework.stereotype.Service

@Service
interface UserService {
    fun findAll(): List<User>;
    fun create(user: User): User;
    fun findByUsername(username: String): User?;
    fun findById(id: Long): User?;
    fun findByUsernameAndPassword(username: String, password: String): User?;
    fun findByEmail(email: String): User?;
    fun deleteByUsername(username: String);
}