# Write your MySQL query statement below

SELECT b.Name AS Department, a.Name AS Employee, a.Salary
FROM (
       SELECT a.Name, a.DepartmentId, COUNT(DISTINCT b.Salary) + 1 AS DenseRank, a.Salary
       FROM Employee AS a
         LEFT OUTER JOIN Employee AS b
           ON a.DepartmentId = b.DepartmentId
              AND a.Salary < b.Salary
              AND a.Id <> b.Id
       GROUP BY a.DepartmentId, a.Name, a.Salary
     ) AS a
  INNER JOIN Department AS b
    ON a.DepartmentId = b.Id
WHERE a.DenseRank <= 3
ORDER BY b.Id ASC, a.Salary DESC