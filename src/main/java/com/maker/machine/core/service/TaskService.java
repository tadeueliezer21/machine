package com.maker.machine.core.service;

import com.maker.machine.app.dto.TaskDTO;
import com.maker.machine.core.domain.Lesson;
import com.maker.machine.core.domain.Task;

import java.util.Set;

public interface TaskService {

    Set<Task>  create(Lesson lesson, Set<TaskDTO> tasks);

}
