create database examModule3;
use examModule3;

create table category(
                         id int auto_increment,
                         name varchar(50),
                         primary key (id)
);

create table product
(
    id int auto_increment,
    name varchar(50) not null,
    price double not null,
    quantity int not null,
    color varchar(50) not null ,
    description varchar(255) ,
    categoryId int,
    primary key (id),
    foreign key (categoryId) references category(id)
);

create view productDetail as
select p.*, c.name as category
from product p
         join examModule3.category c on c.id = p.categoryId;

create trigger deleteProduct
    before delete on category for each row
    delete from product where product.categoryId = old.id;

delete  from  category where id = 1
