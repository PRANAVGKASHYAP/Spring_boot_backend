package com.example.demo.controller;

import com.example.demo.entity.Department;
import com.example.demo.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private DepartmentService service; // from the controller we need to call the mock controller

    private Department department;

    @BeforeEach
    void setUp() {
        department = Department.builder()
                .name("dept3")
                .address("bengaluru")
                .code("103")
                .id(100L)
                .build();

    }


    // for this test case for the controller we are testing the save and fetch mapping

    @Test
    void saveDept() throws Exception {
        //the save dept service takes the dept obj as the input and returns the saved dept as the output

        //creating the input dept
        Department inpDept = Department.builder()
                .name("dept3")
                .address("bengaluru")
                .code("103")
                .build();

        Mockito.when(service.saveDept(inpDept)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.post("/departments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(  "{ \"name\" : \"dept3\" , \"address\" : \"bengaluru\" , \"code\" : \"103\" }"  )
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void fetchDept() throws Exception
    {
        Mockito.when(service.getById(100L)).thenReturn(department);

        mockMvc.perform(MockMvcRequestBuilders.get("/getDept/100")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(department.getName()));

    }

}