package github.io.ch.repositories

import github.io.ch.entities.GroceryListItem
import org.springframework.data.repository.CrudRepository

interface GroceryListItemRepository : CrudRepository<GroceryListItem, Long> {
}