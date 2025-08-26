package github.io.ch.repositories

import github.io.ch.entities.MealPlan
import org.springframework.data.repository.CrudRepository

interface MealPlanRepository : CrudRepository<MealPlan, Long> {
}