package com.maker.machine.app.repository.impl;

import com.maker.machine.app.repository.LessonProgressRepository;
import com.maker.machine.core.domain.LessonProgress;
import com.maker.machine.core.domain.Task;

import java.util.Set;
import java.util.UUID;

public class DynamoLessonProgressRepository implements LessonProgressRepository {

    @Override
    public Set<Task> findByMachineAndLesson(UUID lessonId, UUID machineId) {
        return null;
    }

    @Override
    public LessonProgress save(LessonProgress lessonProgress) {
        return null;
    }

    @Override
    public LessonProgress findById(UUID id) {
        return null;
    }

}
