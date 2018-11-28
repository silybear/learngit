package com.example.demo.controller;


import com.example.demo.dao.StudentsRepository;
import com.example.demo.dao.TeachersRepository;
import com.example.demo.entity.Students;
import com.example.demo.entity.Teachers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/teachers")
public class TeachersController {
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private TeachersRepository teachersRepository;


    //根据id查找老师
    @GetMapping("/getTeachersById")
    public Teachers getTeachersById(@PathVariable Integer teaid) {
       return  teachersRepository.findById(teaid).get();

    }

    //增加教师信息
    @PostMapping("/saveTeacher")
    public void saveTeacher(Teachers teachersEneity){
       teachersRepository.save(teachersEneity);
        System.out.println("增加成功");

    }

    //修改教师信息
    @PutMapping("/updateTeachers/{tea_id}")
    public void updateTeachers(@RequestBody Teachers teachersEneity,@PathVariable Integer tea_id){
        teachersEneity.setTea_id(tea_id);
       teachersRepository.save(teachersEneity);
        System.out.println("修改成功");
    }

    //根据id删除
    @DeleteMapping("/delete/{id}")
    public Map<String, Object> deleteTeachers(@PathVariable Integer tea_id) {
        Map<String, Object> map = new HashMap<String, Object>();

        List<Students> studentsBytea_Id = studentsRepository.getStudentsBytea_Id(tea_id);
        if (studentsBytea_Id.size() == 0) {

            teachersRepository.deleteById(tea_id);
            map.put("status", true);
        } else {
            map.put("status", false);
        }
        return map;
    }


    //查找所有信息
    @GetMapping("/teacherList")
    public void getStudentList() {
        teachersRepository.findAll();
    }





}
