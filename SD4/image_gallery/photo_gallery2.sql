-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 22, 2018 at 12:25 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `photo_gallery`
--
CREATE DATABASE IF NOT EXISTS `photo_gallery` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `photo_gallery`;

-- --------------------------------------------------------

--
-- Table structure for table `image_info`
--

CREATE TABLE `image_info` (
  `image_id` int(11) NOT NULL,
  `iname` varchar(255) NOT NULL,
  `ilocation` varchar(255) NOT NULL,
  `iowner` varchar(255) NOT NULL,
  `istatus` varchar(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `image_info`
--

INSERT INTO `image_info` (`image_id`, `iname`, `ilocation`, `iowner`, `istatus`) VALUES
(1, 'asd', 'uploads/asd1.png', 'sakib19041996@gmail.com', '0'),
(3, '2', 'uploads/2(2).jpg', 'sakib19041996@gmail.com', '0'),
(4, '3', 'uploads/3fjdgh.jpg', 'sakib19041996@gmail.com', '1'),
(5, '4', 'uploads/43D-Background-Wallpapers-HD-Wallpapers-in-HD.jpg', 'sakib19041996@gmail.com', '0'),
(7, '6', 'uploads/6messi-wallpaper-1.jpg', 'sakib19041996@gmail.com', '0'),
(8, '7', 'uploads/7hd-wallpaper-pics-1024X768.jpeg', 'sakib19041996@gmail.com', '0'),
(9, 'img', 'uploads/imgAbstract-Wallpaper-HD-Widescreen-Desktop-Wallpaper-HD-Wallpapers.jpg', 'sakib19041996@gmail.com', '0'),
(10, 'img2', 'uploads/img2Black-and-White-Wallpaper-Photo.jpg', 'sakib19041996@gmail.com', '0'),
(15, '11', 'uploads/11Black-and-White-Wallpaper-Image.jpg', 'sakib19041996@gmail.com', '0'),
(16, 'malware37', 'uploads/malware3730624673_394469054360345_3035619495390478336_o.jpg', 'mahedee@gmail.com', '0'),
(17, 'china', 'uploads/china749794.jpg', 'mahedee@gmail.com', '1'),
(18, 'crow', 'uploads/crowUntitled.png', 'mahedee@gmail.com', '0'),
(19, 'savior', 'uploads/savior41642454_10156497517323654_8108368071200079872_n.jpg', 'mahedee@gmail.com', '0');

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

CREATE TABLE `report` (
  `report_id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `comments` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `report`
--

INSERT INTO `report` (`report_id`, `name`, `email`, `comments`) VALUES
(1, 'Saiful', 'sakib19041996@gmail.com', 'ki j kortesi\r\ncheeeeeee'),
(2, 'Saiful', 'sakib19041996@gmail.com', 'thik ase ebar :-)');

-- --------------------------------------------------------

--
-- Table structure for table `userinfo`
--

CREATE TABLE `userinfo` (
  `user_id` int(11) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `userinfo`
--

INSERT INTO `userinfo` (`user_id`, `fname`, `lname`, `email`, `password`) VALUES
(1, 'Saiful', 'Sakib', 'sakib19041996@gmail.com', '7815696ecbf1c96e6894b779456d330e'),
(2, 'Gazi', 'Mahedee Hasan', 'mahedee@gmail.com', '7815696ecbf1c96e6894b779456d330e');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `image_info`
--
ALTER TABLE `image_info`
  ADD PRIMARY KEY (`image_id`);

--
-- Indexes for table `report`
--
ALTER TABLE `report`
  ADD PRIMARY KEY (`report_id`);

--
-- Indexes for table `userinfo`
--
ALTER TABLE `userinfo`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `image_info`
--
ALTER TABLE `image_info`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `report`
--
ALTER TABLE `report`
  MODIFY `report_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `userinfo`
--
ALTER TABLE `userinfo`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
