SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `result`;
SET FOREIGN_KEY_CHECKS=1;


CREATE TABLE `result` (

  `id`           BIGINT(20) NOT NULL AUTO_INCREMENT,
  `medical_id`   BIGINT(20) DEFAULT NULL,
  `patient_id`   BIGINT(20) DEFAULT NULL,
  `request_id`   BIGINT(20) DEFAULT NULL,
  `result_type`  VARCHAR(31) NOT NULL,
  `spec_res`     TEXT,
  `lab_res`      TEXT,

  PRIMARY KEY (`id`),

  CONSTRAINT `result_ibfk_1` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `result_ibfk_2` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`),
  CONSTRAINT `result_ibfk_3` FOREIGN KEY (`request_id`) REFERENCES `request` (`id`)
--   CONSTRAINT `result_ibfk_3` FOREIGN KEY (`request_id`) REFERENCES `request` (`id`)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;

