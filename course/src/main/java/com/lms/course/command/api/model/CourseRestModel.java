package com.lms.course.command.api.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseRestModel {


    private String name;

    private String description;

    private String technology;

    private int duration;
}
