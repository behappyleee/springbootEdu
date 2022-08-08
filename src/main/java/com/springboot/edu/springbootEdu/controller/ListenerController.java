package com.springboot.edu.springbootEdu.controller;


import com.springboot.edu.springbootEdu.service.ListenerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/listener")
public class ListenerController {

    Logger LOGGER = LoggerFactory.getLogger(ListenerController.class);

    private ListenerService listenerService;

    @Autowired
    public ListenerController(ListenerService listenerService) {
        this.listenerService = listenerService;
    }

    @GetMapping()
    public String getListener() {

        return "OK";
    }
}
