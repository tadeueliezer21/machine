package com.maker.machine.core.domain;

import com.maker.machine.core.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Builder
public class TaskProgress {

    private UUID id;
    private Task task;
    private Status status;

    public void done() {
        status = Status.DONE;
    }

    public static TaskProgress create(Task task) {
        return TaskProgress.builder()
                .id(UUID.randomUUID())
                .task(task)
                .status(Status.IN_PROGRESS)
                .build();
    }


}
