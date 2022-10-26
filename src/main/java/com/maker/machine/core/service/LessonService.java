package com.maker.machine.core.service;

import com.maker.machine.app.dto.LessonDTO;
import com.maker.machine.core.domain.Lesson;

public interface LessonService {

    Lesson create(LessonDTO lessonDTO);

}
