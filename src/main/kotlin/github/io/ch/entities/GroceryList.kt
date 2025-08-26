package github.io.ch.entities

import jakarta.persistence.CascadeType
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "grocery_lists")
data class GroceryList(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    val closed: Boolean,
    @OneToMany(mappedBy = "groceryList", cascade = [CascadeType.ALL], orphanRemoval = true)
    val groceryListItems: List<GroceryListItem> = mutableListOf(),
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    val createdBy: User
)