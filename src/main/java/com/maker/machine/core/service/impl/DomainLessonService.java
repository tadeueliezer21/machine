package com.maker.machine.core.service.impl;

import com.maker.machine.app.dto.LessonDTO;
import com.maker.machine.app.repository.LessonRepository;
import com.maker.machine.core.domain.Lesson;
import com.maker.machine.core.event.CreateTaskEvent;
import com.maker.machine.core.service.LessonService;
import org.springframework.context.ApplicationEventPublisher;

public class DomainLessonService implements LessonService {
    private LessonRepository lessonRepository;

    private ApplicationEventPublisher publisher;
    public DomainLessonService(LessonRepository lessonRepository, ApplicationEventPublisher publisher) {
        this.lessonRepository = lessonRepository;
        this.publisher = publisher;
    }

    @Override
    public Lesson create(LessonDTO lessonDTO) {

        Lesson lesson = Lesson.createFrom(lessonDTO);

        publisher.publishEvent(new CreateTaskEvent(lesson, lessonDTO.getTasks()));

        return lessonRepository.save(lesson);

    }
}