-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  Dim 02 juin 2019 à 14:10
-- Version du serveur :  5.7.26
-- Version de PHP :  7.2.18

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
DROP PROCEDURE IF EXISTS `getLevel`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `getLevel` (IN `choice` INT(255))  BEGIN
SELECT chars
FROM levels
WHERE level = choice;
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Structure de la table `levels`
--

DROP TABLE IF EXISTS `levels`;
CREATE TABLE IF NOT EXISTS `levels` (
  `level` int(255) NOT NULL,
  `chars` varchar(5000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `levels`
--

INSERT INTO `levels` (`level`, `chars`) VALUES
(1, '///////////////////////////////#******0*/*KKKK@******00000*//*******0*/***************@**//*******0*/***************@**//*******0*/************////**//*0*****@*/***********KK*****//*0***/////*****0000**KK*****//*0000**********0000*********//*@*****0000*****************//*******0000****@******0000**//*******0000***********0000**//**KKK**0000***********0000**//*******0000*********0****0**//********************@****0**//********************////*0**//*00000*///**KKK*************//*00000***/@*************@***//***@*****/******************//****************************//****************************//***KKK*******00000000*******//***KKK*******00000000***00**/000*00000000***00**//*********000************00**//*********000*******0****00**//**000****000**00***0****00**//***0*/***000**@****0********//***@*/***000*******0*****@**//*****/***000*******0********////////***000*******0********//*******************0********//*******************0********//******0*KK***00****0********//******0/KK**00*****@*******0//***0000/KK***@****//////***0//******@/*******************0//*******/**************000000//****////********0*KKK*000000//****************0*KKK*******//****************0***********//****************0***********//*******000******0***********//*0*****000*KK***0***********//*0*****000*KK***0**00000****//*0*****000*********00000****//*0*****000******@**00000****//*******000*************@****//*@KKK**000******************//*********00000**************//**********@****************E///////////////////////////////');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
