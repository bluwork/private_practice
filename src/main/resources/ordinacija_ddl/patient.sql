SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `patient`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `middle_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `gender` varchar(6) DEFAULT NULL,
  `blood_type` varchar(15) DEFAULT NULL,
  `allergies` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

INSERT INTO `patient`
	(`id`, `first_name`, `last_name`, `middle_name`, `dob`, `gender`, `blood_type`, `allergies`)
VALUES
	(1, 'Milovan', 'Petrovic', 'Jovan','1978-12-18', 'MALE', 'A_POSITIVE', 'penicilin' ),
	(2, 'Dragan', 'Milovanovic', 'Petar', '1993-02-28', 'MALE', 'B_POSITIVE', NULL),
	(3, 'Dalibor', 'Lazic', 'Dejan','1999-10-02', 'MALE', 'AB_POSITIVE', NULL),
        (4, 'Jelisaveta', 'Antic', 'Antonije','1974-10-31', 'FEMALE', 'O_POSITIVE', NULL),
        (5, 'Jovana', 'Bobic', 'Vasilije','1956-02-14', 'FEMALE', 'B_POSITIVE', NULL),
        (6, 'Dragana', 'Velikic', 'Stanko','1983-08-18', 'FEMALE', 'O_POSITIVE', 'penicilin'),
        (7, 'Antonije', 'Grandic', 'Ivica','1964-05-31', 'MALE', 'A_NEGATIVE', NULL),
        (8, 'Borislav', 'Dabovic', 'Dragomir','1965-06-18', 'MALE', 'AB_POSITIVE', NULL),
        (9, 'Vladimir', 'Zarkovic', 'Radovan','2001-09-24', 'MALE', 'O_POSITIVE', NULL),
        (10, 'Goran', 'Stojanovic', 'Zoran','2009-01-31', 'MALE', 'B_POSITIVE', NULL),
        (11, 'Emilija', 'Radic', 'Zdravko','1993-11-30', 'FEMALE', 'A_POSITIVE', 'penicilin'),
        (12, 'Natalija', 'Tapuskovic', 'Slobodan','1948-06-30', 'FEMALE', 'O_NEGATIVE', NULL);


