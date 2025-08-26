package github.io.ch.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "meal_plans")
data class MealPlan(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long,
    val week: Long,
    @OneToMany(mappedBy = "mealPlan", cascade = [CascadeType.ALL], orphanRemoval = true)
    val mealPlanItems: List<MealPlanItem> = mutableListOf(),
    val createdAt: LocalDateTime,
    val modifiedAt: LocalDateTime,
    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    val createdBy: User

)