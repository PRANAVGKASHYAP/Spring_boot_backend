package com.example.demo.service;

import com.example.demo.entity.Department;
import com.example.demo.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

// we can do mock test for each of the classes in each layer in the test folder

@SpringBootTest
class DepartmentServiceTest {

    @Autowired
    private DepartmentService departmentService;

    @MockBean
    private DepartmentRepository departmentRepository; // we need to mock the repository class

    @BeforeEach
    void setUp() {
        // this method is called before every test method
        Department dept = Department.builder()
                .name("dept")
                .code("100")
                .address("some_addr")
                .build();
        // we neet to provide this mock bean whenever a service layer func makes a call to the mocked repo layer
        Mockito.when(departmentRepository.findByName("dept")).thenReturn(dept);

    }

    // implementing public Department findByName(String name);
    @Test
    @DisplayName("Get Date based on the input")
    public void whenValidDeptNameGiven_isDeptFound(){

        //give a hardcoded valid dept name and see if the dept is found or not
        String sample = "dept2";

        Department check = departmentService.findByName(sample);

        //checking if the retrieved dept has the same name
        assertEquals(sample , check.getName());

    }
}