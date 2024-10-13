-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 13, 2024 at 05:31 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `std_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `marks`
--

CREATE TABLE `marks` (
  `ROLLNO` varchar(255) NOT NULL,
  `SUB_CODE` varchar(255) NOT NULL,
  `SUB_NAME` varchar(255) NOT NULL,
  `T1` int(255) NOT NULL,
  `Q1` int(255) NOT NULL,
  `A1` int(255) NOT NULL,
  `EXT` int(255) NOT NULL,
  `TOTAL` int(11) GENERATED ALWAYS AS (`T1` + `Q1` + `A1`) STORED,
  `SEMESTER` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `marks`
--

INSERT INTO `marks` (`ROLLNO`, `SUB_CODE`, `SUB_NAME`, `T1`, `Q1`, `A1`, `EXT`, `SEMESTER`) VALUES
('23mca31', 'mca01', 'c', 30, 10, 10, 66, 1),
('23mca31', 'mca02', 'c++', 19, 10, 10, 49, 1);

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `ID` int(255) NOT NULL,
  `SNAME` varchar(255) NOT NULL,
  `ROLLNO` varchar(255) NOT NULL,
  `EMAIL` varchar(255) NOT NULL,
  `MOBILE` varchar(255) NOT NULL,
  `COURSE` varchar(255) NOT NULL,
  `GENDER` varchar(255) NOT NULL,
  `PASSWORD` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`ID`, `SNAME`, `ROLLNO`, `EMAIL`, `MOBILE`, `COURSE`, `GENDER`, `PASSWORD`) VALUES
(6, 'sudharsan', '23mca08', 'sudharsan@gmail.com', '88999654', 'MCA', 'male', '1234'),
(1, 'ARUN', '23MCA31', 'ARUN@GMAIL.OCM', '0987654321', 'MCA', 'MALE', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `marks`
--
ALTER TABLE `marks`
  ADD KEY `FK_STD` (`ROLLNO`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ROLLNO`),
  ADD UNIQUE KEY `id` (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `ID` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `marks`
--
ALTER TABLE `marks`
  ADD CONSTRAINT `FK_STD` FOREIGN KEY (`ROLLNO`) REFERENCES `student` (`ROLLNO`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
