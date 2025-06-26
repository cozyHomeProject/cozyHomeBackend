package github.io.ch.repositories

import github.io.ch.entities.GroceryList
import org.springframework.data.repository.CrudRepository

interface GroceryListRepository : CrudRepository<GroceryList, Long> {
}