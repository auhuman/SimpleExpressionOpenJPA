package com.auhuman.self;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByFirstName(String firstName);

    List<Employee> findByLastName(String lastName);

    @Query("select case when e.description IS NOT NULL then true else false end from Employee e")
    List<Boolean> caseDescription();

    /*@Query("select e.description IS NOT NULL from Employee e")
    List<Boolean> isNotNullDescription();*/

}
