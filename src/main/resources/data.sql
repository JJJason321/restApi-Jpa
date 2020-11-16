drop table if exists CLIENT;
drop table if exists ACCOUNT;
drop table if exists EMPLOYEE;
drop table if exists SCHEDULE;
drop table if exists SERVICE;
drop table if exists Appointment;
drop table if exists EMPLOYEE_SERVICE;
drop table if exists ACCOUNT_APPOINTMENT;

-- Table : account
create table account(
    id int AUTO_INCREMENT primary Key,
    username varchar(255) not null,
    password varchar(255) not null,
    ISADMIN BOOLEAN not null,
    ISEMPLOYEE BOOLEAN not null,
    ISCLIENT BOOLEAN not null
);

-- Table : client
create table client(
    id INT AUTO_INCREMENT primary Key,
    firstname varchar(255) not null,
    lastname varchar(255) not null,
    phonenumber varchar(255),
    address varchar(255),
    account_id int not null,
    foreign key(account_id) references account(id)
);

-- Table: service
CREATE TABLE service (
    id INT AUTO_INCREMENT primary Key,
    name varchar(255) NOT NULL,
    description varchar(255) NOT NULL
);

-- Table: Appointment
CREATE TABLE appointment (
    id INT AUTO_INCREMENT primary Key,
    appointment_date date NOT NULL,
    start_time time NOT NULL,
    end_time time NOT NULL,
    service_id int NOT NULL,
    foreign key(service_id) references service(id)
);

-- Table: Account_Appointment
CREATE TABLE account_appointment (
    id INT AUTO_INCREMENT primary Key,
    appointment_id int NOT NULL,
    account_id int NOT NULL,
    foreign key(account_id) references account(id),
    foreign key(appointment_id) references appointment(id)
);

-- Table: employee
CREATE TABLE employee (
    id INT AUTO_INCREMENT primary Key,
    firstname varchar(255) NOT NULL,
    lastname varchar(255) NOT NULL,
    Account_id int NOT NULL,
    phonenumber varchar(255) NOT NULL,
    address varchar(255) NOT NULL
);

-- Table: employee_service
CREATE TABLE employee_service (
    id INT AUTO_INCREMENT primary Key,
    employee_id int NOT NULL,
    service_id int NOT NULL,
    foreign key(service_id) references service(id),
    foreign key(employee_id) references employee(id)
);

-- Table: schedule
CREATE TABLE schedule (
    id INT AUTO_INCREMENT primary Key,
    employee_id int NOT NULL,
    work_date date NOT NULL,
    start_work_time time NOT NULL,
    end_work_time time NOT NULL,
    foreign key(employee_id) references employee(id)
);

-- Insert data for testing.

insert into account(username,password,isadmin,isemployee,isclient) values
    ('a@admin.com','123',1,1,0),
    ('b@client.com','123',0,0,1),
    ('c@client.com','123',0,0,1),
    ('d@employee.com','123',0,1,0),
    ('e@employee.com','123',0,1,0),
    ('f@client.com','123',0,0,1),
    ('g@client.com','123',0,0,1),
    ('h@employee.com','123',0,1,0);



insert into service(name,description) values
    ('hair cut','cut your hair'),
    ('nail color', 'color your nail'),
    ('hair color','color your hair'),
    ('Skin care', 'care your skin');

insert into appointment(appointment_date,start_time,end_time,service_id) values
    ('2020-10-01','10:00:00','11:00:00',4),
    ('2020-10-01','12:00:00','13:00:00',2),
    ('2020-10-01','14:00:00','15:00:00',1),
    ('2020-10-02','09:00:00','10:00:00',3),
    ('2020-10-02','10:00:00','11:00:00',4),
    ('2020-10-02','12:00:00','13:00:00',2),
    ('2020-10-03','14:00:00','15:00:00',1),
    ('2020-10-03','09:00:00','10:00:00',3),
    ('2020-10-03','10:00:00','11:00:00',4),
    ('2020-10-04','12:00:00','13:00:00',2),
    ('2020-10-04','14:00:00','15:00:00',1),
    ('2020-10-05','09:00:00','10:00:00',3),
    ('2020-10-05','10:00:00','11:00:00',4),
    ('2020-10-05','12:00:00','13:00:00',2),
    ('2020-10-05','14:00:00','15:00:00',1),
    ('2020-10-06','09:00:00','10:00:00',3),
    ('2020-10-08','10:00:00','11:00:00',4),
    ('2020-10-08','12:00:00','13:00:00',2),
    ('2020-10-08','14:00:00','15:00:00',1),
    ('2020-10-09','09:00:00','10:00:00',3),
    ('2020-10-09','10:00:00','11:00:00',4),
    ('2020-10-09','12:00:00','13:00:00',2),
    ('2020-10-10','14:00:00','15:00:00',1),
    ('2020-10-10','09:00:00','10:00:00',3),
    ('2020-10-10','10:00:00','11:00:00',4),
    ('2020-10-11','12:00:00','13:00:00',2),
    ('2020-10-11','14:00:00','15:00:00',1),
    ('2020-10-12','09:00:00','10:00:00',3),
    ('2020-10-12','10:00:00','11:00:00',4),
    ('2020-10-13','12:00:00','13:00:00',2),
    ('2020-10-13','14:00:00','15:00:00',1),
    ('2020-10-13','09:00:00','10:00:00',3);

insert into client(firstname,lastname,phonenumber,address,account_id) values
    ('Alex', '-client', '110','ablack',2),
    ('Bob', '-client', '120','bwhite',3),
    ('Carl', '-client', '130','cgreen',7),
    ('Doge', '-client', '150','dyellow',6);

insert into account_appointment(appointment_id,account_id) values
    (1,1),
    (1,5),
    (2,2),
    (2,6),
    (3,3),
    (3,7),
    (4,4),
    (4,8),
    (5,1),
    (5,6),
    (6,2),
    (6,7),
    (7,3),
    (7,8),
    (8,4),
    (8,5),
    (9,1),
    (9,7),
    (10,2),
    (10,8),
    (11,3),
    (11,5),
    (12,4),
    (12,6),
    (13,1),
    (13,8),
    (14,2),
    (14,5),
    (15,3),
    (15,6),
    (16,4),
    (16,7),
    (17,1),
    (17,5),
    (18,2),
    (18,6),
    (19,3),
    (19,7),
    (20,4),
    (20,8),
    (21,1),
    (21,6),
    (22,2),
    (22,7),
    (23,3),
    (23,8),
    (24,4),
    (24,5),
    (25,1),
    (25,7),
    (26,2),
    (26,8),
    (27,3),
    (27,5),
    (28,4),
    (28,6),
    (29,1),
    (29,8),
    (30,2),
    (30,5),
    (31,3),
    (31,6),
    (32,4),
    (32,7);


insert into employee(firstname,lastname,phonenumber,address,account_id) values
    ('Frank', 'owner', '210','Fblack',1),
    ('Gelen', '-employee', '220','Gwhite',5),
    ('Hallen', '-employee', '230','Hgreen',8),
    ('Isermal', '-employee', '250','Iyellow',4);

insert into schedule(employee_id,work_date,start_work_time,end_work_time) values
    (1,'2020-10-01','09:00:00','17:00:00'),
    (1,'2020-10-02','09:00:00','17:00:00'),
    (1,'2020-10-03','09:00:00','17:00:00'),
    (1,'2020-10-04','09:00:00','17:00:00'),
    (1,'2020-10-05','09:00:00','12:00:00'),
    (1,'2020-10-06','13:00:00','17:00:00'),
    (1,'2020-10-08','09:00:00','17:00:00'),
    (1,'2020-10-09','09:00:00','17:00:00'),
    (1,'2020-10-10','09:00:00','17:00:00'),
    (1,'2020-10-11','09:00:00','17:00:00'),
    (1,'2020-10-12','09:00:00','12:00:00'),
    (1,'2020-10-13','13:00:00','17:00:00'),

    (2,'2020-10-01','09:00:00','12:00:00'),
    (2,'2020-10-02','13:00:00','17:00:00'),
    (2,'2020-10-03','09:00:00','17:00:00'),
    (2,'2020-10-04','09:00:00','17:00:00'),
    (2,'2020-10-05','09:00:00','12:00:00'),
    (2,'2020-10-06','09:00:00','17:00:00'),
    (2,'2020-10-08','09:00:00','12:00:00'),
    (2,'2020-10-09','13:00:00','17:00:00'),
    (2,'2020-10-10','09:00:00','17:00:00'),
    (2,'2020-10-11','09:00:00','17:00:00'),
    (2,'2020-10-12','09:00:00','17:00:00'),
    (2,'2020-10-13','09:00:00','17:00:00'),

    (3,'2020-10-01','09:00:00','12:00:00'),
    (3,'2020-10-02','09:00:00','12:00:00'),
    (3,'2020-10-03','09:00:00','12:00:00'),
    (3,'2020-10-04','09:00:00','12:00:00'),
    (3,'2020-10-05','09:00:00','12:00:00'),
    (3,'2020-10-06','09:00:00','12:00:00'),
    (3,'2020-10-08','13:00:00','17:00:00'),
    (3,'2020-10-09','13:00:00','17:00:00'),
    (3,'2020-10-10','13:00:00','17:00:00'),
    (3,'2020-10-11','13:00:00','17:00:00'),
    (3,'2020-10-12','13:00:00','17:00:00'),
    (3,'2020-10-13','13:00:00','17:00:00'),

    (4,'2020-10-01','09:00:00','12:00:00'),
    (4,'2020-10-02','09:00:00','12:00:00'),
    (4,'2020-10-03','09:00:00','12:00:00'),
    (4,'2020-10-04','09:00:00','12:00:00'),
    (4,'2020-10-05','09:00:00','12:00:00'),
    (4,'2020-10-06','09:00:00','17:00:00'),
    (4,'2020-10-08','09:00:00','12:00:00'),
    (4,'2020-10-09','09:00:00','12:00:00'),
    (4,'2020-10-10','09:00:00','12:00:00'),
    (4,'2020-10-11','09:00:00','12:00:00'),
    (4,'2020-10-12','09:00:00','12:00:00'),
    (4,'2020-10-13','09:00:00','17:00:00');

insert into employee_service(employee_id,service_id) values
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (2,1),
    (2,2),
    (2,3),
    (3,3),
    (3,4),
    (4,1),
    (4,2)

------------