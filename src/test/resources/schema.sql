DROP TABLE IF EXISTS customer;

CREATE TABLE IF NOT EXISTS customer
(
    id bigint NOT NULL,
    birth_date date,
    email character varying(50) ,
    name character varying(100) ,
    password character varying(400) ,
    identity_no character varying(11),
    phone_number character varying(15) ,
    status character varying(30) ,
    surname character varying(100) ,
    username character varying(15) ,
    create_date timestamp ,
    creator_id bigint,
    update_date timestamp ,
    updater_id bigint,
    CONSTRAINT customer_pkey PRIMARY KEY (id)
    );

CREATE SEQUENCE IF NOT EXISTS customer_id_seq start with 1 increment by 50;