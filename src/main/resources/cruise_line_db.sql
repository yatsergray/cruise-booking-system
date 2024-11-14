CREATE TABLE countries
(
    id   INTEGER(10)  NOT NULL,
    name VARCHAR(225) NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE cities
(
    id         INTEGER(10)  NOT NULL,
    country_id INTEGER(10)  NOT NULL,
    name       VARCHAR(225) NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE destinations
(
    id             INTEGER(10) NOT NULL,
    cruise_id      INTEGER(10) NOT NULL,
    city_id        INTEGER(10) NOT NULL,
    arrival_number INTEGER(10) NOT NULL,
    arrival_date   DATE        NOT NULL,
    arrival_time   TIME        NOT NULL,
    departure_date DATE        NOT NULL,
    departure_time TIME        NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE cruises
(
    id             INTEGER(10) NOT NULL,
    begin_id       INTEGER(10) NOT NULL,
    end_id         INTEGER(10) NOT NULL,
    duration       INTEGER(10) NOT NULL,
    departure_date DATE        NOT NULL,
    arrival_date   DATE        NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE cruise_liners_cruises
(
    id              INTEGER(10) NOT NULL,
    cruise_liner_id INTEGER(10) NOT NULL,
    cruise_id       INTEGER(10) NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE cruise_liners
(
    id                      INTEGER(10)    NOT NULL,
    creation_year           VARCHAR(4)     NOT NULL,
    length                  DECIMAL(10, 2) NOT NULL,
    width                   DECIMAL(10, 2) NOT NULL,
    cruising_speed          DECIMAL(10, 2) NOT NULL,
    staff_amount            INTEGER(10)    NOT NULL,
    passengers_amount       INTEGER(10)    NOT NULL,
    decks_amount            INTEGER(10)    NOT NULL,
    cabins_amount           INTEGER(10)    NOT NULL,
    passengers_lifts_amount INTEGER(10)    NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE cabins
(
    id               INTEGER(10)    NOT NULL,
    cruise_liner_id  INTEGER(10)    NOT NULL,
    class_id         INTEGER(10)    NOT NULL,
    deck_number      INTEGER(10)    NOT NULL,
    capacity         INTEGER(10)    NOT NULL,
    adult_daily_cost DECIMAL(10, 2) NOT NULL,
    child_daily_cost DECIMAL(10, 2) NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

# CREATE TABLE cabins_statuses
# (
#     id   INTEGER(10)  NOT NULL,
#     name VARCHAR(225) NOT NULL
# )
#     ENGINE = InnoDB
#     DEFAULT CHARSET = utf8;

CREATE TABLE cabins_classes
(
    id   INTEGER(10)  NOT NULL,
    name VARCHAR(225) NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE users
(
    id       INTEGER(10)  NOT NULL,
    role_id  INTEGER(10)  NOT NULL,
    name     VARCHAR(225) NOT NULL,
    surname  VARCHAR(225) NOT NULL,
    email    VARCHAR(225) NOT NULL,
    password VARCHAR(225) NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

CREATE TABLE roles
(
    id   INTEGER(10)  NOT NULL,
    name VARCHAR(225) NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

# CREATE TABLE users_roles
# (
#     id      INTEGER(10) NOT NULL,
#     user_id INTEGER(10) NOT NULL,
#     role_id INTEGER(10) NOT NULL
# )
#     ENGINE = InnoDB
#     DEFAULT CHARSET = utf8;

CREATE TABLE users_cruises
(
    id        INTEGER(10) NOT NULL,
    user_id   INTEGER(10) NOT NULL,
    cruise_id INTEGER(10) NOT NULL
)
    ENGINE = InnoDB
    DEFAULT CHARSET = utf8;

ALTER TABLE countries
    ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE cities
    ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE destinations
    ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE cruises
    ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE cruise_liners_cruises
    ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE cruise_liners
    ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE cabins
    ADD CONSTRAINT PRIMARY KEY (id);
# ALTER TABLE cabins_statuses
#     ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE cabins_classes
    ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE users
    ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE roles
    ADD CONSTRAINT PRIMARY KEY (id);
# ALTER TABLE users_roles
#     ADD CONSTRAINT PRIMARY KEY (id);
ALTER TABLE users_cruises
    ADD CONSTRAINT PRIMARY KEY (id);

ALTER TABLE cities
    ADD CONSTRAINT FOREIGN KEY (country_id) REFERENCES countries (id);
ALTER TABLE destinations
    ADD CONSTRAINT FOREIGN KEY (cruise_id) REFERENCES cruises (id);
ALTER TABLE destinations
    ADD CONSTRAINT FOREIGN KEY (city_id) REFERENCES cities (id);
# ALTER TABLE cruises
#     ADD CONSTRAINT FOREIGN KEY (beginning_id) REFERENCES destinations (id);
# ALTER TABLE cruises
#     ADD CONSTRAINT FOREIGN KEY (end_id) REFERENCES destinations (id);
# ALTER TABLE cruise_liners_cruises
#     ADD CONSTRAINT FOREIGN KEY (cruise_liner_id) REFERENCES cruise_liners (id);
# ALTER TABLE cruise_liners_cruises
#     ADD CONSTRAINT FOREIGN KEY (cruise_id) REFERENCES cruises (id);
ALTER TABLE cabins
    ADD CONSTRAINT FOREIGN KEY (cruise_liner_id) REFERENCES cruise_liners (id);
ALTER TABLE cabins
    ADD CONSTRAINT FOREIGN KEY (class_id) REFERENCES cabins_classes (id);
# ALTER TABLE cabins
#     ADD CONSTRAINT FOREIGN KEY (status_id) REFERENCES cabins_statuses (id);
ALTER TABLE users
    ADD CONSTRAINT FOREIGN KEY (role_id) REFERENCES roles (id);
# ALTER TABLE users_roles
#     ADD CONSTRAINT FOREIGN KEY (user_id) REFERENCES users (id);
# ALTER TABLE users_roles
#     ADD CONSTRAINT FOREIGN KEY (role_id) REFERENCES roles (id);
ALTER TABLE users_cruises
    ADD CONSTRAINT FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE users_cruises
    ADD CONSTRAINT FOREIGN KEY (cruise_id) REFERENCES cruises (id);

ALTER TABLE cruises
    ADD CONSTRAINT FOREIGN KEY (cruise_liner_id) REFERENCES cruise_liners (id);

DELETE FROM cruises WHERE id BETWEEN 1 AND 5;

DELETE FROM destinations WHERE id BETWEEN 18 AND 42;

DELETE FROM cruises WHERE id BETWEEN 11 AND 19;

ALTER TABLE countries
    ADD UNIQUE (name);
ALTER TABLE cities
    ADD UNIQUE (name);
# ALTER TABLE cabins_statuses
#     ADD UNIQUE (name);
ALTER TABLE cabins_classes
    ADD UNIQUE (name);
ALTER TABLE users
    ADD UNIQUE (email);
ALTER TABLE roles
    ADD UNIQUE (name);


INSERT INTO cruises (id, duration, departure_date_time, arrival_date_time) VALUES (1, 7, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO cruises (id, duration, departure_date_time, arrival_date_time) VALUES (2, 5, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO cruises (id, duration, departure_date_time, arrival_date_time) VALUES (3, 3, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');

INSERT INTO cruise_liners (id, name, creation_year, length, width, cruising_speed, staff_amount, passengers_amount, decks_amount, cabins_amount) VALUES (1, 'Wonder of the Seas', '2022', 362, 66, 22, 2300, 6988, 24, 2867);
INSERT INTO cruise_liners (id, name, creation_year, length, width, cruising_speed, staff_amount, passengers_amount, decks_amount, cabins_amount) VALUES (2, 'Oasis of the Seas', '2019', 361.6, 60.5, 22.6, 2219, 6296, 18, 2700);
INSERT INTO cruise_liners (id, name, creation_year, length, width, cruising_speed, staff_amount, passengers_amount, decks_amount, cabins_amount) VALUES (3, 'Ovation of The Seas', '2020', 348, 41, 22, 1500, 4905, 18, 2090);

INSERT INTO cruise_liners_cruises (id, cruise_liner_id, cruise_id) VALUES (1, 1, 1);
INSERT INTO cruise_liners_cruises (id, cruise_liner_id, cruise_id) VALUES (2, 2, 2);
INSERT INTO cruise_liners_cruises (id, cruise_liner_id, cruise_id) VALUES (3, 3, 3);

INSERT INTO countries (id, name) VALUES (1, 'Spain');
INSERT INTO countries (id, name) VALUES (2, 'France');
INSERT INTO countries (id, name) VALUES (3, 'Italy');

INSERT INTO cities (id, country_id, name) VALUES (1, 1, 'Barcelona');
INSERT INTO cities (id, country_id, name) VALUES (2, 2, 'Marcel');
INSERT INTO cities (id, country_id, name) VALUES (3, 3, 'Rym');

INSERT INTO destinations (id, cruise_id, city_id, arrival_date_time, departure_date_time) VALUES (1, 1, 1, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO destinations (id, cruise_id, city_id, arrival_date_time, departure_date_time) VALUES (2, 1, 2, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO destinations (id, cruise_id, city_id, arrival_date_time, departure_date_time) VALUES (3, 1, 3, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO destinations (id, cruise_id, city_id, arrival_date_time, departure_date_time) VALUES (4, 2, 2, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO destinations (id, cruise_id, city_id, arrival_date_time, departure_date_time) VALUES (5, 2, 1, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO destinations (id, cruise_id, city_id, arrival_date_time, departure_date_time) VALUES (6, 2, 3, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO destinations (id, cruise_id, city_id, arrival_date_time, departure_date_time) VALUES (7, 3, 3, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO destinations (id, cruise_id, city_id, arrival_date_time, departure_date_time) VALUES (8, 3, 1, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');
INSERT INTO destinations (id, cruise_id, city_id, arrival_date_time, departure_date_time) VALUES (9, 3, 2, '2022-01-18T00:16:23.035579', '2022-01-18T00:16:23.035579');

DELETE FROM destinations WHERE id BETWEEN 145 AND 218;

DELETE FROM cruises WHERE id = 63;

SELECT destination.id,
       destination.cruise_id,
       destination.city_id,
       destination.departure_date_time,
       destination.arrival_date_time
FROM countries country
         INNER JOIN cities city ON city.country_id = country.id AND country.id = 1
         INNER JOIN destinations destination ON destination.city_id = city.id;
