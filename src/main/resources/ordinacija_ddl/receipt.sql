DROP TABLE IF EXISTS `receipt`;

CREATE TABLE `receipt` (

  `id`              BIGINT(20) NOT NULL AUTO_INCREMENT,
  `description`     VARCHAR(255) DEFAULT NULL,
  `doctor_id`       BIGINT(20) DEFAULT NULL,
  `medical_id`      BIGINT(20) DEFAULT NULL,
  `patient_id`      BIGINT(20) DEFAULT NULL,

  PRIMARY KEY (`id`),

  CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`doctor_id`)  REFERENCES `app_user` (`id`),
  CONSTRAINT `receipt_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `receipt_ibfk_3` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
