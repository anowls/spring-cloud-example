drop table if exists `user`;
CREATE TABLE `user` (
  `id`       VARCHAR(32)  NOT NULL,
  `username` VARCHAR(5)   NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `age`      INT(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

drop table if exists `role`;
CREATE TABLE `role` (
  `id`     BIGINT(20)  NOT NULL AUTO_INCREMENT,
  `name`   VARCHAR(50) NOT NULL,
  `enable` BIT(1)               DEFAULT TRUE,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 12
  DEFAULT CHARSET = utf8;

drop table if exists `user_role`;
CREATE TABLE `user_role` (
  `id`      VARCHAR(32) NOT NULL,
  `user_id` VARCHAR(32) NOT NULL,
  `role_id` BIGINT(20)  NOT NULL,
  PRIMARY KEY (`id`)
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8;