/* Write your T-SQL query statement below */
select teacher_id, count(distinct subject_id) as cnt
from teacher
group by teacher_id