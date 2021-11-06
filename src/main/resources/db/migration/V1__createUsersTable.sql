create table roles
(
    id          bigint       not null
        constraint roles_pkey
            primary key,
    description varchar(255) not null
        constraint uk_2op45rew8nnd6adyi86qeqk50
            unique,
    role        varchar(50)  not null
        constraint uk_g50w4r0ru3g9uf6i6fr4kpro8
            unique
);

create table users
(
    id                 varchar not null
        constraint users_pkey
            primary key,
    created_date       timestamp,
    email              varchar not null
        constraint uk_6dotkott2kjsp8vw4d0m25fb7
            unique,
    first_name         varchar not null,
    is_enabled         boolean not null,
    is_verified        boolean not null,
    last_modified_date timestamp,
    last_name          varchar,
    password           varchar not null
);

create table user_role
(
    user_id varchar not null
        constraint fkj345gk1bovqvfame88rcx7yyx
            references users,
    role_id bigint  not null
        constraint fkt7e7djp752sqn6w22i6ocqy6q
            references roles
);