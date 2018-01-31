SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `app_user`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE  `app_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT, 
  `username` VARCHAR(50) NOT NULL UNIQUE,
  `password` VARCHAR(255) DEFAULT NULL,
  `first_name` VARCHAR(50) DEFAULT NULL,
  `last_name` VARCHAR(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
 

INSERT INTO `app_user` (`id`, `username`, `password`, `first_name`, `last_name`)
VALUES 
(1, 'admin', 'Adm1n', 'Boban', 'Lukic'),
(2, 'doktor_jova', 'jova123', 'Jovan', 'Peric'),
(3, 'doktor_pera', 'pera123', 'Petar', 'Milovanovic'),
(4, 'doktor_mita', 'mita123', 'Mita', 'Stojanovic'),
(5, 'sestra_mara', 'mara123', 'Mara', 'Simic'),
(6, 'sestra_visnja', 'visnja123', 'Visnja', 'Surdilovic'),
(7, 'sestra_jovka', 'jovka123', 'Jovka', 'Lazovic');
