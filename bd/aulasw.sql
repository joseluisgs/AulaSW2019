-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 05-03-2019 a las 21:57:21
-- Versión del servidor: 10.1.37-MariaDB
-- Versión de PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `aulasw`
--
CREATE DATABASE IF NOT EXISTS `aulasw` DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci;
USE `aulasw`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `accesos`
--

DROP TABLE IF EXISTS `accesos`;
CREATE TABLE IF NOT EXISTS `accesos` (
  `usuario_id` int(11) NOT NULL,
  `momento` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`usuario_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `accesos`
--

INSERT INTO `accesos` (`usuario_id`, `momento`) VALUES
(9, '2019-03-05 21:42:07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

DROP TABLE IF EXISTS `alumnos`;
CREATE TABLE IF NOT EXISTS `alumnos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `nota` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`id`, `usuario_id`, `nombre`, `nota`) VALUES
(1, 9, 'Pablo Marmol', 7),
(2, 9, 'Naruto Uzumaki', 3),
(3, 9, 'Pedro Picapiedra', 6.5),
(4, 9, 'Sakura Haruno', 8),
(5, 9, 'Sasuke Uchiha', 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `firmas`
--

DROP TABLE IF EXISTS `firmas`;
CREATE TABLE IF NOT EXISTS `firmas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id` int(11) NOT NULL,
  `valor` varchar(4) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`,`usuario_id`) USING BTREE,
  KEY `usuario_id` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `firmas`
--

INSERT INTO `firmas` (`id`, `usuario_id`, `valor`) VALUES
(1, 9, 'K43Y'),
(2, 9, 'LODD'),
(3, 9, '2ZO8'),
(4, 9, '797Z'),
(5, 9, '8W9Q'),
(6, 9, 'GE1P'),
(7, 9, 'C854'),
(8, 9, '4DCY'),
(9, 9, 'ARSO'),
(10, 9, 'HO7N'),
(11, 9, 'N5VH'),
(12, 9, 'AT7J'),
(13, 9, '7V74'),
(14, 9, '37M9'),
(15, 9, 'LHZJ'),
(16, 9, 'LEPD'),
(17, 9, 'QWQQ'),
(18, 9, 'X9QX'),
(19, 9, '8N03'),
(20, 9, 'AKV1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE IF NOT EXISTS `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(125) COLLATE utf8_spanish_ci NOT NULL,
  `email` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci NOT NULL,
  `creado` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `email`, `password`, `creado`) VALUES
(9, 'Pepe Pepinez', 'pepe@pepe.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '2019-02-26 17:30:46'),
(11, 'ana', 'ana@ana.com', '03ac674216f3e15c761ee1a5e255f067953623c8b388b4459e13f978d7c846f4', '2019-02-27 17:26:57');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
