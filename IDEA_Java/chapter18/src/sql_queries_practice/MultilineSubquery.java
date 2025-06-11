package sql_queries_practice;

public class MultilineSubquery {
/*
-- Query employees whose job and department are the same as Grace's, Grace himself not included
SELECT ename, emp.job, emp.deptno
    FROM emp, (
        SELECT job, deptno
        FROM emp
        WHERE ename = 'Grace' ) grace
WHERE emp.job = grace.job AND emp.deptno = grace.deptno AND ename != 'Grace'
-- Alternatively:
SELECT ename, deptno, job
    FROM emp
    WHERE (deptno, job) = (
          SELECT deptno, job
          FROM emp
          WHERE ename = 'Grace'
          ) AND ename != 'Grace'


 */
}
