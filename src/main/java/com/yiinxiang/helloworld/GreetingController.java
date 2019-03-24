package com.yiinxiang.helloworld;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @program: ordering
 * @Description:
 * @author: Mr.Cheng
 * @date: 2019/3/12 4:57 PM
 */

@RestController
@Slf4j
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        log.trace("trace the log");
        log.debug("debug the log");
        log.info("info the log");
        log.warn("warn the log");
        log.error("error the log");
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
