package sql_queries_practice;
/*

CREATE TABLE department_school(
  departmentid char(2),
  deptname VARCHAR(32) PRIMARY KEY
)

CREATE TABLE class(
  classid char(3) PRIMARY KEY,
  `subject` VARCHAR(32),
  deptname VARCHAR(32),
  enrolltime YEAR,
  num INT,
  FOREIGN KEY (deptname) REFERENCES department_school(deptname)
)

DROP TABLE if EXISTS student
CREATE TABLE student(
  studentid CHAR(4) PRIMARY KEY,
  `name` VARCHAR(4) NOT NULL,
  age INT,
  classid char(3),
  FOREIGN KEY (classid) REFERENCES class(classid)
)

ALTER TABLE department_school MODIFY
departmentid char(2) UNIQUE NOT NULL

ALTER TABLE department_school MODIFY
departmentid char(3)

INSERT INTO department_school VALUES
  ('00','计算机'),
  ('01','化学'),
  ('02','数学'),
  ('03','中文'),
  ('04','经济')

UPDATE department_school SET departmentid = CONCAT('0',departmentid)

INSERT INTO class VALUES
('101','软件','计算机','1995',20),
('102','微电子','计算机','1996',30)

INSERT INTO class VALUES
('111','无机化学','化学','1995',29),
('112','高分子化学','化学','1996',25),
('121','统计数学','数学','1995',20),
('131','现代语言','中文','1996',20),
('141','国际贸易','经济','1997',30),
('142','国际金融','经济','1996',14)

INSERT INTO student VALUES
('8101','张三',18,'101'),
('8102','钱四',16,'121'),
('8103','王玲',17,'131'),
('8105','李飞',19,'102'),
('8109','赵四',18,'141'),
('8110','李可',20,'142'),
('8201','张飞',18,'111'),
('8302','周瑜',16,'112'),
('8203','王亮',17,'111'),
('8305','董庆',19,'102'),
('8409','赵龙',18,'101'),
('8510','李丽',20,'142')

SELECT * FROM student WHERE `name` LIKE '李%'

SELECT department_school.deptname, COUNT(*) AS class_num FROM department_school, class
WHERE class.deptname = department_school.deptname
GROUP BY department_school.deptname
HAVING class_num > 1

SELECT departmentid, class.deptname, SUM(num) FROM department_school, class
WHERE department_school.deptname = class.deptname
GROUP BY department_school.deptname
HAVING SUM(num) >= 30

INSERT into department_school VALUES('005',' 物理')

START TRANSACTION
DELETE FROM student WHERE `name` = '张三'
UPDATE class SET num = num - 1 WHERE classid = '101'
COMMIT

SELECT * FROM student
 */
public class Homework05 {
}
