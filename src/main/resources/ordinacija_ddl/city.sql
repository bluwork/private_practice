SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `city`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `city` (
  `zip_code` bigint(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`zip_code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `city`
	(`zip_code`, `name`)
VALUES
	(11000, 'Beograd'),
	(18000, 'Nis'),
	(21000, 'Novi Sad'),
	(34000, 'Kragujevac');
