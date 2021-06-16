package com.javabrains.apicourseyt.course;

import com.javabrains.apicourseyt.topic.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.GET)
    public List<Course> getAllCourses(@PathVariable String topicId){
        return courseService.getAllCoursesByTopicId(topicId);
    }

    @RequestMapping("/courses/{id}")
    public Course getCourse(@PathVariable String id){
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@RequestBody Course course, @PathVariable String topicId){
        course.setTopic(new Topic(topicId, "", ""));
        courseService.addTopic(course);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.PUT)
    public void updateTopicTopic(@PathVariable String id, @RequestBody Course course){
         courseService.updateTopic(course);
    }

    @RequestMapping(value = "/courses/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id){
        courseService.deleteTopic(id);
    }

}