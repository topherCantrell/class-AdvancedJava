
-- connect 'jdbc:derby://localhost/grades;create=true';
-- connect 'jdbc:derby:grades;create=true';

-- This database is created in the SQL Basics lesson.
-- This database is used in the JDBC lesson.

DROP TABLE APP.GRADES;
DROP TABLE APP.PHONES;

CREATE TABLE APP.PHONES (
  id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  name VARCHAR(20) NOT NULL,
  phone VARCHAR(8) 
);

INSERT INTO APP.PHONES (name,phone) values ('Chris','1234');
INSERT INTO APP.PHONES (name,phone) values ('Ann','9999');
INSERT INTO APP.PHONES (name,phone) values ('Bob','7777');

CREATE TABLE APP.GRADES (
  id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,  
  name int NOT NULL REFERENCES APP.PHONES(id),
  grade INT NOT NULL CHECK (grade>=0),
  subject varchar(20) not null
);

INSERT INTO APP.GRADES (name,subject,grade) values (1,'Math',90);  
INSERT INTO APP.GRADES (name,subject,grade) values (2,'Math',85);
INSERT INTO APP.GRADES (name,subject,grade) values (3,'Math',50);
INSERT INTO APP.GRADES (name,subject,grade) values (1,'Science',78);
INSERT INTO APP.GRADES (name,subject,grade) values (2,'Science',81);
INSERT INTO APP.GRADES (name,subject,grade) values (3,'Science',45);
INSERT INTO APP.GRADES (name,subject,grade) values (1,'History',89);
INSERT INTO APP.GRADES (name,subject,grade) values (2,'History',100);
INSERT INTO APP.GRADES (name,subject,grade) values (3,'History',91);
