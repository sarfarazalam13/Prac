# Write your MySQL query statement below
SELECT id
FROM Weather W
LEFT JOIN (SELECT temperature AS prev_temp, DATE_ADD(recordDate, INTERVAL 1 DAY)  as date FROM Weather) AS WN ON W.recordDate=WN.date
WHERE temperature>prev_temp