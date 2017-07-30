-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jul 30, 2017 at 12:22 PM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";
 

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task_management_system`
--

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `Deadline` varchar(255) DEFAULT NULL,
  `createdBy` int(11) NOT NULL,
  `createdDate` datetime DEFAULT NULL,
  `taskDesp` varchar(255) DEFAULT NULL,
  `assignedTo` int(11) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT 'pending',
  `remark` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`id`, `Deadline`, `createdBy`, `createdDate`, `taskDesp`, `assignedTo`, `title`, `status`, `remark`) VALUES
(2, '2017-07-12', 12, '2017-07-25 12:51:38', 'w', 4, 'Title', 'complete', 'fsdc 11'),
(3, '2017-06-28', 12, '2017-07-25 12:52:32', 's', 4, 's', 'complete', 'remark'),
(4, '2017-06-28', 12, '2017-07-25 12:52:33', 's', 4, 's', 'incomplete', NULL),
(5, NULL, 12, '2017-07-27 11:44:33', NULL, 4, NULL, NULL, NULL),
(6, '2017-01-01 00:00:00', 12, '2017-07-27 12:48:57', 'ewsd', 4, 'efdsc', NULL, NULL),
(7, '2017-07-18 00:00:00', 12, '2017-07-27 12:58:43', 'dfc', 4, 'sfd', 'pending', NULL),
(8, '2017-07-18 00:00:00', 12, '2017-07-27 12:59:58', 'rkjf', 4, 'rkfjvcx', 'pending', NULL),
(9, '2017-07-11 00:00:00', 12, '2017-07-30 10:37:05', 'task12', 13, 'new task', 'incomplete', 'rmakrs');

-- --------------------------------------------------------

--
-- Table structure for table `task_admin`
--

CREATE TABLE `task_admin` (
  `taskId` int(11) NOT NULL,
  `admin_id` int(11) NOT NULL,
  `assignedDate` datetime DEFAULT NULL,
  `remarks` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `task_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `uploadfiles`
--

CREATE TABLE `uploadfiles` (
  `fileId` int(11) NOT NULL,
  `adminId` int(11) NOT NULL,
  `fileName` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users_tbl`
--

CREATE TABLE `users_tbl` (
  `adminId` int(11) NOT NULL,
  `adminType` varchar(255) DEFAULT NULL,
  `createdDate` datetime DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users_tbl`
--

INSERT INTO `users_tbl` (`adminId`, `adminType`, `createdDate`, `password`, `status`, `username`) VALUES
(4, 'Admin', NULL, '$2a$12$ZkPzeZpA9X8P/2/tEY4Ejuj0ngSXZXdqJxkm.125OEFv/6yQYp3xi', NULL, 'e'),
(12, 'Super Admin', NULL, '$2a$12$qWvuov2d0KzSHkHaOYwUyOq06XAycniQTmRjeIai4fnxumYmenRSy', NULL, 'a'),
(13, 'Admin', NULL, '$2a$12$F07WFRmBOpmf.L5VI48xNeiFdwzKWPV.Z08bCowKwc/lDyZ2BVzn2', NULL, 'erika'),
(14, 'Super Admin', NULL, '$2a$12$NfmVHLtpcsbqxWj96i2Fi.LzAD7krHbL57ZttcxYGqt4za4bnutzy', NULL, 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `task_admin`
--
ALTER TABLE `task_admin`
  ADD PRIMARY KEY (`taskId`);

--
-- Indexes for table `uploadfiles`
--
ALTER TABLE `uploadfiles`
  ADD PRIMARY KEY (`fileId`);

--
-- Indexes for table `users_tbl`
--
ALTER TABLE `users_tbl`
  ADD PRIMARY KEY (`adminId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `task`
--
ALTER TABLE `task`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `task_admin`
--
ALTER TABLE `task_admin`
  MODIFY `taskId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `uploadfiles`
--
ALTER TABLE `uploadfiles`
  MODIFY `fileId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `users_tbl`
--
ALTER TABLE `users_tbl`
  MODIFY `adminId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
