
-- connect 'jdbc:derby:pets;create=true';
connect 'jdbc:derby://localhost/pets;create=true'

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
