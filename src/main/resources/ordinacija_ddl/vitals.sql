DROP TABLE IF EXISTS `vitals`;

CREATE TABLE `vitals` (

  `id`              BIGINT(20) NOT NULL AUTO_INCREMENT,
  `patient_id`      VARCHAR(20) DEFAULT NULL,
  `measuring_date`  DATE NOT NULL,
  `diastolic_bp`    INT(11) DEFAULT NULL,
  `systolic_bp`     INT(11) DEFAULT NULL,
  `body_temp`       FLOAT DEFAULT NULL,
  `heart_rate`      INT(11) DEFAULT NULL,
  `height`          INT(11) DEFAULT NULL,
  `mass`            INT(11) DEFAULT NULL,

  PRIMARY KEY (`id`),

  CONSTRAINT `vitals_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`) ON DELETE CASCADE ON UPDATE CASCADE

) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `vitals`
	(`id`, `measuring_date`, `diastolic_bp`, `systolic_bp`, `body_temp`, `heart_rate`, `height`, `mass`, `patient_id`)
VALUES
	(1, '2017-07-14', 78, 125, 36.8, 72, 192, 84, 12345678),
	(2, '2017-08-18', 84, 120, 36.7, 73, 192, 86, 12345678),
	(3, '2016-06-12', 67, 110, 36.9, 64, 177, 69, 22345678),
	(4, '2017-08-14', 72, 125, 36.8, 68, 177, 67, 22345678),
	(5, '2015-04-01', 95, 145, 36.8, 85, 184, 95, 32345678),
	(6, '2017-08-14', 85, 130, 36.4, 78, 184, 85, 32345678);
	
