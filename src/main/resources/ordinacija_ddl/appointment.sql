DROP TABLE IF EXISTS `appointment`;

CREATE TABLE `appointment` (

  `id`              BIGINT(20) NOT NULL AUTO_INCREMENT,
  `doctor_id`       BIGINT(20) NOT NULL,
  `patient_id`      VARCHAR(20) NOT NULL,
  `date`            DATE NOT NULL,
  `time`            TIME NOT NULL,
  `part`            INT(10) NOT NULL,
  `realized`        TINYINT(1) DEFAULT 0,
  
  PRIMARY KEY (`id`),

  CONSTRAINT `appointment_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `appointment_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;