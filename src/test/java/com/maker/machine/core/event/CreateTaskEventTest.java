package com.maker.machine.core.event;

import com.maker.machine.app.dto.TaskDTO;
import com.maker.machine.core.domain.Lesson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateTaskEventTest {

    @Test
    @DisplayName("Should be able instance create task event")
    void shouldBeAbleInstanceCreateTaskEvent() {

        CreateTaskEvent createTaskEvent = new CreateTaskEvent(Lesson.builder().build(), Stream.of(TaskDTO.builder().build()).collect(Collectors.toSet()));
        Assertions.assertNotNull(createTaskEvent);

    }

}
