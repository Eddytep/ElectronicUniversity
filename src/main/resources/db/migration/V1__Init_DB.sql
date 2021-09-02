create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to eddytep;

create table usr
(
    id bigint not null
        constraint usr_pkey
            primary key,
    password varchar(255),
    username varchar(255)
);

alter table usr owner to eddytep;

create table user_role
(
    user_id bigint not null
        constraint fkfpm8swft53ulq2hl11yplpr5
            references usr,
    roles varchar(255)
);

alter table user_role owner to eddytep;

