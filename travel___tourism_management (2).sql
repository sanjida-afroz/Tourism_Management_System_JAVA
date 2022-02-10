-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 23, 2019 at 05:10 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `travel_&_tourism_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `admin_id` int(10) NOT NULL,
  `email` varchar(30) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`admin_id`, `email`, `password`) VALUES
(1, 'mrh2@gmail.com', '12345');

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(10) NOT NULL,
  `c_id` int(10) NOT NULL,
  `package_id` int(10) DEFAULT NULL,
  `ticket_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `c_id`, `package_id`, `ticket_id`) VALUES
(6, 1, NULL, 2),
(7, 1, 2, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `c_id` int(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `mobile_no` varchar(14) NOT NULL,
  `address` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`c_id`, `name`, `email`, `gender`, `mobile_no`, `address`, `password`) VALUES
(1, 'Mohaiminul Rahman', 'hridoy@gmail.com', 'Male', '+8801937818192', 'Savar', '121314'),
(2, 'Shifat Khan', 'sh@gmail.com', 'Male', '01910200871', 'Savar', '9090'),
(3, 'Umar', 'um@gmail.com', 'Male', '01819151750', 'Savar', '123456'),
(7, 'Luna akhter', 'luna@gmail.com', 'Female', '+8801705161717', 'Savar', '098765'),
(10, 'MUSHFIQ CHY', 'mushi@gmail.com', 'Male', '01515699557', 'bashundara', '1234567'),
(11, 'Shimu', 's@gmail.com', 'Female', '01623678904', 'Kuratoli', '666666');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `pay_id` int(10) NOT NULL,
  `c_id` int(10) NOT NULL,
  `package_id` int(10) DEFAULT NULL,
  `ticket_id` int(10) DEFAULT NULL,
  `total_amount` int(20) NOT NULL,
  `paid` int(20) NOT NULL,
  `due` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`pay_id`, `c_id`, `package_id`, `ticket_id`, `total_amount`, `paid`, `due`) VALUES
(5, 1, NULL, 2, 600, 600, 0),
(6, 1, 7, NULL, 7000, 6000, 1000);

-- --------------------------------------------------------

--
-- Table structure for table `route`
--

CREATE TABLE `route` (
  `route_id` int(10) NOT NULL,
  `type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `route`
--

INSERT INTO `route` (`route_id`, `type`) VALUES
(1, 'By Road'),
(2, 'By Air'),
(3, 'By River');

-- --------------------------------------------------------

--
-- Table structure for table `ticket`
--

CREATE TABLE `ticket` (
  `ticket_id` int(10) NOT NULL,
  `departure_from` varchar(30) NOT NULL,
  `destination` varchar(30) NOT NULL,
  `fare` int(10) NOT NULL,
  `departure_time` varchar(100) NOT NULL,
  `route_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ticket`
--

INSERT INTO `ticket` (`ticket_id`, `departure_from`, `destination`, `fare`, `departure_time`, `route_id`) VALUES
(1, 'DHAKA', 'COXS BAZAR', 700, '28TH DECEMBER, 10.45 PM FROM GABTOLI', 1),
(2, 'DHAKA', 'SHYLET', 600, '28TH DECEMBER, 10.45 PM FROM GABTOLI', 1),
(3, 'DHAKA', 'KHULNA', 450, '27TH DECEMBER, 10.45 PM FROM GABTOLI', 1),
(4, 'DHAKA', 'BARISHAL', 600, '27TH DECEMBER, 10 PM FROM GABTOLI', 1),
(5, 'DHAKA', 'CHITTAGONG', 1500, '27TH DECEMBER, 10 PM FROM SAHAJALAL INTERNATIONAL AIRPORT', 2),
(6, 'DHAKA', 'BARISHAL', 1500, '27TH DECEMBER, 10 PM FROM SAHAJALAL INTERNATIONAL AIRPORT', 2),
(7, 'DHAKA', 'BARISHAL', 1000, '27TH DECEMBER, 10 PM FROM SADARGHAT', 3);

-- --------------------------------------------------------

--
-- Table structure for table `tour_package`
--

CREATE TABLE `tour_package` (
  `package_id` int(10) NOT NULL,
  `package_des` varchar(50) NOT NULL,
  `cost` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tour_package`
--

INSERT INTO `tour_package` (`package_id`, `package_des`, `cost`) VALUES
(2, '2days,2night tour in shundarbans', 7000),
(3, '3days,2night tour in shundarbans', 8500),
(4, '2days,2night tour in Coxs Bazar', 10000),
(5, '3days,2night tour in Coxs Bazar', 14000),
(6, '3days,2night tour in Coxs Bazar for 2 persons', 25000),
(7, '3days,2night tour in Shyletr for 2 persons', 22000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`admin_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `c_id` (`c_id`),
  ADD KEY `package_id` (`package_id`),
  ADD KEY `ticket_id` (`ticket_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`c_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `password` (`password`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`pay_id`),
  ADD KEY `c_id` (`c_id`),
  ADD KEY `package_id` (`package_id`),
  ADD KEY `ticket_id` (`ticket_id`);

--
-- Indexes for table `route`
--
ALTER TABLE `route`
  ADD PRIMARY KEY (`route_id`);

--
-- Indexes for table `ticket`
--
ALTER TABLE `ticket`
  ADD PRIMARY KEY (`ticket_id`),
  ADD KEY `route_id` (`route_id`);

--
-- Indexes for table `tour_package`
--
ALTER TABLE `tour_package`
  ADD PRIMARY KEY (`package_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `admin_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `c_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `pay_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
