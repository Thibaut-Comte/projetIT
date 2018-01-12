-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  ven. 12 jan. 2018 à 11:33
-- Version du serveur :  10.2.10-MariaDB
-- Version de PHP :  7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projetit`
--

-- --------------------------------------------------------

--
-- Structure de la table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
CREATE TABLE IF NOT EXISTS `adresse` (
  `identifiant` varchar(25) NOT NULL,
  `rue` varchar(55) DEFAULT NULL,
  `cp` varchar(10) DEFAULT NULL,
  `ville` varchar(55) DEFAULT NULL,
  `pays` varchar(25) DEFAULT NULL,
  `etage` int(11) DEFAULT NULL,
  `ascenseur` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`identifiant`),
  UNIQUE KEY `Adresse_identifiant_uindex` (`identifiant`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `adresse`
--

INSERT INTO `adresse` (`identifiant`, `rue`, `cp`, `ville`, `pays`, `etage`, `ascenseur`) VALUES
('ajout', 'un autre Endroit', '2', 'Ville au loin au fond', 'russie', 2, 0),
('premier', '18 jean dausset', '77176', 'savigny le temple', 'france', 0, 0),
('seconde', 'pompidou', '75000', 'paris', 'france', 0, 0),
('suppression', 'suppr', '00000', 'supp', 'allemagne', 1, 0),
('update', 'update', '55555', 'update', 'update', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `bien`
--

DROP TABLE IF EXISTS `bien`;
CREATE TABLE IF NOT EXISTS `bien` (
  `numero` varchar(25) NOT NULL,
  `type` varchar(25) DEFAULT NULL,
  `specificite` varchar(55) DEFAULT NULL,
  `statut` tinyint(1) DEFAULT NULL,
  `taille` float DEFAULT NULL,
  `identifiant_adresse` varchar(25) NOT NULL,
  PRIMARY KEY (`numero`),
  UNIQUE KEY `Bien_numero_uindex` (`numero`),
  KEY `identifiant_ad` (`identifiant_adresse`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `numero` varchar(25) NOT NULL,
  `nom` varchar(25) DEFAULT NULL,
  `prenom` varchar(25) DEFAULT NULL,
  `tel` varchar(15) DEFAULT NULL,
  `email` varchar(55) DEFAULT NULL,
  `identifiant_adresse` varchar(25) DEFAULT NULL,
  `login` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`numero`),
  UNIQUE KEY `Client_numero_uindex` (`numero`),
  KEY `identifiant_adresse` (`identifiant_adresse`),
  KEY `login` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `compte_utilisateur`
--

DROP TABLE IF EXISTS `compte_utilisateur`;
CREATE TABLE IF NOT EXISTS `compte_utilisateur` (
  `login` varchar(55) NOT NULL,
  `mdp` varchar(55) DEFAULT NULL,
  `dateCreation` date DEFAULT NULL,
  `etat` varchar(25) DEFAULT NULL,
  `type` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`login`),
  UNIQUE KEY `compteUtilisateur_login_uindex` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bien`
--
ALTER TABLE `bien`
  ADD CONSTRAINT `identifiant_ad` FOREIGN KEY (`identifiant_adresse`) REFERENCES `adresse` (`identifiant`);

--
-- Contraintes pour la table `client`
--
ALTER TABLE `client`
  ADD CONSTRAINT `identifiant_adresse` FOREIGN KEY (`identifiant_adresse`) REFERENCES `adresse` (`identifiant`),
  ADD CONSTRAINT `login` FOREIGN KEY (`login`) REFERENCES `compte_utilisateur` (`login`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
