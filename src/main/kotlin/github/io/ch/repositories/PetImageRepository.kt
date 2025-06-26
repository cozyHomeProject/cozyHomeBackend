package github.io.ch.repositories

import github.io.ch.entities.PetImage
import org.springframework.data.repository.CrudRepository

interface PetImageRepository : CrudRepository<PetImage, Long> {
}