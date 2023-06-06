## 도커 컴포즈 백그라운드 실행법
docker-compose up -d

## 디비 더미 데이터
```sql
use rootdb;

create table person(
	id int primary key,
    name varchar(100)
);

insert into person(id, name) values(1, 'ssar');

select * from person;
```