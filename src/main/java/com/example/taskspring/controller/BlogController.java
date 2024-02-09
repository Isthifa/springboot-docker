package com.example.taskspring.controller;

import com.example.taskspring.entity.Blog;
import com.example.taskspring.services.PersonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    private final PersonService personService;

    public BlogController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Blog getBlog(@PathVariable int id){
        return personService.getBlogPerson(id);
    }

    @GetMapping("/all")
    public List<Blog> getBlogs(){
        return personService.getBlogsPerson();
    }

    @PostMapping("/create")
    public Blog addBlog(@RequestBody Blog blogDTO){
        return personService.addBlogPerson(blogDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteBlog(@PathVariable int id){
        return personService.deleteBlogPerson(id);
    }

    @PutMapping("/{id}")
    public String updateBlog(@RequestBody Blog blogDTO){
        return personService.updateBlogPerson(blogDTO);
    }
}
