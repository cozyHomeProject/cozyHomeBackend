package github.io.ch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CozyHomeBackendApplication

fun main(args: Array<String>) {
	runApplication<CozyHomeBackendApplication>(*args)
}
