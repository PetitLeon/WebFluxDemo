package com.example.webflux_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table(value = "user")
@Data
@AllArgsConstructor
public class User implements Serializable {
    @Id
    private Integer id;
    private String name;
    private Integer age;
}
