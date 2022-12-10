-- MySQL Workbench Forward Engineering

DROP DATABASE IF EXISTS 'festivales';

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema festivales
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema festivales
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `festivales` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `festivales` ;

-- -----------------------------------------------------
-- Table `festivales`.`festival`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festivales`.`festival` (
  `idfestival` INT NOT NULL AUTO_INCREMENT,
  `nombrefestival` VARCHAR(50) NOT NULL,
  `lugar` VARCHAR(50) NOT NULL,
  `pais` VARCHAR(45) NOT NULL,
  `fechainicio` DATE NULL DEFAULT NULL,
  `fechafin` DATE NULL DEFAULT NULL,
  `acampada` TINYINT NULL DEFAULT NULL,
  `url` VARCHAR(2048) NULL DEFAULT NULL,
  `estilo` VARCHAR(45) NULL DEFAULT NULL,
  `cartel` VARCHAR(2048) NULL DEFAULT NULL,
  `mostrar` TINYINT NOT NULL DEFAULT '0',
  PRIMARY KEY (`idfestival`))
ENGINE = InnoDB
AUTO_INCREMENT = 29
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `festivales`.`grupo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festivales`.`grupo` (
  `idgrupo` INT NOT NULL AUTO_INCREMENT,
  `nombregrupo` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`idgrupo`))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `festivales`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `festivales`.`usuario` (
  `idusuario` INT NOT NULL AUTO_INCREMENT,
  `nombreusuario` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `cantidadfestivalessubidos` INT NULL DEFAULT NULL,
  `rol` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idusuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 13
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
