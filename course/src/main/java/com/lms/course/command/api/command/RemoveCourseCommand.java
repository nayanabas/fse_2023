package com.lms.course.command.api.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
@ToString
public class RemoveCourseCommand {

    @TargetAggregateIdentifier
    private String courseId;
}
