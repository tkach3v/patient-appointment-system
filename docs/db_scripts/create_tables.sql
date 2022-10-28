DROP TABLE IF EXISTS public.patient CASCADE;
CREATE TABLE public.patient
(
    id bigserial NOT NULL,
    uuid uuid NOT NULL,
    full_name character varying(250) NOT NULL,
    birth_date date NOT NULL,
    PRIMARY KEY (id)
);


DROP TABLE IF EXISTS public.doctor CASCADE;
CREATE TABLE public.doctor
(
    id bigserial NOT NULL,
    uuid uuid NOT NULL,
    full_name character varying(250) NOT NULL,
    birth_date date NOT NULL,
    PRIMARY KEY (id)
);

DROP TABLE IF EXISTS public.appointment CASCADE;
CREATE TABLE public.appointment
(
    id bigserial NOT NULL,
    date date NOT NULL,
    start_time time without time zone NOT NULL,
    doctor_id bigint NOT NULL,
    patient_id bigint,
    PRIMARY KEY (id),
    FOREIGN KEY (doctor_id)
        REFERENCES public.doctor (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE CASCADE
        NOT VALID,
    FOREIGN KEY (patient_id)
        REFERENCES public.patient (id) MATCH SIMPLE
        ON UPDATE CASCADE
        ON DELETE NO ACTION
        NOT VALID
);
