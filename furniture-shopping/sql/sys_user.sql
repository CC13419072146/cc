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

 Date: 11/08/2023 13:03:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `user_id` bigint(0) NOT NULL AUTO_INCREMENT COMMENT '用户表主键',
  `user_name` varchar(50) NOT NULL COMMENT '用户名',
  `user_no` varchar(50) NOT NULL COMMENT '账号',
  `password` varchar(50) NOT NULL COMMENT '密码',
  `role_type` bigint(0) NOT NULL COMMENT '角色',
  `signature` varchar(255) NULL DEFAULT NULL COMMENT '签名',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (1, '王多鱼', 'root', '9O9Gf38LWWdKw+D2GwTlhA==', 0, '一位心大又豪横的管理员');
INSERT INTO `sys_user` VALUES (3, '里一辆', 'user1', 'k4ntHZmPhGjKOmIAe0lAoQ==', 3, '里一辆是铁，里一辆是刚');
INSERT INTO `sys_user` VALUES (7, '轻奢旗舰店', 'shop1', 'k4ntHZmPhGjKOmIAe0lAoQ==', 1, '当代隐性奢华家具城');
INSERT INTO `sys_user` VALUES (8, '临渊', 'desi1', 'k4ntHZmPhGjKOmIAe0lAoQ==', 2, '一位有伟大抱负，不断提升自己的艺术人');
INSERT INTO `sys_user` VALUES (9, '简约木材城', 'shop2', 'k4ntHZmPhGjKOmIAe0lAoQ==', 1, '大隐隐于市，小隐隐于野');
INSERT INTO `sys_user` VALUES (10, '高端定制屋', 'shop3', 'k4ntHZmPhGjKOmIAe0lAoQ==', 1, '从选材到成品，为您量身打造专属家具');
INSERT INTO `sys_user` VALUES (11, '平价特色坊', 'shop4', 'k4ntHZmPhGjKOmIAe0lAoQ==', 1, '价格亲民实惠，主打一个物美价廉，耐用持久');
INSERT INTO `sys_user` VALUES (12, '西域丝绸阁', 'shop5', 'k4ntHZmPhGjKOmIAe0lAoQ==', 1, '张骞当年出使西域带回的天竺打造工艺，打造属于您的专属雅痞家具');
INSERT INTO `sys_user` VALUES (13, '子安', 'desi2', 'k4ntHZmPhGjKOmIAe0lAoQ==', 2, '对古风痴迷到只为此而活');
INSERT INTO `sys_user` VALUES (14, '扶风', 'desi3', 'k4ntHZmPhGjKOmIAe0lAoQ==', 2, '追求极致简约风格，坚持断舍离的设计师');
INSERT INTO `sys_user` VALUES (15, '白凤', 'desi4', 'k4ntHZmPhGjKOmIAe0lAoQ==', 2, '痴迷于白色的极致设计师，只为设计出极致白的世界');
INSERT INTO `sys_user` VALUES (16, '诗染', 'desi5', 'k4ntHZmPhGjKOmIAe0lAoQ==', 2, '追求新事物，讲究中西方结合的协调美感');
INSERT INTO `sys_user` VALUES (17, '吴天天', 'user2', 'k4ntHZmPhGjKOmIAe0lAoQ==', 3, '这个人很懒，什么都没留下');
INSERT INTO `sys_user` VALUES (18, '白团团', 'user3', 'k4ntHZmPhGjKOmIAe0lAoQ==', 3, '第二大懒人，愿望是永远躺平');
INSERT INTO `sys_user` VALUES (19, '东西西', 'user4', 'k4ntHZmPhGjKOmIAe0lAoQ==', 3, '懒到懒得和谁比更懒，完全懒到裂开');
INSERT INTO `sys_user` VALUES (20, '蓝胖胖', 'user5', 'k4ntHZmPhGjKOmIAe0lAoQ==', 3, '小废柴，有个好朋友叫大熊，他容易被胖虎欺负，他也是未来静香的丈夫');

SET FOREIGN_KEY_CHECKS = 1;
