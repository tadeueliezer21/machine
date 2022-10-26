package com.maker.machine.core.domain;

import com.maker.machine.app.dto.TaskDTO;
import com.maker.machine.core.exception.DescriptionNotFoundInTaskException;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Task {

    private UUID id;
    private String description;
    private Integer order;
    private Lesson lesson;

    public static Task createFrom (TaskDTO task, Lesson lesson) {
        if(Objects.isNull(task.getDescription())) {
            throw new DescriptionNotFoundInTaskException("Description not found in Task");
        }

        return Task.builder()
                .id(UUID.randomUUID())
                .lesson(lesson)
                .description(task.getDescription())
                .order(task.getOrder())
                .build();
    }

}
