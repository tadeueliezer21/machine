package com.maker.machine.core.service;

import com.maker.machine.app.dto.TaskDTO;
import com.maker.machine.app.repository.impl.DynamoTaskRepository;
import com.maker.machine.core.domain.Lesson;
import com.maker.machine.core.domain.Machine;
import com.maker.machine.core.exception.DescriptionNotFoundInTaskException;
import com.maker.machine.core.service.impl.DomainTaskService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DomainTaskServiceTest {

    @Test
    @DisplayName("Should be able create tasks")
    public void shouldBeAbleCreateTasks() {

        DomainTaskService taskService = new DomainTaskService(new DynamoTaskRepository());

        Lesson lesson = Lesson.builder()
                .name("lesson")
                .description("description")
                .machine(new Machine())
                .build();

        TaskDTO taskDtoOne = TaskDTO.builder()
                .order(1)
                .description("check 1")
                .build();

        TaskDTO taskDtoTwo = TaskDTO.builder()
                .order(2)
                .description("check 2")
                .build();

        Set<TaskDTO> tasks = Stream.of(taskDtoOne, taskDtoTwo).collect(Collectors.toSet());

        Assertions.assertEquals(2, taskService.create(lesson, tasks).size());

    }

    @Test
    @DisplayName("Should not be able create lesson without tasks")
    void shouldNotBeAbleCreateLessonWithoutTask() {

        DomainTaskService taskService = new DomainTaskService(new DynamoTaskRepository());

        Lesson lesson = Lesson.builder()
                .name("lesson")
                .description("description")
                .machine(null)
                .build();

        TaskDTO taskDtoOne = TaskDTO.builder()
                .order(1)
                .description("check 1")
                .build();

        TaskDTO taskDtoTwo = TaskDTO.builder()
                .order(2)
                .description(null)
                .build();

        Set<TaskDTO> tasks = Stream.of(taskDtoOne, taskDtoTwo).collect(Collectors.toSet());

        DescriptionNotFoundInTaskException thrown = Assertions
                .assertThrows(DescriptionNotFoundInTaskException.class,
                        () -> taskService.create(lesson, tasks),
                        "Expected create() to throw");

        Assertions.assertNotNull(thrown);
    }

}
