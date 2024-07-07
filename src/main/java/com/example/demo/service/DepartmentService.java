package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFound;

import java.util.List;

public interface DepartmentService {
    public Department saveDept(Department department);

    public  List<Department> fetchAllDept();

    public Department getById(Long id) throws DepartmentNotFound;

    public  void deleteDpet(Long id);

    public Department updateDept(Long id, Department department);

    public Department findByName(String name);
}
