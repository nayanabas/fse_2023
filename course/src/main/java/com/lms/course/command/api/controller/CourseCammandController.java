package com.lms.course.command.api.controller;

import com.lms.course.command.api.command.CreateCourseCommand;
import com.lms.course.command.api.command.RemoveCourseCommand;
import com.lms.course.command.api.model.CourseRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("api/v1.0/lms/courses")
public class CourseCammandController {
    private CommandGateway commandGateway;

    public CourseCammandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping
    public String addCourse(@RequestBody CourseRestModel courseRestModel){

        CreateCourseCommand createCourseCommand =
                CreateCourseCommand.builder()
                .courseId(UUID.randomUUID().toString())
                .name(courseRestModel.getName())
                .description(courseRestModel.getDescription())
                .duration(courseRestModel.getDuration())
                .technology(courseRestModel.getTechnology())
                .build();
       String result =  commandGateway.sendAndWait(createCourseCommand);
        return result;
    }

    @DeleteMapping("/{courseId}")
    public CompletableFuture<Object> removeCourse(@PathVariable String courseId){

       RemoveCourseCommand removeCourseCommand = new RemoveCourseCommand(courseId);

        return commandGateway.send(removeCourseCommand);

    }
}
