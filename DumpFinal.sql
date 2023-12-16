CREATE DATABASE  IF NOT EXISTS `trabalho` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `trabalho`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: trabalho
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alimento`
--

DROP TABLE IF EXISTS `alimento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alimento` (
  `idAlimento` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `carboidratos` double NOT NULL,
  `proteinas` double NOT NULL,
  `gorduras` double NOT NULL,
  `porcao` int NOT NULL,
  `calorias` double NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`idAlimento`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimento`
--

LOCK TABLES `alimento` WRITE;
/*!40000 ALTER TABLE `alimento` DISABLE KEYS */;
INSERT INTO `alimento` VALUES (1,'Arroz Integral Cozido',25.8,2.6,1,100,122.60000000000001,'2023-12-07','2023-12-07'),(2,'Feijao Carioca Cozido',13.6,4.8,0.5,100,78.1,'2023-12-07','2023-12-07'),(3,'Salada de Legumes - Cozida ao Vapor',7.1,2,0.3,100,39.1,'2023-12-07','2023-12-07'),(6,'Omelete de Queijo',0.4,15.6,22,100,262,'2023-12-11','2023-12-11'),(7,'File de Frango Grelhado',0,31.02,3.57,100,156.20999999999998,'2023-12-11','2023-12-11');
/*!40000 ALTER TABLE `alimento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alimentorefeicao`
--

DROP TABLE IF EXISTS `alimentorefeicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alimentorefeicao` (
  `idAlimentoRefeicao` int NOT NULL AUTO_INCREMENT,
  `idRefeicao` int NOT NULL,
  `idAlimento` int NOT NULL,
  `porcao` int NOT NULL,
  `proteinas` double NOT NULL,
  `gorduras` double NOT NULL,
  `carboidratos` double NOT NULL,
  `calorias` double NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`idAlimentoRefeicao`),
  KEY `idRefeicao_idx` (`idRefeicao`),
  KEY `idAlimento_idx` (`idAlimento`),
  CONSTRAINT `idAlimento` FOREIGN KEY (`idAlimento`) REFERENCES `alimento` (`idAlimento`) ON DELETE CASCADE,
  CONSTRAINT `idRefeicao` FOREIGN KEY (`idRefeicao`) REFERENCES `refeicoes` (`idrefeicoes`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alimentorefeicao`
--

LOCK TABLES `alimentorefeicao` WRITE;
/*!40000 ALTER TABLE `alimentorefeicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `alimentorefeicao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `avaliacaofisica`
--

DROP TABLE IF EXISTS `avaliacaofisica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `avaliacaofisica` (
  `idavaliacaofisica` int NOT NULL AUTO_INCREMENT,
  `idpessoa` int NOT NULL,
  `peso` double NOT NULL,
  `altura` double NOT NULL,
  `idade` int NOT NULL,
  `pescoco` double NOT NULL,
  `cintura` double NOT NULL,
  `quadril` double NOT NULL,
  `IMC` double NOT NULL,
  `TMB` double NOT NULL,
  `BF` double NOT NULL,
  `massaGorda` double NOT NULL,
  `massaMagra` double NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`idavaliacaofisica`),
  KEY `idpessoa_idx` (`idpessoa`),
  CONSTRAINT `idpessoa` FOREIGN KEY (`idpessoa`) REFERENCES `pessoa` (`idpessoa`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `avaliacaofisica`
--

LOCK TABLES `avaliacaofisica` WRITE;
/*!40000 ALTER TABLE `avaliacaofisica` DISABLE KEYS */;
INSERT INTO `avaliacaofisica` VALUES (4,4,90,190,23,38,100,90,24.930747922437675,3243.5299999999997,31.317428249407733,28.18568542446696,61.81431457553305,'2023-12-10','2023-12-10'),(5,2,65,165,20,32,100,80,23.875114784205696,2412,59.197861654442875,38.47861007538787,26.521389924612134,'2023-12-10','2023-12-10'),(8,11,138,171,28,38,130,120,47.19400841284498,3604.1499999999996,49.26411046201441,67.98447243757988,70.01552756242012,'2023-12-16','2023-12-16');
/*!40000 ALTER TABLE `avaliacaofisica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieta`
--

DROP TABLE IF EXISTS `dieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dieta` (
  `iddieta` int NOT NULL AUTO_INCREMENT,
  `idpessoaDieta` int NOT NULL,
  `idavaliacaofisicaDieta` int NOT NULL,
  `idtipoDieta` int NOT NULL,
  `objetivo` varchar(45) NOT NULL,
  `calorias` double NOT NULL,
  `nroRefeicoes` int NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`iddieta`),
  KEY `idpessoa_idx` (`idpessoaDieta`),
  KEY `idavaliacaofisica_idx` (`idavaliacaofisicaDieta`),
  KEY `idtipoDieta_idx` (`idtipoDieta`),
  CONSTRAINT `idavaliacaofisicaDieta` FOREIGN KEY (`idavaliacaofisicaDieta`) REFERENCES `avaliacaofisica` (`idavaliacaofisica`) ON DELETE CASCADE,
  CONSTRAINT `idpessoaDieta` FOREIGN KEY (`idpessoaDieta`) REFERENCES `pessoa` (`idpessoa`) ON DELETE CASCADE,
  CONSTRAINT `idtipoDieta` FOREIGN KEY (`idtipoDieta`) REFERENCES `tipodieta` (`idtipoDieta`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieta`
--

LOCK TABLES `dieta` WRITE;
/*!40000 ALTER TABLE `dieta` DISABLE KEYS */;
INSERT INTO `dieta` VALUES (8,11,8,7,'Diminuir o peso',3104.1499999999996,5,'2023-12-16','2023-12-16');
/*!40000 ALTER TABLE `dieta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mensagem`
--

DROP TABLE IF EXISTS `mensagem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mensagem` (
  `idmensagem` int NOT NULL AUTO_INCREMENT,
  `idpOrigem` int NOT NULL,
  `idpDestino` int NOT NULL,
  `mensagem` varchar(45) NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`idmensagem`),
  KEY `idpOrigem_idx` (`idpOrigem`),
  KEY `idpDestino_idx` (`idpDestino`),
  CONSTRAINT `idpDestino` FOREIGN KEY (`idpDestino`) REFERENCES `pessoa` (`idpessoa`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idpOrigem` FOREIGN KEY (`idpOrigem`) REFERENCES `pessoa` (`idpessoa`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mensagem`
--

LOCK TABLES `mensagem` WRITE;
/*!40000 ALTER TABLE `mensagem` DISABLE KEYS */;
INSERT INTO `mensagem` VALUES (5,4,2,'Pode mandar o trabalho mesmo assim','2023-12-09','2023-12-09'),(6,4,2,'Pode mandar o trabalho mesmo assim','2023-12-09','2023-12-09');
/*!40000 ALTER TABLE `mensagem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pessoa`
--

DROP TABLE IF EXISTS `pessoa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pessoa` (
  `idpessoa` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sexo` char(1) NOT NULL,
  `dataNascimento` date NOT NULL,
  `login` varchar(45) NOT NULL,
  `senha` varchar(45) NOT NULL,
  `tipoUsuario` varchar(45) NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`idpessoa`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pessoa`
--

LOCK TABLES `pessoa` WRITE;
/*!40000 ALTER TABLE `pessoa` DISABLE KEYS */;
INSERT INTO `pessoa` VALUES (2,'Maria','F','2003-11-09','maria','teste','Admin','2023-12-09','2023-12-09'),(4,'Eduardo','M','2000-01-01','dudu','teste','Comum','2023-12-09','2023-12-10'),(9,'Teste','F','2000-01-01','teste','teste','Comum','2023-12-11','2023-12-11'),(10,'Ana Cristina','F','1998-08-11','testando','teste','Comum','2023-12-11','2023-12-11'),(11,'Rapael','M','1995-08-30','Rapha','teste','Comum','2023-12-16','2023-12-16');
/*!40000 ALTER TABLE `pessoa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `idpost` int NOT NULL AUTO_INCREMENT,
  `idpessoaPost` int NOT NULL,
  `postagem` varchar(45) NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`idpost`),
  KEY `idpessoaPost_idx` (`idpessoaPost`),
  CONSTRAINT `idpessoaPost` FOREIGN KEY (`idpessoaPost`) REFERENCES `pessoa` (`idpessoa`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
INSERT INTO `post` VALUES (2,2,'Sextouuuuu!!!','2023-12-10','2023-12-10'),(3,4,'Notas de prova e participacao liberadas!','2023-12-10','2023-12-10');
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refeicoes`
--

DROP TABLE IF EXISTS `refeicoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refeicoes` (
  `idrefeicoes` int NOT NULL AUTO_INCREMENT,
  `idDieta` int NOT NULL,
  `carboidratos` double NOT NULL,
  `carbMAX` double NOT NULL,
  `proteinas` double NOT NULL,
  `proMAX` double NOT NULL,
  `gorduras` double NOT NULL,
  `gordMAX` double NOT NULL,
  `calorias` double NOT NULL,
  `caloriasMAX` double NOT NULL,
  `nomeRefeicao` varchar(45) NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`idrefeicoes`),
  KEY `idDieta_idx` (`idDieta`),
  CONSTRAINT `idDieta` FOREIGN KEY (`idDieta`) REFERENCES `dieta` (`iddieta`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refeicoes`
--

LOCK TABLES `refeicoes` WRITE;
/*!40000 ALTER TABLE `refeicoes` DISABLE KEYS */;
/*!40000 ALTER TABLE `refeicoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `seguir`
--

DROP TABLE IF EXISTS `seguir`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `seguir` (
  `idSeguir` int NOT NULL AUTO_INCREMENT,
  `idPessoaOrigem` int NOT NULL,
  `idPessoaDestino` int NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`idSeguir`),
  KEY `idPessoaOrigem_idx` (`idPessoaOrigem`),
  KEY `idPessoaDestino_idx` (`idPessoaDestino`),
  CONSTRAINT `idPessoaDestino` FOREIGN KEY (`idPessoaDestino`) REFERENCES `pessoa` (`idpessoa`) ON DELETE CASCADE,
  CONSTRAINT `idPessoaOrigem` FOREIGN KEY (`idPessoaOrigem`) REFERENCES `pessoa` (`idpessoa`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `seguir`
--

LOCK TABLES `seguir` WRITE;
/*!40000 ALTER TABLE `seguir` DISABLE KEYS */;
INSERT INTO `seguir` VALUES (6,2,4,'2023-12-10','2023-12-10'),(8,4,2,'2023-12-10','2023-12-10');
/*!40000 ALTER TABLE `seguir` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipodieta`
--

DROP TABLE IF EXISTS `tipodieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipodieta` (
  `idtipoDieta` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `carboidratos` double NOT NULL,
  `proteinas` double NOT NULL,
  `gorduras` double NOT NULL,
  `dataCriacao` date DEFAULT NULL,
  `dataModificacao` date DEFAULT NULL,
  PRIMARY KEY (`idtipoDieta`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipodieta`
--

LOCK TABLES `tipodieta` WRITE;
/*!40000 ALTER TABLE `tipodieta` DISABLE KEYS */;
INSERT INTO `tipodieta` VALUES (1,'Equilibrada',40,30,30,'2023-12-09','2023-12-09'),(3,'Equilibrada',40,30,30,'2023-12-10','2023-12-10'),(4,'Equilibrada',40,30,30,'2023-12-11','2023-12-11'),(5,'Equilibrada',40,30,30,'2023-12-11','2023-12-11'),(6,'Equilibrada',40,30,30,'2023-12-11','2023-12-11'),(7,'Equilibrada',40,30,30,'2023-12-16','2023-12-16'),(8,'Equilibrada',40,30,30,'2023-12-16','2023-12-16'),(9,'Equilibrada',40,30,30,'2023-12-16','2023-12-16');
/*!40000 ALTER TABLE `tipodieta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-16  9:40:08
