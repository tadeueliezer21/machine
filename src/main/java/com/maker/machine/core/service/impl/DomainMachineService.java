package com.maker.machine.core.service.impl;

import com.maker.machine.app.dto.MachineDTO;
import com.maker.machine.app.repository.MachineRepository;
import com.maker.machine.core.domain.Machine;
import com.maker.machine.core.service.MachineService;

public class DomainMachineService implements MachineService {

    private MachineRepository machineRepository;

    public DomainMachineService(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Machine create(MachineDTO dto) {
        return machineRepository.save(Machine.create(dto));
    }
}
