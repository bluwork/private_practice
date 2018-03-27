DROP TABLE IF EXISTS `prescription`;

CREATE TABLE `prescription` (

  `id`                    BIGINT(20) NOT NULL AUTO_INCREMENT,
  `global_id`             VARCHAR(20) DEFAULT NULL,
  `creation_date`         DATETIME NOT NULL,
  `description`           TEXT,
  `realized`              TINYINT(1) DEFAULT 0,
  `prescriptioner_id`     BIGINT(20) NOT NULL,
  `patient_id`            VARCHAR(20) NOT NULL,

  PRIMARY KEY (`id`),

  CONSTRAINT `prescription_ibfk_1` FOREIGN KEY (`prescriptioner_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `prescription_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;
