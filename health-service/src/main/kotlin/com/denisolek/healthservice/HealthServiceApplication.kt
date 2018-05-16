package com.denisolek.healthservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class HealthServiceApplication

fun main(args: Array<String>) {
    runApplication<HealthServiceApplication>(*args)
}

val patients = listOf(
    Patient(3, "First patient"),
    Patient(4, "Second patient")
)

val doctors = listOf(
    Physio(1, "First physio"),
    Physio(2, "Second physio")
)

@RestController
class PhysioController {

    @GetMapping(value = "/physio/v1/doctors")
    fun getDoctors(): List<Physio> {
        return doctors
    }
}

@RestController
class PatientController {

    @GetMapping(value = "/patient/v1/patients")
    fun getPatients(): List<Patient> {
        return patients
    }
}

@RestController
class HealthController {

    @GetMapping(value = "/health/v1/patients/{patientId}")
    fun findPatient(@PathVariable("patientId") id: String): Patient {
        return patients.first { it.id == id.toInt()}
    }
}

class Physio(
    val id: Int,
    val name: String
)

class Patient(
    val id: Int,
    val name: String
)