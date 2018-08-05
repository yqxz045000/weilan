/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : sgrr

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-08-26 19:23:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for chatroom
-- ----------------------------
DROP TABLE IF EXISTS `chatroom`;
CREATE TABLE `chatroom` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '聊天室名称',
  `description` varchar(50) DEFAULT NULL COMMENT '描述',
  `acceptance_number` int(11) DEFAULT '200' COMMENT '可容纳人数',
  `in_acceptance_number` int(11) DEFAULT '1' COMMENT '已容纳人数',
  `chatRoom_passw` varchar(32) DEFAULT NULL COMMENT '房间密码，默认为null',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  `auto_delete` varchar(1) DEFAULT '1' COMMENT '默认为1，自动删除，为0则否',
  `status` varchar(1) DEFAULT '1',
  `room_table` varchar(32) NOT NULL COMMENT '表名',
  `create_userId` int(11) NOT NULL COMMENT '创建人id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chatroom
-- ----------------------------
INSERT INTO `chatroom` VALUES ('1', '路过你的全世界', '空聊天室', '200', '5', '', '2017-08-23 16:04:29', '2017-08-26 19:03:30', '0', '1', '1111111000000000', '0');
INSERT INTO `chatroom` VALUES ('2', '测试聊天室名称', '描述', '200', '3', 'E10ADC3949BA59ABBE56E057F20F883E', '2017-08-25 11:47:27', '2017-08-25 12:39:54', '1', '1', '6000000622265653', '1');

-- ----------------------------
-- Table structure for chatroom_user
-- ----------------------------
DROP TABLE IF EXISTS `chatroom_user`;
CREATE TABLE `chatroom_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '用户名称',
  `chatroom_id` int(11) DEFAULT '1' COMMENT '所在聊天室id',
  `create_number` int(11) DEFAULT NULL COMMENT '创建聊天室数量',
  `ip` varchar(20) NOT NULL,
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  KEY `charRoom_id` (`chatroom_id`),
  CONSTRAINT `chatroom_user_ibfk_1` FOREIGN KEY (`chatroom_id`) REFERENCES `chatroom` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chatroom_user
-- ----------------------------
INSERT INTO `chatroom_user` VALUES ('1', '管理员', '1', null, '1', '2017-08-25 11:34:49', '2017-08-25 20:31:40');

-- ----------------------------
-- Table structure for dictionary_item
-- ----------------------------
DROP TABLE IF EXISTS `dictionary_item`;
CREATE TABLE `dictionary_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dictCode` varchar(30) DEFAULT NULL COMMENT '字典编码',
  `dictName` varchar(30) DEFAULT NULL COMMENT '字典名称',
  `itemCode` varchar(30) NOT NULL COMMENT '字典项编码',
  `itemName` varchar(30) NOT NULL COMMENT '字典项名称',
  `itemDescription` varchar(55) DEFAULT NULL COMMENT '字典项描述',
  `status` int(11) DEFAULT '1' COMMENT '状态',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dictionary_item
-- ----------------------------
INSERT INTO `dictionary_item` VALUES ('1', '1000', '心情类型', '1000101', '心情短文', '发表一段心情短文', '1', '2017-08-10 17:43:41', '2017-08-10 17:44:34');
INSERT INTO `dictionary_item` VALUES ('4', '1000', '心情类型', '1000102', '心情文章', '发表一段心情文章', '1', '2017-08-10 17:44:16', '2017-08-10 17:44:36');

-- ----------------------------
-- Table structure for memory_category_num
-- ----------------------------
DROP TABLE IF EXISTS `memory_category_num`;
CREATE TABLE `memory_category_num` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `u_id` int(11) NOT NULL COMMENT '用户id',
  `num` int(11) NOT NULL COMMENT '分类数量',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of memory_category_num
-- ----------------------------
INSERT INTO `memory_category_num` VALUES ('2', '1', '3', '2017-08-09 10:53:28', '2017-08-09 15:00:41');

-- ----------------------------
-- Table structure for system_memory_category
-- ----------------------------
DROP TABLE IF EXISTS `system_memory_category`;
CREATE TABLE `system_memory_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) NOT NULL COMMENT '分类名称',
  `description` varchar(55) DEFAULT NULL COMMENT '分类描述',
  `type` varchar(15) DEFAULT NULL COMMENT '类型',
  `isDelete` int(11) DEFAULT '0' COMMENT '是否启用或是否删除',
  `deleteReason` varchar(55) DEFAULT NULL COMMENT '启用原因或删除原因',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of system_memory_category
-- ----------------------------
INSERT INTO `system_memory_category` VALUES ('1', '为了奋斗而坚强', '为了你年轻时的理想而奋斗，因为奋斗而坚强', null, '0', null, '2017-08-04 16:03:01', '2017-08-04 16:03:05');
INSERT INTO `system_memory_category` VALUES ('2', '躺在床上你也可以梦想人生，因为白日做梦', '躺在床上你也可以梦想人生，因为白日做梦', null, '0', null, '2017-08-04 16:04:00', '2017-08-04 16:17:54');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '帐号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `user_code` varchar(20) NOT NULL COMMENT '用户号',
  `nickname` varchar(20) NOT NULL COMMENT '昵称',
  `sex` int(11) DEFAULT '0' COMMENT '性别',
  `birthday` varchar(25) DEFAULT NULL COMMENT '出生年月',
  `headImg` varchar(50) DEFAULT NULL COMMENT '头像',
  `address` varchar(1) DEFAULT NULL COMMENT '地址',
  `type` varchar(1) DEFAULT NULL COMMENT '类型',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'root', 'root', '123456', '朝花夕拾', '1', null, null, null, null, '2017-08-05 11:06:07', '2017-08-05 11:06:07');
