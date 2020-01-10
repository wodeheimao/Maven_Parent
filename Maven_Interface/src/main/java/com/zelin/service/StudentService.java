package com.zelin.service;

import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;

public interface StudentService {
    //分页条件查询
    PageResult search(Integer page, Integer pageSiza, Student student);
}
