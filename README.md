# SimpleExpressionOpenJPA
This project shows that OpenJPA 2.4.1 has some issue in processing Simple Expression in select clause while [Hibernate](https://github.com/auhuman/SimpleExpressionHibernate) is successful in processing the same. Below is the error when you run 

``` 
mvn clean install
```

Open JPA Error

```
Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 1.997 sec <<< FAILURE! - in com.auhuman.self.EmployeeServiceTest
testBooleanSelect(com.auhuman.self.EmployeeServiceTest)  Time elapsed: 0.131 sec  <<< ERROR!
org.apache.openjpa.persistence.ArgumentException: "Encountered "not" at character 8, but expected: ["(", "+", "-", ":", "?", "ABS", "AVG", "CASE", "COALESCE", "CONCAT", "COUNT", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "DISTINCT", "ENTRY", "INDEX", "KEY", "LENGTH", "LOCATE", "LOWER", "MAX", "MIN", "MOD", "NEW", "NULLIF", "OBJECT", "SIZE", "SQRT", "SUBSTRING", "SUM", "TRIM", "TYPE", "UPPER", "VALUE", <BOOLEAN_LITERAL>, <DATE_LITERAL>, <DECIMAL_LITERAL>, <IDENTIFIER>, <INTEGER_LITERAL>, <STRING_LITERAL2>, <STRING_LITERAL>, <TIMESTAMP_LITERAL>, <TIME_LITERAL>]." while parsing JPQL "select not length(employee_.description) = 0
from Employee employee_". See nested stack trace for original parse error.
	at org.apache.openjpa.kernel.jpql.JPQL.generateParseException(JPQL.java:13180)
	at org.apache.openjpa.kernel.jpql.JPQL.jj_consume_token(JPQL.java:13054)
	at org.apache.openjpa.kernel.jpql.JPQL.select_expression(JPQL.java:1001)
	at org.apache.openjpa.kernel.jpql.JPQL.select_expressions(JPQL.java:930)
	at org.apache.openjpa.kernel.jpql.JPQL.select_clause(JPQL.java:865)
	at org.apache.openjpa.kernel.jpql.JPQL.select_statement(JPQL.java:87)
	at org.apache.openjpa.kernel.jpql.JPQL.parseQuery(JPQL.java:63)
	at org.apache.openjpa.kernel.jpql.JPQLExpressionBuilder$ParsedJPQL.parse(JPQLExpressionBuilder.java:2410)
	at org.apache.openjpa.kernel.jpql.JPQLExpressionBuilder$ParsedJPQL.<init>(JPQLExpressionBuilder.java:2397)
	at org.apache.openjpa.kernel.jpql.JPQLParser.parse(JPQLParser.java:48)
	at org.apache.openjpa.kernel.ExpressionStoreQuery.newCompilation(ExpressionStoreQuery.java:154)
	at org.apache.openjpa.kernel.QueryImpl.newCompilation(QueryImpl.java:678)
	at org.apache.openjpa.kernel.QueryImpl.compilationFromCache(QueryImpl.java:652)
	at org.apache.openjpa.kernel.QueryImpl.compileForCompilation(QueryImpl.java:619)
	at org.apache.openjpa.kernel.QueryImpl.compileForExecutor(QueryImpl.java:688)
	at org.apache.openjpa.kernel.QueryImpl.compile(QueryImpl.java:588)
	at org.apache.openjpa.persistence.EntityManagerImpl.createQuery(EntityManagerImpl.java:1005)
	at org.apache.openjpa.persistence.EntityManagerImpl.createQuery(EntityManagerImpl.java:987)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.springframework.orm.jpa.ExtendedEntityManagerCreator$ExtendedEntityManagerInvocationHandler.invoke(ExtendedEntityManagerCreator.java:344)
	at com.sun.proxy.$Proxy55.createQuery(Unknown Source)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.springframework.orm.jpa.SharedEntityManagerCreator$SharedEntityManagerInvocationHandler.invoke(SharedEntityManagerCreator.java:294)
	at com.sun.proxy.$Proxy55.createQuery(Unknown Source)
	at com.mysema.query.jpa.impl.AbstractJPAQuery.createQuery(AbstractJPAQuery.java:129)
	at com.mysema.query.jpa.impl.AbstractJPAQuery.createQuery(AbstractJPAQuery.java:96)
	at com.mysema.query.jpa.impl.AbstractJPAQuery.list(AbstractJPAQuery.java:248)
	at com.auhuman.self.EmployeeService.booleanSelect(EmployeeService.java:27)
	at com.auhuman.self.EmployeeServiceTest.testBooleanSelect(EmployeeServiceTest.java:23)
```