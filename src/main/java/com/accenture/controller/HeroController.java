package com.accenture.controller;

import com.accenture.dao.HeroDAO;
import com.accenture.model.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "heroes")
@CrossOrigin(origins = "http://localhost:4200")
public class HeroController {
    @Autowired
    private HeroDAO dao;

/*    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }*/

    @GetMapping
    public Iterable<Hero> getAll(){
        return dao.findAll();
        // return heroes;
    }

    @GetMapping(value = "/{id}")
    public Hero getOne(@PathVariable("id") Integer id){
        Optional<Hero> hero = dao.findById(id);
        return hero.orElse(null);
        // return heroes;
    }

    @PostMapping
    public Hero save(@RequestBody Hero hero){
        return dao.save(hero);//TODO fix
    }

    @PutMapping
    public Hero update(@RequestBody Hero hero){
       return save(hero);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") Integer id){
        dao.deleteById(id);
    }

    @GetMapping(value = "/search")
    public List<Hero> search(@RequestParam("text")String text){
        return dao.search(text);
    }
}
