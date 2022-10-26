package com.maker.machine.api.controller;

import com.google.gson.Gson;
import com.maker.machine.app.controller.LessonProgressRestController;
import com.maker.machine.app.dto.LessonDTO;
import com.maker.machine.app.dto.LessonProgressDTO;
import com.maker.machine.app.dto.MachineDTO;
import com.maker.machine.app.repository.LessonProgressRepository;
import com.maker.machine.core.service.LessonProgressService;
import com.maker.machine.core.service.impl.DomainLessonProgressService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import java.util.UUID;

@SpringBootTest
@AutoConfigureMockMvc
public class LessonProgressRestControllerTest {

    @Mock
    private LessonProgressRepository lessonProgressRepository;

    @Mock
    private LessonProgressService lessonProgressService;

    @InjectMocks
    private LessonProgressRestController lessonProgressRestController;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Should be not able update task")
    void shouldBeNotAbleUpdateTask() throws Exception {

        Gson gson = new Gson();

        LessonProgressDTO dto = LessonProgressDTO.builder()
                .build();

        mockMvc.perform(post("/lessons/tasks-update-progress/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(gson.toJson(dto)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }

    @Test
    @DisplayName("Should be not able create lesson progress lesson without lessons")
    void shouldBeNotAbleCreateLessonProgress() throws Exception {

        MockitoAnnotations.openMocks(this);

        Gson gson = new Gson();

        LessonDTO lessonDTO = new LessonDTO();

        lessonDTO.setId(UUID.randomUUID());
        lessonDTO.setMachine(MachineDTO.builder().id(UUID.randomUUID()).build());

        mockMvc.perform(post("/lessons/machine/create-lesson-progress/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(lessonDTO)))
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }


}
