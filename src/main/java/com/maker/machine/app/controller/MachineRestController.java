package com.maker.machine.app.controller;

import com.maker.machine.app.dto.MachineDTO;
import com.maker.machine.core.domain.Machine;
import com.maker.machine.core.service.MachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("machines")
public class MachineRestController {

    @Autowired
    private MachineService machineService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Machine createMachine(@RequestBody MachineDTO machineDTO) {
        return machineService.create(machineDTO);
    }

}
