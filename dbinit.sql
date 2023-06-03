-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`MEMBER`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MEMBER` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MEMBER` (
  `id` VARCHAR(20) NOT NULL,
  `pw` VARCHAR(20) NULL,
  `name` VARCHAR(20) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BOOK`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`BOOK` ;

CREATE TABLE IF NOT EXISTS `mydb`.`BOOK` (
  `id` INT NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `publisher` VARCHAR(50) NOT NULL,
  `author` VARCHAR(50) NOT NULL,
  `on_rent` TINYINT NOT NULL DEFAULT 0,
  `userid` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_Book_MEMBER_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_Book_MEMBER`
    FOREIGN KEY (`userid`)
    REFERENCES `mydb`.`MEMBER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
