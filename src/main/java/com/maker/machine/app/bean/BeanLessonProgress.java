package com.maker.machine.app.bean;

import com.maker.machine.app.repository.LessonProgressRepository;
import com.maker.machine.app.repository.impl.DynamoLessonProgressRepository;
import com.maker.machine.core.service.LessonProgressService;
import com.maker.machine.core.service.impl.DomainLessonProgressService;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanLessonProgress {

    @Bean
    public LessonProgressService lessonProgressService() {
        return new DomainLessonProgressService(lessonProgressRepository());
    }

    @Bean
    public LessonProgressRepository lessonProgressRepository() {
        return new DynamoLessonProgressRepository();
    }

}
