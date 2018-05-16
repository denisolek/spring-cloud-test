package com.denisolek.authorizationservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class AuthorizationServiceApplication

fun main(args: Array<String>) {
    runApplication<AuthorizationServiceApplication>(*args)
}

val users = listOf(
    User(1, "First user"),
    User(2, "Second user"),
    User(3, "Third user"),
    User(4, "Fourth user")
)

@RestController
class PhysioController {

    @GetMapping(value = "/authorization/v1/users")
    fun getDoctors(): List<User> {
        return users
    }

    @GetMapping(value = "/authorization/v1/users/{userId}/to-patient")
    fun userToPatient(@PathVariable("userId") id: String) {

    }
}

class User(
    val id: Int,
    val name: String
)
