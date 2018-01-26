SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `patient`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `patient` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(30) DEFAULT NULL,
  `middle_name` varchar(30) DEFAULT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `blood_type` varchar(15) DEFAULT NULL,
  `allergies` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `patient`
	(`id`, `first_name`, `last_name`, `middle_name`, `allergies`, `blood_type`, `dob` )
VALUES
	(1, 'Milovan', 'Petrovic', 'Jovan', 'penicilin', 'A_POSITIVE', '1978-12-18'),
	(2, 'Dragan', 'Milovanovic', 'Petar', NULL, 'O_NEGATIVE', '1993-02-28'),
	(3, 'Dalibor', 'Lazic', 'Dejan', NULL, 'B_POSITIVE', '1984-11-02');


