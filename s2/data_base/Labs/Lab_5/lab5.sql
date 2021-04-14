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
-- Table `mydb`.`Αεροσκάφος`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Αεροσκάφος` (
  `αριθμός` INT NOT NULL,
  `μοντέλο` VARCHAR(45) NULL,
  PRIMARY KEY (`αριθμός`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Δρομολογιο`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Δρομολογιο` (
  `Αριθμός` INT NOT NULL,
  PRIMARY KEY (`Αριθμός`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Επιβάτης`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Επιβάτης` (
  `Κωδικός` INT NOT NULL,
  `Ονοματεπώνυμο` VARCHAR(60) NULL,
  PRIMARY KEY (`Κωδικός`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Πτήση`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Πτήση` (
  `Ημερομηνία_Πτήσης` DATE NOT NULL,
  `Δρομολογιο_Αριθμός` INT NOT NULL,
  `Αεροσκάφος_αριθμός` INT NOT NULL,
  PRIMARY KEY (`Ημερομηνία_Πτήσης`, `Δρομολογιο_Αριθμός`),
  INDEX `fk_Πτήση_Δρομολογιο_idx` (`Δρομολογιο_Αριθμός` ASC) VISIBLE,
  INDEX `fk_Πτήση_Αεροσκάφος1_idx` (`Αεροσκάφος_αριθμός` ASC) VISIBLE,
  CONSTRAINT `fk_Πτήση_Δρομολογιο`
    FOREIGN KEY (`Δρομολογιο_Αριθμός`)
    REFERENCES `mydb`.`Δρομολογιο` (`Αριθμός`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Πτήση_Αεροσκάφος1`
    FOREIGN KEY (`Αεροσκάφος_αριθμός`)
    REFERENCES `mydb`.`Αεροσκάφος` (`αριθμός`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`Πτήση_has_Επιβάτης`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`Πτήση_has_Επιβάτης` (
  `Πτήση_Ημερομηνία_Πτήσης` DATE NOT NULL,
  `Πτήση_Δρομολογιο_Αριθμός` INT NOT NULL,
  `Επιβάτης_Κωδικός` INT NOT NULL,
  `Αριθμός_Εισητηρίου` VARCHAR(30) NULL,
  `Αριθμός_Θέσης` INT NULL,
  PRIMARY KEY (`Πτήση_Ημερομηνία_Πτήσης`, `Πτήση_Δρομολογιο_Αριθμός`, `Επιβάτης_Κωδικός`),
  INDEX `fk_Πτήση_has_Επιβάτης_Επιβάτης1_idx` (`Επιβάτης_Κωδικός` ASC) VISIBLE,
  INDEX `fk_Πτήση_has_Επιβάτης_Πτήση1_idx` (`Πτήση_Ημερομηνία_Πτήσης` ASC, `Πτήση_Δρομολογιο_Αριθμός` ASC) VISIBLE,
  CONSTRAINT `fk_Πτήση_has_Επιβάτης_Πτήση1`
    FOREIGN KEY (`Πτήση_Ημερομηνία_Πτήσης` , `Πτήση_Δρομολογιο_Αριθμός`)
    REFERENCES `mydb`.`Πτήση` (`Ημερομηνία_Πτήσης` , `Δρομολογιο_Αριθμός`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Πτήση_has_Επιβάτης_Επιβάτης1`
    FOREIGN KEY (`Επιβάτης_Κωδικός`)
    REFERENCES `mydb`.`Επιβάτης` (`Κωδικός`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
