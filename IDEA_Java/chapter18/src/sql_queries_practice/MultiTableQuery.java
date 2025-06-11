package sql_queries_practice;

public class MultiTableQuery {
/*
-- show all the employees' name, salary and department name
SELECT ename, salary, dname
  FROM emp, department
  WHERE emp.deptno = department.deptno

-- show all the employees' name, salary and grade of their salary
SELECT ename, salary, grade
FROM emp, salgrade
WHERE salary BETWEEN lowest_sal AND highest_sal

-- Self-join example: show employee's name and his/her manager's name:
SELECT worker.ename AS employee, boss.ename AS manager
FROM emp worker, emp boss
WHERE worker.managerno = boss.empno
 */
}
