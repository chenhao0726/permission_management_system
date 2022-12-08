/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50525
 Source Host           : localhost:3306
 Source Schema         : permission_system

 Target Server Type    : MySQL
 Target Server Version : 50525
 File Encoding         : 65001

 Date: 06/12/2022 23:16:30
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_department
-- ----------------------------
DROP TABLE IF EXISTS `t_department`;
CREATE TABLE `t_department`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '简介',
  `create_time` datetime NULL DEFAULT NULL,
  `update_time` datetime NULL DEFAULT NULL,
  `manager_id` bigint(20) NULL DEFAULT NULL COMMENT '部门经理对应员工表',
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '上级部门',
  `path` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `state` tinyint(4) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 45 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_department
-- ----------------------------
INSERT INTO `t_department` VALUES (1, '屌丝部-edit', '里面都是屌丝', '2022-08-18 15:24:07', '2022-08-18 14:24:11', 1, NULL, '/1', 1);
INSERT INTO `t_department` VALUES (2, '屌丝部1', '里面都是屌丝', '2022-08-18 15:24:07', '2022-08-18 14:24:11', 1, 1, '/1/2', 1);
INSERT INTO `t_department` VALUES (3, '屌丝部2', '里面都是屌丝', '2022-08-18 15:24:07', '2022-08-18 14:24:11', 1, 1, '/1/3', 1);
INSERT INTO `t_department` VALUES (4, '屌丝部3', '里面都是屌丝', '2022-08-18 15:24:07', '2022-08-18 14:24:11', 1, 1, '/1/4', 1);
INSERT INTO `t_department` VALUES (5, '屌丝部4', '里面都是屌丝', '2022-08-18 15:24:07', '2022-08-18 14:24:11', 1, 1, '/1/5', 1);
INSERT INTO `t_department` VALUES (6, '屌丝部5', '里面都是屌丝', '2022-08-18 15:24:07', '2022-08-18 14:24:11', 1, 1, '/1/6', 1);
INSERT INTO `t_department` VALUES (7, '屌丝部10', '里面都是屌丝', '2022-08-18 15:24:07', '2022-08-18 14:24:11', 1, 1, '/1/7', 1);
INSERT INTO `t_department` VALUES (18, '5', '5', '2022-08-23 11:32:30', '2022-08-23 11:32:30', NULL, NULL, '/18', 1);
INSERT INTO `t_department` VALUES (20, '81', '811', '2022-08-23 11:37:36', '2022-08-23 14:08:59', 1, 2, '/1/2/20', 1);
INSERT INTO `t_department` VALUES (27, '66', '666666666666', '2022-10-19 00:15:47', '2022-10-19 00:19:02', 1, 1, NULL, 1);
INSERT INTO `t_department` VALUES (28, '77', '77', '2022-10-19 00:41:59', NULL, 2, 1, NULL, 1);
INSERT INTO `t_department` VALUES (29, '8', '111111111', '2022-10-19 01:15:22', NULL, 3, 2, NULL, 1);
INSERT INTO `t_department` VALUES (31, '99', '9999999999999999999', '2022-10-19 06:13:17', NULL, 5, NULL, '/31', 1);
INSERT INTO `t_department` VALUES (32, '9-1', '111111111111111111111111111111', '2022-10-19 06:14:08', NULL, 6, 31, '/31/32', 1);
INSERT INTO `t_department` VALUES (33, '9-1-1', '111111111111111111111', '2022-10-19 06:14:54', '2022-10-19 06:23:05', 7, 31, '/31/33', 1);
INSERT INTO `t_department` VALUES (39, '1', '1级部门', '2022-12-03 17:14:53', NULL, 1, NULL, '/39', 1);
INSERT INTO `t_department` VALUES (40, '1-1', '1的二级部门', '2022-12-03 17:15:42', '2022-12-03 17:31:57', 1, 18, '/18/40', 1);
INSERT INTO `t_department` VALUES (41, '1-2', '1111', '2022-12-03 17:32:53', NULL, 1, 39, '/39/41', 1);
INSERT INTO `t_department` VALUES (42, '1-3', '1111', '2022-12-03 17:34:15', NULL, 1, 39, '/39/42', 1);
INSERT INTO `t_department` VALUES (43, '1-4', '1-4', '2022-12-03 17:36:41', NULL, 1, 39, '/39/43', 1);
INSERT INTO `t_department` VALUES (44, '1-5', '1-5', '2022-12-03 17:37:20', NULL, 1, 39, '/39/44', 1);

-- ----------------------------
-- Table structure for t_employee
-- ----------------------------
DROP TABLE IF EXISTS `t_employee`;
CREATE TABLE `t_employee`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `headImage` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `department_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK4AFD4ACE851EFECF`(`department_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 274 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_employee
-- ----------------------------
INSERT INTO `t_employee` VALUES (1, 'admin', '$2a$10$VUct.Y1WQ5XiP.GRZQafN.QDQua2wbRCPX3w/0dpCY4Y3svvSfCSm', 'admin@ronghuanet.com', '/images/head/avatar.png', 34, 1);
INSERT INTO `t_employee` VALUES (2, 'menuAdmin', '123', 'roleAdmin@ronghuanet.com', '/images/head/avatar1.png', 25, 1);
INSERT INTO `t_employee` VALUES (3, 'admin1', '$2a$10$VUct.Y1WQ5XiP.GRZQafN.QDQua2wbRCPX3w/0dpCY4Y3svvSfCSm', 'amdin1@ronghuanet.com', '/images/head/avatar2.png', 25, 1);
INSERT INTO `t_employee` VALUES (4, 'admin2', 'd157d747dc2f6740e81ca9d84b669272', 'amdin2@ronghuanet.com', NULL, 25, 2);
INSERT INTO `t_employee` VALUES (5, 'admin3', '123', 'amdin3@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (6, 'admin4', '12e4dc60e1813184b3e4552dedd7bf9b', 'amdin4@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (7, 'admin5', '02f9b7f759b5654d421c0ce458d16c28', 'amdin5@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (8, 'admin6', '138e943e0987d1fff7a4c367deedd4e3', 'amdin6@ronghuanet.com', '/images/head/avatar3.png', 25, 2);
INSERT INTO `t_employee` VALUES (9, 'admin7', '53bf9cd2cb250a9d82c3260b6d398d73', 'amdin7@ronghuanet.com', NULL, 25, 2);
INSERT INTO `t_employee` VALUES (10, 'admin8', 'f6bd6e8ca007216fef1ddd9652e5d42f', 'amdin8@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (11, 'admin9', 'bc9ee22de9d477a4dc21527fb5288e09', 'amdin9@ronghuanet.com', '/images/head/avatar3.png', 25, 2);
INSERT INTO `t_employee` VALUES (12, 'admin10', '4af867a168f310ac9f542fb27d088412', 'amdin10@ronghuanet.com', '/images/head/avatar3.png', 25, 2);
INSERT INTO `t_employee` VALUES (13, 'admin11', 'c953909c87335d7fbc0f004c850d5899', 'amdin11@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (14, 'admin12', '57c15b685c731241ceb257436da984ce', 'amdin12@ronghuanet.com', '/images/head/avatar3.png', 10, 3);
INSERT INTO `t_employee` VALUES (15, 'admin13', '72b5871658a55870f55c7cedcdbfc750', 'amdin13@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (16, 'admin14', '3aaae1c105814d0e3b6de8f4e7befe3f', 'amdin14@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (17, 'admin15', 'ec466277d5e194ce58b4be14de342e0d', 'amdin15@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (18, 'admin16', '0f49d0f9f47fbdbe311b90b39d071389', 'amdin16@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (19, 'admin17', '684e22f740a05d25f63a16ed9b22bd3a', 'amdin17@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (20, 'admin18', '6b3f18873b8c1fa7948d2eefd236f0b0', 'amdin18@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (21, 'admin19', '6ed03e3efc7f62c780e5a5f05327c2dd', 'amdin19@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (22, 'admin20', 'b19bb9f57188bb9017a5f1e334f6cad4', 'amdin20@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (23, 'admin21', '8d366e02c4373f215e5fae12ef04ecb2', 'amdin21@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (24, 'admin22', '8a27c7cc380d853babd2c04c9d72625f', 'amdin22@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (25, 'admin23', '1a9687e7f1d50e800b2ece459e654408', 'amdin23@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (26, 'admin24', '4f3d03f2d6eaa67ee678cb25ab6f30fd', 'amdin24@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (27, 'admin25', '8309757711ae53bf971ada0eb756fcad', 'amdin25@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (28, 'admin26', '65faa932744343a804d2644d6725c809', 'amdin26@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (29, 'admin27', 'c37e2a159c4104b5efafeb48c4d3f8a8', 'amdin27@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (30, 'admin28', 'b4d8369858ca62b1871f611a17ab6c85', 'amdin28@ronghuanet.com', '/images/head/avatar3.png', 25, 3);
INSERT INTO `t_employee` VALUES (31, 'admin29', '32761f6f732cbd3a9b1395f3d0282361', 'amdin29@ronghuanet.com', '/images/head/avatar3.png', 25, 1);
INSERT INTO `t_employee` VALUES (32, 'admin30', '2bde47bd1a502737c2bf7ef8bca461e7', 'amdin30@ronghuanet.com', '/images/head/avatar3.png', 25, 1);

-- ----------------------------
-- Table structure for t_employee_role
-- ----------------------------
DROP TABLE IF EXISTS `t_employee_role`;
CREATE TABLE `t_employee_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employee_id` bigint(20) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_employee_role
-- ----------------------------
INSERT INTO `t_employee_role` VALUES (1, 1, 1);
INSERT INTO `t_employee_role` VALUES (2, 2, 2);
INSERT INTO `t_employee_role` VALUES (3, 3, 4);

-- ----------------------------
-- Table structure for t_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `icon` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FK24897F76799044`(`parent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES (20, '权限平台', '', 'mdi-palette', 0);
INSERT INTO `t_menu` VALUES (21, '权限管理', '/permission/list', '', 20);
INSERT INTO `t_menu` VALUES (22, '角色管理', '/role/list', '', 20);
INSERT INTO `t_menu` VALUES (23, '菜单管理', '/menu/list', '', 20);
INSERT INTO `t_menu` VALUES (24, '后台首页', '/main/index', 'mdi-home', 0);

-- ----------------------------
-- Table structure for t_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_permission`;
CREATE TABLE `t_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `descs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent_id` bigint(20) NULL DEFAULT NULL COMMENT '父级权限的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1184 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_permission
-- ----------------------------
INSERT INTO `t_permission` VALUES (1171, '权限管理', NULL, '', 'PermissionController', NULL);
INSERT INTO `t_permission` VALUES (1172, '保存权限', '/permission', '', 'PermissionController:save', 1171);
INSERT INTO `t_permission` VALUES (1173, '删除权限', '/permission/{id}', '', 'PermissionController:deleteById', 1171);
INSERT INTO `t_permission` VALUES (1174, '获取所有权限', '/permission', '', 'PermissionController:findAll', 1171);
INSERT INTO `t_permission` VALUES (1175, '获取权限详情', '/permission/{id}', '', 'PermissionController:getById', 1171);
INSERT INTO `t_permission` VALUES (1176, '分页查询', '/permission', '权限分页查询', 'PermissionController:listPage', 1171);
INSERT INTO `t_permission` VALUES (1177, '获取权限树', '/permission/tree', '', 'PermissionController:getPermissionTree', 1171);
INSERT INTO `t_permission` VALUES (1178, '角色管理', NULL, '', 'RoleController', NULL);
INSERT INTO `t_permission` VALUES (1179, '角色列表', '/role/list', '', 'RoleController:index', 1178);
INSERT INTO `t_permission` VALUES (1180, '删除单条', '/role/{id}', '', 'RoleController:deleteById', 1178);
INSERT INTO `t_permission` VALUES (1181, '分页查询', '/role', '', 'RoleController:listPage', 1178);
INSERT INTO `t_permission` VALUES (1182, '角色权限分配', '/role/permission', '', 'RoleController:rolePermission', 1178);
INSERT INTO `t_permission` VALUES (1183, '批量删除', '/role', '', 'RoleController:batchDelete', 1178);

-- ----------------------------
-- Table structure for t_role
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES (1, '管理员', 'roleAdmin');
INSERT INTO `t_role` VALUES (2, '角色管理员', 'guest');
INSERT INTO `t_role` VALUES (5, '5', '5');
INSERT INTO `t_role` VALUES (6, '6', '6');
INSERT INTO `t_role` VALUES (9, '超级管理员', 'adminxxxxx');
INSERT INTO `t_role` VALUES (11, '111', '1111');
INSERT INTO `t_role` VALUES (12, '333', '333');

-- ----------------------------
-- Table structure for t_role_menu
-- ----------------------------
DROP TABLE IF EXISTS `t_role_menu`;
CREATE TABLE `t_role_menu`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NULL DEFAULT NULL,
  `menu_id` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `role_id`(`role_id`) USING BTREE,
  INDEX `menu_id`(`menu_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role_menu
-- ----------------------------
INSERT INTO `t_role_menu` VALUES (1, 1, 20);
INSERT INTO `t_role_menu` VALUES (2, 1, 21);
INSERT INTO `t_role_menu` VALUES (3, 1, 22);
INSERT INTO `t_role_menu` VALUES (4, 1, 23);
INSERT INTO `t_role_menu` VALUES (5, 2, 20);
INSERT INTO `t_role_menu` VALUES (6, 2, 21);
INSERT INTO `t_role_menu` VALUES (7, 1, 24);
INSERT INTO `t_role_menu` VALUES (8, 2, 24);

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `role_id` bigint(20) NOT NULL,
  `permission_id` bigint(20) NULL DEFAULT NULL,
  `permission_sn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '权限的唯一标识',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `FKAEE599B74D26E00F`(`role_id`) USING BTREE,
  INDEX `FKAEE599B7C854068F`(`permission_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 114 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES (93, 1, NULL, 'MenuController:Manager');
INSERT INTO `t_role_permission` VALUES (94, 1, NULL, 'MenuController:index');
INSERT INTO `t_role_permission` VALUES (95, 1, NULL, 'MenuController:queryTopMenus');
INSERT INTO `t_role_permission` VALUES (96, 1, NULL, 'MenuController:queryPage');
INSERT INTO `t_role_permission` VALUES (97, 1, NULL, 'MenuController:addOrUpdate');
INSERT INTO `t_role_permission` VALUES (98, 1, NULL, 'PermissionController:Manager');
INSERT INTO `t_role_permission` VALUES (99, 1, NULL, 'PermissionController:index');
INSERT INTO `t_role_permission` VALUES (100, 1, NULL, 'PermissionController:getAll');
INSERT INTO `t_role_permission` VALUES (101, 1, NULL, 'PermissionController:queryPermissionTree');
INSERT INTO `t_role_permission` VALUES (102, 1, NULL, 'PermissionController:addOrUpdate');
INSERT INTO `t_role_permission` VALUES (103, 1, NULL, 'PermissionController:getById');
INSERT INTO `t_role_permission` VALUES (104, 1, NULL, 'PermissionController:page');
INSERT INTO `t_role_permission` VALUES (105, 1, NULL, 'RoleController:Manager');
INSERT INTO `t_role_permission` VALUES (106, 1, NULL, 'RoleController:index');
INSERT INTO `t_role_permission` VALUES (107, 1, NULL, 'RoleController:delete');
INSERT INTO `t_role_permission` VALUES (108, 1, NULL, 'RoleController:queryPage');
INSERT INTO `t_role_permission` VALUES (109, 1, NULL, 'RoleController:addOrUpdate');
INSERT INTO `t_role_permission` VALUES (110, 1, NULL, 'RoleController:getById');
INSERT INTO `t_role_permission` VALUES (111, 1, NULL, 'RoleController:rolePermindex');
INSERT INTO `t_role_permission` VALUES (112, 1, NULL, 'RoleController:authorize');
INSERT INTO `t_role_permission` VALUES (113, 1, NULL, 'RoleController:getRoleAndPermissionSnsByRoleId');

SET FOREIGN_KEY_CHECKS = 1;
