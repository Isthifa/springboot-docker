package com.example.taskspring.services.impl;

import com.example.taskspring.dto.PersonDTO;
import com.example.taskspring.entity.Blog;
import com.example.taskspring.entity.Person;
import com.example.taskspring.repository.BlogRepository;
import com.example.taskspring.repository.PersonRepository;
import com.example.taskspring.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    private final BlogRepository blogRepository;

    public PersonServiceImpl(PersonRepository personRepository, BlogRepository blogRepository) {
        this.personRepository = personRepository;
        this.blogRepository = blogRepository;
    }

    @Override
    public String createPerson(PersonDTO personDTO) {
        Person person = Person.builder()
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .address(personDTO.getAddress())
                .city(personDTO.getCity())
                .state(personDTO.getState())
                .zip(personDTO.getZip())
                .build();
        personRepository.save(person);
        return "Person created successfully";
    }

    @Override
    public String updatePerson(PersonDTO personDTO) {
        Person person = Person.builder()
                .firstName(personDTO.getFirstName())
                .lastName(personDTO.getLastName())
                .address(personDTO.getAddress())
                .city(personDTO.getCity())
                .state(personDTO.getState())
                .zip(personDTO.getZip())
                .build();
        personRepository.save(person);
        return "Person updated successfully";
    }

    @Override
    public String deletePerson(long id) {
        personRepository.deleteById(id);
        return "Person deleted successfully";
    }

    @Override
    public PersonDTO getPerson(long id) {
        Optional<Person> person=personRepository.findById(id);
        if(person.isPresent()){
            return PersonDTO.builder()
                    .firstName(person.get().getFirstName())
                    .lastName(person.get().getLastName())
                    .address(person.get().getAddress())
                    .city(person.get().getCity())
                    .state(person.get().getState())
                    .zip(person.get().getZip())
                    .build();
        }
        return null;
    }

    @Override
    public List<PersonDTO> getPersons() {
        List<Person> persons=personRepository.findAll();
        return persons.stream().map(person -> PersonDTO.builder()
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .address(person.getAddress())
                .city(person.getCity())
                .state(person.getState())
                .zip(person.getZip())
                .build()).toList();
    }

    @Override
    public Blog addBlogPerson(Blog blogDTO) {
        List<Blog> blog1 =blogRepository.findAll();
        System.out.println(blog1.size());
        Blog blog2 =new Blog();
        blog2.setId(blog1.size()+1);
        blog2.setPersonId(blogDTO.getPersonId());
        return blogRepository.save(blog2);
    }

    @Override
    public String deleteBlogPerson(int id) {
             blogRepository.deleteById(id);
        return "Blog deleted successfully";
    }

    @Override
    public Blog getBlogPerson(int id) {
        Blog blog=blogRepository.findById(id).get();

        return blog;
    }

    @Override
    public List<Blog> getBlogsPerson() {
        List<Blog> blogs=blogRepository.findAll();
        return blogs;
    }

    @Override
    public String updateBlogPerson(Blog blogDTO) {
        Blog blog= blogRepository.findById(blogDTO.getId()).get();
        blog.setPersonId(blogDTO.getPersonId());
        blogRepository.save(blog);
        return "Blog updated successfully";
    }
}
