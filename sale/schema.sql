/**
 * Author:  liji8162
 * Created: 8/08/2017
 */
create table Product(
Product_ID integer,
Name varchar(50) not null,
Description varchar(255),
Category varchar(50),
Price decimal,
Quantity integer,
constraint Product_PK primary key (Product_ID)
);

