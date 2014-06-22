-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 13, 2014 at 08:55 AM
-- Server version: 5.5.32
-- PHP Version: 5.4.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `aws_clinic`
--
CREATE DATABASE IF NOT EXISTS `aws_clinic` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `aws_clinic`;

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `searchpetbyid`(in petid int)
begin
	select * from pet
	where pet_id = ifnull(petid,pet_id);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `searchpetbyname`(in petname char)
begin
	select * from pet
	where Pet_name = ifnull(petnamem,Pet_name);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `searchvisitbypetid`(in petid int)
begin 
	select * from pet_visit
	where pet_id = ifnull(petid,pet_id);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showowners`(in ownername char)
begin 
	select last_name from owner
	where last_name = ifnull(ownername,last_name);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showpetsbyownerid`(in ownerid int)
begin
	select * from pet
	where pet_owner = ownerid;
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `showpettypes`(in typename char)
begin 
	select Type_Name from pet_type
	where Type_Name = ifnull(typename,Type_Name);
end$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE IF NOT EXISTS `owner` (
  `Owner_Id` int(11) NOT NULL AUTO_INCREMENT,
  `First_Name` varchar(60) NOT NULL,
  `Last_Name` varchar(60) NOT NULL,
  `Contact_Number` char(20) DEFAULT NULL,
  `Address` char(50) DEFAULT NULL,
  PRIMARY KEY (`Owner_Id`),
  UNIQUE KEY `Owner_Id_UNIQUE` (`Owner_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`Owner_Id`, `First_Name`, `Last_Name`, `Contact_Number`, `Address`) VALUES
(1, 'Thomas', 'Montilla', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `pet`
--

CREATE TABLE IF NOT EXISTS `pet` (
  `Pet_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Pet_Name` varchar(60) NOT NULL,
  `Pet_Type` int(11) NOT NULL,
  `Pet_Age` int(11) NOT NULL,
  `Pet_Owner` int(11) NOT NULL,
  PRIMARY KEY (`Pet_Id`),
  UNIQUE KEY `Pet_Id_UNIQUE` (`Pet_Id`),
  KEY `Pet_Type_idx` (`Pet_Type`),
  KEY `Pet_Owner_idx` (`Pet_Owner`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `pet`
--

INSERT INTO `pet` (`Pet_Id`, `Pet_Name`, `Pet_Type`, `Pet_Age`, `Pet_Owner`) VALUES
(1, 'Dougie', 1, 1, 1),
(2, 'Papi', 1, 1, 1),
(3, 'Eden', 1, 20, 1),
(4, 'Bebe', 1, 20, 1),
(5, 'Cris', 1, 20, 1),
(6, 'Fretz', 1, 20, 1);

-- --------------------------------------------------------

--
-- Table structure for table `pet_type`
--

CREATE TABLE IF NOT EXISTS `pet_type` (
  `Type_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Type_Name` varchar(60) NOT NULL,
  PRIMARY KEY (`Type_Id`),
  UNIQUE KEY `Type_Id_UNIQUE` (`Type_Id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `pet_type`
--

INSERT INTO `pet_type` (`Type_Id`, `Type_Name`) VALUES
(1, 'Dog');

-- --------------------------------------------------------

--
-- Table structure for table `pet_visit`
--

CREATE TABLE IF NOT EXISTS `pet_visit` (
  `Pet_Id` int(11) NOT NULL,
  `Visit_Date` date NOT NULL,
  `Procedure_Number` int(11) NOT NULL,
  KEY `Procedure_Number_idx` (`Procedure_Number`),
  KEY `Pet_Id` (`Pet_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `procedure`
--

CREATE TABLE IF NOT EXISTS `procedures` (
  `Procedure_Id` int(11) NOT NULL AUTO_INCREMENT,
  `Procedure_Name` varchar(60) NOT NULL,
  `Charge` decimal(10,2) NOT NULL,
  PRIMARY KEY (`Procedure_Id`),
  UNIQUE KEY `Procedure_Id_UNIQUE` (`Procedure_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `pet`
--
ALTER TABLE `pet`
  ADD CONSTRAINT `Pet_Owner` FOREIGN KEY (`Pet_Owner`) REFERENCES `owner` (`Owner_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Pet_Type` FOREIGN KEY (`Pet_Type`) REFERENCES `pet_type` (`Type_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pet_visit`
--
ALTER TABLE `pet_visit`
  ADD CONSTRAINT `Pet_Id` FOREIGN KEY (`Pet_Id`) REFERENCES `pet` (`Pet_Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `Procedure_Number` FOREIGN KEY (`Procedure_Number`) REFERENCES `procedures` (`Procedure_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
