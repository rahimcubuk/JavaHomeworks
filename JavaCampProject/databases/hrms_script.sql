-- This script was generated by a beta version of the ERD tool in pgAdmin 4.
-- Please log an issue at https://redmine.postgresql.org/projects/pgadmin4/issues/new if you find any bugs, including reproduction steps.
BEGIN;


CREATE TABLE public.employers
(
    employer_id integer NOT NULL,
    company_name character varying NOT NULL,
    web_address character varying NOT NULL,
    phone_number character varying,
    PRIMARY KEY (employer_id)
);

CREATE TABLE public.jobs
(
    job_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    job_title character varying(50) NOT NULL,
    description character varying NOT NULL,
    employer_id integer NOT NULL,
    PRIMARY KEY (job_id)
);

CREATE TABLE public.jobseekers
(
    jobseeker_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    nationality_id character varying(11) NOT NULL,
    birthday date NOT NULL,
    PRIMARY KEY (jobseeker_id)
);

CREATE TABLE public.personnels
(
    personnel_id integer NOT NULL,
    first_name character varying(50) NOT NULL,
    last_name character varying(50) NOT NULL,
    nationality_id character varying(11) NOT NULL,
    salary real NOT NULL,
    PRIMARY KEY (personnel_id)
);

CREATE TABLE public.users
(
    user_id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    email character varying(50) NOT NULL,
    password character varying(50) NOT NULL,
    PRIMARY KEY (user_id)
);

ALTER TABLE public.employers
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.users (user_id)
    NOT VALID;


ALTER TABLE public.jobs
    ADD FOREIGN KEY (employer_id)
    REFERENCES public.employers (employer_id)
    NOT VALID;


ALTER TABLE public.jobseekers
    ADD FOREIGN KEY (jobseeker_id)
    REFERENCES public.users (user_id)
    NOT VALID;


ALTER TABLE public.personnels
    ADD FOREIGN KEY (personnel_id)
    REFERENCES public.users (user_id)
    NOT VALID;

END;