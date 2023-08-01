# Write your MySQL query statement below
select product_name,year,price
from product inner join sales
on product.product_id=sales.product_id;