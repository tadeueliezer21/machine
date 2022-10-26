package com.maker.machine.app.repository.impl;

import com.maker.machine.app.repository.MachineRepository;
import com.maker.machine.core.domain.Machine;

public class DynamoMachineRepository implements MachineRepository {
    @Override
    public Machine save(Machine machine) {
        return machine;
    }
}
