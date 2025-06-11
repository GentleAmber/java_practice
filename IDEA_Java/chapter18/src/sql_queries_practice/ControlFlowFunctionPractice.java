package sql_queries_practice;

/*
SELECT IFNULL(NULL,'abc')

-- select from emp table, if managerno is null, display "MANAGER"
SELECT ename, IF(managerno IS NULL,'MANAGER',managerno)
FROM emp
-- alternatively:
SELECT ename, IFNULL(managerno,'MANAGER')
FROM emp
 */
public class ControlFlowFunctionPractice {
    public static void main(String[] args) {
        System.out.println("This directory is used to store query practice I have done with mysql");
    }
}
