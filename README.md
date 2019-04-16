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


json data from database:
{
    "success": true,
    "message": "成功！",
    "data": [
        {
            "id": 2796,
            "akey": "spring.datasource.password",
            "avalue": "root",
            "application": "restSpringBoot",
            "aprofile": "pro",
            "label": "suzhou"
        },
        {
            "id": 2797,
            "akey": "spring.jpa.hibernate.ddl-auto",
            "avalue": "update",
            "application": "restSpringBoot",
            "aprofile": "pro",
            "label": "suzhou"
        },
        {
            "id": 2798,
            "akey": "spring.jpa.properties.hibernate.dialect",
            "avalue": "org.hibernate.dialect.MySQL5Dialect",
            "application": "restSpringBoot",
            "aprofile": "pro",
            "label": "suzhou"
        },
        {
            "id": 2799,
            "akey": "city",
            "avalue": "suzhou123",
            "application": "restSpringBoot",
            "aprofile": "pro",
            "label": "suzhou"
        },
        {
            "id": 2800,
            "akey": "spring.datasource.url",
            "avalue": "jdbc:mysql://mysql:3306/springboot",
            "application": "restSpringBoot",
            "aprofile": "pro",
            "label": "suzhou"
        },
        {
            "id": 2801,
            "akey": "spring.datasource.username",
            "avalue": "root",
            "application": "restSpringBoot",
            "aprofile": "pro",
            "label": "suzhou"
        }
    ]
}
