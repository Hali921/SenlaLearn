CREATE TABLE orders (
     id bigint PRIMARY KEY,
     order_date DATE,
     client_id bigint,
     parts_id bigint,
     FOREIGN KEY (client_id) REFERENCES clients (id),
     FOREIGN KEY (parts_id) REFERENCES parts (id)
)