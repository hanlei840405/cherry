package com.fruit.controller.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * Created by JesseHan on 2016/12/21.
 */
@Controller
public class CategoryController {
    @Autowired
    private RestTemplate restTemplate;

}
