DROP TABLE IF EXISTS account;
CREATE TABLE `account` (
  `id` varchar(32) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS role;
CREATE TABLE `role` (
  `id` varchar(32) NOT NULL,
  `name` varchar(50) NOT NULL,
  `enable` bit(1) DEFAULT b'1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS user_role;
CREATE TABLE `user_role` (
  `id` varchar(32) NOT NULL COMMENT '主键 id',
  `user_id` varchar(32) NOT NULL COMMENT '用户 id',
  `role_id` varchar(32) NOT NULL COMMENT '角色 id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
