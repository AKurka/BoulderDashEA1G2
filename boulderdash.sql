-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 29 mai 2019 à 12:27
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `boulderdash`
--

DELIMITER $$
--
-- Procédures
--
DROP PROCEDURE IF EXISTS `lvl1_diamonds`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl1_diamonds` ()  BEGIN
SELECT diamonds.level, diamonds
FROM diamonds
WHERE level = 1;
END$$

DROP PROCEDURE IF EXISTS `lvl1_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl1_procedure` ()  BEGIN
SELECT line, chars
FROM levels
WHERE level = 1;
END$$

DROP PROCEDURE IF EXISTS `lvl2_diamonds`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl2_diamonds` ()  BEGIN
SELECT diamonds.level, diamonds
FROM diamonds
WHERE level = 2;
END$$

DROP PROCEDURE IF EXISTS `lvl2_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl2_procedure` ()  BEGIN
SELECT line, chars
FROM levels
WHERE level = 2;
END$$

DROP PROCEDURE IF EXISTS `lvl3_diamonds`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl3_diamonds` ()  BEGIN
SELECT diamonds.level, diamonds
FROM diamonds
WHERE level = 3;
END$$

DROP PROCEDURE IF EXISTS `lvl3_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl3_procedure` ()  BEGIN
SELECT line, chars
FROM levels
WHERE level = 3;
END$$

DROP PROCEDURE IF EXISTS `lvl4_diamonds`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl4_diamonds` ()  BEGIN
SELECT diamonds.level, diamonds
FROM diamonds
WHERE level = 4;
END$$

DROP PROCEDURE IF EXISTS `lvl4_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl4_procedure` ()  BEGIN
SELECT line, chars
FROM levels
WHERE level = 4;
END$$

DROP PROCEDURE IF EXISTS `lvl5_diamonds`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl5_diamonds` ()  BEGIN
SELECT diamonds.level, diamonds
FROM diamonds
WHERE level = 5;
END$$

DROP PROCEDURE IF EXISTS `lvl5_procedure`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `lvl5_procedure` ()  BEGIN
SELECT line, chars
FROM levels
WHERE level = 5;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `diamonds`
--

DROP TABLE IF EXISTS `diamonds`;
CREATE TABLE IF NOT EXISTS `diamonds` (
  `level` int(11) NOT NULL,
  `diamonds` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `diamonds`
--

INSERT INTO `diamonds` (`level`, `diamonds`) VALUES
(1, 13),
(2, 10),
(3, 15),
(4, 14),
(5, 13);

-- --------------------------------------------------------

--
-- Structure de la table `levels`
--

DROP TABLE IF EXISTS `levels`;
CREATE TABLE IF NOT EXISTS `levels` (
  `level` int(255) NOT NULL,
  `line` int(255) NOT NULL,
  `chars` varchar(255) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Déchargement des données de la table `levels`
--

INSERT INTO `levels` (`level`, `line`, `chars`) VALUES
(1, 1, '///////////////'),
(1, 2, '/#*000*00***00/'),
(1, 3, '/******@**0***/'),
(1, 4, '/0********0**@/'),
(1, 5, '/0**@*000*****/'),
(1, 6, '/**0******@***/'),
(1, 7, '/@*0********0*/'),
(1, 8, '/**000@*****0*/'),
(1, 9, '/***********@*/'),
(1, 10, '/**@****00**00/'),
(1, 11, '/00**0**@0****/'),
(1, 12, '/****0***0***@/'),
(1, 13, '/@*******@****/'),
(1, 14, '/****@********/'),
(1, 15, '///////////////'),
(2, 1, '///////////////'),
(2, 2, '/#****0@*0***@/'),
(2, 3, '/*****0***00**/'),
(2, 4, '/*0@0*********/'),
(2, 5, '/***00***0**0*/'),
(2, 6, '////////////@*/'),
(2, 7, '/***0**00**0*0/'),
(2, 8, '/0**0@*****0**/'),
(2, 9, '/0*******@****/'),
(2, 10, '/@*////////////'),
(2, 11, '/***00**@0**00/'),
(2, 12, '/0***0*0*0**0*/'),
(2, 13, '/0*@**********/'),
(2, 14, '/00*******0**@/'),
(2, 15, '///////////////'),
(3, 1, '///////////////'),
(3, 2, '/0#0*/**0/00@*/'),
(3, 3, '/***0/0*0/****/'),
(3, 4, '/****/@**/***0/'),
(3, 5, '/0**@/***/@***/'),
(3, 6, '//*/////*////*/'),
(3, 7, '/0*0*/0*@/*0**/'),
(3, 8, '/********/@**0/'),
(3, 9, '/@*@*/@******@/'),
(3, 10, '//////*////////'),
(3, 11, '/0***/*****000/'),
(3, 12, '/*00*/0*0/@0**/'),
(3, 13, '/@****@**/****/'),
(3, 14, '/****/**@/**@*/'),
(3, 15, '///////////////'),
(4, 1, '///////////////'),
(4, 2, '/#0/**0*/***00/'),
(4, 3, '/*@/***@/*****/'),
(4, 4, '/*//*KX**0*@**/'),
(4, 5, '/****0***0*/*@/'),
(4, 6, '/**0/0*****////'),
(4, 7, '/0**/@*//@*/00/'),
(4, 8, '/0**/**00****0/'),
(4, 9, '/**@****0**@**/'),
(4, 10, '/@*/*******XK*/'),
(4, 11, '/*0/*KX@//***@/'),
(4, 12, '////*00*/0****/'),
(4, 13, '/00**@**/**/**/'),
(4, 14, '/0@***0*/@*/*0/'),
(4, 15, '///////////////'),
(5, 1, '///////////////'),
(5, 2, '/KX/**0*/KX*00/'),
(5, 3, '/XX/*XK@/X****/'),
(5, 4, '//*/*XX**0*@**/'),
(5, 5, '/****0***0*/K@/'),
(5, 6, '//*0*0*#***////'),
(5, 7, '/0***@*//@*/00/'),
(5, 8, '/0*****00****0/'),
(5, 9, '/**@****0**@**/'),
(5, 10, '/@*********XK*/'),
(5, 11, '/K0**KX@//*//@/'),
(5, 12, '///**00X/0***K/'),
(5, 13, '/K0**@XK/0*/XX/'),
(5, 14, '/X@***0X/@*/X0/'),
(5, 15, '///////////////');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
