-- # Write your MySQL query statement below
-- select query_name,(round(sum(rating/position)),2) as quality,round(sum(case when rating<3 then rating else 0 end)/count(*) as poor_query_percentage from Queries group by query_name;
SELECT 
    query_name,
    ROUND(avg(rating / position), 2) AS quality,
    ROUND(
        SUM(CASE WHEN rating < 3 THEN 1 ELSE 0 END)*100 / COUNT(*),
        2
    ) AS poor_query_percentage
FROM Queries
GROUP BY query_name;
