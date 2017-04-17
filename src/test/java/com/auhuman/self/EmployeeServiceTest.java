package com.auhuman.self;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collections;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class EmployeeServiceTest {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    List<Boolean> expected = Collections.emptyList();

    @Test
    public void testBooleanSelect(){

        List<Boolean> actual = employeeService.booleanSelect();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCaseExpression(){
        List<Boolean> actual = employeeRepository.caseDescription();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCaseSelect(){
        List<Boolean> actual = employeeService.caseSelect();
        Assert.assertEquals(expected, actual);
    }

    /*@Test
    public void testIsNotNullExpression(){
        List<Boolean> actual = employeeRepository.isNotNullDescription();
        Assert.assertEquals(expected, actual);
    }*/
}
