-- shop_category 테이블 만들기

create table shop_category(
	category_num number primary key,		-- 카테고리 번호.
	category_code varchar2(15) not null,	-- 카데고리 코드.
	category_name varchar2(100) not null,	-- 카테고리 이름.
);