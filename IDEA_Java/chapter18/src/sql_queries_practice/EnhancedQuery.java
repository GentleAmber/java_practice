package sql_queries_practice;

/*
-- select employees who joined the company after 2021-01-01
SELECT * FROM emp WHERE hiredate > '2021-01-01'

-- select employees where the second character of their names is 'o'
SELECT ename, salary FROM emp
WHERE ename LIKE '_o%'

-- Paged query. 3 records per page. The following query shows the 1st and then the 2nd page
SELECT * FROM emp
ORDER BY empno
LIMIT 0,3

SELECT * FROM emp
ORDER BY empno
LIMIT 3,3

-- Show the number of all employees and employees that are not manager
SELECT COUNT(*) AS `sum`, COUNT(managerno) AS not_manager
FROM emp
-- alternatively:
SELECT COUNT(*) AS `sum`, COUNT(IF(job LIKE '%Manager', NULL, 1)) AS not_manager
FROM emp

-- calculate average salary of every department whose avg salary > 5000. Display in a descending order and only show the first two records
SELECT deptno, AVG(salary) FROM emp
GROUP BY deptno
HAVING AVG(salary) > 5600
ORDER BY AVG(salary) DESC
LIMIT 0,2



 */
public class EnhancedQuery {
}
