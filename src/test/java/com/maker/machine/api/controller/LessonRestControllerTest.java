package com.maker.machine.api.controller;

import com.google.gson.Gson;
import com.maker.machine.app.dto.LessonDTO;
import com.maker.machine.app.dto.MachineDTO;
import com.maker.machine.app.dto.TaskDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest
@AutoConfigureMockMvc
public class LessonRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should be able create lesson by rest controller")
    void shouldBeAbleCreateLessonByRestController() throws Exception {

        TaskDTO taskDtoOne = TaskDTO.builder()
                .description("Check step 1")
                .order(1)
                .build();

        TaskDTO taskDtoTwo = TaskDTO.builder()
                .description("Check step 1")
                .order(2)
                .build();

        Set<TaskDTO> tasks = Stream.of(taskDtoOne, taskDtoTwo).collect(Collectors.toSet());

        LessonDTO dto = LessonDTO.builder()
                .description("Lesson one")
                .name("Check has gas")
                .machine(MachineDTO.builder()
                        .id(UUID.randomUUID())
                        .code("code")
                        .name("machine")
                        .build())
                .tasks(tasks)
                .build();

        Gson gson = new Gson();

        mockMvc.perform(post("/lessons/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(dto)))
                .andExpect(MockMvcResultMatchers.status().isCreated());

    }

}
