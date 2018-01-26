SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `contact_info`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `contact_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `city_zip_code` bigint(20) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `contact_info_ibfk_1` FOREIGN KEY (`city_zip_code`) REFERENCES `city` (`zip_code`),
  CONSTRAINT `contact_info_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

INSERT INTO `contact_info`
	(`id`, `address`, `email`, `phone`, `city_zip_code`, `patient_id`)
VALUES
	(1, 'Ul Savesnih vozaca 13', 'milovan.petrovic@proba.net', '123454994', 11000, 1),
	(2, 'Ul Zone Zamfirove 24', 'dragan.milovanovic@proba.net', '6012345', 18000, 2),
	(3, 'Ul Vojvodjanskih skijalista 24', 'dalibor.lazic@proba.net', '12495885', 21000, 3);



