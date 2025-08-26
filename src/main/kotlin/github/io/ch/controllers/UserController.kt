package github.io.ch.controllers

import github.io.ch.entities.User
import github.io.ch.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/api/users"], produces = ["application/json"])
class UserController(@Autowired private val usersRepository: UserRepository) {

    @GetMapping("")
    fun getUsers(): List<User> = usersRepository.findAll().toList();

    @PostMapping("")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        usersRepository.save(user)
        return ResponseEntity.ok(user)
    };

    @GetMapping("/{username}")
    fun getUserByUsername(@PathVariable username: String): ResponseEntity<User> {
        val user = usersRepository.findByUsername(username);
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}