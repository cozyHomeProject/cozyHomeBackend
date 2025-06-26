package github.io.ch.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "task")
data class Task(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    @ManyToOne
    @JoinColumn(name = "task_list_id", nullable = false)
    val taskList: TaskList,
    val name: String,
    val description: String,
    val frequency: String,
    /**
     * TODO: move this to a taskListItem
     */
    @ManyToOne
    @JoinColumn(name = "assignee_id", nullable = true)
    var assignee: User? = null,
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = true)
    val createdBy: User
)