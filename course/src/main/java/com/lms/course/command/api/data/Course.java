package com.lms.course.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Course {
    @Id
    private String courseId;
    private String name;

    private String description;

    private String technology;

    private int duration;
}
