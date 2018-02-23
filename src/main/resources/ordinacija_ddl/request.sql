SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `request`;
SET FOREIGN_KEY_CHECKS=1;


SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `request`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `request` (
  `id`            bigint(20) NOT NULL AUTO_INCREMENT,
  `doctor_id`     bigint(20) DEFAULT NULL,
  `medical_id`    bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),

  CONSTRAINT `request_ibfk_1` FOREIGN KEY (`doctor_id`) REFERENCES `app_user` (`id`),
  CONSTRAINT `request_ibfk_2` FOREIGN KEY (`medical_id`) REFERENCES `medical` (`id`)

) ENGINE=MyISAM DEFAULT CHARSET=utf8;


