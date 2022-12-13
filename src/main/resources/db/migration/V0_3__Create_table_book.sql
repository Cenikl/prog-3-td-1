create table book
(
    id     serial,
    author varchar,
    title  varchar,
    page_number int not null default 0,
    release_date date,
    primary key (id),
    constraint fk_book_author foreign key (author) references author(name),
);