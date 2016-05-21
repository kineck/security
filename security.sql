/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50630
 Source Host           : localhost
 Source Database       : security

 Target Server Type    : MySQL
 Target Server Version : 50630
 File Encoding         : utf-8

 Date: 05/21/2016 11:09:44 AM
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `organize_info`
-- ----------------------------
DROP TABLE IF EXISTS `organize_info`;
CREATE TABLE `organize_info` (
  `organize_uuid` varchar(32) NOT NULL,
  `organize_parent` varchar(32) DEFAULT NULL,
  `organize_code` varchar(64) DEFAULT NULL,
  `organize_name` varchar(32) DEFAULT NULL,
  `organize_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`organize_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `resource_info`
-- ----------------------------
DROP TABLE IF EXISTS `resource_info`;
CREATE TABLE `resource_info` (
  `resource_uuid` varchar(32) NOT NULL,
  `resource_code` varchar(64) DEFAULT NULL,
  `resource_name` varchar(32) DEFAULT NULL,
  `resource_uri` varchar(64) DEFAULT NULL,
  `resource_method` varchar(16) DEFAULT NULL,
  `organize_uuid` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`resource_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `resource_info`
-- ----------------------------
BEGIN;
INSERT INTO `resource_info` VALUES ('2057944eb76e41fda051b3e12c439554', null, null, '/user/user_add', 'ANY', null), ('45c4e6a0ddfe456097f9822ba48e0e27', null, null, '/user/res_list', 'ANY', null), ('6841049540864199a0bfb5e0d6100cad', null, null, '/resource/lists', 'ANY', null), ('94c6734af738475d8a46005441dabe7d', null, null, '/user/user_list', 'ANY', null), ('f09539be34694702b267d6c2baf50f23', null, null, '/system/index', 'ANY', null);
COMMIT;

-- ----------------------------
--  Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `role_uuid` varchar(32) NOT NULL,
  `role_code` varchar(64) DEFAULT NULL,
  `role_name` varchar(32) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `role_info`
-- ----------------------------
BEGIN;
INSERT INTO `role_info` VALUES ('660d61c21c09425485a4696c2a17f2f6', 'ADMIN', '管理员', '管理系统的所有操作,有最高权限,对系统有最大的能力'), ('ef30153234cf4cfab33e3afe6c110203', 'SYSTEM', '机构管理', '管理系统中机构的所有操作,有最高权限,对系统有最大的能力');
COMMIT;

-- ----------------------------
--  Table structure for `role_resource_relations`
-- ----------------------------
DROP TABLE IF EXISTS `role_resource_relations`;
CREATE TABLE `role_resource_relations` (
  `role_uuid` varchar(32) NOT NULL,
  `resource_uuid` varchar(32) NOT NULL,
  `record_uuid` varchar(32) NOT NULL,
  PRIMARY KEY (`record_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `station_info`
-- ----------------------------
DROP TABLE IF EXISTS `station_info`;
CREATE TABLE `station_info` (
  `station_uuid` varchar(32) NOT NULL,
  `station_code` varchar(64) DEFAULT NULL,
  `station_name` varchar(64) DEFAULT NULL,
  `station_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`station_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_uuid` varchar(32) NOT NULL,
  `user_name` varchar(32) NOT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `telphone` varchar(16) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_uuid`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_info`
-- ----------------------------
BEGIN;
INSERT INTO `user_info` VALUES ('0806e5fc90df463894bcc4b546f9abd1', 'admin', '远虑水', 'fe6959f2516e4d31954d3c5c78b6ca54', 'shaoqing.ren@yahoo.com', '13290909900', '010-54369870', 'kineck'), ('b7f04d0d6a744489831c252921d43905', 'system', '系统管理', 'd2d07f09f9d04c92a5d1f3b2698f9a6c', 'shaoqing.ren@yahoo.com', '13290909900', '010-54369870', 'system');
COMMIT;

-- ----------------------------
--  Table structure for `user_organize_relations`
-- ----------------------------
DROP TABLE IF EXISTS `user_organize_relations`;
CREATE TABLE `user_organize_relations` (
  `user_uuid` varchar(32) NOT NULL,
  `organize_uuid` varchar(32) NOT NULL,
  `record_uuid` varchar(32) NOT NULL,
  PRIMARY KEY (`record_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `user_role_relations`
-- ----------------------------
DROP TABLE IF EXISTS `user_role_relations`;
CREATE TABLE `user_role_relations` (
  `user_uuid` varchar(32) NOT NULL,
  `role_uuid` varchar(32) NOT NULL,
  `record_uuid` varchar(32) NOT NULL,
  PRIMARY KEY (`record_uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `user_role_relations`
-- ----------------------------
BEGIN;
INSERT INTO `user_role_relations` VALUES ('b7f04d0d6a744489831c252921d43905', 'ef30153234cf4cfab33e3afe6c110203', '1687267517a84c769b0cbe8a725121b8'), ('b7f04d0d6a744489831c252921d43905', '660d61c21c09425485a4696c2a17f2f6', '197a53c6a43b4c1baa70648af4391279'), ('0806e5fc90df463894bcc4b546f9abd1', '660d61c21c09425485a4696c2a17f2f6', '24155a1ec6144179ba0e06fbd428c134'), ('0806e5fc90df463894bcc4b546f9abd1', 'ef30153234cf4cfab33e3afe6c110203', 'af17b915a69347a19c3e7a5315241b11');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
