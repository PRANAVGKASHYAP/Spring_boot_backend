package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data // this is a lombook annotations form lombok that add all the required getters and setters
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    //hibernate data validations can also be added
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank(message = "department needs to have a name")
    @Size(max = 10)
    private String name;
    private String address;
    private String code;

}
