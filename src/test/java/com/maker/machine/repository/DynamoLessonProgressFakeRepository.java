package com.maker.machine.repository;

import com.maker.machine.app.repository.LessonProgressRepository;
import com.maker.machine.core.domain.LessonProgress;
import com.maker.machine.core.domain.Task;
import com.maker.machine.core.domain.TaskProgress;
import com.maker.machine.core.enums.Status;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DynamoLessonProgressFakeRepository implements LessonProgressRepository {

    private Set<Task> tasks = Stream.of(
            Task.builder().id(UUID.randomUUID()).build(),
            Task.builder().id(UUID.randomUUID()).build(),
            Task.builder().id(UUID.randomUUID()).build()
    ).collect(Collectors.toSet());

    @Override
    public Set<Task> findByMachineAndLesson(UUID lessonId, UUID machineId) {
        return tasks;
    }

    @Override
    public LessonProgress save(LessonProgress lessonProgress) {
        return lessonProgress;
    }

    @Override
    public LessonProgress findById(UUID id) {
        Task task = tasks.stream().collect(Collectors.toList()).get(0);
        task.setId(id);
        return LessonProgress.builder()
                .id(id)
                .taskProgress(Stream.of(
                        TaskProgress.builder()
                                .id(id)
                                .task(task).build()).collect(Collectors.toSet()))
                .status(Status.IN_PROGRESS)
                .build();
    }

}
