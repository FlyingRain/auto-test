/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80036 (8.0.36)
 Source Host           : localhost:3306
 Source Schema         : auto_test

 Target Server Type    : MySQL
 Target Server Version : 80036 (8.0.36)
 File Encoding         : 65001

 Date: 05/03/2024 18:45:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auto_test_case_scene
-- ----------------------------
DROP TABLE IF EXISTS `auto_test_case_scene`;
CREATE TABLE `auto_test_case_scene`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `scene_id` int NULL DEFAULT NULL COMMENT '场景id',
  `case_id` int NULL DEFAULT NULL COMMENT '用例id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
