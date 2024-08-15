CREATE TABLE parts (
     id bigint PRIMARY KEY,
     part_type_id bigint,
     manufacture_id bigint,
     cost INTEGER NOT NUll,
     rating DECIMAL (1,1) DEFAULT 3,
     quantity INTEGER NOT NULL,
     FOREIGN KEY (part_type_id) REFERENCES part_type (id),
     FOREIGN KEY (manufacture_id) REFERENCES manufacture (id)
)