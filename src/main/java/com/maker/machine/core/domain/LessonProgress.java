package com.maker.machine.core.domain;

import com.maker.machine.core.enums.Status;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Builder
public class LessonProgress {

    private UUID id;
    private Set<TaskProgress> taskProgress;
    private Status status;

    public Boolean lessonIsDone() {
        return allTasksIsDone();
    }

    public void updateTasksWithDone(Set<UUID> tasksId) {
        tasksId.stream()
                .forEach(tId -> taskProgress.stream()
                    .filter(t -> t.getId().equals(tId)).findFirst().ifPresent(task -> task.done()));
    }

    public void lessonDone() {
        if (lessonIsDone()) {
            status = Status.DONE;
        }
    }

    public static LessonProgress create(Set<TaskProgress> tasks) {
        return LessonProgress.builder()
                .id(UUID.randomUUID())
                .taskProgress(tasks)
                .status(Status.IN_PROGRESS)
                .build();
    }

    private Boolean allTasksIsDone() {
        return taskProgress
                .stream()
                .filter(task -> !Status.DONE.equals(task.getStatus()))
                .collect(Collectors.toSet()).size() == 0;
    }

}
