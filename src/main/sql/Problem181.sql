# Write your MySQL query statement below
SELECT e.Name AS Employee
FROM Employee AS e
  LEFT OUTER JOIN Employee AS m
    ON e.ManagerId = m.Id
WHERE m.Id IS NOT NULL
      AND e.Salary > m.Salary