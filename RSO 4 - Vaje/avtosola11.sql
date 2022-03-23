-- MariaDB dump 10.19  Distrib 10.4.22-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: avtosola
-- ------------------------------------------------------
-- Server version	10.4.22-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `avtomobil`
--

DROP TABLE IF EXISTS `avtomobil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avtomobil` (
  `Registrska_stevilka` varchar(7) NOT NULL,
  `Znamka` varchar(20) NOT NULL,
  `Model` varchar(30) NOT NULL,
  `Vrsta_goriva` varchar(10) NOT NULL,
  `ID_avtosole` smallint(5) NOT NULL,
  PRIMARY KEY (`Registrska_stevilka`),
  KEY `ID_avtosole` (`ID_avtosole`),
  CONSTRAINT `avtomobil_ibfk_1` FOREIGN KEY (`ID_avtosole`) REFERENCES `avtosola` (`ID_avtosole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avtomobil`
--

LOCK TABLES `avtomobil` WRITE;
/*!40000 ALTER TABLE `avtomobil` DISABLE KEYS */;
INSERT INTO `avtomobil` VALUES ('KR29KKO','Toyota','Yaris','bencin 95',3),('KR33PKG','Alfa-Romeo','Giulia','Diesel',3),('KRAZ993','Toyota','Yaris','bencin 95',3),('KRBN332','Toyota','Yaris','bencin 95',3),('LJ12KPR','VW','Golf','Diesel',2),('LJ19NCS','VW','T-Roc','bencin 95',2),('LJ33ACC','VW','Tiguan','Diesel',2),('LJ34ADE','Ford','Fiesta','bencin 95',1),('LJ67BZN','BMW','325i','bencin 95',1),('LJA4BC3','Ford','Fiesta','bencin 95',1),('LJAD591','Ford','Focus ST-Line','Diesel',1),('LJMB583','VW','Golf','Diesel',2),('MB19AID','Seat','Ibiza','Diesel',4),('MB39KLM','Ford','Focus','bencin 95',4),('MBKR339','Seat','Ibiza','bencin 95',4),('MBKT381','Ford','S-Max','Diesel',4),('MBP4511','Toyota','Yaris','bencin 95',4);
/*!40000 ALTER TABLE `avtomobil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avtosola`
--

DROP TABLE IF EXISTS `avtosola`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `avtosola` (
  `ID_avtosole` smallint(5) NOT NULL,
  `Ime_avtosole` varchar(50) NOT NULL,
  `Naslov_sedeza` varchar(50) NOT NULL,
  `Kraj_sedeza` varchar(80) NOT NULL,
  PRIMARY KEY (`ID_avtosole`),
  UNIQUE KEY `Ime_avtosole` (`Ime_avtosole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avtosola`
--

LOCK TABLES `avtosola` WRITE;
/*!40000 ALTER TABLE `avtosola` DISABLE KEYS */;
INSERT INTO `avtosola` VALUES (1,'Modri Voznik','Smartinska cesta 120','Ljubljana'),(2,'STOP','Celovska cesta 211','Ljubljana'),(3,'Polzek','Presernova 14','Kranj'),(4,'Totek','Celeiska 38','Maribor');
/*!40000 ALTER TABLE `avtosola` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instruktor`
--

DROP TABLE IF EXISTS `instruktor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instruktor` (
  `Stevilka_zaposlenega` int(10) NOT NULL,
  `Ime` varchar(40) NOT NULL,
  `Priimek` varchar(40) NOT NULL,
  `Datum_rojstva` date NOT NULL,
  `ID_avtosole` smallint(5) NOT NULL,
  PRIMARY KEY (`Stevilka_zaposlenega`),
  KEY `ID_avtosole` (`ID_avtosole`),
  CONSTRAINT `instruktor_ibfk_1` FOREIGN KEY (`ID_avtosole`) REFERENCES `avtosola` (`ID_avtosole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instruktor`
--

LOCK TABLES `instruktor` WRITE;
/*!40000 ALTER TABLE `instruktor` DISABLE KEYS */;
INSERT INTO `instruktor` VALUES (1,'Drazen','Jurcic','1983-02-03',1),(2,'Gaj','Koler','1992-05-11',1),(69,'Sven','Kremlin','1974-09-14',3),(75,'Peter','Oglin','1968-11-13',2),(84,'Miha','Kromara','1977-12-12',1),(332,'Bojan','Frcopelnik','1966-04-21',2),(384,'Florijan','Smuk','1987-07-30',4),(756,'Zvone','Car','1958-01-28',4),(834,'Ana','Fanik','1988-01-28',2),(888,'Kris','Klop','1972-02-29',3),(906,'Manca','Pogrinjek','1993-02-19',3),(4201,'Ana','Skokin','1976-10-17',4);
/*!40000 ALTER TABLE `instruktor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `izpitna_voznja`
--

DROP TABLE IF EXISTS `izpitna_voznja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `izpitna_voznja` (
  `ID_izpitne_voznje` int(10) NOT NULL,
  `Stevilka_zaposlenega` int(10) NOT NULL,
  `Stevilka_evidencnega_kartona` smallint(5) NOT NULL,
  `Registrska_stevilka_avtomobila` varchar(7) NOT NULL,
  `Kilometrina` tinyint(3) NOT NULL,
  `Cas_voznje` time(6) NOT NULL,
  `Datum_voznje` date NOT NULL,
  `Ocenjevalec` varchar(80) NOT NULL,
  `Uspesnost_opravljanja_izpita` tinyint(1) DEFAULT 1,
  `Razlogi_za_padec` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID_izpitne_voznje`),
  KEY `Stevilka_zaposlenega` (`Stevilka_zaposlenega`),
  KEY `Stevilka_evidencnega_kartona` (`Stevilka_evidencnega_kartona`),
  KEY `Registrska_stevilka_avtomobila` (`Registrska_stevilka_avtomobila`),
  CONSTRAINT `izpitna_voznja_ibfk_1` FOREIGN KEY (`Stevilka_zaposlenega`) REFERENCES `instruktor` (`Stevilka_zaposlenega`),
  CONSTRAINT `izpitna_voznja_ibfk_2` FOREIGN KEY (`Stevilka_evidencnega_kartona`) REFERENCES `kandidat` (`Stevilka_evidencnega_kartona`),
  CONSTRAINT `izpitna_voznja_ibfk_3` FOREIGN KEY (`Registrska_stevilka_avtomobila`) REFERENCES `avtomobil` (`Registrska_stevilka`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `izpitna_voznja`
--

LOCK TABLES `izpitna_voznja` WRITE;
/*!40000 ALTER TABLE `izpitna_voznja` DISABLE KEYS */;
/*!40000 ALTER TABLE `izpitna_voznja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kandidat`
--

DROP TABLE IF EXISTS `kandidat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kandidat` (
  `Stevilka_evidencnega_kartona` smallint(5) NOT NULL,
  `Ime` varchar(40) NOT NULL,
  `Priimek` varchar(40) NOT NULL,
  `Datum_rojstva` date NOT NULL,
  `ID_tecaja` int(10) NOT NULL,
  `ID_avtosole` smallint(5) NOT NULL,
  PRIMARY KEY (`Stevilka_evidencnega_kartona`),
  KEY `ID_tecaja` (`ID_tecaja`),
  KEY `ID_avtosole` (`ID_avtosole`),
  CONSTRAINT `kandidat_ibfk_1` FOREIGN KEY (`ID_tecaja`) REFERENCES `tecaj` (`ID_tecaja`),
  CONSTRAINT `kandidat_ibfk_2` FOREIGN KEY (`ID_avtosole`) REFERENCES `avtosola` (`ID_avtosole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kandidat`
--

LOCK TABLES `kandidat` WRITE;
/*!40000 ALTER TABLE `kandidat` DISABLE KEYS */;
/*!40000 ALTER TABLE `kandidat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecaj`
--

DROP TABLE IF EXISTS `tecaj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tecaj` (
  `ID_tecaja` int(10) NOT NULL,
  `Tema_tecaja` varchar(30) NOT NULL,
  `Stevilka_zaposlenega` int(10) NOT NULL,
  `ID_avtosole` smallint(5) NOT NULL,
  PRIMARY KEY (`ID_tecaja`),
  KEY `Stevilka_zaposlenega` (`Stevilka_zaposlenega`),
  KEY `ID_avtosole` (`ID_avtosole`),
  CONSTRAINT `tecaj_ibfk_1` FOREIGN KEY (`Stevilka_zaposlenega`) REFERENCES `instruktor` (`Stevilka_zaposlenega`),
  CONSTRAINT `tecaj_ibfk_2` FOREIGN KEY (`ID_avtosole`) REFERENCES `avtosola` (`ID_avtosole`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecaj`
--

LOCK TABLES `tecaj` WRITE;
/*!40000 ALTER TABLE `tecaj` DISABLE KEYS */;
/*!40000 ALTER TABLE `tecaj` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `voznja`
--

DROP TABLE IF EXISTS `voznja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `voznja` (
  `ID_izpitne_voznje` int(10) NOT NULL,
  `Stevilka_zaposlenega` int(10) NOT NULL,
  `Stevilka_evidencnega_kartona` smallint(5) NOT NULL,
  `Registrska_stevilka_avtomobila` varchar(7) NOT NULL,
  `Kilometrina` tinyint(3) NOT NULL,
  `Cas_voznje` time(6) NOT NULL,
  `Datum_voznje` date NOT NULL,
  PRIMARY KEY (`ID_izpitne_voznje`),
  KEY `Stevilka_zaposlenega` (`Stevilka_zaposlenega`),
  KEY `Stevilka_evidencnega_kartona` (`Stevilka_evidencnega_kartona`),
  KEY `Registrska_stevilka_avtomobila` (`Registrska_stevilka_avtomobila`),
  CONSTRAINT `voznja_ibfk_1` FOREIGN KEY (`Stevilka_zaposlenega`) REFERENCES `instruktor` (`Stevilka_zaposlenega`),
  CONSTRAINT `voznja_ibfk_2` FOREIGN KEY (`Stevilka_evidencnega_kartona`) REFERENCES `kandidat` (`Stevilka_evidencnega_kartona`),
  CONSTRAINT `voznja_ibfk_3` FOREIGN KEY (`Registrska_stevilka_avtomobila`) REFERENCES `avtomobil` (`Registrska_stevilka`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `voznja`
--

LOCK TABLES `voznja` WRITE;
/*!40000 ALTER TABLE `voznja` DISABLE KEYS */;
/*!40000 ALTER TABLE `voznja` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-03-23 22:14:56
