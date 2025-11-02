create table post(
    iid serial primary key,
    name text,
    description text,
    link text unique,
    created timestamp
);

