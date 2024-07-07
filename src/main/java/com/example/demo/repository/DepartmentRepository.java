package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    // teh jpa repository aldready has many implementations required for crud operations

    // defining the function signatures for custom methods
    public Department findByName(String name);
    //... the name of any function needs to be in camal casing

    //we can add a method to ignore the case also
    public Department findByNameIgnoreCase(String name);

}
