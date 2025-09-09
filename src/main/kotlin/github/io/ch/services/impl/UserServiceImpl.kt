package github.io.ch.services.impl

import github.io.ch.entities.User
import github.io.ch.repositories.UserRepository
import github.io.ch.services.UserService
import kotlin.jvm.optionals.getOrNull

class UserServiceImpl(private val userRepository: UserRepository) : UserService {

    override fun findAll(): List<User> {
        return userRepository.findAll().toList();
    }

    override fun create(user: User): User {
        TODO("Encryption not implemented")
        return userRepository.save(user);
    }

    override fun findByUsername(username: String): User? {
        return userRepository.findByUsername(username);
    }

    override fun findById(id: Long): User? {
        return userRepository.findById(id).map { user -> user }.getOrNull();
    }

    override fun findByUsernameAndPassword(
        username: String,
        password: String
    ): User? {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    override fun findByEmail(email: String): User? {
        return userRepository.findByEmail(email);
    }

    override fun deleteByUsername(username: String) {
        this.findByUsername(username)?.let { userRepository.delete(it) };
    }
}