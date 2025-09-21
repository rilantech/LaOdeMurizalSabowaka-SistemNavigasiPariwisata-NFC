-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 16, 2024 at 03:14 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `website_admin`
--

-- --------------------------------------------------------

--
-- Table structure for table `akunwisatawan`
--

CREATE TABLE `akunwisatawan` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nama` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `api_token` varchar(255) DEFAULT NULL,
  `remember_token` varchar(100) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `akunwisatawan`
--

INSERT INTO `akunwisatawan` (`id`, `nama`, `username`, `password`, `api_token`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, 'wahyu', 'wahyu', '$2y$10$9OVuJOLak0FTlwRnN/ryNOIlUaHYWNBYWnQcLDiWCIBpOYEh994Sm', NULL, NULL, '2024-02-13 15:34:51', '2024-02-18 09:07:08'),
(41, 'Maman', 'Mamansulaiman', '$2y$10$neYfAJQTBHyGD5V.CoFB9uuoqhVBlpqaD8QEWte4.03VtKVhMKgzq', NULL, NULL, '2024-02-18 10:23:27', '2024-08-15 16:22:38'),
(42, 'Herdin', 'herdi12345', '$2y$10$jjI6smUTFOvgpBRKuHiB6eC1CZ.Xt2RSwsdbxTgl6FGk7V1LDJqNe', NULL, NULL, '2024-02-23 16:44:19', '2024-08-15 16:22:01'),
(43, 'zulmiati', 'zulmiati', '$2y$10$2JninHm4Sf5jUv5UFIf90eor7l9vJ0iol8WWL3Yz763h/qc6cru1u', NULL, NULL, '2024-08-01 20:58:53', '2024-08-15 16:21:25'),
(44, 'Karman', 'karman12', '$2y$10$V21.a3bQLYwQqk/4zSXBhuqaF5nCoxnM8a2VufDzSeTCYeSNg0K0G', NULL, NULL, '2024-08-01 20:58:55', '2024-08-15 16:19:54'),
(46, 'Lalan', 'Lalan', '$2y$10$yQ3b.UCMaFy2VEGAb/Qf0uw7jxN0/hJK0RjYyzR8O8JENfB1l9oRy', NULL, NULL, '2024-08-09 08:24:12', '2024-08-15 16:19:02'),
(48, 'Wanda', 'wanda', '$2y$10$TnV7bK5/Xo71Ui8dqPF.h.GGELKW1LNJHaSbRREWzpo5/Hb8j8PUu', NULL, NULL, '2024-08-15 16:24:36', '2024-08-15 16:24:36');

-- --------------------------------------------------------

--
-- Table structure for table `failed_jobs`
--

CREATE TABLE `failed_jobs` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `uuid` varchar(255) NOT NULL,
  `connection` text NOT NULL,
  `queue` text NOT NULL,
  `payload` longtext NOT NULL,
  `exception` longtext NOT NULL,
  `failed_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `kategoriwisata`
--

CREATE TABLE `kategoriwisata` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `nama` varchar(200) NOT NULL,
  `keterangan` varchar(500) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `kategoriwisata`
--

INSERT INTO `kategoriwisata` (`id`, `nama`, `keterangan`, `created_at`, `updated_at`) VALUES
(1, 'Wisata Alam', 'Wisata Tentang Panorama Alam', '2024-02-13 04:34:52', '2024-02-13 04:34:52'),
(2, 'Wisata Religi', 'Wisata tentang keagamaan', '2024-02-13 04:35:46', '2024-02-13 04:35:46'),
(5, 'Wisata Budaya', 'Wisata tentang kebudayaan', '2024-02-23 09:45:34', '2024-02-23 09:45:34');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `migrations`
--

INSERT INTO `migrations` (`id`, `migration`, `batch`) VALUES
(1, '2014_10_12_000000_create_users_table', 1),
(2, '2014_10_12_100000_create_password_reset_tokens_table', 1),
(3, '2019_08_19_000000_create_failed_jobs_table', 1),
(4, '2019_12_14_000001_create_personal_access_tokens_table', 1),
(5, '2023_07_02_105147_create_dataservis_table', 1),
(6, '2023_07_04_080858_create_bisadiambils_table', 1),
(7, '2023_07_09_033629_add_is_admin_to_users_table', 1),
(8, '2023_07_10_101526_create_sudahdiambils_table', 1),
(9, '2024_01_26_232728_create_tabeldaftarwisatas_table', 1),
(10, '2024_01_27_232902_create_kategoriwisata_table', 1),
(11, '2024_01_28_030053_create_akunwisatawan_table', 1),
(12, '2024_08_09_233747_create_pengunjungwisatas_table', 2);

-- --------------------------------------------------------

--
-- Table structure for table `password_reset_tokens`
--

CREATE TABLE `password_reset_tokens` (
  `email` varchar(255) NOT NULL,
  `token` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `pengunjungwisatas`
--

CREATE TABLE `pengunjungwisatas` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tanggal` varchar(200) NOT NULL,
  `nama` varchar(200) NOT NULL,
  `wisata` varchar(200) NOT NULL,
  `alamat` varchar(200) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `pengunjungwisatas`
--

INSERT INTO `pengunjungwisatas` (`id`, `tanggal`, `nama`, `wisata`, `alamat`, `created_at`, `updated_at`) VALUES
(1, '10 Agustus 2024', 'Ahmad', 'Jembatan Lingkar', 'Desa Wawoangi', NULL, NULL),
(2, '20 Agustus', 'Dwi', 'Bukit Rongi', 'Desa Rongi', NULL, NULL),
(3, '11 Agustus 2024', 'Wulani', 'Benteng Wawoangi', 'Desa Wawoangi', '2024-08-10 22:06:53', '2024-08-10 22:06:53'),
(4, '4 Agustus', 'Rizal', 'Jembatan', 'Ndauli', '2024-08-10 23:13:01', '2024-08-10 23:13:01'),
(5, '07/8/2024', 'Lalan', 'Teluk Sampolawa', 'Desa Tira', '2024-08-10 23:36:03', '2024-08-15 12:45:34'),
(6, '07/8/2024', 'Karman', 'Puncak Kali Biru Wawoangi', 'Desa Wawoangi', '2024-08-10 23:46:54', '2024-08-15 12:44:19'),
(7, '07/8/2024', 'Wa Zulmiati', 'Mata Air Laloya', 'Desa Gunung Sejuk', '2024-08-11 00:13:23', '2024-08-15 12:44:44'),
(8, '09/8/2024', 'Herdin', 'Benteng Rongi', 'Desa Hendea', '2024-08-11 00:14:39', '2024-08-15 12:41:52'),
(9, '09/8/2024', 'Maman', 'Mata Air Wasalamata', 'Desa Wawoangi', '2024-08-12 23:29:26', '2024-08-15 12:40:58'),
(10, '09/8/2024', 'Wahyu', 'Gua Walupi Mokolona', 'Kelurahan Jayabakti', '2024-08-12 23:29:50', '2024-08-15 12:40:03'),
(11, '10/8/2024', 'Risman', 'Benteng Wawoangi', 'Desa Wawoangi', '2024-08-12 23:52:28', '2024-08-15 12:38:43'),
(12, '10/8/2024', 'Dwi', 'Pantai Lagunci', 'Desa Bahari', '2024-08-12 23:53:03', '2024-08-15 12:37:44'),
(15, '10/8/2024', 'Zulkifli', 'Masjid Tua Wawoangi', 'Desa Wawoangi', '2024-08-14 17:03:23', '2024-08-15 12:34:34'),
(16, '11/08/2024', 'Yulianti', 'Permandian Kampidi', 'Desa Watiginanda', '2024-08-14 17:09:51', '2024-08-15 12:33:49');

-- --------------------------------------------------------

--
-- Table structure for table `personal_access_tokens`
--

CREATE TABLE `personal_access_tokens` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tokenable_type` varchar(255) NOT NULL,
  `tokenable_id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `token` varchar(64) NOT NULL,
  `abilities` text DEFAULT NULL,
  `last_used_at` timestamp NULL DEFAULT NULL,
  `expires_at` timestamp NULL DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `personal_access_tokens`
--

INSERT INTO `personal_access_tokens` (`id`, `tokenable_type`, `tokenable_id`, `name`, `token`, `abilities`, `last_used_at`, `expires_at`, `created_at`, `updated_at`) VALUES
(1, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '72785f8ac7169d9ea1a29ff88bb6a7e43ab9edf9e335d7d7c781db6b99553eda', '[\"*\"]', NULL, NULL, '2024-02-13 15:35:11', '2024-02-13 15:35:11'),
(2, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '35296c1d7219660e4bb643717b1eaaf7583e0c5ceabead3e5a42f2c7fda60dfe', '[\"*\"]', NULL, NULL, '2024-02-13 15:44:53', '2024-02-13 15:44:53'),
(3, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '392e4a0be03e7433ed52c06d7220575ad001518f2f34237e64820d98f600500d', '[\"*\"]', NULL, NULL, '2024-02-13 15:46:38', '2024-02-13 15:46:38'),
(4, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '327270d4af1ea9230af9c64a54563d99b04619a40bd0a349669c06def16d4925', '[\"*\"]', NULL, NULL, '2024-02-13 15:49:24', '2024-02-13 15:49:24'),
(5, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6b845223dae45d707a72779037b6b8bbf14647b731e067f1c1d7fdefb2c61226', '[\"*\"]', NULL, NULL, '2024-02-13 15:52:26', '2024-02-13 15:52:26'),
(6, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0eec5a4bf651ec6e1013173d268df4b7a3edf34396727005b4b1c13039462b4f', '[\"*\"]', NULL, NULL, '2024-02-13 15:55:05', '2024-02-13 15:55:05'),
(7, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '45b3c5bb2ec4c36e2d172cd4743e9bcd097c445d7a25a6e7b98ce7507503513e', '[\"*\"]', NULL, NULL, '2024-02-13 15:58:00', '2024-02-13 15:58:00'),
(8, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2cbbb4a9bf9936541f2262bc1c6bd9e91b748a4ee14405eedb095a116b38d65c', '[\"*\"]', NULL, NULL, '2024-02-13 16:01:01', '2024-02-13 16:01:01'),
(9, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8d7a838c65df8266e9103ba00135bf625b29ab7f10c86136ef1102be313e799f', '[\"*\"]', NULL, NULL, '2024-02-13 16:03:43', '2024-02-13 16:03:43'),
(10, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b7ba3f94191f1aac882f9e3a1ab8634aa3c713b1fdefeae0b7e054819859476d', '[\"*\"]', NULL, NULL, '2024-02-13 16:07:12', '2024-02-13 16:07:12'),
(11, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6e971baa992221c1a753d1c15be18b48c9af785137402fd2ee85455b30b0a67e', '[\"*\"]', NULL, NULL, '2024-02-13 16:10:16', '2024-02-13 16:10:16'),
(12, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '55c298682b2d97f7883bf82d2f99b150bfcc78cddf20e8a3e3f4e0ddfdb8700d', '[\"*\"]', NULL, NULL, '2024-02-13 16:10:16', '2024-02-13 16:10:16'),
(13, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '440088a6ad5611315084f3b0f509552b700c8f233851a9040f6ff60ca08c63ec', '[\"*\"]', NULL, NULL, '2024-02-13 16:12:15', '2024-02-13 16:12:15'),
(14, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ddf346d59820db11ae1e70f984278f72e3b846960c06854b70ab75d10f009fa8', '[\"*\"]', NULL, NULL, '2024-02-13 16:14:27', '2024-02-13 16:14:27'),
(15, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5fa63012ee654a8ff80d8939763843d7f4f4fbfebbcf965cf9522b52dd69f5e5', '[\"*\"]', NULL, NULL, '2024-02-13 16:17:50', '2024-02-13 16:17:50'),
(16, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6c5e68875de3b8debf2085c8ee91f2003a2340baad95f27d597094ea4f7062b9', '[\"*\"]', NULL, NULL, '2024-02-13 16:21:42', '2024-02-13 16:21:42'),
(17, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7202fc8a24ba356fc2d3afff045c475daf286951358e3e3c0fe5173aa7e5ed94', '[\"*\"]', NULL, NULL, '2024-02-13 16:21:44', '2024-02-13 16:21:44'),
(18, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd73d5a1a26f371833c43ed0882490549ed62e637650167c7db6c03d93834fbd6', '[\"*\"]', NULL, NULL, '2024-02-13 16:40:44', '2024-02-13 16:40:44'),
(19, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '67cc3b6b608e7019920340826cbd1c22c9a88d6438c30aea9ba77d07303b9749', '[\"*\"]', NULL, NULL, '2024-02-13 16:46:17', '2024-02-13 16:46:17'),
(20, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ec2faa1941cf0f07b1d2c3a7c569e2992f553e111e5a6157907c99dd5f937656', '[\"*\"]', NULL, NULL, '2024-02-13 16:49:56', '2024-02-13 16:49:56'),
(21, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'dd3ba5f79b432ba5e155425c1b77a92eaa54ddda1f2305c9f9fe9de73bda01a2', '[\"*\"]', NULL, NULL, '2024-02-13 16:58:29', '2024-02-13 16:58:29'),
(22, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '306459dbf76f484d2c22b7b46bf4135c8db9d8e0bd1d9fd2f5ecbfdac32a1ec0', '[\"*\"]', NULL, NULL, '2024-02-13 17:03:22', '2024-02-13 17:03:22'),
(23, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1719b1c025b3f2a445495956693722942d7f5e412e0018ceec7a8fae91ac9cf4', '[\"*\"]', NULL, NULL, '2024-02-13 17:03:34', '2024-02-13 17:03:34'),
(24, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '503bcfe1057f46c466e502b8f96e330346d021afc3a450ff112d5ef4935928b3', '[\"*\"]', NULL, NULL, '2024-02-13 17:06:39', '2024-02-13 17:06:39'),
(25, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f004e547a31280e230367dedeb99dea2aaa968f876ff043a75c2dc952a605f2d', '[\"*\"]', NULL, NULL, '2024-02-13 17:07:31', '2024-02-13 17:07:31'),
(26, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b2996ec105ce59a625168edf33cf70b115030e1025dca47dcc87445e79f8d922', '[\"*\"]', NULL, NULL, '2024-02-13 17:07:34', '2024-02-13 17:07:34'),
(27, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '822dc74321b200fdf6385b91b30030a90adb7816a0765625148bf23a6aeb8f1b', '[\"*\"]', NULL, NULL, '2024-02-13 17:09:05', '2024-02-13 17:09:05'),
(28, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b8a57a8be0541c78a81a5371396110e30c6530f4b18da43b39f7a6fe9ee51299', '[\"*\"]', NULL, NULL, '2024-02-13 17:09:42', '2024-02-13 17:09:42'),
(29, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '794e35399c4cf83d9df2687acd7520fd0d3a9e120c06bfd0683b16b859a6e594', '[\"*\"]', NULL, NULL, '2024-02-13 17:13:16', '2024-02-13 17:13:16'),
(30, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f57408247e5df8fbb23689dda19583076f1efb2c2e6a63cd97e3a07a0d21f799', '[\"*\"]', NULL, NULL, '2024-02-13 17:15:37', '2024-02-13 17:15:37'),
(31, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '561f36177e8106733a3ed9e50eea2aac901fdd7a4a8e6a6fe71d3bf88f9f999d', '[\"*\"]', NULL, NULL, '2024-02-13 17:17:16', '2024-02-13 17:17:16'),
(32, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4af60c0cd08c4062fca0d638804cbaaf46473a1eccd29b99bf6693f7960ceb97', '[\"*\"]', NULL, NULL, '2024-02-13 17:18:21', '2024-02-13 17:18:21'),
(33, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6e83886f9d07d77d3d8e3da9cc3aa260ef8a490bae9fbba5556d2392ad989547', '[\"*\"]', NULL, NULL, '2024-02-13 17:18:23', '2024-02-13 17:18:23'),
(34, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b60f6da44cdf656585207fd0ba78604c3b123c0cd9ea62116ab9b1975629a020', '[\"*\"]', NULL, NULL, '2024-02-13 17:18:24', '2024-02-13 17:18:24'),
(35, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6a0dec5f89e68c67409a2cf8ec28bed247d5de27345e0e57883d8832541fd207', '[\"*\"]', NULL, NULL, '2024-02-13 17:18:26', '2024-02-13 17:18:26'),
(36, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9b625904568e7f1c9e528a4fb47826eb483218c9463837f472adea68bb6f5e33', '[\"*\"]', NULL, NULL, '2024-02-13 17:21:13', '2024-02-13 17:21:13'),
(37, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5df0ca3ca31a290bddb68d830287d1bc51341fe809a84ede972022d6f814f9c9', '[\"*\"]', NULL, NULL, '2024-02-13 17:23:22', '2024-02-13 17:23:22'),
(38, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '71739f50627242d11a6837da46a929c3cee95342aaa90dfb480a31173c78b304', '[\"*\"]', NULL, NULL, '2024-02-13 17:23:55', '2024-02-13 17:23:55'),
(39, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f3d5a63c12bad02332bfdbcc50b19d1d8ec910f197579853145bea22fb0ffbf7', '[\"*\"]', NULL, NULL, '2024-02-14 04:27:31', '2024-02-14 04:27:31'),
(40, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '68eee3ee8aeb387a481e903be23851c37d58e448d24e4a17512de6dfaa1302cb', '[\"*\"]', NULL, NULL, '2024-02-14 04:34:22', '2024-02-14 04:34:22'),
(41, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'bfa4f5f817af5496354af6c33ff6961265020007f44f3ce3c3df7b51c748d6a7', '[\"*\"]', NULL, NULL, '2024-02-14 04:36:01', '2024-02-14 04:36:01'),
(42, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '24dfe3a887030e99222b3052f8460a3b13944f8e63073c880ffb336bd0ae92fe', '[\"*\"]', NULL, NULL, '2024-02-14 04:38:47', '2024-02-14 04:38:47'),
(43, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '096885bc7e89cd35cc5581ea3582dd6223cbce6aa2e316e1086a187a005528cf', '[\"*\"]', NULL, NULL, '2024-02-14 04:40:08', '2024-02-14 04:40:08'),
(44, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '22ba428d4f9449d11f9baed0f6519fd97a0a3a34a8eb13e5386c1e20376a4f95', '[\"*\"]', NULL, NULL, '2024-02-14 04:43:37', '2024-02-14 04:43:37'),
(45, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'cf7658de3c96ecf6a7be374b8b8e24ab8bbb441df3b02d6d98a927086d34183c', '[\"*\"]', NULL, NULL, '2024-02-14 04:47:04', '2024-02-14 04:47:04'),
(46, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd6b3d026fd3a38d5699b32be5de715ea62ac31c09bda7743298d94829f4a4986', '[\"*\"]', NULL, NULL, '2024-02-14 04:47:53', '2024-02-14 04:47:53'),
(47, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2f8884b2b5cc6fa809475ae0284a6196f6f172f1d25fd108df8dacaf852b3c93', '[\"*\"]', NULL, NULL, '2024-02-14 04:48:51', '2024-02-14 04:48:51'),
(48, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'df81c00fb4bd77108d02479d39838546f367bed451f9d8b0362146c271fe429d', '[\"*\"]', NULL, NULL, '2024-02-14 04:49:47', '2024-02-14 04:49:47'),
(49, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '50b09b05162aa1e3d1a191c5ef350d5f4ef111afff82f9c2726dbafc400188e5', '[\"*\"]', NULL, NULL, '2024-02-14 04:53:43', '2024-02-14 04:53:43'),
(50, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'cc553627dc9d3dd753acde841db0c7aede85e9af2bdbd2c992892c08490c843b', '[\"*\"]', NULL, NULL, '2024-02-14 04:54:42', '2024-02-14 04:54:42'),
(51, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '390f9682591cc10f911faeaf046764553d41a991d219875ddf81eff78c05d46f', '[\"*\"]', NULL, NULL, '2024-02-14 04:56:58', '2024-02-14 04:56:58'),
(52, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '483d991d4dcf16e32d4f9d489e7a3e3639a801bcfd8953d6e87fa9334fcab1a4', '[\"*\"]', NULL, NULL, '2024-02-14 05:01:38', '2024-02-14 05:01:38'),
(53, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6e87f2f627ebb377e8daa7dbe31e9face91aebb5664551ecce7f098fb2d4b976', '[\"*\"]', NULL, NULL, '2024-02-14 05:01:54', '2024-02-14 05:01:54'),
(54, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b1f1c9e65322a06f0bf60cf12b62d429e90afa8520d4234334d70c5b5e500ca9', '[\"*\"]', NULL, NULL, '2024-02-14 05:06:45', '2024-02-14 05:06:45'),
(55, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '071aacdbc0fade4c9c64ec0b4259175b45d0a5d8be3d377c57babf469928189f', '[\"*\"]', NULL, NULL, '2024-02-14 05:10:17', '2024-02-14 05:10:17'),
(56, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd9527058daf5fa68b81689fe1c13e01cca5c544c5130cffe0cf7ae3e0edf9e4a', '[\"*\"]', NULL, NULL, '2024-02-14 05:13:33', '2024-02-14 05:13:33'),
(57, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '3a17ff1403b0cf48626ce2cbf4b46ce76b87a94fdfb13cf7fc2bf82b00582a65', '[\"*\"]', NULL, NULL, '2024-02-14 05:28:47', '2024-02-14 05:28:47'),
(58, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '651a25b6e8bce5ee4268071de1535a3d29f8979e04bddcefd6436b0fd0a75f3c', '[\"*\"]', NULL, NULL, '2024-02-14 05:31:15', '2024-02-14 05:31:15'),
(59, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'bd515c96292864357beb05db98dab184f0b21e9de6cdb423b5fa151dfa92f777', '[\"*\"]', NULL, NULL, '2024-02-14 05:40:02', '2024-02-14 05:40:02'),
(60, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '34aef59324da361b0a0f7b4aaad09030999deed6b4f4504f9ab14388c6d705c2', '[\"*\"]', NULL, NULL, '2024-02-14 05:41:58', '2024-02-14 05:41:58'),
(61, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2952de925b6f870e01ec3a1f4052dda4b30e6a730d1031985834f617339a251b', '[\"*\"]', NULL, NULL, '2024-02-14 05:47:41', '2024-02-14 05:47:41'),
(62, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5f2abb120add87bf3a745f6db6457c3ad5ef5f168c81bb0170af7d5c6966e086', '[\"*\"]', NULL, NULL, '2024-02-14 05:51:51', '2024-02-14 05:51:51'),
(63, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a1752f9fce8d88180648e93a2c23e9b5e1d7960222e5caab8a85672a86cd527f', '[\"*\"]', NULL, NULL, '2024-02-14 05:56:40', '2024-02-14 05:56:40'),
(64, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'bd313cfe56708c94cb872eee550a4be885a913a3a6a568b041abdefff730ea0f', '[\"*\"]', NULL, NULL, '2024-02-14 06:01:55', '2024-02-14 06:01:55'),
(65, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4b1f0903d70fd4e3718b26b63beb1aaefbed20646d68687294fc85eb0a5cf5bd', '[\"*\"]', NULL, NULL, '2024-02-14 06:01:57', '2024-02-14 06:01:57'),
(66, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4e4f009f7abbb7dce2d2b6d8c8d33077f41844a2e56bff8dd38838096766603b', '[\"*\"]', NULL, NULL, '2024-02-14 06:12:53', '2024-02-14 06:12:53'),
(67, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '3f864f2ee04718343b1f378f4faff01f25fd20b059b33fa660791029dccf8bea', '[\"*\"]', NULL, NULL, '2024-02-14 06:17:21', '2024-02-14 06:17:21'),
(68, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '3439d31a80ca4dba9f38358d6cf7e01c855a278d0acca0370c472a8bd84b39b0', '[\"*\"]', NULL, NULL, '2024-02-14 06:27:59', '2024-02-14 06:27:59'),
(69, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c47463774d52e8ddf8a375d04ee8ecc3b982c654020704abd574358d7c2272ce', '[\"*\"]', NULL, NULL, '2024-02-14 06:28:01', '2024-02-14 06:28:01'),
(70, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9baad2a0ed816710846db2fcf82f8ad2b8a20fa364e0f4b6b4f384f43f889a4c', '[\"*\"]', NULL, NULL, '2024-02-14 06:35:54', '2024-02-14 06:35:54'),
(71, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a86b4ab4e7f4c9aab038df5a24c2b9a95cdcc66477048058f5747eedf61c4a81', '[\"*\"]', NULL, NULL, '2024-02-14 07:21:55', '2024-02-14 07:21:55'),
(72, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '13ee4b3678a38e0189726012616f4ff4aadf25cfac00ba7b7510f5d2c707bfda', '[\"*\"]', NULL, NULL, '2024-02-14 07:21:57', '2024-02-14 07:21:57'),
(73, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '293bf65deaed8e96595b7df5548f414a7ccab76ebce145ca067cfccf4868f3d7', '[\"*\"]', NULL, NULL, '2024-02-14 07:21:58', '2024-02-14 07:21:58'),
(74, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6d9757a3549395d8d7746522d7b738429571314e03f0ef3895aa40e4c6d1554f', '[\"*\"]', NULL, NULL, '2024-02-14 07:21:59', '2024-02-14 07:21:59'),
(75, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6c44eae81176fd1170c96bce155c5a1e7f4850c4e70af6806e386e6e3b27b064', '[\"*\"]', NULL, NULL, '2024-02-14 07:21:59', '2024-02-14 07:21:59'),
(76, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '200813e7f28df33f7d453b3295a0d6fb0c236043520e14a88f6c45a8acedea61', '[\"*\"]', NULL, NULL, '2024-02-14 07:22:00', '2024-02-14 07:22:00'),
(77, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4b338cd1cd15913a45d2810dd0655204b9f1b3670be91877f4c7797c94ef474c', '[\"*\"]', NULL, NULL, '2024-02-14 07:22:01', '2024-02-14 07:22:01'),
(78, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c803f8af2a596e308a3eca8d5e22900440b1c592f9030069862cded3b9286f3e', '[\"*\"]', NULL, NULL, '2024-02-14 07:22:01', '2024-02-14 07:22:01'),
(79, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '56f9a2fa065314e10f958b7dadb9180fc961a8107776b0fa846604de60ffe41d', '[\"*\"]', NULL, NULL, '2024-02-14 07:22:02', '2024-02-14 07:22:02'),
(80, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '59e112680aae513bcc57997898142f01dae46ab9cae3d349fc5a7404b249acc8', '[\"*\"]', NULL, NULL, '2024-02-14 07:31:34', '2024-02-14 07:31:34'),
(81, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'aa0d487c6c2b46df6067d01efcb04b4c32782c7e2ef53cc282e92109f7911de7', '[\"*\"]', NULL, NULL, '2024-02-14 07:32:50', '2024-02-14 07:32:50'),
(82, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5af7ee5c045bf3b3adf175ba49783bb64f9ad4ba980d622bd680b1ae748141ca', '[\"*\"]', NULL, NULL, '2024-02-14 07:35:52', '2024-02-14 07:35:52'),
(83, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '44813665a49361ef210523340a305f474a83a5b9a68b56395910da445a0a7628', '[\"*\"]', NULL, NULL, '2024-02-14 07:36:19', '2024-02-14 07:36:19'),
(84, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f4319244a39c4a40c662d93e13c2c2901417a28153cf8ab0d0b9d5bd9631d483', '[\"*\"]', NULL, NULL, '2024-02-14 07:37:06', '2024-02-14 07:37:06'),
(85, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd7c1988aa5e94295cce71662691f1e4a20e7c3a45421ea56b6ca6ebf87e8c372', '[\"*\"]', NULL, NULL, '2024-02-14 07:38:27', '2024-02-14 07:38:27'),
(86, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '991d7c892b63068152011c4799af4f2cd7cda0647c8a01ece6b0518ff01a2447', '[\"*\"]', NULL, NULL, '2024-02-14 07:39:05', '2024-02-14 07:39:05'),
(87, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '430b32eb306a5c2a537ce3d58604b2d52bdad28b23d845b111d462f53102808a', '[\"*\"]', NULL, NULL, '2024-02-14 07:39:55', '2024-02-14 07:39:55'),
(88, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '3c427a05a214348d785dd78f6bef9e8101a33155845ad16497ab9dd1068f420e', '[\"*\"]', NULL, NULL, '2024-02-14 07:40:35', '2024-02-14 07:40:35'),
(89, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9018d7ad1a2e22947b8dc543a1dd776a1e37fb688432d20e548ab6983f2727f5', '[\"*\"]', NULL, NULL, '2024-02-14 07:41:46', '2024-02-14 07:41:46'),
(90, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1ec3aa51f7ab37942bee8c530b935eaadc3b41b6208e4c8708f7718ed203a3fa', '[\"*\"]', NULL, NULL, '2024-02-14 07:41:48', '2024-02-14 07:41:48'),
(91, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f14ef89b778e27fec0e2bd2fd1b137035723d276933d690e28f40ed688af5a73', '[\"*\"]', NULL, NULL, '2024-02-14 07:41:49', '2024-02-14 07:41:49'),
(92, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f929a0022b39c6db03d6af2e4c62da2185ff53fafdbeda3e01001cd831d923bd', '[\"*\"]', NULL, NULL, '2024-02-14 07:43:59', '2024-02-14 07:43:59'),
(93, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '88df0d03958bb38fc7523e40622a8b18613ddbf3b82b0d1c9336211ff6a975fd', '[\"*\"]', NULL, NULL, '2024-02-14 07:47:48', '2024-02-14 07:47:48'),
(94, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b8d20253a078606f8eb4126b550d38c9c59c58ae8ccb7af2a21a041dbda6a96c', '[\"*\"]', NULL, NULL, '2024-02-14 07:50:39', '2024-02-14 07:50:39'),
(95, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '32559f7eca3513a99aabf57b9bf50c3e72e62ee1c6f867d129d0954a6377e651', '[\"*\"]', NULL, NULL, '2024-02-14 07:51:20', '2024-02-14 07:51:20'),
(96, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a0cf28969653aa777541e8e3bcc2576186122f6decc5823977aad6b1be425357', '[\"*\"]', NULL, NULL, '2024-02-14 07:52:20', '2024-02-14 07:52:20'),
(97, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ebf8d126a4a567184422ac735799c9cc1aa543a42fd5fcb767b0f803317ff022', '[\"*\"]', NULL, NULL, '2024-02-14 07:54:09', '2024-02-14 07:54:09'),
(98, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9158d54a0b40747d57c7990070ca584dce407992613e1797af4789940b425f75', '[\"*\"]', NULL, NULL, '2024-02-14 07:54:26', '2024-02-14 07:54:26'),
(99, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'e972200958862615c55c21b1956ee9aef46b0e7eaf3cb4cc7fb5c05212d8f8f9', '[\"*\"]', NULL, NULL, '2024-02-14 07:55:48', '2024-02-14 07:55:48'),
(100, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '777c34c2839965ab854d54c76ca14f5fb5e86782b57c18ee9eda848cba895c3b', '[\"*\"]', NULL, NULL, '2024-02-14 07:56:27', '2024-02-14 07:56:27'),
(101, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c5fbb6154b2581434ef25ac3d101634ed3f6e110932e31ee44305d7c97f3bb8d', '[\"*\"]', NULL, NULL, '2024-02-14 07:57:21', '2024-02-14 07:57:21'),
(102, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '45b813f4734223ca00b12e848ae6335baeb95c89f021edf3fa37df4cc2ddb222', '[\"*\"]', NULL, NULL, '2024-02-14 07:58:41', '2024-02-14 07:58:41'),
(103, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '001327a6aacc0dca8e90293ca8e1edbaded2774d7beca790fd87c0275f12f2fc', '[\"*\"]', NULL, NULL, '2024-02-14 08:00:32', '2024-02-14 08:00:32'),
(104, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '04e22bfaa9f22999c244407f41e4d7918e1886db4b6b4ef75c618283d71eb83f', '[\"*\"]', NULL, NULL, '2024-02-14 08:02:32', '2024-02-14 08:02:32'),
(105, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f648b268e13d005e87c4837aaf2d2c20e19d8450fbbaf5f4eed72a79ae6347d0', '[\"*\"]', NULL, NULL, '2024-02-14 08:04:00', '2024-02-14 08:04:00'),
(106, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '596dc562d560b6ee529ba5c186b79fdd1f9a5c51fe5f6c5055a0bf6fd6df39e3', '[\"*\"]', NULL, NULL, '2024-02-14 08:07:52', '2024-02-14 08:07:52'),
(107, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f7422582e8ae1f70fdcd04964c7aa555604b10788e242495e324e469712314ea', '[\"*\"]', NULL, NULL, '2024-02-14 08:12:22', '2024-02-14 08:12:22'),
(108, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '35fdb7c4d0abb663444d94d04360fe3576e5bd64d3ed7d2aba4c56bcfaf8e9f7', '[\"*\"]', NULL, NULL, '2024-02-14 08:12:43', '2024-02-14 08:12:43'),
(109, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9e8699496f14b2097a133baa855f146ed7ba0a8c4f9f98ccafa26886d2b49801', '[\"*\"]', NULL, NULL, '2024-02-14 08:14:47', '2024-02-14 08:14:47'),
(110, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f5cd5fce90cd02365fd7b791c83ef21a009e855ca1235b7e18ac10ba5333ed71', '[\"*\"]', NULL, NULL, '2024-02-14 08:16:13', '2024-02-14 08:16:13'),
(111, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0556a02b629a6248fab1aa639513eb2459c2427944252e0c8a3184ab760e171b', '[\"*\"]', NULL, NULL, '2024-02-14 08:17:19', '2024-02-14 08:17:19'),
(112, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0b2f672a637f6468d22eb1905578b8efd13450667eaaf0c2438092ada2342781', '[\"*\"]', NULL, NULL, '2024-02-14 08:19:22', '2024-02-14 08:19:22'),
(113, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd5f1e99448bc11ea8b4b6d91192ccd833d08f23d91b475b0c4b053d239d438f2', '[\"*\"]', NULL, NULL, '2024-02-14 08:21:19', '2024-02-14 08:21:19'),
(114, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0064953d87189ee616adf6dc2d391c2cdd9f27bb63304b85fe08c9a6ab5f6478', '[\"*\"]', NULL, NULL, '2024-02-14 08:22:51', '2024-02-14 08:22:51'),
(115, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a117a312acb29df81964272801b058ca7ff65bdaac7ae0243bf3fe66df71a8b8', '[\"*\"]', NULL, NULL, '2024-02-14 08:26:13', '2024-02-14 08:26:13'),
(116, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1c827742d3ed494af1487f873e34647d1d9849a5cbc5dc47c950ab571acc2ad1', '[\"*\"]', NULL, NULL, '2024-02-14 08:27:18', '2024-02-14 08:27:18'),
(117, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1e785d78bc21941632a397585aa3a904ba3d850faaed4bea2ec046fb46709c57', '[\"*\"]', NULL, NULL, '2024-02-14 08:34:13', '2024-02-14 08:34:13'),
(118, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '676e38da17fc9b673743812997535625460910d9a5cda524967b042755b490ff', '[\"*\"]', NULL, NULL, '2024-02-14 08:35:38', '2024-02-14 08:35:38'),
(119, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c75b464593e03cc02d97a64fc512ec07f40e4c7b223ab931d9615dfb7afb6ef3', '[\"*\"]', NULL, NULL, '2024-02-14 08:37:18', '2024-02-14 08:37:18'),
(120, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ababd80d2e354de72a507480dbfb626ad516f0a35245720d54809db2a794a3d0', '[\"*\"]', NULL, NULL, '2024-02-14 08:38:38', '2024-02-14 08:38:38'),
(121, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b60b4444e1e2d6b1d6d432dcf020829f85e3760c666b071e4966af24a1d597d0', '[\"*\"]', NULL, NULL, '2024-02-14 08:39:19', '2024-02-14 08:39:19'),
(122, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd47285e60cfc6b7055305d22502984601f82715f13257ac6e9f4a5440fee9a98', '[\"*\"]', NULL, NULL, '2024-02-14 08:42:40', '2024-02-14 08:42:40'),
(123, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c717ec6b320fc7e2e852352a85dfd326907b8e2e1ddf412450753e20265a53bf', '[\"*\"]', NULL, NULL, '2024-02-14 08:44:44', '2024-02-14 08:44:44'),
(124, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b5c19917bbf2612dacf902191da0ce26b3a862d70532cd19d388fd419b97a052', '[\"*\"]', NULL, NULL, '2024-02-14 08:44:47', '2024-02-14 08:44:47'),
(125, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b7f52caef53cb5cb35f9c35dd8e4e97b502fa954868a3763bc422a3983479a66', '[\"*\"]', NULL, NULL, '2024-02-14 08:49:47', '2024-02-14 08:49:47'),
(126, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'e6537c9a5b2634da8f71a208e6080a9521cda22ec9937cd7876c2e49751f8280', '[\"*\"]', NULL, NULL, '2024-02-14 08:55:26', '2024-02-14 08:55:26'),
(127, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ff3568df76be04e8916e32bb61b2186d13aadc1037c7bcd381e3b1ba9a41a6b3', '[\"*\"]', NULL, NULL, '2024-02-14 08:57:52', '2024-02-14 08:57:52'),
(128, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1635c4832b5ab4fcf79a339b5a569cf6143aed03c48da11c446df422cd14e5ec', '[\"*\"]', NULL, NULL, '2024-02-14 09:00:59', '2024-02-14 09:00:59'),
(129, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'be5aea66ca795af99b5252e36f5b25eb4c310c09f43600e46b2e7d18c38c72bf', '[\"*\"]', NULL, NULL, '2024-02-14 09:02:39', '2024-02-14 09:02:39'),
(130, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ef359542af37969528c0c273770affe2577b09d4180d1bc297bbfdd64dbceeab', '[\"*\"]', NULL, NULL, '2024-02-14 09:08:07', '2024-02-14 09:08:07'),
(131, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5896cb975e9f8ecd2db804188e230ab7a497530a5b1098e36dba2b682be18ee7', '[\"*\"]', NULL, NULL, '2024-02-14 09:10:06', '2024-02-14 09:10:06'),
(132, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '63aead0e40159b59afd16052c256f0ee9928a60912898fab9d67c133b24c156e', '[\"*\"]', NULL, NULL, '2024-02-14 09:17:31', '2024-02-14 09:17:31'),
(133, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4583b401b70ac74ee179dda23474027b4cc80b35833225e454667cf8da03ecb8', '[\"*\"]', NULL, NULL, '2024-02-14 09:19:27', '2024-02-14 09:19:27'),
(134, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9aa3d59cdae08b4e34110f8f5de73f8a293e1d2dad6e6b8f7eb0968ef9dec0e6', '[\"*\"]', NULL, NULL, '2024-02-14 09:21:26', '2024-02-14 09:21:26'),
(135, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '974e98ae3317d3e09ba19df230f0785f1446fec7c8c4002e2714e9c33c0bc76c', '[\"*\"]', NULL, NULL, '2024-02-14 09:21:27', '2024-02-14 09:21:27'),
(136, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'fd539dc003b7504c64707c70903c0df3a91015413c5be7d09c723f248eb792a5', '[\"*\"]', NULL, NULL, '2024-02-14 09:21:27', '2024-02-14 09:21:27'),
(137, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'e2623cfb1370b87961a5b2a0da036fd65832635ddb6e8f795cc9174a138a6b10', '[\"*\"]', NULL, NULL, '2024-02-14 09:21:49', '2024-02-14 09:21:49'),
(138, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '105e6ec48c0c491229ef41f028694bd3f3752a009585ef9351a42478fe0656fc', '[\"*\"]', NULL, NULL, '2024-02-14 09:28:50', '2024-02-14 09:28:50'),
(139, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a91bc7de2a80b369967244cce64b66f6715a56cb68ec0ff117a541fd1bb0e103', '[\"*\"]', NULL, NULL, '2024-02-14 09:30:43', '2024-02-14 09:30:43'),
(140, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '637a4aa19cbd6073d1a4f34bfa2ccf458f8c0606f784ca8d81785890f626b155', '[\"*\"]', NULL, NULL, '2024-02-14 09:32:31', '2024-02-14 09:32:31'),
(141, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '304822bf74e3b638ffcc4f602da21ed28645f80e8ddfd9f56d9b6845d3cc3ebd', '[\"*\"]', NULL, NULL, '2024-02-14 09:35:33', '2024-02-14 09:35:33'),
(142, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0b9a03723587babd42f830fc9b6389f04cd6f3216d2c305d633817970c07e97d', '[\"*\"]', NULL, NULL, '2024-02-14 09:41:07', '2024-02-14 09:41:07'),
(143, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1d0ea79f2afe14266169623bdce0ab869bbb3702e719544f744f541f129bef28', '[\"*\"]', NULL, NULL, '2024-02-14 09:44:39', '2024-02-14 09:44:39'),
(144, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ecb3aff30448c3ba818d65f13282568d7b719e9c9557de5fccae376d33243fbb', '[\"*\"]', NULL, NULL, '2024-02-14 09:53:14', '2024-02-14 09:53:14'),
(145, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0d64a9183ecf69b6b8aa0b9c8eab474f82abeb9e621a3b979bbd7bf62842388b', '[\"*\"]', NULL, NULL, '2024-02-14 09:57:19', '2024-02-14 09:57:19'),
(146, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '3aeda71266356784a7716429ca0c216c750c1423635d68c82999d5e26dcede68', '[\"*\"]', NULL, NULL, '2024-02-14 10:04:29', '2024-02-14 10:04:29'),
(147, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a3fbbbd08fb98579727794796fe620a5a53a1f34233b9003d3a0bd789a7097ab', '[\"*\"]', NULL, NULL, '2024-02-14 10:05:47', '2024-02-14 10:05:47'),
(148, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ff7aae2d972eaf03543cee6b4ed74b8f528e0feb91fd7ec9b2cf4a5dbb92f87d', '[\"*\"]', NULL, NULL, '2024-02-14 10:08:54', '2024-02-14 10:08:54'),
(149, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8084570be233435fd1217d91dab4a062bc3336f8b31950c860f5a0b91b64a132', '[\"*\"]', NULL, NULL, '2024-02-14 10:11:04', '2024-02-14 10:11:04'),
(150, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '15d52ad37e7cf68661e0010634338d80baae8a4612e40335d03743414718d86e', '[\"*\"]', NULL, NULL, '2024-02-14 10:12:32', '2024-02-14 10:12:32'),
(151, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '83d8398d1cfa23796b3bed0a617bb8047fc467223796bc8f3065a47cb665fe94', '[\"*\"]', NULL, NULL, '2024-02-14 10:13:34', '2024-02-14 10:13:34'),
(152, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '560ef60b1d71759be5c4d801c0983629ca3eb282b520c4eb425b802e51f163e2', '[\"*\"]', NULL, NULL, '2024-02-14 10:14:27', '2024-02-14 10:14:27'),
(153, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '697537b5a953b68464167ff1563499b46b9f92b5e497526ba40a189e88cbad98', '[\"*\"]', NULL, NULL, '2024-02-14 10:15:28', '2024-02-14 10:15:28'),
(154, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '74f2b82f51abc8dac70839fd3909acc6a78bb163a98ea6b05773a2e3498120b7', '[\"*\"]', NULL, NULL, '2024-02-14 10:15:44', '2024-02-14 10:15:44'),
(155, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd7ff07b35b1092bbbb960a87837a5080124b9b57ebd921f7c1140af9f79a0d7a', '[\"*\"]', NULL, NULL, '2024-02-14 10:18:22', '2024-02-14 10:18:22'),
(156, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '3cf46362dd230b7db081839def576385a41cc16bca671508e08e53c7ca5800ec', '[\"*\"]', NULL, NULL, '2024-02-14 10:22:55', '2024-02-14 10:22:55'),
(157, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'be3efa3f1be58a8835ff32f0d5fe9c62e63fc33cf3eac12533eff95ab8cb10ae', '[\"*\"]', NULL, NULL, '2024-02-14 10:24:13', '2024-02-14 10:24:13'),
(158, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '50321a4ee9cec24497eec2a1c5587b0de17c28f3da055915813defece2bc5158', '[\"*\"]', NULL, NULL, '2024-02-14 10:24:45', '2024-02-14 10:24:45'),
(159, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f733fa9a6471d57c3319b35924fc37a37e75bda3e8131a1ee2950cc11646ef70', '[\"*\"]', NULL, NULL, '2024-02-14 10:29:09', '2024-02-14 10:29:09'),
(160, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '371994135b29892a25eee20614f25217fb2adf6936017570248111b2ce46840e', '[\"*\"]', NULL, NULL, '2024-02-14 10:30:46', '2024-02-14 10:30:46'),
(161, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2b81fe51f10c419fbccb9d3981827ad159f730151c3e5be3c5e2809106bb091c', '[\"*\"]', NULL, NULL, '2024-02-14 10:33:03', '2024-02-14 10:33:03'),
(162, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8a5bcd51dc2267d76ecdf8a2d992413373c353ac4ab2e038294c2851be8af79e', '[\"*\"]', NULL, NULL, '2024-02-14 10:50:50', '2024-02-14 10:50:50'),
(163, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c0a78dc3463f2ed5977489e053a3660fd56b69e229ee8363e7d79acf2f72f27b', '[\"*\"]', NULL, NULL, '2024-02-14 10:51:24', '2024-02-14 10:51:24'),
(164, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'bdaa18834da929d1a238437f410219829a2c7674b3837d9fcff2951f18b3a5b2', '[\"*\"]', NULL, NULL, '2024-02-14 10:52:24', '2024-02-14 10:52:24'),
(165, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '3b4bd3c9142f285df7ba0f52d1a31e38f2b6f613da7948bb2c0a02627f87115a', '[\"*\"]', NULL, NULL, '2024-02-14 10:53:31', '2024-02-14 10:53:31'),
(166, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd389734d1ca2a2a6a365be6af6dbc12396f80e79b7687281a2e1942a2f346cda', '[\"*\"]', NULL, NULL, '2024-02-14 10:54:27', '2024-02-14 10:54:27'),
(167, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'fcfa7f35ee57c9b07bfa3f7208b4c4540ea097df2c8b3097b10ef8b36ded73b7', '[\"*\"]', NULL, NULL, '2024-02-14 10:55:23', '2024-02-14 10:55:23'),
(168, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'dd81072d881eb27b1fe31d52ca38860b3873cbeafa2ac55c2e6810e2e4ead407', '[\"*\"]', NULL, NULL, '2024-02-14 10:57:01', '2024-02-14 10:57:01'),
(169, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b683b0daad4356f12792601a7046926d87b709c241d67ffd672072271e01b3b7', '[\"*\"]', NULL, NULL, '2024-02-14 20:59:02', '2024-02-14 20:59:02'),
(170, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f84012a4dfaf02990525d85e0358f415f826ca4a02ca87d8e6fa3e9b695e6dda', '[\"*\"]', NULL, NULL, '2024-02-14 20:59:03', '2024-02-14 20:59:03'),
(171, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4a346d8bc5fe1ac48a339eef34565b145c70d82590012d6448d7e6aca1f0c84e', '[\"*\"]', NULL, NULL, '2024-02-15 15:47:00', '2024-02-15 15:47:00'),
(172, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '89a069cd034b30f3f5017196c5c682a83b692eac617d28f8fd264a253981933c', '[\"*\"]', NULL, NULL, '2024-02-15 15:51:13', '2024-02-15 15:51:13'),
(173, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '30ea65c71db29d0abfd34968322210388d154c8f3986c6930c204f7b322b3f95', '[\"*\"]', NULL, NULL, '2024-02-15 21:41:49', '2024-02-15 21:41:49'),
(174, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6113898b32cb99d044b4bc4432452c423aeb98039da596da3ca6bcf9bdff11f5', '[\"*\"]', NULL, NULL, '2024-02-15 21:41:52', '2024-02-15 21:41:52'),
(175, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c821d8def705d0bb9767d23e01db0f4726c3dc4339f2c1124f11570740031a5c', '[\"*\"]', NULL, NULL, '2024-02-15 21:41:52', '2024-02-15 21:41:52'),
(176, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'dd7b2e552c27e74256face58fdee19a7e3c703ff9b59b790b5d405954dfb5a9e', '[\"*\"]', NULL, NULL, '2024-02-15 21:41:53', '2024-02-15 21:41:53'),
(177, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4839b9363fce93c532ecc22e424371bac9426159a7c5aa31d45ca2acb8c7e9e4', '[\"*\"]', NULL, NULL, '2024-02-15 21:41:54', '2024-02-15 21:41:54'),
(178, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b5ec01353e07e4f910d1a86a2569f365fb0e2ac562cafc0ca24d09914eb952b6', '[\"*\"]', NULL, NULL, '2024-02-15 21:41:55', '2024-02-15 21:41:55'),
(179, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8b501407614f6e5d938b432333f3e8fd8e499f1f5aa7ae98d0a1f7edc7cc924b', '[\"*\"]', NULL, NULL, '2024-02-15 21:41:57', '2024-02-15 21:41:57'),
(180, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1fac3a0f0a29fc8ab02a6dc66e982a1a829f7b50d86bb5c8727389a76f060a72', '[\"*\"]', NULL, NULL, '2024-02-15 21:42:13', '2024-02-15 21:42:13'),
(181, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1b9469202e10a2fb4d143a9c66832dea27e17e6724957693974689216c1fe780', '[\"*\"]', NULL, NULL, '2024-02-15 21:51:42', '2024-02-15 21:51:42'),
(182, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9cb5734cef87e56aeae521cf1444b88ada67ac7b3f2640f6dde1d717d195278a', '[\"*\"]', NULL, NULL, '2024-02-15 21:54:07', '2024-02-15 21:54:07'),
(183, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4d5ec15d52dc2213841675bc53ffb6b090b535ef12bb03fd8e9335b475c7f67c', '[\"*\"]', NULL, NULL, '2024-02-15 21:56:24', '2024-02-15 21:56:24'),
(184, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '915b89d62850b31a3a15214148ac862570d2b19f517b5681ffd2eb45d8305c30', '[\"*\"]', NULL, NULL, '2024-02-15 22:06:54', '2024-02-15 22:06:54'),
(185, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '3329ba74d221486291f0a82197936b0b086980a03e3dec461708168e710021c5', '[\"*\"]', NULL, NULL, '2024-02-15 22:10:16', '2024-02-15 22:10:16'),
(186, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b5a0d328f78a15c72943d2baa63d70ebc20cac3ecf8db599072ef95ee820aa9d', '[\"*\"]', NULL, NULL, '2024-02-15 22:27:01', '2024-02-15 22:27:01'),
(187, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'e20768f6964375443a3b63c93ad918b723f7ac9381f23f53f478ebb434151c11', '[\"*\"]', NULL, NULL, '2024-02-15 22:29:16', '2024-02-15 22:29:16'),
(188, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1095e086626d71bdd9ec88be4d99279ef805f8e463986a2d8415b81c8c373a92', '[\"*\"]', NULL, NULL, '2024-02-15 22:30:27', '2024-02-15 22:30:27'),
(189, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6470f02aaafd3d45a79fa4282e6d432abd6884ff2731130d6a8c361127c9efdd', '[\"*\"]', NULL, NULL, '2024-02-15 22:32:51', '2024-02-15 22:32:51'),
(190, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '284d2a05c468ccf5bd22856a762c390f0377cf000b960305e4bfdc43d738c846', '[\"*\"]', NULL, NULL, '2024-02-15 22:38:23', '2024-02-15 22:38:23'),
(191, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7a64b4c42513cc2669e90ce3d080ff30966a6a1458f8f6aeceba49dd90c9dc74', '[\"*\"]', NULL, NULL, '2024-02-15 22:39:41', '2024-02-15 22:39:41'),
(192, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f5912f8fe7d539a8b8444854e7b737df0bf0d3e623d6491b791bbb1df5945609', '[\"*\"]', NULL, NULL, '2024-02-15 23:00:40', '2024-02-15 23:00:40'),
(193, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a0cd1d6849e064b85b36f0797c88b4c5d7fd7cfcdf6c77971dddc9b5851bee44', '[\"*\"]', NULL, NULL, '2024-02-15 23:01:24', '2024-02-15 23:01:24'),
(194, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2bed33e5d436cf7ba90cf9517cafcd68f72a1ff848b3abf181ecea10ae48937d', '[\"*\"]', NULL, NULL, '2024-02-15 23:13:36', '2024-02-15 23:13:36'),
(195, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '84a531f1a660d75bb4e99f8623f7a0e4ec21d797f22c23c20b1f1fdca2486723', '[\"*\"]', NULL, NULL, '2024-02-15 23:47:13', '2024-02-15 23:47:13'),
(196, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '476d00af947ae15592dea7c1d33f2d26eac476a3c649d19a124348397cf61b89', '[\"*\"]', NULL, NULL, '2024-02-15 23:50:16', '2024-02-15 23:50:16'),
(197, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7eed6717612452336f0d112e5534db5af89b952a34c005a8e436972b45f8ed76', '[\"*\"]', NULL, NULL, '2024-02-16 00:28:55', '2024-02-16 00:28:55'),
(198, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f2acb4e32c7af440cb2cf2dbe07123cc1d6899b0a2237d0ada044bb9fdf9bf84', '[\"*\"]', NULL, NULL, '2024-02-16 09:02:47', '2024-02-16 09:02:47'),
(199, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c2e73a77f4af306a5dab7452ac3b38502ad2a9bb2d8032fbdc24987b25209b48', '[\"*\"]', NULL, NULL, '2024-02-16 09:02:48', '2024-02-16 09:02:48'),
(200, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f4eda9c8f87ac270ace2ccc0a68f03cf95e5f88bd443e184ce87a8962da53fb8', '[\"*\"]', NULL, NULL, '2024-02-16 09:02:49', '2024-02-16 09:02:49'),
(201, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4580aa8cbbc1cab427d0d14d341664cf306c76723d33eae203567826cf3ff984', '[\"*\"]', NULL, NULL, '2024-02-16 09:06:53', '2024-02-16 09:06:53'),
(202, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1149eff14dd383bf8018935477c5940ce4817ff030d2061b9599040b14361dc8', '[\"*\"]', NULL, NULL, '2024-02-16 09:07:52', '2024-02-16 09:07:52'),
(203, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1a7f35510685251b44015fd40f42a18711ba14f74b7dac46ad6f1b6ffc35b3f0', '[\"*\"]', NULL, NULL, '2024-02-16 09:13:10', '2024-02-16 09:13:10'),
(204, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '41a1d7fed1a9c210cc49bdd08a59c4ed967154130e931514f53bc1fa0d39bdd8', '[\"*\"]', NULL, NULL, '2024-02-16 09:19:15', '2024-02-16 09:19:15'),
(205, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'cff6dcd870052de3428952e0b19a75b7bd2735b30ab5178bc24e5992b90e7c63', '[\"*\"]', NULL, NULL, '2024-02-16 09:22:33', '2024-02-16 09:22:33'),
(206, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'db3648dbbd7b54aa5d4d0e2bcf170e462866d2d501d683aa307dd0fba10493dc', '[\"*\"]', NULL, NULL, '2024-02-16 09:23:30', '2024-02-16 09:23:30'),
(207, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd38f1d71fc7a4254f954ce71ac4893711f9eafc6d3e042b1900843bfb4accca4', '[\"*\"]', NULL, NULL, '2024-02-16 09:24:50', '2024-02-16 09:24:50'),
(208, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'e590584e91c866c2b264658292cbac29c674a48d564596071cab31472959951d', '[\"*\"]', NULL, NULL, '2024-02-16 09:26:12', '2024-02-16 09:26:12'),
(209, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd371d3690a26157a0a5eb9cc13adb7af08b6a1707b06b9ec9d8d32f41b1f2461', '[\"*\"]', NULL, NULL, '2024-02-16 09:47:12', '2024-02-16 09:47:12'),
(210, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f00aada483d72af39e7898b55d2645d6fa2920e13ac5a1ec7fd1dabcd7ed825d', '[\"*\"]', NULL, NULL, '2024-02-16 10:08:28', '2024-02-16 10:08:28'),
(211, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '095635dba41ea1caef535ded8e031ce181939fe572c166a59d3d18cf48e9107a', '[\"*\"]', NULL, NULL, '2024-02-16 10:15:15', '2024-02-16 10:15:15'),
(212, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ad01e8e4d8640cd46a37b9c76f989954c76cee993f4c0bdfd914ee4fdadb5ddb', '[\"*\"]', NULL, NULL, '2024-02-16 10:45:36', '2024-02-16 10:45:36'),
(213, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b873fa3b5cffbade4c4a9a3b998d0829effe3a01f0670974c2c54fd5b5e4f6ab', '[\"*\"]', NULL, NULL, '2024-02-16 10:51:16', '2024-02-16 10:51:16'),
(214, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f22e926eba03b9ca9de5c08149724a78a5ed1c941cab4cccfbbb0d87b4674fe7', '[\"*\"]', NULL, NULL, '2024-02-16 10:59:13', '2024-02-16 10:59:13'),
(215, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'e8b0e35dde6a5caea660f78be0c1794b6194bdc412fe7fd2c48f9f7536a6b3d9', '[\"*\"]', NULL, NULL, '2024-02-16 11:06:33', '2024-02-16 11:06:33'),
(216, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '862f197b7d20f97ed3f6e3a9d37e53a768ee7dea566648b5cebdb19f8ae4a1b7', '[\"*\"]', NULL, NULL, '2024-02-16 11:10:32', '2024-02-16 11:10:32'),
(217, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '02459a23749245fc4c09c7f98c14cdc2cd6de37490efed8c876260606bd39d7f', '[\"*\"]', NULL, NULL, '2024-02-16 11:12:15', '2024-02-16 11:12:15'),
(218, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'acae25c22670bd2f1601ffe838f62b28b7ea461b887eb1ffe0bdfd34e09ac21b', '[\"*\"]', NULL, NULL, '2024-02-16 11:13:22', '2024-02-16 11:13:22'),
(219, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '67df550597e8f22d8fb87510350127b321cd3b756c7d9f6e5099b16e7ee4378a', '[\"*\"]', NULL, NULL, '2024-02-16 11:14:56', '2024-02-16 11:14:56'),
(220, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'fd64f4d1cd09c642bf3a5c1e8b0020217bc2445b6acab175a438b251bdaf1e53', '[\"*\"]', NULL, NULL, '2024-02-16 11:15:51', '2024-02-16 11:15:51'),
(221, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '81757b2bfcc935ae5448127cbde78049510ff57de57aca99536ba3605746a964', '[\"*\"]', NULL, NULL, '2024-02-16 11:17:07', '2024-02-16 11:17:07'),
(222, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '46ee6b14ae11fc64a811269619dcc03689372f29b90a535c70f5f9abc5a3e703', '[\"*\"]', NULL, NULL, '2024-02-16 11:18:45', '2024-02-16 11:18:45'),
(223, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ce952d6d707c98da273237824f12c7475dde9666b2024a2fede5c4faf0fc678e', '[\"*\"]', NULL, NULL, '2024-02-16 11:20:11', '2024-02-16 11:20:11'),
(224, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0c00d911036f1f297a0d4b51bc159be775371a154501531c1af9291648e5eda3', '[\"*\"]', NULL, NULL, '2024-02-16 11:21:36', '2024-02-16 11:21:36'),
(225, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '90cbf65753cbdae6a1037621b676471cb45020cbe9b6453fb6fd4c8b9fe1cd9f', '[\"*\"]', NULL, NULL, '2024-02-16 11:24:58', '2024-02-16 11:24:58'),
(226, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9d415ea99b6717c4730a28554ca53ea62b65a062d669b2742095c9e7ed9076ce', '[\"*\"]', NULL, NULL, '2024-02-16 11:26:01', '2024-02-16 11:26:01'),
(227, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5b1ceab50621a78b9bc93918dbd4633672c64c848904a37d74185115c1caf323', '[\"*\"]', NULL, NULL, '2024-02-16 11:27:16', '2024-02-16 11:27:16'),
(228, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4d78a33bf2e592a1d3b3a598e2ecfbb9eb577404830384608907f0bc791ecac2', '[\"*\"]', NULL, NULL, '2024-02-16 11:30:04', '2024-02-16 11:30:04'),
(229, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9c298916e1be2c7a45cf418371a08be3eb09e535da8be5af9606a65294cf1a44', '[\"*\"]', NULL, NULL, '2024-02-16 11:31:43', '2024-02-16 11:31:43'),
(230, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c074fc940e98f3a343d7bd28c9c04c35c64798033367d0e62b92508c2a7c5e3e', '[\"*\"]', NULL, NULL, '2024-02-16 11:33:04', '2024-02-16 11:33:04'),
(231, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2d57a7fcac309063de26a8cdc26c94f040b6e35705b59f319af9f4f0fb89720d', '[\"*\"]', NULL, NULL, '2024-02-16 11:34:57', '2024-02-16 11:34:57'),
(232, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f415dd3ca7574f2dbe5e375b506b67d98362e2b13a579499f4cb5aace31b56e9', '[\"*\"]', NULL, NULL, '2024-02-16 11:36:03', '2024-02-16 11:36:03'),
(233, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd6aba7268f98c845c4d3ceaf95008af5e5db10fc223d608efe1308f7d938481d', '[\"*\"]', NULL, NULL, '2024-02-16 11:37:11', '2024-02-16 11:37:11'),
(234, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '77ca3ff8e282f45006354e6c0c42eaba37947eaa58895311e4d1ed097445c2d0', '[\"*\"]', NULL, NULL, '2024-02-16 11:40:58', '2024-02-16 11:40:58'),
(235, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f1e58fd48f5a7d46443fe8f3d591dd3957d2070a02dd80428cabb48824662f8f', '[\"*\"]', NULL, NULL, '2024-02-16 11:45:17', '2024-02-16 11:45:17'),
(236, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ef071ffe27cce7e5acc89d46a7f578388ef2bff7812cd7e44bb1c6a0bf1ff562', '[\"*\"]', NULL, NULL, '2024-02-16 11:47:20', '2024-02-16 11:47:20'),
(237, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '482412b15a024e66dba45a23aee89b0e2d016e793abba2ac6a345e589c801ca0', '[\"*\"]', NULL, NULL, '2024-02-16 11:55:28', '2024-02-16 11:55:28'),
(238, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2f7103ed4f65154cbb31aabc9fbd7cf829100a9d0b108d46a9019b1a4a1d424f', '[\"*\"]', NULL, NULL, '2024-02-16 11:55:51', '2024-02-16 11:55:51'),
(239, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9d2acb01604d1f3c3d79acec3c0542d46feaaa2ac5f550003596dd899f4bdf20', '[\"*\"]', NULL, NULL, '2024-02-16 11:57:45', '2024-02-16 11:57:45'),
(240, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a689e47db7db2fb66e20125cc0789a07ea297b5fca11315a4e4e1846427a23cd', '[\"*\"]', NULL, NULL, '2024-02-16 11:58:29', '2024-02-16 11:58:29'),
(241, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ceeae7802761d357655293f489b5f91245e6adf9aee98653c60c29b8c266d223', '[\"*\"]', NULL, NULL, '2024-02-16 12:04:28', '2024-02-16 12:04:28'),
(242, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'bd0f5dafeb842e789f4373177731a3dbd29a546a54f42d22635da14b2afaeef5', '[\"*\"]', NULL, NULL, '2024-02-16 12:12:22', '2024-02-16 12:12:22'),
(243, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7ed62161b64aad3d1ca19fda0ef8b7a0fea412da76de293d5694a56e5bf87f36', '[\"*\"]', NULL, NULL, '2024-02-16 12:13:42', '2024-02-16 12:13:42'),
(244, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ca22130556f33db8b94d7f5bcf17b1e933d85fb5628f9f3240338e76239d1f42', '[\"*\"]', NULL, NULL, '2024-02-16 12:15:04', '2024-02-16 12:15:04'),
(245, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'bda05ec3b8af50668907798a39ec27abc5572203bee04df34e5c5512a08b4b21', '[\"*\"]', NULL, NULL, '2024-02-16 12:22:34', '2024-02-16 12:22:34'),
(246, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '853a6331692134232bda09cd705acc4ab6a1e3f1a9d119fbd2dacd14782a2ec7', '[\"*\"]', NULL, NULL, '2024-02-16 12:25:04', '2024-02-16 12:25:04'),
(247, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ccca09a9e7fccc9b929c1844d1d8b689e7d74a8074c26a1df245ea760a187d17', '[\"*\"]', NULL, NULL, '2024-02-16 12:26:00', '2024-02-16 12:26:00'),
(248, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd117e793c65e44ed80938db86db62f6672bd2e1df2f3f9ab4c6b08d20ac29747', '[\"*\"]', NULL, NULL, '2024-02-16 12:26:59', '2024-02-16 12:26:59'),
(249, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8ca147e5061cc5c05a366abd4a97bbd9d52ef2afee33fea9ad18bb5dd1372dc1', '[\"*\"]', NULL, NULL, '2024-02-16 12:42:25', '2024-02-16 12:42:25'),
(250, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '43ef728295df751c7be4b244053700aba90499795b92887f6cac8ae8cb2c4661', '[\"*\"]', NULL, NULL, '2024-02-16 12:43:25', '2024-02-16 12:43:25'),
(251, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7e680c17fbb5351844965fe90454d552fec6483ad6dfc0cf756c9693754d0421', '[\"*\"]', NULL, NULL, '2024-02-16 12:59:13', '2024-02-16 12:59:13'),
(252, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4b8db00e82e9f174b21595f0d01800adcdfa929f24937049827e08bd62780249', '[\"*\"]', NULL, NULL, '2024-02-16 13:48:19', '2024-02-16 13:48:19'),
(253, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b5e04fc8501ba4a3089a38472f7755036dd8a3d8e9a265b12cd674fc7da799c5', '[\"*\"]', NULL, NULL, '2024-02-16 13:58:25', '2024-02-16 13:58:25'),
(254, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0b035d16290834485f15a0e77bf3a77525058e5d44521bc370ca2141b1ad24ad', '[\"*\"]', NULL, NULL, '2024-02-16 14:00:02', '2024-02-16 14:00:02'),
(255, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '305836947dd53d98eea11bb298699e7791d3909210e4204385a711e4c59bd8bc', '[\"*\"]', NULL, NULL, '2024-02-16 14:01:32', '2024-02-16 14:01:32'),
(256, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'fe31525e47b9a03c4be449b87176ba07de4ffda5b24d8f9a6c04038f4fe7ab70', '[\"*\"]', NULL, NULL, '2024-02-16 14:03:52', '2024-02-16 14:03:52'),
(257, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c7ae219f462a2612d6154ce0825c5c1d231a6def427d22811cfdda9532e84f72', '[\"*\"]', NULL, NULL, '2024-02-16 14:08:35', '2024-02-16 14:08:35'),
(258, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd3f70f62f175678b27609a499e96b5a342f174892419982edcdb6e734a16894c', '[\"*\"]', NULL, NULL, '2024-02-16 14:11:47', '2024-02-16 14:11:47'),
(259, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a886db73800e3254f3ac1238ca9de0513ce8d9bc99ac406903ebf6bde2a76df5', '[\"*\"]', NULL, NULL, '2024-02-16 14:16:09', '2024-02-16 14:16:09'),
(260, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7c9d59179ba4ca03e536a1d8a002c0eba9aca27025645ab0a3ba702031111bd1', '[\"*\"]', NULL, NULL, '2024-02-16 14:36:04', '2024-02-16 14:36:04'),
(261, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2769097706ef6bf67d179ec7d4d2a0c3fd73156b330205b4058410746f5352d7', '[\"*\"]', NULL, NULL, '2024-02-16 17:13:49', '2024-02-16 17:13:49'),
(262, 'App\\Models\\Akunwisatawan', 13, 'auth_token', 'f94085289c5035247b324669420b5cf427f47360bb9403a72729d46b8ec01e70', '[\"*\"]', NULL, NULL, '2024-02-16 17:16:26', '2024-02-16 17:16:26'),
(263, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b96428f4257aea3ef513e1206dc1f0efce8ec445db61dfccd69b4ce426b8d793', '[\"*\"]', NULL, NULL, '2024-02-16 17:19:58', '2024-02-16 17:19:58'),
(264, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a1e5cc43a4baefddacfd7a46ff74911015c5ba345333e92a5c28d67717cc94b8', '[\"*\"]', NULL, NULL, '2024-02-16 17:28:27', '2024-02-16 17:28:27');
INSERT INTO `personal_access_tokens` (`id`, `tokenable_type`, `tokenable_id`, `name`, `token`, `abilities`, `last_used_at`, `expires_at`, `created_at`, `updated_at`) VALUES
(265, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '844dc3c9abf75ba07b75e1c671f845594b22e055fd5d66e32bfc3465dab91750', '[\"*\"]', NULL, NULL, '2024-02-16 17:34:00', '2024-02-16 17:34:00'),
(266, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8165b32fbc8356f26919269bfc48b88fd92779cf42014dc57f437414a478df12', '[\"*\"]', NULL, NULL, '2024-02-16 17:42:19', '2024-02-16 17:42:19'),
(267, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '823228a985b30a9d0050a116f78001df6f407614e9bbe088eb55f24575ab798c', '[\"*\"]', NULL, NULL, '2024-02-16 17:45:10', '2024-02-16 17:45:10'),
(268, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b1e3ff9f0c0bb18016ea3a7c3407aeb93d8c8b02bb14d9aaeee930d2801cfaea', '[\"*\"]', NULL, NULL, '2024-02-16 17:45:29', '2024-02-16 17:45:29'),
(269, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '569f501ec2edbcddb51b404d0d683fcd00a8ef00f24046ad1a713cd23571925a', '[\"*\"]', NULL, NULL, '2024-02-16 17:52:50', '2024-02-16 17:52:50'),
(270, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '75e8ee80c999bc8d820599e36096ebbedba228e0eaac5337c158e5fbb8a076b8', '[\"*\"]', NULL, NULL, '2024-02-16 17:56:31', '2024-02-16 17:56:31'),
(271, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c69528def51fe992e735acc4385691d64975eda629ed7aba61229d386b81f1f3', '[\"*\"]', NULL, NULL, '2024-02-16 17:58:10', '2024-02-16 17:58:10'),
(272, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8b55bd1b5ff77683b0c1e3978e79e69ddd810be09478f56f4fe355d9244ff4ca', '[\"*\"]', NULL, NULL, '2024-02-16 18:00:22', '2024-02-16 18:00:22'),
(273, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '569010182dbe532128b1b41c37edf8c7d00919846fa4f924fc2bb3eab050011c', '[\"*\"]', NULL, NULL, '2024-02-16 19:17:45', '2024-02-16 19:17:45'),
(274, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2cfb374f5c19cdd355cd3b1eb0c46ce8035a4690655c3844fca15bec14bf012d', '[\"*\"]', NULL, NULL, '2024-02-16 19:17:46', '2024-02-16 19:17:46'),
(275, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '36a00b309a35428c2d079bb1a2e6eadf74d841cd8235b2034fa33b09ba97fd59', '[\"*\"]', NULL, NULL, '2024-02-16 19:17:46', '2024-02-16 19:17:46'),
(276, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f8ea64479bbc6c81785ad0e6c63e04ea5418d1cfa6fb95edf2c1305091346984', '[\"*\"]', NULL, NULL, '2024-02-16 19:17:47', '2024-02-16 19:17:47'),
(277, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '62a95d38ac145b7f397ae20665b460e7b2e0767afd9fd2fb44d47ba01e749101', '[\"*\"]', NULL, NULL, '2024-02-17 23:04:59', '2024-02-17 23:04:59'),
(278, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c7efb661c10979c4bda74b596c5d908a63722fbbcc609430b4849d01fe129b08', '[\"*\"]', NULL, NULL, '2024-02-17 23:05:01', '2024-02-17 23:05:01'),
(279, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a9b477ff4c09dda07245736ad5a9e4032616cc429558fc57db4edfff7c400fd3', '[\"*\"]', NULL, NULL, '2024-02-17 23:05:02', '2024-02-17 23:05:02'),
(280, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8a42dfd045e38b281ed77e3a7ff6599ce7a6804e3bb8ece920438e3612c38370', '[\"*\"]', NULL, NULL, '2024-02-17 23:05:02', '2024-02-17 23:05:02'),
(281, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7bf2574404c40e1b843c704c185d14757ecfe8fa1feba7099d2a4749ee0d840a', '[\"*\"]', NULL, NULL, '2024-02-17 23:18:57', '2024-02-17 23:18:57'),
(282, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5c34e5358aa88cf10e3e359e669e69f6e88ffc67240ecd0e4164aca3056b1c8f', '[\"*\"]', NULL, NULL, '2024-02-17 23:22:45', '2024-02-17 23:22:45'),
(283, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '98b8b0d3d27229bb20417fec868e9f462e9d115b61b207eeccd88516800ae911', '[\"*\"]', NULL, NULL, '2024-02-17 23:25:37', '2024-02-17 23:25:37'),
(284, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '34bb687a1a6c49495e3b8a5f44b8de63df8aee7ad2ae747c76b9e8f4466bf828', '[\"*\"]', NULL, NULL, '2024-02-17 23:27:53', '2024-02-17 23:27:53'),
(285, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '75830f041f84dc2ff04b19536de9443d62113c92d6cbd19e75a5a30e0fb0a6e4', '[\"*\"]', NULL, NULL, '2024-02-17 23:35:05', '2024-02-17 23:35:05'),
(286, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a12b377f0cb9eaa7d3006194c7275b5aae844c24e5c8a50b958f588d1b422d3b', '[\"*\"]', NULL, NULL, '2024-02-17 23:35:56', '2024-02-17 23:35:56'),
(287, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '73da3a68776f054de9682fbd55f574df43ee7f78d68efef282bdeeaa2fef44ec', '[\"*\"]', NULL, NULL, '2024-02-17 23:38:05', '2024-02-17 23:38:05'),
(288, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'cdc4902f3b0539b1a81c95625aad45fe4b952158655269b23f306a35cfe267ad', '[\"*\"]', NULL, NULL, '2024-02-17 23:53:36', '2024-02-17 23:53:36'),
(289, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'daaf08d611ce70319440a78a94f362fde7157bee8a0b329746887bd0165da212', '[\"*\"]', NULL, NULL, '2024-02-18 00:11:20', '2024-02-18 00:11:20'),
(290, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '13ec16f556324972c23e13c14560c5d4138b857f71f703bc9a84bb55f429394b', '[\"*\"]', NULL, NULL, '2024-02-18 00:12:22', '2024-02-18 00:12:22'),
(291, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5fcf4bcae09a3766b00439798b0b462cd35386b08fbeefe8554d383218b9bde6', '[\"*\"]', NULL, NULL, '2024-02-18 00:13:36', '2024-02-18 00:13:36'),
(292, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '999c0883005e2c89d91a573328eec62416768250ed90c8d6bcf6220058445be6', '[\"*\"]', NULL, NULL, '2024-02-18 00:14:07', '2024-02-18 00:14:07'),
(293, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'cf905a51e3ce68f3680fa94de95fdf2ceee0a5f635404a3c1c3cfd95ef1ef727', '[\"*\"]', NULL, NULL, '2024-02-18 00:15:19', '2024-02-18 00:15:19'),
(294, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'dc7f0cac329e78bd04bf3c8fbf5b8ba7088cc62177c4381148c4fda8e93018e6', '[\"*\"]', NULL, NULL, '2024-02-18 00:15:49', '2024-02-18 00:15:49'),
(295, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '3c02b62d38ceced48a7b714497d205af868469c985b223ff2589500ea4b07797', '[\"*\"]', NULL, NULL, '2024-02-18 00:18:31', '2024-02-18 00:18:31'),
(296, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2ae4c7229b7bf14004860ce53f7fa27fc84122e4aafec28c1773612021755268', '[\"*\"]', NULL, NULL, '2024-02-18 00:20:56', '2024-02-18 00:20:56'),
(297, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '007c1f9f51305d4b2397ab2281e62412b2e43f0f99b3156bab499d731f10541f', '[\"*\"]', NULL, NULL, '2024-02-18 00:24:06', '2024-02-18 00:24:06'),
(298, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'e173831ed0aed57b3e9000c98384b5dac2dd178b0c4ac9b3129845b0680c884c', '[\"*\"]', NULL, NULL, '2024-02-18 00:34:01', '2024-02-18 00:34:01'),
(299, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '585748a958211b406c7f3155c4c32ae24587c78ef2eed16449a98abe634462e9', '[\"*\"]', NULL, NULL, '2024-02-18 00:34:27', '2024-02-18 00:34:27'),
(300, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '77e0ac318de5df72576bcb3a4c26df2076933c7a463a443e8db817f61bb362e4', '[\"*\"]', NULL, NULL, '2024-02-18 00:35:53', '2024-02-18 00:35:53'),
(301, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2f521bf274495b1b3f64196996f5828b29205fa0e1eeec33f8fe3b96290ee0f9', '[\"*\"]', NULL, NULL, '2024-02-18 00:35:56', '2024-02-18 00:35:56'),
(302, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '42199b7786078cd485f004a3517c8998d6ced393aace6d34aaff6f22bbd7bd3f', '[\"*\"]', NULL, NULL, '2024-02-18 00:40:00', '2024-02-18 00:40:00'),
(303, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '02244657e922f534c2a39421bdc825001293514d3bf34d72aa0bfd50d71eb269', '[\"*\"]', NULL, NULL, '2024-02-18 00:49:11', '2024-02-18 00:49:11'),
(304, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '68a44a77ac61d5b723a2d44d45fd227ac409eacba4d045343a6c56a3180248d4', '[\"*\"]', NULL, NULL, '2024-02-18 00:49:14', '2024-02-18 00:49:14'),
(305, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b06979a448ff76cba7275bd4c89ac1ae44ff5cdd26175080adda4c813695aaa9', '[\"*\"]', NULL, NULL, '2024-02-18 00:56:18', '2024-02-18 00:56:18'),
(306, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'ec3882d8107a799de55b18b143167ae49419b7a288e753e6447d6da35c15f472', '[\"*\"]', NULL, NULL, '2024-02-18 01:01:33', '2024-02-18 01:01:33'),
(307, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a57f6e1277c31821cbb027f76674dc1b8671d22b0b22fb2ac838702f5947bb2d', '[\"*\"]', NULL, NULL, '2024-02-18 01:05:54', '2024-02-18 01:05:54'),
(308, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '295f9b65c105ca7d863e1ceffc585504f782baabb1810450c23350e16d052b71', '[\"*\"]', NULL, NULL, '2024-02-18 01:08:12', '2024-02-18 01:08:12'),
(309, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f0391028717740605ed21c80996194f6ef36889cd539e30072ee7fba199924b5', '[\"*\"]', NULL, NULL, '2024-02-18 01:10:31', '2024-02-18 01:10:31'),
(310, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a408142f56fd1782a5cbc48dfc45315d3158e49a2f13e667c6625a5d5ad4a56d', '[\"*\"]', NULL, NULL, '2024-02-18 01:10:33', '2024-02-18 01:10:33'),
(311, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0243f279ae88e9fab9c75f1276c7969521a2432eca0ff68d917888a183f6b6af', '[\"*\"]', NULL, NULL, '2024-02-18 01:15:53', '2024-02-18 01:15:53'),
(312, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b8a9633742bb9b9039ccd21e1893aad860e88dfdcf6518d935f7fd5751aa7645', '[\"*\"]', NULL, NULL, '2024-02-18 01:20:28', '2024-02-18 01:20:28'),
(313, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'fcd66fd2be140e0ff79759bdaf39a3f925ce51a9dbdc1c34a85cf31c3820fdeb', '[\"*\"]', NULL, NULL, '2024-02-18 01:29:32', '2024-02-18 01:29:32'),
(314, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd128661fb207ae1d3942dba007100096938e84e180a359809dce950cf7a00fb3', '[\"*\"]', NULL, NULL, '2024-02-18 01:31:13', '2024-02-18 01:31:13'),
(315, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6b8abc903d72c950f10ea516bdb3d814fe6f114307773fa9ce3b541ec19bd040', '[\"*\"]', NULL, NULL, '2024-02-18 01:34:42', '2024-02-18 01:34:42'),
(316, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5ab58909da060a341e17789503aa9207d771a9e9db38e2698796d77726d751cb', '[\"*\"]', NULL, NULL, '2024-02-18 01:35:35', '2024-02-18 01:35:35'),
(317, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '62e3f3e84944207f884de899c04d763ca3b2ca0d80e683c69c7501f8994d0ff9', '[\"*\"]', NULL, NULL, '2024-02-18 01:36:31', '2024-02-18 01:36:31'),
(318, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '613b293808d845b7dc6d35dbda656fddd50eb09139393f78d0eab8d018e3401f', '[\"*\"]', NULL, NULL, '2024-02-18 01:38:29', '2024-02-18 01:38:29'),
(319, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5168ddd5ca94f126b7198ef914428b7643b08f9747973f213fde6b440de650e7', '[\"*\"]', NULL, NULL, '2024-02-18 01:39:35', '2024-02-18 01:39:35'),
(320, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '38837ef11e1bd1b84cf9a25596fa8541c8dcb3c3fde03fc051fdd8bd11cd215b', '[\"*\"]', NULL, NULL, '2024-02-18 01:40:32', '2024-02-18 01:40:32'),
(321, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '37bf424dd7e7db47e8e6aac7d030c358a1cc9dee50bd80201a1fc538d3e2221f', '[\"*\"]', NULL, NULL, '2024-02-18 01:47:38', '2024-02-18 01:47:38'),
(322, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd6c6d3ed8d026ce0821ce03819355a02d852462a562a8c62bfe50f2f69f08e82', '[\"*\"]', NULL, NULL, '2024-02-18 01:55:04', '2024-02-18 01:55:04'),
(323, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7eaa634b1790f816d5ec6326a02973aeb718075b11e975ac4fa18421543804ac', '[\"*\"]', NULL, NULL, '2024-02-18 01:55:33', '2024-02-18 01:55:33'),
(324, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f296f64a58073b606e963de9894a78e05338732546f39109b4f5f693360995f5', '[\"*\"]', NULL, NULL, '2024-02-18 01:55:35', '2024-02-18 01:55:35'),
(325, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'caf036ff7f5d2e5dcf03c67a297568c6241f3dd7024aa3e9ae6e24c4046e436f', '[\"*\"]', NULL, NULL, '2024-02-18 01:55:39', '2024-02-18 01:55:39'),
(326, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'e3aa60d63ce4d54733b00f5b908d9dad9b582b5a859ae20e9a44b7d8dea8e652', '[\"*\"]', NULL, NULL, '2024-02-18 01:55:40', '2024-02-18 01:55:40'),
(327, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2ec8bc57f4304501ea922d013ecf2389282a6b8889ad76f72674c1b87389b461', '[\"*\"]', NULL, NULL, '2024-02-18 01:55:41', '2024-02-18 01:55:41'),
(328, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9322e16bda47a59bea23f2456931ab996861504afa650ecebf6cf11fe8e2a1b9', '[\"*\"]', NULL, NULL, '2024-02-18 01:55:42', '2024-02-18 01:55:42'),
(329, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '50ad10aa74bc85fbffd3a8156f93126f01f56fc62f9a4900f9a8b9ce5d91dd01', '[\"*\"]', NULL, NULL, '2024-02-18 01:55:43', '2024-02-18 01:55:43'),
(330, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b427d8823c8ed578ad36bb4b69861e19a8f14b98fdd3705b11a58fb086e11ca4', '[\"*\"]', NULL, NULL, '2024-02-18 02:14:25', '2024-02-18 02:14:25'),
(331, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '89224ea79e20efe5790918fb1a9000da0bc913c9aba38e20c99f6603bb5cd30b', '[\"*\"]', NULL, NULL, '2024-02-18 02:15:18', '2024-02-18 02:15:18'),
(332, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6509cce2ebebb7de707c97d766095cd83973a3402459e5b88bd87fc091bf99ef', '[\"*\"]', NULL, NULL, '2024-02-18 02:22:25', '2024-02-18 02:22:25'),
(333, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '84bfc7365c1f720c73b5faeea4742377e55986d02e4bfded1418f311217e1651', '[\"*\"]', NULL, NULL, '2024-02-18 06:38:48', '2024-02-18 06:38:48'),
(334, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f7c4df083f42648f131cc3702b71a999d57b3081b737ee2da39d075cee6110d9', '[\"*\"]', NULL, NULL, '2024-02-18 06:41:59', '2024-02-18 06:41:59'),
(335, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'b7ab8921b469a035c753f2b7733b1df11eacf54b5f584f4d6a98d587aeb566f6', '[\"*\"]', NULL, NULL, '2024-02-18 06:48:29', '2024-02-18 06:48:29'),
(336, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c7ea51d8d20d9e1125854adad58ad4a8b5d053d212764f5484b4385812340f70', '[\"*\"]', NULL, NULL, '2024-02-18 06:50:43', '2024-02-18 06:50:43'),
(337, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'da2d0ebf2adbbf695f211dfd09f6a8b0c4d8a020cb94f44dcbcdde546b8f87a7', '[\"*\"]', NULL, NULL, '2024-02-18 06:53:24', '2024-02-18 06:53:24'),
(338, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7ebc4350ea00454338268320b5c344de25be6b8fb4de00ed354a07c12329b8ba', '[\"*\"]', NULL, NULL, '2024-02-18 06:56:42', '2024-02-18 06:56:42'),
(339, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'bb2af2c898cbd74cc2f62d52d396c4441dafb322da2e19928638d6fee197116d', '[\"*\"]', NULL, NULL, '2024-02-18 06:58:17', '2024-02-18 06:58:17'),
(340, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '79ba6b6040730ce7fef8b97e6720d2a0b49a33de92b0441db587ab1c84aca2cc', '[\"*\"]', NULL, NULL, '2024-02-18 07:00:07', '2024-02-18 07:00:07'),
(341, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1e4aa4a7f2744a2c01384ebd571a4f70e6f1924b3795a4684c29931f53cfd331', '[\"*\"]', NULL, NULL, '2024-02-18 07:00:36', '2024-02-18 07:00:36'),
(342, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0076c3a03f3f5f63f21e146e72b02dcbf85e1d73531ec5ceeb7874d0ce093c53', '[\"*\"]', NULL, NULL, '2024-02-18 07:03:59', '2024-02-18 07:03:59'),
(343, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8d8e2aa4f5aa49cfcffdbc291094908332240eaf4fef1cec508e45a006a16fff', '[\"*\"]', NULL, NULL, '2024-02-18 07:06:07', '2024-02-18 07:06:07'),
(344, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '52983de5855cc4d0186b444684605c3ceac8267ab36940d0e63e4f4cea15f842', '[\"*\"]', NULL, NULL, '2024-02-18 07:08:16', '2024-02-18 07:08:16'),
(345, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c75127b923d4a8e4c2b2425b2848880d16e1fa66d52acb5b94671a153b7e6313', '[\"*\"]', NULL, NULL, '2024-02-18 07:09:06', '2024-02-18 07:09:06'),
(346, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '6371c3ed3eb835da0ae31c26b3b39c8c2043b5fd0fd96d1fb2da4163183f168a', '[\"*\"]', NULL, NULL, '2024-02-18 07:11:30', '2024-02-18 07:11:30'),
(347, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4b86c13d661f529472fd69ab66a45464456a5acc2e771d95feea1c59e13f029b', '[\"*\"]', NULL, NULL, '2024-02-18 07:18:31', '2024-02-18 07:18:31'),
(348, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'c92b4fb3784e54f0fa0969cb82e875abaf738fe1477f8d61576dc1e53a428825', '[\"*\"]', NULL, NULL, '2024-02-18 07:21:01', '2024-02-18 07:21:01'),
(349, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '4e261a452c4093f7d39cdfeb37a3cce27e7a6790c9ae5f7d9800a9792299d501', '[\"*\"]', NULL, NULL, '2024-02-18 07:22:24', '2024-02-18 07:22:24'),
(350, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0907ae403e48709b6dc4fa9d80ff1aef3721141bcc9ed994bfff4fe737fd2962', '[\"*\"]', NULL, NULL, '2024-02-18 07:24:02', '2024-02-18 07:24:02'),
(351, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '616153c72e5c984ef89ea5f9c5f6f761b5179477ffebb6bd073140891513b2eb', '[\"*\"]', NULL, NULL, '2024-02-18 07:25:02', '2024-02-18 07:25:02'),
(352, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '830a89b6ed64ec63b27b1404c20e7c61a988d5471d67f56ec30892150db0a5d6', '[\"*\"]', NULL, NULL, '2024-02-18 07:25:57', '2024-02-18 07:25:57'),
(353, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5ad9432e49c264a6b403ba6139881e918cdd871003cbe3b0cd55a20d4e24c1a7', '[\"*\"]', NULL, NULL, '2024-02-18 07:29:23', '2024-02-18 07:29:23'),
(354, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '7ff084b4a32587e0f1eb4a8a983badc4bbefc2c681310be0d1f5d5fbaf1875fa', '[\"*\"]', NULL, NULL, '2024-02-18 07:32:34', '2024-02-18 07:32:34'),
(355, 'App\\Models\\Akunwisatawan', 32, 'auth_token', '63cf52759d52b3f2df76df91170ef8cf13e5e0b20f37e04d406a84b373108e1f', '[\"*\"]', NULL, NULL, '2024-02-18 07:42:03', '2024-02-18 07:42:03'),
(356, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'f7a7450e61108fc8a43ddc96c3131e2efccd0456acb95c238e386651a028bcf6', '[\"*\"]', NULL, NULL, '2024-02-18 08:15:51', '2024-02-18 08:15:51'),
(357, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '5c27ca7da4d22cba120739d59a585db100a2a2d6fa9a2bc4c5368e78ec092a24', '[\"*\"]', NULL, NULL, '2024-02-18 08:18:42', '2024-02-18 08:18:42'),
(358, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8a4e00ece956044c2ad557c6d7c8897f38b4ba3bd1876b585e4a3461ee6ee416', '[\"*\"]', NULL, NULL, '2024-02-18 08:21:10', '2024-02-18 08:21:10'),
(359, 'App\\Models\\Akunwisatawan', 40, 'auth_token', '6393feeefa793f1595f9352ef5a08c42d8039aa24351b0102087298344b72179', '[\"*\"]', NULL, NULL, '2024-02-18 08:34:57', '2024-02-18 08:34:57'),
(360, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '8480571b7c939dc60cccb16c228aca5e5a98bcc2ce0dbcfbe84963db84da21f2', '[\"*\"]', NULL, NULL, '2024-02-18 08:39:01', '2024-02-18 08:39:01'),
(361, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd2c7c92413cc72679cb9c2c0aa6d9d2bcbbed7414f1e6d55d7dc27c5a1229d27', '[\"*\"]', NULL, NULL, '2024-02-18 08:39:02', '2024-02-18 08:39:02'),
(362, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'a6250442c3d6ab3dfd027a89caaa5564a49594fb7ec9f0afd1895944a0d1f8f5', '[\"*\"]', NULL, NULL, '2024-02-18 08:39:05', '2024-02-18 08:39:05'),
(363, 'App\\Models\\User', 1, 'auth_token', 'f2b0218739ab28deac1ed889fca85a61f2b35250394e8d32d713452de9cb1c82', '[\"*\"]', NULL, NULL, '2024-02-18 08:54:00', '2024-02-18 08:54:00'),
(364, 'App\\Models\\User', 1, 'auth_token', '5c0d36a10954d4aaff4a8fa9a203ab7c460c9497f19aaa79428ca798856eaadb', '[\"*\"]', NULL, NULL, '2024-02-18 08:54:01', '2024-02-18 08:54:01'),
(365, 'App\\Models\\User', 1, 'auth_token', '462ffadb36220d0e8d74327f73407f8c26c1bb629ae6f818b5d284048c1b2fec', '[\"*\"]', NULL, NULL, '2024-02-18 08:54:05', '2024-02-18 08:54:05'),
(366, 'App\\Models\\User', 1, 'auth_token', 'f4de1ac38686b04cf76f284834f737913e5fa7b2d3d961247e9aef4680dc8df7', '[\"*\"]', NULL, NULL, '2024-02-18 08:55:02', '2024-02-18 08:55:02'),
(367, 'App\\Models\\User', 1, 'auth_token', '4ed35bd80b6d3fa776f04617b9c2ec28a678f65b7efceaea1e381e4094019bc4', '[\"*\"]', NULL, NULL, '2024-02-18 08:57:48', '2024-02-18 08:57:48'),
(368, 'App\\Models\\User', 1, 'auth_token', '2b54d369688c7dcb62abcd58df860dc380cf99f81efeec11ce5bcd4bd0e290eb', '[\"*\"]', NULL, NULL, '2024-02-18 09:03:31', '2024-02-18 09:03:31'),
(369, 'App\\Models\\User', 1, 'auth_token', '22d337800d38bec5a80e22b3f16030fb84ffa2a9c60fe5bea501006a783c863f', '[\"*\"]', NULL, NULL, '2024-02-18 09:04:07', '2024-02-18 09:04:07'),
(370, 'App\\Models\\User', 1, 'auth_token', 'a8cf4a40798384a35871c5d82a1b55393d94f9ff6d419415fb6314c7fe527b71', '[\"*\"]', NULL, NULL, '2024-02-18 09:04:23', '2024-02-18 09:04:23'),
(371, 'App\\Models\\User', 1, 'auth_token', '9985261bf97948971d78902442f7581657fd357dae2a28db546f52881333c3cf', '[\"*\"]', NULL, NULL, '2024-02-18 09:05:22', '2024-02-18 09:05:22'),
(372, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '1c8d4b0f2ef60f146211f0f3f2d584544c596152f1330d022b541ec912d497e5', '[\"*\"]', NULL, NULL, '2024-02-18 09:06:03', '2024-02-18 09:06:03'),
(373, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '67b7eedee22d5be70e15f657541bde288d5d1c729202cfca90d3ce13d3303129', '[\"*\"]', NULL, NULL, '2024-02-18 09:07:44', '2024-02-18 09:07:44'),
(374, 'App\\Models\\User', 1, 'auth_token', 'ee0ae0e58b5a0f79603c45f8f15dfaae8b6c6ed5ca6a9fea824e244347d225fa', '[\"*\"]', NULL, NULL, '2024-02-18 09:18:50', '2024-02-18 09:18:50'),
(375, 'App\\Models\\User', 1, 'auth_token', 'fa4a2526077b22dd91711b496dfae14d7d7111b1b2b03eb1a4e414eb1969625b', '[\"*\"]', NULL, NULL, '2024-02-18 09:21:08', '2024-02-18 09:21:08'),
(376, 'App\\Models\\User', 1, 'auth_token', '87af805d3c66ab4d0f71f39bf5ebe028e153dc0cbef3c9ac13aba1b5bcb5fb93', '[\"*\"]', NULL, NULL, '2024-02-18 09:26:56', '2024-02-18 09:26:56'),
(377, 'App\\Models\\User', 1, 'auth_token', 'b2e59869d4443f2cb54c81ffb4415036dd52a4e003b16618704c3c90350c1d4f', '[\"*\"]', NULL, NULL, '2024-02-18 09:30:13', '2024-02-18 09:30:13'),
(378, 'App\\Models\\User', 1, 'auth_token', '38f5cac84c9ac04cc0d51016191c41fd9ef1f4ab23df1a9b5c05157a87c19c97', '[\"*\"]', NULL, NULL, '2024-02-18 09:32:10', '2024-02-18 09:32:10'),
(379, 'App\\Models\\User', 1, 'auth_token', 'a294201375722ad2226f0b4634ecc9fdd747ea96a317f912e7d1d52675484067', '[\"*\"]', NULL, NULL, '2024-02-18 09:32:11', '2024-02-18 09:32:11'),
(380, 'App\\Models\\User', 1, 'auth_token', '524190c1c9e28b77208a12a188454b1ff250da8ad0233925389ab016e35172a9', '[\"*\"]', NULL, NULL, '2024-02-18 09:32:12', '2024-02-18 09:32:12'),
(381, 'App\\Models\\User', 1, 'auth_token', '64f536f6972896c47f31fe4bb9f1624ba656c2d9f95f407df497145c51894d86', '[\"*\"]', NULL, NULL, '2024-02-18 09:32:12', '2024-02-18 09:32:12'),
(382, 'App\\Models\\User', 1, 'auth_token', 'e2fc298ecc7cb73093d533dc5dd2729c2b64aec85826712803359b878c260cb2', '[\"*\"]', NULL, NULL, '2024-02-18 09:33:56', '2024-02-18 09:33:56'),
(383, 'App\\Models\\User', 1, 'auth_token', 'ea748bf4da3e5f2238cba3fd9c340a1a07f13d45c2301196b3572066e2212832', '[\"*\"]', NULL, NULL, '2024-02-18 09:44:12', '2024-02-18 09:44:12'),
(384, 'App\\Models\\User', 1, 'auth_token', '1bc17b76890605ccaf8f474d703ee8c494a90fc34821f61e3e4a15d4e4bd51ac', '[\"*\"]', NULL, NULL, '2024-02-18 09:48:24', '2024-02-18 09:48:24'),
(385, 'App\\Models\\User', 1, 'auth_token', '399b38d27dee4dcbc710559f88b85616afda337237589197a445b2f6e4f7e50e', '[\"*\"]', NULL, NULL, '2024-02-18 09:50:43', '2024-02-18 09:50:43'),
(386, 'App\\Models\\User', 1, 'auth_token', '6c2e8c70ec2b32f45e55f37734e5a6f7c31517c3c710033131605ee554b93637', '[\"*\"]', NULL, NULL, '2024-02-18 09:58:45', '2024-02-18 09:58:45'),
(387, 'App\\Models\\User', 1, 'auth_token', '141be49f4a7178b314a3c6de3d3b75766377a9da943c196c9935bbce70e007d9', '[\"*\"]', NULL, NULL, '2024-02-18 10:01:03', '2024-02-18 10:01:03'),
(388, 'App\\Models\\User', 1, 'auth_token', '16da8bd652d92d001fb87690f6cd03e2bc0c7d6cf01a37fb82ebcf7d8cfce075', '[\"*\"]', NULL, NULL, '2024-02-18 10:01:04', '2024-02-18 10:01:04'),
(389, 'App\\Models\\User', 1, 'auth_token', 'ec9bb6f3eef8fcba610945f28b7aafb26bccb15c5d28310c8fd1e94b889c951b', '[\"*\"]', NULL, NULL, '2024-02-18 10:02:51', '2024-02-18 10:02:51'),
(390, 'App\\Models\\User', 1, 'auth_token', '4131640b092b9091b4487a2ed79855fe077e06214d014a744a8b14d895f49529', '[\"*\"]', NULL, NULL, '2024-02-18 10:04:40', '2024-02-18 10:04:40'),
(391, 'App\\Models\\User', 1, 'auth_token', '9eb5c35b99739d934d8fb46698fe70152298d1f56e8deb938db210bf2a3cb14c', '[\"*\"]', NULL, NULL, '2024-02-18 10:05:42', '2024-02-18 10:05:42'),
(392, 'App\\Models\\User', 1, 'auth_token', '19410f339a8022948616acaddf0f6a91a5d284ce90c880abb93173f714a9058d', '[\"*\"]', NULL, NULL, '2024-02-18 10:07:03', '2024-02-18 10:07:03'),
(393, 'App\\Models\\User', 1, 'auth_token', 'd013534f167616c8fde6279fbd2b1ca0c0e7965ec9dc22e8495700a0a66e2964', '[\"*\"]', NULL, NULL, '2024-02-18 10:08:13', '2024-02-18 10:08:13'),
(394, 'App\\Models\\User', 1, 'auth_token', '0d0f849c6bd089124e0bcf4ec3b246dd035b55167b29a2c804304a48e87dc5be', '[\"*\"]', NULL, NULL, '2024-02-18 10:09:14', '2024-02-18 10:09:14'),
(395, 'App\\Models\\User', 1, 'auth_token', '8ccd0fd9d0f1b53fdde97c4031ce2bd1f3e67162d98574ab8201119c36f18a02', '[\"*\"]', NULL, NULL, '2024-02-18 10:18:05', '2024-02-18 10:18:05'),
(396, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '041a6cda8b7e6026b69bcfd1a8e08358602ab54c434aa1f83a1c830f841de301', '[\"*\"]', NULL, NULL, '2024-02-18 10:19:00', '2024-02-18 10:19:00'),
(397, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '2910ad83b85097ad129df4bf92d03baaa513353fb04356bcec152bd2db40db6b', '[\"*\"]', NULL, NULL, '2024-02-18 10:19:01', '2024-02-18 10:19:01'),
(398, 'App\\Models\\User', 1, 'auth_token', 'e496cefccc353a69f66e311f7ed0c7897c666f21b8e09b15e1fa3182058c1c93', '[\"*\"]', NULL, NULL, '2024-02-18 10:20:34', '2024-02-18 10:20:34'),
(399, 'App\\Models\\Akunwisatawan', 41, 'auth_token', 'c50282801e9161702221dd5f4671cf3be34157364fe47c5fd07619c934383650', '[\"*\"]', NULL, NULL, '2024-02-18 10:23:54', '2024-02-18 10:23:54'),
(400, 'App\\Models\\Akunwisatawan', 41, 'auth_token', '74f77fc765940a2903b4530451036b419969340d8592ca8f7b1e94cbd14dc33e', '[\"*\"]', NULL, NULL, '2024-02-18 10:25:06', '2024-02-18 10:25:06'),
(401, 'App\\Models\\User', 1, 'auth_token', '5676d67745b5e793935df5a74ffec244847f9679f8dd21cf26a3f10eed8bcdf3', '[\"*\"]', NULL, NULL, '2024-02-18 10:59:05', '2024-02-18 10:59:05'),
(402, 'App\\Models\\User', 1, 'auth_token', 'c9b455e11c1a27aa2d3c0d7a1894d2c19c09669e08b3cf7ac5bd3b5d73f7b2d2', '[\"*\"]', NULL, NULL, '2024-02-18 11:09:18', '2024-02-18 11:09:18'),
(403, 'App\\Models\\User', 1, 'auth_token', 'e850111f561a3a1507b11c83ab32314e114cce346f38a2e60e25aa9440127dad', '[\"*\"]', NULL, NULL, '2024-02-18 11:17:59', '2024-02-18 11:17:59'),
(404, 'App\\Models\\Akunwisatawan', 41, 'auth_token', '4944aac81b5c09c615ab5adf4dbe7175eee52bcc8dd23eb6e1812c6a4f54c65f', '[\"*\"]', NULL, NULL, '2024-02-18 11:19:01', '2024-02-18 11:19:01'),
(405, 'App\\Models\\Akunwisatawan', 41, 'auth_token', '79f2f9075048e0907b501a858ae78693cfc3a7d7412e09fc6146a543288531a2', '[\"*\"]', NULL, NULL, '2024-02-18 11:40:53', '2024-02-18 11:40:53'),
(406, 'App\\Models\\Akunwisatawan', 41, 'auth_token', '17a0292b87d1a5f16ef8129042f996e1997967f7e745c41828f1b353752a1760', '[\"*\"]', NULL, NULL, '2024-02-18 11:40:55', '2024-02-18 11:40:55'),
(407, 'App\\Models\\Akunwisatawan', 41, 'auth_token', '8f889f1d7957b503a0568d9220ef6a803d77ae18042084a4b30dc980f40eab68', '[\"*\"]', NULL, NULL, '2024-02-18 11:40:56', '2024-02-18 11:40:56'),
(408, 'App\\Models\\Akunwisatawan', 41, 'auth_token', '7687ecab7539c6c7c1469df76e4d53117a9b412793489abaa8d6017ff12d8fbe', '[\"*\"]', NULL, NULL, '2024-02-18 11:40:56', '2024-02-18 11:40:56'),
(409, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'd0d2cd915dd5e09daf391d549f576bfb08677752fc68f44d6e7b0c4041a992c7', '[\"*\"]', NULL, NULL, '2024-02-18 19:03:49', '2024-02-18 19:03:49'),
(410, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '9c95c949253f4a89d56c529c6c7a907e8459157fae3be24546e3b419d78b4ddf', '[\"*\"]', NULL, NULL, '2024-02-18 19:03:50', '2024-02-18 19:03:50'),
(411, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '64e3fd9b1750418c9a06709fb70680f750f6fbccd2c10315c10136d3537b495a', '[\"*\"]', NULL, NULL, '2024-02-18 19:03:51', '2024-02-18 19:03:51'),
(412, 'App\\Models\\Akunwisatawan', 1, 'auth_token', 'daf94f5b0b665596bdd2d8c768c4758321c5ab5ca440b0e2003fd2519bc11962', '[\"*\"]', NULL, NULL, '2024-02-18 19:03:51', '2024-02-18 19:03:51'),
(413, 'App\\Models\\User', 1, 'auth_token', '928bcad2b7db0b9d715a3dbba804e335ebfa6ee40ee7ee04e9942262d2d5d0a3', '[\"*\"]', NULL, NULL, '2024-02-18 19:08:05', '2024-02-18 19:08:05'),
(414, 'App\\Models\\User', 1, 'auth_token', '76c700edbb33c3b5e2173ab4fc2679bb80675af71a7482894dce0d39b5c158fb', '[\"*\"]', NULL, NULL, '2024-02-18 19:08:06', '2024-02-18 19:08:06'),
(415, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '26328ee88f59bfe11ccfaa246d67d6e207063830d115db5dc6af7d78e0ed3134', '[\"*\"]', NULL, NULL, '2024-02-18 19:09:14', '2024-02-18 19:09:14'),
(416, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '982527ede764946bbab3a65c27902b7ea5f958aae843d1197ec24f7c58868b28', '[\"*\"]', NULL, NULL, '2024-02-18 19:09:15', '2024-02-18 19:09:15'),
(417, 'App\\Models\\User', 1, 'auth_token', '244826da2e36889f36227c695570c2224d27b0d91259f15ef299cb7f5e045a7c', '[\"*\"]', NULL, NULL, '2024-02-18 19:11:04', '2024-02-18 19:11:04'),
(418, 'App\\Models\\User', 1, 'auth_token', '036882d65eaa519124f7155763ded8a3beaac16d53be90ecf30c463e899e3452', '[\"*\"]', NULL, NULL, '2024-02-19 00:05:10', '2024-02-19 00:05:10'),
(419, 'App\\Models\\User', 1, 'auth_token', '9f6a627871733579af9851fe0df44b4e6093c77735325e7e2dbf7ca2a4e78f4f', '[\"*\"]', NULL, NULL, '2024-02-19 00:05:11', '2024-02-19 00:05:11'),
(420, 'App\\Models\\User', 1, 'auth_token', 'cec171c5908547846edae86a0b55e7f42913187a2d0981ae30c53f374c1590f6', '[\"*\"]', NULL, NULL, '2024-02-19 00:05:13', '2024-02-19 00:05:13'),
(421, 'App\\Models\\User', 1, 'auth_token', 'a58dd230db2d56160748296c43e2427b88228ebee7d59c76f97bbe67883dbd8e', '[\"*\"]', NULL, NULL, '2024-02-19 00:05:16', '2024-02-19 00:05:16'),
(422, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '67e602723871cccb82c2b15bab3841138fa9522ae587646df5d9308fa2ac005a', '[\"*\"]', NULL, NULL, '2024-02-19 00:06:47', '2024-02-19 00:06:47'),
(423, 'App\\Models\\User', 1, 'auth_token', '3efb2a79532145a52f3795f277c447eb6f281f63572893e642e87f06823160b9', '[\"*\"]', NULL, NULL, '2024-02-19 00:58:13', '2024-02-19 00:58:13'),
(424, 'App\\Models\\User', 1, 'auth_token', 'b1998668b6ef9d64d8eb2b9fbbaf49bdcc258d5cea2c65f74d0e6f77c18632be', '[\"*\"]', NULL, NULL, '2024-02-23 07:16:29', '2024-02-23 07:16:29'),
(425, 'App\\Models\\User', 1, 'auth_token', 'c14b48a0dc4b10faf0fd6d3bfa59006943d627561f5b2ed2e9118f894aa802b7', '[\"*\"]', NULL, NULL, '2024-02-23 07:16:30', '2024-02-23 07:16:30'),
(426, 'App\\Models\\User', 1, 'auth_token', '5bf4c7c152b72f336d02a28382b48478ca17d8bc276cd70f1b18d8140829322b', '[\"*\"]', NULL, NULL, '2024-02-23 07:16:31', '2024-02-23 07:16:31'),
(427, 'App\\Models\\User', 1, 'auth_token', '7db12fb5ab6f72a663f66037688605221c538de8dfeb78cf64156d09787c3c08', '[\"*\"]', NULL, NULL, '2024-02-23 07:20:30', '2024-02-23 07:20:30'),
(428, 'App\\Models\\User', 1, 'auth_token', '7fd4fc826cf2844d3ec2866496fda159a031e4b0473840a935c600546899db14', '[\"*\"]', NULL, NULL, '2024-02-23 07:30:25', '2024-02-23 07:30:25'),
(429, 'App\\Models\\User', 1, 'auth_token', '8d7e26d50b28425a8c20d82c2a4af1601be8f92f8f48b1a9582fffa29ed0bb3c', '[\"*\"]', NULL, NULL, '2024-02-23 07:31:24', '2024-02-23 07:31:24'),
(430, 'App\\Models\\User', 1, 'auth_token', 'c4a52a09e1bd81e4de26fa1f7e0b8c6e456e79d46c66b76accf65deff5355eca', '[\"*\"]', NULL, NULL, '2024-02-23 10:20:49', '2024-02-23 10:20:49'),
(431, 'App\\Models\\User', 1, 'auth_token', '0121749771b015b29e1a4328e500d65ea370b5dfd543361ba76963215b39e230', '[\"*\"]', NULL, NULL, '2024-02-23 10:20:51', '2024-02-23 10:20:51'),
(432, 'App\\Models\\User', 1, 'auth_token', 'f05c2f49e244cec2a08536e3b75882d2fc20db4800f37581f2286835583ede0b', '[\"*\"]', NULL, NULL, '2024-02-23 10:37:57', '2024-02-23 10:37:57'),
(433, 'App\\Models\\User', 1, 'auth_token', 'dd11c8a540cc7b1b70b1c9e6101a6510b88f9d74c963a7928cffa15eca9e51af', '[\"*\"]', NULL, NULL, '2024-02-23 10:50:29', '2024-02-23 10:50:29'),
(434, 'App\\Models\\User', 1, 'auth_token', '442019236a523141e5c3cb6d89c2b51a5e22b3bc5e5e2bbebc5e908d39f10a3f', '[\"*\"]', NULL, NULL, '2024-02-23 10:50:33', '2024-02-23 10:50:33'),
(435, 'App\\Models\\User', 1, 'auth_token', '12a7ca70545faf707359c4bec6d5cae83166bee7148f9789dea9eaba5570831e', '[\"*\"]', NULL, NULL, '2024-02-23 11:43:51', '2024-02-23 11:43:51'),
(436, 'App\\Models\\User', 1, 'auth_token', '85e834bb8e24ef51bb0fb8a6bd0b770b72bf7b9c76130531a8ee51e72ef54061', '[\"*\"]', NULL, NULL, '2024-02-23 11:43:54', '2024-02-23 11:43:54'),
(437, 'App\\Models\\User', 1, 'auth_token', '1af508864e9ffe3c3d49ca7373cd5ec00caac48ca95f405c23c58ea32b5814f0', '[\"*\"]', NULL, NULL, '2024-02-23 11:45:48', '2024-02-23 11:45:48'),
(438, 'App\\Models\\User', 1, 'auth_token', 'ed7a50492fc8578d953c8b886edb99aa3b99b0ba13af2f35e793d8c8c4b27f85', '[\"*\"]', NULL, NULL, '2024-02-23 11:57:50', '2024-02-23 11:57:50'),
(439, 'App\\Models\\User', 1, 'auth_token', '61f040c0d4d2bc01bca8021e72f60427bbcf89b723caccc796490f17f78f7f29', '[\"*\"]', NULL, NULL, '2024-02-23 11:58:21', '2024-02-23 11:58:21'),
(440, 'App\\Models\\User', 1, 'auth_token', 'b8413e68c69821698c0d4600a5408d516d791e0da46e0e4031ba93e57f9858d4', '[\"*\"]', NULL, NULL, '2024-02-23 11:58:22', '2024-02-23 11:58:22'),
(441, 'App\\Models\\User', 1, 'auth_token', '28613a93cacc7b9a738774298720a15ab1d40940ca40d9f1e46bfdc6e4c110aa', '[\"*\"]', NULL, NULL, '2024-02-23 11:58:23', '2024-02-23 11:58:23'),
(442, 'App\\Models\\User', 1, 'auth_token', '360565357969f2266b4f0d7755a78cafc2a1f3df4fb4f00e131eb6c9c0b3829d', '[\"*\"]', NULL, NULL, '2024-02-23 11:58:24', '2024-02-23 11:58:24'),
(443, 'App\\Models\\User', 1, 'auth_token', '25d9192d183838a3b26a2783c218183611a347841d0c48a0f2f49325700e9d5b', '[\"*\"]', NULL, NULL, '2024-02-23 11:58:26', '2024-02-23 11:58:26'),
(444, 'App\\Models\\User', 1, 'auth_token', 'f90722047e1d0850fe07796faa98e763039f55adbb6b34220fca31eab7884dfa', '[\"*\"]', NULL, NULL, '2024-02-23 11:58:27', '2024-02-23 11:58:27'),
(445, 'App\\Models\\User', 1, 'auth_token', 'a2aaa34c5687229d1dc7274dd38fdfb4452209bebb9a633d93d87c6039ebc31f', '[\"*\"]', NULL, NULL, '2024-02-23 11:58:28', '2024-02-23 11:58:28'),
(446, 'App\\Models\\User', 1, 'auth_token', 'd09698925104572810d191a7810fff352c71686f67c16cc1a6e141bb702cc4db', '[\"*\"]', NULL, NULL, '2024-02-23 11:58:58', '2024-02-23 11:58:58'),
(447, 'App\\Models\\User', 1, 'auth_token', 'f574ac96b40b667f5a8311a7ef9070d3c22bf9a10deaaa60526aa69e08ed8eea', '[\"*\"]', NULL, NULL, '2024-02-23 15:46:25', '2024-02-23 15:46:25'),
(448, 'App\\Models\\User', 1, 'auth_token', '8da8b8bbcf32c7dfa1fe3cce008ae4523ba6399a2943189b628de0efcc0570c9', '[\"*\"]', NULL, NULL, '2024-02-23 16:20:31', '2024-02-23 16:20:31'),
(449, 'App\\Models\\Akunwisatawan', 42, 'auth_token', '84ff7db53bef38ae066e423ca806058b27eac2227cfe7e93125142599de8dfe2', '[\"*\"]', NULL, NULL, '2024-02-23 16:44:44', '2024-02-23 16:44:44'),
(450, 'App\\Models\\Akunwisatawan', 42, 'auth_token', '78a1dff2d4b3022fa6870c9cc033af2cf4c9a17cce84c675f85ef4b7300e18b4', '[\"*\"]', NULL, NULL, '2024-02-23 16:45:36', '2024-02-23 16:45:36'),
(451, 'App\\Models\\Akunwisatawan', 42, 'auth_token', '50e0445dd2d0bbeb6ddee649e0c5fd447bc79702d908ee811878cd1bc20029a5', '[\"*\"]', NULL, NULL, '2024-02-23 16:46:01', '2024-02-23 16:46:01'),
(452, 'App\\Models\\User', 1, 'auth_token', '4ec71b76df3d8cbf8dabf9ef3c7afcfe48219a75fbab9b9dadea1260a5f98e07', '[\"*\"]', NULL, NULL, '2024-02-23 18:25:09', '2024-02-23 18:25:09'),
(453, 'App\\Models\\User', 1, 'auth_token', '95feb8c5376f0f04f72f28c18ece769170327a3f5f6b517bb57fe46be31ca924', '[\"*\"]', NULL, NULL, '2024-02-23 18:25:10', '2024-02-23 18:25:10'),
(454, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '65b014664fa2129bec208d31b05bd25d2a14fb68cc8d5a0f93b70a7906879c34', '[\"*\"]', NULL, NULL, '2024-02-23 18:28:43', '2024-02-23 18:28:43'),
(455, 'App\\Models\\User', 1, 'auth_token', 'af3ead7b4b75985437af5d0b3cb87b920b376e60b44aefce5161aed325fb2b14', '[\"*\"]', NULL, NULL, '2024-02-24 00:09:45', '2024-02-24 00:09:45'),
(456, 'App\\Models\\User', 1, 'auth_token', 'b217e44ef185d2386d80c8922157986a5a6df99a166178d3e17ebfc406d881bf', '[\"*\"]', NULL, NULL, '2024-02-24 00:09:47', '2024-02-24 00:09:47'),
(457, 'App\\Models\\User', 1, 'auth_token', '04961ce87977ca7e183fcce1c08a1bf91f3cd905483bbfb2fe29778a7de9f03b', '[\"*\"]', NULL, NULL, '2024-02-24 00:09:48', '2024-02-24 00:09:48'),
(458, 'App\\Models\\User', 1, 'auth_token', '1d8ed89752ae53e1988ce90bde17c8668f6255be03410de65daf02a8ee9a2c78', '[\"*\"]', NULL, NULL, '2024-02-24 17:04:26', '2024-02-24 17:04:26'),
(459, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '0ca40036e30548dd571aa85aa7df736f87d74f74dc36023ae1760f538919ccbf', '[\"*\"]', NULL, NULL, '2024-02-24 17:04:55', '2024-02-24 17:04:55'),
(460, 'App\\Models\\User', 1, 'auth_token', '9dc4b293434856340f8dacd2e0d9e943c3314160052ab840e2ae3d129d607ad8', '[\"*\"]', NULL, NULL, '2024-02-25 03:53:13', '2024-02-25 03:53:13'),
(461, 'App\\Models\\User', 1, 'auth_token', 'bbe742893527bc6640e51ec95dcacb5fbb1d07560adf3de868899a7a1c7e0d8b', '[\"*\"]', NULL, NULL, '2024-02-25 03:53:20', '2024-02-25 03:53:20'),
(462, 'App\\Models\\User', 1, 'auth_token', 'd5ffd4cb807d299b24d55edcbf0ee7eb32ecedc018690fcdfc26758bbe1ce131', '[\"*\"]', NULL, NULL, '2024-02-25 03:53:24', '2024-02-25 03:53:24'),
(463, 'App\\Models\\User', 1, 'auth_token', 'd34726d3a046fafd991b2200e0eae11555e349423674d2a217b0d67a55e1baba', '[\"*\"]', NULL, NULL, '2024-02-25 03:53:30', '2024-02-25 03:53:30'),
(464, 'App\\Models\\User', 1, 'auth_token', '633cbf107b1c650320582e753420ee9e2efbe4416ead6c3fe2b5ddec86c7027a', '[\"*\"]', NULL, NULL, '2024-02-25 03:53:35', '2024-02-25 03:53:35'),
(465, 'App\\Models\\Akunwisatawan', 43, 'auth_token', '27e9a9b7c8164526b5652904814d997d97dff997ef8f06d603183afd9eaa319f', '[\"*\"]', NULL, NULL, '2024-08-01 20:59:09', '2024-08-01 20:59:09'),
(466, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '4598b116fb01d796284edc2d13032793f7fcdbf21b2963981631b371b7daddbc', '[\"*\"]', NULL, NULL, '2024-08-09 08:25:22', '2024-08-09 08:25:22'),
(467, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'a23b893f50ef839cf91868759a7b00d0c059aaabb2ff1e68bcc9ed77acb7d228', '[\"*\"]', NULL, NULL, '2024-08-09 08:25:24', '2024-08-09 08:25:24'),
(468, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '79af3d1dedbe4f93dac4e62e9514da8466b6d916abee69f8b3f905a2ebb4d695', '[\"*\"]', NULL, NULL, '2024-08-09 08:25:28', '2024-08-09 08:25:28'),
(469, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '8b10c6702f9b8211ebc9d07906bdae5f0fdefcabae494637c70ffc6cf9e6823b', '[\"*\"]', NULL, NULL, '2024-08-10 21:48:21', '2024-08-10 21:48:21'),
(470, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '834320e17f6e24d96f9c1c84cdd111340a0e9810ab2295477fe111942a1d859a', '[\"*\"]', NULL, NULL, '2024-08-10 21:48:23', '2024-08-10 21:48:23'),
(471, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '8cfe6e940dba883c91a3759a92c6b58679256022f89548a442dd7476eeaa7430', '[\"*\"]', NULL, NULL, '2024-08-10 21:48:24', '2024-08-10 21:48:24'),
(472, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '0750955476418f1ece42b631298de14d0360dfaf92c6eb8284b101446e6d6af0', '[\"*\"]', NULL, NULL, '2024-08-10 21:48:26', '2024-08-10 21:48:26'),
(473, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '75808957dab508718b6173dae659d9f2ec40e6bc2baec22b3e252bc085627f6b', '[\"*\"]', NULL, NULL, '2024-08-10 22:26:19', '2024-08-10 22:26:19'),
(474, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '450bf91afb77b1236277d23bbdf5c47a1ca66ab24867b40a16e7a6262d4dcddd', '[\"*\"]', NULL, NULL, '2024-08-10 22:26:20', '2024-08-10 22:26:20'),
(475, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '36851e10404a928971c9161778897ce6af9493faee8cda4dcc97795d9eb6e1b4', '[\"*\"]', NULL, NULL, '2024-08-10 22:26:21', '2024-08-10 22:26:21'),
(476, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '24f9d596b5cf440f08d3ecb05731ef46d7bcc48c1fdc196b15b7ddb327ba12fa', '[\"*\"]', NULL, NULL, '2024-08-10 22:33:04', '2024-08-10 22:33:04'),
(477, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '9b81a1efe16f8ef84901dd1abcb4ae7d249b5c7bfcf129c9602100bf118468a4', '[\"*\"]', NULL, NULL, '2024-08-10 22:33:05', '2024-08-10 22:33:05'),
(478, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '0eed30178d4f52a43e1ba024ab837f59d42afbeb004a32a4e0d71d06a45fe566', '[\"*\"]', NULL, NULL, '2024-08-10 22:34:57', '2024-08-10 22:34:57'),
(479, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '8e4d20917de62c534af6b26c9badb055b56086a3698996bc4c7ea8221316c35c', '[\"*\"]', NULL, NULL, '2024-08-10 22:36:31', '2024-08-10 22:36:31'),
(480, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '4393223ab2b9361ed2996b56c5a48caea7e51a166ad1c733f256ecf86d31eb33', '[\"*\"]', NULL, NULL, '2024-08-10 22:36:32', '2024-08-10 22:36:32'),
(481, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'e2ca01927fa6355d3eb54f0c32d3db5c243b5ec63d444952500ca39008c3d59c', '[\"*\"]', NULL, NULL, '2024-08-10 22:36:33', '2024-08-10 22:36:33'),
(482, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '4a87472acd5c3d908ecc25bd0c7a19e2f3786091809219c5a4b228ba788df829', '[\"*\"]', NULL, NULL, '2024-08-10 22:42:44', '2024-08-10 22:42:44'),
(483, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'c3ec2fa6f7f83bd908b7de4329545cf07050ab7c52b7eef39b6f8a91d6997cc8', '[\"*\"]', NULL, NULL, '2024-08-10 22:58:58', '2024-08-10 22:58:58'),
(484, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '8df7a5ef1be51d3f9439818fd0a4a4c01009d6a9b2f347174e2caa84c5013454', '[\"*\"]', NULL, NULL, '2024-08-10 22:59:00', '2024-08-10 22:59:00'),
(485, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '221f4ad8736be34b8ce9224aea9285e5b7d0b3da38a72f5e3ac61598b80992e2', '[\"*\"]', NULL, NULL, '2024-08-10 23:03:01', '2024-08-10 23:03:01'),
(486, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'a61c437d77fea59a2ab92bcaab175047f1d2f872467021dc842b64c52cfa42ae', '[\"*\"]', NULL, NULL, '2024-08-10 23:08:31', '2024-08-10 23:08:31'),
(487, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '31cae253e6493d36f720271c7fb077b84fdc10f0bfd69828586830f6ed50fa53', '[\"*\"]', NULL, NULL, '2024-08-10 23:12:46', '2024-08-10 23:12:46'),
(488, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'b346c3478b543c128036fb3013326f5d842a6c3ab086831433ca79527b69e7c6', '[\"*\"]', NULL, NULL, '2024-08-10 23:17:18', '2024-08-10 23:17:18'),
(489, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'd014ec2ca433cab1eeb5d973710fac6a7387c283d1ef909db691909d2c25a654', '[\"*\"]', NULL, NULL, '2024-08-10 23:20:05', '2024-08-10 23:20:05'),
(490, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'fb15f4d00a377d37a8633ecc8eef634109093d66634ac991c20b885665b17b1f', '[\"*\"]', NULL, NULL, '2024-08-10 23:23:01', '2024-08-10 23:23:01'),
(491, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '9173991fcd029309637c013aa7f24c7ac20a20ddf1ee718d80ccfd943da6aa8b', '[\"*\"]', NULL, NULL, '2024-08-10 23:26:52', '2024-08-10 23:26:52'),
(492, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '5445469b4653d73f766b7a28bbf8fa08505fef4f0283173bbdaa5efe2ce38ffe', '[\"*\"]', NULL, NULL, '2024-08-10 23:30:43', '2024-08-10 23:30:43'),
(493, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '4dfc4b6aa54334694fa376a458ffa94f850851acc8b1aba656f1afd04e0f495d', '[\"*\"]', NULL, NULL, '2024-08-10 23:35:55', '2024-08-10 23:35:55'),
(494, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '8f44e569e888d9a32f6109d6b24e43bd8b76fe0edfce4d05207d3f8a52376f83', '[\"*\"]', NULL, NULL, '2024-08-10 23:37:51', '2024-08-10 23:37:51'),
(495, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'cbbc41d655c4a47c179dd41acc25800f79c558282c1e82f123fab63f5a798572', '[\"*\"]', NULL, NULL, '2024-08-10 23:40:42', '2024-08-10 23:40:42'),
(496, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'd7a03baa1be29139eb50922a747bd00a1319f00d469beb631fc79e37617b7c7d', '[\"*\"]', NULL, NULL, '2024-08-10 23:46:41', '2024-08-10 23:46:41'),
(497, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'a762c3830cc5ce50adea524d390c5df1c40d644e66fd788aafff68f51699058d', '[\"*\"]', NULL, NULL, '2024-08-10 23:49:01', '2024-08-10 23:49:01'),
(498, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'f105027aed8b51dba0e1b6bbca569e376cd504dc3433dc1cd43b48cd95018c9a', '[\"*\"]', NULL, NULL, '2024-08-11 00:06:50', '2024-08-11 00:06:50'),
(499, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '502f8940d4bc79ee5a5cd8e62a6420286b000d8c0bde8693cde3ee3d975dac5c', '[\"*\"]', NULL, NULL, '2024-08-11 00:13:09', '2024-08-11 00:13:09'),
(500, 'App\\Models\\User', 4, 'auth_token', 'cd2cd5abc7ddd2445c89b5266c83e80090611decc956ce6cc522ade6b2d339f8', '[\"*\"]', NULL, NULL, '2024-08-12 14:23:36', '2024-08-12 14:23:36'),
(501, 'App\\Models\\Akunwisatawan', 46, 'auth_token', 'd3d6e7f67378825ac1c8da299323eb52953dfcec7eae3f86e31c24e4f3446e47', '[\"*\"]', NULL, NULL, '2024-08-12 14:25:58', '2024-08-12 14:25:58'),
(502, 'App\\Models\\User', 5, 'auth_token', 'c8c3ce07e953786e5beefe51d97359f0ad0f8138acba5e7348ed847c91003d85', '[\"*\"]', NULL, NULL, '2024-08-12 14:29:35', '2024-08-12 14:29:35'),
(503, 'App\\Models\\User', 7, 'auth_token', '987134e3ad44c487a20a7fc1c580c043979c3689f8680e3f4bdac4dfa01e0e25', '[\"*\"]', NULL, NULL, '2024-08-12 15:03:55', '2024-08-12 15:03:55'),
(504, 'App\\Models\\User', 7, 'auth_token', '475c7850a566b941d958de23fe6d06a5ffaa7b8de3a75c8b975eb217feaff697', '[\"*\"]', NULL, NULL, '2024-08-12 21:04:14', '2024-08-12 21:04:14'),
(505, 'App\\Models\\Akunwisatawan', 1, 'auth_token', '095c65d5364de6ccc6f681296a762e280e4a669a2d62a6f1cfe95b3af7dcb9ca', '[\"*\"]', NULL, NULL, '2024-08-12 21:13:44', '2024-08-12 21:13:44'),
(506, 'App\\Models\\User', 9, 'auth_token', 'fbf1981879ae009d10cf4147c55dd04e3cbdf829e648ceed35cedaf8d3620713', '[\"*\"]', NULL, NULL, '2024-08-12 21:39:29', '2024-08-12 21:39:29'),
(507, 'App\\Models\\User', 9, 'auth_token', 'e090629464c42c1c072b3907d78e82b0e2fb8d22b61af9d847cffb6433f1cc01', '[\"*\"]', NULL, NULL, '2024-08-12 22:37:19', '2024-08-12 22:37:19'),
(508, 'App\\Models\\User', 9, 'auth_token', 'a5e31ce99996ecae209459b5f43b1b7b21a88d40f1fd926c37e502c7939bf773', '[\"*\"]', NULL, NULL, '2024-08-12 22:37:21', '2024-08-12 22:37:21'),
(509, 'App\\Models\\User', 9, 'auth_token', 'bd388fef11581fff8d5ada8261d92f28ca74dd2b3fc01e7e04bd605a5cb68a2b', '[\"*\"]', NULL, NULL, '2024-08-12 22:37:22', '2024-08-12 22:37:22'),
(510, 'App\\Models\\User', 9, 'auth_token', 'ce4a754e63a74156513a0b5f1f0ea8468dfa82e1e38fa1a88c20bc19060a7ee0', '[\"*\"]', NULL, NULL, '2024-08-12 22:37:44', '2024-08-12 22:37:44'),
(511, 'App\\Models\\User', 9, 'auth_token', '649e10d6cd84e60139a18a39f25caf2c5359c2198df6c59e29110b56c1eda52a', '[\"*\"]', NULL, NULL, '2024-08-12 22:56:14', '2024-08-12 22:56:14'),
(512, 'App\\Models\\User', 9, 'auth_token', '56e7f3a274b75be7311f258767e56e5cf8b08cf160697c89c705bae4f8586874', '[\"*\"]', NULL, NULL, '2024-08-12 22:56:16', '2024-08-12 22:56:16'),
(513, 'App\\Models\\User', 9, 'auth_token', '47bc9ef7c0f6f7873d09babc4a308465b92e4ff346d76e4709677415604236c0', '[\"*\"]', NULL, NULL, '2024-08-12 22:56:20', '2024-08-12 22:56:20'),
(514, 'App\\Models\\User', 9, 'auth_token', '9c586f1f37441aab54c4eaef8c26ccf0c0517e0078c0e8fc3690303c801d00bc', '[\"*\"]', NULL, NULL, '2024-08-12 23:19:43', '2024-08-12 23:19:43'),
(515, 'App\\Models\\User', 9, 'auth_token', '8fc37929f706a47689d09b5dc301105a46a6c100506ebad45bef3ae77bdd4b2f', '[\"*\"]', NULL, NULL, '2024-08-12 23:19:44', '2024-08-12 23:19:44'),
(516, 'App\\Models\\User', 9, 'auth_token', '0f2673294c2245b46e29629edb0ad4f84349acac3a6b2e1b51c0cc3318ab7d50', '[\"*\"]', NULL, NULL, '2024-08-12 23:19:46', '2024-08-12 23:19:46'),
(517, 'App\\Models\\User', 9, 'auth_token', '2a6c66e4b943f4860b4fc50fcdecc1eed7adc59837563323adf3749de69c32b3', '[\"*\"]', NULL, NULL, '2024-08-12 23:19:47', '2024-08-12 23:19:47'),
(518, 'App\\Models\\User', 9, 'auth_token', 'a3d17929223a56ee678cd2bc27d2f839ef66e11d0bc9439ffaae1d70d5823b65', '[\"*\"]', NULL, NULL, '2024-08-12 23:19:48', '2024-08-12 23:19:48'),
(519, 'App\\Models\\User', 9, 'auth_token', '1c4def3deefae17ed9045a208269ad07846893a71b3bc9a88cc83817d686467d', '[\"*\"]', NULL, NULL, '2024-08-12 23:24:44', '2024-08-12 23:24:44'),
(520, 'App\\Models\\User', 9, 'auth_token', '425ec1b431f70a1c8851162261bb67f9393646b1436834d91628dd6da00a4aaa', '[\"*\"]', NULL, NULL, '2024-08-12 23:24:45', '2024-08-12 23:24:45'),
(521, 'App\\Models\\User', 9, 'auth_token', 'cddf989a8c63ab2cd4c1cbb24d419b856421342fab87aefa0ea74630a3aa2e70', '[\"*\"]', NULL, NULL, '2024-08-12 23:24:47', '2024-08-12 23:24:47'),
(522, 'App\\Models\\User', 9, 'auth_token', '93aab7fb9c0768426490087e1fdde6e3b183fd677aee2519e5586df2a52c4a21', '[\"*\"]', NULL, NULL, '2024-08-12 23:24:50', '2024-08-12 23:24:50'),
(523, 'App\\Models\\User', 9, 'auth_token', '5fe3d160d2ec557ebd82e8a105e48ae177e4735b1369d05fd911ce16d1fd34e2', '[\"*\"]', NULL, NULL, '2024-08-12 23:24:51', '2024-08-12 23:24:51'),
(524, 'App\\Models\\User', 9, 'auth_token', 'f889812492185c75a6ef7ac1bea2e1643155d6e66bb7f57448715ca9242982c3', '[\"*\"]', NULL, NULL, '2024-08-12 23:24:52', '2024-08-12 23:24:52'),
(525, 'App\\Models\\User', 9, 'auth_token', '765aa82ffe38280ceba4586e3ffa1fcd93f8fc578e595983a4473db5b71e602e', '[\"*\"]', NULL, NULL, '2024-08-12 23:24:53', '2024-08-12 23:24:53'),
(526, 'App\\Models\\User', 9, 'auth_token', '1f6c6462115780cac7a46b773f094f8cc92983af1a7e5b9600ebebccfd63026f', '[\"*\"]', NULL, NULL, '2024-08-12 23:24:55', '2024-08-12 23:24:55'),
(527, 'App\\Models\\Akunwisatawan', 43, 'auth_token', '8cb365242cd5d5be1b4adb5e3e7a597126ece5737345d0fe4293af39b77ff614', '[\"*\"]', NULL, NULL, '2024-08-12 23:29:08', '2024-08-12 23:29:08'),
(528, 'App\\Models\\User', 9, 'auth_token', '7ff15d0a98629cbab929562ef2447c58a30cf3a12c0e1f3f2d17dcd30a61c84c', '[\"*\"]', NULL, NULL, '2024-08-12 23:30:42', '2024-08-12 23:30:42'),
(529, 'App\\Models\\User', 9, 'auth_token', 'f57774747357a801b9ee3a6225b71983ae2b4d667f4d7e2f6b783ce43ccd3c21', '[\"*\"]', NULL, NULL, '2024-08-12 23:30:45', '2024-08-12 23:30:45'),
(530, 'App\\Models\\User', 9, 'auth_token', '2b1e224cbe0784fdffd1d87f1885cf8206557ff4b0c2ca3abc38a581289e9bfd', '[\"*\"]', NULL, NULL, '2024-08-12 23:30:47', '2024-08-12 23:30:47'),
(531, 'App\\Models\\User', 9, 'auth_token', 'dd2f8f42d933621891e60362397e973e048a3f6b9cb8c8937b7f1ec20db124b2', '[\"*\"]', NULL, NULL, '2024-08-12 23:30:48', '2024-08-12 23:30:48'),
(532, 'App\\Models\\User', 9, 'auth_token', '8f7e32f6e0cfe69e4001d3df710066f231f30cce8905e4c2e098b7dfe6612d4a', '[\"*\"]', NULL, NULL, '2024-08-12 23:32:19', '2024-08-12 23:32:19');
INSERT INTO `personal_access_tokens` (`id`, `tokenable_type`, `tokenable_id`, `name`, `token`, `abilities`, `last_used_at`, `expires_at`, `created_at`, `updated_at`) VALUES
(533, 'App\\Models\\User', 9, 'auth_token', 'a8bcb3ffeb72d67ac61b185b5c77ac4351552b77592378d06e7ddd8f1dbad5c6', '[\"*\"]', NULL, NULL, '2024-08-12 23:36:43', '2024-08-12 23:36:43'),
(534, 'App\\Models\\User', 9, 'auth_token', 'd83b16e85c345b1c203dd54d627edd24e7e3d70818bc93f04c50517db5bb40e8', '[\"*\"]', NULL, NULL, '2024-08-12 23:44:44', '2024-08-12 23:44:44'),
(535, 'App\\Models\\User', 9, 'auth_token', 'e4a319924dcfbcfaf74fbc8d6eba9a4574ddbb64b93b07a0fb06a35c0f733358', '[\"*\"]', NULL, NULL, '2024-08-12 23:44:49', '2024-08-12 23:44:49'),
(536, 'App\\Models\\User', 9, 'auth_token', 'af9236ae2ffda47cd8eb4570d1e2abb8d40262e0e99d6744540c4c177ab2e503', '[\"*\"]', NULL, NULL, '2024-08-12 23:46:43', '2024-08-12 23:46:43'),
(537, 'App\\Models\\User', 9, 'auth_token', '52bc57fe12496122b16ff4ece68086834b67eaae855ca92e3b0d961696569c61', '[\"*\"]', NULL, NULL, '2024-08-12 23:46:44', '2024-08-12 23:46:44'),
(538, 'App\\Models\\User', 9, 'auth_token', '59172415436f89b934a2f62c4780d1c66d34101ec908dac001420de67d65d5bf', '[\"*\"]', NULL, NULL, '2024-08-12 23:47:41', '2024-08-12 23:47:41'),
(539, 'App\\Models\\User', 9, 'auth_token', '7216208ed119b71c1a29a0d2cd3afa2873741e488487f233933b62e16f407826', '[\"*\"]', NULL, NULL, '2024-08-12 23:49:07', '2024-08-12 23:49:07'),
(540, 'App\\Models\\User', 9, 'auth_token', '012c41d3dd282c7d5ad042f06646ebb6a04d887f303f5cef4ba54d2b84845072', '[\"*\"]', NULL, NULL, '2024-08-12 23:52:15', '2024-08-12 23:52:15'),
(541, 'App\\Models\\Akunwisatawan', 46, 'auth_token', '6007af562a6b26a9f20240eea3dafe65e5f3662cb9d8aa89fa721f18834afa51', '[\"*\"]', NULL, NULL, '2024-08-12 23:59:18', '2024-08-12 23:59:18'),
(542, 'App\\Models\\User', 9, 'auth_token', '58c5fa11056727ce2ffbd952ab0d75f66f1d6484fd8a1597504f9c1af263dab2', '[\"*\"]', NULL, NULL, '2024-08-14 16:58:40', '2024-08-14 16:58:40'),
(543, 'App\\Models\\User', 9, 'auth_token', '99cc8745796bf24eba6881b2aff78912bee7b3a45ded2c2517d4371362b55d6a', '[\"*\"]', NULL, NULL, '2024-08-14 16:58:42', '2024-08-14 16:58:42');

-- --------------------------------------------------------

--
-- Table structure for table `tabeldaftarwisatas`
--

CREATE TABLE `tabeldaftarwisatas` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `kategori` varchar(100) NOT NULL,
  `namawisata` varchar(100) NOT NULL,
  `alamat` varchar(100) NOT NULL,
  `biaya` varchar(255) NOT NULL,
  `longitude` varchar(100) NOT NULL,
  `latitude` varchar(100) NOT NULL,
  `info` text NOT NULL,
  `fotobesar` varchar(255) NOT NULL,
  `fotokecil1` varchar(255) NOT NULL,
  `fotokecil2` varchar(255) NOT NULL,
  `fotokecil3` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `tabeldaftarwisatas`
--

INSERT INTO `tabeldaftarwisatas` (`id`, `kategori`, `namawisata`, `alamat`, `biaya`, `longitude`, `latitude`, `info`, `fotobesar`, `fotokecil1`, `fotokecil2`, `fotokecil3`, `created_at`, `updated_at`) VALUES
(7415022002, 'Wisata Alam', 'Jembatan Lingkar', 'Desa Wawoangi', 'Rp 10.000', '122.6836475', '-5.6594696', 'Namanya, jembatan lingkar Lapoili Desa Wawoangi, Kecamatan Sampolawa. Jembatan ini, dibangun tepat di sudut tebing laut yang berada di pesisir desa.\r\n\r\nBerlokasi di bawah bebatuan karst, dahulu, tempatnya tersembunyi dan tak banyak diketahui orang luar. Dilihat sepintas, jembatan yang berada di pesisir ini, mirip desain jembatan dan vila yang ada di Maldives. Tempatnya menghadap laut lepas dan pegunungan, air laut yang biru, mirip dengan wisata mahal di negara yang terletak di bagian selatan India itu.', '1126728576.png', '1330573080.jpg', '507494468.PNG', '1338051629.PNG', '2024-02-16 10:06:32', '2024-02-16 10:06:32'),
(7415022008, 'Wisata Alam', 'Bukit Lamando', 'Desa Rongi', 'Rp 0', '122.7455376', '-5.5340078', 'Bukit Lamando adalah destinasi berbasis alam yang sangat eksotis. Makanya yang datang ke tempat ini tidak hanya bertujuan untuk melepas penat saja tetapi juga berfoto selfie bersama seluruh keluarga.', '507123262.jpg', '2045100751.jpg', '1106342737.PNG', '1731991476.PNG', '2024-02-23 09:23:35', '2024-02-23 09:23:35'),
(7415022016, 'Wisata Alam', 'Permandian Kampidi', 'Desa Watiginanda', 'Rp 15.000', '122.6774554', '-5.6702426', 'Wisata kolam permandian air tawar Kampidi terletak di pinggir pantai Desa Watiginanda, Kecamatan Sampolawa. Untuk menuju ke lokasi, harus melewati jalan setapak yang berjarak kurang lebih 50 meter dari jalan raya. Airnya bersumber dari mata air yang keluar dari celah batu tebing. Mata air Kampidi memiliki air yang jernih serta letaknya yang berada di pinggir pantai menambah keindahan kolam yang memiliki kedalaman 2 meter ini. Untuk biaya masuk ke wisata permandian ini dikenakan biaya Rp 5000 per orang.', '422010149.jpg', '2034869557.jpg', '40588463.jpg', '814874153.jpg', '2024-02-16 11:45:03', '2024-02-16 11:45:03'),
(74150220022, 'Wisata Religi', 'Masjid Tua Wawoangi', 'Desa Wawoangi', 'Rp 0', '122.673422', '-5.6610133', 'Masjid Wawoangi namanya, didirikan oleh penyebar Islam pertama di Kerajaan Buton. Disinilah menjadi titik nol penyebaran Islam di Pulau Buton.Masjid ini dinamakan sesuai dengan nama desa setempat, Wawoangi. Lokasinya strategis berada di puncak bukit di antara Pegunungan Buton Selatan. Dari masjid, terlihat panorama perairan Laut Banda sejauh mata memandang. Arsitektur masjid juga sangat sederhana, tidak seperti masjid pada umumnya yang dilengkapi kubah. Di Masjid Wawoangi, tidak ada kubah. Bahkan, bangunannya pun unik, terbuat dari bambu-bambu lurus berukuran kecil yang disusun sedemikian rupa.', '618720341.jpg', '136527360.jpg', '1386102368.jpg', '2047613711.jpg', '2024-02-18 10:58:21', '2024-02-18 10:58:21');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  `is_admin` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `username`, `password`, `created_at`, `updated_at`, `is_admin`) VALUES
(9, 'admin', 'admin', '$2y$10$oIQOAdV4zkpJ33im1cEF5uWwBTM8lQKM.6LspNgeKoqGZ0Hx.c1qy', '2024-08-12 21:39:23', '2024-08-12 21:39:23', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `akunwisatawan`
--
ALTER TABLE `akunwisatawan`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `akunwisatawan_api_token_unique` (`api_token`);

--
-- Indexes for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `failed_jobs_uuid_unique` (`uuid`);

--
-- Indexes for table `kategoriwisata`
--
ALTER TABLE `kategoriwisata`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `password_reset_tokens`
--
ALTER TABLE `password_reset_tokens`
  ADD PRIMARY KEY (`email`);

--
-- Indexes for table `pengunjungwisatas`
--
ALTER TABLE `pengunjungwisatas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `personal_access_tokens_token_unique` (`token`),
  ADD KEY `personal_access_tokens_tokenable_type_tokenable_id_index` (`tokenable_type`,`tokenable_id`);

--
-- Indexes for table `tabeldaftarwisatas`
--
ALTER TABLE `tabeldaftarwisatas`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `akunwisatawan`
--
ALTER TABLE `akunwisatawan`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT for table `failed_jobs`
--
ALTER TABLE `failed_jobs`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `kategoriwisata`
--
ALTER TABLE `kategoriwisata`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT for table `pengunjungwisatas`
--
ALTER TABLE `pengunjungwisatas`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `personal_access_tokens`
--
ALTER TABLE `personal_access_tokens`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=544;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
