package github.io.ch.repositories

import github.io.ch.entities.TaskList
import org.springframework.data.repository.CrudRepository

interface TaskListRepository : CrudRepository<TaskList, Long> {
}