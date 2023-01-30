package com.lms.course.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CourseCreatedEvent {

    private String courseId;
    private String name;

    private String description;

    private String technology;

    private int duration;
}
