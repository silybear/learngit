package com.example.demo.dao;

import com.example.demo.entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students,Integer> {
    @Query(value="select * from students where tea_id=?",nativeQuery=true)
    List<Students> getStudentsBytea_Id(Integer tea_id);

}
