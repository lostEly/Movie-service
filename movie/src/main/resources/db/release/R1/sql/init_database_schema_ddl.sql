create table employee
(
    id           VARCHAR(255) default (uuid()) not null
        primary key,
    date_created datetime(6) default (now()) not null,
    date_deleted datetime(6) null,
    date_updated datetime(6) null,
    last_name    varchar(40)                   not null,
    name         varchar(30)                   not null
);

create table genre
(
    id              VARCHAR(255) default (uuid()) not null
        primary key,
    date_created    datetime(6) default (now()) not null,
    date_deleted    datetime(6) null,
    date_updated    datetime(6) null,
    name            varchar(30)                   not null,
    parent_genre_id varchar(255) null,
    constraint FKcvbnwpnfnuwxhkvqcxvvtrumk
        foreign key (parent_genre_id) references genre (id)
);

create table movie
(
    id           VARCHAR(255) default (uuid()) not null
        primary key,
    date_created datetime(6) default (now()) not null,
    date_deleted datetime(6) null,
    date_updated datetime(6) null,
    description  text                          not null,
    duration     bigint                        not null,
    name         varchar(30)                   not null,
    rating       double null,
    release_date date                          not null
);

create table employee_to_movie
(
    movie_id    varchar(255) not null,
    employee_id VARCHAR(255) not null,
    primary key (movie_id, employee_id),
    constraint FK1p3o9m41afjfyvy76lmycvi36
        foreign key (movie_id) references movie (id),
    constraint FKp9n702umpt9nnpunltjhhibxa
        foreign key (employee_id) references employee (id)
);

create table genre_to_movie
(
    genre_id varchar(255) not null,
    movie_id varchar(255) not null,
    primary key (genre_id, movie_id),
    constraint FK6pc9008s4ol81ag1yd05pg8yq
        foreign key (genre_id) references genre (id),
    constraint FKqc1xo6g2cdc338no6ugvew9m2
        foreign key (movie_id) references movie (id)
);

create table profession
(
    id           VARCHAR(255) default (uuid()) not null
        primary key,
    date_created datetime(6) default (now()) not null,
    date_deleted datetime(6) null,
    date_updated datetime(6) null,
    name         varchar(50)                   not null
);

create table profession_to_employee
(
    employee_id   varchar(255) not null,
    profession_id varchar(255) not null,
    primary key (employee_id, profession_id),
    constraint FK1d7vja04833t3g8gah5fhx7ij
        foreign key (profession_id) references profession (id),
    constraint FKq3fbepejvypeybc63ppv1bfxt
        foreign key (employee_id) references employee (id)
);

create table role
(
    id           VARCHAR(255) default (uuid()) not null
        primary key,
    date_created datetime(6) default (now()) not null,
    date_deleted datetime(6) null,
    date_updated datetime(6) null,
    name         varchar(50)                   not null,
    constraint UK_8sewwnpamngi6b1dwaa88askk
        unique (name)
);

create table userr
(
    id               VARCHAR(255) default (uuid()) not null
        primary key,
    date_created     datetime(6) default (now()) not null,
    date_deleted     datetime(6) null,
    date_updated     datetime(6) null,
    date_of_birthday date                          not null,
    email            varchar(255)                  not null,
    last_name        varchar(40)                   not null,
    name             varchar(30)                   not null,
    sex              varchar(255)                  not null,
    telephone        varchar(255)                  not null,
    constraint UK_dtcw0hvws8dd40xbob8r6xxcp
        unique (telephone)
);

create table movie_list
(
    id              VARCHAR(255) default (uuid()) not null
        primary key,
    date_created    datetime(6) default (now()) not null,
    date_deleted    datetime(6) null,
    date_updated    datetime(6) null,
    comment         text null,
    movie_list_type varchar(255) null,
    name            varchar(50)                   not null,
    user_id         varchar(255) null,
    constraint FK9beao22hrs9gdtfk4yxkj7n95
        foreign key (user_id) references userr (id)
);

create table movie_list_to_movie
(
    id            VARCHAR(255) default (uuid()) not null
        primary key,
    date_created  datetime(6) default (now()) not null,
    date_deleted  datetime(6) null,
    date_updated  datetime(6) null,
    date_added    date                          not null,
    movie_id      varchar(255) null,
    movie_list_id varchar(255) null,
    constraint FKai6jnssknfkooo6c3ah67mi2u
        foreign key (movie_id) references movie (id),
    constraint FKi9byo2q8ym9qom9rquiknqr5o
        foreign key (movie_list_id) references movie_list (id)
);

create table user_to_role
(
    user_id varchar(255) not null,
    role_id varchar(255) not null,
    primary key (user_id, role_id),
    constraint FKc7r83fvwrbfw0lybidhdetnor
        foreign key (user_id) references userr (id),
    constraint FKknk9kh09xew27k796uxnj1tbs
        foreign key (role_id) references role (id)
);

create table userr_movie_lists
(
    userr_id       varchar(255) not null,
    movie_lists_id varchar(255) not null,
    constraint UK_jtcifmgkupuieustjljel9q0r
        unique (movie_lists_id),
    constraint FK51lcrw61cgagqofgqtcb3rign
        foreign key (movie_lists_id) references movie_list (id),
    constraint FKse0fh1jqqn007py8yskg5nu63
        foreign key (userr_id) references userr (id)
);

create table country
(
    id                VARCHAR(255) default (uuid()) not null
        primary key,
    date_created      datetime(6) default (now()) not null,
    date_deleted      datetime(6) null,
    date_updated      datetime(6) null,
    iso               int                           not null,
    alpha2            varchar(2)                    not null,
    full_name         varchar(255)                  not null,
    part_of_the_world varchar(255)                  not null,
    short_name        varchar(255)                  not null,
    constraint UK_country_iso
        unique (iso)
);

create table country_to_movie
(
    movie_id   varchar(255) not null,
    country_id varchar(255) not null,
    primary key (movie_id, country_id),
    constraint FK9bdxcogmi6e4s1plobfatkmhm
        foreign key (country_id) references country (id),
    constraint FKcisau9sqm57m06kejopllvq6x
        foreign key (movie_id) references movie (id)
);

