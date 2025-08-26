package github.io.ch.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "task_list")
data class TaskList(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long = 0,
    val name: String,
    val description: String,
    @OneToMany(mappedBy = "taskList", cascade = [CascadeType.ALL], orphanRemoval = true)
    val tasks: List<Task> = mutableListOf(),
    val closed: Boolean,
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    val createdBy: User
)