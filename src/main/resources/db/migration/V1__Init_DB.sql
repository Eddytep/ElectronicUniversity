create sequence hibernate_sequence start 1 increment 1;

alter sequence hibernate_sequence owner to eddytep;

create table if not exists book
(
    id     bigint not null
        constraint book_pkey
            primary key,
    isbn   varchar(255),
    author varchar(255),
    name   varchar(255)
);

alter table book
    owner to eddytep;

create table if not exists building
(
    building_number smallint not null
        constraint building_pkey
            primary key,
    address         varchar(255)
);

alter table building
    owner to eddytep;

create table if not exists department
(
    id           bigint not null
        constraint department_pkey
            primary key,
    name         varchar(255)
        constraint uk_1t68827l97cwyxo9r1u6t4p7d
            unique,
    phone_number varchar(255)
);

alter table department
    owner to eddytep;

create table if not exists department_sub_departments
(
    department_id      bigint not null
        constraint fktd951nnq8jma9wfxshjqsdy83
            references department,
    sub_departments_id bigint not null
        constraint uk_jq4bba4car7samx8l0ghrxs2h
            unique
        constraint fkss4o3qfbbg8eeqh2wa5jrk2u9
            references department,
    constraint department_sub_departments_pkey
        primary key (department_id, sub_departments_id)
);

alter table department_sub_departments
    owner to eddytep;

create table if not exists discipline
(
    id          bigint not null
        constraint discipline_pkey
            primary key,
    lesson_type varchar(255),
    name        varchar(255)
);

alter table discipline
    owner to eddytep;

create table if not exists discipline_recomended_books
(
    discipline_id       bigint not null
        constraint fk5ijnpkcl0fdq8ctbg2ratt2sr
            references discipline,
    recomended_books_id bigint not null
        constraint uk_c3gyq9op9i3bmoixenhmehr9f
            unique
        constraint fknklnyrtp5xty5ufmfxh8r9gfk
            references book,
    constraint discipline_recomended_books_pkey
        primary key (discipline_id, recomended_books_id)
);

alter table discipline_recomended_books
    owner to eddytep;

create table if not exists equipment
(
    id   bigint not null
        constraint equipment_pkey
            primary key,
    name varchar(255)
);

alter table equipment
    owner to eddytep;

create table if not exists discipline_equipments
(
    discipline_id bigint not null
        constraint fkfvnp4qah46ps9cit0ltfnnqf
            references discipline,
    equipments_id bigint not null
        constraint uk_5elsph232ir6e81bc10ll1m49
            unique
        constraint fkcq45elukclttqy846ssf199tp
            references equipment,
    constraint discipline_equipments_pkey
        primary key (discipline_id, equipments_id)
);

alter table discipline_equipments
    owner to eddytep;

create table if not exists equipment_parts
(
    equipment_id bigint not null
        constraint fkqspfk1qv40knfox485edjrim8
            references equipment,
    parts        varchar(255)
);

alter table equipment_parts
    owner to eddytep;

create table if not exists premise
(
    id                       bigint  not null
        constraint premise_pkey
            primary key,
    human_capacity           integer not null,
    premise_name             varchar(255)
        constraint uk_p5tc1op29jpob5horcuf5ox2v
            unique,
    premise_type             integer,
    building_building_number smallint
        constraint fk6pnfoj6ok8h1wjdfemsl0e449
            references building
);

alter table premise
    owner to eddytep;

create table if not exists department_premises
(
    department_id bigint not null
        constraint fk5pi19d13spure417mr8pxm7ss
            references department,
    premises_id   bigint not null
        constraint uk_kbqr7cxy64vud2c8aj91nwhpr
            unique
        constraint fkbgbwjyy0wwp4gcc9a3djbjlvc
            references premise,
    constraint department_premises_pkey
        primary key (department_id, premises_id)
);

alter table department_premises
    owner to eddytep;

create table if not exists premise_equipments
(
    premise_id    bigint not null
        constraint fkeey8m8apw79bavs4yeujn1anw
            references premise,
    equipments_id bigint not null
        constraint uk_nx61tpnrs2xedqjlhp8mb69qc
            unique
        constraint fk19pqcsovt2re253ptdbradcsr
            references equipment,
    constraint premise_equipments_pkey
        primary key (premise_id, equipments_id)
);

alter table premise_equipments
    owner to eddytep;

create table if not exists speciality
(
    id   bigint not null
        constraint speciality_pkey
            primary key,
    code varchar(255),
    name varchar(255)
);

alter table speciality
    owner to eddytep;

create table if not exists human
(
    human_type    integer not null,
    id            bigint  not null
        constraint human_pkey
            primary key,
    birthday      timestamp,
    email         varchar(255),
    first_name    varchar(255),
    last_name     varchar(255),
    password      varchar(255),
    middle_name   varchar(255),
    username      varchar(255),
    speciality_id bigint
        constraint fk3kej2o73prlu6ouxexvqg7fvq
            references speciality
);

alter table human
    owner to eddytep;

create table if not exists department_humans
(
    department_id bigint not null
        constraint fk4hwnaw63e2e3t8hlyq055vjaa
            references department,
    humans_id     bigint not null
        constraint uk_fn3u3ak4ktepmic82nr5ndlpo
            unique
        constraint fkd65w9ht21lvggusd3ho6u56kr
            references human,
    constraint department_humans_pkey
        primary key (department_id, humans_id)
);

alter table department_humans
    owner to eddytep;

create table if not exists human_department
(
    human_id      bigint not null
        constraint fkbdpks2xq4cr77ohh68kt1lmcu
            references human,
    department_id bigint not null
        constraint fkhu1ar2ihmeek30grqjifub4wj
            references department,
    constraint human_department_pkey
        primary key (human_id, department_id)
);

alter table human_department
    owner to eddytep;

create table if not exists human_role
(
    human_id bigint not null
        constraint fk9xbt7glktupl3t2jkthy129i9
            references human,
    roles    varchar(255)
);

alter table human_role
    owner to eddytep;

create table if not exists lesson
(
    id            bigint not null
        constraint lesson_pkey
            primary key,
    time          timestamp,
    class_room_id bigint
        constraint fk46tgvctxoeets56nbl3meik19
            references premise,
    discipline_id bigint
        constraint fkb63aphj5so62o2tpu6idva52x
            references discipline,
    lecturer_id   bigint
        constraint fkb0crrx4m9m4epfviy2jliaip9
            references human
);

alter table lesson
    owner to eddytep;

create table if not exists students_group
(
    id         bigint   not null
        constraint students_group_pkey
            primary key,
    group_name varchar(255)
        constraint uk_ltioxbrjokvfrbh5ban3952gy
            unique,
    sub_group  smallint not null
);

alter table students_group
    owner to eddytep;

create table if not exists lesson_students_group
(
    lesson_id         bigint not null
        constraint fkfj0ucruhccr7ndaycnyxgaotl
            references lesson,
    students_group_id bigint not null
        constraint uk_3numt1xrhdjwbjlmgy64c8l6s
            unique
        constraint fk8ct3venilk0cbl47dw0hx9wm1
            references students_group,
    constraint lesson_students_group_pkey
        primary key (lesson_id, students_group_id)
);

alter table lesson_students_group
    owner to eddytep;

create table if not exists students_group_students
(
    students_group_id bigint not null
        constraint fknhbx3q63fg59fy2e5rlosagkm
            references students_group,
    students_id       bigint not null
        constraint uk_ch0e6n7937qil2dkq0jublv6g
            unique
        constraint fk8vgawtrjmkas6u4rgtamc5vkr
            references human,
    constraint students_group_students_pkey
        primary key (students_group_id, students_id)
);

alter table students_group_students
    owner to eddytep;

