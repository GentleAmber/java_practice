package sql_queries_practice;
/*
-- Query different jobs where some employees get commission fees
SELECT job FROM emp WHERE commission IS NOT NULL
GROUP BY job

-- Query employees that were hired on the 4th last day of each month
SELECT ename, hiredate from emp
WHERE MONTH(DATE_ADD(hiredate,INTERVAL 4 DAY))  - MONTH(hiredate) = 1 AND MONTH(DATE_ADD(hiredate,INTERVAL 3 DAY))  - MONTH(hiredate) = 0
-- Alternatively:
SELECT ename, date(hiredate) FROM emp
WHERE LAST_DAY(hiredate) - 3 = DATE(hiredate)

-- Query employees that were hired 12 years ago or earlier than that
SELECT ename, hiredate FROM emp
WHERE DATE_ADD(hiredate,INTERVAL 12 YEAR) <= NOW()

-- Display the names of employees with first letter in lowercase
SELECT CONCAT(LOWER(LEFT(ename,1)),SUBSTR(ename,2))
FROM emp

-- Display the names that contain exactly 5 letters
SELECT ename from emp
WHERE LENGTH(ename) = 5

-- Display the names that don't contain "s"/"S"
SELECT ename FROM emp
WHERE ename NOT LIKE '%s%' OR '%S%'

-- Display all the names, replacing a with A
SELECT REPLACE(ename,'a','A') FROM emp

-- Display employees that have worked over 10 years or equal to 10 years
SELECT ename, hiredate FROM emp
WHERE DATE_ADD(hiredate, INTERVAL 10 year) <= NOW()

-- Display employees' names and hiredates, order by hiredate (old employees come first)
SELECT ename, hiredate FROM emp
ORDER BY hiredate

-- Display all the employee's names, order by the month of their hiredate. If two have the same months, put the older employee first
SELECT ename, hiredate FROM emp
ORDER BY MONTH(hiredate), YEAR(hiredate)
 */
public class Homework03 {
}
