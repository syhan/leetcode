# Write your MySQL query statement below
SELECT DISTINCT d.*
FROM stadium AS a
  INNER JOIN stadium AS b # tomorrow
    ON a.id = b.id - 1
       AND a.people >= 100
       AND b.people >= 100
  INNER JOIN stadium AS c # the day after tomorrow
    ON b.id = c.id - 1
       AND c.people >= 100
  INNER JOIN stadium AS d
    ON a.id = d.id
       OR a.id = d.id - 1
       OR a.id = d.id - 2
ORDER BY d.id