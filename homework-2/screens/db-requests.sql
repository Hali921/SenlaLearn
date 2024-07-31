SELECT reviews.massage FROM reviews
INNER JOIN parts
ON reviews.parts_id = parts.id;


SELECT clients.firstname, lastname FROM clients
INNER JOIN orders
ON orders.clients_id = clients.id
WHERE orders.orders_date = "01-07-2024";


SELECT manufacture.name FROM manufacture
INNER JOIN parts
ON parts.manufacture_id = manufacture.id
WHERE parts.rating > 3;
