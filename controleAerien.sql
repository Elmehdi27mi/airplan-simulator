-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 02 jan. 2024 à 21:19
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `jee_projet2`
--

-- --------------------------------------------------------

--
-- Structure de la table `aeroport`
--

CREATE TABLE `aeroport` (
  `id_aeroport` int(11) NOT NULL,
  `acces_piste` int(11) DEFAULT NULL,
  `attente_sol` int(11) DEFAULT NULL,
  `boucle_attente` int(11) DEFAULT NULL,
  `delai_anticollision` int(11) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `nombre_piste` int(11) DEFAULT NULL,
  `localisation` int(11) DEFAULT NULL,
  `localisation_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `aeroport`
--

INSERT INTO `aeroport` (`id_aeroport`, `acces_piste`, `attente_sol`, `boucle_attente`, `delai_anticollision`, `nom`, `nombre_piste`, `localisation`, `localisation_id`) VALUES
(0, 1, 2, 3, 4, 'Dubai', 3, 4, 4),
(1, 1, 2, 3, 4, 'casa', 1, 1, 1),
(2, 1, 2, 3, 4, 'NewYork', 1, 5, 5),
(3, 1, 2, 3, 4, 'CapTown', 1, 3, 3),
(4, 1, 2, 3, 4, 'Brazilia', 3, 6, 6),
(5, 1, 2, 3, 4, 'Cairo', 3, 7, 7);

-- --------------------------------------------------------

--
-- Structure de la table `avion`
--

CREATE TABLE `avion` (
  `id` int(11) NOT NULL,
  `altitude` double DEFAULT NULL,
  `altitude_mximale` int(11) DEFAULT NULL,
  `capacite_maximale` int(11) DEFAULT NULL,
  `consomation` int(11) DEFAULT NULL,
  `niveau_kerosene` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `vitess` int(11) DEFAULT NULL,
  `vitess_maximale` int(11) DEFAULT NULL,
  `aeroport_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `avion`
--

INSERT INTO `avion` (`id`, `altitude`, `altitude_mximale`, `capacite_maximale`, `consomation`, `niveau_kerosene`, `type`, `vitess`, `vitess_maximale`, `aeroport_id`) VALUES
(1, 1, 1, 1, 1, 1, 'alpha', 220, 1, 1),
(2, 1, 1, 1, 1, 1, 'beta', 220, 1, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `coordonnee`
--

CREATE TABLE `coordonnee` (
  `id` int(11) NOT NULL,
  `x` double DEFAULT NULL,
  `y` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `coordonnee`
--

INSERT INTO `coordonnee` (`id`, `x`, `y`) VALUES
(1, 33.5731, -7.5898),
(2, 28.96, -9.13),
(3, -33.9249, 18.4241),
(4, 25, 55),
(5, 40.7128, -74.006),
(6, -15.7801, -47.9292),
(7, 30.0444, 31.2357);

-- --------------------------------------------------------

--
-- Structure de la table `trajectoire`
--

CREATE TABLE `trajectoire` (
  `id_tra` int(11) NOT NULL,
  `distance` double DEFAULT NULL,
  `flot` int(11) DEFAULT NULL,
  `aeroport_arrivet_id_aeroport` int(11) DEFAULT NULL,
  `aeroport_depart_id_aeroport` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `trajectoire`
--

INSERT INTO `trajectoire` (`id_tra`, `distance`, `flot`, `aeroport_arrivet_id_aeroport`, `aeroport_depart_id_aeroport`) VALUES
(11, 2, 2, 2, 1),
(12, 21, 22, 2, 3),
(13, 3, 2, 1, 2),
(14, 3, 2, 1, 3),
(15, 21, 2, 3, 2),
(16, 21, 2, 1, 3),
(17, 3, 2, 2, 1),
(19, 2, 2, 2, 2),
(20, 2, 2, 2, 2),
(21, 2, 2, 2, 2),
(22, 2, 2, 2, 3),
(23, 2, 2, 2, 3),
(24, 2, 2, 2, 3),
(25, 2, 2, 3, 2),
(26, 2, 2, 3, 2),
(27, 2, 2, 2, 3),
(28, 2, 2, 3, 2),
(29, 2, 2, 3, 2),
(30, 2, 2, 3, 1),
(31, 18.265123869276117, 3, 2, 1),
(32, 61.96772143624453, 3, 3, 2),
(33, 2, 2, 3, 0),
(34, 24.293783687396246, 3, 5, 0),
(35, 65.23962321358087, 3, 3, 5),
(36, 2, 2, 3, 0),
(37, 24.293783687396246, 3, 5, 0),
(38, 65.23962321358087, 3, 3, 5),
(39, 24.293783687396246, 3, 5, 0),
(40, 65.23962321358087, 3, 3, 5);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id`, `password`, `username`) VALUES
(1, '1234', 'mohamed'),
(2, '1234', 'mehdi');

-- --------------------------------------------------------

--
-- Structure de la table `vol`
--

CREATE TABLE `vol` (
  `id` int(11) NOT NULL,
  `heur_depart` datetime(6) DEFAULT NULL,
  `avion_id` int(11) DEFAULT NULL,
  `date_depart` datetime(6) DEFAULT NULL,
  `aeroport_arrivet_id_aeroport` int(11) DEFAULT NULL,
  `aeroport_depart_id_aeroport` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `vol`
--

INSERT INTO `vol` (`id`, `heur_depart`, `avion_id`, `date_depart`, `aeroport_arrivet_id_aeroport`, `aeroport_depart_id_aeroport`) VALUES
(1, '2023-12-27 09:30:47.000000', 1, NULL, 1, 3),
(2, '2023-12-27 09:30:47.000000', 1, NULL, 1, 2),
(3, '2023-12-27 09:30:47.000000', 1, NULL, 3, 2),
(4, '2023-12-27 09:30:47.000000', 1, NULL, 2, 1),
(28, NULL, 2, NULL, 3, 0);

-- --------------------------------------------------------

--
-- Structure de la table `vol_trajectoires`
--

CREATE TABLE `vol_trajectoires` (
  `vol_id` int(11) NOT NULL,
  `trajectoires_id_tra` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `vol_trajectoires`
--

INSERT INTO `vol_trajectoires` (`vol_id`, `trajectoires_id_tra`) VALUES
(1, 11),
(1, 15),
(2, 12),
(3, 13),
(4, 14),
(4, 17),
(28, 39),
(28, 40);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `aeroport`
--
ALTER TABLE `aeroport`
  ADD PRIMARY KEY (`id_aeroport`),
  ADD UNIQUE KEY `UK_7v5u1h3xmng4ouj17oj87j3ut` (`localisation`),
  ADD UNIQUE KEY `UK_s8t2obwf9t8kgrs39xf6qitt6` (`localisation_id`);

--
-- Index pour la table `avion`
--
ALTER TABLE `avion`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKj5k021e781nxv6l5c1lof15s4` (`aeroport_id`);

--
-- Index pour la table `coordonnee`
--
ALTER TABLE `coordonnee`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `trajectoire`
--
ALTER TABLE `trajectoire`
  ADD PRIMARY KEY (`id_tra`),
  ADD KEY `FK9e064eyoub2qapsp6k7lkpnt3` (`aeroport_arrivet_id_aeroport`),
  ADD KEY `FKgqml1a6qhousiov31m10bl470` (`aeroport_depart_id_aeroport`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `vol`
--
ALTER TABLE `vol`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKi36u7096ahgjbjwinm85pfwjw` (`avion_id`),
  ADD KEY `FK3hao721cisap25plwnm00ptno` (`aeroport_arrivet_id_aeroport`),
  ADD KEY `FK5dgcj8vc6pvqsxn8sr6wcupia` (`aeroport_depart_id_aeroport`);

--
-- Index pour la table `vol_trajectoires`
--
ALTER TABLE `vol_trajectoires`
  ADD UNIQUE KEY `UK_gn3cv6pv6hbkbpbfwwe1of7o3` (`trajectoires_id_tra`),
  ADD KEY `FK2pkpxiy7axf19lq186r628unq` (`vol_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `avion`
--
ALTER TABLE `avion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `coordonnee`
--
ALTER TABLE `coordonnee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `trajectoire`
--
ALTER TABLE `trajectoire`
  MODIFY `id_tra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `vol`
--
ALTER TABLE `vol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `aeroport`
--
ALTER TABLE `aeroport`
  ADD CONSTRAINT `FK17qgrxl0dgb2e34ntcy02o7rm` FOREIGN KEY (`localisation`) REFERENCES `coordonnee` (`id`),
  ADD CONSTRAINT `FKfg35h69b07mxsw4kkmbkoykeu` FOREIGN KEY (`localisation_id`) REFERENCES `coordonnee` (`id`);

--
-- Contraintes pour la table `avion`
--
ALTER TABLE `avion`
  ADD CONSTRAINT `FKj5k021e781nxv6l5c1lof15s4` FOREIGN KEY (`aeroport_id`) REFERENCES `aeroport` (`id_aeroport`);

--
-- Contraintes pour la table `trajectoire`
--
ALTER TABLE `trajectoire`
  ADD CONSTRAINT `FK9e064eyoub2qapsp6k7lkpnt3` FOREIGN KEY (`aeroport_arrivet_id_aeroport`) REFERENCES `aeroport` (`id_aeroport`),
  ADD CONSTRAINT `FKgqml1a6qhousiov31m10bl470` FOREIGN KEY (`aeroport_depart_id_aeroport`) REFERENCES `aeroport` (`id_aeroport`);

--
-- Contraintes pour la table `vol`
--
ALTER TABLE `vol`
  ADD CONSTRAINT `FK3hao721cisap25plwnm00ptno` FOREIGN KEY (`aeroport_arrivet_id_aeroport`) REFERENCES `aeroport` (`id_aeroport`),
  ADD CONSTRAINT `FK5dgcj8vc6pvqsxn8sr6wcupia` FOREIGN KEY (`aeroport_depart_id_aeroport`) REFERENCES `aeroport` (`id_aeroport`),
  ADD CONSTRAINT `FKi36u7096ahgjbjwinm85pfwjw` FOREIGN KEY (`avion_id`) REFERENCES `avion` (`id`);

--
-- Contraintes pour la table `vol_trajectoires`
--
ALTER TABLE `vol_trajectoires`
  ADD CONSTRAINT `FK2pkpxiy7axf19lq186r628unq` FOREIGN KEY (`vol_id`) REFERENCES `vol` (`id`),
  ADD CONSTRAINT `FK8wg9ibb46liy9709vnx8svglv` FOREIGN KEY (`trajectoires_id_tra`) REFERENCES `trajectoire` (`id_tra`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
