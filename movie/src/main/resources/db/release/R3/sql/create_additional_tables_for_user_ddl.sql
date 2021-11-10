DROP INDEX UK_dtcw0hvws8dd40xbob8r6xxcp on userr;

# ALTER TABLE userr
#     DROP COLUMN telephone,
#     DROP COLUMN telephone;

CREATE TABLE contact_info
(
    id        VARCHAR(255) default (uuid()) not null
        primary key,
    email     VARCHAR(255)                  not null,
    telephone VARCHAR(255)                  not null,
    constraint UK_contact_info_email
        unique (email),
    constraint UK_contact_info_telephone
        unique (telephone)
);

CREATE TABLE socials
(
    id            VARCHAR(255) default (uuid()) not null
        primary key,
    twitter       VARCHAR(255),
    facebook      VARCHAR(255),
    instagram     VARCHAR(255),
    personal_blog VARCHAR(255),
    constraint UK_socials_twitter
        unique (twitter),
    constraint UK_socials_facebook
        unique (facebook),
    constraint UK_socials_instagram
        unique (instagram)
);

CREATE TABLE userr_address
(
    id         VARCHAR(255) default (uuid()) not null
        primary key,
    country_id VARCHAR(255),
    city       VARCHAR(255),
    constraint foreign key (country_id)
        references country (id)
);

ALTER TABLE userr
    add contact_info_id  VARCHAR(255),
    add socials_id       VARCHAR(255),
    add userr_address_id VARCHAR(255),
    add constraint FK_userr_contact_info_id
        FOREIGN KEY (contact_info_id) references contact_info (id),
    add constraint FK_userr_socials_id
        FOREIGN KEY (socials_id) references socials (id),
    add constraint FK_userr_userr_address_id
        FOREIGN KEY (userr_address_id) references userr_address (id);
