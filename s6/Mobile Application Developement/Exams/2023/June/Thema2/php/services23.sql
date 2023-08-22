-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Εξυπηρετητής: localhost
-- Χρόνος δημιουργίας: 22 Αυγ 2023 στις 11:47:14
-- Έκδοση διακομιστή: 10.4.28-MariaDB
-- Έκδοση PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Βάση δεδομένων: `services23`
--

-- --------------------------------------------------------

--
-- Δομή πίνακα για τον πίνακα `Multis`
--

CREATE TABLE `Multis` (
  `image1` varchar(1024) NOT NULL,
  `image2` varchar(1024) NOT NULL,
  `oper1` varchar(32) NOT NULL,
  `oper2` varchar(32) NOT NULL,
  `res` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Άδειασμα δεδομένων του πίνακα `Multis`
--

INSERT INTO `Multis` (`image1`, `image2`, `oper1`, `oper2`, `res`) VALUES
('https://www.pngitem.com/pimgs/m/1-14760_red-round-error-warning-error-icon-hd-png.png', 'https://cms-assets.tutsplus.com/cdn-cgi/image/width=850/uploads/users/523/posts/32694/final_image/tutorial-preview-large.png', '1', '2', '2'),
('https://www.pngitem.com/pimgs/m/1-14760_red-round-error-warning-error-icon-hd-png.png', 'https://cms-assets.tutsplus.com/cdn-cgi/image/width=850/uploads/users/523/posts/32694/final_image/tutorial-preview-large.png', '2', '2', '2'),
('https://www.pngitem.com/pimgs/m/1-14760_red-round-error-warning-error-icon-hd-png.png', 'https://cms-assets.tutsplus.com/cdn-cgi/image/width=850/uploads/users/523/posts/32694/final_image/tutorial-preview-large.png', '3', '2', '2'),
('https://www.pngitem.com/pimgs/m/1-14760_red-round-error-warning-error-icon-hd-png.png', 'https://cms-assets.tutsplus.com/cdn-cgi/image/width=850/uploads/users/523/posts/32694/final_image/tutorial-preview-large.png', '4', '2', '8'),
('https://www.pngitem.com/pimgs/m/1-14760_red-round-error-warning-error-icon-hd-png.png', 'https://cms-assets.tutsplus.com/cdn-cgi/image/width=850/uploads/users/523/posts/32694/final_image/tutorial-preview-large.png', '23', '2', '46'),
('https://www.pngitem.com/pimgs/m/1-14760_red-round-error-warning-error-icon-hd-png.png', 'https://cms-assets.tutsplus.com/cdn-cgi/image/width=850/uploads/users/523/posts/32694/final_image/tutorial-preview-large.png', '5', '5', '25'),
('https://www.pngitem.com/pimgs/m/1-14760_red-round-error-warning-error-icon-hd-png.png', 'https://cms-assets.tutsplus.com/cdn-cgi/image/width=850/uploads/users/523/posts/32694/final_image/tutorial-preview-large.png', '4', '4', '18');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
