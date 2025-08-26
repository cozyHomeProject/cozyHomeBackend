package github.io.ch.repositories

import github.io.ch.entities.Grocery
import org.springframework.data.repository.CrudRepository

interface GroceryRepository : CrudRepository<Grocery, Long> {
}