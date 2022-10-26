package com.maker.machine.app.controller;

import com.maker.machine.app.dto.LessonDTO;
import com.maker.machine.core.domain.Lesson;
import com.maker.machine.core.service.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "lessons")
public class LessonRestController {

    private LessonService lessonService;

    @Autowired
    public LessonRestController(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Lesson createLesson(@RequestBody LessonDTO dto) {
        return this.lessonService.create(dto);
    }
}
