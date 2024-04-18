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

 Date: 18/04/2024 22:37:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auto_test_case
-- ----------------------------
DROP TABLE IF EXISTS `auto_test_case`;
CREATE TABLE `auto_test_case`  (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用例名称',
  `code` varchar(64) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用例编码',
  `service_id` int NULL DEFAULT NULL COMMENT '服务名称',
  `desc` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '用例描述',
  `case_status` int NULL DEFAULT NULL COMMENT '用例状态',
  `check_point_config` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '校验点配置',
  `result_collect_config` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '结果集采集',
  `param_value` text CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL COMMENT '请求参数',
  `modifier` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '修改人',
  `creator` varchar(128) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL COMMENT '创建人',
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `un_idx_code`(`code` ASC) USING BTREE,
  UNIQUE INDEX `un_idx_name`(`name` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
