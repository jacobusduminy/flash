CREATE DATABASE IF NOT EXISTS regapp_database;
USE regapp_database;

create user regapp_user
    identified by 'regapp_user';

grant all privileges on regapp_database.* to regapp_user;

create table if not exists regapp_database.user
(
    user_id             int auto_increment
    primary key,
    username            varchar(255)                       null,
    surname             varchar(255)                       null,
    email               varchar(255)                       not null,
    password            varchar(255)                       null,
    password_reset_code varchar(255)                       null,
    created_on          datetime default CURRENT_TIMESTAMP not null,
    update_on           datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP,
    constraint unique_user_email
    unique (email)
    );

