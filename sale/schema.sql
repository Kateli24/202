/**
 * Author:  liji8162
 * Created: 8/08/2017
 */
create table Product(
Product_ID integer,
Name varchar(50) not null,
Description varchar(255),
Category varchar(50) not null,
Price decimal not null,
Quantity integer not null,
constraint Product_PK primary key (Product_ID)
);

create table Customer(
username varchar(50) not null,
name varchar(50) not null,
email varchar(70) not null unique,
shippingAddress varchar(255) not null,
creditCardDetail varchar(255) not null,
password varchar(50) not null,
constraint Customer_PK primary key (username)
);

create table Sale_Item(
Product_ID integer,
quantityPurchased integer not null,
purchasePrice decimal not null,
constraint Sale_Item_Product_FK foreign key (Product_ID) references Product,
constraint sale_item_PK primary key (Product_id)
);

create sequence id_seq_1;

create table Sale( 
id bigint auto_increment(1000), 
Product_ID integer, 
username varchar(50), 
date Date, 
constraint Sale_Customer_FK foreign key (username) references Customer, 
constraint Sale_Sale_Item_FK foreign key (Product_ID) references Sale_Item,
primary key (id) 
);
