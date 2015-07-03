create database schooldb;


CREATE TABLE school (
  _id Integer NOT NULL  AUTO_INCREMENT,
  name varchar(60) ,
  code varchar(3) NOT NULL,
  address varchar(200),
  emailDomain varchar(40),
  PRIMARY KEY (_id)
);

INSERT INTO school (name, code, address, emailDomain)
VALUES ('Straw Nest Primary School', '003', '10 Showground Road', '@straw-nest.com.au');

INSERT INTO school (name, code, address, emailDomain)
VALUES ('Francis Park High School', '004', '21 Richmond Road', '@francis-park.com.au');

INSERT INTO school (name, code, address, emailDomain)
VALUES ('Maria Teresa Piccio', 'MTP', 'Cape Street', '@maria-teresa.com.au');

INSERT INTO school (name, code, address, emailDomain)
VALUES ('Nomen Nescio', 'NN', 'McDonald Street', '@nomen-nescio.com.au');

