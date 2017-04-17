package com.auhuman.self;

import com.mysema.query.Tuple;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.support.Expressions;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.CaseBuilder;
import com.mysema.query.types.expr.NumberExpression;
import com.mysema.query.types.path.BooleanPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    EntityManager entityManager;

    List<Boolean> booleanSelect(){
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        QEmployee employee = QEmployee.employee;
        BooleanPath booleanPath = Expressions.booleanPath("isGoodDescription");
        BooleanExpression notNullDesc = QEmployee.employee.description.isNotEmpty();
        return jpaQuery.from(employee).list(notNullDesc);
    }

    List<Boolean> caseSelect(){
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        QEmployee employee = QEmployee.employee;
        BooleanPath booleanPath = Expressions.booleanPath("isGoodDescription");
        BooleanExpression notNullDesc = QEmployee.employee.description.isNotNull();
        BooleanExpression caseExpression = new CaseBuilder().when(QEmployee.employee.description.isNotNull()).then(true).otherwise(false);
        return jpaQuery.from(employee).list(caseExpression);
    }

    void caseGroupBy(){
        JPAQuery jpaQuery = new JPAQuery(entityManager);
        QEmployee employee = QEmployee.employee;
        BooleanPath booleanPath = Expressions.booleanPath("isGoodDescription");
        BooleanExpression caseExpression = new CaseBuilder().when(QEmployee.employee.description.isNotNull()).then(true).otherwise(false);
        BooleanExpression selectList = caseExpression.as(booleanPath);
        NumberExpression<Long> count = QEmployee.employee.count();
        List<Tuple> tuples = jpaQuery.from(employee).groupBy(booleanPath).list(selectList, count);
    }

}
