-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : Dim 24 jan. 2021 à 22:09
-- Version du serveur :  8.0.21
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `template`
--

-- --------------------------------------------------------

--
-- Structure de la table `creation`
--

DROP TABLE IF EXISTS `creation`;
CREATE TABLE IF NOT EXISTS `creation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `price` double NOT NULL,
  `url1` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `url2` varchar(250) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` varchar(250) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `creation`
--

INSERT INTO `creation` (`id`, `name`, `price`, `url1`, `url2`, `date`) VALUES
(1, 'Chemisier Femme', 16, 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-1.jpg', 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-2.jpg', '15/11/2020'),
(2, 'Chemisier Femme', 16, 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-1.jpg', 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-2.jpg', '15/11/2020'),
(3, 'T-shirt Homme ', 10, 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-3.jpg', 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-4.jpg', '18/11/2020'),
(4, 'T-shirt uni Homme ', 10, 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-5.jpg', 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-6.jpg', '18/11/2020'),
(5, 'T-shirt uni Homme ', 5, 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-7.jpg', 'http://bestjquery.com/tutorial/product-grid/demo9/images/img-8.jpg', '12/10/2020');

-- --------------------------------------------------------

--
-- Structure de la table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `note` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `pwd` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
