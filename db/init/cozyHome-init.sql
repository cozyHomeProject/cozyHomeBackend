CREATE TABLE IF NOT EXISTS "users" (
	"id" serial NOT NULL,
	"username" varchar(255) NOT NULL UNIQUE,
	"email" varchar(255) NOT NULL UNIQUE,
	"password" varchar(255) NOT NULL,
	"name" varchar(255) NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "groceries_lists" (
	"id" serial NOT NULL UNIQUE,
	"closed" boolean NOT NULL DEFAULT false,
	"created_at" timestamp without time zone NOT NULL,
	"modified_at" timestamp without time zone NOT NULL,
	"created_by" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "grocery_item" (
	"id" serial NOT NULL UNIQUE,
	"name" varchar(100) NOT NULL,
	"created_at" timestamp without time zone NOT NULL,
	"measure_unit" varchar(255) NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "groceries_list_item" (
	"id" serial NOT NULL UNIQUE,
	"groceries_list_id" bigint NOT NULL,
	"groceries_item" bigint NOT NULL,
	"amount" varchar(255) NOT NULL,
	"last_ordered_at" timestamp without time zone NOT NULL,
	"ordered_by" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "meals" (
	"id" serial NOT NULL UNIQUE,
	"name" varchar(255) NOT NULL,
	"recipe" varchar(255),
	"recipe_url" varchar(255),
	"created_at" timestamp without time zone NOT NULL,
	"created_by" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "meal_plans" (
	"id" serial NOT NULL UNIQUE,
	"week" bigint NOT NULL,
	"created_at" timestamp without time zone NOT NULL,
	"modified_at" timestamp without time zone NOT NULL,
	"created_by" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "meal_plan_items" (
	"id" serial NOT NULL UNIQUE,
	"meal_plan_id" bigint NOT NULL,
	"meal_type_id" bigint NOT NULL,
	"meal" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "meal_types" (
	"id" serial NOT NULL UNIQUE,
	"name" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "task_lists" (
	"id" serial NOT NULL UNIQUE,
	"name" varchar(255) NOT NULL,
	"description" varchar(255) NOT NULL,
	"closed" boolean NOT NULL DEFAULT false,
	"created_at" timestamp without time zone NOT NULL,
	"modified_at" timestamp without time zone NOT NULL,
	"created_by" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "task" (
	"id" serial NOT NULL UNIQUE,
	"name" varchar(255) NOT NULL,
	"description" varchar(255) NOT NULL,
	"frequency" varchar(255) NOT NULL,
	"created_at" timestamp without time zone NOT NULL,
	"modified_at" timestamp without time zone NOT NULL,
	"created_by" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "task_assignments" (
	"id" serial NOT NULL UNIQUE,
	"task_list_id" bigint NOT NULL,
	"task_id" bigint NOT NULL,
	"due_date" timestamp without time zone,
	"finished" boolean NOT NULL DEFAULT false,
	"assignee" bigint,
	"created_at" timestamp without time zone NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "pets" (
	"id" serial NOT NULL UNIQUE,
	"name" varchar(255) NOT NULL,
	"birth_date" date,
	"age" bigint,
	"type" varchar(255) NOT NULL,
	"created_at" timestamp without time zone NOT NULL,
	"created_by" bigint NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "pet_pictures" (
	"id" serial NOT NULL UNIQUE,
	"pet_id" bigint NOT NULL,
	"image_url" varchar(255) NOT NULL,
	PRIMARY KEY ("id")
);

CREATE TABLE IF NOT EXISTS "pet_appointments" (
	"id" serial NOT NULL UNIQUE,
	"pet_id" bigint NOT NULL,
	"appointment" varchar(255) NOT NULL,
	"due_date" timestamp without time zone NOT NULL,
	"created_by" bigint NOT NULL,
	"frequency" varchar(255) NOT NULL,
	"finished" boolean NOT NULL,
	PRIMARY KEY ("id")
);


ALTER TABLE "groceries_lists" ADD CONSTRAINT "groceries_lists_fk4" FOREIGN KEY ("created_by") REFERENCES "users"("id");

ALTER TABLE "groceries_list_item" ADD CONSTRAINT "groceries_list_item_fk1" FOREIGN KEY ("groceries_list_id") REFERENCES "groceries_lists"("id");

ALTER TABLE "groceries_list_item" ADD CONSTRAINT "groceries_list_item_fk2" FOREIGN KEY ("groceries_item") REFERENCES "grocery_item"("id");

ALTER TABLE "groceries_list_item" ADD CONSTRAINT "groceries_list_item_fk5" FOREIGN KEY ("ordered_by") REFERENCES "users"("id");
ALTER TABLE "meals" ADD CONSTRAINT "meals_fk5" FOREIGN KEY ("created_by") REFERENCES "users"("id");
ALTER TABLE "meal_plans" ADD CONSTRAINT "meal_plans_fk4" FOREIGN KEY ("created_by") REFERENCES "users"("id");
ALTER TABLE "meal_plan_items" ADD CONSTRAINT "meal_plan_items_fk1" FOREIGN KEY ("meal_plan_id") REFERENCES "meal_plans"("id");

ALTER TABLE "meal_plan_items" ADD CONSTRAINT "meal_plan_items_fk2" FOREIGN KEY ("meal_type_id") REFERENCES "meal_types"("id");

ALTER TABLE "meal_plan_items" ADD CONSTRAINT "meal_plan_items_fk3" FOREIGN KEY ("meal") REFERENCES "meals"("id");

ALTER TABLE "task_lists" ADD CONSTRAINT "task_lists_fk6" FOREIGN KEY ("created_by") REFERENCES "users"("id");
ALTER TABLE "task" ADD CONSTRAINT "task_fk6" FOREIGN KEY ("created_by") REFERENCES "users"("id");
ALTER TABLE "task_assignments" ADD CONSTRAINT "task_assignments_fk1" FOREIGN KEY ("task_list_id") REFERENCES "task_lists"("id");

ALTER TABLE "task_assignments" ADD CONSTRAINT "task_assignments_fk2" FOREIGN KEY ("task_id") REFERENCES "task"("id");

ALTER TABLE "task_assignments" ADD CONSTRAINT "task_assignments_fk5" FOREIGN KEY ("assignee") REFERENCES "users"("id");
ALTER TABLE "pets" ADD CONSTRAINT "pets_fk6" FOREIGN KEY ("created_by") REFERENCES "users"("id");
ALTER TABLE "pet_pictures" ADD CONSTRAINT "pet_pictures_fk1" FOREIGN KEY ("pet_id") REFERENCES "pets"("id");
ALTER TABLE "pet_appointments" ADD CONSTRAINT "pet_appointments_fk1" FOREIGN KEY ("pet_id") REFERENCES "pets"("id");

ALTER TABLE "pet_appointments" ADD CONSTRAINT "pet_appointments_fk4" FOREIGN KEY ("created_by") REFERENCES "users"("id");