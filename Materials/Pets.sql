
-- connect 'jdbc:derby://localhost/pets;create=true'
-- connect 'jdbc:derby:pets;create=true'

-- This database is my take on the solution for the Cats and Dogs exercise. Yours may
-- be very different. Or if SQL confuses you then just use this implementation as-is.

drop table app.customers;

create table app.customers (
  id int primary key GENERATED ALWAYS as IDENTITY,
  name varchar(20) not null,
  numCats int not null check(numCats>=0),
  numDogs int not null check(numDogs>=0)
);

insert into app.customers (name, numCats, numDogs) values ('Chris',   3,1);
insert into app.customers (name, numCats, numDogs) values ('Stacy',   2,2);
insert into app.customers (name, numCats, numDogs) values ('Joe',     4,8);
insert into app.customers (name, numCats, numDogs) values ('Megan',  25,0);
insert into app.customers (name, numCats, numDogs) values ('Bill',    1,3);
insert into app.customers (name, numCats, numDogs) values ('Richard', 0,1);

select * from app.customers where numCats>3;

select * from app.customers where numCats+numDogs>8;

select * from app.customers where (numCats=0 AND numDogs>0) OR (numDogs=0 AND numCats>0);