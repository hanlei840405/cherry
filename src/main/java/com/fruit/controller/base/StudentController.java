package com.fruit.controller.base;

import com.fruit.constant.Constant;
import com.fruit.dto.StudentDto;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

/**
 * Created by hanlei6 on 2016/12/20.
 */
@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/{username}")
    public String index(@PathVariable("username") String username, Model model) {
        ResponseEntity<StudentDto> responseEntity = restTemplate.getForEntity(Constant.REST_URL + Constant.SERVICE_ORANGE + "student/" + username, StudentDto.class);
        model.addAttribute("student", responseEntity.getBody());
        return "portal_student";
    }

    @RequestMapping("/save")
    public String save(Model model) {
        StudentDto studentDto = new StudentDto();
        studentDto.setAddress("建设路1-1号");
        studentDto.setAge(33);
        studentDto.setBirthday(new Date());
        studentDto.setCellphone("18615267773");
        studentDto.setCity("济南市");
        studentDto.setDistrict("市中区");
        studentDto.setGender("男");
        studentDto.setGrade("高三");
        studentDto.setProvince("山东省");
        studentDto.setRealName("韩磊");
        studentDto.setSchool("济南三中");
        studentDto.setUsername("hanlei");
        amqpTemplate.convertAndSend("queue.student", studentDto);
        return "portal_student";
    }
}
