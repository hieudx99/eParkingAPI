drop database eparking;
create database eparking;
use eparking;

CREATE TABLE tbl_user (
  id            integer NOT NULL AUTO_INCREMENT, 
  fullname      varchar(255) NOT NULL, 
  identity_card varchar(255) NOT NULL UNIQUE, 
  telephone     varchar(255) NOT NULL UNIQUE, 
  address       varchar(255) NOT NULL, 
  username      varchar(255) NOT NULL UNIQUE, 
  password      varchar(255) NOT NULL, 
  roleid        integer NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tbl_car (
  id            integer NOT NULL AUTO_INCREMENT, 
  name          varchar(255) NOT NULL, 
  color         varchar(255) NOT NULL, 
  license_plate varchar(255) NOT NULL, 
  seat_number   integer NOT NULL, 
  userid        integer NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tbl_role (
  id   integer NOT NULL AUTO_INCREMENT, 
  name varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tbl_parking_slot (
  id     integer NOT NULL AUTO_INCREMENT, 
  name   varchar(255) NOT NULL UNIQUE, 
  status varchar(255) NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tbl_bill (
  id               integer NOT NULL AUTO_INCREMENT, 
  create_date      datetime NOT NULL, 
  start_time       datetime NOT NULL, 
  end_time         datetime NOT NULL, 
  total            double NOT NULL, 
  payment_status   varchar(255) NOT NULL, 
  userid           integer NOT NULL, 
  payment_methodid integer NOT NULL, 
  parking_slotid   integer NOT NULL, 
  carid            integer NOT NULL, 
  PRIMARY KEY (id));
CREATE TABLE tbl_payment_method (
  id   integer NOT NULL AUTO_INCREMENT, 
  name varchar(255) NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE tbl_car ADD CONSTRAINT FKtbl_car592996 FOREIGN KEY (userid) REFERENCES tbl_user (id);
ALTER TABLE tbl_user ADD CONSTRAINT FKtbl_user774296 FOREIGN KEY (roleid) REFERENCES tbl_role (id);
ALTER TABLE tbl_bill ADD CONSTRAINT FKtbl_bill871129 FOREIGN KEY (userid) REFERENCES tbl_user (id);
ALTER TABLE tbl_bill ADD CONSTRAINT FKtbl_bill625386 FOREIGN KEY (payment_methodid) REFERENCES tbl_payment_method (id);
ALTER TABLE tbl_bill ADD CONSTRAINT FKtbl_bill772327 FOREIGN KEY (parking_slotid) REFERENCES tbl_parking_slot (id);
ALTER TABLE tbl_bill ADD CONSTRAINT FKtbl_bill706365 FOREIGN KEY (carid) REFERENCES tbl_car (id);

INSERT INTO `eparking`.`tbl_role`(`name`) values ('customer');
INSERT INTO `eparking`.`tbl_role`(`name`) VALUES ('admin');
INSERT INTO `eparking`.`tbl_user` (`fullname`, `identity_card`, `telephone`, `address`, `username`, `password`, `roleid`) VALUES ('Vu Duc Duy', '038099887766', '0971368712', 'Hoang Mai', 'duyvd', '123456', '1');

