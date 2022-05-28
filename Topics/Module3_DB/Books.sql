
-- connect 'jdbc:derby://localhost/books;create=true'
-- connect 'jdbc:derby:books;create=true'

-- This database is constructed in the Database Overview lesson.
-- This database is used in the DAO lesson.

drop table app.bookauthors;
drop table app.books;
drop table app.publishers;
drop table app.authors;

create table app.PUBLISHERS (
  id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  name varchar(20) not null,
  address varchar(20) not null,
  phone varchar(20) not null
);

insert into app.PUBLISHERS (name,address,phone) values ('Good Books','AL','1234');
insert into app.PUBLISHERS (name,address,phone) values ('Smarties','NY','5678');

create table app.AUTHORS (
  id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  name varchar(20) not null,
  address varchar(20) not null,
  phone varchar(20) not null
);

insert into app.AUTHORS (name,address,phone) values ('Ben','CA','1111');
insert into app.AUTHORS (name,address,phone) values ('Sarah','TX','5555');
insert into app.AUTHORS (name,address,phone) values ('Pat','CO','5309');

create table app.BOOKS (
  id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
  isbn varchar(20) not null,
  name varchar(20) not null,
  price double not null check(price>=0.0),
  publisher int not null REFERENCES APP.PUBLISHERS(id)
);

insert into app.BOOKS (isbn,name,price,publisher) values ('1234','Learn C++',9.95,1);
insert into app.BOOKS (isbn,name,price,publisher) values ('5678','Learn Java',50.0,2);
insert into app.BOOKS (isbn,name,price,publisher) values ('9981','Using Perl',2.46,2);
insert into app.BOOKS (isbn,name,price,publisher) values ('1055','JavaScript',10.00,1);
insert into app.BOOKS (isbn,name,price,publisher) values ('5679','COBOL',50.00,1);

create table app.BOOKAUTHORS (
  bookid int not null REFERENCES APP.BOOKS(id),
  authorid int not null REFERENCES APP.AUTHORS(id)
);

insert into app.BOOKAUTHORS (bookid,authorid) values (1,1);
insert into app.BOOKAUTHORS (bookid,authorid) values (2,1);
insert into app.BOOKAUTHORS (bookid,authorid) values (2,3);
insert into app.BOOKAUTHORS (bookid,authorid) values (3,2);
insert into app.BOOKAUTHORS (bookid,authorid) values (3,1);
insert into app.BOOKAUTHORS (bookid,authorid) values (3,3);
insert into app.BOOKAUTHORS (bookid,authorid) values (4,2);
insert into app.BOOKAUTHORS (bookid,authorid) values (5,1);
insert into app.BOOKAUTHORS (bookid,authorid) values (5,2);

