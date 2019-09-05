/*
Navicat MySQL Data Transfer

Source Server         : company
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : miaosha

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-06-28 14:59:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for address
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `reciver_name` varchar(255) DEFAULT NULL COMMENT '收货人姓名',
  `reciver_phone` varchar(255) DEFAULT NULL COMMENT '收货人电话',
  `reciver_address` varchar(255) DEFAULT NULL COMMENT '收货人详细地址',
  `post_no` int(11) DEFAULT NULL COMMENT '邮编',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`address_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for cart
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `goods_id` int(255) DEFAULT NULL,
  `goods_price` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goods_id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(255) DEFAULT NULL COMMENT '商品名称',
  `goods_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `goods_desc` varchar(255) DEFAULT NULL COMMENT '商品描述',
  `goods_stock` int(10) DEFAULT NULL COMMENT '商品库存',
  `goods_img` varchar(255) DEFAULT NULL COMMENT '商品图片',
  PRIMARY KEY (`goods_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES ('1', 'Jordan篮球鞋', '450.00', '轻便透气夏季运动跑鞋', '289', 'b1.jpg');
INSERT INTO `goods` VALUES ('2', '耐克男鞋', '1198.00', '减震保护外场篮球鞋', '39', 'b2.jpg');
INSERT INTO `goods` VALUES ('3', '李宁复古卫衣', '1299.00', '红旗汽车联名卫衣', '12', 'lining.jpg');
INSERT INTO `goods` VALUES ('4', '阿迪达斯boost跑步鞋', '689.00', '巴斯夫缓震科技回弹跑鞋', '45', 'boost.png');
INSERT INTO `goods` VALUES ('5', '李宁韦德之道', '1299.00', '云缓震科技减震回弹篮球鞋wow7', '98', 'wow.png');

-- ----------------------------
-- Table structure for miaosha_goods
-- ----------------------------
DROP TABLE IF EXISTS `miaosha_goods`;
CREATE TABLE `miaosha_goods` (
  `miaoshagoods_id` int(11) NOT NULL,
  `goods_id` int(11) DEFAULT NULL COMMENT '商品id',
  `miaosha_price` decimal(10,2) DEFAULT NULL COMMENT '秒杀价格',
  `miaosha_stock` int(10) DEFAULT NULL COMMENT '秒杀库存',
  `begin_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  PRIMARY KEY (`miaoshagoods_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of miaosha_goods
-- ----------------------------
INSERT INTO `miaosha_goods` VALUES ('1', '1', '998.00', '82', '2019-06-25 11:30:18', '2019-06-29 11:11:33');
INSERT INTO `miaosha_goods` VALUES ('2', '2', '222.00', '34', '2019-06-25 11:31:54', '2019-06-29 11:12:00');
INSERT INTO `miaosha_goods` VALUES ('3', '3', '659.00', '18', '2019-06-25 11:21:27', '2019-06-29 11:12:32');
INSERT INTO `miaosha_goods` VALUES ('4', '4', '399.00', '22', '2019-06-24 11:54:44', '2019-06-29 11:54:50');
INSERT INTO `miaosha_goods` VALUES ('5', '5', '799.00', '9', '2019-06-26 11:55:14', '2019-06-29 11:55:25');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` varchar(255) DEFAULT NULL COMMENT '订单编号',
  `address_id` int(10) DEFAULT NULL COMMENT '地址id',
  `miaoshagoods_id` int(10) DEFAULT NULL COMMENT '商品id',
  `user_id` int(10) DEFAULT NULL COMMENT '用户id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `pay_time` datetime DEFAULT NULL COMMENT '付款时间',
  `buy_count` int(10) DEFAULT NULL COMMENT '商品数量',
  `order_pay_no` varchar(255) DEFAULT NULL COMMENT '商品交易号',
  PRIMARY KEY (`order_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('2', '15616056982191', '1', '1', '0', '2019-06-27 11:21:38', null, '1', null);
INSERT INTO `orderinfo` VALUES ('3', '15616061278261', '1', '1', '0', '2019-06-27 11:28:47', null, '1', null);
INSERT INTO `orderinfo` VALUES ('4', '15616070312961', '1', '1', '0', '2019-06-27 11:43:51', null, '1', null);
INSERT INTO `orderinfo` VALUES ('5', '15616070393291', '1', '1', '0', '2019-06-27 11:43:59', null, '1', null);
INSERT INTO `orderinfo` VALUES ('6', '15616102101381', '1', '1', '0', '2019-06-27 12:36:50', null, '1', null);
INSERT INTO `orderinfo` VALUES ('7', '15616115271171', '1', '1', '0', '2019-06-27 12:58:47', null, '1', null);
INSERT INTO `orderinfo` VALUES ('8', '15616115359371', '1', '1', '0', '2019-06-27 12:58:55', null, '1', null);
INSERT INTO `orderinfo` VALUES ('9', '15616115915991', '1', '1', '0', '2019-06-27 12:59:51', null, '1', null);
INSERT INTO `orderinfo` VALUES ('10', '15616179750821', '1', '1', '0', '2019-06-27 14:46:15', null, '1', null);
INSERT INTO `orderinfo` VALUES ('11', '15616201019331', '1', '1', '0', '2019-06-27 15:21:41', null, '1', null);
INSERT INTO `orderinfo` VALUES ('12', '15616225896531', '101', '1', '0', '2019-06-27 16:03:09', null, '1', null);
INSERT INTO `orderinfo` VALUES ('13', '15616252386941', '101', '1', '0', '2019-06-27 16:47:18', null, '1', null);
INSERT INTO `orderinfo` VALUES ('14', '15616254526101', '101', '1', '0', '2019-06-27 16:50:52', null, '1', null);
INSERT INTO `orderinfo` VALUES ('15', '15616277034481', '101', '1', null, '2019-06-27 17:28:23', null, '1', null);
INSERT INTO `orderinfo` VALUES ('16', '15616277035031', '101', '1', null, '2019-06-27 17:28:23', null, '1', null);
INSERT INTO `orderinfo` VALUES ('17', '15616461673821', '101', '1', '0', '2019-06-27 22:36:07', null, '1', null);
INSERT INTO `orderinfo` VALUES ('18', '15616461861191', '101', '1', '0', '2019-06-27 22:36:26', null, '1', null);
INSERT INTO `orderinfo` VALUES ('19', '15616859858911', '101', '1', null, '2019-06-28 09:39:45', null, '1', null);
INSERT INTO `orderinfo` VALUES ('20', '15616883668183', '101', '3', '0', '2019-06-28 10:19:26', null, '1', null);
INSERT INTO `orderinfo` VALUES ('21', '15616908493565', '101', '5', null, '2019-06-28 11:00:49', null, '1', null);

-- ----------------------------
-- Table structure for userinfo
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名 ',
  `user_pwd` varchar(255) DEFAULT NULL COMMENT '用户密码',
  `regist_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_login_time` datetime DEFAULT NULL COMMENT '上次登录时间',
  `user_email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'lin', '123', '2019-06-19 11:01:16', '2019-06-19 11:01:19', null);
INSERT INTO `userinfo` VALUES ('7', 'qq', '222', '2019-06-20 10:48:36', '2019-06-20 10:48:36', 'bb');
INSERT INTO `userinfo` VALUES ('8', 'lin2', '222', '2019-06-24 21:50:28', '2019-06-24 21:50:28', '211@11.cpm');
INSERT INTO `userinfo` VALUES ('9', 'sfs', 'asd', '2019-06-26 19:31:33', '2019-06-26 19:31:33', '211@11.cpm');
INSERT INTO `userinfo` VALUES ('10', 'lin22', '111', '2019-06-28 11:00:15', '2019-06-28 11:00:15', '211@11.cps');
