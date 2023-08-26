# Write your MySQL query statement below

with salary_category as
(
    select 'Low Salary' as category
    union
    select 'Average Salary'
    union
    select 'High Salary'
),
salary_accounts as
(
select
    case 
        when income < 20000 then 'Low Salary'
        when income <= 50000 then 'Average Salary'
        else 'High Salary' end category,
    count(account_id) as accounts_count
from Accounts
group by 1
)

select
    sc.category,
    coalesce(sa.accounts_count, 0) as accounts_count
from salary_category sc
left join salary_accounts sa
    on sc.category = sa.category