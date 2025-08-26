package github.io.ch.repositories

import github.io.ch.entities.Pet
import org.springframework.data.repository.CrudRepository

interface PetRepository : CrudRepository<Pet, Long> {
}