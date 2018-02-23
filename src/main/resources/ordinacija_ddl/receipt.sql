SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `receipt`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `receipt` (

  `id`              bigint(20) NOT NULL AUTO_INCREMENT,
  `description`     varchar(255) DEFAULT NULL,
  `doctor_id`       bigint(20) DEFAULT NULL,
  `medical_id`      bigint(20) DEFAULT NULL,
  `patient_id`      bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),

  CONSTRAINT `receipt_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `receipt_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `receipt_ibfk_3` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
