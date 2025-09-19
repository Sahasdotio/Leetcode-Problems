

with fo as (select *, row_number() over(partition by customer_id order by order_date) as rn from Delivery)
select round(avg(case when order_date = customer_pref_delivery_date then 1 else 0 end)*100,2) as immediate_percentage from fo where rn=1