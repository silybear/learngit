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
@RequestMapping("/students")
public class StudentsController {
    @Autowired
    private StudentsRepository studentsRepository;
    @Autowired
    private TeachersRepository teachersRepository;

    //根据id查找学生的信息以及老师
    @GetMapping("/get/{id}")
    public Map<String, Object> getStudent(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<String, Object>();
        Students students = studentsRepository.getOne(id);
        Teachers teachers= teachersRepository.getOne(students.getTea_id());
        map.put("student", students);
        map.put("teachers", teachers);
        return map;
    }

    //增加信息
    @PostMapping("/savestudents")
    public void saveStudents(Students studentsEneity){
          studentsRepository.save(studentsEneity);
        System.out.println("增加成功");

    }

    //修改信息
    @PutMapping("/updateStudents/{id}")
    public void updateStudents(@RequestBody Students studentsEneity,@PathVariable Integer id){
        studentsEneity.setId(id);
       studentsRepository.save(studentsEneity);
        System.out.println("修改成功");
    }

    //根据id删除
    @DeleteMapping ("/deleteById/{id}")
    public void  deleteById(@PathVariable Integer id) {
      studentsRepository.deleteById(id);
        System.out.println("删除成功");
    }

    //查找所有学生信息
    @GetMapping("/studentsList")
    public List<Students>   getStudentList() {
       return  studentsRepository.findAll();
    }

}
