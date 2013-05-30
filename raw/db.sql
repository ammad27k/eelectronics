/*
SQLyog Ultimate v10.42 
MySQL - 5.5.16-log : Database - maakfreeads
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`maakfreeads` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `mobileinfo`;

/*Table structure for table `admin_users` */

DROP TABLE IF EXISTS `admin_users`;

CREATE TABLE `admin_users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `admin_users` */

/*Table structure for table `categories` */

DROP TABLE IF EXISTS `categories`;

CREATE TABLE `categories` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `parent_id` bigint(20) NOT NULL DEFAULT '0',
  `slug` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


/*Table structure for table `cms_pages` */

DROP TABLE IF EXISTS `cms_pages`;

CREATE TABLE `cms_pages` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `category_id` int(11) DEFAULT '0',
  `slug` varchar(255) DEFAULT NULL,
  `meta_title` varchar(60) DEFAULT NULL,
  `meta_description` varchar(255) DEFAULT NULL,
  `meta_keywords` varchar(255) DEFAULT NULL,
  `meta_content` longtext,
  `sort_order` tinyint(4) DEFAULT '0',
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_alert_types` */

DROP TABLE IF EXISTS `mobile_alert_types`;

CREATE TABLE `mobile_alert_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_bluetooth` */

DROP TABLE IF EXISTS `mobile_bluetooth`;

CREATE TABLE `mobile_bluetooth` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_brands` */

DROP TABLE IF EXISTS `mobile_brands`;

CREATE TABLE `mobile_brands` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `slug` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_browsers` */

DROP TABLE IF EXISTS `mobile_browsers`;

CREATE TABLE `mobile_browsers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_camera_features` */

DROP TABLE IF EXISTS `mobile_camera_features`;

CREATE TABLE `mobile_camera_features` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_camera_primary` */

DROP TABLE IF EXISTS `mobile_camera_primary`;

CREATE TABLE `mobile_camera_primary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_camera_secondary` */

DROP TABLE IF EXISTS `mobile_camera_secondary`;

CREATE TABLE `mobile_camera_secondary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_camera_video` */

DROP TABLE IF EXISTS `mobile_camera_video`;

CREATE TABLE `mobile_camera_video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_chipsets` */

DROP TABLE IF EXISTS `mobile_chipsets`;

CREATE TABLE `mobile_chipsets` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_colors` */

DROP TABLE IF EXISTS `mobile_colors`;

CREATE TABLE `mobile_colors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_cpu` */

DROP TABLE IF EXISTS `mobile_cpu`;

CREATE TABLE `mobile_cpu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_data_speeds` */

DROP TABLE IF EXISTS `mobile_data_speeds`;

CREATE TABLE `mobile_data_speeds` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_display_protection` */

DROP TABLE IF EXISTS `mobile_display_protection`;

CREATE TABLE `mobile_display_protection` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_display_types` */

DROP TABLE IF EXISTS `mobile_display_types`;

CREATE TABLE `mobile_display_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_edge` */

DROP TABLE IF EXISTS `mobile_edge`;

CREATE TABLE `mobile_edge` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_features` */

DROP TABLE IF EXISTS `mobile_features`;

CREATE TABLE `mobile_features` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_games` */

DROP TABLE IF EXISTS `mobile_games`;

CREATE TABLE `mobile_games` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_gprs` */

DROP TABLE IF EXISTS `mobile_gprs`;

CREATE TABLE `mobile_gprs` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_gps` */

DROP TABLE IF EXISTS `mobile_gps`;

CREATE TABLE `mobile_gps` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_gpu` */

DROP TABLE IF EXISTS `mobile_gpu`;

CREATE TABLE `mobile_gpu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_java` */

DROP TABLE IF EXISTS `mobile_java`;

CREATE TABLE `mobile_java` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_memory` */

DROP TABLE IF EXISTS `mobile_memory`;

CREATE TABLE `mobile_memory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_memory_cardslots` */

DROP TABLE IF EXISTS `mobile_memory_cardslots`;

CREATE TABLE `mobile_memory_cardslots` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_messaging` */

DROP TABLE IF EXISTS `mobile_messaging`;

CREATE TABLE `mobile_messaging` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_networks` */

DROP TABLE IF EXISTS `mobile_networks`;

CREATE TABLE `mobile_networks` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `type` char(2) DEFAULT '2G',
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_nfc` */

DROP TABLE IF EXISTS `mobile_nfc`;

CREATE TABLE `mobile_nfc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_os` */

DROP TABLE IF EXISTS `mobile_os`;

CREATE TABLE `mobile_os` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_photos` */

DROP TABLE IF EXISTS `mobile_phone_photos`;

CREATE TABLE `mobile_phone_photos` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) NOT NULL,
  `photo_url` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_alert_types` */

DROP TABLE IF EXISTS `mobile_phone_to_alert_types`;

CREATE TABLE `mobile_phone_to_alert_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `alert_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_alert_type_phone_id` (`phone_id`),
  KEY `mobile_alert_type_alert_id` (`alert_type_id`),
  CONSTRAINT `mobile_alert_type_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_alert_type_alert_id` FOREIGN KEY (`alert_type_id`) REFERENCES `mobile_alert_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_browsers` */

DROP TABLE IF EXISTS `mobile_phone_to_browsers`;

CREATE TABLE `mobile_phone_to_browsers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `browser_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_browser_phone_id` (`phone_id`),
  KEY `mobile_browser_browser_id` (`browser_id`),
  CONSTRAINT `mobile_browser_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_browser_browser_id` FOREIGN KEY (`browser_id`) REFERENCES `mobile_browsers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_camera_features` */

DROP TABLE IF EXISTS `mobile_phone_to_camera_features`;

CREATE TABLE `mobile_phone_to_camera_features` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `feature_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_camera_feature_phone_id` (`phone_id`),
  KEY `mobile_camera_feature_feature_id` (`feature_id`),
  CONSTRAINT `mobile_camera_feature_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_camera_feature_feature_id` FOREIGN KEY (`feature_id`) REFERENCES `mobile_camera_features` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_camera_primary` */

DROP TABLE IF EXISTS `mobile_phone_to_camera_primary`;

CREATE TABLE `mobile_phone_to_camera_primary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `primary_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_camera_primary_phone_id` (`phone_id`),
  KEY `mobile_camera_primary_camera_id` (`primary_id`),
  CONSTRAINT `mobile_camera_primary_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_camera_primary_camera_id` FOREIGN KEY (`primary_id`) REFERENCES `mobile_camera_primary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_camera_secondary` */

DROP TABLE IF EXISTS `mobile_phone_to_camera_secondary`;

CREATE TABLE `mobile_phone_to_camera_secondary` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `secondary_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_camera_secondary_phone_id` (`phone_id`),
  KEY `mobile_camera_secondary_camera_id` (`secondary_id`),
  CONSTRAINT `mobile_camera_secondary_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_camera_secondary_camera_id` FOREIGN KEY (`secondary_id`) REFERENCES `mobile_camera_secondary` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_camera_video` */

DROP TABLE IF EXISTS `mobile_phone_to_camera_video`;

CREATE TABLE `mobile_phone_to_camera_video` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `video_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_camera_video_phone_id` (`phone_id`),
  KEY `mobile_camera_video_camera_id` (`video_id`),
  CONSTRAINT `mobile_camera_video_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_camera_video_camera_id` FOREIGN KEY (`video_id`) REFERENCES `mobile_camera_video` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_colors` */

DROP TABLE IF EXISTS `mobile_phone_to_colors`;

CREATE TABLE `mobile_phone_to_colors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `color_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_colors_phone_id` (`phone_id`),
  KEY `mobile_colors_camera_id` (`color_id`),
  CONSTRAINT `mobile_colors_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_colors_camera_id` FOREIGN KEY (`color_id`) REFERENCES `mobile_colors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_data_speeds` */

DROP TABLE IF EXISTS `mobile_phone_to_data_speeds`;

CREATE TABLE `mobile_phone_to_data_speeds` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `data_speed_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_data_speeds_phone_id` (`phone_id`),
  KEY `mobile_data_speeds_speed_id` (`data_speed_id`),
  CONSTRAINT `mobile_data_speeds_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_data_speeds_speed_id` FOREIGN KEY (`data_speed_id`) REFERENCES `mobile_data_speeds` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_display_types` */

DROP TABLE IF EXISTS `mobile_phone_to_display_types`;

CREATE TABLE `mobile_phone_to_display_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `display_type_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `display_type_id` (`display_type_id`),
  KEY `mobile_phone_display_type_id` (`phone_id`),
  CONSTRAINT `mobile_phone_display_type_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `display_type_id` FOREIGN KEY (`display_type_id`) REFERENCES `mobile_display_types` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_features` */

DROP TABLE IF EXISTS `mobile_phone_to_features`;

CREATE TABLE `mobile_phone_to_features` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `feature_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_features_phone_id` (`phone_id`),
  KEY `mobile_features_speed_id` (`feature_id`),
  CONSTRAINT `mobile_features_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_features_speed_id` FOREIGN KEY (`feature_id`) REFERENCES `mobile_features` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_games` */

DROP TABLE IF EXISTS `mobile_phone_to_games`;

CREATE TABLE `mobile_phone_to_games` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `game_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_games_phone_id` (`phone_id`),
  KEY `mobile_games_game_id` (`game_id`),
  CONSTRAINT `mobile_games_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_games_game_id` FOREIGN KEY (`game_id`) REFERENCES `mobile_games` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_java` */

DROP TABLE IF EXISTS `mobile_phone_to_java`;

CREATE TABLE `mobile_phone_to_java` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `java_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_java_phone_id` (`phone_id`),
  KEY `mobile_java_java_id` (`java_id`),
  CONSTRAINT `mobile_java_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_java_java_id` FOREIGN KEY (`java_id`) REFERENCES `mobile_java` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_memory` */

DROP TABLE IF EXISTS `mobile_phone_to_memory`;

CREATE TABLE `mobile_phone_to_memory` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `memory_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_memory_phone_id` (`phone_id`),
  KEY `mobile_memory_memory_id` (`memory_id`),
  CONSTRAINT `mobile_memory_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_memory_memory_id` FOREIGN KEY (`memory_id`) REFERENCES `mobile_memory` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_memory_cardslots` */

DROP TABLE IF EXISTS `mobile_phone_to_memory_cardslots`;

CREATE TABLE `mobile_phone_to_memory_cardslots` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `memory_cardslot_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_memory_cardslots_phone_id` (`phone_id`),
  KEY `mobile_memory_cardslots_memory_id` (`memory_cardslot_id`),
  CONSTRAINT `mobile_memory_cardslots_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_memory_cardslots_memory_id` FOREIGN KEY (`memory_cardslot_id`) REFERENCES `mobile_memory_cardslots` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_messaging` */

DROP TABLE IF EXISTS `mobile_phone_to_messaging`;

CREATE TABLE `mobile_phone_to_messaging` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `messaging_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_messaging_phone_id` (`phone_id`),
  KEY `mobile_messaging_messaging_id` (`messaging_id`),
  CONSTRAINT `mobile_messaging_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_messaging_messaging_id` FOREIGN KEY (`messaging_id`) REFERENCES `mobile_messaging` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mobile_phone_to_messaging` */

/*Table structure for table `mobile_phone_to_networks` */

DROP TABLE IF EXISTS `mobile_phone_to_networks`;

CREATE TABLE `mobile_phone_to_networks` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `network_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_phone_id` (`phone_id`),
  KEY `mobile_network_id` (`network_id`),
  CONSTRAINT `mobile_network_id` FOREIGN KEY (`network_id`) REFERENCES `mobile_networks` (`id`),
  CONSTRAINT `mobile_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_nfc` */

DROP TABLE IF EXISTS `mobile_phone_to_nfc`;

CREATE TABLE `mobile_phone_to_nfc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `nfc_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_nfc_phone_id` (`phone_id`),
  KEY `mobile_nfc_nfc_id` (`nfc_id`),
  CONSTRAINT `mobile_nfc_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_nfc_nfc_id` FOREIGN KEY (`nfc_id`) REFERENCES `mobile_nfc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mobile_phone_to_nfc` */

/*Table structure for table `mobile_phone_to_protections` */

DROP TABLE IF EXISTS `mobile_phone_to_protections`;

CREATE TABLE `mobile_phone_to_protections` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `protection_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_protections_phone_id` (`phone_id`),
  KEY `mobile_protections_protection_id` (`protection_id`),
  CONSTRAINT `mobile_protections_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_protections_protection_id` FOREIGN KEY (`protection_id`) REFERENCES `mobile_display_protection` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_radio` */

DROP TABLE IF EXISTS `mobile_phone_to_radio`;

CREATE TABLE `mobile_phone_to_radio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `radio_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_radio_phone_id` (`phone_id`),
  KEY `mobile_radio_radio_id` (`radio_id`),
  CONSTRAINT `mobile_radio_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_radio_radio_id` FOREIGN KEY (`radio_id`) REFERENCES `mobile_radio` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_sensors` */

DROP TABLE IF EXISTS `mobile_phone_to_sensors`;

CREATE TABLE `mobile_phone_to_sensors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `sensor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_sensors_phone_id` (`phone_id`),
  KEY `mobile_sensors_sensor_id` (`sensor_id`),
  CONSTRAINT `mobile_sensors_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_sensors_sensor_id` FOREIGN KEY (`sensor_id`) REFERENCES `mobile_sensors` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_phone_to_sound_features` */

DROP TABLE IF EXISTS `mobile_phone_to_sound_features`;

CREATE TABLE `mobile_phone_to_sound_features` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `phone_id` bigint(20) DEFAULT NULL,
  `feature_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `mobile_sound_features_phone_id` (`phone_id`),
  KEY `mobile_sound_features_feature_id` (`feature_id`),
  CONSTRAINT `mobile_sound_features_phone_id` FOREIGN KEY (`phone_id`) REFERENCES `mobile_phones` (`id`),
  CONSTRAINT `mobile_sound_features_feature_id` FOREIGN KEY (`feature_id`) REFERENCES `mobile_sound_features` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mobile_phone_to_sound_features` */

/*Table structure for table `mobile_phones` */

DROP TABLE IF EXISTS `mobile_phones`;

CREATE TABLE `mobile_phones` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `gsmarena_id` bigint(20) NOT NULL,
  `brand_id` bigint(20) DEFAULT '0',
  `slug` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `sim_type_id` bigint(20) DEFAULT '0',
  `announcement_date` date DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  `dimensions` varchar(255) DEFAULT NULL,
  `weight` varchar(255) DEFAULT NULL,
  `display_size` varchar(255) DEFAULT NULL,
  `display_multitouch` char(1) DEFAULT 'N',
  `sound_loudspeaker` char(1) DEFAULT 'Y',
  `sound_35mmjack` char(1) DEFAULT 'N',
  `phonebook` varchar(255) NOT NULL,
  `call_records` varchar(255) NOT NULL,
  `gprs_id` bigint(20) DEFAULT '0',
  `edge_id` bigint(20) DEFAULT '0',
  `wlan_id` bigint(20) DEFAULT '0',
  `bluetooth_id` bigint(20) DEFAULT '0',
  `usb_id` bigint(20) DEFAULT '0',
  `os_id` bigint(20) DEFAULT '0',
  `chipset_id` bigint(20) DEFAULT '0',
  `cpu_id` bigint(20) DEFAULT '0',
  `gpu_id` bigint(20) DEFAULT '0',
  `gps_id` bigint(20) DEFAULT '0',
  `battery` varchar(255) DEFAULT NULL,
  `standby_time` varchar(255) DEFAULT NULL,
  `talk_time` varchar(255) DEFAULT NULL,
  `music_play` varchar(255) DEFAULT NULL,
  `photo_url` varchar(255) NOT NULL,
  `short_desc` varchar(255) DEFAULT NULL,
  `full_desc` longtext,
  `is_special` char(1) DEFAULT 'N',
  `is_featured` char(1) DEFAULT 'N',
  `added_on` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`),
  KEY `mobile_phone_grps_id` (`gprs_id`),
  KEY `mobile_phone_edge_id` (`edge_id`),
  KEY `mobile_phone_wlan_id` (`wlan_id`),
  KEY `mobile_phone_bluetooth_id` (`bluetooth_id`),
  KEY `mobile_phone_usb_id` (`usb_id`),
  KEY `mobile_phone_os_id` (`os_id`),
  KEY `mobile_phone_chipset_id` (`chipset_id`),
  KEY `mobile_phone_cpu_id` (`cpu_id`),
  KEY `mobile_phone_gpu_id` (`gpu_id`),
  KEY `mobile_phone_gps_id` (`gps_id`),
  CONSTRAINT `mobile_phone_grps_id` FOREIGN KEY (`gprs_id`) REFERENCES `mobile_gprs` (`id`),
  CONSTRAINT `mobile_phone_edge_id` FOREIGN KEY (`edge_id`) REFERENCES `mobile_edge` (`id`),
  CONSTRAINT `mobile_phone_wlan_id` FOREIGN KEY (`wlan_id`) REFERENCES `mobile_wlan` (`id`),
  CONSTRAINT `mobile_phone_bluetooth_id` FOREIGN KEY (`bluetooth_id`) REFERENCES `mobile_bluetooth` (`id`),
  CONSTRAINT `mobile_phone_usb_id` FOREIGN KEY (`usb_id`) REFERENCES `mobile_usb` (`id`),
  CONSTRAINT `mobile_phone_os_id` FOREIGN KEY (`os_id`) REFERENCES `mobile_os` (`id`),
  CONSTRAINT `mobile_phone_chipset_id` FOREIGN KEY (`chipset_id`) REFERENCES `mobile_chipsets` (`id`),
  CONSTRAINT `mobile_phone_cpu_id` FOREIGN KEY (`cpu_id`) REFERENCES `mobile_cpu` (`id`),
  CONSTRAINT `mobile_phone_gpu_id` FOREIGN KEY (`gpu_id`) REFERENCES `mobile_gpu` (`id`),
  CONSTRAINT `mobile_phone_gps_id` FOREIGN KEY (`gps_id`) REFERENCES `mobile_gps` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_radio` */

DROP TABLE IF EXISTS `mobile_radio`;

CREATE TABLE `mobile_radio` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_sensors` */

DROP TABLE IF EXISTS `mobile_sensors`;

CREATE TABLE `mobile_sensors` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_sim_types` */

DROP TABLE IF EXISTS `mobile_sim_types`;

CREATE TABLE `mobile_sim_types` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


/*Table structure for table `mobile_sound_features` */

DROP TABLE IF EXISTS `mobile_sound_features`;

CREATE TABLE `mobile_sound_features` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mobile_sound_features` */

/*Table structure for table `mobile_speeds` */

DROP TABLE IF EXISTS `mobile_speeds`;

CREATE TABLE `mobile_speeds` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `mobile_speeds` */

/*Table structure for table `mobile_usb` */

DROP TABLE IF EXISTS `mobile_usb`;

CREATE TABLE `mobile_usb` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `mobile_usb` */


DROP TABLE IF EXISTS `mobile_wlan`;

CREATE TABLE `mobile_wlan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;


/*Table structure for table `posts` */

DROP TABLE IF EXISTS `posts`;

CREATE TABLE `posts` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `slug` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `short_content` varchar(255) DEFAULT NULL,
  `content` longtext,
  `tags` varchar(255) DEFAULT NULL,
  `post_type` varchar(10) DEFAULT 'blog',
  `added_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_active` char(1) DEFAULT 'Y',
  `is_deleted` char(1) DEFAULT 'N',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;


/*Table structure for table `posts_comments` */

DROP TABLE IF EXISTS `posts_comments`;

CREATE TABLE `posts_comments` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `post_id` bigint(20) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `content` text,
  `added_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `is_deleted` char(1) DEFAULT 'Y',
  PRIMARY KEY (`id`),
  KEY `posts_comments_post_id` (`post_id`),
  CONSTRAINT `posts_comments_post_id` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `posts_comments` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
