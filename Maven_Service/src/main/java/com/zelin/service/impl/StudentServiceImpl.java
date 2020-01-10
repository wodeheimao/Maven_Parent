package com.zelin.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zelin.mapper.ClassesMapper;
import com.zelin.mapper.StudentMapper;
import com.zelin.pojo.PageResult;
import com.zelin.pojo.Student;
import com.zelin.pojo.StudentExample;
import com.zelin.service.StudentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassesMapper classesMapper;

    //分页条件查询
    @Override
    public PageResult search(Integer page, Integer pageSize, Student student) {
        PageHelper.startPage(page,pageSize);

        StudentExample example = new StudentExample();
        StudentExample.Criteria criteria = example.createCriteria();
        if(student!=null){
            if(StringUtils.isNotEmpty(student.getSname())){
                criteria.andSnameLike("%"+student.getSname()+"%");
            }
            if(StringUtils.isNotEmpty(student.getAddr())){
                criteria.andAddrLike("%"+student.getAddr()+"%");
            }
            if(null != student.getCid() && student.getCid().intValue() !=0){
                criteria.andCidEqualTo(student.getCid());
            }
        }
        List<Student> studentList = studentMapper.selectByExample(example);
        for (Student stud : studentList) {
            stud.setCname(classesMapper.selectByPrimaryKey(stud.getCid()).getCname());
        }
        Page<Student> studentPage = (Page<Student>) studentList;
        return new PageResult(studentPage.getTotal(),studentPage.getResult());
    }
}
