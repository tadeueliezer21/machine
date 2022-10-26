package com.maker.machine.app.bean;

import com.maker.machine.app.repository.TaskRepository;
import com.maker.machine.app.repository.impl.DynamoTaskRepository;
import com.maker.machine.core.service.TaskService;
import com.maker.machine.core.service.impl.DomainTaskService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanTask {

    @Bean
    public TaskService taskService () {
        return new DomainTaskService(taskRepository());
    }

    @Bean
    public TaskRepository taskRepository() {
        return new DynamoTaskRepository();
    }

}
