/* Write your T-SQL query statement below */
select e1.name 
from Employee e1
where e1.id in (
    select e2.managerId 
    from Employee e2
    group by managerId
    having count(id) >= 5
)

