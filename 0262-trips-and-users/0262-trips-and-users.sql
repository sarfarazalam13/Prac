# Write your MySQL query statement below


SELECT request_at AS day,
        ROUND(SUM(IF(status like '%cancelled%',1,0))/COUNT(*),2) AS "Cancellation Rate"
FROM trips t
WHERE (request_at BETWEEN '2013-10-01' and '2013-10-03')
AND  client_id IN (
    SELECT users_id
    FROM users
    WHERE banned <>"Yes"
)
AND driver_id IN (
    SELECT users_id
    FROM users
    WHERE banned <>"Yes"
)
GROUP BY request_at