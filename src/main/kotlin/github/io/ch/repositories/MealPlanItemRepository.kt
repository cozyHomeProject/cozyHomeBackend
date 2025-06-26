package github.io.ch.repositories

import github.io.ch.entities.MealPlanItem
import org.springframework.data.repository.CrudRepository

interface MealPlanItemRepository : CrudRepository<MealPlanItem, Long> {
}