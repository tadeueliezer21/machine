package com.maker.machine.app.dto;

import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonDTO {

    private UUID id;
    private String name;
    private String description;
    private Integer order;
    private Set<TaskDTO> tasks;
    private MachineDTO machine;

}
