-- Dumping data for table dbbooks4u.tb_authors: ~2 rows (approximately)
INSERT INTO `tb_authors` (`id`, `name`)
VALUES (1, 'Agatha Christie'),
       (2, 'Espirito Santo');

-- Dumping data for table dbbooks4u.tb_genres: ~3 rows (approximately)
INSERT INTO `tb_genres` (`id`, `name`)
VALUES (1, 'Drama'),
       (3, 'Salvação'),
       (2, 'Vida');

-- Dumping data for table dbbooks4u.tb_publishers: ~2 rows (approximately)
INSERT INTO `tb_publishers` (`id`, `name`)
VALUES (1, 'Editora Globo S/A'),
       (2, 'The chosen');

-- Dumping data for table dbbooks4u.tb_books_localizations: ~2 rows (approximately)
INSERT INTO `tb_books_localizations` (`id`, `bookcase`, `shelf`)
VALUES (1, 'B', '2'),
       (2, 'C', '1');

-- Dumping data for table dbbooks4u.tb_classrooms: ~1 rows (approximately)
INSERT INTO `tb_classrooms` (`id`, `class_year`, `shift`, `active`)
VALUES (1, '2024', '701', 1);

-- Dumping data for table dbbooks4u.tb_students: ~1 rows (approximately)
INSERT INTO `tb_students` (`id`, `fullname`, `enrollment`, `active`, `classroom_id`)
VALUES (1, 'Marcos Aurélio', 919191912291, 1, 1);

-- Dumping data for table dbbooks4u.tb_books: ~3 rows (approximately)
INSERT INTO `tb_books` (`id`, `title`, `CDD`, `CDU`, `CUTER`, `active`, `status`, `copy`, `genre_id`, `publisher_id`,
                        `books_localization_id`, `author_id`)
VALUES (1, 'E não sobrou nenhum', '123', '123', '123', 1, 'ATIVO', 2, 1, 1, 1, NULL),
       (2, 'E não sobrou nenhum 2', '123', '123', '123', 1, 'ATIVO', 2, 1, 1, 1, NULL),
       (3, 'Bíblia Sagrada', '1232', '1232', '123', 1, 'ATIVO', 2, NULL, 2, 2, NULL);

-- Dumping data for table dbbooks4u.tb_books_authors: ~4 rows (approximately)
INSERT INTO `tb_books_authors` (`book_id`, `author_id`)
VALUES (1, 1),
       (2, 1),
       (3, 1),
       (3, 2);

-- Dumping data for table dbbooks4u.tb_books_genres: ~2 rows (approximately)
INSERT INTO `tb_books_genres` (`book_id`, `genre_id`)
VALUES (3, 2),
       (3, 3);

-- Dumping data for table dbbooks4u.tb_loans: ~1 rows (approximately)
INSERT INTO `tb_loans` (`id`, `start_date`, `end_date`, `delivered_date`, `tax`, `book_id`, `student_id`)
VALUES (1, '2023-12-01', '2023-12-31', NULL, 0.52, NULL, 1);

-- Dumping data for table dbbooks4u.tb_loan_books: ~2 rows (approximately)
INSERT INTO `tb_loan_books` (`loan_id`, `book_id`)
VALUES (1, 1),
       (1, 2);












