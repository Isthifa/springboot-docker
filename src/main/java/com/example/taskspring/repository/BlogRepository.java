package com.example.taskspring.repository;

import com.example.taskspring.entity.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlogRepository extends MongoRepository<Blog, Integer>{

}
