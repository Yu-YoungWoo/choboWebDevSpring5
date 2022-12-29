create user 'study'@'localhost' identified by 'study';

create database spring5fs character set=utf8;

grant all privileges on *.* to 'study'@'localhost';

create table spring5fs.MEMBER(
    ID int auto_increment primary key,
    EMAIL varchar(255),
    PASSWORD varchar(100),
    NAME varchar(100),
    REGDATE datetime,
    unique key(EMAIL)
)engine=InnoDB character set=utf8;




