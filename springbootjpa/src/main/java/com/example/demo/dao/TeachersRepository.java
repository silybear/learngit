package com.example.demo.dao;


import com.example.demo.entity.Teachers;
import org.springframework.data.jpa.repository.JpaRepository;



public interface TeachersRepository extends JpaRepository<Teachers,Integer> {

}
