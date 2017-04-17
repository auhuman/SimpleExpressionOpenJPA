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

    @Test
    public void testBooleanSelect(){
        List<Boolean> expected = Collections.emptyList();
        List<Boolean> actual = employeeService.booleanSelect();
        Assert.assertEquals(expected, actual);
    }
}
