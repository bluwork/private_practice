CREATE TABLE `medical` (

  `id`            BIGINT(20) NOT NULL AUTO_INCREMENT,
  `doctor_id`     INT(11) DEFAULT NULL,
  `patient_id`    BIGINT(20) DEFAULT NULL,
  `medical_date`  DATETIME DEFAULT NULL,
  `description`   TEXT,
  `diagnosis`     TEXT,
  `therapy`       TEXT,

  PRIMARY KEY (`id`),

  CONSTRAINT `medical_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `medical_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
