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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `contacts`
--

INSERT INTO `contacts` (`customerNumber`, `contactNumber`, `contactName`, `phone`, `email`, `jobTitle`, `isMain`) VALUES
(1, 1, 'huong hoa', '0904602582', 'huong@qsoft.com', 'management', 1),
(1, 2, 'huong hoa', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(2, 3, 'huong hoa', '0904602582', 'huong@qsoft.com', 'management', 1),
(2, 4, 'huong hoa', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(3, 5, 'huong hoa', '0904602582', 'huong@qsoft.com', 'management', 1),
(3, 6, 'huong hoa', '0904602582', 'hoa@qsoft.com', 'employee', 0),
(1, 7, 'huong hoa', '0904602582', 'huong@qsoft.com', 'management', 1),
(1, 8, 'huong hoa', '0904602582', 'hoa@qsoft.com', 'employee', 0);

-- --------------------------------------------------------

--
-- Table structure for table `customers`
--

CREATE TABLE IF NOT EXISTS `customers` (
  `customerNumber` int(11) NOT NULL AUTO_INCREMENT,
  `avataLink` varchar(100) DEFAULT NULL,
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
(1, 'http://www.qsoftvietnam.com/themes/qsoft_revamp10/images/qs_logo.gif', 'QSoftVietnam', '(+844) 3792 5148', 'Nbr 22, road number 3, Tran Thai Tong Street, Cau ', '+84 4 666 999', ' contact@qsoftvietnam.com'),
(2, 'http://www.qsoftvietnam.com/themes/qsoft_revamp10/images/qs_logo.gif', 'Công ty Cổ Phần Viễn Thông FPT', ' +84 4 73007300', 'Trụ sở chính: Tòa nhà FPT, lô B2  Phố Duy Tân  Đườ', '+84 4 37687410', 'contact@fpt.com'),
(3, 'http://www.qsoftvietnam.com/images/banner/1281685557_home_design.jpg', 'VNPT', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street, Cau ', '+84 4 666 999', ' contact@vnpt.com'),
(4, 'http://www.qsoftvietnam.com/images/banner/1277964490_mobile_application.jpg', 'Viettel Telecom', '(+844) 3792 5148', 'Nbr 22, road number 3, Cau Giay Street', '+84 4 666 999', ' contact@viettel.com'),
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
  `description` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`orderNumber`,`serial`),
  KEY `serial` (`serial`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orderdetails`
--

INSERT INTO `orderdetails` (`orderNumber`, `serial`, `quantityOrdered`, `priceEach`, `description`) VALUES
(1, '111', 10, 500, 'Loại động cơ: Xăng 4 thì .  Model động cơ: GCV160 (HONDA-JAPAN).  Công suất: 5.5Hp.  Dung tích'),
(2, '113', 20, 600, 'Loại động cơ: Xăng 4 thì .  Model động cơ: GCV160 (HONDA-JAPAN).  Công suất: 5.5Hp.  Dung tích');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`orderNumber`, `contactNumber`, `creationDate`, `updateDate`) VALUES
(1, 1, '2014-04-01', '2014-04-03'),
(2, 1, '2014-04-17', '2014-04-16'),
(3, 3, '2014-04-25', '2014-04-26'),
(4, 2, '2014-04-02', '2014-04-16');

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
('T4', 'Máy cắt cỏ', 'Máy cắt cỏ Husqvarna Rider 16C AWD'),
('T4-M2', 'Máy cắt cỏ ', 'Máy cắt cỏ Husqvarna Rider 16C AWD');

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
('221', 'Máy cắt cỏ', 'T4-M2', 'H2M1', 2001),
('222', 'Máy cắt cỏ', 'T4-M2', 'H2M2', 2000);

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
