create database week3;
use week3;

create table faculty(
	id int auto_increment primary key,
    name varchar(50),
    email varchar(100) unique,
    password varchar(100),
    mobile varchar(13)
);

create table course(
	id int auto_increment primary key,
    name varchar(50),
    duration int
);

create table faculty_courses(
	faculty_id int,
    course_id int,
    primary key(faculty_id,course_id),
    foreign key(faculty_id) references faculty(id),
    foreign key(course_id) references course(id)
);

select * from faculty;