/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.7.36 : Database - book
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`book` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `book`;


DROP TABLE IF EXISTS `bookinfo`;

CREATE TABLE `bookinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '图书名称',
  `supplier` varchar(255) DEFAULT NULL COMMENT '出版社',
  `producttime` datetime DEFAULT NULL COMMENT '出版日期',
  `warrenty` varchar(255) DEFAULT NULL COMMENT '作者',
  `number` varchar(255) DEFAULT NULL COMMENT '图书编码',
  `price` float(20,2) DEFAULT NULL COMMENT '图书价格',
  `stock` int(11) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='图书信息';


insert  into `bookinfo`(`id`,`name`,`supplier`,`producttime`,`warrenty`,`number`,`price`,`stock`) values (6,'数据库','机械出版社','2021-10-04 16:00:00','24','1003',11.50,100),(7,'c++','清华大学出版社','2021-10-04 16:00:00','24','1004',13.00,100),(8,'计算机网络','清华大学出版社','2021-10-04 16:00:00','24','1005',15.00,100),(9,'计算机组成原理','清华大学出版社','2021-10-04 16:00:00','24','1006',16.00,100),(10,'python程序设计','清华大学出版社','2021-10-04 16:00:00','24','1007',17.00,100),(11,'Oracle','清华大学出版社','2021-10-04 16:00:00','24','1008',19.00,100),(12,'redis','清华大学出版社','2021-10-04 16:00:00','24','1009',22.00,200),(13,'springboot','清华大学出版社','2021-10-04 16:00:00','24','1010',100.00,100);


DROP TABLE IF EXISTS `owinfo`;

CREATE TABLE `owinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) DEFAULT NULL COMMENT '药品名称',
  `type` varchar(255) DEFAULT NULL COMMENT '出库/入库',
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人',
  `createtime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='出入库';

/*Data for the table `owinfo` */

insert  into `owinfo`(`id`,`dname`,`type`,`count`,`operator`,`createtime`) values (7,'数据库','出库',1,'张三','2021-12-07 18:33:41'),(8,'springMVC','出库',1,'李四','2021-12-07 18:47:57'),(9,'计算机组成原理','出库',1,'王五','2021-12-11 11:32:35'),(10,'数据库','出库',1,'1','2021-12-12 06:08:32'),(11,'python程序设计','入库',1,'123','2021-12-12 11:05:48');

/*Table structure for table `saleinfo` */

DROP TABLE IF EXISTS `saleinfo`;

CREATE TABLE `saleinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) DEFAULT NULL COMMENT '图书名称',
  `dnumber` varchar(255) DEFAULT NULL COMMENT '图书编号',
  `count` int(11) DEFAULT NULL COMMENT '数量',
  `total` varchar(255) DEFAULT NULL COMMENT '作者',
  `operator` varchar(255) DEFAULT NULL COMMENT '推荐人',
  `operatetime` datetime DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='销售记录';

/*Data for the table `saleinfo` */

insert  into `saleinfo`(`id`,`dname`,`dnumber`,`count`,`total`,`operator`,`operatetime`) values (25,'算法','1',21,'123','张三','2021-12-06 16:00:00'),(26,'张三','1',3,'123.0','李四','2021-12-07 16:00:00'),(27,'java基础','2',3,'123.0','王五','2021-12-11 16:00:00');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `content` varchar(1000) DEFAULT NULL COMMENT '供应商描述',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='供应商';

/*Data for the table `supplier` */

insert  into `supplier`(`id`,`name`,`content`,`createtime`) values (1,'清华大学出版社','清华大学出版的很多优秀的教材','2021-10-11 16:18:07'),(3,'机械工业出版社','老牌出版社','2021-10-04 10:20:30');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户表';

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`) values (1,'admin','admin'),(2,'123','123');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
