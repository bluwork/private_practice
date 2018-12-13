DROP TABLE IF EXISTS `diagnosis`;

CREATE TABLE `diagnosis` (
    `code`      VARCHAR(20) NOT NULL UNIQUE,
    `name`      VARCHAR(255) NOT NULL,

PRIMARY KEY (`code`)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `diagnosis`
         (`code`, `name`)
VALUES
         ('10-aa-000', 'Upala grla'),
         ('10-ab-001', 'Prehlada'),
         ('10-ac-002', 'Virusna infekcija uva'),
         ('10-ad-003', 'Konjuktivitis'),
         ('10-ae-004', 'Iscasenje rucnog zgloba'),
         ('10-af-005', 'Ukljesten nerv');
