package com.maker.machine.core.service.impl;

import com.maker.machine.app.dto.TaskDTO;
import com.maker.machine.app.repository.TaskRepository;
import com.maker.machine.core.domain.Lesson;
import com.maker.machine.core.domain.Task;
import com.maker.machine.core.service.TaskService;

import java.util.Set;
import java.util.stream.Collectors;

public class DomainTaskService implements TaskService {

    private TaskRepository taskRepository;

    public DomainTaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Set<Task> create(Lesson lesson, Set<TaskDTO> tasks) {

        Set<Task> tasksCreated = tasks.stream()
                .map(task -> Task.createFrom(task, lesson))
                .collect(Collectors.toSet());

        return taskRepository.saveAll(tasksCreated);
    }
}
