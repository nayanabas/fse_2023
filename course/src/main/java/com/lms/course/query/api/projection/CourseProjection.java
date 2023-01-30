package com.lms.course.query.api.projection;

import com.lms.course.command.api.data.Course;
import com.lms.course.command.api.data.CourseRepository;
import com.lms.course.query.api.model.CourseRestModel;
import com.lms.course.query.api.queries.GetCourseByIDQuery;
import com.lms.course.query.api.queries.GetCourseQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class CourseProjection {

    @Autowired
    private CourseRepository courseRepository;

    @QueryHandler
    public List<CourseRestModel> handle(GetCourseQuery getCourseQuery){

        List<Course> courses = (List<Course>) courseRepository.findAll();

        List<CourseRestModel> courseRestModels = courses.stream().
                map(course ->
                   CourseRestModel
                           .builder()
                            .courseId(course.getCourseId())
                            .name(course.getName())
                            .description(course.getDescription())
                            .duration(course.getDuration())
                            .technology(course.getTechnology())
                            .build()).collect(Collectors.toList());

        System.out.println(courseRestModels.toString());
        return courseRestModels;
    }
    @QueryHandler
    public List<CourseRestModel> handle(GetCourseByIDQuery getCourseQuery){

        Optional<Course> courses;
        courses = courseRepository.findById(getCourseQuery.getCourseId());

        List<CourseRestModel> courseRestModels = courses.stream().
                map(course ->
                        CourseRestModel
                                .builder()
                                .courseId(course.getCourseId())
                                .name(course.getName())
                                .description(course.getDescription())
                                .duration(course.getDuration())
                                .technology(course.getTechnology())
                                .build()).collect(Collectors.toList());

        System.out.println(courseRestModels.toString());
        return courseRestModels;
    }
}
