package com.maker.machine.core.domain;

import com.maker.machine.app.dto.LessonDTO;
import com.maker.machine.core.exception.MachineNotFoundException;
import com.maker.machine.core.exception.TaskNotFoundException;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class Lesson {

    private UUID id;
    private String name;
    private String description;
    private Machine machine;

    public static Lesson createFrom(LessonDTO lesson) {

        if(Objects.isNull(lesson.getTasks())) {
            throw new TaskNotFoundException("Task not found");
        }

        if(Objects.isNull(lesson.getMachine())){
            throw new MachineNotFoundException("Machine not found");
        }

        return Lesson.builder()
                .id(UUID.randomUUID())
                .name(lesson.getName())
                .description(lesson.getDescription())
                .build();
    }

}
