package sql_queries_practice;

public class SubQuery {
    /*
    -- Query info of employees whose salary are higher than the average salary in their department
SELECT *
FROM (
  SELECT AVG(salary) AS average, deptno FROM emp
  GROUP BY deptno) avgsal, emp
WHERE emp.deptno = avgsal.deptno AND salary > average

-- Query info of employees whose salary are the highest among their departments
SELECT ename, salary, emp.deptno, job FROM emp, (
SELECT MAX(salary) AS max_salary, deptno FROM emp GROUP BY deptno) maxsal
WHERE emp.deptno = maxsal.deptno AND salary = max_salary

-- Query every department's info: deptno, deptname, location, number of employees
SELECT department.deptno, dname, location, employee_num FROM department,
(SELECT COUNT(ename) AS employee_num, deptno
FROM emp
GROUP BY deptno) temp
WHERE department.deptno = temp.deptno


     */
}
