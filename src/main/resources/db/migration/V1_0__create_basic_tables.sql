CREATE TABLE patient
(
    id        varchar(36)  NOT NULL PRIMARY KEY,
    firstname varchar(50)  not null,
    surname   varchar(100) not null,
    address   varchar(255) not null
);

CREATE TABLE doctor
(
    id             varchar(36)  NOT NULL PRIMARY KEY,
    firstname      varchar(50)  not null,
    surname        varchar(100) not null,
    specialization varchar(100) not null
);

CREATE TABLE visit
(
    id         varchar(36)  NOT NULL PRIMARY KEY,
    `date`     datetime     not null,
    `hour`     integer      not null,
    place      varchar(100) not null,
    doctor_id  varchar(36)  not null,
    patient_id varchar(36)  not null
);

ALTER TABLE visit
    ADD FOREIGN KEY (doctor_id) REFERENCES doctor (id);

ALTER TABLE visit
    ADD FOREIGN KEY (patient_id) REFERENCES patient (id);

CREATE INDEX visit_idx ON visit (patient_id);
