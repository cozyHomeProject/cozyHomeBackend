package github.io.ch.entities

import org.springframework.beans.factory.annotation.Value
import org.springframework.data.rest.core.config.Projection
import java.time.LocalDate
import java.time.LocalDateTime

// Proyecciones de Spring Data REST: se piden con ?projection=detail y traen
// los datos de las relaciones en la misma respuesta, sin un pedido extra por fila.

@Projection(name = "detail", types = [GroceryListItem::class])
interface GroceryListItemDetail {
    val id: Long
    val amount: String
    val lastOrderedAt: LocalDateTime?

    @get:Value("#{target.grocery.name}")
    val groceryName: String

    @get:Value("#{target.grocery.measureUnit}")
    val measureUnit: String
}

@Projection(name = "detail", types = [Task::class])
interface TaskDetail {
    val id: Long
    val name: String
    val lastDoneAt: LocalDateTime?

    @get:Value("#{target.assignee?.username}")
    val assigneeUsername: String?
}

@Projection(name = "detail", types = [MealPlanItem::class])
interface MealPlanItemDetail {
    val id: Long
    val mealType: String
    val day: LocalDate?

    @get:Value("#{target.meal.name}")
    val mealName: String
}
