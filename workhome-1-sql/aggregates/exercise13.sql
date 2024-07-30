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

select facs.facid, facs.name,
	trim(to_char(sum(bks.slots)/2.0, '9999999999999999D99')) as "Total Hours"

	from cd.bookings bks
	inner join cd.facilities facs
		on facs.facid = bks.facid
	group by facs.facid, facs.name
order by facs.facid;