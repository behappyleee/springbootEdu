package test;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class test {

    private static final Logger logger = LoggerFactory.getLogger(test.class);

    @RequestMapping("/")
    public String firstPage() {
        logger.debug("Hello First Page !!");
        System.out.println("Hello First Page !!");
        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        System.out.println("Hello Controller !");
        return "hello";
    }
}
