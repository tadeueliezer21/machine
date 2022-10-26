package com.maker.machine.app.advice;

import com.maker.machine.app.dto.MessageDTO;
import com.maker.machine.core.exception.DescriptionNotFoundInTaskException;
import com.maker.machine.core.exception.LessonNotFoundException;
import com.maker.machine.core.exception.MachineNotFoundException;
import com.maker.machine.core.exception.TaskNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = "com.maker.machine.app.controller")
public class RestControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler({
            TaskNotFoundException.class,
            LessonNotFoundException.class,
            MachineNotFoundException.class,
            DescriptionNotFoundInTaskException.class
    })
    protected ResponseEntity<MessageDTO> handleRestAdvice(
            RuntimeException ex) {
        return ResponseEntity.badRequest().body(MessageDTO.builder().message(ex.getMessage()).build());
    }

}
