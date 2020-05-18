DROP TABLE IF EXISTS `app_user`;

CREATE TABLE  `app_user` (

  `id`             BIGINT(20) NOT NULL AUTO_INCREMENT, 
  `username`       VARCHAR(50) NOT NULL,
  `password`       VARCHAR(255) DEFAULT NULL,
  `first_name`     VARCHAR(50) DEFAULT NULL,
  `last_name`      VARCHAR(50) DEFAULT NULL,
  `active`         TINYINT(1) DEFAULT 1,
   

PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
 

INSERT INTO `app_user` 
        (`id`, `username`, `password`, `first_name`, `last_name`)
VALUES 
        (1, 'admin', '$2a$05$KevIcBN8FPAyx4ImSKM2punbEjNDQeWGopkQXCX8fkr2Y1uMaWNRC', 'Glavni', 'Administrator'),
        (2, 'dr_jova', '$2a$04$oJfnkHg7Mqg7aZWXtjy3xO0/wNKyPWcquwsI0.xorERI00CjxZaua', 'Jovan', 'Jovanovic'),
        (3, 'dr_dragana', '$2a$04$ahIdT28SkHXNSiSt/NrrO.Saosx9Y0AOMRK9d.FAl5UMo.kg3wJTi', 'Dragana', 'Jovanovic'),
        (4, 'st_pera', '$2a$04$FVydfmApvLawFPo/a/mphuPOnT4RJQQtTglxKDIY8eebAIwm8BIeO', 'Petar', 'Milovanovic'),
        (5, 'st_una', '$2a$04$QEgZYEmEUYWCg4b3t4R8TOsLMZeqea2sKvG7VVw5DmAIxwSI3KShq', 'Una', 'Stojanovic'),
        (6, 'tester', '$2y$12$geiFbU076Jypl2AKt8QRVOsHGqHkUJnxcQCV1GkecZWJFzV.fy4MS', 'Tes', 'Teric');
