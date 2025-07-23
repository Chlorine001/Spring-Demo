/*
 Navicat Premium Data Transfer

 Source Server         : CHLORINE
 Source Server Type    : MySQL
 Source Server Version : 80025 (8.0.25)
 Source Host           : localhost:3306
 Source Schema         : springtest

 Target Server Type    : MySQL
 Target Server Version : 80025 (8.0.25)
 File Encoding         : 65001

 Date: 23/07/2025 16:45:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `number` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `description` varchar(192) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_disabled` tinyint NOT NULL,
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '周杰伦', '26', 'zjl123456@qq.com', 0, '2025-07-23 15:03:59', NULL, 0, NULL, '2025-07-23 15:05:42', 0);
INSERT INTO `user` VALUES (2, '杨宗纬', '44', 'yzw123456@qq.com', 0, '2025-07-23 15:04:54', NULL, 0, NULL, '2025-07-23 15:04:54', 0);

SET FOREIGN_KEY_CHECKS = 1;
