# Write your MySQL query statement below
SELECT Request_at AS Day, ROUND(SUM(Count * StatusType) / SUM(Count), 2) AS `Cancellation Rate`
FROM (
       SELECT Request_at, SUM(Count) AS Count, StatusType
       FROM (
              SELECT b.Request_at, COUNT(*) AS Count, CASE WHEN b.Status = 'completed' THEN 0 ELSE 1 END AS StatusType
              FROM Users AS a
                INNER JOIN Trips AS b
                  ON a.Banned = 'No'
                     AND a.Role = 'client'
                     AND a.Users_Id = b.Client_Id
                     AND b.Request_at BETWEEN '2013-10-01' AND '2013-10-03'
              GROUP BY b.Request_at, b.Status
            ) AS a
       GROUP BY Request_at, StatusType
     ) AS a GROUP BY Request_at