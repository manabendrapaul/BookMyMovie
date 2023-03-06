create table booking
(
    id              bigint auto_increment
        primary key,
    created_by      varchar(255) null,
    created_on      datetime(6)  null,
    updated_by      varchar(255) null,
    updated_on      datetime(6)  null,
    booked_at       datetime(6)  null,
    customer_email  varchar(255) null,
    customer_mobile varchar(255) null,
    movie_slot_id   bigint       null
)
    collate = utf8mb4_0900_ai_ci;

create table movie
(
    id                  bigint auto_increment
        primary key,
    created_by          varchar(255) null,
    created_on          datetime(6)  null,
    updated_by          varchar(255) null,
    updated_on          datetime(6)  null,
    duration_in_minutes bigint       null,
    genre               varchar(255) null,
    language            varchar(255) null,
    name                varchar(255) null,
    released_on         datetime(6)  null
)
    collate = utf8mb4_0900_ai_ci;

create table theater
(
    id         bigint auto_increment
        primary key,
    created_by varchar(255) null,
    created_on datetime(6)  null,
    updated_by varchar(255) null,
    updated_on datetime(6)  null,
    city       varchar(255) null,
    country    varchar(255) null,
    name       varchar(255) null
)
    collate = utf8mb4_0900_ai_ci;

create table hall
(
    id         bigint auto_increment
        primary key,
    created_by varchar(255) null,
    created_on datetime(6)  null,
    updated_by varchar(255) null,
    updated_on datetime(6)  null,
    theater_id bigint       null,
    constraint FKjwgc3yb123rpbgf6o85rlw897
        foreign key (theater_id) references theater (id)
)
    collate = utf8mb4_0900_ai_ci;

create table movie_slot
(
    id                bigint auto_increment
        primary key,
    created_by        varchar(255) null,
    created_on        datetime(6)  null,
    updated_by        varchar(255) null,
    updated_on        datetime(6)  null,
    currently_showing bit          null,
    end_time          time(6)  null,
    price             double       null,
    start_time        time(6)  null,
    hall_id           bigint       null,
    movie_id          bigint       null,
    constraint FK2mvlbvvg5j21vm19nqnhtqp55
        foreign key (hall_id) references hall (id),
    constraint FKpf9i8d3vy8m72v4r9djlcjhf8
        foreign key (movie_id) references movie (id)
)
    collate = utf8mb4_0900_ai_ci;

create table seat
(
    id         bigint auto_increment
        primary key,
    created_by varchar(255) null,
    created_on datetime(6)  null,
    updated_by varchar(255) null,
    updated_on datetime(6)  null,
    row_no     varchar(255) null,
    seat_no    int          null,
    hall_id    bigint       null,
    constraint FKg6ltooo0e2ddvo624h3nc8jmb
        foreign key (hall_id) references hall (id)
)
    collate = utf8mb4_0900_ai_ci;

create table theater_movie
(
    theater_id bigint not null,
    movie_id   bigint not null,
    active   bool not null default true,
    primary key (theater_id, movie_id),
    constraint FK1496v0v72004n6a59fsnll6jx
        foreign key (movie_id) references movie (id),
    constraint FKryte4be3i9uj7rsd37amdsn7c
        foreign key (theater_id) references theater (id)
)
    collate = utf8mb4_0900_ai_ci;

