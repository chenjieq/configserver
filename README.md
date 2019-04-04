# configserver
this server need create a database with mysql.Below is sql.
CREATE TABLE `config_server` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
 `akey` varchar(500) DEFAULT NULL COMMENT 'akey',
 `avalue` varchar(500) DEFAULT NULL COMMENT 'akey',
  `application` varchar(50) DEFAULT NULL COMMENT 'application',
  `aprofile` varchar(500) DEFAULT NULL COMMENT 'aprofile',
`label` varchar(500) DEFAULT NULL COMMENT 'label',

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=UTF8MB4;
