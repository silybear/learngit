package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name="students")
public class Students {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id ;
    private String name;
    private Integer tea_id;
    @ManyToOne
    @JoinColumn(name="tea_id")
    private Teachers teachers;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public  Integer getTea_id() {
        return tea_id;
    }

    public void setTea_id(Integer tea_id) {
        this.tea_id = tea_id;
    }
    public Students(){
        super();
    }
}
