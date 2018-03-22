DROP TABLE IF EXISTS `appointment`;

CREATE TABLE `appointment` (

  `id`              BIGINT(20) NOT NULL AUTO_INCREMENT,
  `doctor_id`       BIGINT(20) NOT NULL,
  `patient_id`      BIGINT(20) NOT NULL,
  `date`            DATE NOT NULL,
  `time`            TIME NOT NULL,
  `part`            INT(10) NOT NULL,
  
  PRIMARY KEY (`id`),

  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;