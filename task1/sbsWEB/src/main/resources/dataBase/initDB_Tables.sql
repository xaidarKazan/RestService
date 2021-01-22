CREATE SEQUENCE "person_person_id_seq";
CREATE SEQUENCE "dim_genre_genre_id_seq";
CREATE SEQUENCE "author_author_id_seq";
CREATE SEQUENCE "book_book_id_seq";
CREATE SEQUENCE "library_card_library_card_id_seq";
CREATE SEQUENCE "users_users_id_seq";

CREATE TABLE IF NOT EXISTS public.person
(
    person_id bigint NOT NULL DEFAULT nextval('person_person_id_seq'::regclass),
    birth_date date,
    first_name character varying(200) NOT NULL,
    last_name character varying(200) NOT NULL,
    middle_name character varying(200),
    post_time date,
    put_time date,
    version bigint,
    CONSTRAINT person_pk PRIMARY KEY (person_id)
);

CREATE TABLE IF NOT EXISTS public.author
(
    author_id bigint NOT NULL DEFAULT nextval('author_author_id_seq'::regclass),
    first_name character varying(200) NOT NULL,
    last_name character varying(200) NOT NULL,
    middle_name character varying(200),
    birth_date  timestamp,
    post_time date,
    put_time date,
    version bigint,
    CONSTRAINT author_pk PRIMARY KEY (author_id)
);

CREATE TABLE IF NOT EXISTS public.book
(
    book_id bigint NOT NULL DEFAULT nextval('book_book_id_seq'::regclass),
    name character varying(200) NOT NULL,
    author_id bigint NOT NULL,
    date_of_public date,
    date_Of_receipt_in_lib date,
    post_time date,
    put_time date,
    version bigint,
    CONSTRAINT book_pk PRIMARY KEY (book_id),
    CONSTRAINT book_author__fk FOREIGN KEY (author_id)
        REFERENCES public.author (author_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.dim_genre
(
    genre_id bigint NOT NULL DEFAULT nextval('dim_genre_genre_id_seq'::regclass),
    genre_name character varying(200) NOT NULL,
    post_time date,
    put_time date,
    version bigint,
    CONSTRAINT dim_genre_pk PRIMARY KEY (genre_id)
);

CREATE TABLE IF NOT EXISTS public.book_genre_lnk
(
    book_id bigint,
    genre_id bigint,
    CONSTRAINT book_id FOREIGN KEY (book_id)
        REFERENCES public.book (book_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
    CONSTRAINT genre_id FOREIGN KEY (genre_id)
        REFERENCES public.dim_genre (genre_id) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE IF NOT EXISTS public.library_card
(
    library_card_id  bigint NOT NULL DEFAULT nextval('library_card_library_card_id_seq'::regclass),
    book_book_id     bigint
        constraint book_book_id_fk
            references public.book (book_id),
    person_person_id bigint
        constraint person_person_id_fk
            references public.person (person_id),
    when_take        date,
    when_return      date,
    CONSTRAINT library_card_pk PRIMARY KEY (library_card_id)
);

CREATE TABLE IF NOT EXISTS public.users
(
    users_id bigint NOT NULL DEFAULT nextval('users_users_id_seq'::regclass),
    login    varchar(45)  not null,
    password varchar(200) not null,
    CONSTRAINT users_pk PRIMARY KEY (users_id)
);


