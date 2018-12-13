DROP TABLE IF EXISTS `city`;

CREATE TABLE `city` (
    `zip_code`  BIGINT(20) NOT NULL UNIQUE,
    `name`      VARCHAR(255) NOT NULL,

PRIMARY KEY (`zip_code`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `city`
         (`zip_code`, `name`)
VALUES
         (11000, 'Beograd'),
         (14000, 'Valjevo'),
         (15000, 'Sabac'),
         (18000, 'Nis'),
         (21000, 'Novi Sad'),
         (34000, 'Kragujevac'),
         (35000, 'Jagodina'),
         (36000, 'Kraljevo'),
         (37000, 'Krusevac');