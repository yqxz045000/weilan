/*
Navicat MySQL Data Transfer

Source Server         : 自己的数据库，别打错了啊
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : weilandb

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2018-05-19 13:42:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_annoyancewall
-- ----------------------------
DROP TABLE IF EXISTS `tb_annoyancewall`;
CREATE TABLE `tb_annoyancewall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) DEFAULT NULL,
  `msg` varchar(100) NOT NULL,
  `nickName` varchar(20) DEFAULT '',
  `ip` varchar(20) NOT NULL,
  `type` varchar(1) NOT NULL,
  `status` varchar(1) DEFAULT '1',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_annoyancewall
-- ----------------------------

-- ----------------------------
-- Table structure for tb_category
-- ----------------------------
DROP TABLE IF EXISTS `tb_category`;
CREATE TABLE `tb_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(255) DEFAULT '',
  `status` varchar(1) DEFAULT '1',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `tb_category_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_useraccount` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_category
-- ----------------------------
INSERT INTO `tb_category` VALUES ('1', '1', '自由', '自由飞翔', '1', '2017-12-08 09:58:44', '2017-12-23 11:07:24');
INSERT INTO `tb_category` VALUES ('2', '1', '路由你', '路由你', '1', '2017-12-23 11:07:48', '2017-12-23 11:07:48');
INSERT INTO `tb_category` VALUES ('3', '1', 'apple', 'apple改变世界', '1', '2017-12-23 11:08:07', '2017-12-23 11:08:07');
INSERT INTO `tb_category` VALUES ('5', '1', '&#x4e0a;&#x6d77;&#x4eca;&#x5929;&#x597d;&#x51b7;', '&#x4e0a;&#x6d77;&#x4eca;&#x5929;&#x597d;&#x51b7;&#x5440;', '1', '2018-01-14 12:30:56', '2018-01-14 12:30:56');

-- ----------------------------
-- Table structure for tb_feedback
-- ----------------------------
DROP TABLE IF EXISTS `tb_feedback`;
CREATE TABLE `tb_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `msg` varchar(100) NOT NULL,
  `replyMsg` varchar(50) DEFAULT '',
  `type` varchar(2) NOT NULL,
  `status` varchar(1) DEFAULT '0',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  CONSTRAINT `tb_feedback_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_useraccount` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_feedback
-- ----------------------------

-- ----------------------------
-- Table structure for tb_longmessage
-- ----------------------------
DROP TABLE IF EXISTS `tb_longmessage`;
CREATE TABLE `tb_longmessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `title` varchar(30) NOT NULL,
  `contentId` int(11) DEFAULT NULL,
  `resume` varchar(100) NOT NULL,
  `bgImg` varchar(100) DEFAULT '',
  `status` varchar(1) DEFAULT '1',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `categoryId` (`categoryId`),
  KEY `contentId` (`contentId`),
  CONSTRAINT `tb_longMessage_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_useraccount` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_longMessage_ibfk_2` FOREIGN KEY (`categoryId`) REFERENCES `tb_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_longMessage_ibfk_3` FOREIGN KEY (`contentId`) REFERENCES `tb_longmessagecontent` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_longmessage
-- ----------------------------
INSERT INTO `tb_longmessage` VALUES ('7', '1', '1', 'title111', '10', 'title111', 'bgImg111', '1', '2017-12-08 14:27:22', '2017-12-08 14:27:22');

-- ----------------------------
-- Table structure for tb_longmessagecontent
-- ----------------------------
DROP TABLE IF EXISTS `tb_longmessagecontent`;
CREATE TABLE `tb_longmessagecontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(6000) DEFAULT '',
  `userId` int(11) NOT NULL,
  `modifyTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_longmessagecontent
-- ----------------------------
INSERT INTO `tb_longmessagecontent` VALUES ('10', 'content1111', '1', '2017-12-08 14:27:22');

-- ----------------------------
-- Table structure for tb_shortmessage
-- ----------------------------
DROP TABLE IF EXISTS `tb_shortmessage`;
CREATE TABLE `tb_shortmessage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userId` int(11) NOT NULL,
  `categoryId` int(11) NOT NULL,
  `essayId` int(11) DEFAULT NULL,
  `content` varchar(200) DEFAULT '',
  `type` varchar(5) DEFAULT NULL,
  `status` varchar(1) DEFAULT '1',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `userId` (`userId`),
  KEY `essayId` (`essayId`),
  KEY `categoryId` (`categoryId`),
  CONSTRAINT `tb_shortMessage_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `tb_useraccount` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_shortMessage_ibfk_2` FOREIGN KEY (`essayId`) REFERENCES `tb_longmessage` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `tb_shortMessage_ibfk_3` FOREIGN KEY (`categoryId`) REFERENCES `tb_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_shortmessage
-- ----------------------------
INSERT INTO `tb_shortmessage` VALUES ('3', '1', '1', null, '　有这样一些女人，她们喜欢书。买书、读书、写书，书是她们经久耐用的时装和化妆品。普通的衣着，素面朝天，走在花团簇锦浓妆艳抹的女人中间，反而格外引人注目。是气质，是修养，是浑身流溢的书卷味，使她们显得与众不同。“腹有诗书气自华”，这句名言对她们是再合适不过了。', 'M', '1', '2017-12-08 10:51:49', '2017-12-16 19:04:21');
INSERT INTO `tb_shortmessage` VALUES ('4', '1', '1', null, '因为爱读书的女人，她不管走到那里都是一道美丽的风景。她可能貌不惊人，但她有一种内在的气质：幽雅的谈吐超凡脱俗，清丽的仪态无需修饰，那是静的凝重，动的优雅；那是坐的端庄，行的洒脱；那是天然的质朴与含蓄混合，像水一样的柔软，像风一样的迷人，像花一样的绚丽……', 'M', '1', '2017-12-08 10:51:49', '2017-12-16 19:04:29');
INSERT INTO `tb_shortmessage` VALUES ('5', '1', '1', null, '对于书，不同的女人会有不同的品味，不同的品味会有不同的选择，不同的选择得到不同的效果，因而演绎出一道女人与书的风景线。', 'M', '1', '2017-12-08 10:51:49', '2017-12-16 19:04:38');
INSERT INTO `tb_shortmessage` VALUES ('6', '1', '1', null, '有的女人，读书是为了获取知识，增长才干，她们比较注重思想性强、有哲理、有深度的书。书提高了她们的人生境界，使她们生活得很充实。这样的女人本身就是一本书，一本耐人寻味的好书。', 'M', '1', '2017-12-08 10:51:49', '2017-12-16 19:04:40');
INSERT INTO `tb_shortmessage` VALUES ('15', '1', '2', null, '&#x8def;&#x5728;&#x811a;&#x4e0b;&#xff0c;&#x884c;&#x5728;&#x5fc3;&#x4e2d;', 'M', '1', '2017-12-23 12:04:40', '2017-12-23 12:04:40');
INSERT INTO `tb_shortmessage` VALUES ('25', '1', '3', null, '&#x6d4b;&#x8bd5;&#x65b0;&#x589e;&#x52a0;&#x7684;&#x5fc3;&#x60c5;', 'M', '1', '2018-01-14 11:02:59', '2018-01-14 11:02:59');
INSERT INTO `tb_shortmessage` VALUES ('26', '1', '1', null, '&#x81ea;&#x7531;&#x7684;&#x4f60;&#x548c;&#x6211;', 'M', '1', '2018-01-14 11:05:38', '2018-01-14 11:05:38');
INSERT INTO `tb_shortmessage` VALUES ('27', '1', '1', null, '&#x539f;&#x91ce;1', 'M', '1', '2018-01-14 11:08:17', '2018-01-14 11:08:17');

-- ----------------------------
-- Table structure for tb_systemcategory
-- ----------------------------
DROP TABLE IF EXISTS `tb_systemcategory`;
CREATE TABLE `tb_systemcategory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `description` varchar(100) DEFAULT '',
  `status` varchar(1) DEFAULT '1',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_systemcategory
-- ----------------------------

-- ----------------------------
-- Table structure for tb_useraccount
-- ----------------------------
DROP TABLE IF EXISTS `tb_useraccount`;
CREATE TABLE `tb_useraccount` (
  `id` int(11) NOT NULL,
  `userAccount` varchar(20) NOT NULL,
  `passwd` varchar(100) DEFAULT NULL,
  `oldPasswd` varchar(100) DEFAULT NULL,
  `type` varchar(5) DEFAULT '0',
  `status` varchar(1) DEFAULT '1',
  `level` varchar(2) DEFAULT '0',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ip` varchar(20) DEFAULT NULL,
  `lastLogintime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_useraccount
-- ----------------------------
INSERT INTO `tb_useraccount` VALUES ('1', 'admin', '76A2173BE6393254E72FFA4D6DF1030A', '76A2173BE6393254E72FFA4D6DF1030A', '0', '1', '0', '2017-12-07 15:09:42', '2017-12-07 15:17:40', null, '2017-12-23 15:21:40');
INSERT INTO `tb_useraccount` VALUES ('2', 'guest', '76A2173BE6393254E72FFA4D6DF1030A', '76A2173BE6393254E72FFA4D6DF1030A', '0', '1', '0', '2017-12-27 20:17:03', '2017-12-27 20:17:08', null, '0000-00-00 00:00:00');
INSERT INTO `tb_useraccount` VALUES ('11', 'abc', 'passw', 'passwwwww', '0', '1', '0', '2018-03-16 17:09:30', '2018-03-16 17:09:30', null, '0000-00-00 00:00:00');

-- ----------------------------
-- Table structure for tb_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_userinfo`;
CREATE TABLE `tb_userinfo` (
  `id` int(11) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `sex` varchar(1) DEFAULT '0',
  `birthday` date DEFAULT NULL,
  `headImg` varchar(100) NOT NULL,
  `address` varchar(50) DEFAULT '',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `phone` varchar(18) DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_userinfo
-- ----------------------------
INSERT INTO `tb_userinfo` VALUES ('1', 'admin', '1', '2017-12-07', 'headImg', '上海市', '2017-12-07 15:09:44', '2017-12-07 15:17:49', '');
INSERT INTO `tb_userinfo` VALUES ('2', 'guest', '1', '2017-12-11', '11', '上海市', '2017-12-27 20:17:27', '2017-12-27 20:17:32', '');

-- ----------------------------
-- Table structure for tb_userinfosummary
-- ----------------------------
DROP TABLE IF EXISTS `tb_userinfosummary`;
CREATE TABLE `tb_userinfosummary` (
  `userId` int(11) NOT NULL,
  `shortMessageNum` int(11) DEFAULT '0' COMMENT '短文数量',
  `longMessageNum` int(11) DEFAULT '0' COMMENT '长文数量',
  `imgNum` int(11) DEFAULT '0' COMMENT '图片数量',
  `categoryNum` int(11) DEFAULT '0' COMMENT '分类数量',
  `feedbackNum` int(11) DEFAULT '0' COMMENT '反馈数量',
  `annoyanceWallNum` int(11) DEFAULT '0' COMMENT '烦恼发布数量',
  `longMessageSpaceSize` int(11) DEFAULT '0' COMMENT '以长文占用空间',
  `imgSpaceSize` int(11) DEFAULT '0' COMMENT '以图片占用空间',
  `createTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `modifytime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_userinfosummary
-- ----------------------------
INSERT INTO `tb_userinfosummary` VALUES ('1', '21', '1', '0', '3', null, null, '0', '0', '2017-12-23 14:46:36', '2017-12-28 20:30:40');
