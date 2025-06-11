package sql_queries_practice;

/*
SELECT dname, emp.deptno, count(ename) FROM department, emp
WHERE department.deptno = emp.deptno
GROUP BY deptno
HAVING COUNT(ename) >= 1

SELECT ename, salary FROM emp
WHERE salary >= (SELECT salary FROM emp WHERE ename = 'Bob')

-- Query employees whose hiredates are later than their bosses'
SELECT emp.ename AS employee_name, emp.hiredate AS employee_hiredate, manager.manager_name AS manager_name, manager_hiredate
  FROM emp left JOIN
    (SELECT ename AS manager_name, hiredate AS manager_hiredate, empno FROM emp WHERE managerno IS NULL) manager
      ON emp.managerno = manager.empno
        WHERE emp.hiredate > manager_hiredate

-- Display department names and their employees' information, as well as those departments without any employees
SELECT dname, emp.* FROM department LEFT JOIN emp
ON department.deptno = emp.deptno

-- Query the names of all the salesmen, as well as their department names
SELECT dname, ename, job FROM department, emp
WHERE department.deptno = emp.deptno AND job = 'Salesperson'

-- Query the names of the employees who work at Sales department
SELECT ename, dname, job FROM department, emp
WHERE department.deptno = emp.deptno AND dname = 'Sales'

-- Query employees whose salary is higher than the average salary in the company
SELECT ename, salary, temp.average_sal
	FROM(
			SELECT AVG(salary) AS average_sal FROM emp
	) temp , emp
	WHERE salary > temp.average_sal

  -- Query employees whose salary is higher than every one's salary in department 30
SELECT ename, salary FROM emp
WHERE salary > ALL (SELECT salary FROM emp WHERE deptno = 30)

  -- Query the num of employees, average salary and average working time of every department
SELECT emp.deptno, dname, COUNT(ename), AVG(salary), AVG(DATEDIFF(NOW(),hiredate)) from emp, department
WHERE emp.deptno = department.deptno
GROUP BY deptno

-- Query the lowest salary of every type of job
SELECT MIN(salary), job FROM emp
GROUP BY job


SELECT MIN(salary) FROM emp
WHERE job = 'Manager'

SELECT ename, (salary + IFNULL(commission,0)) * 12 AS annual_salary, job, dname FROM emp, department
WHERE emp.deptno = department.deptno
ORDER BY annual_salary
 */
public class Homework04 {
}
