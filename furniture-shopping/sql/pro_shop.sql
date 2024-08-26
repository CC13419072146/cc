/*
 Navicat Premium Data Transfer

 Source Server         : localhost-practice
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:5001
 Source Schema         : furniture_shopping

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 11/08/2023 12:59:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for pro_shop
-- ----------------------------
DROP TABLE IF EXISTS `pro_shop`;
CREATE TABLE `pro_shop`  (
  `pro_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '商品表主键',
  `pro_no` varchar(255) NOT NULL COMMENT '商品编号',
  `pro_name` varchar(50) NOT NULL COMMENT '商品名',
  `unit_price` decimal(10, 2) NOT NULL COMMENT '单价',
  `pro_desc` varchar(255) NOT NULL COMMENT '商品描述',
  `pro_url` varchar(500) NOT NULL COMMENT '商品图',
  `user_no` varchar(50) NOT NULL COMMENT '所属店铺',
  `inventory` bigint(0) NOT NULL COMMENT '库存',
  PRIMARY KEY (`pro_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pro_shop
-- ----------------------------
INSERT INTO `pro_shop` VALUES (2, 'e5152b15-31ef-4985-8bdd-e8a5691f348f', '资深大理石桌子', 998.00, '超级耐看且耐用的大理石桌子', 'https://img2.baidu.com/it/u=2894363945,831351535&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=666', 'shop1', 98);
INSERT INTO `pro_shop` VALUES (3, 'sad2h-sad88-mv7', '蓝博湾重金设计打造', 889.00, '超级好看，高级感点满', 'https://img1.baidu.com/it/u=3305144007,2305186064&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', 'shop1', 90);
INSERT INTO `pro_shop` VALUES (4, 'ksansa9-sakfsnd8-je8h47fsg6', '居有会良心良心家具', 650.00, '宝宝，孕妇专用，舒适柔软，极具亲和力', 'https://img1.baidu.com/it/u=2631724342,843333302&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', 'shop1', 80);
INSERT INTO `pro_shop` VALUES (5, 'sad-ksafa9-67g65-asdhw0', '宜家伊娃内阁设计', 440.00, '家用商用都妥妥的上气质', 'https://img0.baidu.com/it/u=1302112766,2488913521&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=500', 'shop1', 50);
INSERT INTO `pro_shop` VALUES (6, 'dsad0-fasasd0fsa--asfkmj97hfw8-afs', '黄花梨月洞门仿古床', 1600.00, '闺房专用，送礼装修老一辈一眼拿下', 'https://img0.baidu.com/it/u=428757554,4085175470&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=771', 'shop1', 22);

SET FOREIGN_KEY_CHECKS = 1;
