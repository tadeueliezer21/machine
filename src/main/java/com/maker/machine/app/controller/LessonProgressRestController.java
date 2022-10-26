package com.maker.machine.app.controller;

import com.maker.machine.app.dto.LessonDTO;
import com.maker.machine.app.dto.LessonProgressDTO;
import com.maker.machine.core.domain.LessonProgress;
import com.maker.machine.core.service.LessonProgressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/lessons")
public class LessonProgressRestController {

    private LessonProgressService lessonProgressService;

    @Autowired
    public LessonProgressRestController(LessonProgressService lessonProgressService) {
        this.lessonProgressService = lessonProgressService;
    }

    @PostMapping("/machine/create-lesson-progress/")
    @ResponseStatus(HttpStatus.CREATED)
    public LessonProgress createLessonProgress(@RequestBody LessonDTO lessonDTO) {
        return lessonProgressService.create(lessonDTO.getId(), lessonDTO.getMachine().getId());
    }

    @PostMapping("/tasks-update-progress/")
    @ResponseStatus(HttpStatus.CREATED)
    public LessonProgress updateTaskProgress(@RequestBody LessonProgressDTO lessonProgress) {
        return lessonProgressService.updateTaskWithDone(lessonProgress);
    }

}
