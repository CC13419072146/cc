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

 Date: 11/08/2023 12:58:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for desi_pro
-- ----------------------------
DROP TABLE IF EXISTS `desi_pro`;
CREATE TABLE `desi_pro`  (
  `desi_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '设计师方案',
  `desi_url` varchar(500) NOT NULL COMMENT '方案图',
  `desi_title` varchar(50) NOT NULL COMMENT '方案标题',
  `desi_desc` varchar(255) NOT NULL COMMENT '方案描述',
  `user_no` varchar(50) NOT NULL COMMENT '设计师账号',
  PRIMARY KEY (`desi_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4;

-- ----------------------------
-- Records of desi_pro
-- ----------------------------
INSERT INTO `desi_pro` VALUES (1, 'https://img1.baidu.com/it/u=2274788698,1262022827&fm=253&fmt=auto&app=138&f=JPEG?w=531&h=500', '最新人工学椅子', '采用德国类人集团最新研发成果，长期使用不仅能活血化瘀，亦能开阔身心', 'desi1');
INSERT INTO `desi_pro` VALUES (2, 'https://img0.baidu.com/it/u=3623961695,2650345237&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=313', '手绘概念沙发设计', '借鉴文艺复兴思想绘制而成', 'desi1');

SET FOREIGN_KEY_CHECKS = 1;
