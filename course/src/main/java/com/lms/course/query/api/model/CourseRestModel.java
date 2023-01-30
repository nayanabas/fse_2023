package com.lms.course.query.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseRestModel {

    private String courseId;

    private String name;

    private String description;

    private String technology;

    private int duration;
}
