package com.ani.rest.crud
import org.springframework.http.HttpRange
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin
@RequestMapping("/simple")
@RestController
class SimpleController {

    private val app : App = App(id = "00000", cnt = 0)

    private val apps: ArrayList<App> = arrayListOf(
        App(id="#0003", 25),
        App(id="#0004", 35),
        App(id="#0005", 20),
        App(id="#0006", 50),
        App(id="#0007", 45),
        App(id="#0008", 15),
        App(id="#0009", 28),
        App(id="#0010", 32),
        App(id="#0011", 38),
        App(id="#0012", 42),
        App(id="#0013", 27),
        App(id="#0014", 39),
        App(id="#0015", 48),
        App(id="#0016", 21),
        App(id="#0017", 36),
        App(id="#0018", 29),
        App(id="#0019", 31),
        App(id="#0020", 33),
        App(id="#0021", 37),
        App(id="#0022", 43)
    )


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


    @PostMapping("/app")
    fun createApp(@RequestBody app : App):ResponseEntity<String> {
        println(app)
        apps.add(app)
        return  ResponseEntity.ok(app.id)
    }

    @DeleteMapping("/app/{id}")
    fun deleteApp(@PathVariable id :String): ResponseEntity<Boolean> {
//        apps.removeIf (fun (el : App) : Boolean {
//            return el.id == id
//        })
//        apps.removeIf ( { el -> el.id == id })
//        apps.removeIf  { el -> el.id == id }

        val sts = apps.removeIf { it.id == id }
        return ResponseEntity(sts, HttpStatus.ACCEPTED)
    }

    @PutMapping("/app")
    fun updateApp(@RequestBody app: App): ResponseEntity<String> {
        val ind = apps.indexOf(app)
        println(app.toString())
        println("Index is $ind")
//        apps.set(ind, app);
        apps[ind] = app;
        return ResponseEntity(app.id, HttpStatus.CREATED)
    }

    @GetMapping("/app")
    fun showApps(): ResponseEntity<List<App>> {
        return ResponseEntity(apps, HttpStatus.OK)
    }
}