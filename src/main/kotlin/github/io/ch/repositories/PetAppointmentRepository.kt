package github.io.ch.repositories

import github.io.ch.entities.PetAppointment
import org.springframework.data.repository.CrudRepository

interface PetAppointmentRepository : CrudRepository<PetAppointment, Long> {
}