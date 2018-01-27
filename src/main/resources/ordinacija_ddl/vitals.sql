SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `vitals`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `vitals` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `measuring_date` date NOT NULL,
  `diastolic_bp` int(11) DEFAULT NULL,
  `systolic_bp` int(11) DEFAULT NULL,
  `body_temp` float DEFAULT NULL,
  `heart_rate` int(11) DEFAULT NULL,
  `height` int(11) DEFAULT NULL,
  `mass` int(11) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `vitals_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `vitals`
	(`id`, `measuring_date`, `diastolic_bp`, `systolic_bp`, `body_temp`, `heart_rate`, `height`, `mass`, `patient_id`)
VALUES
	(1, '2017-07-14', 78, 125, 36.8, 72, 192, 84, 1),
	(2, '2017-08-18', 84, 120, 36.7, 73, 192, 86, 1),
	(3, '2016-06-12', 67, 110, 36.9, 64, 177, 69, 2),
	(4, '2017-08-14', 72, 125, 36.8, 68, 177, 67, 2),
	(5, '2015-04-01', 95, 145, 36.8, 85, 184, 95, 3),
	(6, '2017-08-14', 85, 130, 36.4, 78, 184, 85, 3);
	
