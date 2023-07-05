package ru.skypro.lessons.springboot.EmployeeApplication.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class InfoController {

    @Value("${app.env}")
    private String appInfo;
    @GetMapping("/test")
    public String info(){
        return appInfo;
    }
}
