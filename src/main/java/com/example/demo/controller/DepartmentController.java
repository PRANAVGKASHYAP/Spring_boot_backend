package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.error.DepartmentNotFound;
import com.example.demo.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class DepartmentController {

    // mappings to department entity
    @Autowired
    private DepartmentService departmentService;

    //adding the simple loggers
    private final Logger LOGGER = Logger.getLogger(this.getClass().getName());

    //1. save api
    //we need to validate the input that we get from the request body
    @PostMapping("/departments")
    public Department saveDpet(@Valid @RequestBody Department department )
    {
        //logging the requests
        LOGGER.info("post request made");
        //using the service objects
        return departmentService.saveDept(department); // is the method doesnot exist we need to create it
    }

    //get all the departments
    @GetMapping("/getAll")
    public List<Department> fetchAll()
    {
        //logging the request
        LOGGER.info("getAll request made");
        return departmentService.fetchAllDept();
    }

    //getting a single record
    @GetMapping("/getDept/{id}")
    public Department fetchDept(@PathVariable Long id) throws DepartmentNotFound {
        return departmentService.getById(id);
    }

    //delete mapping
    @DeleteMapping("/del/{id}")
    public String deleteDept(@PathVariable Long id)
    {
        departmentService.deleteDpet(id);
        return "department deleted";
    }

    //updating
    @PutMapping("/update/{id}")
    public Department updateDept(@PathVariable Long id, @RequestBody Department department)
    {
        //logging the update request
        LOGGER.info("update request made");
        //returning the updated department
        return departmentService.updateDept(id , department);
    }

    // adding endpoints for custom functionality

    // getting the department by name
    @GetMapping("/department/{name}")
    public Department findByName(@PathVariable String name)
    {
        return departmentService.findByName(name);
    }


}
