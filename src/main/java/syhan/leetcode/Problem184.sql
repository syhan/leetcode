# Write your MySQL query statement below

SELECT r.Department, e.Name AS Employee, e.Salary
FROM Employee AS e
  INNER JOIN (
               SELECT d.Name AS Department, d.Id AS DepartmentId, MAX(e.Salary) AS Salary
               FROM Employee AS e
                 INNER JOIN Department AS d
                   ON e.DepartmentId = d.Id
               GROUP BY d.Name, d.Id
             ) AS r
    ON e.Salary = r.Salary
       AND e.DepartmentId = r.DepartmentId
