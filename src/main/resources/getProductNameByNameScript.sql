SELECT product_name  FROM jdbc.ORDERS
RIGHT JOIN jdbc.CUSTOMERS ON jdbc.ORDERS.customer_id = jdbc.CUSTOMERS.id
WHERE (SELECT LOWER(jdbc.CUSTOMERS.name)) =:name
ORDER BY product_name;
