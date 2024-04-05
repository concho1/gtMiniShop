create table shop_products(
	pnum number primary key,
	pname varchar2(100) not null,
	pcategory_fk varchar2(15) not null,
	pcompany varchar2(100),
	pimage varchar2(200),
	pqty number default 0,
	price number default 0,
	pspec varchar2(30),
	pcontents varchar2(2000),
	point numger default 0,
	pinputdate date
);