# Write your MySQL query statement below
SELECT DISTINCT a.Num AS ConsecutiveNums
FROM Logs AS a
  INNER JOIN Logs AS b
    ON a.Num = b.Num
       AND a.Id - 1 = b.Id
  INNER JOIN Logs AS c
    ON a.Num = c.Num
       AND a.Id + 1 = c.Id
