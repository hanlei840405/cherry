package com.fruit.controller.base;

import com.fruit.controller.BaseController;
import com.fruit.dto.CategoryDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Created by JesseHan on 2016/12/21.
 */
@Slf4j
@Controller
@RequestMapping("/category")
public class CategoryController extends BaseController {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/save")
    public
    @ResponseBody
    Map<String, Object> save(String name, String categoryCode, String imgUrl, Long sequence) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setCategoryCode(categoryCode);
        categoryDto.setName(name);
        categoryDto.setImgUrl(imgUrl);
        categoryDto.setSequence(sequence);
        amqpTemplate.convertAndSend("queue.category.insert", categoryDto);
        return success();
    }
}
