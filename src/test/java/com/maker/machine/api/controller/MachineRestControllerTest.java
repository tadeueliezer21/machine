package com.maker.machine.api.controller;

import com.google.gson.Gson;
import com.maker.machine.app.dto.MachineDTO;
import javax.crypto.Mac;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class MachineRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should be able create new machine")
    void shouldBeAbleCreateNewMachine() throws Exception {

        MachineDTO machineDTO = MachineDTO.builder()
                .model("Model")
                .name("Name")
                .code("Code")
                .build();

        Gson gson = new Gson();

        mockMvc.perform(MockMvcRequestBuilders.post("/machines/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(machineDTO)))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

}
