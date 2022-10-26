package com.maker.machine.app.dto;

import lombok.*;

import java.util.UUID;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MachineDTO {
    private UUID id;
    private String model;
    private String name;
    private String code;
}
