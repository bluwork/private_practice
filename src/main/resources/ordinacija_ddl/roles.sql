SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `roles`;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE `roles` (
  `app_user` int(11) NOT NULL,
  `roles` varchar(255) DEFAULT NULL,
  CONSTRAINT `roles_ibfk_1` FOREIGN KEY (`app_user`) REFERENCES `app_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO  `roles`
(`app_user`, `roles`)
VALUES
(1, 'ADMIN'),
(1, 'PHYSICIAN'),
(1, 'NURSE'),
(2, 'PHYSICIAN'),
(2, 'NURSE'),
(3, 'PHYSICIAN'),
(3, 'NURSE'),
(4, 'PHYSICIAN'),
(4, 'NURSE'),
(5, 'NURSE'),
(6, 'NURSE'),
(7, 'NURSE');
