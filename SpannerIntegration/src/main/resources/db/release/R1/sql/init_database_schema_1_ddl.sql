create table employee
(
    id           STRING(36) not null,
    date_created TIMESTAMP not null,
    date_deleted TIMESTAMP,
    date_updated TIMESTAMP,
    last_name    STRING(40) not null,
    name         STRING(30) not null,
) PRIMARY KEY (id);

create table genre
(
    id              STRING(255) not null,
    date_created    TIMESTAMP not null,
    date_deleted    TIMESTAMP,
    date_updated    TIMESTAMP,
    name            STRING(30) not null,
    parent_genre_id STRING(255),
    constraint FK_parent_genre_id_genre
        foreign key (parent_genre_id) references genre (id)
) PRIMARY KEY (id);

create table movie
(
    id           STRING(255) not null,
    date_created TIMESTAMP not null,
    date_deleted TIMESTAMP,
    date_updated TIMESTAMP,
    description  STRING(MAX)      not null,
    duration     bigint    not null,
    name         STRING(30) not null,
    rating       double,
    release_date date      not null
) PRIMARY KEY (id);

create table employee_to_movie
(
    movie_id    STRING(255) not null,
    employee_id STRING(255) not null,
    constraint FK_movie_employee_to_movie
        foreign key (movie_id) references movie (id),
    constraint FK_employee_employee_to_movie
        foreign key (employee_id) references employee (id)
) PRIMARY KEY (movie_id, employee_id);

create table genre_to_movie
(
    genre_id STRING(255) not null,
    movie_id STRING(255) not null,
    constraint FK_genre_genre_to_movie
        foreign key (genre_id) references genre (id),
    constraint FK_movie_genre_to_movie
        foreign key (movie_id) references movie (id)
) PRIMARY KEY (genre_id, movie_id);

create table profession
(
    id           STRING(255) not null,
    date_created TIMESTAMP not null,
    date_deleted TIMESTAMP,
    date_updated TIMESTAMP,
    name         STRING(50) not null
) PRIMARY KEY (id);

create table profession_to_employee
(
    employee_id   STRING(255) not null,
    profession_id STRING(255) not null,
    constraint FK_profession_profession_to_employee
        foreign key (profession_id) references profession (id),
    constraint FK_employee_profession_to_employee
        foreign key (employee_id) references employee (id)
) PRIMARY KEY  (employee_id, profession_id);

create table role
(
    id           STRING(255) not null,
    date_created TIMESTAMP not null,
    date_deleted TIMESTAMP,
    date_updated TIMESTAMP,
    name         STRING(50) not null,
    constraint UK_role_name
        unique (name)
) PRIMARY KEY (id);

create table userr
(
    id               STRING(255) not null,
    date_created     TIMESTAMP not null,
    date_deleted     TIMESTAMP,
    date_updated     TIMESTAMP,
    date_of_birthday date      not null,
    email            STRING(255) not null,
    last_name        STRING(40) not null,
    name             STRING(30) not null,
    sex              STRING(255) not null,
    telephone        STRING(255) not null,
    constraint UK_userr_telephone
        unique (telephone)
) PRIMARY KEY (id);

create table movie_list
(
    id              STRING(255) not null,
    date_created    TIMESTAMP not null,
    date_deleted    TIMESTAMP,
    date_updated    TIMESTAMP,
    comment         STRING(MAX),
    movie_list_type STRING(255),
    name            STRING(50) not null,
    user_id         STRING(255),
    constraint FK_user_id_movie_list
        foreign key (user_id) references userr (id)
) PRIMARY KEY (id);

create table movie_list_to_movie
(
    id            STRING(255) not null,
    date_created  TIMESTAMP not null,
    date_deleted  TIMESTAMP,
    date_updated  TIMESTAMP,
    date_added    date      not null,
    movie_id      STRING(255),
    movie_list_id STRING(255),
    constraint FK_movie_id_movie_list_to_movie
        foreign key (movie_id) references movie (id),
    constraint FK_movie_list_id_movie_list_to_movie
        foreign key (movie_list_id) references movie_list (id)
) PRIMARY KEY (id);

create table user_to_role
(
    user_id STRING(255) not null,
    role_id STRING(255) not null,
    constraint FK_user_id_user_to_role
        foreign key (user_id) references userr (id),
    constraint FK_role_id_user_to_role
        foreign key (role_id) references role (id)
) PRIMARY KEY (user_id, role_id);

create table userr_movie_lists
(
    userr_id       STRING(255) not null,
    movie_lists_id STRING(255) not null,
    constraint UK_movie_lists_id
        unique (movie_lists_id),
    constraint FK_movie_list_id_userr_movie_lists
        foreign key (movie_lists_id) references movie_list (id),
    constraint FK_userr_id_userr_movie_lists
        foreign key (userr_id) references userr (id)
) PRIMARY KEY (userr_id, movie_lists_id);

create table country
(
    id                STRING(255) not null,
    date_created      TIMESTAMP not null,
    date_deleted      TIMESTAMP,
    date_updated      TIMESTAMP,
    iso               int       not null,
    alpha2            STRING(2) not null,
    full_name         STRING(255) not null,
    part_of_the_world STRING(255) not null,
    short_name        STRING(255) not null,
    constraint UK_country_iso
        unique (iso)
) PRIMARY KEY (id);

create table country_to_movie
(
    movie_id   STRING(255) not null,
    country_id STRING(255) not null,
    constraint FK_movie_id_country_to_movie
        foreign key (country_id) references country (id),
    constraint FK_country_id_country_to_movie
        foreign key (movie_id) references movie (id)
) PRIMARY KEY (movie_id, country_id);
