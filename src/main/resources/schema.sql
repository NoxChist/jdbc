CREATE SCHEMA jdbc;
CREATE TABLE jdbc.CUSTOMERS
(
    id           serial      NOT NULL,
    name         varchar(20) NOT NULL,
    surname      varchar(20) NOT NULL,
    age          int         NOT NULL,
    phone_number varchar(20) NOT NULL UNIQUE,
    PRIMARY KEY (id)
);

CREATE TABLE jdbc.ORDERS
(
    id           serial       NOT NULL,
    date         date         NOT NULL,
    customer_id  int          NOT NULL,
    product_name varchar(200) NOT NULL,
    amount       int          NOT NULL,

    PRIMARY KEY (id),
    CONSTRAINT fk_CustOrder
        FOREIGN KEY (customer_id)
            REFERENCES jdbc.CUSTOMERS (id)
);
