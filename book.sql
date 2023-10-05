/*
 Navicat Premium Data Transfer

 Source Server         : 电脑本机
 Source Server Type    : MySQL
 Source Server Version : 80034
 Source Host           : localhost:3306
 Source Schema         : book

 Target Server Type    : MySQL
 Target Server Version : 80034
 File Encoding         : 65001

 Date: 05/10/2023 11:16:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `bookinfo`;
CREATE TABLE `bookinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '名称',
  `supplier` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '供应商',
  `producttime` datetime(0) NULL DEFAULT NULL COMMENT '生产日期',
  `warrenty` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '保质期(月)',
  `number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '药品编码',
  `price` float(20, 2) NULL DEFAULT NULL COMMENT '价格',
  `stock` int(0) NULL DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '药品信息' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of bookinfo
-- ----------------------------
INSERT INTO `bookinfo` VALUES (7, 'c++', '清华大学出版社', '2021-10-04 16:00:00', '24', '1004', 13.00, 100);
INSERT INTO `bookinfo` VALUES (8, '计算机网络', '清华大学出版社', '2021-10-04 16:00:00', '24', '1005', 15.00, 100);
INSERT INTO `bookinfo` VALUES (9, '计算机组成原理', '清华大学出版社', '2021-10-04 16:00:00', '24', '1006', 16.00, 100);
INSERT INTO `bookinfo` VALUES (10, 'python程序设计', '清华大学出版社', '2021-10-04 16:00:00', '24', '1007', 17.00, 100);
INSERT INTO `bookinfo` VALUES (11, 'Oracle', '清华大学出版社', '2021-10-04 16:00:00', '24', '1008', 19.00, 100);
INSERT INTO `bookinfo` VALUES (12, 'redis', '清华大学出版社', '2021-10-04 16:00:00', '24', '1009', 22.00, 200);
INSERT INTO `bookinfo` VALUES (13, 'springboot', '清华大学出版社', '2021-10-04 16:00:00', '24', '1010', 100.00, 100);

-- ----------------------------
-- Table structure for owinfo
-- ----------------------------
DROP TABLE IF EXISTS `owinfo`;
CREATE TABLE `owinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '药品名称',
  `type` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '出库/入库',
  `count` int(0) NULL DEFAULT NULL COMMENT '数量',
  `operator` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '操作人',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '出入库' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of owinfo
-- ----------------------------
INSERT INTO `owinfo` VALUES (11, 'python程序设计', '入库', 1, '123', '2021-12-12 11:05:48');
INSERT INTO `owinfo` VALUES (12, '计算机网络', '出库', 1, 'pengjin', '2023-10-05 02:10:20');
INSERT INTO `owinfo` VALUES (13, 'c++', '出库', 1, '123', '2023-10-05 02:11:22');

-- ----------------------------
-- Table structure for saleinfo
-- ----------------------------
DROP TABLE IF EXISTS `saleinfo`;
CREATE TABLE `saleinfo`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `dname` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图书名称',
  `dnumber` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '图书编号',
  `count` int(0) NULL DEFAULT NULL COMMENT '数量',
  `total` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '作者',
  `operator` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '推荐人',
  `operatetime` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '销售记录' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of saleinfo
-- ----------------------------
INSERT INTO `saleinfo` VALUES (26, '张三', '1', 3, '123.0', '李四', '2021-12-07 16:00:00');
INSERT INTO `saleinfo` VALUES (27, 'java基础', '2', 3, '123.0', '王五', '2021-12-11 16:00:00');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '供应商名称',
  `content` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '供应商描述',
  `createtime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '供应商' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES (3, '机械工业出版社', '老牌出版社', '2021-10-04 10:20:30');
INSERT INTO `supplier` VALUES (7, '机械工业出版社', '好的出版社', '2023-10-05 02:29:03');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci COMMENT = '用户表' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
