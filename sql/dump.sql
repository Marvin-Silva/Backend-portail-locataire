CREATE DATABASE  IF NOT EXISTS `rentals` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rentals`;
-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: rentals
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `messages`
--

DROP TABLE IF EXISTS `messages`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `messages` (
  `id` int NOT NULL AUTO_INCREMENT,
  `rental_id` int DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  `message` varchar(2000) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `messages`
--

LOCK TABLES `messages` WRITE;
/*!40000 ALTER TABLE `messages` DISABLE KEYS */;
/*!40000 ALTER TABLE `messages` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rentals`
--

DROP TABLE IF EXISTS `rentals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rentals` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `surface` decimal(10,0) DEFAULT NULL,
  `price` decimal(10,0) DEFAULT NULL,
  `picture` varchar(255) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `owner_id` int NOT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rentals`
--

LOCK TABLES `rentals` WRITE;
/*!40000 ALTER TABLE `rentals` DISABLE KEYS */;
INSERT INTO `rentals` VALUES (1,'test house 1',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend,\n varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a,\n eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis\n ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt.\n Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in.\n Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros,\n et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat',1,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(2,'test house 2',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend,\n varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a,\n eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis\n ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt.\n Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in.\n Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros,\n et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat',2,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(3,'test house 3',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend,\n varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a,\n eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis\n ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt.\n Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in.\n Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros,\n et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat',3,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(4,'test house 4',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','Lorem ipsu dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend,\n varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a,\n eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis\n ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt.\n Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in.\n Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros,\n et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat',4,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(13,'test house 6',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg',NULL,6,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(15,'test house 15',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg',NULL,15,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(17,'test house 18',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','orem ipsu dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend,\n varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a,\n eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis\n ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt.\n Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in.\n Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros,\n et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat',18,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(18,'test house 19',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend,\n varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a,\n eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis\n ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt.\n Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in.\n Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros,\n et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat',19,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(19,'test house 19',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend,\n varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a,\n eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis\n ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt.\n Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in.\n Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros,\n et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat',19,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(20,'test house 20',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend,\n varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a,\n eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis\n ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt.\n Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in.\n Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros,\n et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat',20,'2023-05-13 10:34:56','2023-05-13 10:34:56'),(21,'name',50,200,NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend, varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a, eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt. Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in. Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros, et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat.',0,NULL,NULL),(22,'name',50,200,NULL,'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend, varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a, eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt. Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in. Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros, et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat.',0,NULL,NULL),(23,'name',50,200,'org.springframework.web.multipart.support.StandardMultipartHttpServletRequest$StandardMultipartFile@402d9a36','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend, varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a, eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt. Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in. Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros, et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat.',0,NULL,NULL),(24,'Test from front',50,200,'Online-House-Rental-Sites.jpg','This is a test from front',0,NULL,NULL),(25,'name',50,200,'','Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend, varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a, eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt. Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in. Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros, et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat.',0,NULL,NULL),(26,'testing',60,260,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','NEW test from front',0,NULL,NULL),(27,'Gueda taro',200,20000,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','Maison de Frida Kalo',0,NULL,NULL),(28,'test house 28',432,300,'https://blog.technavio.org/wp-content/uploads/2018/12/Online-House-Rental-Sites.jpg','orem ipsu dolor sit amet, consectetur adipiscing elit. Etiam a lectus eleifend,\n varius massa ac, mollis tortor. Quisque ipsum nulla, faucibus ac metus a,\n eleifend efficitur augue. Integer vel pulvinar ipsum. Praesent mollis neque sed sagittis\n ultricies. Suspendisse congue ligula at justo molestie, eget cursus nulla tincidunt.\n Pellentesque elementum rhoncus arcu, viverra gravida turpis mattis in.\n Maecenas tempor elementum lorem vel ultricies. Nam tempus laoreet eros,\n et viverra libero tincidunt a. Nunc vel nisi vulputate, sodales massa eu, varius erat',28,'2023-05-13 10:34:56','2023-05-13 10:34:56');
/*!40000 ALTER TABLE `rentals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `USERS_index` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'test@test.com','jean','test!31','2023-04-14 13:09:21','2023-04-14 13:09:21'),(2,'test@silva.com','marie','test!31',NULL,NULL),(10,NULL,'jean','test!31','2023-05-04 21:25:09',NULL),(11,'jean@test.com','jacques','$2a$10$MD1Ua7NTRZtOxDx4qJBSPebS.zlvBWL01hrU5x9B0myou3kq8pc2y','2023-05-05 09:02:00',NULL),(13,'jean@tes.com','jacques','$2a$10$2pov7fSXBm/VVkPyYxWPFuCQNRuroGTcHB/0NGAolF5QPNBGKbEg2','2023-05-05 09:30:05',NULL),(15,'je@tes.com','jacques','$2a$10$Sb/gL2pwCFp4W.8QTeXnre7x3Ir8Kk7OUKrJBJt0D35IBb7xQPnom','2023-05-12 07:22:33',NULL),(17,'j@tes.com','jac','$2a$10$MUzctx88nUp5nYF6AKzKEOhm7c2vq3zvDuzTBnATsuB9YXrGQL8N.','2023-05-12 12:17:03',NULL),(18,'marvin@test.com','marvin','$2a$10$5iPaDf5gnRbu1jIM1qsIJuk6Cx14L73yJAKQtk3zswgsxTlV5KxtG','2023-05-12 12:33:07',NULL),(20,'martin@test.com','martin','$2a$10$e4D7YFkoBsiffRyoi9k2IOMhy/MJy6NQrpobICxxW.qu1SSWpt5j.','2023-05-12 13:18:02',NULL),(23,'margin@test.com','margin','$2a$10$.MWcXAOqcRtxHy1jAebw1ev1xc/VZwfh78PBBOgsTmfICb.9Y0ILO','2023-05-12 15:25:50',NULL),(26,'margin@tes.com','mar','$2a$10$4woHLfsIuyMIlZz.w8d83ulTXqmIbYrxVkilUdsTpJmP6FON7qKKa','2023-05-31 13:31:32',NULL),(27,'guerdataro@gmail.com','guerda','$2a$10$5IsXRY6KCkY1OrQAEQ3KA.KdTMnLQb.Xy4MdGF6If3QWZMtKlhGhC','2023-06-01 07:43:22',NULL),(30,'robertocapa@gmail.com','capa','$2a$10$B6D73D/xpl6GnDqccZEYku.s3CPDftmec5HEs3QHcksB3kh5fYz/6','2023-06-02 05:11:12',NULL),(33,'capa@gmail.com','roberto','$2a$10$wRl1psOT8bAch81UejE6qummrW07Am12DPDCKKom/r.nJ3N/5gohe','2023-06-03 12:35:43',NULL),(34,'usertest@test.com','userTest','$2a$10$JBD0XJdysEQDW8slKHYq5uT0NsrQ23DW9k.uLf9gqNh2SlOVFx82i','2023-06-07 12:46:52',NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'rentals'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-07 17:04:44
