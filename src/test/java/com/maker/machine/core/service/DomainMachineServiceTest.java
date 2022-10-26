package com.maker.machine.core.service;

import com.maker.machine.app.dto.MachineDTO;
import com.maker.machine.app.repository.impl.DynamoMachineRepository;
import com.maker.machine.core.service.impl.DomainMachineService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class DomainMachineServiceTest {

    @Test
    @DisplayName("Should be abre create new machine")
    void shouldBeAbleCreateNewMachine() {

        MachineDTO machineDTO = MachineDTO.builder()
                .id(UUID.randomUUID())
                .name("Machine")
                .model("Model")
                .build();

        DomainMachineService domainMachineService = new DomainMachineService(new DynamoMachineRepository());

        Assertions.assertNotNull(domainMachineService.create(machineDTO));

    }

}
