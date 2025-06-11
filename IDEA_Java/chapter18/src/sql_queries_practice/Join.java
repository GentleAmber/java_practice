package sql_queries_practice;

/*
-- Query the number of employees in each department, showing 0 for departments with no employees.
SELECT department.deptno, dname, location, IFNULL(employee_num, 0) AS employee_num
FROM department LEFT JOIN (
    SELECT count(ename) AS employee_num, deptno FROM emp
    GROUP BY deptno
  ) temp ON department.deptno = temp.deptno



 */
public class Join {
}
