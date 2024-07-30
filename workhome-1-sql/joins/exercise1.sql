CREATE TABLE cd.members
    (
       memid integer NOT NULL,
       surname character varying(200) NOT NULL,
       firstname character varying(200) NOT NULL,
       address character varying(300) NOT NULL,
       zipcode integer NOT NULL,
       telephone character varying(20) NOT NULL,
       recommendedby integer,
       joindate timestamp NOT NULL,
       CONSTRAINT members_pk PRIMARY KEY (memid),
       CONSTRAINT fk_members_recommendedby FOREIGN KEY (recommendedby)
            REFERENCES cd.members(memid) ON DELETE SET NULL
    );

INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, joindate)
VALUES (0,	'GUEST', 'GUEST', 'GUEST', 0, '(000) 000-0000', '2012-07-01 00:00:00');
INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, joindate)
VALUES (1, 'Smith', 'Darren', '8 Bloomsbury Close, Boston',	4321, '555-555-5555', '2012-07-02 12:02:05');
INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, joindate)
VALUES (2, 'Smith',	'Tracy', '8 Bloomsbury Close, New York', 4321, '555-555-5555', '2012-07-02 12:08:23' );
INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, joindate)
VALUES (3, 'Rownam', 'Tim',	'23 Highway Way, Boston', 23423, '(844) 693-0723', '2012-07-03 09:32:15');
INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate)
VALUES (4,	'Joplette',	'Janice',	'20 Crossing Road, New York', 234, '(833) 942-4710', 1,	'2012-07-03 10:25:05');
INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate)
VALUES (5,	'Butters', 'Gerald', '1065 Huntingdon Avenue, Boston', 56754, '(844) 078-4130', 1, '2012-07-09 10:44:09');
INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, joindate)
VALUES (6,	'Tracy', 'Burton', '3 Tunisia Drive, Boston', 45678, '(822) 354-9973', '2012-07-15 08:52:55');
INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate)
VALUES (7,	'Dare', 'Nancy', '6 Hunting Lodge Way, Boston', 10383, '(833) 776-4001', 4, '2012-07-25 08:59:12');
INSERT INTO cd.members (memid, surname, firstname, address, zipcode, telephone, recommendedby, joindate)
VALUES (8,	'Farrel', 'David', '3 Bloomsbury Close, Reading, 00234', 234, '(811) 433-2547', 3, '2012-07-25 16:02:35');

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

SELECT boo.starttime
FROM
cd.bookings boo
INNER JOIN cd.members mems
ON mems.memid = boo.memid
WHERE
mems.firstname='David'
AND mems.surname='Farrell';
