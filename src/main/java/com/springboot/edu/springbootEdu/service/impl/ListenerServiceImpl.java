package com.springboot.edu.springbootEdu.service.impl;

import com.springboot.edu.springbootEdu.data.Entity.ListenerEntity;
import com.springboot.edu.springbootEdu.data.repository.ListenerRepository;
import com.springboot.edu.springbootEdu.service.ListenerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ListenerServiceImpl implements ListenerService {

    private final Logger LOGGER = LoggerFactory.getLogger(ListenerServiceImpl.class);

    private ListenerRepository listenerRepository;

    @Autowired
    public ListenerServiceImpl(ListenerRepository listenerRepository) {
        this.listenerRepository = listenerRepository;
    }

    @Override
    public ListenerEntity getEntity(Long id) {
        // 기본 SimplageJpaRepository 인터페이스에서 제공하는 API
        return listenerRepository.findById(id).get();
    }

    @Override
    public void saveEntity(ListenerEntity listenerEntity) {
        listenerRepository.save(listenerEntity);
    }

    @Override
    public void updateEntity(ListenerEntity listenerEntity) {
        ListenerEntity foundListener = listenerRepository.findById(listenerEntity.getId()).get();
        foundListener.setName(listenerEntity.getName());

        listenerRepository.save(foundListener);
    }

    @Override
    public void removeEntity(ListenerEntity listenerEntity) {
        listenerRepository.delete(listenerEntity);

    }


}
