# Write your MySQL query statement below
SELECT Name AS Customers
FROM Customers AS c
  LEFT OUTER JOIN Orders AS o
    ON c.Id = o.CustomerId
WHERE o.Id IS NULL