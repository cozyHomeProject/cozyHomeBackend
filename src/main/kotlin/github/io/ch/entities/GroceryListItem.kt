package github.io.ch.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity
@Table(name = "grocery_list_items")
data class GroceryListItem(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    @ManyToOne
    @JoinColumn(name = "grocery_list_id", nullable = false)
    val groceryList: GroceryList,
    @ManyToOne
    @JoinColumn(name = "grocery_id", nullable = false)
    val grocery: Grocery,
    val amount: String,
    val lastOrderedAt: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "ordered_by_id", nullable = false)
    val orderedBy: User
)