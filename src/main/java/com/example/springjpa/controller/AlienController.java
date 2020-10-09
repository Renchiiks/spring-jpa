package com.example.springjpa.controller;

import com.example.springjpa.entities.Alien;
import com.example.springjpa.repository.AlienRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
public class AlienController {

    private AlienRepository alienRepository;

    public AlienController(AlienRepository alienRepository) {
        this.alienRepository = alienRepository;
    }

    @RequestMapping("/")
    public String home() {
        return "alien/home";
    }

    //    @RequestMapping("/addAlien")
//    public String addAlien(Alien alien) {
//        alienRepository.save(alien);
//
//        return "alien/home";
//    }
    @PostMapping("/alien")
    public Alien addAlien(@RequestBody Alien alien) {
        alienRepository.save(alien);

        return alien;
    }

    @PutMapping ("/alien")
    public Alien saveOrUpdateAlien(@RequestBody Alien alien) {
        alienRepository.save(alien);

        return alien;
    }

    @RequestMapping("/getAlien")
    public ModelAndView getAlien(@RequestParam Long id) {

        ModelAndView modelAndView = new ModelAndView("alien/showAlien");
        Alien alien = alienRepository.findById(id).orElse(new Alien());

//        System.out.println(alienRepository.findByIdGreaterThan(5L));
//        System.out.println(alienRepository.findByTech("Java"));
//        System.out.println(alienRepository.findByTechSorted("Java"));


        modelAndView.addObject(alien);
        return modelAndView;
    }

    @RequestMapping("/aliens")
    // @ResponseBody
    public List<Alien> getAliens() {

        return alienRepository.findAll();
    }

    @RequestMapping("/alien/{id}")
    //@ResponseBody
    public Optional<Alien> getAliens(@PathVariable("id") Long id) {

        return alienRepository.findById(id);
    }

    @DeleteMapping("/alien/{id}")
    public String deleteAlien(@PathVariable("id") Long id) {
        Alien alien = alienRepository.getOne(id);
        alienRepository.delete(alien);
        return "deleted";
    }


}
