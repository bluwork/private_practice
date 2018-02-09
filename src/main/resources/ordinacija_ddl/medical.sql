CREATE TABLE `medical` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `diagnosis` text,
  `medical_date` date DEFAULT NULL,
  `therapy` text,
  `doctor_id` int(11) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`),
  CONSTRAINT `medical_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `medical_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
