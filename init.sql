drop database eparking;
create database eparking;

use eparking;

create table tbl_customer(
	id int auto_increment,
	fullname varchar(255) not null,
    identity_card varchar(255) not null,
    telephone varchar(255) not null unique,
    address varchar(255) not null,
    username varchar(255) not null unique,
    password varchar(255) not null,
    primary key(id)
);

INSERT INTO `eparking`.`tbl_customer` (`fullname`, `identity_card`, `telephone`, `address`, `username`, `password`) VALUES ('Hoang Dinh Loc', '038012341235', '0976542732', 'Thanh Xuan', 'lochd', '123456');

