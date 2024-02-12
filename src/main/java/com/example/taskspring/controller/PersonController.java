package com.example.taskspring.controller;

import com.example.taskspring.dto.PersonDTO;
import com.example.taskspring.entity.Person;
import com.example.taskspring.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<PersonDTO> getPerson(@PathVariable long id){
        return ResponseEntity.ok(personService.getPerson(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable long id){
        return ResponseEntity.ok(personService.deletePerson(id));
    }

    @PostMapping("/create")
    public ResponseEntity<String> createPerson(@RequestBody @Valid PersonDTO personDTO){
        return ResponseEntity.ok(personService.createPerson(personDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<String> updatePerson(@RequestBody Person personDTO){
        return ResponseEntity.ok(personService.updatePerson(personDTO));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PersonDTO>> getPersons(){
        return ResponseEntity.ok(personService.getPersons());
    }


}
