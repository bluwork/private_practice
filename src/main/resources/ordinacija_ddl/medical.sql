DROP TABLE IF EXISTS `medical`;

CREATE TABLE `medical` (

  `id`            BIGINT(20) NOT NULL AUTO_INCREMENT,
  `doctor_id`     BIGINT(20) NOT NULL,
  `patient_id`    VARCHAR(20) NOT NULL,
  `medical_date`  DATETIME DEFAULT NULL,
  `description`   TEXT,
  `diagnosis`     VARCHAR(20) NOT NULL,
  `therapy`       TEXT,

  PRIMARY KEY (`id`),

  CONSTRAINT `medical_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `medical_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `medical_ibfk_3` FOREIGN KEY (`diagnosis`) REFERENCES `diagnosis` (`code`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
