package com.maker.machine.app.bean;

import com.maker.machine.app.repository.MachineRepository;
import com.maker.machine.app.repository.impl.DynamoMachineRepository;
import com.maker.machine.core.service.MachineService;
import com.maker.machine.core.service.impl.DomainMachineService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanMachine {

    @Bean
    public MachineService machineService() {
        return new DomainMachineService(machineRepository());
    }

    @Bean
    public MachineRepository machineRepository() {
        return new DynamoMachineRepository();
    }

}
