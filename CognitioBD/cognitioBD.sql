-- MySQL Script generated by MySQL Workbench
-- Mon Apr  3 17:12:32 2023
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema bdcognitio
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `bdcognitio` ;

-- -----------------------------------------------------
-- Schema bdcognitio
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bdcognitio` DEFAULT CHARACTER SET utf8 ;
USE `bdcognitio` ;

-- -----------------------------------------------------
-- Table `bdcognitio`.`estadocliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`estadocliente` (
  `idestadoCliente` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idestadoCliente`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcognitio`.`sexo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`sexo` (
  `idsexo` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idsexo`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcognitio`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`cliente` (
  `idcliente` INT(11) NOT NULL,
  `fechaInscripcion` DATETIME NOT NULL,
  `nombre` VARCHAR(40) NOT NULL,
  `apellido` VARCHAR(40) NOT NULL,
  `edad` INT(11) NOT NULL,
  `peso` INT(11) NOT NULL,
  `correo` VARCHAR(80) NOT NULL,
  `celular` INT(11) NOT NULL,
  `sexo_idsexo` INT(11) NOT NULL,
  `estadoCliente_idestadoCliente` INT(11) NOT NULL,
  `identificacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcliente`),
  CONSTRAINT `fk_cliente_estadoCliente1`
    FOREIGN KEY (`estadoCliente_idestadoCliente`)
    REFERENCES `bdcognitio`.`estadocliente` (`idestadoCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cliente_sexo1`
    FOREIGN KEY (`sexo_idsexo`)
    REFERENCES `bdcognitio`.`sexo` (`idsexo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_cliente_sexo1_idx` ON `bdcognitio`.`cliente` (`sexo_idsexo` ASC) VISIBLE;

CREATE INDEX `fk_cliente_estadoCliente1_idx` ON `bdcognitio`.`cliente` (`estadoCliente_idestadoCliente` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `bdcognitio`.`estadocita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`estadocita` (
  `idestadoCita` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idestadoCita`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcognitio`.`tipocita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`tipocita` (
  `idtipoCita` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idtipoCita`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcognitio`.`estadousuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`estadousuario` (
  `idestadoUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(40) NOT NULL,
  PRIMARY KEY (`idestadoUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcognitio`.`rolusuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`rolusuario` (
  `idrolUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idrolUsuario`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcognitio`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`usuario` (
  `idusuario` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(40) NOT NULL,
  `apellido` VARCHAR(40) NULL DEFAULT NULL,
  `celular` VARCHAR(50) NULL DEFAULT NULL,
  `direccion` VARCHAR(80) NULL DEFAULT NULL,
  `estadoUsuario_idestadoUsuario` INT(11) NOT NULL,
  `rolUsuario_idrolUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  CONSTRAINT `fk_usuario_estadoUsuario`
    FOREIGN KEY (`estadoUsuario_idestadoUsuario`)
    REFERENCES `bdcognitio`.`estadousuario` (`idestadoUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_usuario_rolUsuario1`
    FOREIGN KEY (`rolUsuario_idrolUsuario`)
    REFERENCES `bdcognitio`.`rolusuario` (`idrolUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_usuario_estadoUsuario_idx` ON `bdcognitio`.`usuario` (`estadoUsuario_idestadoUsuario` ASC) VISIBLE;

CREATE INDEX `fk_usuario_rolUsuario1_idx` ON `bdcognitio`.`usuario` (`rolUsuario_idrolUsuario` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `bdcognitio`.`cita`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`cita` (
  `idcita` INT(11) NOT NULL AUTO_INCREMENT,
  `fecha` DATETIME NOT NULL,
  `observacion` VARCHAR(400) NULL DEFAULT NULL,
  `usuario_idusuario` INT(11) NOT NULL,
  `tipoCita_idtipoCita` INT(11) NOT NULL,
  `cliente_idcliente` INT(11) NOT NULL,
  `estadoCita_idestadoCita` INT(11) NOT NULL,
  PRIMARY KEY (`idcita`),
  CONSTRAINT `fk_cita_cliente1`
    FOREIGN KEY (`cliente_idcliente`)
    REFERENCES `bdcognitio`.`cliente` (`idcliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_estadoCita1`
    FOREIGN KEY (`estadoCita_idestadoCita`)
    REFERENCES `bdcognitio`.`estadocita` (`idestadoCita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_tipoCita1`
    FOREIGN KEY (`tipoCita_idtipoCita`)
    REFERENCES `bdcognitio`.`tipocita` (`idtipoCita`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `bdcognitio`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_cita_usuario1_idx` ON `bdcognitio`.`cita` (`usuario_idusuario` ASC) VISIBLE;

CREATE INDEX `fk_cita_tipoCita1_idx` ON `bdcognitio`.`cita` (`tipoCita_idtipoCita` ASC) VISIBLE;

CREATE INDEX `fk_cita_cliente1_idx` ON `bdcognitio`.`cita` (`cliente_idcliente` ASC) VISIBLE;

CREATE INDEX `fk_cita_estadoCita1_idx` ON `bdcognitio`.`cita` (`estadoCita_idestadoCita` ASC) VISIBLE;


-- -----------------------------------------------------
-- Table `bdcognitio`.`estadoitem`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`estadoitem` (
  `idestadoItem` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idestadoItem`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `bdcognitio`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bdcognitio`.`item` (
  `iditem` INT(11) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaMantenimiento` DATETIME NOT NULL,
  `fechaIngreso` DATETIME NOT NULL,
  `estadoItem_idestadoItem` INT(11) NOT NULL,
  `usuario_idusuario` INT(11) NOT NULL,
  PRIMARY KEY (`iditem`),
  CONSTRAINT `fk_item_estadoItem1`
    FOREIGN KEY (`estadoItem_idestadoItem`)
    REFERENCES `bdcognitio`.`estadoitem` (`idestadoItem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_item_usuario1`
    FOREIGN KEY (`usuario_idusuario`)
    REFERENCES `bdcognitio`.`usuario` (`idusuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_item_estadoItem1_idx` ON `bdcognitio`.`item` (`estadoItem_idestadoItem` ASC) VISIBLE;

CREATE INDEX `fk_item_usuario1_idx` ON `bdcognitio`.`item` (`usuario_idusuario` ASC) VISIBLE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
