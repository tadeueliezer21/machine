package com.maker.machine.app.repository.impl;

import com.maker.machine.app.repository.LessonRepository;
import com.maker.machine.core.domain.Lesson;

public class DynamoLessonRepository implements LessonRepository {

    @Override
    public Lesson save(Lesson lesson) {
        return lesson;
    }
}
