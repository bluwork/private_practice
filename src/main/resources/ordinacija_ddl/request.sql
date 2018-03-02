DROP TABLE IF EXISTS `request`;

CREATE TABLE `request` (

  `id`            BIGINT(20) NOT NULL AUTO_INCREMENT,
  `doctor_id`     BIGINT(20) DEFAULT NULL,
  `medical_id`    BIGINT(20) DEFAULT NULL,

  PRIMARY KEY (`id`),

  CONSTRAINT `request_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `request_ibfk_2` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`)

)ENGINE=InnoDB DEFAULT CHARSET=utf8;


