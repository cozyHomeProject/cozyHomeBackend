package github.io.ch.repositories

import github.io.ch.entities.Meal
import org.springframework.data.repository.CrudRepository

interface MealRepository : CrudRepository<Meal, Long> {
}