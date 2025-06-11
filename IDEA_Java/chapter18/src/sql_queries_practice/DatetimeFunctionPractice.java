package sql_queries_practice;
/*
INSERT INTO news
VALUES (1, 'Beijing News', CURRENT_TIMESTAMP()),
(2, 'Shanghai News', NOW()),
(3, 'Shenzhen News', NOW())

-- Show all the news with only date, not time
SELECT id, content, DATE(send_time) AS send_date FROM news

-- Show all the news posted within the last ten minutes
SELECT * FROM news
WHERE TIMEDIFF(NOW(),send_time) < '00:10:00'
-- Alternatively:
SELECT * FROM news
WHERE DATE_ADD(send_time, INTERVAL 10 MINUTE)  >= NOW()

-- How many days are there between 2011-11-11 and 1990-01-01?
SELECT DATEDIFF('2011-11-11','1990-01-01')

SELECT DATEDIFF('2025-06-05', '1997-12-09')

SELECT DATEDIFF(DATE_ADD('1997-12-09',INTERVAL 80 YEAR),NOW())

 */
public class DatetimeFunctionPractice {
}
