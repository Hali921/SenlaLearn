CREATE TABLE cd.bookings
    (
       bookid integer NOT NULL,
       facid integer NOT NULL,
       memid integer NOT NULL,
       starttime timestamp NOT NULL,
       slots integer NOT NULL,
       CONSTRAINT bookings_pk PRIMARY KEY (bookid),
       CONSTRAINT fk_bookings_facid FOREIGN KEY (facid) REFERENCES cd.facilities(facid),
       CONSTRAINT fk_bookings_memid FOREIGN KEY (memid) REFERENCES cd.members(memid)
    );

INSERT INTO cd.bookings
VALUES (0,	3,	1,	'2012-07-03 11:00:00',	2),
(1,	4,	1,	'2012-07-03 08:00:00',	2),
(2,	6,	0,	'2012-07-03 18:00:00',	2),
(3,	7,	1,	'2012-07-03 19:00:00',	2),
(4,	8,	1,	'2012-07-03 10:00:00',	1),
(5,	8,	8,	'2012-07-03 15:00:00',	1);

SELECT facid, SUM(slots) AS "Total Slots"
FROM cd.bookings
GROUP BY facid
HAVING SUM(slots) > 1000
ORDER BY facid;