package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin("*")
@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {
    private  Map<Integer, Animal> animals;

    @PostConstruct
    public void initialValuesLoad(){
        this.animals = new HashMap<>();
        animals.put(11, new Animal(11,"Köpek"));
        animals.put(22, new Animal(22,"Kedi"));
        animals.put(33, new Animal(33,"Papağan"));
        animals.put(44, new Animal(44,"Timsah"));
        animals.put(55, new Animal(55,"Kaplan"));
    }

    @GetMapping
    public List<Animal> getAnimals() {

        List<Animal> listOfValues = new ArrayList<>(animals.values());

        return listOfValues;
    }

    @GetMapping("/{id}")
    public Animal isContainedAnimal(@PathVariable int id){
        if(this.animals.containsKey(id)){

            return this.animals.get(id);

        }
        return null;
    }

    @PostMapping
    public Animal createAnimal(@RequestBody Animal animal){

        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable int id, @RequestBody Animal animal){
       if(animals.containsKey(id)){
           animals.replace(id, animal);
           return animal;
       }
        return null;
    }

    @DeleteMapping("/{id}")
    public Animal deleteAnimal(@PathVariable int id){
        if(animals.containsKey(id)){
            return animals.remove(id);

        }
        return null;
    }
}
