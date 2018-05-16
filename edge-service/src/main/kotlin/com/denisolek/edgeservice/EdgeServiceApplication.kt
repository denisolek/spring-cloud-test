package com.denisolek.edgeservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EdgeServiceApplication

fun main(args: Array<String>) {
    runApplication<EdgeServiceApplication>(*args)
}