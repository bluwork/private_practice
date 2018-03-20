DROP TABLE IF EXISTS `app_user`;

CREATE TABLE  `app_user` (

  `id`             BIGINT(20) NOT NULL AUTO_INCREMENT, 
  `username`       VARCHAR(50) NOT NULL,
  `password`       VARCHAR(255) DEFAULT NULL,
  `first_name`     VARCHAR(50) DEFAULT NULL,
  `last_name`      VARCHAR(50) DEFAULT NULL,
  `active`         TINYINT(1) DEFAULT 1,
   

PRIMARY KEY (`id`)

) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 

INSERT INTO `app_user` 
        (`id`, `username`, `password`, `first_name`, `last_name`)
VALUES 
        (1, 'admin', '$2y$10$nUrl76SCUWtdzvBT/olxb.pxYgrbQAFED6iMKZMhrBQ8yp0sZn/5q', 'Glavni', 'Administrator');
