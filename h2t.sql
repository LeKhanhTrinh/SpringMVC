-- phpMyAdmin SQL Dump
-- version 4.1.6
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 11, 2014 at 11:05 AM
-- Server version: 5.6.16
-- PHP Version: 5.5.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`h2t` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `h2t`;
--
-- Database: `h2t`
--

-- --------------------------------------------------------
--
-- Table structure for table `contacts`
--

CREATE TABLE IF NOT EXISTS `contacts` (
  `customerNumber` int(11) NOT NULL,
  `contactNumber` int(50) NOT NULL AUTO_INCREMENT,
  `contactName` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `jobTitle` varchar(15) DEFAULT NULL,
  `isMain` tinyint(1) NOT NULL,
  PRIMARY KEY (`contactNumber`),
  KEY `contact_fk` (`customerNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=30 ;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`customerNumber`, `contactNumber`, `contactName`, `phone`, `email`, `jobTitle`, `isMain`) VALUES
(1, 1, 'vmmvb', '0904602582', 'huong@qsoft.com', 'management', 1),
(1, 2, 'dqwđ', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(2, 3, 'dqwdasd', '0904602582', 'huong@qsoft.com', 'management', 1),
(2, 4, 'qwdqd', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(3, 5, 'ádsdfasdfasdf', '0904602582', 'huong@qsoft.com', 'management', 1),
(3, 6, 'dcqwd', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(1, 7, 'dqwdqwd', '0904602582', 'huong@qsoft.com', 'employee', 0),
(1, 8, 'dqwdqa', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(5, 9, 'ừaafsdfafas', '0904602582', 'huong@qsoft.com', 'management', 1),
(5, 10, 'dqwdqdoa', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(6, 11, 'ádfsdaasdfsdf', '0904602582', 'huong@qsoft.com', 'management', 1),
(6, 12, 'dqwdwqda', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(7, 13, 'mcvasdfasdf', '0904602582', 'huong@qsoft.com', 'management', 1),
(7, 14, 'dfwqdewdsaa', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(8, 15, 'gádfasdsdfasdf', '0904602582', 'huong@qsoft.com', 'management', 1),
(8, 16, 'huorqwefng hoaqưer', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(9, 17, 'dấdca', '0904602582', 'huong@qsoft.com', 'management', 1),
(9, 18, 'huong hoafasdfasdfq', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(10, 19, 'dqwđ', '0904602582', 'huong@qsoft.com', 'management', 1),
(10, 20, 'huong hoaádfdfasfasf', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(4, 27, 'dqwdqwd', '0904602582', 'huong@qsoft.com', 'management', 1),
(4, 28, 'huong hoa213313', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(1, 29, 'dsaf', 'fad', 'fasd', 'fdas', 1);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `customerNumber` int(11) NOT NULL AUTO_INCREMENT,
  `avataLink` varchar(300) DEFAULT NULL,
  `customerName` varchar(50) NOT NULL,
  `phone` varchar(50) NOT NULL,
  `address` varchar(50) NOT NULL,
  `fax` varchar(15) DEFAULT NULL,
  `emailCustomer` varchar(50) NOT NULL,
  PRIMARY KEY (`customerNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

--
-- Dumping data for table `customers`
--

INSERT INTO `customers` (`customerNumber`, `avataLink`, `customerName`, `phone`, `address`, `fax`, `emailCustomer`) VALUES
(1, 'http://s3.amazonaws.com/crunchbase_prod_assets/assets/images/resized/0015/3878/153878v2-max-250x250.png', 'QSoftVietnam', '(+844) 3792 5148', 'Nbr 22, road number 3, Tran Thai Tong Street, Cau ', '+84 4 666 999', ' contact@qsoftvietnam.com'),
(2, 'http://s3.amazonaws.com/crunchbase_prod_assets/assets/images/resized/0015/3878/153878v2-max-250x250.png', 'Công ty Cổ Phần Viễn Thông FPT', ' +84 4 73007300', 'Trụ sở chính: Tòa nhà FPT, lô B2  Phố Duy Tân  Đườ', '+84 4 37687410', 'contact@fpt.com'),
(3, 'http://www.qsoftvietnam.com/images/banner/1281685557_home_design.jpg', 'VNPT', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street, Cau ', '+84 4 666 999', ' contact@vnpt.com'),
(4, 'http://www.qsoftvietnam.com/images/banner/1277964490_mobile_application.jpg', 'Viettel Telecom', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street', '+84 4 666 999', ' contact@viettel.com'),
(5, 'http://www.qsoftvietnam.com/images/banner/1277964490_mobile_application.jpg', 'Vinova', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street, Cau ', '+84 4 666 999', ' contact@vinova.com'),
(6, 'http://www.qsoftvietnam.com/images/banner/1277964490_mobile_application.jpg', 'Vinova', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street, Cau ', '+84 4 666 999', ' contact@vinova.com'),
(7, 'http://www.qsoftvietnam.com/images/banner/1277964490_mobile_application.jpg', 'Seta', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street, Cau ', '+84 4 666 999', ' contact@seta.com'),
(8, 'http://www.qsoftvietnam.com/images/banner/1277964490_mobile_application.jpg', 'SmartOS', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street, Cau ', '+84 4 666 999', ' contact@smartos.com'),
(9, 'http://www.qsoftvietnam.com/images/banner/1277964490_mobile_application.jpg', 'FIS', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street, Cau ', '+84 4 666 999', ' contact@fis.com'),
(10, NULL, 'Fsoft', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street, Cau ', '+84 4 666 999', ' contact@fisoft.com');

-- --------------------------------------------------------

--
-- Table structure for table `orderdetails`
--

CREATE TABLE IF NOT EXISTS `orderdetails` (
  `orderNumber` int(11) NOT NULL,
  `serial` varchar(15) NOT NULL,
  `quantityOrdered` int(11) DEFAULT NULL,
  `priceEach` double DEFAULT NULL,
  PRIMARY KEY (`orderNumber`,`serial`),
  KEY `serial` (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`orderNumber`, `serial`, `quantityOrdered`, `priceEach`) VALUES
(1, '111', 10, 500),
(1, '115', 10, 500),
(2, '113', 20, 600),
(4, '113', 3, 200),
(4, '114', 2, 500),
(4, '115', 3, 900),
(4, '116', 3, 900),
(5, '221', 5, 800),
(6, '222', 4, 900),
(7, '222', 4, 900);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE IF NOT EXISTS `orders` (
  `orderNumber` int(11) NOT NULL AUTO_INCREMENT,
  `contactNumber` int(50) NOT NULL,
  `creationDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  PRIMARY KEY (`orderNumber`,`contactNumber`),
  KEY `contactNumber` (`contactNumber`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=31 ;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orderNumber`, `contactNumber`, `creationDate`, `updateDate`) VALUES
(1, 1, '2014-04-01', '2014-04-03'),
(2, 1, '2014-04-17', '2014-04-16'),
(3, 3, '2014-04-25', '2014-04-26'),
(4, 2, '2014-04-02', '2014-04-16'),
(5, 2, '2014-04-01', '2014-04-03'),
(6, 2, '2014-04-17', '2014-04-16'),
(7, 1, '2014-04-25', '2014-04-26'),
(8, 8, '2014-04-02', '2014-04-16'),
(9, 6, '2014-04-01', '2014-04-03'),
(10, 6, '2014-04-17', '2014-04-16'),
(11, 7, '2014-04-25', '2014-04-26'),
(12, 7, '2014-04-02', '2014-04-16'),
(13, 8, '2014-04-01', '2014-04-03'),
(14, 8, '2014-04-17', '2014-04-16'),
(15, 9, '2014-04-25', '2014-04-26'),
(16, 9, '2014-04-02', '2014-04-16'),
(17, 10, '2014-04-01', '2014-04-03'),
(18, 10, '2014-04-17', '2014-04-16'),
(19, 11, '2014-04-25', '2014-04-26'),
(20, 11, '2014-04-02', '2014-04-16'),
(21, 12, '2014-04-25', '2014-04-26'),
(22, 12, '2014-04-02', '2014-04-16'),
(23, 13, '2014-04-01', '2014-04-03'),
(24, 13, '2014-04-17', '2014-04-16'),
(25, 14, '2014-04-25', '2014-04-26'),
(26, 14, '2014-04-02', '2014-04-16'),
(27, 15, '2014-04-01', '2014-04-03'),
(28, 15, '2014-04-17', '2014-04-16'),
(29, 16, '2014-04-25', '2014-04-26'),
(30, 16, '2014-04-02', '2014-04-16');

-- --------------------------------------------------------

--
-- Table structure for table `productlines`
--

CREATE TABLE IF NOT EXISTS `productlines` (
  `idProductLine` varchar(50) NOT NULL,
  `name` varchar(4000) DEFAULT NULL,
  `textDescription` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`idProductLine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `productlines`
--

INSERT INTO `productlines` (`idProductLine`, `name`, `textDescription`) VALUES
('8DH', 'Máy cắt cỏ ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('97D', 'Máy cắt cỏ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('G4', 'Máy cắt cỏ ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('JUY', 'Máy cắt cỏ ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('KD7', 'Máy cắt cỏ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('KDJH9', 'Máy cắt cỏ ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('MHY1', 'Máy cắt cỏ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('ODH7', 'Máy cắt cỏ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('OPAD0', 'Máy cắt cỏ ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('T4', 'Máy cắt cỏ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('T4-M2', 'Máy cắt cỏ ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('UAS8', 'Máy cắt cỏ ', 'Máy cắt cỏ Husqvarna Rider 16C AWD');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE IF NOT EXISTS `products` (
  `serial` varchar(15) NOT NULL,
  `productName` varchar(70) NOT NULL,
  `idProductLine` varchar(50) NOT NULL,
  `model` varchar(10) NOT NULL,
  `years` int(11) NOT NULL,
  PRIMARY KEY (`serial`),
  KEY `idProductLine` (`idProductLine`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`serial`, `productName`, `idProductLine`, `model`, `years`) VALUES
('111', 'Máy cắt cỏ Husqvarna Rider 16C AWD', 'T4', 'Husqvarna', 1990),
('113', 'Máy cắt cỏ đẩy tay Yinxiang YXGC-215', 'T4', 'YXGD', 1999),
('114', 'Máy cắt cỏ Husqvarna Rider 16C AWD', 'T4', 'Husqvarna', 1990),
('115', 'Máy cắt cỏ đẩy tay Yinxiang YXGC-215', 'T4', 'YXGD', 1999),
('116', 'Máy cắt cỏ đẩy tay Yinxiang YXGC-215', 'T4', 'YXGD', 1999),
('221', 'Máy cắt cỏ', 'T4-M2', 'H2M1', 2001),
('222', 'Máy cắt cỏ', 'T4-M2', 'H2M2', 2000),
('223', 'Máy cắt cỏ', 'T4-M2', 'H2M1', 2001),
('224', 'Máy cắt cỏ', 'T4-M2', 'H2M2', 2000),
('300', 'Máy cắt cỏ Husqvarna Rider 16C AWD', '8DH', 'Husqvarna', 1990),
('301', 'Máy cắt cỏ đẩy tay Yinxiang YXGC-215', '8DH', 'YXGD', 1999),
('302', 'Máy cắt cỏ', '97D', 'H2M1', 2001),
('303', 'Máy cắt cỏ', '97D', 'H2M2', 2000),
('304', 'Máy cắt cỏ Husqvarna Rider 16C AWD', 'G4', 'Husqvarna', 1990),
('305', 'Máy cắt cỏ đẩy tay Yinxiang YXGC-215', 'G4', 'YXGD', 1999),
('306', 'Máy cắt cỏ', 'JUY', 'H2M1', 2001),
('307', 'Máy cắt cỏ', 'JUY', 'H2M2', 2000),
('308', 'Máy cắt cỏ Husqvarna Rider 16C AWD', 'KD7', 'Husqvarna', 1990),
('309', 'Máy cắt cỏ đẩy tay Yinxiang YXGC-215', 'KD7', 'YXGD', 1999),
('310', 'Máy cắt cỏ', 'KDJH9', 'H2M1', 2001),
('311', 'Máy cắt cỏ', 'KDJH9', 'H2M2', 2000),
('312', 'Máy cắt cỏ Husqvarna Rider 16C AWD', 'MHY1', 'Husqvarna', 1990),
('313', 'Máy cắt cỏ đẩy tay Yinxiang YXGC-215', 'MHY1', 'YXGD', 1999),
('314', 'Máy cắt cỏ', 'ODH7', 'H2M1', 2001),
('315', 'Máy cắt cỏ', 'ODH7', 'H2M2', 2000),
('316', 'Máy cắt cỏ Husqvarna Rider 16C AWD', 'OPAD0', 'Husqvarna', 1990),
('317', 'Máy cắt cỏ đẩy tay Yinxiang YXGC-215', 'OPAD0', 'YXGD', 1999),
('318', 'Máy cắt cỏ', 'UAS8', 'H2M1', 2001),
('319', 'Máy cắt cỏ', 'UAS8', 'H2M2', 2000);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `contacts`
--
ALTER TABLE `contacts`
  ADD CONSTRAINT `contact_fk` FOREIGN KEY (`customerNumber`) REFERENCES `customers` (`customerNumber`);

--
-- Constraints for table `orderdetails`
--
ALTER TABLE `orderdetails`
  ADD CONSTRAINT `orderdetails_ibfk_1` FOREIGN KEY (`orderNumber`) REFERENCES `orders` (`orderNumber`),
  ADD CONSTRAINT `orderdetails_ibfk_2` FOREIGN KEY (`serial`) REFERENCES `products` (`serial`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`contactNumber`) REFERENCES `contacts` (`contactNumber`);

--
-- Constraints for table `products`
--
ALTER TABLE `products`
  ADD CONSTRAINT `products_ibfk_1` FOREIGN KEY (`idProductLine`) REFERENCES `productlines` (`idProductLine`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
