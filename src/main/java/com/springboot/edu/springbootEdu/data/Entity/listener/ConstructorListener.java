package com.springboot.edu.springbootEdu.data.Entity.listener;

import com.springboot.edu.springbootEdu.data.Entity.ListenerEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;


// ListenerConstructor
// javax.persistence 에서 제공해주는 어노테이션들
public class ConstructorListener {

    // Service 에서 Jpa 에서 Annotation 별 로 처리가 가능

    private final Logger LOGGER = LoggerFactory.getLogger(ConstructorListener.class);

    @PostLoad
    public void postLoad(ListenerEntity listenerEntity) {
        LOGGER.info("[ConstructorListener postLoad] : {} ", listenerEntity);
    }

    @PrePersist
    public void prePersist(ListenerEntity listenerEntity) {
        LOGGER.info("[ConstructorListener prePersist] : {} ", listenerEntity);
    }

    @PostPersist
    public void postPersist(ListenerEntity listenreEntity) {
        LOGGER.info("[ConstructorListenre postPersist] : {}" , listenreEntity);
    }

    @PreUpdate
    public void preUpdate(ListenerEntity listenerEntity) {
        LOGGER.info("[ConstructorListener preUpdate] {} " , listenerEntity);
    }

}
