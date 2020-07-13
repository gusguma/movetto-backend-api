/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : api

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2020-07-13 12:25:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
`id`  int(11) NOT NULL ,
`active`  bit(1) NOT NULL ,
`card_number`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`cvc`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`expire_month`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`expire_year`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`registration_date`  datetime NULL DEFAULT '' ,
`user_id`  int(11) NULL DEFAULT '' ,
PRIMARY KEY (`id`),
INDEX `FKl4gbym62l738id056y12rt6q6` (`user_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of card
-- ----------------------------
BEGIN;
INSERT INTO `card` VALUES ('1916', '', '4566555512452655', '386', '03', '21', '2020-05-23 15:16:15', '8'), ('1917', '', '2569369925891400', '259', '02', '22', '2020-05-23 17:51:09', '8'), ('1918', '', '1234567891881234', '456', '12', '21', '2020-05-23 19:04:20', '8'), ('2024', '', '5120461063093486', '058', '7', '2022', '2020-06-04 11:53:53', '29'), ('2053', '', '5120461063093480', '999', '07', '26', '2020-06-13 18:27:41', '2044');
COMMIT;

-- ----------------------------
-- Table structure for direction
-- ----------------------------
DROP TABLE IF EXISTS `direction`;
CREATE TABLE `direction` (
`id`  int(11) NOT NULL ,
`active`  bit(1) NOT NULL ,
`city`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`latitude`  double NOT NULL ,
`longitude`  double NOT NULL ,
`country`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`direction_type`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`postal_code`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`registration_date`  datetime NULL DEFAULT '' ,
`state`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`street`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of direction
-- ----------------------------
BEGIN;
INSERT INTO `direction` VALUES ('47', '', 'Cabanillas', '0', '0', 'Spain', 'PARTNER', '19171', '2020-04-17 11:58:16', 'Guadalajara', 'Av. Larona, 100'), ('50', '', 'Cabanillas del Campo', '0', '0', 'Spain', 'CUSTOMER', '19170', '2020-04-18 19:19:48', 'Guadalajara', 'Av. Larona, 105'), ('1887', '', 'Daganzo de Arriba', '0', '0', 'España', 'FINISH', '28814', '2020-05-17 10:24:23', 'Madrid', 'Calle Zurbarán,41'), ('1888', '', 'Chiloeches', '0', '0', 'España', 'START', '19160', '2020-05-17 10:23:29', 'Guadalajara', 'Calle Mayor, 17'), ('1892', '', 'Daganzo de Arriba', '0', '0', 'España', 'FINISH', '28814', '2020-05-17 10:30:13', 'Madrid', 'Calle Valor, 65'), ('1893', '', 'Chiloeches', '0', '0', 'España', 'START', '19160', '2020-05-17 10:29:10', 'Guadalajara', 'calle mayor,43'), ('1897', '', 'Daganzo de Arriba', '0', '0', 'España', 'FINISH', '28814', '2020-05-17 12:15:15', 'Madrid', 'Calle Zurbarán, 41'), ('1898', '', 'Chiloeches', '0', '0', 'España', 'START', '19174', '2020-05-17 12:14:01', 'Guadalajara', 'Calle Camino, 232'), ('1907', '', 'Daganzo de Arriba', '0', '0', 'España', 'FINISH', '28814', '2020-05-17 14:29:48', 'Madrid', 'calle Zurbarán, 43'), ('1908', '', 'Chiloeches', '0', '0', 'España', 'START', '19160', '2020-05-17 14:28:37', 'Guadalajara', 'calle Ramón, 3'), ('1911', '', 'Daganzo de Arriba', '0', '0', 'España', 'FINISH', '28814', '2020-05-19 16:42:49', 'Madrid', 'Calle Zurbano, 55'), ('1912', '', 'Chiloeches', '0', '0', 'España', 'START', '19160', '2020-05-19 16:41:58', 'Guadalajara', 'Calle Mayor, 17'), ('1958', '', 'Cabanillas del Campo', '0', '0', 'Spain', 'FINISH', '19171', '2020-05-31 10:44:57', 'Guadalajara', 'Av. Larona, 10'), ('1959', '', 'chiloeches', '0', '0', 'España', 'START', '19160', '2020-05-31 10:44:54', 'Guadalajara', 'calle mayor, 17'), ('1961', '', 'Cabanillas del Campo', '0', '0', 'Spain', 'FINISH', '19171', '2020-05-31 10:55:31', 'Guadalajara', 'Av. Larona, 10'), ('1962', '', 'chiloeches', '0', '0', 'españa', 'START', '19160', '2020-05-31 10:55:29', 'guadalajara', '\ncalle mayor, 17'), ('1964', '', 'Cabanillas del Campo', '0', '0', 'Spain', 'FINISH', '19171', '2020-05-31 11:10:54', 'Guadalajara', 'Av. Larona, 10'), ('1965', '', 'chiloeches', '0', '0', 'españa', 'START', '19160', '2020-05-31 11:10:52', 'Guadalajara', 'calle mayor, 17'), ('1967', '', 'Cabanillas del Campo', '0', '0', 'Spain', 'FINISH', '19171', '2020-05-31 11:31:18', 'Guadalajara', 'Av. Larona, 10'), ('1968', '', 'chiloeches', '0', '0', 'españa', 'START', '19160', '2020-05-31 11:31:15', 'Guadalajara', 'calle mayor, 17'), ('1970', '', 'Cabanillas del Campo', '0', '0', 'Spain', 'FINISH', '19171', '2020-05-31 11:35:02', 'Guadalajara', 'Av. Larona, 10'), ('1971', '', 'chiloeches', '0', '0', 'españa', 'START', '19160', '2020-05-31 11:31:15', 'Guadalajara', 'calle mayor, 17'), ('1973', '', 'Daganzo de Arriba', '0', '0', 'España', 'FINISH', '28814', '2020-05-31 20:07:01', 'Madrid', 'Calle Zurbano, 41'), ('1974', '', 'Chiloeches', '0', '0', 'España', 'START', '19160', '2020-05-31 20:06:34', 'Guadalajara', 'Calle Mayor, 17'), ('1976', '', 'Cabanillas del Campo', '0', '0', 'Spain', 'FINISH', '19142', '2020-06-01 11:39:35', 'Guadalajara', 'Av. Larona, 10'), ('1977', '', 'Chiloeches', '0', '0', 'España', 'START', '19122', '2020-06-01 11:39:33', 'Guadalajara', 'Calle Mayor, 17'), ('1979', '', 'Cabanillas del Campo', '0', '0', 'Spain', 'FINISH', '19171', '2020-06-02 18:06:06', 'Guadalajara', 'Av. Larona, 10'), ('1980', '', 'Chiloeches', '0', '0', 'España', 'START', '19160', '2020-06-02 18:06:03', 'Guadalajara', 'Calle Mayor, 17'), ('2007', '', 'chiloeches', '0', '0', 'España', 'CUSTOMER', '19160', '2020-06-04 11:29:54', 'guadalajara', 'calle mayor 17'), ('2010', '', 'Cabanillas del Campo', '0', '0', 'España', 'FINISH', '19171', '2020-06-04 11:31:48', 'Guadalajara', 'Av. Larona, 10'), ('2011', '', 'Chiloeches', '0', '0', 'España', 'START', '19160', '2020-06-04 11:30:39', 'Guadalajara', 'Calle Mayor, 17'), ('2015', '', 'Cabanillas del Campo', '0', '0', 'España', 'FINISH', '19171', '2020-06-04 11:43:07', 'Guadalajara', 'Av. Larona, 10'), ('2016', '', 'Chiloeches', '0', '0', 'España', 'START', '19160', '2020-06-04 11:42:23', 'Guadalajara', 'Calle Mayor 17'), ('2020', '', 'Cabanillas del Campo', '0', '0', 'España', 'FINISH', '19171', '2020-06-04 11:48:27', 'Guadalajara', 'Av. Larona, 10'), ('2021', '', 'Chiloeches', '0', '0', 'España', 'START', '19160', '2020-06-04 11:47:48', 'Guadalajara', 'Calle Mayor, 17'), ('2031', '', 'Cabanillas del Campo', '0', '0', 'Spain', 'FINISH', '19171', '2020-06-12 18:01:51', 'Guadalajara', 'Av. Larona, 10'), ('2032', '', 'chiloeches', '0', '0', 'españa', 'START', '19160', '2020-06-12 18:01:47', 'guadalajara', 'calle mayor, 15'), ('2036', '', 'Cabanillas del Campo', '0', '0', 'España', 'FINISH', '19171', '2020-06-13 09:00:56', 'guadalajara', 'Av. Larona, 10'), ('2037', '', 'chiloeches', '0', '0', 'España', 'START', '19160', '2020-06-13 09:00:24', 'madrid', 'calle mayor 17'), ('2045', '', 'chiloeches', '0', '0', 'España', 'CUSTOMER', '19160', '2020-06-13 16:25:49', 'guadalajara', 'calle mayor 17'), ('2047', '', 'Chiloeches', '0', '0', 'españa', 'FINISH', '19160', '2020-06-13 16:32:35', 'Guadalajara', 'Calle Zurbarán, 41'), ('2048', '', 'chiloeches', '0', '0', 'España', 'START', '19160', '2020-06-13 16:31:23', 'Guadalajara', 'calle mayor 17'), ('2051', '', 'Daganzo de arriba', '0', '0', 'España', 'FINISH', '28814', '2020-06-13 18:14:19', 'Madrid', 'calle Zurbarán 41'), ('2052', '', 'chiloeches', '0', '0', 'España', 'START', '19160', '2020-06-13 18:13:56', 'Guadalajara', 'calle mayor 17');
COMMIT;

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
`next_val`  bigint(20) NULL DEFAULT '' 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
BEGIN;
INSERT INTO `hibernate_sequence` VALUES ('2057'), ('2057'), ('2057'), ('2057'), ('2057'), ('2057');
COMMIT;

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
`id`  int(11) NOT NULL ,
`active`  bit(1) NOT NULL ,
`large_description`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`registration_date`  datetime NULL DEFAULT '' ,
`short_description`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`subtitle`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`title`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`url_image`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of news
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for news_labels
-- ----------------------------
DROP TABLE IF EXISTS `news_labels`;
CREATE TABLE `news_labels` (
`news_id`  int(11) NOT NULL ,
`labels_id`  int(11) NOT NULL ,
PRIMARY KEY (`news_id`, `labels_id`),
INDEX `FK92hte1y6p9cbxm90ikvcydisc` (`labels_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of news_labels
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for news_users
-- ----------------------------
DROP TABLE IF EXISTS `news_users`;
CREATE TABLE `news_users` (
`news_id`  int(11) NOT NULL ,
`users_id`  int(11) NOT NULL ,
PRIMARY KEY (`news_id`, `users_id`),
INDEX `FKojac3uwkhtbhwjyxwxqjg8sh7` (`users_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of news_users
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for package
-- ----------------------------
DROP TABLE IF EXISTS `package`;
CREATE TABLE `package` (
`id`  int(11) NOT NULL ,
`active`  bit(1) NOT NULL ,
`high`  double NOT NULL ,
`lenght`  double NOT NULL ,
`price_package`  double NOT NULL ,
`registration_date`  datetime NULL DEFAULT '' ,
`status`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`weight`  double NOT NULL ,
`weight_volume`  double NOT NULL ,
`width`  double NOT NULL ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of package
-- ----------------------------
BEGIN;
INSERT INTO `package` VALUES ('1889', '', '16', '35', '0', '2020-05-17 10:24:52', 'SAVED', '3', '333', '24'), ('1890', '', '16', '35', '0', '2020-05-17 10:24:52', 'SAVED', '3', '333', '24'), ('1894', '', '55', '35', '0', '2020-05-17 10:30:33', 'SAVED', '24', '333', '25'), ('1895', '', '4', '15', '0', '2020-05-17 10:31:50', 'SAVED', '0.5', '333', '16'), ('1899', '', '42', '35', '0', '2020-05-17 12:15:36', 'SAVED', '12', '333', '55'), ('1900', '', '11', '12', '4.5', '2020-05-17 12:16:22', 'SAVED', '15', '333', '10'), ('1901', '', '33', '28', '6.2769167999999995', '2020-05-17 13:02:12', 'SAVED', '14.5', '333', '68'), ('1902', '', '24', '33', '3.5604359999999997', '2020-05-17 14:25:52', 'SAVED', '11', '333', '45'), ('1903', '', '25', '23', '4.2', '2020-05-17 14:26:33', 'SAVED', '14', '333', '25'), ('1904', '', '22', '24', '6.3', '2020-05-17 14:26:48', 'SAVED', '21', '333', '23'), ('1909', '', '33', '28', '2.6999999999999997', '2020-05-17 14:30:05', 'SAVED', '9', '333', '29'), ('1913', '', '33', '25', '4.2', '2020-05-19 16:43:07', 'SAVED', '14', '333', '24'), ('1914', '', '35', '25', '3.8461499999999997', '2020-05-19 17:26:37', 'SAVED', '12', '333', '44'), ('1915', '', '18', '25', '1.483515', '2020-05-21 10:37:38', 'SAVED', '0.5', '333', '33'), ('2012', '', '35', '26', '3.8181779999999996', '2020-06-04 11:32:04', 'SAVED', '9', '333', '42'), ('2017', '', '19', '25', '1.7999999999999998', '2020-06-04 11:43:21', 'SAVED', '6', '333', '23'), ('2022', '', '25', '26', '2.142855', '2020-06-04 11:48:40', 'SAVED', '7', '333', '33'), ('2038', '', '52', '36', '4.8623328', '2020-06-13 09:01:07', 'SAVED', '15', '333', '26'), ('2049', '', '45', '36', '4.207788', '2020-06-13 16:32:48', 'SAVED', '9', '333', '26');
COMMIT;

-- ----------------------------
-- Table structure for service
-- ----------------------------
DROP TABLE IF EXISTS `service`;
CREATE TABLE `service` (
`id`  int(11) NOT NULL ,
`active`  bit(1) NOT NULL ,
`description`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`price`  double NOT NULL ,
`registration_date`  datetime NULL DEFAULT '' ,
`customer_id`  int(11) NULL DEFAULT '' ,
`end_direction_id`  int(11) NULL DEFAULT '' ,
`partner_id`  int(11) NULL DEFAULT '' ,
`start_direction_id`  int(11) NULL DEFAULT '' ,
`vehicle_id`  int(11) NULL DEFAULT '' ,
PRIMARY KEY (`id`),
INDEX `FKvw4e42v2avsgrsvjhd1edgxf` (`customer_id`) USING BTREE ,
INDEX `FK2xi1gorhp4pd2t5s93r0glekd` (`end_direction_id`) USING BTREE ,
INDEX `FKilaifx4ofb00ednaogofiypn9` (`partner_id`) USING BTREE ,
INDEX `FKctceyyxlrtekwhnaot1xgnyr9` (`start_direction_id`) USING BTREE ,
INDEX `FK6fnmjdjln3oexu231vwf1e5kh` (`vehicle_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of service
-- ----------------------------
BEGIN;
INSERT INTO `service` VALUES ('1886', '\0', null, '0', '2020-05-17 10:24:52', '8', '1887', null, '1888', null), ('1891', '\0', null, '0', '2020-05-17 10:30:33', '8', '1892', null, '1893', null), ('1896', '\0', null, '0', '2020-05-17 12:15:36', '8', '1897', null, '1898', null), ('1906', '\0', null, '0', '2020-05-17 14:30:05', '8', '1907', null, '1908', null), ('1910', '', null, '0', '2020-05-19 16:43:07', '8', '1911', null, '1912', null), ('1972', '\0', null, '0', '2020-05-31 22:07:26', '8', '1973', null, '1974', null), ('1975', '\0', null, '0', '2020-06-01 11:39:49', '8', '1976', null, '1977', null), ('1978', '', null, '0', '2020-06-02 18:06:20', '8', '1979', null, '1980', null), ('2009', '', null, '0', '2020-06-04 11:32:05', '29', '2010', '8', '2011', '2028'), ('2014', '', null, '0', '2020-06-04 11:43:22', '8', '2015', null, '2016', null), ('2019', '\0', null, '0', '2020-06-04 11:48:41', '8', '2020', null, '2021', null), ('2030', '', null, '0', '2020-06-12 18:02:07', '29', '2031', '8', '2032', '104'), ('2035', '', null, '0', '2020-06-13 09:01:08', '29', '2036', null, '2037', null), ('2046', '\0', null, '0', '2020-06-13 16:32:48', '2044', '2047', null, '2048', null), ('2050', '', null, '0', '2020-06-13 18:14:45', '2044', '2051', '8', '2052', '104');
COMMIT;

-- ----------------------------
-- Table structure for shipment
-- ----------------------------
DROP TABLE IF EXISTS `shipment`;
CREATE TABLE `shipment` (
`minimum_price`  double NOT NULL ,
`price_shipment`  double NOT NULL ,
`shipment_datetime_limit`  datetime NULL DEFAULT '' ,
`status`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`id`  int(11) NOT NULL ,
`destination_user_id`  int(11) NULL DEFAULT '' ,
PRIMARY KEY (`id`),
INDEX `FKtcv1pho8ii2oqc16qan23vulh` (`destination_user_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of shipment
-- ----------------------------
BEGIN;
INSERT INTO `shipment` VALUES ('5', '0', '2020-05-22 10:24:52', 'DELETED', '1886', '1885'), ('5', '0', '2020-05-22 10:30:33', 'DELETED', '1891', '1885'), ('5', '0', '2020-05-22 12:15:36', 'DELETED', '1896', '1885'), ('5', '0', '2020-05-22 14:30:05', 'DELETED', '1906', '1905'), ('5', '0', '2020-05-24 16:43:07', 'PAID', '1910', '1885'), ('5', '0', '2020-06-09 11:32:05', 'FINISHED', '2009', '2008'), ('5', '0', '2020-06-09 11:43:22', 'PAID', '2014', '2013'), ('5', '0', '2020-06-09 11:48:41', 'DELETED', '2019', '2018'), ('5', '0', '2020-06-18 09:01:08', 'PAID', '2035', '8'), ('5', '0', '2020-06-18 16:32:48', 'DELETED', '2046', '8');
COMMIT;

-- ----------------------------
-- Table structure for shipment_packages
-- ----------------------------
DROP TABLE IF EXISTS `shipment_packages`;
CREATE TABLE `shipment_packages` (
`shipment_id`  int(11) NOT NULL ,
`packages_id`  int(11) NOT NULL ,
PRIMARY KEY (`shipment_id`, `packages_id`),
UNIQUE INDEX `UK_n41ksgxdhnnj5kvs5vvkhukb2` (`packages_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of shipment_packages
-- ----------------------------
BEGIN;
INSERT INTO `shipment_packages` VALUES ('1886', '1889'), ('1886', '1890'), ('1891', '1894'), ('1891', '1895'), ('1896', '1903'), ('1906', '1909'), ('1910', '1913'), ('1910', '1914'), ('1910', '1915'), ('2009', '2012'), ('2014', '2017'), ('2019', '2022'), ('2035', '2038'), ('2046', '2049');
COMMIT;

-- ----------------------------
-- Table structure for tag
-- ----------------------------
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
`id`  int(11) NOT NULL ,
`name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of tag
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for transaction
-- ----------------------------
DROP TABLE IF EXISTS `transaction`;
CREATE TABLE `transaction` (
`dtype`  varchar(31) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`id`  int(11) NOT NULL ,
`active`  bit(1) NOT NULL ,
`amount`  double NOT NULL ,
`registration_date`  datetime NULL DEFAULT '' ,
`status`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`card_id`  int(11) NULL DEFAULT '' ,
`service_id`  int(11) NULL DEFAULT '' ,
PRIMARY KEY (`id`),
INDEX `FKc1dpp3bpa7sm3b23ywr1yyvo5` (`service_id`) USING BTREE ,
INDEX `FK484i2t8acnct6xy8ylevl40go` (`card_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of transaction
-- ----------------------------
BEGIN;
INSERT INTO `transaction` VALUES ('Deposit', '1936', '', '45', '2020-05-26 13:49:14', 'CREATED', '1916', null), ('Deposit', '1935', '', '23', '2020-05-24 16:57:41', 'CREATED', '1916', null), ('Payment', '2006', '', '-16.1217', '2020-06-03 13:23:59', 'CREATED', null, '1978'), ('Payment', '2005', '', '-14.529665', '2020-06-03 13:21:14', 'CREATED', null, '1910'), ('Payment', '2023', '', '-6.8', '2020-06-04 11:49:12', 'CREATED', null, '2014'), ('Deposit', '2026', '', '60', '2020-06-04 11:54:05', 'CREATED', '2024', null), ('Payment', '2027', '', '-8.818178', '2020-06-04 11:54:35', 'CREATED', null, '2009'), ('Payment', '2033', '', '-16.12275', '2020-06-12 18:02:47', 'CREATED', null, '2030'), ('Deposit', '2034', '', '90', '2020-06-12 19:11:15', 'CREATED', '1918', null), ('Payment', '2039', '', '-9.8623328', '2020-06-13 09:01:43', 'CREATED', null, '2035'), ('Charge', '2042', '', '14.510475', '2020-06-13 11:22:27', 'CREATED', null, '2030'), ('Charge', '2043', '', '8.87609952', '2020-06-13 11:27:34', 'CREATED', null, '2035'), ('Deposit', '2055', '', '35', '2020-06-13 18:27:49', 'CREATED', '2053', null), ('Payment', '2056', '', '-34.6794', '2020-06-13 18:29:01', 'CREATED', null, '2050');
COMMIT;

-- ----------------------------
-- Table structure for travel
-- ----------------------------
DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel` (
`distance`  double NOT NULL ,
`end`  datetime NULL DEFAULT '' ,
`minimum_price`  double NOT NULL ,
`people`  int(11) NOT NULL ,
`price_hour`  double NOT NULL ,
`price_km`  double NOT NULL ,
`price_travel`  double NOT NULL ,
`start`  datetime NULL DEFAULT '' ,
`id`  int(11) NOT NULL ,
`status`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
PRIMARY KEY (`id`)
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of travel
-- ----------------------------
BEGIN;
INSERT INTO `travel` VALUES ('34.251', '2020-05-31 20:37:43', '2.4', '3', '20.5', '1.05', '35.96355', '2020-05-31 20:07:00', '1972', 'DELETED'), ('15.354', '2020-06-02 11:57:45', '2.4', '2', '20.5', '1.05', '16.1217', '2020-06-02 11:39:00', '1975', 'DELETED'), ('15.354', '2020-05-30 03:24:45', '2.4', '2', '20.5', '1.05', '16.1217', '2020-05-30 03:06:00', '1978', 'PAID'), ('15.355', '2020-06-13 18:19:31', '2.4', '3', '20.5', '1.05', '16.12275', '2020-06-13 18:01:00', '2030', 'FINISHED'), ('33.028', '2020-05-19 16:42:02', '2.4', '3', '20.5', '1.05', '34.6794', '2020-05-19 16:15:00', '2050', 'TRANSIT');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
`id`  int(11) NOT NULL ,
`active`  bit(1) NULL DEFAULT 0 ,
`customer_id`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`display_name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`email`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`driver_id`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`partner_id`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`phone`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`registration_date`  datetime NULL DEFAULT '' ,
`uid`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `UK_bv23tjhe3c029w3d3x0435imy` (`customer_id`) USING HASH ,
UNIQUE INDEX `UK_ob8kqyqqgmefl0aco34akdtpe` (`email`) USING HASH ,
UNIQUE INDEX `UK_4yaf6tjm0jduantayvd4bqts8` (`driver_id`) USING HASH ,
UNIQUE INDEX `UK_h4ivmkbkxkh2ngoqn3i0tu3ky` (`partner_id`) USING HASH 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES ('8', '', '09012821H', 'Gustavo Gutierrez', 'gusguma@gmail.com', '09012821H', '09012821H', '633927742', '2020-04-10 21:03:35', 't6bpbrIi8Ba8C0AxMYL8nWB1mqi2'), ('29', '', '09012822H', 'Gustavo Gutierrez', 'ggutierrez@urneba.com', null, null, '633927742', '2020-04-13 16:12:38', 'AY5u6E5XdscTFe6HcCZAYYj7u4a2'), ('2008', '', null, 'Carlos Perez', 'carlosperez@gmail.com', null, null, '622445533', '2020-06-04 11:31:49', ''), ('2013', '', null, 'Alfonso Gomez', 'alfonso@gmail.com', null, null, '622442213', '2020-06-04 11:43:08', ''), ('2018', '', null, 'Gustavo Gutierrez', 'rufino@gmail.com', null, null, '622334422', '2020-06-04 11:48:27', ''), ('2044', '', '46867456P', 'Monica Caballero', 'mocatalydia@gmail.com', null, null, '633927742', '2020-06-13 12:04:21', 'iqWhbvwnI2RpFoDNohr56CZVgIR2'), ('1885', '', null, 'Águeda Martin Blazquez', 'aguedamartin@gmail.com', null, null, '617552183', '2020-05-17 10:24:23', ''), ('1905', '', null, 'Mónica Caballero', 'monicacaballero@gmail.com', null, null, '633256233', '2020-05-17 14:29:49', '');
COMMIT;

-- ----------------------------
-- Table structure for user_directions
-- ----------------------------
DROP TABLE IF EXISTS `user_directions`;
CREATE TABLE `user_directions` (
`user_id`  int(11) NOT NULL ,
`directions_id`  int(11) NOT NULL ,
PRIMARY KEY (`user_id`, `directions_id`),
UNIQUE INDEX `UK_f4lm9n4p4xr3p420135h1sy4y` (`directions_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of user_directions
-- ----------------------------
BEGIN;
INSERT INTO `user_directions` VALUES ('8', '47'), ('8', '50'), ('29', '2007'), ('2044', '2045');
COMMIT;

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
`user_id`  int(11) NOT NULL ,
`roles`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
INDEX `FK55itppkw3i07do3h7qoclqd4k` (`user_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
BEGIN;
INSERT INTO `user_roles` VALUES ('8', 'USER'), ('8', 'CUSTOMER'), ('29', 'USER'), ('8', 'PARTNER'), ('1885', 'USER'), ('1884', 'USER'), ('1905', 'USER'), ('29', 'CUSTOMER'), ('2008', 'USER'), ('2013', 'USER'), ('2018', 'USER'), ('2044', 'USER'), ('2044', 'CUSTOMER');
COMMIT;

-- ----------------------------
-- Table structure for user_vehicles
-- ----------------------------
DROP TABLE IF EXISTS `user_vehicles`;
CREATE TABLE `user_vehicles` (
`user_id`  int(11) NOT NULL ,
`vehicles_id`  int(11) NOT NULL ,
PRIMARY KEY (`user_id`, `vehicles_id`),
UNIQUE INDEX `UK_9j5jv72lre66julwmi3hx5bxb` (`vehicles_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of user_vehicles
-- ----------------------------
BEGIN;
INSERT INTO `user_vehicles` VALUES ('8', '104'), ('8', '2028');
COMMIT;

-- ----------------------------
-- Table structure for vehicle
-- ----------------------------
DROP TABLE IF EXISTS `vehicle`;
CREATE TABLE `vehicle` (
`dtype`  varchar(31) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`id`  int(11) NOT NULL ,
`active`  bit(1) NULL DEFAULT 0 ,
`name`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL ,
`registration`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`registration_date`  datetime NULL DEFAULT '' ,
`max_high`  double NULL DEFAULT '' ,
`max_lenght`  double NULL DEFAULT '' ,
`max_volume`  double NULL DEFAULT '' ,
`max_weight`  double NULL DEFAULT '' ,
`max_width`  double NULL DEFAULT '' ,
`places_available`  int(11) NULL DEFAULT '' ,
`vehicle_type_enum`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`description`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`make`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
`model`  varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' ,
PRIMARY KEY (`id`),
UNIQUE INDEX `UK_tjmofyrt4whp0m1vaql9njjdo` (`registration`) USING HASH 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of vehicle
-- ----------------------------
BEGIN;
INSERT INTO `vehicle` VALUES ('Car', '2028', '', 'Mi Coche', '3486CJY', '2020-06-10 08:57:36', '200', '200', '0.5', '250', '200', '4', 'CAR', 'mi Coche', 'Alfa Romeo', '147'), ('Car', '2029', '', 'hhhhh', 'bbbbj', '2020-06-10 13:46:16', '200', '200', '0.5', '250', '200', '4', 'CAR', 'bbbjjj', 'bbbbjj', 'hhjjj'), ('Bike', '104', '', 'mi bicicleta', null, '2020-05-10 12:03:20', '50', '50', '0.13', '15', '50', '0', 'BIKE', 'la bici', 'Campagnolo', null);
COMMIT;

-- ----------------------------
-- Table structure for wallet
-- ----------------------------
DROP TABLE IF EXISTS `wallet`;
CREATE TABLE `wallet` (
`id`  int(11) NOT NULL ,
`active`  bit(1) NOT NULL ,
`balance`  double NOT NULL ,
`registration_date`  datetime NULL DEFAULT '' ,
`user_id`  int(11) NULL DEFAULT '' ,
PRIMARY KEY (`id`),
INDEX `FKbs4ogwiknsup4rpw8d47qw9dx` (`user_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of wallet
-- ----------------------------
BEGIN;
INSERT INTO `wallet` VALUES ('1934', '', '143.93520952', '2020-05-24 18:57:41', '8'), ('2025', '', '25.196739199999996', '2020-06-04 11:54:06', '29'), ('2054', '', '0.3205999999999989', '2020-06-13 18:27:50', '2044');
COMMIT;

-- ----------------------------
-- Table structure for wallet_transactions
-- ----------------------------
DROP TABLE IF EXISTS `wallet_transactions`;
CREATE TABLE `wallet_transactions` (
`wallet_id`  int(11) NOT NULL ,
`transactions_id`  int(11) NOT NULL ,
PRIMARY KEY (`wallet_id`, `transactions_id`),
UNIQUE INDEX `UK_ih1d10xdrgoibf7na9f3lcb1` (`transactions_id`) USING BTREE 
)
ENGINE=MyISAM
DEFAULT CHARACTER SET=utf8mb4 COLLATE=utf8mb4_general_ci

;

-- ----------------------------
-- Records of wallet_transactions
-- ----------------------------
BEGIN;
INSERT INTO `wallet_transactions` VALUES ('1934', '1935'), ('1934', '1936'), ('1934', '1956'), ('1934', '1981'), ('1934', '1982'), ('1934', '1983'), ('1934', '1984'), ('1934', '1985'), ('1934', '1986'), ('1934', '1987'), ('1934', '1988'), ('1934', '1990'), ('1934', '1991'), ('1934', '1992'), ('1934', '1994'), ('1934', '1995'), ('1934', '1996'), ('1934', '1997'), ('1934', '1998'), ('1934', '1999'), ('1934', '2000'), ('1934', '2001'), ('1934', '2002'), ('1934', '2003'), ('1934', '2004'), ('1934', '2005'), ('1934', '2006'), ('1934', '2023'), ('1934', '2034'), ('1934', '2040'), ('1934', '2041'), ('1934', '2042'), ('1934', '2043'), ('2025', '2026'), ('2025', '2027'), ('2025', '2033'), ('2025', '2039'), ('2054', '2055'), ('2054', '2056');
COMMIT;
