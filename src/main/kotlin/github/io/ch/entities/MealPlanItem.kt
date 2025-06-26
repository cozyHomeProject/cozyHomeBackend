package github.io.ch.entities

import jakarta.persistence.*

@Entity
@Table(name = "meal_plan_items")
data class MealPlanItem(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Int,
    @ManyToOne
    @JoinColumn(name = "meal_plan_id", nullable = false)
    val mealPlan: MealPlan,
    val mealType: String,
    @ManyToOne
    @JoinColumn(name = "meal_id", nullable = false)
    val meal: Meal
)