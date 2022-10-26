package com.maker.machine.core.service;

import com.maker.machine.app.dto.LessonDTO;
import com.maker.machine.app.dto.MachineDTO;
import com.maker.machine.app.dto.TaskDTO;
import com.maker.machine.app.repository.impl.DynamoLessonRepository;
import com.maker.machine.core.exception.MachineNotFoundException;
import com.maker.machine.core.exception.TaskNotFoundException;
import com.maker.machine.core.service.impl.DomainLessonService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DomainLessonServiceTest {

    @Mock
    private ApplicationEventPublisher publisher;

    @Test
    @DisplayName("Should be able create lesson")
    void shouldBeAbleCreateLesson() {

        MockitoAnnotations.openMocks(this);

        DomainLessonService domainLessonService = new DomainLessonService(new DynamoLessonRepository(), publisher);

        TaskDTO taskDtoOne = TaskDTO.builder()
                .description("Check step 1")
                .order(1)
                .build();

        TaskDTO taskDtoTwo = TaskDTO.builder()
                .description("Check step 1")
                .order(2)
                .build();

        Set<TaskDTO> tasks = Stream.of(taskDtoOne, taskDtoTwo).collect(Collectors.toSet());

        LessonDTO dto = LessonDTO.builder()
                .description("Lesson one")
                .name("Check has gas")
                .machine(MachineDTO.builder().build())
                .tasks(tasks)
                .build();

        Assertions.assertNotNull(domainLessonService.create(dto));

    }

    @Test
    @DisplayName("Should not be able create lesson without tasks")
    void shouldNotBeAbleCreateLessonWithoutTask() {

        DomainLessonService domainLessonService = new DomainLessonService(new DynamoLessonRepository(), publisher);

        LessonDTO dto = LessonDTO.builder()
                .description("Lesson one")
                .name("Check has gas")
                .build();

        TaskNotFoundException thrown = Assertions
                .assertThrows(TaskNotFoundException.class,
                        () -> domainLessonService.create(dto),
                        "Expected create() to throw");

        Assertions.assertNotNull(thrown);
    }

    @Test
    @DisplayName("Should not be able create lesson without Machine")
    void shouldNotBeAbleCreateLessonWithoutMachine() {

        DomainLessonService domainLessonService = new DomainLessonService(new DynamoLessonRepository(), publisher);

        LessonDTO dto = LessonDTO.builder()
                .description("Lesson one")
                .name("Check has gas")
                .machine(null)
                .tasks(Stream.of(new TaskDTO()).collect(Collectors.toSet()))
                .build();

        MachineNotFoundException thrown = Assertions
                .assertThrows(MachineNotFoundException.class,
                        () -> domainLessonService.create(dto),
                        "Expected create() to throw");

        Assertions.assertNotNull(thrown);
    }

}
