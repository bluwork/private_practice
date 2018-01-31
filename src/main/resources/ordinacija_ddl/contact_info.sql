SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `contact_info`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `contact_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `city_zip_code` bigint(20) DEFAULT NULL,
  `patient_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `contact_info_ibfk_1` FOREIGN KEY (`city_zip_code`) REFERENCES `city` (`zip_code`),
  CONSTRAINT `contact_info_ibfk_2` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

INSERT INTO `contact_info`
	(`id`, `address`, `email`, `phone`, `city_zip_code`, `patient_id`)
VALUES
	(1, 'Ul Vojislava Ilica 107', 'milovan.petrovic@proba.net', '+381 88 1234567', 11000, 1),
	(2, 'Ul Aleksandra Belica 18', 'dragan.milovanovic@proba.net', '+381 83 623456', 18000, 2),
        (3, 'Bulevar Mihajla Pupina', 'dalibor.lazic@proba.net', '+381 81 2234577', 21000, 3),
        (4, 'Ul Vrsacka 24', 'jelisaveta22@proba.net', '+381 84 1234567', 11000, 4),  
        (5, 'Ul Balkanska 45', 'boba.j@proba.net', '+381 88 7234567', 18000, 5),  
        (6, 'Ul Vojvodjanskih brigada 48', 'dragana.vel@proba.net', '+381 88 8234567', 21000, 6),  
        (7, 'Ul Vojvode Misica 11', 'grandanta@proba.net', '+381 88 9234567', 11000, 7),  
        (8, 'Ul Branka Bjegovica 81', 'bora.daba@proba.net', '+381 88 0234567', 18000, 8),  
        (9, 'Ul Maksima Gorkog 22', 'zare2323@proba.net', '+381 83 1234567', 21000, 9),  
        (10, 'Ul Vojvode Stepe 14', 'stole011@proba.net', '+381 84 1234567', 11000, 10),  
        (11, 'Ul Belotinacka 15', 'ema.rad123@proba.net', '+381 86 1234567', 18000, 11),  
	(12, 'Ul Uspenska 68', 'nata123@proba.net', '+381 85 1234567', 21000, 12);



