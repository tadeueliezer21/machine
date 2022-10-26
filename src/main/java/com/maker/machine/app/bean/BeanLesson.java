package com.maker.machine.app.bean;

import com.maker.machine.app.repository.LessonRepository;
import com.maker.machine.app.repository.impl.DynamoLessonRepository;
import com.maker.machine.core.service.LessonService;
import com.maker.machine.core.service.impl.DomainLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanLesson {

    @Autowired
    private ApplicationEventPublisher beanEvent;

    @Bean
    public LessonService domainLessonService(){
        return new DomainLessonService(domainLessonRepository(), beanEvent);
    }

    @Bean
    public LessonRepository domainLessonRepository() {
        return new DynamoLessonRepository();
    }

}
