package com.example.demo.entity;


import javax.persistence.*;

@Entity
@Table(name="teachers")
public class Teachers {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer tea_id;
    private  String name;
    @OneToMany
    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(Integer teaid) {
        this.tea_id = teaid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Teachers(){ super();
    }
}
