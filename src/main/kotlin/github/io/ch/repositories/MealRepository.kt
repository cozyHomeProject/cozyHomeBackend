package github.io.ch.repositories

import github.io.ch.entities.Meal
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param

interface MealRepository : CrudRepository<Meal, Long> {
    /** GET /meals/search/findFirstByNameIgnoreCase?name=Tarta (404 si no existe) */
    fun findFirstByNameIgnoreCase(@Param("name") name: String): Meal?
}
