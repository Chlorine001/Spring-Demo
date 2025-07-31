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

 Date: 31/07/2025 16:17:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for fq_login_users
-- ----------------------------
DROP TABLE IF EXISTS `fq_login_users`;
CREATE TABLE `fq_login_users`  (
  `id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  `platform` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第三方平台名称',
  `open_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第三方平台的用户ID',
  `access_token` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '访问令牌（密码）',
  `status` int NOT NULL,
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of fq_login_users
-- ----------------------------

-- ----------------------------
-- Table structure for rel_group_role
-- ----------------------------
DROP TABLE IF EXISTS `rel_group_role`;
CREATE TABLE `rel_group_role`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `gid` bigint NOT NULL,
  `rid` bigint NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_disabled` tinyint NOT NULL,
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rel_group_role
-- ----------------------------

-- ----------------------------
-- Table structure for rel_role_perm
-- ----------------------------
DROP TABLE IF EXISTS `rel_role_perm`;
CREATE TABLE `rel_role_perm`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `rid` bigint NOT NULL,
  `pid` bigint NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_disabled` tinyint NOT NULL,
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rel_role_perm
-- ----------------------------

-- ----------------------------
-- Table structure for rel_user_group
-- ----------------------------
DROP TABLE IF EXISTS `rel_user_group`;
CREATE TABLE `rel_user_group`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uid` bigint NOT NULL,
  `gid` bigint NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_disabled` tinyint NOT NULL,
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rel_user_group
-- ----------------------------

-- ----------------------------
-- Table structure for rel_user_role
-- ----------------------------
DROP TABLE IF EXISTS `rel_user_role`;
CREATE TABLE `rel_user_role`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `uid` bigint NOT NULL,
  `rid` bigint NOT NULL,
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_disabled` tinyint NOT NULL,
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of rel_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for sys_groups
-- ----------------------------
DROP TABLE IF EXISTS `sys_groups`;
CREATE TABLE `sys_groups`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_disabled` tinyint NOT NULL,
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_groups
-- ----------------------------

-- ----------------------------
-- Table structure for sys_perms
-- ----------------------------
DROP TABLE IF EXISTS `sys_perms`;
CREATE TABLE `sys_perms`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `operation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_disabled` tinyint NOT NULL,
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_perms
-- ----------------------------

-- ----------------------------
-- Table structure for sys_roles
-- ----------------------------
DROP TABLE IF EXISTS `sys_roles`;
CREATE TABLE `sys_roles`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_disabled` tinyint NOT NULL,
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_roles
-- ----------------------------

-- ----------------------------
-- Table structure for sys_users
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `age` tinyint UNSIGNED NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
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
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES (1, '周杰伦', 'jay', 26, '15386885719', 'zjl123456@qq.com', '123456', '周杰伦', 0, '2025-07-23 15:03:59', NULL, 0, NULL, '2025-07-23 15:05:42', 0);
INSERT INTO `sys_users` VALUES (2, '杨宗纬', 'yzw', 44, '15727352903', 'yzw123456@qq.com', '123456', '', 0, '2025-07-23 15:04:54', NULL, 0, NULL, '2025-07-23 15:04:54', 0);

-- ----------------------------
-- Table structure for test_template
-- ----------------------------
DROP TABLE IF EXISTS `test_template`;
CREATE TABLE `test_template`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `is_deleted` tinyint NOT NULL,
  `create_time` datetime NOT NULL,
  `update_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_disabled` tinyint NOT NULL,
  `create_by` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `version` int NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of test_template
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
