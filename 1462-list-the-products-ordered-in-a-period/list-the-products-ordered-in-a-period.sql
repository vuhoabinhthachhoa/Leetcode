/* Write your T-SQL query statement below */
select prd.product_name, sum(od.unit) as unit
from products prd
join orders od on od.product_id = prd.product_id
where year(od.order_date) = 2020 and month(od.order_date) = 2
group by prd.product_id, prd.product_name
having sum(od.unit) >= 100
