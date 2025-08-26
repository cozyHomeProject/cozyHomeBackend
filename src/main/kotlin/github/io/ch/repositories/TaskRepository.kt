package github.io.ch.repositories

import github.io.ch.entities.Task
import org.springframework.data.repository.CrudRepository

interface TaskRepository : CrudRepository<Task, Long> {
}