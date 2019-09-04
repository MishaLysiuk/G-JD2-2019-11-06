CREATE TABLE "course"
(
    "id"           serial                      NOT NULL,
    "name"         VARCHAR(255)                NOT NULL UNIQUE,
    "company_id"   integer                     NOT NULL,
    "start_date"   TIMESTAMP without time zone NOT NULL,
    "end_date"     TIMESTAMP without time zone NOT NULL,
    "final_result" integer,
    "created"      TIMESTAMP without time zone NOT NULL,
    "updated"      TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "course_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "language"
(
    "id"      serial                      NOT NULL,
    "name"    VARCHAR(255)                NOT NULL,
    "created" TIMESTAMP without time zone NOT NULL,
    "updated" TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "language_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "user_language"
(
    "id"          serial                      NOT NULL,
    "language_id" integer                     NOT NULL,
    "level_id"    integer                     NOT NULL,
    "user_id"     integer                     NOT NULL,
    "created"     TIMESTAMP without time zone NOT NULL,
    "updated"     TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "user_language_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "user_account"
(
    "id"               serial                      NOT NULL,
    "email"            VARCHAR(255)                NOT NULL UNIQUE,
    "password"         VARCHAR(255)                NOT NULL,
    "role"             VARCHAR(255)                NOT NULL,
    "first_name"       VARCHAR(255)                NOT NULL,
    "last_name"        VARCHAR(255),
    "job_title"        VARCHAR(255),
    "birthday"         TIMESTAMP without time zone,
    "contact_info"     VARCHAR(255),
    "mother_tongue_id" integer,
    "created"          TIMESTAMP without time zone NOT NULL,
    "updated"          TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "user_account_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "skill"
(
    "id"       serial                      NOT NULL,
    "name"     VARCHAR(255)                NOT NULL UNIQUE,
    "group_id" integer                     NOT NULL,
    "created"  TIMESTAMP without time zone NOT NULL,
    "updated"  TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "skill_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "group_skill"
(
    "id"      serial                      NOT NULL,
    "name"    VARCHAR(255)                NOT NULL,
    "created" TIMESTAMP without time zone NOT NULL,
    "updated" TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "group_skill_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "company"
(
    "id"      serial                      NOT NULL,
    "name"    VARCHAR(255)                NOT NULL,
    "created" TIMESTAMP without time zone NOT NULL,
    "updated" TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "company_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "education"
(
    "id"            serial                      NOT NULL,
    "university"    VARCHAR(255)                NOT NULL,
    "start_date"    TIMESTAMP without time zone NOT NULL,
    "end_date"      TIMESTAMP without time zone NOT NULL,
    "speciality_id" integer                     NOT NULL,
    "degree_id"     integer,
    "address"       VARCHAR(255)                NOT NULL,
    "city_id"       integer                     NOT NULL,
    "created"       TIMESTAMP without time zone NOT NULL,
    "updated"       TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "education_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "vacancy"
(
    "id"           serial                      NOT NULL,
    "creator_id"   integer                     NOT NULL UNIQUE,
    "job_title"    VARCHAR(255)                NOT NULL UNIQUE,
    "company_id"   integer                     NOT NULL,
    "address"      VARCHAR(255)                NOT NULL,
    "city_id"      integer                     NOT NULL,
    "description"  VARCHAR(255),
    "contact_info" VARCHAR(255)                NOT NULL,
    "created"      TIMESTAMP without time zone NOT NULL,
    "updated"      TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "vacancy_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "work_experience"
(
    "id"         serial                      NOT NULL,
    "job_title"  VARCHAR(255)                NOT NULL,
    "start_date" TIMESTAMP without time zone NOT NULL,
    "end_date"   TIMESTAMP without time zone NOT NULL,
    "address"    VARCHAR(255)                NOT NULL,
    "city_id"    integer                     NOT NULL,
    "company_id" integer                     NOT NULL,
    "created"    TIMESTAMP without time zone NOT NULL,
    "updated"    TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "work_experience_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "city"
(
    "id"         serial                      NOT NULL,
    "name"       VARCHAR(255)                NOT NULL,
    "country_id" integer                     NOT NULL,
    "created"    TIMESTAMP without time zone NOT NULL,
    "updated"    TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "city_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "country"
(
    "id"        serial                      NOT NULL,
    "name"      VARCHAR(255)                NOT NULL,
    "region_id" integer                     NOT NULL,
    "created"   TIMESTAMP without time zone NOT NULL,
    "updated"   TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "country_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "region"
(
    "id"      serial                      NOT NULL,
    "name"    VARCHAR(255)                NOT NULL,
    "created" TIMESTAMP without time zone NOT NULL,
    "updated" TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "region_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "language_level"
(
    "id"       serial                      NOT NULL,
    "name"     VARCHAR(255)                NOT NULL UNIQUE,
    "priority" integer                     NOT NULL UNIQUE,
    "created"  TIMESTAMP without time zone NOT NULL,
    "updated"  TIMESTAMP without time zone NOT NULL,
    CONSTRAINT "language_level_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "course_2_user"
(
    "course_id" integer NOT NULL,
    "user_id"   integer NOT NULL
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "education_2_user"
(
    "education_id" integer NOT NULL,
    "user_id"      integer NOT NULL
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "experience_2_user"
(
    "experience_id" integer NOT NULL,
    "user_id"       integer NOT NULL
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "skill_2_user"
(
    "skill_id" integer NOT NULL,
    "user_id"  integer NOT NULL
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "speciality"
(
    "id"      serial       NOT NULL,
    "name"    VARCHAR(255) NOT NULL UNIQUE,
    "created" DATE         NOT NULL,
    "updated" DATE         NOT NULL,
    CONSTRAINT "speciality_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



CREATE TABLE "degree"
(
    "id"      serial       NOT NULL,
    "name"    VARCHAR(255) NOT NULL UNIQUE,
    "created" DATE         NOT NULL,
    "updated" DATE         NOT NULL,
    CONSTRAINT "degree_pk" PRIMARY KEY ("id")
) WITH (
      OIDS= FALSE
    );



ALTER TABLE "course"
    ADD CONSTRAINT "course_fk0" FOREIGN KEY ("company_id") REFERENCES "company" ("id");


ALTER TABLE "user_language"
    ADD CONSTRAINT "user_language_fk0" FOREIGN KEY ("language_id") REFERENCES "language" ("id");
ALTER TABLE "user_language"
    ADD CONSTRAINT "user_language_fk1" FOREIGN KEY ("level_id") REFERENCES "language_level" ("id");
ALTER TABLE "user_language"
    ADD CONSTRAINT "user_language_fk2" FOREIGN KEY ("user_id") REFERENCES "user_account" ("id");

ALTER TABLE "user_account"
    ADD CONSTRAINT "user_account_fk0" FOREIGN KEY ("mother_tongue_id") REFERENCES "language" ("id");

ALTER TABLE "skill"
    ADD CONSTRAINT "skill_fk0" FOREIGN KEY ("group_id") REFERENCES "group_skill" ("id");



ALTER TABLE "education"
    ADD CONSTRAINT "education_fk0" FOREIGN KEY ("speciality_id") REFERENCES "speciality" ("id");
ALTER TABLE "education"
    ADD CONSTRAINT "education_fk1" FOREIGN KEY ("degree_id") REFERENCES "degree" ("id");
ALTER TABLE "education"
    ADD CONSTRAINT "education_fk2" FOREIGN KEY ("city_id") REFERENCES "city" ("id");

ALTER TABLE "vacancy"
    ADD CONSTRAINT "vacancy_fk0" FOREIGN KEY ("creator_id") REFERENCES "user_account" ("id");
ALTER TABLE "vacancy"
    ADD CONSTRAINT "vacancy_fk1" FOREIGN KEY ("company_id") REFERENCES "company" ("id");
ALTER TABLE "vacancy"
    ADD CONSTRAINT "vacancy_fk2" FOREIGN KEY ("city_id") REFERENCES "city" ("id");

ALTER TABLE "work_experience"
    ADD CONSTRAINT "work_experience_fk0" FOREIGN KEY ("city_id") REFERENCES "city" ("id");
ALTER TABLE "work_experience"
    ADD CONSTRAINT "work_experience_fk1" FOREIGN KEY ("company_id") REFERENCES "company" ("id");

ALTER TABLE "city"
    ADD CONSTRAINT "city_fk0" FOREIGN KEY ("country_id") REFERENCES "country" ("id");

ALTER TABLE "country"
    ADD CONSTRAINT "country_fk0" FOREIGN KEY ("region_id") REFERENCES "region" ("id");



ALTER TABLE "course_2_user"
    ADD CONSTRAINT "course_2_user_fk0" FOREIGN KEY ("course_id") REFERENCES "course" ("id");
ALTER TABLE "course_2_user"
    ADD CONSTRAINT "course_2_user_fk1" FOREIGN KEY ("user_id") REFERENCES "user_account" ("id");

ALTER TABLE "education_2_user"
    ADD CONSTRAINT "education_2_user_fk0" FOREIGN KEY ("education_id") REFERENCES "education" ("id");
ALTER TABLE "education_2_user"
    ADD CONSTRAINT "education_2_user_fk1" FOREIGN KEY ("user_id") REFERENCES "user_account" ("id");

ALTER TABLE "experience_2_user"
    ADD CONSTRAINT "experience_2_user_fk0" FOREIGN KEY ("experience_id") REFERENCES "work_experience" ("id");
ALTER TABLE "experience_2_user"
    ADD CONSTRAINT "experience_2_user_fk1" FOREIGN KEY ("user_id") REFERENCES "user_account" ("id");

ALTER TABLE "skill_2_user"
    ADD CONSTRAINT "skill_2_user_fk0" FOREIGN KEY ("skill_id") REFERENCES "skill" ("id");
ALTER TABLE "skill_2_user"
    ADD CONSTRAINT "skill_2_user_fk1" FOREIGN KEY ("user_id") REFERENCES "user_account" ("id");


