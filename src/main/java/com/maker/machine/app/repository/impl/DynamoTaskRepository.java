package com.maker.machine.app.repository.impl;

import com.maker.machine.app.repository.TaskRepository;
import com.maker.machine.core.domain.Task;

import java.util.Set;

public class DynamoTaskRepository implements TaskRepository {
    @Override
    public Set<Task> saveAll(Set<Task> tasks) {
        return tasks;
    }
}
