package com.maker.machine.core.service.impl;

import com.maker.machine.app.dto.LessonProgressDTO;
import com.maker.machine.app.repository.LessonProgressRepository;
import com.maker.machine.core.domain.LessonProgress;
import com.maker.machine.core.domain.Task;
import com.maker.machine.core.domain.TaskProgress;
import com.maker.machine.core.exception.LessonNotFoundException;
import com.maker.machine.core.exception.TaskNotFoundException;
import com.maker.machine.core.service.LessonProgressService;

import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class DomainLessonProgressService implements LessonProgressService {

    private LessonProgressRepository lessonProgressRepository;

    public DomainLessonProgressService(LessonProgressRepository lessonProgressRepository) {
        this.lessonProgressRepository = lessonProgressRepository;
    }

    public LessonProgress create(UUID lessonId, UUID machineId) {

        Set<Task> tasks = lessonProgressRepository.findByMachineAndLesson(lessonId, machineId);

        if(Objects.isNull(tasks)) {
            throw new TaskNotFoundException("Tasks not found to this lesson and machine");
        }

        Set<TaskProgress> taskProgress = tasks.stream().map(TaskProgress::create).collect(Collectors.toSet());


        return lessonProgressRepository.save(LessonProgress.create(taskProgress));

    }

    public LessonProgress updateTaskWithDone(LessonProgressDTO dto) {

        if(Objects.isNull(dto.getLessonId())) {
            throw new LessonNotFoundException("Lesson not found");
        }

        LessonProgress lessonProgress = lessonProgressRepository.findById(dto.getLessonId());

        lessonProgress.updateTasksWithDone(dto.getTasksId());
        lessonProgress.lessonDone();

        return lessonProgressRepository.save(lessonProgress);
    }

}
