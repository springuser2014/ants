SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `log` ;
CREATE SCHEMA IF NOT EXISTS `log` DEFAULT CHARACTER SET utf8 ;
USE `log` ;

-- -----------------------------------------------------
-- Table `log`.`page`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `log`.`page` ;

CREATE TABLE IF NOT EXISTS `log`.`page` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(400) NULL,
  `times` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `log`.`log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `log`.`log` ;

CREATE TABLE IF NOT EXISTS `log`.`log` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `duration` FLOAT NULL,
  `pageId` INT NULL,
  `browser` VARCHAR(500) NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_log_1_idx` (`pageId` ASC),
  CONSTRAINT `fk_log_1`
    FOREIGN KEY (`pageId`)
    REFERENCES `log`.`page` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
