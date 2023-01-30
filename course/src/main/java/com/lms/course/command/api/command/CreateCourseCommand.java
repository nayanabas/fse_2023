package com.lms.course.command.api.command;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateCourseCommand {

    @TargetAggregateIdentifier
    private String courseId;
    private String name;

    private String description;

    private String technology;

    private int duration;
}
