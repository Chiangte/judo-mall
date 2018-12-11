/*
Navicat MySQL Data Transfer

Source Server         : type
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : judo

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-10-03 16:16:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for shop_goods_type
-- ----------------------------
DROP TABLE IF EXISTS `shop_goods_type`;
CREATE TABLE `shop_goods_type` (
  `id` varchar(64) NOT NULL COMMENT 'ID',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `parent_id` varchar(64) DEFAULT NULL COMMENT '父级ID',
  `parent_name` varchar(200) DEFAULT NULL COMMENT '父级名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(64) DEFAULT NULL COMMENT '创建人',
  `last_modify` varchar(64) DEFAULT NULL COMMENT '最后修改人',
  `del_flag` char(1) DEFAULT '0' COMMENT '0--正常 1--删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品类型表';

-- ----------------------------
-- Records of shop_goods_type
-- ----------------------------
INSERT INTO `shop_goods_type` VALUES ('0749c04fbc0149f7aed8773dbfc9295d', 'X21&X21屏幕指纹版', '639b4aba547f4f7dbd4940162a7b0869', 'X系列', '2018-10-03 15:58:21', '2018-10-03 15:58:35', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('15ff5e06ec054d00bb4ff4988bfe8458', 'Z1i', 'cb47eee7e36145ea8bd3666670571fab', 'Z系列', '2018-10-03 16:03:52', '2018-10-03 16:04:13', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('23ba5e1724f64fc9b2e4259e66a44704', '配件产品', '1', '1', '2018-10-03 15:34:44', '2018-10-03 15:34:47', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('315108266d7f456da20c746796a4e4a0\r\n', '服务', '1', '1', '2018-10-03 15:35:39', '2018-10-03 15:35:41', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('327fb94db62640a58966fa24fa87842d', '智能手机', '1', '1', '2018-10-03 15:31:36', '2018-10-03 15:31:43', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('3a98ac9dc4384328aa7355c6ae29a5d2', 'Y81s', '7339ad2ce41d4030a3fa2ae3f8f5cabd', 'Y系列', '2018-10-03 16:07:33', '2018-10-03 16:07:47', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('405a1a9659134d77b7e15eb6185497ae', 'NEX & NEX屏幕指纹版\r\n', 'bf9e0f2d3386441f9fcd5d5066b7a08c\r\n', 'NEX系列', '2018-10-03 15:55:00', '2018-10-03 15:55:15', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('5b3d42a2ed5f46009bfcc92df0f70747', 'NEX旗舰版\r\n', 'bf9e0f2d3386441f9fcd5d5066b7a08c\r\n', 'NEX系列', '2018-10-03 15:55:41', '2018-10-03 15:56:05', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('639b4aba547f4f7dbd4940162a7b0869', 'X系列', '327fb94db62640a58966fa24fa87842d', '智能手机', '2018-10-03 15:39:22', '2018-10-03 15:39:28', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('7339ad2ce41d4030a3fa2ae3f8f5cabd', 'Y系列', '327fb94db62640a58966fa24fa87842d', '智能手机', '2018-10-03 15:42:52', '2018-10-03 15:43:07', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('763eb37eb06b4c42a3e5204eb6ec39f2', '音乐', '23ba5e1724f64fc9b2e4259e66a44704\r\n', '配件产品', '2018-10-03 15:48:43', '2018-10-03 15:48:59', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('79338aa8ad7247a9aef93a1f3d533b2d', 'X23', '639b4aba547f4f7dbd4940162a7b0869', 'X系列', '2018-10-03 15:57:17', '2018-10-03 15:57:34', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('87ba4dc9f208462787429c4a3964a018', 'X21i', '639b4aba547f4f7dbd4940162a7b0869', 'X系列', '2018-10-03 16:00:34', '2018-10-03 16:00:44', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('89166c4a2d1841f99817e25a83db6b30', 'Y85', '7339ad2ce41d4030a3fa2ae3f8f5cabd', 'Y系列', '2018-10-03 16:05:48', '2018-10-03 16:06:02', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('8c840324f9874864afa3203473ee1d16', '配件', '23ba5e1724f64fc9b2e4259e66a44704\r\n', '配件产品', '2018-10-03 15:47:36', '2018-10-03 15:47:53', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('8e218e1e6e4f40d8bcd83aa0d4ff7adf', 'Y83', '7339ad2ce41d4030a3fa2ae3f8f5cabd', 'Y系列', '2018-10-03 16:06:56', '2018-10-03 16:07:04', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('8ebc8c4b12064fcea66f84fd8757e349', 'X21 FIFA世界杯非凡版', '639b4aba547f4f7dbd4940162a7b0869', 'X系列', '2018-10-03 15:59:43', '2018-10-03 15:59:53', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('8ff64791388a4825b42fb5acc25303f7', '生活', '23ba5e1724f64fc9b2e4259e66a44704', '配件产品', '2018-10-03 15:51:41', '2018-10-03 15:51:18', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('9a925c2b7cc1454da55c63b06d6b5f51', 'Y79', '7339ad2ce41d4030a3fa2ae3f8f5cabd', 'Y系列', '2018-10-03 16:08:23', '2018-10-03 16:08:34', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('9b9444c9fd934e30aa86af22ed7740c2', 'X20', '639b4aba547f4f7dbd4940162a7b0869', 'X系列', '2018-10-03 16:01:21', '2018-10-03 16:01:32', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('9fdbd2ff48274017be2f42ce05ab936d', '碎屏宝', '315108266d7f456da20c746796a4e4a0\r\n', '服务', '2018-10-03 15:52:40', '2018-10-03 15:53:33', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('a93c2fd7669b4f278c47ba4ea1d0fa45', 'Z1', 'cb47eee7e36145ea8bd3666670571fab', 'Z系列', '2018-10-03 16:02:32', '2018-10-03 16:02:45', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('bf9e0f2d3386441f9fcd5d5066b7a08c\r\n', 'NEX系列', '327fb94db62640a58966fa24fa87842d', '智能手机', '2018-10-03 15:36:32', '2018-10-03 15:36:43', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('c60a26cdc3b44240897f8aa505617ac9', '智能', '23ba5e1724f64fc9b2e4259e66a44704\r\n', '配件产品', '2018-10-03 15:49:38', '2018-10-03 15:50:01', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('cb47eee7e36145ea8bd3666670571fab', 'Z系列', '327fb94db62640a58966fa24fa87842d', '智能手机', '2018-10-03 15:41:46', '2018-10-03 15:42:01', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('d7ed2e56f5634ed8b9c5a0058f43ffab', '充电', '23ba5e1724f64fc9b2e4259e66a44704\r\n', '配件产品', '2018-10-03 15:46:10', '2018-10-03 15:46:50', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('db352b3afeab43ba8905a9c5ed030204', 'Y97', '7339ad2ce41d4030a3fa2ae3f8f5cabd', 'Y系列', '2018-10-03 16:04:56', '2018-10-03 16:05:10', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
INSERT INTO `shop_goods_type` VALUES ('ddef57c9b4114385a86f1bc12f612773', '摄影', '23ba5e1724f64fc9b2e4259e66a44704\r\n', '配件产品', '2018-10-03 15:50:45', '2018-10-03 15:50:57', 'b9c7c5a8e497469daab6b664d01f995f\r\n', 'b9c7c5a8e497469daab6b664d01f995f\r\n', '0');
