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
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

INSERT INTO `patient`
	(`id`, `first_name`, `last_name`, `middle_name`, `dob`, `gender`, `blood_type`, `allergies`)
VALUES
	(1, 'Milovan', 'Petrovic', 'Jovan','1978-12-18', 'MALE', 'A_POSITIVE', 'penicilin' ),
	(2, 'Dragan', 'Milovanovic', 'Petar', '1993-02-28', 'MALE', 'B_POSITIVE', NULL),
	(3, 'Dalibor', 'Lazic', 'Dejan','1984-11-02', 'MALE', 'AB_POSITIVE', NULL),
        (4, 'Jelisavete', 'Markovic', 'Slobodan','1987-12-31', 'FEMALE', 'O_POSITIVE', NULL);


