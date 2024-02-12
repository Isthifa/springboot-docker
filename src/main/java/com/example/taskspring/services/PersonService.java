package com.example.taskspring.services;

import com.example.taskspring.dto.PersonDTO;
import com.example.taskspring.entity.Blog;
import com.example.taskspring.entity.Person;

import java.util.List;

public interface PersonService {

    String createPerson(PersonDTO personDTO);

    String updatePerson(Person person);

    String deletePerson(long id);

    PersonDTO getPerson(long id);

    List<PersonDTO> getPersons();

    Blog addBlogPerson(Blog blogDTO);

    String deleteBlogPerson(int id);

    Blog getBlogPerson(int id);

    List<Blog> getBlogsPerson();

    String updateBlogPerson(Blog blogDTO);

}
