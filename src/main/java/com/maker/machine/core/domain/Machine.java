package com.maker.machine.core.domain;

import com.maker.machine.app.dto.MachineDTO;
import lombok.*;

import java.util.UUID;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Machine {

    private UUID id;
    private String model;
    private String name;
    private String code;

    public static Machine create(MachineDTO dto) {
        return Machine.builder()
                .id(dto.getId())
                .name(dto.getName())
                .code(dto.getCode())
                .model(dto.getModel())
                .build();
    }
}
