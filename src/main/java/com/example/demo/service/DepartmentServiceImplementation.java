package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFound;
import com.example.demo.repository.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DepartmentServiceImplementation implements DepartmentService{

    @Autowired
    DepartmentRepository departmentRepository;

    @Override
    public Department saveDept(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> fetchAllDept() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(Long id) throws DepartmentNotFound {

        //handelling the exceptions for invalid id
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        //if dept with this id is present then wwe return it else we throw an exception
        if(!optionalDepartment.isPresent())
        {
            throw new DepartmentNotFound("Department not found");
        }

        return departmentRepository.findById(id).get();
    }

    @Override
    public void deleteDpet(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department updateDept(Long id, Department department) {

        Department temp = departmentRepository.findById(id).get();

        //checking if the fields are not null
        if(Objects.nonNull(department.getName()) && !"".equals(department.getName())) {
            temp.setName(department.getName());
        }

        if(Objects.nonNull(department.getAddress()) && !"".equals(department.getAddress())) {
            temp.setAddress(department.getAddress());
        }

        if(Objects.nonNull(department.getCode()) && !"".equals(department.getCode())) {
            temp.setCode(department.getCode());
        }

        return departmentRepository.save(temp);
    }

    @Override
    public Department findByName(String name) {

        Department temp = departmentRepository.findByName(name);
        if( !Objects.nonNull(temp) ) {
            return departmentRepository.findByNameIgnoreCase(name);
        }

        return temp;
    }
}
