package sql_queries_practice;

public class View {
/*
DROP view emp_view

CREATE VIEW emp_view AS
  SELECT empno, ename, dname, grade AS salary_grade
  FROM emp JOIN department
  ON emp.deptno = department.deptno JOIN salgrade ON emp.salary >= salgrade.lowest_sal AND emp.salary <= salgrade.highest_sal


  SELECT * FROM emp_view ORDER BY empno
 */
}
