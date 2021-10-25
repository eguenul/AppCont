-- MySQL dump 10.13  Distrib 8.0.25, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: AppCont
-- ------------------------------------------------------
-- Server version	8.0.27-0ubuntu0.20.04.1

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
-- Table structure for table `CentroCosto`
--

DROP TABLE IF EXISTS `CentroCosto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CentroCosto` (
  `CentroCostoId` int unsigned NOT NULL AUTO_INCREMENT,
  `EmpresaId` int unsigned NOT NULL DEFAULT '0',
  `CentroCostoCod` int unsigned NOT NULL DEFAULT '0',
  `CentroCostoNom` varchar(45) NOT NULL DEFAULT '',
  `CentroCostoEliminado` int DEFAULT '0',
  PRIMARY KEY (`CentroCostoId`)
) ENGINE=InnoDB AUTO_INCREMENT=144 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CentroCosto`
--

LOCK TABLES `CentroCosto` WRITE;
/*!40000 ALTER TABLE `CentroCosto` DISABLE KEYS */;
INSERT INTO `CentroCosto` VALUES (142,202,1,'CASA MATRIZ',0),(143,199,1,'CASA MATRIZ',0);
/*!40000 ALTER TABLE `CentroCosto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CliProv`
--

DROP TABLE IF EXISTS `CliProv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CliProv` (
  `CliProvId` int unsigned NOT NULL AUTO_INCREMENT,
  `CliProvCod` int NOT NULL DEFAULT '0',
  `CliProvRut` varchar(45) NOT NULL DEFAULT '',
  `CliProvRaz` varchar(45) NOT NULL DEFAULT '',
  `CliProvGir` varchar(45) NOT NULL DEFAULT '',
  `CliProvFon` varchar(45) NOT NULL DEFAULT '',
  `CliProvFax` varchar(45) NOT NULL DEFAULT '',
  `CliProvCiu` varchar(45) NOT NULL DEFAULT '',
  `EmpresaId` int NOT NULL DEFAULT '0',
  `CliProvRutRep` varchar(45) NOT NULL DEFAULT '',
  `CliProvNomRep` varchar(45) NOT NULL DEFAULT '',
  `CliProvEma` varchar(45) NOT NULL DEFAULT '',
  `CliProvDir` varchar(45) NOT NULL DEFAULT '',
  `CliProvDelete` int DEFAULT '0',
  `CliProvCom` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CliProvId`),
  KEY `FK_ClienteProveedor_1` (`EmpresaId`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CliProv`
--

LOCK TABLES `CliProv` WRITE;
/*!40000 ALTER TABLE `CliProv` DISABLE KEYS */;
INSERT INTO `CliProv` VALUES (25,1,'77813960','AMULEN CONSULTORES LTDA','ASESORIA TRIBUTARIA','652250340','','PUERTO MONTT',202,'74854974','JOSE OMAR GUENUL','eguenul@egga.cl','URMENETA 305 OFIC 513',0,'PUERTO MONTT'),(26,2,'76520400','ROSSME SPA','ESTACION DE SERVICIO','652250340','','PUERTO MONTT',202,'-','-','-','CAMINO TEPUAL KM3',0,'PUERTO MONTT'),(27,4,'7485497','JOSE OMAR GUENUL V','ASESORIA TRIBUTARIA','-','','PUERTO MONTT',202,'-','-','- ','URMENETA 305 OFIC 513',0,'PUERTO MONTT'),(28,1,'78885550-8','PERSONAL COMPUTER FACTORY S.A.','SERV INFORMATICOS','652250340','','PUERTO MONTT',199,'','','eguenul@yahoo.com','URMENETA 305',0,'PUERTO MONTT');
/*!40000 ALTER TABLE `CliProv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Correlativo`
--

DROP TABLE IF EXISTS `Correlativo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Correlativo` (
  `EmpresaId` int unsigned NOT NULL DEFAULT '1',
  `ClienteProveedorCod` int DEFAULT '1',
  `CentroCostoCod` int DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Correlativo`
--

LOCK TABLES `Correlativo` WRITE;
/*!40000 ALTER TABLE `Correlativo` DISABLE KEYS */;
INSERT INTO `Correlativo` VALUES (3,1,1),(193,1,1),(194,1,1),(195,1,1),(196,1,1),(197,1,1),(198,1,1),(199,2,2),(200,1,1),(201,1,1),(202,1,146);
/*!40000 ALTER TABLE `Correlativo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CorrelativoEmpresa`
--

DROP TABLE IF EXISTS `CorrelativoEmpresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CorrelativoEmpresa` (
  `EmpresaCod` int DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CorrelativoEmpresa`
--

LOCK TABLES `CorrelativoEmpresa` WRITE;
/*!40000 ALTER TABLE `CorrelativoEmpresa` DISABLE KEYS */;
INSERT INTO `CorrelativoEmpresa` VALUES (51);
/*!40000 ALTER TABLE `CorrelativoEmpresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CorrelativosVoucher`
--

DROP TABLE IF EXISTS `CorrelativosVoucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CorrelativosVoucher` (
  `EmpresaId` int DEFAULT NULL,
  `Id` int NOT NULL AUTO_INCREMENT,
  `NumVoucher` int DEFAULT '1',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CorrelativosVoucher`
--

LOCK TABLES `CorrelativosVoucher` WRITE;
/*!40000 ALTER TABLE `CorrelativosVoucher` DISABLE KEYS */;
INSERT INTO `CorrelativosVoucher` VALUES (199,1,86),(200,2,1),(202,3,6);
/*!40000 ALTER TABLE `CorrelativosVoucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cuentas`
--

DROP TABLE IF EXISTS `Cuentas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cuentas` (
  `CuentaId` int NOT NULL AUTO_INCREMENT,
  `EmpresaId` int DEFAULT NULL,
  `CuentaCod` int DEFAULT NULL,
  `CuentaDes` longtext CHARACTER SET dec8 COLLATE dec8_bin,
  `Nivel` int DEFAULT NULL,
  `Saldo` int DEFAULT NULL,
  PRIMARY KEY (`CuentaId`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cuentas`
--

LOCK TABLES `Cuentas` WRITE;
/*!40000 ALTER TABLE `Cuentas` DISABLE KEYS */;
INSERT INTO `Cuentas` VALUES (1,231,1,'ACTIVOS',NULL,NULL),(2,231,2,'PASIVOS',NULL,NULL),(3,231,3,'GANANCIA',NULL,NULL),(4,231,4,'PERDIDA',NULL,NULL),(5,231,1,'ACTIVOS',NULL,NULL),(6,231,2,'PASIVOS',NULL,NULL),(7,231,3,'GANANCIA',NULL,NULL),(8,231,4,'PERDIDA',NULL,NULL),(9,232,1,'ACTIVOS',NULL,NULL),(10,232,2,'PASIVOS',NULL,NULL),(11,232,3,'GANANCIA',NULL,NULL),(12,232,4,'PERDIDA',NULL,NULL),(13,231,1,'ACTIVOS',NULL,NULL),(14,231,2,'PASIVOS',NULL,NULL),(15,231,3,'GANANCIA',NULL,NULL),(16,231,4,'PERDIDA',NULL,NULL),(17,232,1,'ACTIVOS',NULL,NULL),(18,232,2,'PASIVOS',NULL,NULL),(19,232,3,'GANANCIA',NULL,NULL),(20,232,4,'PERDIDA',NULL,NULL),(21,233,1,'ACTIVOS',NULL,NULL),(22,233,2,'PASIVOS',NULL,NULL),(23,233,3,'GANANCIA',NULL,NULL),(24,233,4,'PERDIDA',NULL,NULL),(25,231,1,'ACTIVOS',NULL,NULL),(26,231,2,'PASIVOS',NULL,NULL),(27,231,3,'GANANCIA',NULL,NULL),(28,231,4,'PERDIDA',NULL,NULL),(29,232,1,'ACTIVOS',NULL,NULL),(30,232,2,'PASIVOS',NULL,NULL),(31,232,3,'GANANCIA',NULL,NULL),(32,232,4,'PERDIDA',NULL,NULL),(33,233,1,'ACTIVOS',NULL,NULL),(34,233,2,'PASIVOS',NULL,NULL),(35,233,3,'GANANCIA',NULL,NULL),(36,233,4,'PERDIDA',NULL,NULL),(37,234,1,'ACTIVOS',NULL,NULL),(38,234,2,'PASIVOS',NULL,NULL),(39,234,3,'GANANCIA',NULL,NULL),(40,234,4,'PERDIDA',NULL,NULL);
/*!40000 ALTER TABLE `Cuentas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CuentasCliProv`
--

DROP TABLE IF EXISTS `CuentasCliProv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CuentasCliProv` (
  `ClienteProveedorId` int DEFAULT NULL,
  `Id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CuentasCliProv`
--

LOCK TABLES `CuentasCliProv` WRITE;
/*!40000 ALTER TABLE `CuentasCliProv` DISABLE KEYS */;
/*!40000 ALTER TABLE `CuentasCliProv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DetallePago`
--

DROP TABLE IF EXISTS `DetallePago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DetallePago` (
  `Id` int DEFAULT NULL,
  `IdMovimiento` int DEFAULT NULL,
  `MontoAbonado` int DEFAULT NULL,
  `FechaPago` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetallePago`
--

LOCK TABLES `DetallePago` WRITE;
/*!40000 ALTER TABLE `DetallePago` DISABLE KEYS */;
/*!40000 ALTER TABLE `DetallePago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `DetalleVoucher`
--

DROP TABLE IF EXISTS `DetalleVoucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `DetalleVoucher` (
  `DetDebe` int DEFAULT NULL,
  `DetHaber` int DEFAULT NULL,
  `DetalleId` int NOT NULL AUTO_INCREMENT,
  `VoucherId` int DEFAULT NULL,
  `SaldoAnterior` int DEFAULT NULL,
  `SaldoActual` int DEFAULT NULL,
  PRIMARY KEY (`DetalleId`),
  KEY `fk_DetalleVoucher_2_idx` (`VoucherId`)
) ENGINE=InnoDB DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `DetalleVoucher`
--

LOCK TABLES `DetalleVoucher` WRITE;
/*!40000 ALTER TABLE `DetalleVoucher` DISABLE KEYS */;
/*!40000 ALTER TABLE `DetalleVoucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Documento`
--

DROP TABLE IF EXISTS `Documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Documento` (
  `DocumentoId` int NOT NULL AUTO_INCREMENT,
  `DocumentoDes` varchar(45) CHARACTER SET dec8 COLLATE dec8_bin DEFAULT NULL,
  `CodigoSii` int DEFAULT NULL,
  PRIMARY KEY (`DocumentoId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Documento`
--

LOCK TABLES `Documento` WRITE;
/*!40000 ALTER TABLE `Documento` DISABLE KEYS */;
INSERT INTO `Documento` VALUES (1,'FACTURA ELECTRONICA',NULL),(2,'FACTURA EXENTA ELECTRONICA',NULL);
/*!40000 ALTER TABLE `Documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Empresa`
--

DROP TABLE IF EXISTS `Empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Empresa` (
  `EmpresaId` int NOT NULL AUTO_INCREMENT,
  `EmpresaCod` int DEFAULT '0',
  `EmpresaRaz` varchar(45) DEFAULT '',
  `EmpresaRut` varchar(45) DEFAULT '',
  `EmpresaGir` varchar(45) DEFAULT '',
  `EmpresaDir` varchar(45) DEFAULT '',
  `EmpresaCom` varchar(45) DEFAULT '',
  `EmpresaCiu` varchar(45) DEFAULT '',
  `EmpresaFon` varchar(45) DEFAULT '',
  `EmpresaEma` varchar(45) DEFAULT '',
  `EmpresaRutRep` varchar(45) DEFAULT '',
  `EmpresaNomRep` varchar(45) DEFAULT '',
  `EmpresaEliminada` int DEFAULT '0',
  `EmpresaActEco` int DEFAULT '0',
  `EmpresaOficinaSii` varchar(45) DEFAULT NULL,
  `EmpresaFechaResolucion` varchar(45) DEFAULT NULL,
  `EmpresaResolucionNum` varchar(45) DEFAULT NULL,
  `SucursalSiiCod` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`EmpresaId`)
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Empresa`
--

LOCK TABLES `Empresa` WRITE;
/*!40000 ALTER TABLE `Empresa` DISABLE KEYS */;
INSERT INTO `Empresa` VALUES (199,47,'AMULEN CONSULTORES','77813960-K','CONSULTORIAS','WWW','WWW','WWW','WWW','WWW','222','222',0,0,'PUERTO MONTT','2021-01-06','0','0'),(200,48,'ESTEBAN GUENUL','1','SERV INFORMATICOS','-','-','-','-','-','0','0',0,0,NULL,NULL,NULL,NULL),(231,1,'EMPRESA DE PRUEBA','1-9','SERVICIOS INFORMATICOSQ','URMENETA 305 OFIC 513','PTO MONTT','PTO MONTT','652250340','eguenul@yahoo.com','','',0,0,NULL,NULL,NULL,NULL),(232,1,'sssss','ssss','ssss','sss','ssss','ssss','ssss','sssss','','',0,0,NULL,NULL,NULL,NULL),(233,1,'111','111','111','111','111','111','111','111','','',0,0,NULL,NULL,NULL,NULL),(234,1,'111','111','111','111','111','1111','1111','111','','',0,0,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `Empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FormaPago`
--

DROP TABLE IF EXISTS `FormaPago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `FormaPago` (
  `idFormaPago` int NOT NULL AUTO_INCREMENT,
  `FormaPagoDes` varchar(45) COLLATE dec8_bin DEFAULT NULL,
  PRIMARY KEY (`idFormaPago`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FormaPago`
--

LOCK TABLES `FormaPago` WRITE;
/*!40000 ALTER TABLE `FormaPago` DISABLE KEYS */;
INSERT INTO `FormaPago` VALUES (1,'CONTADO'),(2,'CREDITO 30 DIAS'),(3,'CREDITO 60 DIAS'),(4,'CREDITO 30 DIAS');
/*!40000 ALTER TABLE `FormaPago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Movimiento`
--

DROP TABLE IF EXISTS `Movimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Movimiento` (
  `MovimientoId` int NOT NULL AUTO_INCREMENT,
  `CliProvId` int DEFAULT NULL,
  `FechaDoc` date DEFAULT NULL,
  `NumDoc` int DEFAULT NULL,
  `TipoDocumentoId` int DEFAULT NULL,
  `MontoExento` int DEFAULT '0',
  `MontoNeto` int DEFAULT '0',
  `MontoIva` int DEFAULT NULL,
  `MontoTotal` int DEFAULT NULL,
  `TipoVoucherId` int DEFAULT NULL,
  `NumVoucher` int DEFAULT NULL,
  `EmpresaId` int DEFAULT NULL,
  `GlosaGeneral` text CHARACTER SET dec8 COLLATE dec8_bin,
  `IdPeriodo` int DEFAULT NULL,
  `idTipoMovimiento` int DEFAULT NULL,
  `FormaPagoId` int DEFAULT NULL,
  `MontoPagado` int DEFAULT NULL,
  `TipoCompraId` int DEFAULT NULL,
  `TipoVentaId` int DEFAULT NULL,
  `CentralizadoFlag` int DEFAULT '0',
  PRIMARY KEY (`MovimientoId`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Movimiento`
--

LOCK TABLES `Movimiento` WRITE;
/*!40000 ALTER TABLE `Movimiento` DISABLE KEYS */;
INSERT INTO `Movimiento` VALUES (1,NULL,NULL,NULL,NULL,0,0,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(2,28,'2021-10-06',0,3,1,1,1,1,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(3,28,'2021-10-06',0,3,1,1,1,1,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(4,28,'2021-10-06',0,1,1,1,1,1,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(5,28,'2021-10-06',0,3,1,1,1,1,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(6,28,'2021-10-06',0,3,1,1,1,1,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(7,28,'2021-10-06',0,3,2,2,2,2,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(8,28,'2021-10-06',573,3,1,1,1,1,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(9,28,'2021-10-06',1,1,1,1,1,1,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(10,28,'2021-10-06',8,1,464564,6656,6665656,656566565,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(11,28,'2021-10-06',573,3,1,1,1,1,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(12,28,'2021-10-20',1,3,1,1,1,1,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(13,28,'2021-10-20',9,1,9,9,9,9,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(14,28,'2021-10-20',111,1,111,111,111,111,NULL,NULL,199,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0),(15,28,'2021-10-20',2222,3,1111,1111,111,1111,NULL,NULL,199,NULL,NULL,0,NULL,NULL,NULL,NULL,0),(16,28,'2021-10-20',111,5,111,1111,111,1111,NULL,NULL,199,NULL,NULL,2,NULL,NULL,NULL,NULL,0),(17,28,'2021-10-20',1,3,1111,1111,11111,1111,NULL,NULL,199,NULL,NULL,2,NULL,NULL,NULL,NULL,0),(18,28,'2021-10-20',1,3,1,1,1,1,NULL,NULL,199,NULL,NULL,2,NULL,NULL,NULL,NULL,0),(19,28,'2021-10-22',1,1,1,1,1,1,NULL,NULL,199,NULL,NULL,2,NULL,NULL,NULL,NULL,0),(20,28,'2021-10-22',1,1,1,1,1,1,NULL,NULL,199,NULL,NULL,2,NULL,NULL,NULL,NULL,0),(21,28,'2021-10-22',1,3,1,1,1,1,NULL,NULL,199,NULL,NULL,2,NULL,NULL,NULL,NULL,0),(22,28,'2021-10-25',1,3,1,1,1,1,NULL,NULL,199,NULL,NULL,2,NULL,NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `Movimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Parametros`
--

DROP TABLE IF EXISTS `Parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Parametros` (
  `IvaCredFiscal` float DEFAULT NULL,
  `IvaDebFiscal` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Parametros`
--

LOCK TABLES `Parametros` WRITE;
/*!40000 ALTER TABLE `Parametros` DISABLE KEYS */;
/*!40000 ALTER TABLE `Parametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PlantillaEstadoResultado1`
--

DROP TABLE IF EXISTS `PlantillaEstadoResultado1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PlantillaEstadoResultado1` (
  `DescripcionItem` varchar(510) CHARACTER SET dec8 COLLATE dec8_bin DEFAULT NULL,
  `EmpresaId` int DEFAULT NULL,
  `ItemId` int NOT NULL AUTO_INCREMENT,
  `CodItem` int DEFAULT NULL,
  PRIMARY KEY (`ItemId`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PlantillaEstadoResultado1`
--

LOCK TABLES `PlantillaEstadoResultado1` WRITE;
/*!40000 ALTER TABLE `PlantillaEstadoResultado1` DISABLE KEYS */;
INSERT INTO `PlantillaEstadoResultado1` VALUES ('INGRESOS',198,1,1),('COSTOS DE EXPLOTACION',198,2,2),('GASTOS DE ADMINISTRACION Y VENTAS',198,3,3),('INGRESOS Y EGRESOS NO OPERACIONALES',198,4,4),('IMPUESTO A LA RENTA',198,5,5),('INGRESOS',199,6,1),('COSTOS DE EXPLOTACION',199,7,2),('GASTOS DE ADMINISTRACION Y VENTAS',199,8,3),('INGRESOS Y EGRESOS NO OPERACIONALES',199,9,4),('IMPUESTO A LA RENTA',199,10,5),('INGRESOS',200,11,1),('COSTOS DE EXPLOTACION',200,12,2),('GASTOS DE ADMINISTRACION Y VENTAS',200,13,3),('INGRESOS Y EGRESOS NO OPERACIONALES',200,14,4),('IMPUESTO A LA RENTA',200,15,5),('INGRESOS',201,16,1),('COSTOS DE EXPLOTACION',201,17,2),('GASTOS DE ADMINISTRACION Y VENTAS',201,18,3),('INGRESOS Y EGRESOS NO OPERACIONALES',201,19,4),('IMPUESTO A LA RENTA',201,20,5),('INGRESOS',202,21,1),('COSTOS DE EXPLOTACION',202,22,2),('GASTOS DE ADMINISTRACION Y VENTAS',202,23,3),('INGRESOS Y EGRESOS NO OPERACIONALES',202,24,4),('IMPUESTO A LA RENTA',202,25,5);
/*!40000 ALTER TABLE `PlantillaEstadoResultado1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PlantillaEstadoResultado2`
--

DROP TABLE IF EXISTS `PlantillaEstadoResultado2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PlantillaEstadoResultado2` (
  `Item2Id` int NOT NULL AUTO_INCREMENT,
  `ItemId` int DEFAULT NULL,
  `Descripcion` varchar(510) CHARACTER SET dec8 COLLATE dec8_bin DEFAULT NULL,
  PRIMARY KEY (`Item2Id`),
  KEY `fk_PlantillaEstadoResultado2_1_idx` (`ItemId`),
  CONSTRAINT `fk_PlantillaEstadoResultado2_1` FOREIGN KEY (`ItemId`) REFERENCES `PlantillaEstadoResultado1` (`ItemId`)
) ENGINE=InnoDB DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PlantillaEstadoResultado2`
--

LOCK TABLES `PlantillaEstadoResultado2` WRITE;
/*!40000 ALTER TABLE `PlantillaEstadoResultado2` DISABLE KEYS */;
/*!40000 ALTER TABLE `PlantillaEstadoResultado2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PlantillaEstadoResultado3`
--

DROP TABLE IF EXISTS `PlantillaEstadoResultado3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PlantillaEstadoResultado3` (
  `Item2Id` int DEFAULT NULL,
  `Item3Id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`Item3Id`)
) ENGINE=InnoDB DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PlantillaEstadoResultado3`
--

LOCK TABLES `PlantillaEstadoResultado3` WRITE;
/*!40000 ALTER TABLE `PlantillaEstadoResultado3` DISABLE KEYS */;
/*!40000 ALTER TABLE `PlantillaEstadoResultado3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoDocumentos`
--

DROP TABLE IF EXISTS `TipoDocumentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TipoDocumentos` (
  `TipoDocumentoId` int unsigned NOT NULL AUTO_INCREMENT,
  `TipoDocumentoDes` varchar(45) NOT NULL DEFAULT '',
  `TipoOperacion` int unsigned NOT NULL DEFAULT '0',
  `FlagIva` int unsigned NOT NULL DEFAULT '0',
  `Dte` int unsigned NOT NULL DEFAULT '0',
  `CodigoSii` int unsigned NOT NULL DEFAULT '0',
  `TipoMovimiento` int unsigned NOT NULL DEFAULT '0',
  `OpExento` int unsigned NOT NULL DEFAULT '0',
  `CompraVenta` int unsigned NOT NULL DEFAULT '0',
  `AumentaDisminuye` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TipoDocumentoId`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoDocumentos`
--

LOCK TABLES `TipoDocumentos` WRITE;
/*!40000 ALTER TABLE `TipoDocumentos` DISABLE KEYS */;
INSERT INTO `TipoDocumentos` VALUES (1,'FACTURA DE COMPRA ELECTRONICA',0,1,1,46,0,0,0,'1'),(2,'GUIA DESPACHO ELECTRONICA',0,0,1,52,0,0,0,'1'),(3,'FACTURA ELECTRONICA',0,1,1,33,0,0,0,'1'),(4,'NOTA DE CREDITO ELECTRONICA',0,1,1,61,0,0,0,'-1'),(5,'FACTURA EXENTA ELECTRONICA',0,0,1,34,0,1,0,'1'),(6,'NOTA DEBITO ELECTRONICA',0,1,1,56,0,0,0,'1'),(7,'FACTURA DE COMPRA',0,1,1,45,0,0,0,'1'),(8,'FACTURA',0,1,1,30,0,0,0,'1'),(9,'NOTA DE CREDITO',0,1,1,60,0,0,0,'-1'),(10,'BOLETA ELECTRONICA',0,1,0,39,0,0,0,NULL);
/*!40000 ALTER TABLE `TipoDocumentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoMovimiento`
--

DROP TABLE IF EXISTS `TipoMovimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TipoMovimiento` (
  `idTipoMovimiento` int NOT NULL AUTO_INCREMENT,
  `MovimientoDes` varchar(45) COLLATE dec8_bin DEFAULT NULL,
  PRIMARY KEY (`idTipoMovimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoMovimiento`
--

LOCK TABLES `TipoMovimiento` WRITE;
/*!40000 ALTER TABLE `TipoMovimiento` DISABLE KEYS */;
INSERT INTO `TipoMovimiento` VALUES (1,'COMPRA'),(2,'VENTA');
/*!40000 ALTER TABLE `TipoMovimiento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `TipoVoucher`
--

DROP TABLE IF EXISTS `TipoVoucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `TipoVoucher` (
  `TipoVoucherId` int NOT NULL AUTO_INCREMENT,
  `Descripcion` varchar(510) CHARACTER SET dec8 COLLATE dec8_bin DEFAULT NULL,
  PRIMARY KEY (`TipoVoucherId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `TipoVoucher`
--

LOCK TABLES `TipoVoucher` WRITE;
/*!40000 ALTER TABLE `TipoVoucher` DISABLE KEYS */;
INSERT INTO `TipoVoucher` VALUES (4,'INGRESO'),(5,'EGRESO'),(6,'TRASPASO');
/*!40000 ALTER TABLE `TipoVoucher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Usuario`
--

DROP TABLE IF EXISTS `Usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Usuario` (
  `idUsuarios` int NOT NULL AUTO_INCREMENT,
  `UsuarioLogin` varchar(45) CHARACTER SET dec8 COLLATE dec8_bin DEFAULT NULL,
  `UsuarioPass` varchar(45) CHARACTER SET dec8 COLLATE dec8_bin DEFAULT NULL,
  PRIMARY KEY (`idUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Usuario`
--

LOCK TABLES `Usuario` WRITE;
/*!40000 ALTER TABLE `Usuario` DISABLE KEYS */;
INSERT INTO `Usuario` VALUES (2,'eguenul','esther65'),(3,'admin','super');
/*!40000 ALTER TABLE `Usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Voucher`
--

DROP TABLE IF EXISTS `Voucher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Voucher` (
  `VoucherId` int NOT NULL AUTO_INCREMENT,
  `NumVoucher` int DEFAULT NULL,
  `FechaVoucher` date DEFAULT NULL,
  `TipoVoucher` varchar(45) CHARACTER SET dec8 COLLATE dec8_bin DEFAULT NULL,
  `EmpresaId` int DEFAULT NULL,
  PRIMARY KEY (`VoucherId`),
  KEY `fk_Voucher_1_idx` (`EmpresaId`),
  CONSTRAINT `fk_Voucher_1` FOREIGN KEY (`EmpresaId`) REFERENCES `Empresa` (`EmpresaId`)
) ENGINE=InnoDB DEFAULT CHARSET=dec8 COLLATE=dec8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Voucher`
--

LOCK TABLES `Voucher` WRITE;
/*!40000 ALTER TABLE `Voucher` DISABLE KEYS */;
/*!40000 ALTER TABLE `Voucher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-10-25 14:39:57
