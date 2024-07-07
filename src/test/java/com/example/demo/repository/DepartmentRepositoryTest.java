package com.example.demo.repository;

import com.example.demo.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.*;


// the data jpa test is used to create and store the data only when the testing is done later the test data is removed
@DataJpaTest
class DepartmentRepositoryTest {


    //getting the required objects
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private TestEntityManager entityManager;

    @BeforeEach
    void setUp() {

        //setting up a mock entity to test the .getById() method
        Department department = Department.builder()
                .name("testing")
                .code("100")
                .address("testing_addr")
                .build();
        entityManager.persist(department);
    }

    @Test
    @DisplayName("this method need to find only the dept names of dept id that actually exist")
    public void findValidId()
    {
        Department dept = departmentRepository.findById(1L).get();
        assertEquals("testing", dept.getName());
    }
}