/*
Navicat MySQL Data Transfer

Source Server         : 68
Source Server Version : 50173
Source Host           : 210.47.163.68:3306
Source Database       : brrowsystem

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Date: 2018-04-27 21:58:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for applytable
-- ----------------------------
DROP TABLE IF EXISTS `applytable`;
CREATE TABLE `applytable` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` varchar(7) NOT NULL,
  `user_time` date NOT NULL,
  `username` varchar(7) NOT NULL,
  `period` varchar(2) NOT NULL,
  `type` varchar(8) NOT NULL,
  `email` varchar(20) NOT NULL,
  `my_describe` varchar(200) DEFAULT NULL,
  `operatetime` timestamp NULL DEFAULT '0000-00-00 00:00:00',
  `account` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applytable
-- ----------------------------
INSERT INTO `applytable` VALUES ('2', '2', '2017-12-13', '李希', '2', '上课', '1937915896@qq.com', null, '0000-00-00 00:00:00', '195140040');
INSERT INTO `applytable` VALUES ('5', '1', '2017-12-12', '周梦凯', '1', '录用', '1149089199@qq.com', '斯蒂芬', '2017-12-06 15:19:13', '195140040');
INSERT INTO `applytable` VALUES ('6', '2', '2017-12-11', '龙哥', '3', '会议', '1937915896@qq.com', '还不成？？', '2017-12-07 16:53:23', '195140040');
INSERT INTO `applytable` VALUES ('7', '1', '2017-12-08', '苏国启', '1', '录用', '12983179040', '测试', '2017-12-07 23:19:14', '2016191007');
INSERT INTO `applytable` VALUES ('8', '1', '2017-12-10', '陈柯', '1', '录用', '2320138196@qq.com', '', '2017-12-08 08:40:10', '2016101208');

-- ----------------------------
-- Table structure for brrowrecord_table
-- ----------------------------
DROP TABLE IF EXISTS `brrowrecord_table`;
CREATE TABLE `brrowrecord_table` (
  `record_id` varchar(30) NOT NULL DEFAULT '',
  `class_id` varchar(7) NOT NULL DEFAULT '',
  `user_time` date NOT NULL DEFAULT '0000-00-00',
  `username` varchar(20) NOT NULL DEFAULT '',
  `period` varchar(2) NOT NULL DEFAULT '',
  `usetype` varchar(8) NOT NULL DEFAULT '',
  `describe_info` varchar(200) DEFAULT NULL,
  `delete_mark` char(1) NOT NULL DEFAULT '' COMMENT '0为存在记录，1为删除记录',
  `operatetime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '记录操作时间用',
  PRIMARY KEY (`record_id`),
  KEY `FK_Reference_1` (`class_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`class_id`) REFERENCES `classes_table` (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of brrowrecord_table
-- ----------------------------
INSERT INTO `brrowrecord_table` VALUES ('0ac245e5-fff3-49d7-9', '1', '2017-11-08', '升天', '4', '录用', '速度', '0', '2017-11-07 14:48:29');
INSERT INTO `brrowrecord_table` VALUES ('0e63764c-f970-4238-a', '1', '2017-12-10', '陈柯', '1', '录用', '', '0', '2017-12-08 08:41:28');
INSERT INTO `brrowrecord_table` VALUES ('12', '2', '2017-11-29', '李峰', '3', '会议', '开会使用', '0', '2017-11-06 10:31:51');
INSERT INTO `brrowrecord_table` VALUES ('123', '1', '2017-11-09', 'dsadasdsadsa', '2', '录用', '发给', '0', '2017-11-07 15:07:56');
INSERT INTO `brrowrecord_table` VALUES ('15b752bc-f934-4245-9', '1', '2017-11-10', 'aaaaa', '1', '录用', 'asd', '0', '2017-11-07 16:50:13');
INSERT INTO `brrowrecord_table` VALUES ('3174f323-158d-448d-b', '1', '2017-11-08', '就是打开解放', '1', '录用', '降幅达斯科拉积分', '0', '2017-11-06 22:18:23');
INSERT INTO `brrowrecord_table` VALUES ('345', '2', '2017-11-12', '天', '1', '录用', '哈哈', '1', '0000-00-00 00:00:00');
INSERT INTO `brrowrecord_table` VALUES ('64c177a2-2087-4b59-9', '1', '2017-12-08', '周梦凯', '3', '会议', '诗圣杜甫', '0', '2017-11-07 15:02:03');
INSERT INTO `brrowrecord_table` VALUES ('7e1e2578-1b9f-48fb-a', '1', '2017-11-05', '凯哥', '4', '天气挺好', '开会', '0', '2017-11-06 10:31:51');
INSERT INTO `brrowrecord_table` VALUES ('cf2d4a35-00bd-4a61-8', '2', '2017-12-14', '凯哥', '4', '会议', '完成了', '0', '2017-12-07 16:48:28');

-- ----------------------------
-- Table structure for classes_table
-- ----------------------------
DROP TABLE IF EXISTS `classes_table`;
CREATE TABLE `classes_table` (
  `class_id` varchar(7) NOT NULL DEFAULT '',
  `class_name` varchar(7) NOT NULL DEFAULT '',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of classes_table
-- ----------------------------
INSERT INTO `classes_table` VALUES ('1', '北区315');
INSERT INTO `classes_table` VALUES ('2', '北区513');
