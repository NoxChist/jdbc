INSERT INTO jdbc.CUSTOMERS (name, surname, age, phone_number)
VALUES
    ('Ivan', 'Ivanov', 28, '123-456-7890'),
    ('Sergei', 'Kuznetsov', 42, '555-123-4567'),
    ('Ivan', 'Sokolov', 23, '444-555-6666'),
    ('Alexey', 'Vasiliev', 45, '333-444-5555'),
    ('Natalia', 'Mikhailova', 20, '999-111-2222'),
    ('alexey', 'Morozov', 38, '666-777-8888'),
    ('Sergei', 'Golubev', 26, '876-543-2109'),
    ('ALEXEY', 'Orlov', 32, '987-654-3210'),
    ('Vladimir', 'Antonov', 41, '123-987-6543');

INSERT INTO jdbc.ORDERS (date, customer_id, product_name,amount)
VALUES
    ('2023-01-12', 1, 'Product A', 10),
    ('2023-01-12', 4, 'Product A', 3),
    ('2023-01-12', 2, 'Product B', 1),
    ('2023-01-12', 6, 'Product A', 15),
    ('2023-01-13', 3, 'Product C', 5),
    ('2023-01-13', 9, 'Product C', 2),
    ('2023-01-13', 5, 'Product C', 7),
    ('2023-01-13', 4, 'Product A', 16),
    ('2023-01-13', 6, 'Product A', 8),
    ('2023-01-14', 1, 'Product B', 9),
    ('2023-01-14', 2, 'Product B', 4),
    ('2023-01-14', 7, 'Product A', 12),
    ('2023-01-15', 5, 'Product C', 16);