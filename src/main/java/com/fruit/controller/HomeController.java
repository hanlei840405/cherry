package com.fruit.controller;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by hanlei6 on 16-12-14.
 */
@Slf4j
@RestController
public class HomeController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    @ApiOperation(value = "add", notes = "add", code = 200)
    public Integer add(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        log.info("cherry, a: {}, b: {}", a, b);
        return restTemplate.getForEntity("http://litchi/orange/add?a=" + a + "&b=" + b, Integer.class).getBody();
    }

    @RequestMapping(value = "/print/{payload}", method = RequestMethod.GET)
    @ApiOperation(value = "print", notes = "print", code = 200)
    public String print(@PathVariable("payload") String payload) {
        log.info("cherry, payload: {}", payload);
        return restTemplate.getForEntity("http://litchi/orange/print?payload=" + payload, String.class).getBody();
    }
}
