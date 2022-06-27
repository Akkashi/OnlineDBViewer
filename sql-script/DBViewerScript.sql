/*
 * Project: DBViewerScript
 * Created by Akkashi
 * on 23/06/2022 at 10:50
 */

-- Creating database with name, username and password
create DATABASE world;
create user explorer with ENCRYPTED PASSWORD '63xyZ9=4LhZ!r2Fv';
grant all privileges on DATABASE world to explorer;

-- Creating a table "countries" in this database with fields: id, name and capital_city
create TABLE "countries" (
    id SERIAL PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    capital_city VARCHAR(40) NOT NULL
);

-- Insert some values in the table "countries"
insert into
    "countries" (name, capital_city)
values
    ('France', 'Paris'),
    ('Spain', 'Madrid'),
    ('Italy', 'Rome'),
    ('United States', 'Washington DC');
