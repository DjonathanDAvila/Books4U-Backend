CREATE TABLE `tb_authors`
(
    `id`   BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL
);

CREATE TABLE `tb_books_localizations`
(
    `id`       BIGINT PRIMARY KEY AUTO_INCREMENT,
    `bookcase` CHAR(55),
    `shelf`    CHAR(55)
);

CREATE TABLE `tb_genres`
(
    `id`   BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE `tb_publishers`
(
    `id`   BIGINT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE `tb_classrooms`
(
    `id`         BIGINT PRIMARY KEY AUTO_INCREMENT,
    `class_year` CHAR(55),
    `shift`      CHAR(55),
    `active`     BOOLEAN DEFAULT true
);

CREATE TABLE `tb_students`
(
    `id`           BIGINT PRIMARY KEY AUTO_INCREMENT,
    `fullname`     VARCHAR(255)  NOT NULL,
    `enrollment`   BIGINT UNIQUE NOT NULL,
    `active`       BOOLEAN DEFAULT true,
    `classroom_id` BIGINT
);

CREATE TABLE `tb_books`
(
    `id`                    BIGINT PRIMARY KEY AUTO_INCREMENT,
    `title`                 VARCHAR(255) NOT NULL,
    `CDD`                   VARCHAR(255),
    `CDU`                   VARCHAR(255),
    `CUTER`                 VARCHAR(255),
    `active`                BOOLEAN DEFAULT true,
    `status`                VARCHAR(55)  NOT NULL,
    `copy`                  INT          NOT NULL,
    `genre_id`              BIGINT,
    `publisher_id`          BIGINT,
    `books_localization_id` BIGINT,
    `author_id`             BIGINT
);

CREATE TABLE `tb_loans`
(
    `id`             BIGINT PRIMARY KEY AUTO_INCREMENT,
    `start_date`     DATE NOT NULL,
    `end_date`       DATE NOT NULL,
    `delivered_date` DATE,
    `tax` DOUBLE,
    `book_id`        BIGINT,
    `student_id`     BIGINT
);

CREATE TABLE `tb_books_authors`
(
    `book_id`   BIGINT,
    `author_id` BIGINT,
    PRIMARY KEY (`book_id`, `author_id`)
);

CREATE TABLE `tb_loan_books`
(
    `loan_id` BIGINT,
    `book_id` BIGINT,
    PRIMARY KEY (`loan_id`, `book_id`)
);

CREATE TABLE `tb_books_genres`
(
    `book_id`  BIGINT,
    `genre_id` BIGINT,
    PRIMARY KEY (`book_id`, `genre_id`)
);


ALTER TABLE `tb_students`
    ADD FOREIGN KEY (`classroom_id`) REFERENCES `tb_classrooms` (`id`);

ALTER TABLE `tb_books`
    ADD FOREIGN KEY (`genre_id`) REFERENCES `tb_genres` (`id`);

ALTER TABLE `tb_books`
    ADD FOREIGN KEY (`publisher_id`) REFERENCES `tb_publishers` (`id`);

ALTER TABLE `tb_books`
    ADD FOREIGN KEY (`books_localization_id`) REFERENCES `tb_books_localizations` (`id`);

ALTER TABLE `tb_loans`
    ADD FOREIGN KEY (`book_id`) REFERENCES `tb_books` (`id`);

ALTER TABLE `tb_loans`
    ADD FOREIGN KEY (`student_id`) REFERENCES `tb_students` (`id`);

ALTER TABLE `tb_books_authors`
    ADD FOREIGN KEY (`book_id`) REFERENCES `tb_books` (`id`);

ALTER TABLE `tb_books_authors`
    ADD FOREIGN KEY (`author_id`) REFERENCES `tb_authors` (`id`);

ALTER TABLE `tb_loan_books`
    ADD FOREIGN KEY (`book_id`) REFERENCES `tb_books` (`id`);

ALTER TABLE `tb_loan_books`
    ADD FOREIGN KEY (`loan_id`) REFERENCES `tb_loans` (`id`);

ALTER TABLE `tb_books_genres`
    ADD FOREIGN KEY (`book_id`) REFERENCES `tb_books` (`id`);

ALTER TABLE `tb_books_genres`
    ADD FOREIGN KEY (`genre_id`) REFERENCES `tb_genres` (`id`);