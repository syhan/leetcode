# Write your MySQL query statement below
SELECT b.Salary AS SecondHighestSalary
FROM (SELECT Salary FROM Employee ORDER BY Salary DESC LIMIT 1) AS a
  LEFT OUTER JOIN Employee AS b
    ON a.Salary > b.Salary
ORDER BY b.Salary DESC
LIMIT 1