package com.javabrains.apicourseyt.course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCoursesByTopicId(String id){
        List<Course> courses = new ArrayList<>();
        courseRepository.findByTopicId(id).forEach( courses:: add);
        return courses;
    }

    public Course getCourse(String id){
        return courseRepository.findById(id).get();
    }

    public void addTopic(Course course){
        courseRepository.save(course);
    }

    public void updateTopic(Course course){
        courseRepository.save(course);
    }

    public void deleteTopic(String id){ courseRepository.deleteById(id); }
}
