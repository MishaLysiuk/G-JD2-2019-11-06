CREATE TABLE "user_account" (
	"id" serial NOT NULL,
	"email" VARCHAR(255) NOT NULL UNIQUE,
	"password" VARCHAR(255) NOT NULL,
	"role_id" integer NOT NULL,
	CONSTRAINT "user_account_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "course" (
	"id" serial NOT NULL,
	"user_id" integer NOT NULL,
	"name" VARCHAR(255) NOT NULL UNIQUE,
	"company_id" integer NOT NULL,
	"start" DATE NOT NULL,
	"end" DATE NOT NULL,
	"final_result" integer,
	CONSTRAINT "course_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "language" (
	"id" serial NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	CONSTRAINT "language_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user_language" (
	"id" serial NOT NULL,
	"language_id" integer NOT NULL,
	"user_id" integer NOT NULL,
	"level_id" integer NOT NULL,
	CONSTRAINT "user_language_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "user_portfolio" (
	"id" serial NOT NULL,
	"first_name" VARCHAR(255) NOT NULL,
	"last_name" VARCHAR(255),
	"birthday" DATE,
	"industry_id" integer,
	"position_id" integer,
	"contact_info" VARCHAR(255),
	"mother_tongue" VARCHAR(255),
	"created" DATE NOT NULL,
	"updated" DATE NOT NULL,
	CONSTRAINT "user_portfolio_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "skill" (
	"id" serial NOT NULL,
	"user_id" integer NOT NULL,
	"group_id" integer NOT NULL,
	CONSTRAINT "skill_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "group" (
	"id" serial NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	CONSTRAINT "group_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "company" (
	"id" serial NOT NULL,
	"name" VARCHAR(255) NOT NULL,
	CONSTRAINT "company_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "education" (
	"id" serial NOT NULL,
	"user_id" integer NOT NULL,
	"university" VARCHAR(255) NOT NULL,
	"start" DATE NOT NULL,
	"end" DATE NOT NULL,
	"speciality" VARCHAR(255) NOT NULL,
	"degree" VARCHAR(255) NOT NULL,
	"address_id" integer NOT NULL,
	CONSTRAINT "education_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "vacancy" (
	"id" serial NOT NULL,
	"creator_id" integer NOT NULL UNIQUE,
	"active" BOOLEAN NOT NULL,
	"industry_id" integer NOT NULL,
	"position_id" integer NOT NULL,
	"company_id" integer NOT NULL,
	"address_id" integer NOT NULL,
	"contact_info" VARCHAR(255) NOT NULL,
	CONSTRAINT "vacancy_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "work_experience" (
	"id" serial NOT NULL,
	"user_id" integer NOT NULL,
	"industry_id" integer NOT NULL,
	"position_id" integer NOT NULL,
	"start" DATE NOT NULL,
	"end" DATE NOT NULL,
	"address_id" integer NOT NULL,
	"company_id" integer NOT NULL,
	CONSTRAINT "work_experience_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "address" (
	"id" serial NOT NULL,
	"address" VARCHAR(255) NOT NULL UNIQUE,
	"city_id" integer NOT NULL,
	CONSTRAINT "address_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "city" (
	"id" integer NOT NULL,
	"name_id" integer NOT NULL,
	"country_id" integer NOT NULL,
	CONSTRAINT "city_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "country" (
	"id" serial NOT NULL,
	"name_id" integer NOT NULL,
	"region_id" integer NOT NULL,
	CONSTRAINT "country_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "region" (
	"id" serial NOT NULL,
	"name_id" integer NOT NULL,
	CONSTRAINT "region_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



ALTER TABLE "user_account" ADD CONSTRAINT "user_account_fk0" FOREIGN KEY ("id") REFERENCES "user_portfolio"("id");

ALTER TABLE "course" ADD CONSTRAINT "course_fk0" FOREIGN KEY ("user_id") REFERENCES "user_portfolio"("id");
ALTER TABLE "course" ADD CONSTRAINT "course_fk1" FOREIGN KEY ("company_id") REFERENCES "company"("id");


ALTER TABLE "user_language" ADD CONSTRAINT "user_language_fk0" FOREIGN KEY ("language_id") REFERENCES "language"("id");
ALTER TABLE "user_language" ADD CONSTRAINT "user_language_fk1" FOREIGN KEY ("user_id") REFERENCES "user_portfolio"("id");


ALTER TABLE "skill" ADD CONSTRAINT "skill_fk0" FOREIGN KEY ("user_id") REFERENCES "user_portfolio"("id");
ALTER TABLE "skill" ADD CONSTRAINT "skill_fk1" FOREIGN KEY ("group_id") REFERENCES "group"("id");



ALTER TABLE "education" ADD CONSTRAINT "education_fk0" FOREIGN KEY ("user_id") REFERENCES "user_portfolio"("id");
ALTER TABLE "education" ADD CONSTRAINT "education_fk1" FOREIGN KEY ("address_id") REFERENCES "address"("id");

ALTER TABLE "vacancy" ADD CONSTRAINT "vacancy_fk0" FOREIGN KEY ("creator_id") REFERENCES "user_portfolio"("id");
ALTER TABLE "vacancy" ADD CONSTRAINT "vacancy_fk1" FOREIGN KEY ("company_id") REFERENCES "company"("id");
ALTER TABLE "vacancy" ADD CONSTRAINT "vacancy_fk2" FOREIGN KEY ("address_id") REFERENCES "address"("id");

ALTER TABLE "work_experience" ADD CONSTRAINT "work_experience_fk0" FOREIGN KEY ("user_id") REFERENCES "user_portfolio"("id");
ALTER TABLE "work_experience" ADD CONSTRAINT "work_experience_fk1" FOREIGN KEY ("address_id") REFERENCES "address"("id");
ALTER TABLE "work_experience" ADD CONSTRAINT "work_experience_fk2" FOREIGN KEY ("company_id") REFERENCES "company"("id");

ALTER TABLE "address" ADD CONSTRAINT "address_fk0" FOREIGN KEY ("city_id") REFERENCES "city"("id");

ALTER TABLE "city" ADD CONSTRAINT "city_fk0" FOREIGN KEY ("country_id") REFERENCES "country"("id");

ALTER TABLE "country" ADD CONSTRAINT "country_fk0" FOREIGN KEY ("region_id") REFERENCES "region"("id");


