-- MySQL dump 10.13  Distrib 5.6.14, for Win32 (x86)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	5.6.14

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `mydb`
--

-- drop database mydb;

-- CREATE DATABASE /*!32312 IF NOT EXISTS*/ `mydb` /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE database mydb;

USE mydb;

--
-- Table structure for table `adresse`
--

DROP TABLE IF EXISTS `adresse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adresse` (
  `AdresseId` bigint(20) NOT NULL AUTO_INCREMENT,
  `KundeId` bigint(20) NOT NULL,
  `AdressNr` int(11) NOT NULL,
  `Strasse` varchar(100) DEFAULT NULL,
  `Hausnummer` varchar(100) DEFAULT NULL,
  `Adresszusatz` varchar(500) DEFAULT NULL,
  `PLZ` varchar(10) DEFAULT NULL,
  `Ort` varchar(100) DEFAULT NULL,
  `Land` varchar(100) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`AdresseId`),
  UNIQUE KEY `uq_KundeId_AdressNr` (`KundeId`,`AdressNr`),
  KEY `fk_Adresse_Kunde1_idx` (`KundeId`),
  CONSTRAINT `fk_Adresse_Kunde1` FOREIGN KEY (`KundeId`) REFERENCES `kunde` (`KundeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adresse`
--

LOCK TABLES `adresse` WRITE;
/*!40000 ALTER TABLE `adresse` DISABLE KEYS */;
/*!40000 ALTER TABLE `adresse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `annahmestelle`
--

DROP TABLE IF EXISTS `annahmestelle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `annahmestelle` (
  `AnnahmestelleId` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(500) DEFAULT NULL,
   `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`AnnahmestelleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `annahmestelle`
--

LOCK TABLES `annahmestelle` WRITE;
/*!40000 ALTER TABLE `annahmestelle` DISABLE KEYS */;
/*!40000 ALTER TABLE `annahmestelle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `bankverbindung`
--

DROP TABLE IF EXISTS `bankverbindung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bankverbindung` (
  `BankverbindungId` bigint(20) NOT NULL AUTO_INCREMENT,
  `KundeId` bigint(20) NOT NULL,
  `VerbindungsNr` int(11) NOT NULL,
  `IBAN` varchar(30) DEFAULT NULL,
  `BIC` varchar(15) DEFAULT NULL,
  `Name` varchar(100) DEFAULT NULL,
  `Ort` varchar(100) DEFAULT NULL,
  `Land` varchar(100) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`BankverbindungId`),
  UNIQUE KEY `uq_KundeId_VerbindunsNr` (`KundeId`,`VerbindungsNr`),
  CONSTRAINT `Kunde_Bankverbindung` FOREIGN KEY (`KundeId`) REFERENCES `kunde` (`KundeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankverbindung`
--

LOCK TABLES `bankverbindung` WRITE;
/*!40000 ALTER TABLE `bankverbindung` DISABLE KEYS */;
/*!40000 ALTER TABLE `bankverbindung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gebuehr`
--

DROP TABLE IF EXISTS `gebuehr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gebuehr` (
  `GebuehrId` bigint(20) NOT NULL AUTO_INCREMENT,
  `Grundgebuehr` int(11) DEFAULT NULL,
  `GebuehrTipp` int(11) DEFAULT NULL,
  `GebuehrSpiel77` int(11) DEFAULT NULL,
  `GebuehrSuper6` int(11) DEFAULT NULL,
  `GueltigAb` datetime DEFAULT NULL,
  `Created` datetime DEFAULT NULL,
  `LastModified` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`GebuehrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gebuehr`
--

LOCK TABLES `gebuehr` WRITE;
/*!40000 ALTER TABLE `gebuehr` DISABLE KEYS */;
/*!40000 ALTER TABLE `gebuehr` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gewinnklasse`
--

DROP TABLE IF EXISTS `gewinnklasse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gewinnklasse` (
  `GewinnklasseId` bigint(20) NOT NULL AUTO_INCREMENT,
  `SpielID` int(11) NOT NULL,
  `GewinnklassenNr` int(11) NOT NULL,
  `BezeichnungLatein` varchar(5) NOT NULL,
  `Beschreibung` varchar(45) DEFAULT NULL,
  `IsAbsolut` tinyint(1) NOT NULL,
  `Betrag` bigint(20) DEFAULT NULL,
  `GueltigAb` datetime NOT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`GewinnklasseId`),
  KEY `Gewinnklassen_Spiele_idx` (`SpielID`),
  CONSTRAINT `Gewinnklassen_Spiele` FOREIGN KEY (`SpielID`) REFERENCES `spiel` (`SpielId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gewinnklasse`
--

LOCK TABLES `gewinnklasse` WRITE;
/*!40000 ALTER TABLE `gewinnklasse` DISABLE KEYS */;
/*!40000 ALTER TABLE `gewinnklasse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gewinnklasseziehungquote`
--

DROP TABLE IF EXISTS `gewinnklasseziehungquote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gewinnklasseziehungquote` (
  `GewinnklasseZiehungQuoteId` bigint(20) NOT NULL AUTO_INCREMENT,
  `AnzahlGewinner` int(11) NOT NULL,
  `GewinnklasseId` bigint(20) NOT NULL,
  `ZiehungId` bigint(20) NOT NULL,
  `Quote` bigint(20) NOT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`GewinnklasseZiehungQuoteId`),
  UNIQUE KEY `uq_GewinnklasseId_ZiehungId` (`GewinnklasseId`,`ZiehungId`),
  KEY `GewinnklassenZiehungQuoten_Ziehungen_idx` (`ZiehungId`),
  CONSTRAINT `GewinnklassenZiehungQuoten_Ziehungen` FOREIGN KEY (`ZiehungId`) REFERENCES `ziehung` (`ZiehungId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `GewinnklasseZiehungQuoten_Gewinnklassen` FOREIGN KEY (`GewinnklasseId`) REFERENCES `gewinnklasse` (`GewinnklasseId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gewinnklasseziehungquote`
--

LOCK TABLES `gewinnklasseziehungquote` WRITE;
/*!40000 ALTER TABLE `gewinnklasseziehungquote` DISABLE KEYS */;
/*!40000 ALTER TABLE `gewinnklasseziehungquote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `jackpot`
--

DROP TABLE IF EXISTS `jackpot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `jackpot` (
  `JackpotId` bigint(20) NOT NULL AUTO_INCREMENT,
  `SpielId` bigint(20) NOT NULL,
  `ZiehungId` bigint(20) NOT NULL,
  `AnzahlZiehungen` int(11) DEFAULT NULL,
  `Betrag` bigint(20) DEFAULT NULL,
  `GewinnklasseId` bigint(20) DEFAULT NULL,
  `BetragKumuliert` bigint(20) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`JackpotId`),
  UNIQUE KEY `uq_SpielId_ZiehungId` (`SpielId`,`ZiehungId`),
  KEY `Jackpot_Ziehungen_idx` (`ZiehungId`),
  KEY `Jackpot_Gewinnklassen_idx` (`GewinnklasseId`),
  CONSTRAINT `Jackpot_Gewinnklasse` FOREIGN KEY (`GewinnklasseId`) REFERENCES `gewinnklasse` (`GewinnklasseId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Jackpot_Ziehung` FOREIGN KEY (`ZiehungId`) REFERENCES `ziehung` (`ZiehungId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jackpot`
--

LOCK TABLES `jackpot` WRITE;
/*!40000 ALTER TABLE `jackpot` DISABLE KEYS */;
/*!40000 ALTER TABLE `jackpot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kunde`
--

DROP TABLE IF EXISTS `kunde`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kunde` (
  `KundeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Vorname` varchar(100) DEFAULT NULL,
  `Guthaben` int(11) DEFAULT NULL,
  `ALimit` int(11) DEFAULT NULL,
  `Gesperrt` tinyint(1) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` datetime NOT NULL,
  PRIMARY KEY (`KundeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kunde`
--

LOCK TABLES `kunde` WRITE;
/*!40000 ALTER TABLE `kunde` DISABLE KEYS */;
/*!40000 ALTER TABLE `kunde` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lottoschein`
--

DROP TABLE IF EXISTS `lottoschein`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lottoschein` (
  `LottoscheinId` bigint(20) NOT NULL AUTO_INCREMENT,
  `Belegnummer` bigint(20) DEFAULT NULL,
  `Spielscheinnummer` int(7) NOT NULL,
  `KundeID` bigint(20) NOT NULL,
  `Spiel77` tinyint(1) DEFAULT NULL,
  `Super6` tinyint(1) DEFAULT NULL,
  `Mittwoch` tinyint(1) DEFAULT NULL,
  `Samstag` tinyint(1) DEFAULT NULL,
  `Laufzeit` tinyint(4) DEFAULT NULL,
  `Abgeschlossen` tinyint(1) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` datetime NOT NULL,
  `abgabeDatum` datetime NOT NULL,
  `Kosten` int(11) DEFAULT NULL,
  `AnnahmestelleId` bigint(20) DEFAULT NULL,
  `AusbezahltDurch` bigint(20) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`LottoscheinId`),
  KEY `Kunde_Lottoschein_idx` (`KundeID`),
  KEY `Annahmestelle_Lottoschein_idx` (`AnnahmestelleId`),
  KEY `Ausbezahlt_Lottoschein_idx` (`AusbezahltDurch`),
  CONSTRAINT `Annahmestelle_Lottoschein` FOREIGN KEY (`AnnahmestelleId`) REFERENCES `annahmestelle` (`AnnahmestelleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Ausbezahlt_Lottoschein` FOREIGN KEY (`AusbezahltDurch`) REFERENCES `annahmestelle` (`AnnahmestelleId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `Kunde_Lottoschein` FOREIGN KEY (`KundeID`) REFERENCES `kunde` (`KundeId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lottoschein`
--

LOCK TABLES `lottoschein` WRITE;
/*!40000 ALTER TABLE `lottoschein` DISABLE KEYS */;
/*!40000 ALTER TABLE `lottoschein` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lottoscheintipp`
--

DROP TABLE IF EXISTS `lottoscheintipp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lottoscheintipp` (
  `LottoScheinTippId` bigint(20) NOT NULL AUTO_INCREMENT,
  `LottoscheinId` bigint(20) NOT NULL,
  `TippNr` tinyint(4) NOT NULL,
  `ZahlenAlsBits` bigint(20) NOT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`LottoScheinTippId`),
  UNIQUE KEY `uq_LottoscheinId_TippNr` (`LottoscheinId`,`TippNr`),
  CONSTRAINT `Lottoschein_LottoScheinFeld` FOREIGN KEY (`LottoscheinId`) REFERENCES `lottoschein` (`LottoscheinId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lottoscheintipp`
--

LOCK TABLES `lottoscheintipp` WRITE;
/*!40000 ALTER TABLE `lottoscheintipp` DISABLE KEYS */;
/*!40000 ALTER TABLE `lottoscheintipp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lottoscheinziehung`
--

DROP TABLE IF EXISTS `lottoscheinziehung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lottoscheinziehung` (
  `LottoscheinZiehungId` bigint(20) NOT NULL AUTO_INCREMENT,
  `LottoscheinId` bigint(20) NOT NULL,
  `ZiehungNr` tinyint(4) NOT NULL,
  `ZiehungsDatum` datetime DEFAULT NULL,
  `Abgeschlossen` tinyint(1) DEFAULT NULL,
  `LetzteZiehung` tinyint(1) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`LottoscheinZiehungId`),
  UNIQUE KEY `uq_LottoscheinId_ZiehungNr` (`LottoscheinId`,`ZiehungNr`),
  KEY `Lottoschein_LottoScheinZiehung_idx` (`LottoscheinId`),
  CONSTRAINT `Lottoschein_LottoScheinZiehung` FOREIGN KEY (`LottoscheinId`) REFERENCES `lottoschein` (`LottoscheinId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lottoscheinziehung`
--

LOCK TABLES `lottoscheinziehung` WRITE;
/*!40000 ALTER TABLE `lottoscheinziehung` DISABLE KEYS */;
/*!40000 ALTER TABLE `lottoscheinziehung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lottoscheinziehung6aus49`
--

DROP TABLE IF EXISTS `lottoscheinziehung6aus49`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lottoscheinziehung6aus49` (
  `LottoscheinZiehung6Aus49Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `LottoscheinId` bigint(20) NOT NULL,
  `ZiehungNr` tinyint(4) NOT NULL,
  `TippNr` tinyint(4) NOT NULL,
  `ZiehungId` bigint(20) NOT NULL,
  `GewinnklasseId` bigint(20) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`LottoscheinZiehung6Aus49Id`),
  UNIQUE KEY `uq_LottoscheinId_ZiehungNr_TippNr` (`LottoscheinId`,`ZiehungNr`,`TippNr`),
  KEY `LottoscheinZiehung6Aus49_LottoscheinZiehung_idx` (`LottoscheinId`,`ZiehungNr`),
  KEY `LottoscheinZiehung6Aus49_LottoScheinFeld_idx` (`LottoscheinId`,`TippNr`),
  KEY `LottoscheinZiehung6Aus49_Ziehungen_idx` (`ZiehungId`),
  KEY `LottoscheinZiehung6Aus49_GewinnklasseZiehungQuoten_idx` (`ZiehungId`,`GewinnklasseId`),
  CONSTRAINT `LottoscheinZiehung6Aus49_Lottoschein` FOREIGN KEY (`LottoscheinId`) REFERENCES `lottoschein` (`LottoscheinId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `LottoscheinZiehung6Aus49_Ziehung` FOREIGN KEY (`ZiehungId`) REFERENCES `ziehung` (`ZiehungId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lottoscheinziehung6aus49`
--

LOCK TABLES `lottoscheinziehung6aus49` WRITE;
/*!40000 ALTER TABLE `lottoscheinziehung6aus49` DISABLE KEYS */;
/*!40000 ALTER TABLE `lottoscheinziehung6aus49` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lottoscheinziehungspiel77super6`
--

DROP TABLE IF EXISTS `lottoscheinziehungspiel77super6`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lottoscheinziehungspiel77super6` (
  `LottoscheinZiehungSpiel77Super6Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `LottoscheinId` bigint(20) NOT NULL,
  `ZiehungNr` tinyint(4) NOT NULL,
  `ZiehungId` bigint(20) NOT NULL,
  `GewinnklasseSpiel77` tinyint(4) DEFAULT NULL,
  `GewinnklasseSuper6` tinyint(4) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`LottoscheinZiehungSpiel77Super6Id`),
  UNIQUE KEY `uq_LottoscheinId_ZiehungNr_TippNr` (`LottoscheinId`,`ZiehungNr`),
  KEY `LottoscheinZiehungResult_Ziehungen_idx` (`ZiehungId`),
  KEY `LottoscheinZiehungResult_GewinnklassenZiehungQuoten_idx` (`ZiehungId`,`GewinnklasseSpiel77`),
  KEY `LottoscheinZiehungResult_GewinnklassenZiehungQuoten_6_idx` (`ZiehungId`,`GewinnklasseSuper6`),
  CONSTRAINT `LottoscheinZiehungSpiel77Super6_Lottoschein` FOREIGN KEY (`LottoscheinId`) REFERENCES `lottoschein` (`LottoscheinId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `LottoscheinZiehungSpiel77Super6_Ziehung` FOREIGN KEY (`ZiehungId`) REFERENCES `ziehung` (`ZiehungId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lottoscheinziehungspiel77super6`
--

LOCK TABLES `lottoscheinziehungspiel77super6` WRITE;
/*!40000 ALTER TABLE `lottoscheinziehungspiel77super6` DISABLE KEYS */;
/*!40000 ALTER TABLE `lottoscheinziehungspiel77super6` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `spiel`
--

DROP TABLE IF EXISTS `spiel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `spiel` (
  `SpielId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(45) NOT NULL,
  `Beschreibung` varchar(500) DEFAULT NULL,
  `PfadAnleitung` varchar(100) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`SpielId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `spiel`
--

LOCK TABLES `spiel` WRITE;
/*!40000 ALTER TABLE `spiel` DISABLE KEYS */;
/*!40000 ALTER TABLE `spiel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ziehung`
--

DROP TABLE IF EXISTS `ziehung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ziehung` (
  `ZiehungId` bigint(20) NOT NULL AUTO_INCREMENT,
  `Ziehungsdatum` datetime NOT NULL,
  `ZahlenAlsBits` bigint(20) NOT NULL,
  `Superzahl` tinyint(4) NOT NULL,
  `Spiel77` int(7) NOT NULL,
  `Super6` int(6) NOT NULL,
  `EinsatzLotto` int(14) NOT NULL,
  `EinsatzSpiel77` int(14) NOT NULL,
  `EinsatzSuper6` int(14) NOT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `Created` datetime NOT NULL,
  `LastModified` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`ZiehungId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ziehung`
--

LOCK TABLES `ziehung` WRITE;
/*!40000 ALTER TABLE `ziehung` DISABLE KEYS */;
/*!40000 ALTER TABLE `ziehung` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-03-09 13:00:35
