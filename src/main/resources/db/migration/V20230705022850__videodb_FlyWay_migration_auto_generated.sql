create table category
(
    id    integer not null
        constraint category_pk
            primary key,
    title varchar(25)
        constraint category_title
            unique
);

create table video
(
    id        serial
        constraint video_pk
            primary key,
    title     varchar(50)
        constraint video_title
            unique,
    duration  integer,
    cover_url varchar(100),
    file_url  varchar(100),
    excerpt   varchar(250),
    type      varchar(25)
);

create table video_category
(
    video_pk    integer not null
        constraint video_category_video_id_fk
            references video,
    category_pk integer not null
        constraint video_category_category_id_fk
            references category,
    constraint video_category_pk
        primary key (category_pk, video_pk)
);

-- insert into category (id, title) values (1, 'action');
-- insert into category (id, title) values (2, 'thriller');
-- insert into category (id, title) values (3, 'science-fiction');
-- insert into category (id, title) values (4, 'comedy');