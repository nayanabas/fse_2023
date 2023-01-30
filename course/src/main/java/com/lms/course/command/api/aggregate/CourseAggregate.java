package com.lms.course.command.api.aggregate;

import com.lms.course.command.api.command.CreateCourseCommand;
import com.lms.course.command.api.command.RemoveCourseCommand;
import com.lms.course.command.api.events.CourseCreatedEvent;
import com.lms.course.command.api.events.CourseRemovedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Lazy;

@Aggregate
public class CourseAggregate {

    @AggregateIdentifier
    private String courseId;
    private String name;

    private String description;

    private String technology;

    private int duration;

    @CommandHandler
    public CourseAggregate(CreateCourseCommand createCourseCommand) {

        CourseCreatedEvent courseCreatedEvent = new CourseCreatedEvent();

        BeanUtils.copyProperties(createCourseCommand, courseCreatedEvent);

        AggregateLifecycle.apply(courseCreatedEvent);

    }
    public CourseAggregate() {

    }

    @CommandHandler
    public void handle(RemoveCourseCommand removeCourseCommand){
        CourseRemovedEvent removedEvent = new CourseRemovedEvent();
        BeanUtils.copyProperties(removeCourseCommand, removedEvent);
        AggregateLifecycle.apply(removedEvent);

    }

    @EventSourcingHandler
    public void on(CourseRemovedEvent removedEvent){
      System.out.println("Item removed event");
    }

    @EventSourcingHandler
    public void on(CourseCreatedEvent courseCreatedEvent){
        this.courseId = courseCreatedEvent.getCourseId();
        this.description = courseCreatedEvent.getDescription();
        this.duration = courseCreatedEvent.getDuration();
        this.name = courseCreatedEvent.getName();
        this.technology = courseCreatedEvent.getTechnology();
    }
}
