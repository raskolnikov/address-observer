-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 03, 2015 at 03:25 AM
-- Server version: 5.6.19-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `address_observer`
--

-- --------------------------------------------------------

--
-- Table structure for table `address_list`
--

CREATE TABLE IF NOT EXISTS `address_list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `update_user` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `company_name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `company_address` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address_dedector_bean` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'DefaultDetector',
  `address_notification_email` varchar(50) CHARACTER SET utf8 NOT NULL,
  `create_user` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'observer_cron',
  `company_contact_url` varchar(200) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `address_list`
--

INSERT INTO `address_list` (`id`, `create_date`, `update_date`, `update_user`, `company_name`, `company_address`, `address_dedector_bean`, `address_notification_email`, `create_user`, `company_contact_url`) VALUES
(2, '0002-11-30 00:00:01', '2015-06-03 03:19:00', 'observer_cron', 'Deniz', '                    Inhaber Heidi Pulkkinen & Alexander Heim Eingetragen als Theaterkostümnäherei Handwerkskammer Berlin - Gewerbekarte: 82389 Steuernummer Finanzamt Berlin Friedrichshain USt-IdNr.: DE254165281 Steuernummer: 14/480/51018 Kontakt über eMail: c-o-n-t-a-c-t ( a t ) savage-wear.com Telefon: +49 30 / 54771505 Anschrift Savage-Wear Pulkkinen & Heim GbR Gubener Straße 29 10243 Berlin Laden Savage-Store Grünberger Straße 16 10243 berlin Bankverbindung Konto-Inhaber: Savage-Wear Pulkkinen & Heim GbR Kontonummer: 506930103 Bankleitzahl: 10010010 Bank: Postbank Berlin IBAN: DE17100100100506930103 BIC: PBNKDEFF WebDesign Alexander Heim GKL-Informationsmanagement GmbH & Co.KG www.gkl.de Photos Martin Pelzer www.abwaerts.de Tina Cassati www.tinacassati.de Alexander Horn www.l-a-tex.comhttp://www.latexnews.com/ Lust Love Latex www.lustlovelatex.com Oliver Indra www.c-o-de.net Herr Buchta www.herrbuchta.de Norman Richter www.normanrichter.com Victoria Perelet www.victoriasphoto.com Sebastian Solo www.sebastiansolo.com Thomas Fröhlich Jens Becker www.fall-apart.de Sean McCall www.seanmccall.com LowTek Jody Cortes www.cortesphoto.com Allen Falkner www.obscurephoto.com Adrian Ashley-Judd www.adrianjudd.com Christine Kessler www.myfetishdiary.com Andre Pigur www.pigur.de 06.05.15 German Fetish Ball Weekend Sonderöffnung, Rabatte, Party [mehr] 22.12.14 Öffnungszeiten über die Feiertage Unsere Öffnungszeiten zu Weihnachten und Silvester [mehr] 05.12.14 Savage-Wear auf Zauberfair und Zauberfetisch in Bremen Savage-Store am Freitag 5.12. und Samstag 6.12. geschlossen [mehr]         Google+         ', 'DefaultDetector', 'mehmet2aktas@gmail.com', 'observer_cron', 'http://www.savage-wear.com/impressum/index.html');

-- --------------------------------------------------------

--
-- Table structure for table `address_list_history`
--

CREATE TABLE IF NOT EXISTS `address_list_history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `create_date` datetime NOT NULL,
  `company_name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `company_address` text CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `address_dedector_bean` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'DefaultDetector',
  `address_notification_email` varchar(50) CHARACTER SET utf8 NOT NULL,
  `create_user` varchar(50) CHARACTER SET utf8 NOT NULL DEFAULT 'observer_cron',
  `company_contact_url` varchar(200) CHARACTER SET utf8 NOT NULL,
  `address_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id` (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dumping data for table `address_list_history`
--

INSERT INTO `address_list_history` (`id`, `create_date`, `company_name`, `company_address`, `address_dedector_bean`, `address_notification_email`, `create_user`, `company_contact_url`, `address_id`) VALUES
(1, '2015-06-03 01:51:26', 'Deniz', '                    /480/51018 Kontakt über eMail: c-o-n-t-a-c-t ( a t ) savage-wear.com Telefon: +49 30 / 54771505 Anschrift Savage-Wear Pulkkinen & Heim GbR Gubener Straße 29 10243 Berlin Laden Savage-Store Grünberger Straße 16 10243 berlin Bankverbindung Konto-Inhaber: Savage-Wear Pulkkinen & Heim GbR Kontonummer: 506930103 Bankleitzahl: 10010010 Bank: Postbank Berlin IBAN: DE17100100100506930103 BIC: PBNKDEFF WebDesign Alexander Heim GKL-Informationsmanagement GmbH & Co.KG www.gkl.de Photos Martin Pelzer www.abwaerts.de Tina Cassati www.tinacassati.de Alexander Horn www.l-a-tex.comhttp://www.latexnews.com/ Lust Love Latex www.lustlovelatex.com Oliver Indra www.c-o-de.net Herr Buchta www.herrbuchta.de Norman Richter www.normanrichter.com Victoria Perelet www.victoriasphoto.com Sebastian Solo www.sebastiansolo.com Thomas Fröhlich Jens Becker www.fall-apart.de Sean McCall www.seanmccall.com LowTek Jody Cortes www.cortesphoto.com Allen Falkner www.obscurephoto.com Adrian Ashley-Judd www.adrianjudd.com Christine Kessler www.myfetishdiary.com Andre Pigur www.pigur.de 06.05.15 German Fetish Ball Weekend Sonderöffnung, Rabatte, Party [mehr] 22.12.14 Öffnungszeiten über die Feiertage Unsere Öffnungszeiten zu Weihnachten und Silvester [mehr] 05.12.14 Savage-Wear auf Zauberfair und Zauberfetisch in Bremen Savage-Store am Freitag 5.12. und Samstag 6.12. geschlossen [mehr]         Google+         ', 'DefaultDetector', 'mehmet2aktas@gmail.com', 'observer_cron', 'http://www.savage-wear.com/impressum/index.html', 2),
(2, '2015-06-03 03:18:26', 'Deniz', '\nüber eMail: c-o-n-t-a-c-t ( a t ) savage-wear.com Telefon: +49 30 / 54771505 Anschrift Savage-Wear Pulkkinen & Heim GbR Gubener Straße 29 10243 Berlin Laden Savage-Store Grünberger Straße 16 10243 berlin Bankverbindung Konto-Inhaber: Savage-Wear Pulkkinen & Heim GbR Kontonummer: 506930103 Bankleitzahl: 10010010 Bank: Postbank Berlin IBAN: DE17100100100506930103 BIC: PBNKDEFF WebDesign Alexander Heim GKL-Informationsmanagement GmbH & Co.KG www.gkl.de Photos Martin Pelzer www.abwaerts.de Tina Cassati www.tinacassati.de Alexander Horn www.l-a-tex.comhttp://www.latexnews.com/ Lust Love Latex www.lustlovelatex.com Oliver Indra www.c-o-de.net Herr Buchta www.herrbuchta.de Norman Richter www.normanrichter.com Victoria Perelet www.victoriasphoto.com Sebastian Solo www.sebastiansolo.com Thomas Fröhlich Jens Becker www.fall-apart.de Sean McCall www.seanmccall.com LowTek Jody Cortes www.cortesphoto.com Allen Falkner www.obscurephoto.com Adrian Ashley-Judd www.adrianjudd.com Christine Kessler www.myfetishdiary.com Andre Pigur www.pigur.de 06.05.15 German Fetish Ball Weekend Sonderöffnung, Rabatte, Party [mehr] 22.12.14 Öffnungszeiten über die Feiertage Unsere Öffnungszeiten zu Weihnachten und Silvester [mehr] 05.12.14 Savage-Wear auf Zauberfair und Zauberfetisch in Bremen Savage-Store am Freitag 5.12. und Samstag 6.12. geschlossen [mehr]         Google+         ', 'DefaultDetector', 'mehmet2aktas@gmail.com', 'observer_cron', 'http://www.savage-wear.com/impressum/index.html', 2),
(3, '2015-06-03 03:19:00', 'Deniz', '\nhshain USt-IdNr.: DE254165281 Steuernummer: 14/480/51018 Kontakt über eMail: c-o-n-t-a-c-t ( a t ) savage-wear.com Telefon: +49 30 / 54771505 Anschrift Savage-Wear Pulkkinen & Heim GbR Gubener Straße 29 10243 Berlin Laden Savage-Store Grünberger Straße 16 10243 berlin Bankverbindung Konto-Inhaber: Savage-Wear Pulkkinen & Heim GbR Kontonummer: 506930103 Bankleitzahl: 10010010 Bank: Postbank Berlin IBAN: DE17100100100506930103 BIC: PBNKDEFF WebDesign Alexander Heim GKL-Informationsmanagement GmbH & Co.KG www.gkl.de Photos Martin Pelzer www.abwaerts.de Tina Cassati www.tinacassati.de Alexander Horn www.l-a-tex.comhttp://www.latexnews.com/ Lust Love Latex www.lustlovelatex.com Oliver Indra www.c-o-de.net Herr Buchta www.herrbuchta.de Norman Richter www.normanrichter.com Victoria Perelet www.victoriasphoto.com Sebastian Solo www.sebastiansolo.com Thomas Fröhlich Jens Becker www.fall-apart.de Sean McCall www.seanmccall.com LowTek Jody Cortes www.cortesphoto.com Allen Falkner www.obscurephoto.com Adrian Ashley-Judd www.adrianjudd.com Christine Kessler www.myfetishdiary.com Andre Pigur www.pigur.de 06.05.15 German Fetish Ball Weekend Sonderöffnung, Rabatte, Party [mehr] 22.12.14 Öffnungszeiten über die Feiertage Unsere Öffnungszeiten zu Weihnachten und Silvester [mehr] 05.12.14 Savage-Wear auf Zauberfair und Zauberfetisch in Bremen Savage-Store am Freitag 5.12. und Samstag 6.12. geschlossen [mehr]         Google+         ', 'DefaultDetector', 'mehmet2aktas@gmail.com', 'observer_cron', 'http://www.savage-wear.com/impressum/index.html', 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
