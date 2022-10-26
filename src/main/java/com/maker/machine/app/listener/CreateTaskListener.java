package com.maker.machine.app.listener;

import com.maker.machine.core.event.CreateTaskEvent;
import com.maker.machine.core.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CreateTaskListener {
    @Autowired
    private TaskService taskService;

    @EventListener
    public void event(CreateTaskEvent  event) {
        taskService.create(event.getLesson(), event.getTasks());
    }

}
