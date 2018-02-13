SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `patient`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `patient` (

  `id`                BIGINT(20) NOT NULL UNIQUE,
  `first_name`        VARCHAR(30) DEFAULT NULL,
  `middle_name`       VARCHAR(30) DEFAULT NULL,
  `last_name`         VARCHAR(30) DEFAULT NULL,
  `dob`               DATE DEFAULT NULL,
  `gender`            VARCHAR(6) DEFAULT NULL,
  `blood_type`        VARCHAR(15) DEFAULT NULL,
  `allergies`         VARCHAR(255) DEFAULT NULL,
  `med_schedule_date`  DATE DEFAULT NULL,
  `med_schedule_time`  TIME DEFAULT NULL,

  PRIMARY KEY (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `patient`
	(`id`, `first_name`, `last_name`, `middle_name`, `dob`, `gender`, `blood_type`, `allergies`, `med_schedule_date`, `med_schedule_time`)
VALUES
	(12345678, 'Milovan', 'Petrovic', 'Jovan','1978-12-18', 'MALE', 'A_POSITIVE', 'penicilin', NULL, NULL),
	(22345678, 'Драган', 'Миловановић', 'Петар', '1993-02-28', 'MALE', 'B_POSITIVE', NULL, NULL, NULL),
	(32345678, 'Dalibor', 'Lazic', 'Dejan','1999-10-02', 'MALE', 'AB_POSITIVE', NULL, NULL, NULL),
        (42345678, 'Jelisaveta', 'Antic', 'Antonije','1974-10-31', 'FEMALE', 'O_POSITIVE', NULL, NULL, NULL),
        (52345678, 'Jovana', 'Bobic', 'Vasilije','1956-02-14', 'FEMALE', 'B_POSITIVE', NULL, NULL, NULL),
        (62345678, 'Dragana', 'Velikic', 'Stanko','1983-08-18', 'FEMALE', 'O_POSITIVE', 'penicilin', NULL, NULL),
        (72345678, 'Antonije', 'Kafic', 'Ivica','1964-05-31', 'MALE', 'A_NEGATIVE', NULL, '2018-05-31', '08:00:00'),
        (82345678, 'Borislav', 'Dabovic', 'Dragomir','1965-06-18', 'MALE', 'AB_POSITIVE', NULL, NULL, NULL),
        (92345678, 'Vladimir', 'Zarkovic', 'Radovan','2001-09-24', 'MALE', 'O_POSITIVE', NULL, NULL, NULL),
        (102345678, 'Goran', 'Stojanovic', 'Zoran','2009-01-31', 'MALE', 'B_POSITIVE', NULL, NULL, NULL),
        (112345678, 'Emilija', 'Radic', 'Zdravko','1993-11-30', 'FEMALE', 'A_POSITIVE', 'penicilin', '2018-02-13', '09:00:00'),
        (122345678, 'Natalija', 'Tapuskovic', 'Slobodan','1948-06-30', 'FEMALE', 'O_NEGATIVE', NULL, NULL, NULL);


