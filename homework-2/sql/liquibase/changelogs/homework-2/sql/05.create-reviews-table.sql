CREATE TABLE reviews (
     id bigint PRIMARY KEY,
     client_id bigint,
     parts_id bigint,
     massage VARCHAR(500),
     FOREIGN KEY (client_id) REFERENCES clients (id),
     FOREIGN KEY (parts_id) REFERENCES parts (id)
)