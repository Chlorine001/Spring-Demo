package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @version 1.0
 * @Author chenglong
 * @className Programmer
 * @Description
 * @Date 2025-07-22
 */
@Getter
@Setter
public class Programmer {
    private Integer id;
    private String name;
    private Integer age;
    private List<String> skills;

    public Programmer(Integer id, String name, Integer age, List<String> skills) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.skills = skills;
    }
}
