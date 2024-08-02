SELECT reviews.massage FROM reviews
INNER JOIN parts
ON reviews.parts_id = parts.id;


SELECT clients.firstname, clients.lastname FROM clients
INNER JOIN orders
ON orders.client_id = clients.id;


SELECT manufacture.name FROM manufacture
INNER JOIN parts
ON parts.manufacture_id = manufacture.id
WHERE parts.rating > 3;
