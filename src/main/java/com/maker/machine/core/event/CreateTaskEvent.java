package com.maker.machine.core.event;

import com.maker.machine.app.dto.TaskDTO;
import com.maker.machine.core.domain.Lesson;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Set;

@Getter
@AllArgsConstructor
public class CreateTaskEvent {

    private Lesson lesson;
    private Set<TaskDTO> tasks;

}
