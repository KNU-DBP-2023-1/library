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
DEFAULT CHARACTER SET UTF8
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`BOOK`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`BOOK` ;

CREATE TABLE IF NOT EXISTS `mydb`.`BOOK` (
  `id` INT auto_increment NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `publisher` VARCHAR(50) NOT NULL,
  `author` VARCHAR(50) NOT NULL,
  `on_rent` TINYINT NOT NULL DEFAULT 0,
  `userid` VARCHAR(20),
  PRIMARY KEY (`id`),
  INDEX `fk_Book_MEMBER_idx` (`userid` ASC) VISIBLE,
  CONSTRAINT `fk_Book_MEMBER`
    FOREIGN KEY (`userid`)
    REFERENCES `mydb`.`MEMBER` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION) 
DEFAULT CHARACTER SET UTF8
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Insert Test Data
-- -----------------------------------------------------
insert into member values ('test1', 'test!', 'testname1');
insert into member values ('test2', 'test!', 'testname2');
insert into member values ('test3', 'test!', 'testname3');
insert into member values ('admin', 'admin!', '관리자');

insert into book values (1, '책제목1', '출판사1', '작가1', false, null);
insert into book values (2, '책제목2', '출판사2', '작가2', false, null);
insert into book values (3, '책제목3', '출판사3', '작가3', false, null);
insert into book values (4, '책제목4', '출판사4', '작가4', false, null);
insert into book values (5, '책제목5', '출판사5', '작가5', false, null);
insert into book values (6, '책제목6', '출판사6', '작가6', true, 'test1');
insert into book values (7, '책제목7', '출판사7', '작가7', true, 'test1');
insert into book values (8, '책제목8', '출판사8', '작가8', true, 'test2');
insert into book values (9, '책제목9', '출판사9', '작가9', true, 'test2');
insert into book values (10, '책제목10', '출판사10', '작가10', true, 'test3');

