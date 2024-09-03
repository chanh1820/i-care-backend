CREATE DATABASE "crud-demo-1"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    LC_COLLATE = 'English_United States.1252'
    LC_CTYPE = 'English_United States.1252'
    LOCALE_PROVIDER = 'libc'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;


-- SEQUENCE: public.employee_tbl_id_seq
ALTER TABLE IF EXISTS public.employee_tbl
    OWNER to postgres;

CREATE SEQUENCE IF NOT EXISTS public.employee_tbl_id_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 999999999
    CACHE 1
    OWNED BY employee_tbl.id;

ALTER SEQUENCE public.employee_tbl_id_seq
    OWNER TO postgres;

-- Table: public.employee_tbl
CREATE TABLE IF NOT EXISTS public.employee_tbl
(
    id integer NOT NULL DEFAULT nextval('employee_tbl_id_seq'::regclass),
    full_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    age integer NOT NULL,
    created_date timestamp with time zone DEFAULT now(),
    updated_date timestamp with time zone DEFAULT now(),
    CONSTRAINT employee_tbl_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

