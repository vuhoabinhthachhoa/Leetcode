/* Write your T-SQL query statement below */
select distinct ctm.customer_id
from customer ctm
where not exists (
    select product_key
    from product
    except 
    select product_key
    from customer
    where customer_id = ctm.customer_id
)