DROP TABLE IF EXISTS `prescription`;

CREATE TABLE `prescription` (

  `medical_id`       BIGINT(20) DEFAULT NULL,
  `description`      TEXT,

  CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
