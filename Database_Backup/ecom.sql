-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 29, 2018 at 07:55 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecom`
--

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

CREATE TABLE `login` (
  `LogInID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`LogInID`, `Name`, `Password`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `ProductType` varchar(30) NOT NULL,
  `Price` float NOT NULL,
  `ProfitPercentage` float NOT NULL,
  `Action` varchar(30) NOT NULL DEFAULT 'DELETE'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`ID`, `Name`, `ProductType`, `Price`, `ProfitPercentage`, `Action`) VALUES
(7, 'Gigabyte B360 HD3 8th Gen DDR4 Motherboard', 'MOTHERBOARD', 9500, 0.05, 'DELETE'),
(8, 'Gigabyte B360M HD3 8th Gen Motherboard', 'MOTHERBOARD', 7900, 0.05, 'DELETE');

-- --------------------------------------------------------

--
-- Table structure for table `productsolds`
--

CREATE TABLE `productsolds` (
  `ID` int(11) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `ProductType` varchar(30) NOT NULL,
  `Price` float NOT NULL,
  `Profit` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `productsolds`
--

INSERT INTO `productsolds` (`ID`, `Name`, `ProductType`, `Price`, `Profit`) VALUES
(1, 'Leven 4GB DDR3  Desktop Ram', 'RAM', 2400, 48),
(2, 'Zotac GeForce GT 710 2GB DDR3', 'GRAPHICS CARD', 1200, 120),
(3, 'Twinmos 4GB DDR3 1600 BUS Desktop RAM', 'RAM', 2900, 58),
(4, 'ASRock H110M-HDV Micro ATX DDR4 Motherboard', 'MOTHERBOARD', 5400, 270),
(5, 'Gigabyte B360M-DS3H 8th Gen Motherboard', 'MOTHERBOARD', 8600, 430);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`LogInID`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `productsolds`
--
ALTER TABLE `productsolds`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `login`
--
ALTER TABLE `login`
  MODIFY `LogInID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT for table `productsolds`
--
ALTER TABLE `productsolds`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
