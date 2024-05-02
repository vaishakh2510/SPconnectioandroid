package com.ani.rest.crud

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RequestMapping("/simple")
@RestController
class SimpleController {

    private val app : App = App(id = "00000", cnt = 0)

    @GetMapping
    fun show(): ResponseEntity<App> {
        println("-------> Client requested this method")
        return  ResponseEntity.ok(app)
    }

    @PostMapping
    fun create(@RequestBody app: App) : ResponseEntity<String> {

        val (id, cnt) = app
//        this.app.id = app.id
//        this.app.cnt = app.cnt

        this.app.id = id
        this.app.cnt =cnt

        return ResponseEntity.ok(id)
    }

}