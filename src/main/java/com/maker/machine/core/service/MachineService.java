package com.maker.machine.core.service;

import com.maker.machine.app.dto.MachineDTO;
import com.maker.machine.core.domain.Machine;

public interface MachineService {

    Machine create(MachineDTO machine);

}
