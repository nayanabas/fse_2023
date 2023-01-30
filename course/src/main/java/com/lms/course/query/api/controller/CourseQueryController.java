package com.lms.course.query.api.controller;

import com.lms.course.query.api.model.CourseRestModel;
import com.lms.course.query.api.queries.GetCourseByIDQuery;
import com.lms.course.query.api.queries.GetCourseQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1.0/lms/courses")
public class CourseQueryController {

    private QueryGateway queryGateway;

    public CourseQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<CourseRestModel> getAllCourse(){


      //  GetCourseQuery getCourseQuery = ;

        List<CourseRestModel> courseRestModels = null;
        try {
            courseRestModels =
                    queryGateway.query(new GetCourseQuery(), ResponseTypes.multipleInstancesOf(CourseRestModel.class)).get();
        }catch (Exception e){
            e.printStackTrace();
        }


        
        return courseRestModels ;
    }
    @GetMapping("/{courseId}")
    public List<CourseRestModel> getCourseByID(@PathVariable String courseId){
        List<CourseRestModel> courseRestModels = null;

        try{
            courseRestModels =
                    queryGateway.query(new GetCourseByIDQuery(courseId), ResponseTypes.multipleInstancesOf(CourseRestModel.class)).get();

        }catch (Exception e){
            e.printStackTrace();
        }

return courseRestModels;

    }
    
}
