package com.maker.machine.app.repository;

import com.maker.machine.core.domain.Task;

import java.util.Set;

public interface TaskRepository {

    Set<Task> saveAll(Set<Task> tasks);

}
