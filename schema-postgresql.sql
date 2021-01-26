DROP TABLE IF EXISTS reviews;
CREATE TABLE reviews (id serial, category_id integer NOT NULL, app_id integer NOT NULL, author_id VARCHAR(500) NOT NULL, title VARCHAR(500) NOT NULL,
    rating integer NOT NULL, content TEXT NOT NULL, date VARCHAR(500) NOT NULL);