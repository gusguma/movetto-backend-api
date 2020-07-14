-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: api
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.11-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
SET NAMES utf8;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `card`
--

DROP TABLE IF EXISTS card;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE card
(
    `id`              int(11) NOT NULL,
    active            bit(1)  NOT NULL,
    card_number       varchar(255) DEFAULT NULL,
    cvc               varchar(255) DEFAULT NULL,
    expire_month      varchar(255) DEFAULT NULL,
    expire_year       varchar(255) DEFAULT NULL,
    registration_date datetime     DEFAULT NULL,
    user_id           int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY FKl4gbym62l738id056y12rt6q6 (user_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `card`
--

INSERT INTO card
VALUES (1916, _binary '', '4566555512452655', '386', '03', '21', '2020-05-23 15:16:15', 8),
       (1917, _binary '', '2569369925891400', '259', '02', '22', '2020-05-23 17:51:09', 8),
       (1918, _binary '', '1234567891881234', '456', '12', '21', '2020-05-23 19:04:20', 8),
       (2024, _binary '', '5120461063093486', '058', '7', '2022', '2020-06-04 11:53:53', 29),
       (2053, _binary '', '5120461063093480', '999', '07', '26', '2020-06-13 18:27:41', 2044);

--
-- Table structure for table `direction`
--

DROP TABLE IF EXISTS direction;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE direction
(
    `id`              int(11)      NOT NULL,
    active            bit(1)       NOT NULL,
    city              varchar(255) DEFAULT NULL,
    latitude          double       NOT NULL,
    longitude         double       NOT NULL,
    country           varchar(255) DEFAULT NULL,
    direction_type    varchar(255) NOT NULL,
    postal_code       varchar(255) DEFAULT NULL,
    registration_date datetime     DEFAULT NULL,
    state             varchar(255) DEFAULT NULL,
    street            varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `direction`
--

INSERT INTO direction
VALUES (47, _binary '', 'Cabanillas', 0, 0, 'Spain', 'PARTNER', '19171', '2020-04-17 11:58:16', 'Guadalajara',
        'Av. Larona, 100'),
       (50, _binary '', 'Cabanillas del Campo', 0, 0, 'Spain', 'CUSTOMER', '19170', '2020-04-18 19:19:48',
        'Guadalajara', 'Av. Larona, 105'),
       (1887, _binary '', 'Daganzo de Arriba', 0, 0, 'España', 'FINISH', '28814', '2020-05-17 10:24:23', 'Madrid',
        'Calle Zurbarán,41'),
       (1888, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19160', '2020-05-17 10:23:29', 'Guadalajara',
        'Calle Mayor, 17'),
       (1892, _binary '', 'Daganzo de Arriba', 0, 0, 'España', 'FINISH', '28814', '2020-05-17 10:30:13', 'Madrid',
        'Calle Valor, 65'),
       (1893, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19160', '2020-05-17 10:29:10', 'Guadalajara',
        'calle mayor,43'),
       (1897, _binary '', 'Daganzo de Arriba', 0, 0, 'España', 'FINISH', '28814', '2020-05-17 12:15:15', 'Madrid',
        'Calle Zurbarán, 41'),
       (1898, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19174', '2020-05-17 12:14:01', 'Guadalajara',
        'Calle Camino, 232'),
       (1907, _binary '', 'Daganzo de Arriba', 0, 0, 'España', 'FINISH', '28814', '2020-05-17 14:29:48', 'Madrid',
        'calle Zurbarán, 43'),
       (1908, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19160', '2020-05-17 14:28:37', 'Guadalajara',
        'calle Ramón, 3'),
       (1911, _binary '', 'Daganzo de Arriba', 0, 0, 'España', 'FINISH', '28814', '2020-05-19 16:42:49', 'Madrid',
        'Calle Zurbano, 55'),
       (1912, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19160', '2020-05-19 16:41:58', 'Guadalajara',
        'Calle Mayor, 17'),
       (1958, _binary '', 'Cabanillas del Campo', 0, 0, 'Spain', 'FINISH', '19171', '2020-05-31 10:44:57',
        'Guadalajara', 'Av. Larona, 10'),
       (1959, _binary '', 'chiloeches', 0, 0, 'España', 'START', '19160', '2020-05-31 10:44:54', 'Guadalajara',
        'calle mayor, 17'),
       (1961, _binary '', 'Cabanillas del Campo', 0, 0, 'Spain', 'FINISH', '19171', '2020-05-31 10:55:31',
        'Guadalajara', 'Av. Larona, 10'),
       (1962, _binary '', 'chiloeches', 0, 0, 'españa', 'START', '19160', '2020-05-31 10:55:29', 'guadalajara',
        '\ncalle mayor, 17'),
       (1964, _binary '', 'Cabanillas del Campo', 0, 0, 'Spain', 'FINISH', '19171', '2020-05-31 11:10:54',
        'Guadalajara', 'Av. Larona, 10'),
       (1965, _binary '', 'chiloeches', 0, 0, 'españa', 'START', '19160', '2020-05-31 11:10:52', 'Guadalajara',
        'calle mayor, 17'),
       (1967, _binary '', 'Cabanillas del Campo', 0, 0, 'Spain', 'FINISH', '19171', '2020-05-31 11:31:18',
        'Guadalajara', 'Av. Larona, 10'),
       (1968, _binary '', 'chiloeches', 0, 0, 'españa', 'START', '19160', '2020-05-31 11:31:15', 'Guadalajara',
        'calle mayor, 17'),
       (1970, _binary '', 'Cabanillas del Campo', 0, 0, 'Spain', 'FINISH', '19171', '2020-05-31 11:35:02',
        'Guadalajara', 'Av. Larona, 10'),
       (1971, _binary '', 'chiloeches', 0, 0, 'españa', 'START', '19160', '2020-05-31 11:31:15', 'Guadalajara',
        'calle mayor, 17'),
       (1973, _binary '', 'Daganzo de Arriba', 0, 0, 'España', 'FINISH', '28814', '2020-05-31 20:07:01', 'Madrid',
        'Calle Zurbano, 41'),
       (1974, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19160', '2020-05-31 20:06:34', 'Guadalajara',
        'Calle Mayor, 17'),
       (1976, _binary '', 'Cabanillas del Campo', 0, 0, 'Spain', 'FINISH', '19142', '2020-06-01 11:39:35',
        'Guadalajara', 'Av. Larona, 10'),
       (1977, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19122', '2020-06-01 11:39:33', 'Guadalajara',
        'Calle Mayor, 17'),
       (1979, _binary '', 'Cabanillas del Campo', 0, 0, 'Spain', 'FINISH', '19171', '2020-06-02 18:06:06',
        'Guadalajara', 'Av. Larona, 10'),
       (1980, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19160', '2020-06-02 18:06:03', 'Guadalajara',
        'Calle Mayor, 17'),
       (2007, _binary '', 'chiloeches', 0, 0, 'España', 'CUSTOMER', '19160', '2020-06-04 11:29:54', 'guadalajara',
        'calle mayor 17'),
       (2010, _binary '', 'Cabanillas del Campo', 0, 0, 'España', 'FINISH', '19171', '2020-06-04 11:31:48',
        'Guadalajara', 'Av. Larona, 10'),
       (2011, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19160', '2020-06-04 11:30:39', 'Guadalajara',
        'Calle Mayor, 17'),
       (2015, _binary '', 'Cabanillas del Campo', 0, 0, 'España', 'FINISH', '19171', '2020-06-04 11:43:07',
        'Guadalajara', 'Av. Larona, 10'),
       (2016, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19160', '2020-06-04 11:42:23', 'Guadalajara',
        'Calle Mayor 17'),
       (2020, _binary '', 'Cabanillas del Campo', 0, 0, 'España', 'FINISH', '19171', '2020-06-04 11:48:27',
        'Guadalajara', 'Av. Larona, 10'),
       (2021, _binary '', 'Chiloeches', 0, 0, 'España', 'START', '19160', '2020-06-04 11:47:48', 'Guadalajara',
        'Calle Mayor, 17'),
       (2031, _binary '', 'Cabanillas del Campo', 0, 0, 'Spain', 'FINISH', '19171', '2020-06-12 18:01:51',
        'Guadalajara', 'Av. Larona, 10'),
       (2032, _binary '', 'chiloeches', 0, 0, 'españa', 'START', '19160', '2020-06-12 18:01:47', 'guadalajara',
        'calle mayor, 15'),
       (2036, _binary '', 'Cabanillas del Campo', 0, 0, 'España', 'FINISH', '19171', '2020-06-13 09:00:56',
        'guadalajara', 'Av. Larona, 10'),
       (2037, _binary '', 'chiloeches', 0, 0, 'España', 'START', '19160', '2020-06-13 09:00:24', 'madrid',
        'calle mayor 17'),
       (2045, _binary '', 'chiloeches', 0, 0, 'España', 'CUSTOMER', '19160', '2020-06-13 16:25:49', 'guadalajara',
        'calle mayor 17'),
       (2047, _binary '', 'Chiloeches', 0, 0, 'españa', 'FINISH', '19160', '2020-06-13 16:32:35', 'Guadalajara',
        'Calle Zurbarán, 41'),
       (2048, _binary '', 'chiloeches', 0, 0, 'España', 'START', '19160', '2020-06-13 16:31:23', 'Guadalajara',
        'calle mayor 17'),
       (2051, _binary '', 'Daganzo de arriba', 0, 0, 'España', 'FINISH', '28814', '2020-06-13 18:14:19', 'Madrid',
        'calle Zurbarán 41'),
       (2052, _binary '', 'chiloeches', 0, 0, 'España', 'START', '19160', '2020-06-13 18:13:56', 'Guadalajara',
        'calle mayor 17');

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS hibernate_sequence;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE hibernate_sequence
(
    next_val bigint(20) DEFAULT NULL
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO hibernate_sequence
VALUES (2057),
       (2057),
       (2057),
       (2057),
       (2057),
       (2057);

--
-- Table structure for table `news`
--

DROP TABLE IF EXISTS news;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE news
(
    `id`              int(11) NOT NULL,
    active            bit(1)  NOT NULL,
    large_description varchar(255) DEFAULT NULL,
    registration_date datetime     DEFAULT NULL,
    short_description varchar(255) DEFAULT NULL,
    subtitle          varchar(255) DEFAULT NULL,
    title             varchar(255) DEFAULT NULL,
    url_image         varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news`
--


--
-- Table structure for table `news_labels`
--

DROP TABLE IF EXISTS news_labels;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE news_labels
(
    news_id   int(11) NOT NULL,
    labels_id int(11) NOT NULL,
    PRIMARY KEY (news_id, labels_id),
    KEY FK92hte1y6p9cbxm90ikvcydisc (labels_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_labels`
--


--
-- Table structure for table `news_users`
--

DROP TABLE IF EXISTS news_users;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE news_users
(
    news_id  int(11) NOT NULL,
    users_id int(11) NOT NULL,
    PRIMARY KEY (news_id, users_id),
    KEY FKojac3uwkhtbhwjyxwxqjg8sh7 (users_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `news_users`
--


--
-- Table structure for table `package`
--

DROP TABLE IF EXISTS package;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `package`
(
    `id`              int(11) NOT NULL,
    active            bit(1)  NOT NULL,
    high              double  NOT NULL,
    lenght            double  NOT NULL,
    price_package     double  NOT NULL,
    registration_date datetime     DEFAULT NULL,
    `status`          varchar(255) DEFAULT NULL,
    weight            double  NOT NULL,
    weight_volume     double  NOT NULL,
    width             double  NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `package`
--

INSERT INTO package
VALUES (1889, _binary '', 16, 35, 0, '2020-05-17 10:24:52', 'SAVED', 3, 333, 24),
       (1890, _binary '', 16, 35, 0, '2020-05-17 10:24:52', 'SAVED', 3, 333, 24),
       (1894, _binary '', 55, 35, 0, '2020-05-17 10:30:33', 'SAVED', 24, 333, 25),
       (1895, _binary '', 4, 15, 0, '2020-05-17 10:31:50', 'SAVED', 0.5, 333, 16),
       (1899, _binary '', 42, 35, 0, '2020-05-17 12:15:36', 'SAVED', 12, 333, 55),
       (1900, _binary '', 11, 12, 4.5, '2020-05-17 12:16:22', 'SAVED', 15, 333, 10),
       (1901, _binary '', 33, 28, 6.2769167999999995, '2020-05-17 13:02:12', 'SAVED', 14.5, 333, 68),
       (1902, _binary '', 24, 33, 3.5604359999999997, '2020-05-17 14:25:52', 'SAVED', 11, 333, 45),
       (1903, _binary '', 25, 23, 4.2, '2020-05-17 14:26:33', 'SAVED', 14, 333, 25),
       (1904, _binary '', 22, 24, 6.3, '2020-05-17 14:26:48', 'SAVED', 21, 333, 23),
       (1909, _binary '', 33, 28, 2.6999999999999997, '2020-05-17 14:30:05', 'SAVED', 9, 333, 29),
       (1913, _binary '', 33, 25, 4.2, '2020-05-19 16:43:07', 'SAVED', 14, 333, 24),
       (1914, _binary '', 35, 25, 3.8461499999999997, '2020-05-19 17:26:37', 'SAVED', 12, 333, 44),
       (1915, _binary '', 18, 25, 1.483515, '2020-05-21 10:37:38', 'SAVED', 0.5, 333, 33),
       (2012, _binary '', 35, 26, 3.8181779999999996, '2020-06-04 11:32:04', 'SAVED', 9, 333, 42),
       (2017, _binary '', 19, 25, 1.7999999999999998, '2020-06-04 11:43:21', 'SAVED', 6, 333, 23),
       (2022, _binary '', 25, 26, 2.142855, '2020-06-04 11:48:40', 'SAVED', 7, 333, 33),
       (2038, _binary '', 52, 36, 4.8623328, '2020-06-13 09:01:07', 'SAVED', 15, 333, 26),
       (2049, _binary '', 45, 36, 4.207788, '2020-06-13 16:32:48', 'SAVED', 9, 333, 26);

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS service;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE service
(
    `id`               int(11) NOT NULL,
    active             bit(1)  NOT NULL,
    description        varchar(255) DEFAULT NULL,
    price              double  NOT NULL,
    registration_date  datetime     DEFAULT NULL,
    customer_id        int(11)      DEFAULT NULL,
    end_direction_id   int(11)      DEFAULT NULL,
    partner_id         int(11)      DEFAULT NULL,
    start_direction_id int(11)      DEFAULT NULL,
    vehicle_id         int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY FKvw4e42v2avsgrsvjhd1edgxf (customer_id),
    KEY FK2xi1gorhp4pd2t5s93r0glekd (end_direction_id),
    KEY FKilaifx4ofb00ednaogofiypn9 (partner_id),
    KEY FKctceyyxlrtekwhnaot1xgnyr9 (start_direction_id),
    KEY FK6fnmjdjln3oexu231vwf1e5kh (vehicle_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

INSERT INTO service
VALUES (1886, _binary '\0', NULL, 0, '2020-05-17 10:24:52', 8, 1887, NULL, 1888, NULL),
       (1891, _binary '\0', NULL, 0, '2020-05-17 10:30:33', 8, 1892, NULL, 1893, NULL),
       (1896, _binary '\0', NULL, 0, '2020-05-17 12:15:36', 8, 1897, NULL, 1898, NULL),
       (1906, _binary '\0', NULL, 0, '2020-05-17 14:30:05', 8, 1907, NULL, 1908, NULL),
       (1910, _binary '', NULL, 0, '2020-05-19 16:43:07', 8, 1911, NULL, 1912, NULL),
       (1972, _binary '\0', NULL, 0, '2020-05-31 22:07:26', 8, 1973, NULL, 1974, NULL),
       (1975, _binary '\0', NULL, 0, '2020-06-01 11:39:49', 8, 1976, NULL, 1977, NULL),
       (1978, _binary '', NULL, 0, '2020-06-02 18:06:20', 8, 1979, NULL, 1980, NULL),
       (2009, _binary '', NULL, 0, '2020-06-04 11:32:05', 29, 2010, 8, 2011, 2028),
       (2014, _binary '', NULL, 0, '2020-06-04 11:43:22', 8, 2015, NULL, 2016, NULL),
       (2019, _binary '\0', NULL, 0, '2020-06-04 11:48:41', 8, 2020, NULL, 2021, NULL),
       (2030, _binary '', NULL, 0, '2020-06-12 18:02:07', 29, 2031, 8, 2032, 104),
       (2035, _binary '', NULL, 0, '2020-06-13 09:01:08', 29, 2036, NULL, 2037, NULL),
       (2046, _binary '\0', NULL, 0, '2020-06-13 16:32:48', 2044, 2047, NULL, 2048, NULL),
       (2050, _binary '', NULL, 0, '2020-06-13 18:14:45', 2044, 2051, 8, 2052, 104);

--
-- Table structure for table `shipment`
--

DROP TABLE IF EXISTS shipment;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE shipment
(
    minimum_price           double  NOT NULL,
    price_shipment          double  NOT NULL,
    shipment_datetime_limit datetime     DEFAULT NULL,
    `status`                varchar(255) DEFAULT NULL,
    `id`                    int(11) NOT NULL,
    destination_user_id     int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY FKtcv1pho8ii2oqc16qan23vulh (destination_user_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment`
--

INSERT INTO shipment
VALUES (5, 0, '2020-05-22 10:24:52', 'DELETED', 1886, 1885),
       (5, 0, '2020-05-22 10:30:33', 'DELETED', 1891, 1885),
       (5, 0, '2020-05-22 12:15:36', 'DELETED', 1896, 1885),
       (5, 0, '2020-05-22 14:30:05', 'DELETED', 1906, 1905),
       (5, 0, '2020-05-24 16:43:07', 'PAID', 1910, 1885),
       (5, 0, '2020-06-09 11:32:05', 'FINISHED', 2009, 2008),
       (5, 0, '2020-06-09 11:43:22', 'PAID', 2014, 2013),
       (5, 0, '2020-06-09 11:48:41', 'DELETED', 2019, 2018),
       (5, 0, '2020-06-18 09:01:08', 'PAID', 2035, 8),
       (5, 0, '2020-06-18 16:32:48', 'DELETED', 2046, 8);

--
-- Table structure for table `shipment_packages`
--

DROP TABLE IF EXISTS shipment_packages;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE shipment_packages
(
    shipment_id int(11) NOT NULL,
    packages_id int(11) NOT NULL,
    PRIMARY KEY (shipment_id, packages_id),
    UNIQUE KEY UK_n41ksgxdhnnj5kvs5vvkhukb2 (packages_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shipment_packages`
--

INSERT INTO shipment_packages
VALUES (1886, 1889),
       (1886, 1890),
       (1891, 1894),
       (1891, 1895),
       (1896, 1903),
       (1906, 1909),
       (1910, 1913),
       (1910, 1914),
       (1910, 1915),
       (2009, 2012),
       (2014, 2017),
       (2019, 2022),
       (2035, 2038),
       (2046, 2049);

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS tag;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE tag
(
    `id`   int(11) NOT NULL,
    `name` varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--


--
-- Table structure for table `transaction`
--

DROP TABLE IF EXISTS transaction;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `transaction`
(
    dtype             varchar(31) NOT NULL,
    `id`              int(11)     NOT NULL,
    active            bit(1)      NOT NULL,
    amount            double      NOT NULL,
    registration_date datetime     DEFAULT NULL,
    `status`          varchar(255) DEFAULT NULL,
    card_id           int(11)      DEFAULT NULL,
    service_id        int(11)      DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY FKc1dpp3bpa7sm3b23ywr1yyvo5 (service_id),
    KEY FK484i2t8acnct6xy8ylevl40go (card_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaction`
--

INSERT INTO transaction
VALUES ('Deposit', 1936, _binary '', 45, '2020-05-26 13:49:14', 'CREATED', 1916, NULL),
       ('Deposit', 1935, _binary '', 23, '2020-05-24 16:57:41', 'CREATED', 1916, NULL),
       ('Payment', 2006, _binary '', -16.1217, '2020-06-03 13:23:59', 'CREATED', NULL, 1978),
       ('Payment', 2005, _binary '', -14.529665, '2020-06-03 13:21:14', 'CREATED', NULL, 1910),
       ('Payment', 2023, _binary '', -6.8, '2020-06-04 11:49:12', 'CREATED', NULL, 2014),
       ('Deposit', 2026, _binary '', 60, '2020-06-04 11:54:05', 'CREATED', 2024, NULL),
       ('Payment', 2027, _binary '', -8.818178, '2020-06-04 11:54:35', 'CREATED', NULL, 2009),
       ('Payment', 2033, _binary '', -16.12275, '2020-06-12 18:02:47', 'CREATED', NULL, 2030),
       ('Deposit', 2034, _binary '', 90, '2020-06-12 19:11:15', 'CREATED', 1918, NULL),
       ('Payment', 2039, _binary '', -9.8623328, '2020-06-13 09:01:43', 'CREATED', NULL, 2035),
       ('Charge', 2042, _binary '', 14.510475, '2020-06-13 11:22:27', 'CREATED', NULL, 2030),
       ('Charge', 2043, _binary '', 8.87609952, '2020-06-13 11:27:34', 'CREATED', NULL, 2035),
       ('Deposit', 2055, _binary '', 35, '2020-06-13 18:27:49', 'CREATED', 2053, NULL),
       ('Payment', 2056, _binary '', -34.6794, '2020-06-13 18:29:01', 'CREATED', NULL, 2050);

--
-- Table structure for table `travel`
--

DROP TABLE IF EXISTS travel;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE travel
(
    distance      double  NOT NULL,
    `end`         datetime     DEFAULT NULL,
    minimum_price double  NOT NULL,
    people        int(11) NOT NULL,
    price_hour    double  NOT NULL,
    price_km      double  NOT NULL,
    price_travel  double  NOT NULL,
    `start`       datetime     DEFAULT NULL,
    `id`          int(11) NOT NULL,
    `status`      varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `travel`
--

INSERT INTO travel
VALUES (34.251, '2020-05-31 20:37:43', 2.4, 3, 20.5, 1.05, 35.96355, '2020-05-31 20:07:00', 1972, 'DELETED'),
       (15.354, '2020-06-02 11:57:45', 2.4, 2, 20.5, 1.05, 16.1217, '2020-06-02 11:39:00', 1975, 'DELETED'),
       (15.354, '2020-05-30 03:24:45', 2.4, 2, 20.5, 1.05, 16.1217, '2020-05-30 03:06:00', 1978, 'PAID'),
       (15.355, '2020-06-13 18:19:31', 2.4, 3, 20.5, 1.05, 16.12275, '2020-06-13 18:01:00', 2030, 'FINISHED'),
       (33.028, '2020-05-19 16:42:02', 2.4, 3, 20.5, 1.05, 34.6794, '2020-05-19 16:15:00', 2050, 'TRANSIT');

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS user;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE `user`
(
    `id`              int(11) NOT NULL,
    active            bit(1)       DEFAULT NULL,
    customer_id       varchar(255) DEFAULT NULL,
    display_name      varchar(255) DEFAULT NULL,
    email             varchar(255) DEFAULT NULL,
    driver_id         varchar(20)  DEFAULT NULL,
    partner_id        varchar(20)  DEFAULT NULL,
    phone             varchar(255) DEFAULT NULL,
    registration_date datetime     DEFAULT NULL,
    uid               varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY UK_bv23tjhe3c029w3d3x0435imy (customer_id) USING HASH,
    UNIQUE KEY UK_ob8kqyqqgmefl0aco34akdtpe (email) USING HASH,
    UNIQUE KEY UK_4yaf6tjm0jduantayvd4bqts8 (driver_id) USING HASH,
    UNIQUE KEY UK_h4ivmkbkxkh2ngoqn3i0tu3ky (partner_id) USING HASH
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

INSERT INTO user
VALUES (8, _binary '', '09012821H', 'Gustavo Gutierrez', 'gusguma@gmail.com', '09012821H', '09012821H', '633927742',
        '2020-04-10 21:03:35', 't6bpbrIi8Ba8C0AxMYL8nWB1mqi2'),
       (29, _binary '', '09012822H', 'Gustavo Gutierrez', 'ggutierrez@urneba.com', NULL, NULL, '633927742',
        '2020-04-13 16:12:38', 'AY5u6E5XdscTFe6HcCZAYYj7u4a2'),
       (2008, _binary '', NULL, 'Carlos Perez', 'carlosperez@gmail.com', NULL, NULL, '622445533',
        '2020-06-04 11:31:49', ''),
       (2013, _binary '', NULL, 'Alfonso Gomez', 'alfonso@gmail.com', NULL, NULL, '622442213', '2020-06-04 11:43:08',
        ''),
       (2018, _binary '', NULL, 'Gustavo Gutierrez', 'rufino@gmail.com', NULL, NULL, '622334422',
        '2020-06-04 11:48:27', ''),
       (2044, _binary '', '46867456P', 'Monica Caballero', 'mocatalydia@gmail.com', NULL, NULL, '633927742',
        '2020-06-13 12:04:21', 'iqWhbvwnI2RpFoDNohr56CZVgIR2'),
       (1885, _binary '', NULL, 'Águeda Martin Blazquez', 'aguedamartin@gmail.com', NULL, NULL, '617552183',
        '2020-05-17 10:24:23', ''),
       (1905, _binary '', NULL, 'Mónica Caballero', 'monicacaballero@gmail.com', NULL, NULL, '633256233',
        '2020-05-17 14:29:49', '');

--
-- Table structure for table `user_directions`
--

DROP TABLE IF EXISTS user_directions;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE user_directions
(
    user_id       int(11) NOT NULL,
    directions_id int(11) NOT NULL,
    PRIMARY KEY (user_id(11), directions_id(11)),
    UNIQUE KEY UK_f4lm9n4p4xr3p420135h1sy4y (directions_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_directions`
--

INSERT INTO user_directions
VALUES (8, 47),
       (8, 50),
       (29, 2007),
       (2044, 2045);

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS user_roles;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE user_roles
(
    user_id int(11) NOT NULL,
    roles   varchar(255) DEFAULT NULL,
    KEY FK55itppkw3i07do3h7qoclqd4k (user_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

INSERT INTO user_roles
VALUES (8, 'USER'),
       (8, 'CUSTOMER'),
       (29, 'USER'),
       (8, 'PARTNER'),
       (1885, 'USER'),
       (1884, 'USER'),
       (1905, 'USER'),
       (29, 'CUSTOMER'),
       (2008, 'USER'),
       (2013, 'USER'),
       (2018, 'USER'),
       (2044, 'USER'),
       (2044, 'CUSTOMER');

--
-- Table structure for table `user_vehicles`
--

DROP TABLE IF EXISTS user_vehicles;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE user_vehicles
(
    user_id     int(11) NOT NULL,
    vehicles_id int(11) NOT NULL,
    PRIMARY KEY (user_id, vehicles_id),
    UNIQUE KEY UK_9j5jv72lre66julwmi3hx5bxb (vehicles_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_vehicles`
--

INSERT INTO user_vehicles
VALUES (8, 104),
       (8, 2028);

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS vehicle;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE vehicle
(
    dtype             varchar(31)  NOT NULL,
    `id`              int(11)      NOT NULL,
    active            bit(1)       DEFAULT NULL,
    `name`            varchar(255) NOT NULL,
    registration      varchar(255) DEFAULT NULL,
    registration_date datetime     DEFAULT NULL,
    max_high          double       DEFAULT NULL,
    max_lenght        double       DEFAULT NULL,
    max_volume        double       DEFAULT NULL,
    max_weight        double       DEFAULT NULL,
    max_width         double       DEFAULT NULL,
    places_available  int(11)      DEFAULT NULL,
    vehicle_type_enum varchar(255) DEFAULT NULL,
    description       varchar(255) DEFAULT NULL,
    make              varchar(255) DEFAULT NULL,
    model             varchar(255) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY UK_tjmofyrt4whp0m1vaql9njjdo (registration) USING HASH
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

INSERT INTO vehicle
VALUES ('Car', 2028, _binary '', 'Mi Coche', '3486CJY', '2020-06-10 08:57:36', 200, 200, 0.5, 250, 200, 4, 'CAR',
        'mi Coche', 'Alfa Romeo', '147'),
       ('Car', 2029, _binary '', 'hhhhh', 'bbbbj', '2020-06-10 13:46:16', 200, 200, 0.5, 250, 200, 4, 'CAR', 'bbbjjj',
        'bbbbjj', 'hhjjj'),
       ('Bike', 104, _binary '', 'mi bicicleta', NULL, '2020-05-10 12:03:20', 50, 50, 0.13, 15, 50, 0, 'BIKE',
        'la bici', 'Campagnolo', NULL);

--
-- Table structure for table `wallet`
--

DROP TABLE IF EXISTS wallet;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE wallet
(
    `id`              int(11) NOT NULL,
    active            bit(1)  NOT NULL,
    balance           double  NOT NULL,
    registration_date datetime DEFAULT NULL,
    user_id           int(11)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY FKbs4ogwiknsup4rpw8d47qw9dx (user_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet`
--

INSERT INTO wallet
VALUES (1934, _binary '', 143.93520952, '2020-05-24 18:57:41', 8),
       (2025, _binary '', 25.196739199999996, '2020-06-04 11:54:06', 29),
       (2054, _binary '', 0.3205999999999989, '2020-06-13 18:27:50', 2044);

--
-- Table structure for table `wallet_transactions`
--

DROP TABLE IF EXISTS wallet_transactions;
/*!40101 SET @saved_cs_client = @@character_set_client */;
SET character_set_client = utf8mb4;
CREATE TABLE wallet_transactions
(
    wallet_id       int(11) NOT NULL,
    transactions_id int(11) NOT NULL,
    PRIMARY KEY (wallet_id, transactions_id),
    UNIQUE KEY UK_ih1d10xdrgoibf7na9f3lcb1 (transactions_id)
) ENGINE = MyISAM
  DEFAULT CHARSET = utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `wallet_transactions`
--

INSERT INTO wallet_transactions
VALUES (1934, 1935),
       (1934, 1936),
       (1934, 1956),
       (1934, 1981),
       (1934, 1982),
       (1934, 1983),
       (1934, 1984),
       (1934, 1985),
       (1934, 1986),
       (1934, 1987),
       (1934, 1988),
       (1934, 1990),
       (1934, 1991),
       (1934, 1992),
       (1934, 1994),
       (1934, 1995),
       (1934, 1996),
       (1934, 1997),
       (1934, 1998),
       (1934, 1999),
       (1934, 2000),
       (1934, 2001),
       (1934, 2002),
       (1934, 2003),
       (1934, 2004),
       (1934, 2005),
       (1934, 2006),
       (1934, 2023),
       (1934, 2034),
       (1934, 2040),
       (1934, 2041),
       (1934, 2042),
       (1934, 2043),
       (2025, 2026),
       (2025, 2027),
       (2025, 2033),
       (2025, 2039),
       (2054, 2055),
       (2054, 2056);
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed
