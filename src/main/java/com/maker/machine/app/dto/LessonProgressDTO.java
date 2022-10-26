package com.maker.machine.app.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;
import java.util.UUID;

@Getter
@Builder
public class LessonProgressDTO {

    private UUID lessonId;
    private Set<UUID> tasksId;

}
