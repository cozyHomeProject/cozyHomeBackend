package github.io.ch.repositories

import github.io.ch.entities.MealPlan
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface MealPlanRepository : CrudRepository<MealPlan, Long> {
    /** GET /mealPlans/search/findByWeek?week=20261115 */
    fun findByWeek(@Param("week") week: Long): List<MealPlan>
}
