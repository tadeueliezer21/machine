package com.maker.machine.core.service;

import com.maker.machine.app.dto.LessonProgressDTO;
import com.maker.machine.core.domain.LessonProgress;

import java.util.UUID;

public interface LessonProgressService {

    LessonProgress create(UUID lessonId, UUID machineId);

    LessonProgress updateTaskWithDone(LessonProgressDTO dto);

}
