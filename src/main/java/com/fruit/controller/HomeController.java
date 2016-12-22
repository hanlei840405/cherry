package com.fruit.controller;

import com.fruit.constant.Constant;
import com.fruit.dto.CategoryDto;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hanlei6 on 16-12-14.
 */
@Slf4j
@Controller
public class HomeController {
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/")
    public String index(Model model) {
        List<CategoryDto> categoryDtoList = restTemplate.getForObject(Constant.REST_URL + Constant.SERVICE_ORANGE + "category/categories/", ArrayList.class);
        categoryDtoList.forEach(categoryDto -> {
            List<CategoryDto> elements = restTemplate.getForObject(Constant.REST_URL + Constant.SERVICE_ORANGE + "category/categories/" + categoryDto.getCategoryCode(), ArrayList.class);
            categoryDto.getElements().addAll(elements);
        });
        model.addAttribute("categoryDtoList", categoryDtoList);
        return "index";
    }

    @RequestMapping(value = "/add/{a}/{b}", method = RequestMethod.GET)
    @ApiOperation(value = "add", notes = "add", code = 200)
    public
    @ResponseBody
    Integer add(@PathVariable("a") Integer a, @PathVariable("b") Integer b) {
        log.info("cherry, a: {}, b: {}", a, b);
        return restTemplate.getForEntity("http://litchi/orange/add?a=" + a + "&b=" + b, Integer.class).getBody();
    }

    @RequestMapping(value = "/print/{payload}", method = RequestMethod.GET)
    @ApiOperation(value = "print", notes = "print", code = 200)
    public
    @ResponseBody
    String print(@PathVariable("payload") String payload) {
        log.info("cherry, payload: {}", payload);
        return restTemplate.getForEntity("http://litchi/orange/print?payload=" + payload, String.class).getBody();
    }
}
