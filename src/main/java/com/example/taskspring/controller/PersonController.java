package com.example.taskspring.controller;

import com.example.taskspring.dto.PersonDTO;
import com.example.taskspring.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable long id){
        return personService.getPerson(id);
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable long id){
        return personService.deletePerson(id);
    }

    @PostMapping("/create")
    public String createPerson(@RequestBody @Valid PersonDTO personDTO){
        return personService.createPerson(personDTO);
    }

    @PutMapping("/update")
    public String updatePerson(@RequestBody PersonDTO personDTO){
        return personService.updatePerson(personDTO);
    }

    @GetMapping("/all")
    public List<PersonDTO> getPersons(){
        return personService.getPersons();
    }


}
