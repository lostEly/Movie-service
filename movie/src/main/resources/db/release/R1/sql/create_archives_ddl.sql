create table employee_archives
(
    id VARCHAR(255) not null
        primary key,
    date_created datetime(6) not null,
    date_deleted datetime(6) DEFAULT (NOW()) not null,
    date_updated datetime(6) null,
    last_name varchar(40) not null,
    name varchar(30) not null
);

create table genre_archives
(
    id VARCHAR(255) not null
        primary key,
    date_created datetime(6) not null,
    date_deleted datetime(6) DEFAULT (NOW()) not null,
    date_updated datetime(6) null,
    name varchar(30) not null,
    parent_genre_id varchar(255) null,
    constraint FK_archived_parent_genre_id
        foreign key (parent_genre_id) references genre (id)
);

create table movie_archives
(
    id VARCHAR(255) not null
        primary key,
    date_created datetime(6) not null,
    date_deleted datetime(6) DEFAULT (NOW()) not null,
    date_updated datetime(6) null,
    country varchar(255) null,
    description text not null,
    duration bigint not null,
    name varchar(30) not null,
    rating double null,
    release_date date not null
);

create table profession_archives
(
    id VARCHAR(255) not null
        primary key,
    date_created datetime(6) not null,
    date_deleted datetime(6) DEFAULT (NOW()) not null,
    date_updated datetime(6) null,
    name varchar(50) not null
);

create table role_archives
(
    id VARCHAR(255) not null
        primary key,
    date_created datetime(6) not null,
    date_deleted datetime(6) DEFAULT (NOW()) not null,
    date_updated datetime(6) null,
    name varchar(50) not null,
    constraint UK_archived_name
        unique (name)
);

create table userr_archives
(
    id VARCHAR(255) not null
        primary key,
    date_created datetime(6) not null,
    date_deleted datetime(6) DEFAULT (NOW()) not null,
    date_updated datetime(6) null,
    date_of_birthday date not null,
    email varchar(255) not null,
    last_name varchar(40) not null,
    name varchar(30) not null,
    sex varchar(255) not null,
    telephone varchar(255) not null,
    constraint UK_archived_telephone
        unique (telephone)
);

create table movie_list_archives
(
    id VARCHAR(255) not null
        primary key,
    date_created datetime(6) not null,
    date_deleted datetime(6) DEFAULT (NOW()) not null,
    date_updated datetime(6) null,
    comment text null,
    movie_list_type varchar(255) null,
    name varchar(50) not null,
    user_id varchar(255) null,
    constraint FK_archived_user_id
        foreign key (user_id) references userr (id)
);
