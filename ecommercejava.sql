-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 06-12-2019 a las 16:49:39
-- Versión del servidor: 10.4.6-MariaDB
-- Versión de PHP: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ecommercejava`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

CREATE TABLE `categoria` (
  `id` int(11) NOT NULL,
  `valor` varchar(255) NOT NULL,
  `fk_id_categoria` int(11) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `categoria`
--

INSERT INTO `categoria` (`id`, `valor`, `fk_id_categoria`, `activo`) VALUES
(1, 'Nueva', NULL, 1),
(2, 'Categoria 2', NULL, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria_producto`
--

CREATE TABLE `categoria_producto` (
  `id` int(11) NOT NULL,
  `fk_id_producto` int(11) NOT NULL,
  `fk_id_categoria` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `imagen`
--

CREATE TABLE `imagen` (
  `id` int(11) NOT NULL,
  `url` varchar(255) NOT NULL,
  `fk_id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `imagen`
--

INSERT INTO `imagen` (`id`, `url`, `fk_id_producto`) VALUES
(1, '/FinalProjectJava/resources/img/imgPro_1572822135441.jpg', 48),
(2, '/FinalProjectJava/resources/img/imgPro_1572822205501.jpg', 48),
(15, '/FinalProjectJava/resources/img/imgPro_1575603230653.jpg', 55),
(16, '/FinalProjectJava/resources/img/imgPro_1575603230668.png', 55),
(17, '/FinalProjectJava/resources/img/imgPro_1575603263029.jpg', 56),
(18, '/FinalProjectJava/resources/img/imgPro_1575603263041.png', 56),
(19, '/FinalProjectJava/resources/img/imgPro_1575603430477.png', 57),
(20, '/FinalProjectJava/resources/img/imgPro_1575603463267.jpg', 58),
(21, '/FinalProjectJava/resources/img/imgPro_1575645655556.jpg', 59);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `orden`
--

CREATE TABLE `orden` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL DEFAULT current_timestamp(),
  `fk_id_usuario` int(11) NOT NULL,
  `status` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `orden`
--

INSERT INTO `orden` (`id`, `fecha`, `fk_id_usuario`, `status`) VALUES
(33, '2019-12-05', 8, 3),
(34, '2019-12-05', 8, 3),
(35, '2019-12-05', 8, 2),
(36, '2019-12-05', 8, 2),
(37, '2019-12-06', 8, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `precio` double NOT NULL,
  `cantidad` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `fk_id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `precio`, `cantidad`, `activo`, `descripcion`, `nombre`, `fk_id_usuario`) VALUES
(48, 1000, 3, 1, ' dhgfj dsgjhdf kgh adfs', 'Nuevo 3', NULL),
(55, 10, 17, 1, 'Descripcion', 'Lapiz 1', NULL),
(56, 15, 10, 1, 'Lapiz de la mejor calidad', 'Lapiz 2', NULL),
(57, 18, 10, 1, 'Lapiz de la mejor calidad', 'Lapiz 3', NULL),
(58, 150, 10, 1, 'Muchos', 'Conjunto de utilez', NULL),
(59, 123, 123, 1, 'sdf', 'asd', NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto_orden`
--

CREATE TABLE `producto_orden` (
  `id` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precio` double NOT NULL,
  `fk_id_producto` int(11) NOT NULL,
  `fk_id_orden` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `producto_orden`
--

INSERT INTO `producto_orden` (`id`, `cantidad`, `precio`, `fk_id_producto`, `fk_id_orden`) VALUES
(29, 1, 1000, 48, 33),
(30, 1, 1000, 48, 34),
(31, 1, 1000, 48, 35),
(32, 1, 1000, 48, 35),
(33, 1, 1000, 48, 35),
(34, 1, 15, 56, 35),
(35, 1, 15, 56, 35),
(36, 1, 18, 57, 35),
(37, 1, 15, 56, 35),
(38, 1, 18, 57, 35),
(39, 1, 10, 55, 35),
(40, 1, 10, 55, 35),
(41, 1, 18, 57, 35),
(42, 1, 15, 56, 35),
(43, 1, 150, 58, 35),
(44, 1, 150, 58, 35),
(45, 1, 15, 56, 35),
(46, 1, 10, 55, 35),
(47, 1, 18, 57, 35),
(49, 1, 10, 55, 36),
(50, 1, 10, 55, 36),
(51, 1, 15, 56, 36),
(52, 1, 15, 56, 36),
(53, 1, 10, 55, 36),
(54, 1, 18, 57, 36),
(55, 1, 15, 56, 36),
(56, 1, 10, 55, 36),
(57, 1, 18, 57, 36),
(58, 1, 150, 58, 36),
(59, 1, 18, 57, 36),
(60, 1, 15, 56, 36),
(61, 1, 150, 58, 36),
(62, 1, 10, 55, 36),
(63, 1, 1000, 48, 37),
(64, 1, 1000, 48, 37),
(65, 1, 1000, 48, 37),
(66, 1, 1000, 48, 37),
(67, 1, 1000, 48, 37),
(68, 1, 1000, 48, 37),
(69, 1, 1000, 48, 37),
(70, 1, 1000, 48, 37),
(71, 1, 1000, 48, 37),
(72, 1, 1000, 48, 37),
(73, 1, 1000, 48, 37),
(74, 1, 1000, 48, 37),
(75, 1, 1000, 48, 37),
(76, 1, 1000, 48, 37),
(77, 1, 1000, 48, 37),
(78, 1, 1000, 48, 37),
(79, 1, 1000, 48, 37),
(80, 1, 1000, 48, 37),
(81, 1, 1000, 48, 37),
(82, 1, 1000, 48, 37),
(83, 1, 1000, 48, 37),
(84, 1, 1000, 48, 37),
(85, 1, 1000, 48, 37),
(86, 1, 1000, 48, 37),
(87, 1, 1000, 48, 37),
(88, 1, 1000, 48, 37),
(89, 1, 1000, 48, 37),
(90, 1, 1000, 48, 37),
(91, 1, 1000, 48, 37),
(92, 1, 1000, 48, 37),
(93, 1, 1000, 48, 37),
(94, 1, 1000, 48, 37),
(95, 1, 1000, 48, 37),
(96, 1, 1000, 48, 37),
(97, 1, 1000, 48, 37),
(98, 1, 1000, 48, 37),
(99, 1, 10, 55, 37),
(100, 1, 1000, 48, 37),
(101, 1, 1000, 48, 37),
(102, 1, 1000, 48, 37),
(103, 1, 1000, 48, 37),
(104, 1, 1000, 48, 37),
(105, 1, 10, 55, 37),
(106, 1, 1000, 48, 37),
(107, 1, 1000, 48, 37);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propiedad`
--

CREATE TABLE `propiedad` (
  `id` int(11) NOT NULL,
  `valor` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propiedad_producto`
--

CREATE TABLE `propiedad_producto` (
  `id` int(11) NOT NULL,
  `valor` varchar(255) NOT NULL,
  `fk_id_propiedad` int(11) NOT NULL,
  `fk_id_producto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `valor` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `valor`) VALUES
(1, 'Administrador'),
(2, 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `apellidos` varchar(255) NOT NULL,
  `correo` varchar(255) NOT NULL,
  `alias` varchar(255) DEFAULT NULL,
  `activo` tinyint(1) NOT NULL,
  `fk_id_rol` int(11) NOT NULL DEFAULT 2,
  `password` longtext NOT NULL,
  `username` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `nombre`, `apellidos`, `correo`, `alias`, `activo`, `fk_id_rol`, `password`, `username`) VALUES
(2, 'Leo', 'Flores', 'leojfl@outlook.com', 'admin', 1, 1, 'prueba', 'admin'),
(3, 'NOmbre', 'apellido', 'correo@correo.com', 'juan', 1, 2, 'prueba', 'juan'),
(6, 'Usuario1', 'usuario1', 'usuario1@usuario1.com', 'usuario1', 1, 2, 'prueba', 'usuario1'),
(8, 'prueba', 'prueba', 'prueba@prueba.prueba', 'prueba', 1, 2, 'prueba', 'prueba'),
(9, 'kj', 'kj', 'k', 'j', 1, 2, 'kj', 'j');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_categoria` (`fk_id_categoria`);

--
-- Indices de la tabla `categoria_producto`
--
ALTER TABLE `categoria_producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_categoria` (`fk_id_categoria`),
  ADD KEY `fk_id_producto` (`fk_id_producto`);

--
-- Indices de la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_producto` (`fk_id_producto`);

--
-- Indices de la tabla `orden`
--
ALTER TABLE `orden`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_usuario` (`fk_id_usuario`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_usuario` (`fk_id_usuario`);

--
-- Indices de la tabla `producto_orden`
--
ALTER TABLE `producto_orden`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_producto` (`fk_id_producto`),
  ADD KEY `fk_id_orden` (`fk_id_orden`);

--
-- Indices de la tabla `propiedad`
--
ALTER TABLE `propiedad`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `propiedad_producto`
--
ALTER TABLE `propiedad_producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_propiedad` (`fk_id_propiedad`),
  ADD KEY `fk_id_producto` (`fk_id_producto`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_rol` (`fk_id_rol`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categoria`
--
ALTER TABLE `categoria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `categoria_producto`
--
ALTER TABLE `categoria_producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `imagen`
--
ALTER TABLE `imagen`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `orden`
--
ALTER TABLE `orden`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=60;

--
-- AUTO_INCREMENT de la tabla `producto_orden`
--
ALTER TABLE `producto_orden`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=108;

--
-- AUTO_INCREMENT de la tabla `propiedad`
--
ALTER TABLE `propiedad`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `propiedad_producto`
--
ALTER TABLE `propiedad_producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `categoria`
--
ALTER TABLE `categoria`
  ADD CONSTRAINT `categoria_ibfk_1` FOREIGN KEY (`fk_id_categoria`) REFERENCES `categoria` (`id`);

--
-- Filtros para la tabla `categoria_producto`
--
ALTER TABLE `categoria_producto`
  ADD CONSTRAINT `categoria_producto_ibfk_1` FOREIGN KEY (`fk_id_categoria`) REFERENCES `categoria` (`id`),
  ADD CONSTRAINT `categoria_producto_ibfk_2` FOREIGN KEY (`fk_id_producto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `imagen`
--
ALTER TABLE `imagen`
  ADD CONSTRAINT `imagen_ibfk_1` FOREIGN KEY (`fk_id_producto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `orden`
--
ALTER TABLE `orden`
  ADD CONSTRAINT `orden_ibfk_1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`fk_id_usuario`) REFERENCES `usuario` (`id`);

--
-- Filtros para la tabla `producto_orden`
--
ALTER TABLE `producto_orden`
  ADD CONSTRAINT `producto_orden_ibfk_1` FOREIGN KEY (`fk_id_producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `producto_orden_ibfk_2` FOREIGN KEY (`fk_id_orden`) REFERENCES `orden` (`id`);

--
-- Filtros para la tabla `propiedad_producto`
--
ALTER TABLE `propiedad_producto`
  ADD CONSTRAINT `propiedad_producto_ibfk_1` FOREIGN KEY (`fk_id_propiedad`) REFERENCES `propiedad` (`id`),
  ADD CONSTRAINT `propiedad_producto_ibfk_2` FOREIGN KEY (`fk_id_producto`) REFERENCES `producto` (`id`),
  ADD CONSTRAINT `propiedad_producto_ibfk_3` FOREIGN KEY (`fk_id_producto`) REFERENCES `producto` (`id`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`fk_id_rol`) REFERENCES `rol` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
