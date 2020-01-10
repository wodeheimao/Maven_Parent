package com.zelin.controller;

import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;
import com.zelin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("search")
    public PageResult search(Integer page, Integer pageSize,@RequestBody(required = false) Student student){
        return studentService.search(page,pageSize,student);
    }
}
