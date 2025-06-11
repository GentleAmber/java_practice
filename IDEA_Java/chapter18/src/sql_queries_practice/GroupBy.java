package sql_queries_practice;

/*
-- Select average salary and max salary for each department
SELECT AVG(salary), MAX(salary), deptno FROM emp
GROUP BY deptno;

-- Select average salary and max salary for each job in each department
SELECT AVG(salary), MAX(salary), deptno, job FROM emp
GROUP BY deptno, job;

-- Select deptno whose average salary is lower than 5600 (should be deptno 10)
SELECT AVG(salary), deptno FROM emp
GROUP BY deptno
HAVING AVG(salary) <= 5600;
 */
public class GroupBy {
}
