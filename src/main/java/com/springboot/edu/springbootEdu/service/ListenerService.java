package com.springboot.edu.springbootEdu.service;

import com.springboot.edu.springbootEdu.data.Entity.ListenerEntity;

public interface ListenerService {

    ListenerEntity getEntity(Long id);

    void saveEntity(ListenerEntity listenerEntity);

    void updateEntity(ListenerEntity listenEntity);

    void removeEntity(ListenerEntity listenerEntity);
}
