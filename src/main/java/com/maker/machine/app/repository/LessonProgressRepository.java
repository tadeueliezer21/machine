package com.maker.machine.app.repository;

import com.maker.machine.core.domain.LessonProgress;
import com.maker.machine.core.domain.Task;

import java.util.Set;
import java.util.UUID;

public interface LessonProgressRepository {

    Set<Task> findByMachineAndLesson(UUID lessonId, UUID machineId);

    LessonProgress save(LessonProgress lessonProgress);

    LessonProgress findById(UUID id);

}
