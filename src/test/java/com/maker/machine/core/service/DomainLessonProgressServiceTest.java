package com.maker.machine.core.service;

import com.maker.machine.app.dto.LessonProgressDTO;
import com.maker.machine.app.repository.LessonProgressRepository;
import com.maker.machine.app.repository.impl.DynamoLessonProgressRepository;
import com.maker.machine.core.domain.LessonProgress;
import com.maker.machine.core.enums.Status;
import com.maker.machine.core.exception.LessonNotFoundException;
import com.maker.machine.core.service.impl.DomainLessonProgressService;
import com.maker.machine.repository.DynamoLessonProgressFakeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DomainLessonProgressServiceTest {

    @Test
    @DisplayName("Should be able set task with done")
    void shouldBeAbleSetTaskWithDone() {

        UUID uuid = UUID.randomUUID();

        LessonProgressDTO lessonProgressDTO = LessonProgressDTO.builder()
                .lessonId(uuid)
                .tasksId(Stream.of(uuid).collect(Collectors.toSet()))
                .build();

        DomainLessonProgressService domain = new DomainLessonProgressService(new DynamoLessonProgressFakeRepository());

        LessonProgress lessonProgress = domain.updateTaskWithDone(lessonProgressDTO);

        Assertions.assertEquals(Status.DONE, lessonProgress.getStatus());

    }

    @Test
    @DisplayName("Should be able create lesson progress")
    void shouldBeAbleCreateLessonProgress() {

        DomainLessonProgressService domain = new DomainLessonProgressService(new DynamoLessonProgressFakeRepository());

        LessonProgress lesson = domain.create(UUID.randomUUID(), UUID.randomUUID());

        domain.create(UUID.randomUUID(), UUID.randomUUID());

        Assertions.assertNotNull(lesson);
        Assertions.assertEquals(3, lesson.getTaskProgress().size());
    }


    @Test
    @DisplayName("Should be not able update task with done lesson progress without uuid")
    void shouldBeNotAbleUpdateTaskWithDoneLessonProgressWithoutUUID() {

        LessonProgressDTO dto = LessonProgressDTO.builder()
                .build();

        DomainLessonProgressService domain = new DomainLessonProgressService(new DynamoLessonProgressRepository());

        LessonNotFoundException thrown = Assertions
                .assertThrows(LessonNotFoundException.class,
                        () -> domain.updateTaskWithDone(dto),
                        "Expected updateTaskWithDone() to throw");

        Assertions.assertNotNull(thrown);

    }
}
