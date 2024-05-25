package com.itvedant.courseregistration.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.courseregistration.entity.Course;
import com.itvedant.courseregistration.repository.CourseRepository;


@Service
public class CourseService {
    
    @Autowired
    private CourseRepository repo;
    
    public List<Course> listAll() {
        return repo.findAll();
    }
     
    public void save(Course std) {
        repo.save(std);
    }
     
    public Course get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
