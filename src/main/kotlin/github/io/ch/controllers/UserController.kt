package github.io.ch.controllers

import github.io.ch.entities.User
import github.io.ch.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping(path = ["/api/users"])
class UserController(@Autowired private val userService: UserService) {

    @GetMapping("")
    fun getUsers(): List<User> = userService.findAll();

    @PostMapping("")
    fun createUser(@RequestBody user: User): ResponseEntity<User> {
        return ResponseEntity.ok(userService.create(user));
    };

    @GetMapping("/{username}")
    fun getUserByUsername(@PathVariable username: String): ResponseEntity<User> {
        return ResponseEntity.ok(userService.findByUsername(username));
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<User> {
        return ResponseEntity.ok(userService.findById(id))
    }
    @DeleteMapping("/{username}")
    fun deleteUserByUsername(@PathVariable username: String): ResponseEntity<Void> {
        try {
            userService.deleteByUsername(username);
            return ResponseEntity.ok().build();
        } catch (ex: Exception) {
            return ResponseEntity.internalServerError().build();
        };
    }
}