/*
 Navicat Premium Data Transfer

 Source Server         : xaxb_v0.9
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost
 Source Database       : online

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : utf-8

 Date: 12/12/2017 15:00:02 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `x_admin`
-- ----------------------------
DROP TABLE IF EXISTS `x_admin`;
CREATE TABLE `x_admin` (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(18) NOT NULL,
  `admin_passwd` varchar(100) NOT NULL,
  `admin_phone_number` char(64) NOT NULL,
  `admin_idcard` char(128) NOT NULL,
  `admin_flag` int(8) NOT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `x_admin`
-- ----------------------------
BEGIN;
INSERT INTO `x_admin` VALUES ('1', 'jeq', '123123', '18332536666', '1305331990837493849', '0');
COMMIT;

-- ----------------------------
--  Table structure for `x_email`
-- ----------------------------
DROP TABLE IF EXISTS `x_email`;
CREATE TABLE `x_email` (
  `email_id` int(8) NOT NULL AUTO_INCREMENT,
  `email_rank` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `email_name` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `email_phone` varchar(16) CHARACTER SET utf8 DEFAULT NULL,
  `email_str` varchar(32) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`email_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `x_email`
-- ----------------------------
BEGIN;
INSERT INTO `x_email` VALUES ('1', '市区', '翟亚楠', '183****0065', '782364397@qq.com'), ('2', '市区', '贾恩秋', '183****7474', 'jiaenqiu@163.com'), ('3', '县区', '里斯', '183****5465', '804132063@qq.com'), ('4', '梨园屯', '姜新淼', '153****2150', 'jxmiao926@163.com');
COMMIT;

-- ----------------------------
--  Table structure for `x_user`
-- ----------------------------
DROP TABLE IF EXISTS `x_user`;
CREATE TABLE `x_user` (
  `user_id` int(8) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(16) NOT NULL,
  `user_phone` char(11) NOT NULL,
  `user_pwd` varchar(32) DEFAULT '',
  `user_id_card` char(18) NOT NULL,
  `user_content` text,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `x_user`
-- ----------------------------
BEGIN;
INSERT INTO `x_user` VALUES ('1', 'jeq', '18332537474', null, '130544199009233842', 'abcdefghijklmnopqrstuvwxyz');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
