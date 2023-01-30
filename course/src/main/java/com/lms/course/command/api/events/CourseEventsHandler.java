package com.lms.course.command.api.events;

import com.lms.course.command.api.data.Course;
import com.lms.course.command.api.data.CourseRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("course")
public class CourseEventsHandler {


    @Autowired
    private CourseRepository courseRepository;



    public CourseEventsHandler( ){
    }

    @EventHandler
    public void on( CourseCreatedEvent event){

        Course course = new Course();

        try{
            BeanUtils.copyProperties(event, course);
            System.out.println("save----------------"+course.toString());
            courseRepository.save(course);
            System.out.println("saved----------------");
        }catch(Exception e){
            e.printStackTrace();
        }


    }
    @EventHandler
    public void on( CourseRemovedEvent event){

        try{

            System.out.println("save----------------"+event.toString());
            courseRepository.deleteById(event.getCourseId());
            System.out.println("saved----------------");
        }catch(Exception e){
            e.printStackTrace();
        }


    }
}
