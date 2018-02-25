# Write your MySQL query statement below
SELECT a.Id
FROM Weather AS a
  INNER JOIN Weather AS b
    ON a.Date = DATE_ADD(b.Date, INTERVAL 1 DAY)
       AND a.Temperature > b.Temperature