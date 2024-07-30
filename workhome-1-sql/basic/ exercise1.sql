CREATE TABLE cd.facilities
(facid INTEGER,
name CHARACTER VARYING(100),
membercost NUMERIC,
guestcost numeric,
initialoutlay numeric,
monthlymaintenance numeric
);

INSERT INTO cd.facilities
VALUES (0, 'Tennis Court 1', 5, 25, 10000, 200);
INSERT INTO cd.facilities
VALUES (1, 'Tennis Court 2', 5, 25, 8000, 200);
INSERT INTO cd.facilities
VALUES (2, 'Badminton Court', 0, 15.5, 4000, 50);
INSERT INTO cd.facilities
VALUES (3,	'Table Tennis',	0, 5, 320, 10);
INSERT INTO cd.facilities
VALUES (4, 'Massage Room 1', 35, 80, 4000, 3000);
INSERT INTO cd.facilities
VALUES (5, 'Massage Room 2', 35, 80, 4000, 3000);
INSERT INTO cd.facilities
VALUES (6, 'Squash Court', 3.5, 17.5, 5000, 80);
INSERT INTO cd.facilities
VALUES (7, 'Snooker Table', 0, 5, 450, 15);
INSERT INTO cd.facilities
VALUES (8, 'Pool Table', 0,	5, 400, 15);

SELECT * FROM cd.facilities;




