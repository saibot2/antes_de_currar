
-- Base de datos: pruebas. BBDD en MySQL hecha con xamp. Cotejamiento: utf8_spanish_ci
port: 3306 localhost
URL--> jdbc:mysql://localhost:3306/pruebas


CREATE TABLE ALMACENES (
	`id_almacen` bigint unsigned NOT NULL auto_increment, 
	`nombre_almacen` varchar(100) default NULL, 
	`telefono` varchar(20) default NULL, 
	PRIMARY KEY (`id_almacen`) 
) engine=innodb DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci; 

CREATE TABLE PRODUCTOS ( 
	`id_producto` BIGINT NOT NULL auto_increment, 
	`nombre_producto` varchar(100) default NULL, 
	`pvp` FLOAT NOT NULL , 
	`id_almacen` bigint unsigned NOT NULL, 
	PRIMARY KEY (`id_producto`),
	CONSTRAINT FOREIGN KEY (`id_almacen`) REFERENCES ALMACENES(`id_almacen`) ON DELETE CASCADE	
) ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_spanish_ci;


CREATE TABLE NAIPES (
	`id_naipe` int unsigned NOT NULL, 
	`numero` int unsigned NOT NULL, 
	`palo` varchar(1) NOT NULL,
	PRIMARY KEY (`id_naipe`) 
) engine=innodb DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci; 

INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (1,'c',1);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (2,'c',2);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (3,'c',3);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (4,'c',4);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (5,'c',5);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (6,'c',6);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (7,'c',7);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (8,'c',8);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (9,'c',9);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (10,'c',10);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (11,'c',11);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (12,'c',12);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (13,'c',13);
---
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (14,'d',1);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (15,'d',2);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (16,'d',3);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (17,'d',4);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (18,'d',5);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (19,'d',6);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (20,'d',7);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (21,'d',8);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (22,'d',9);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (23,'d',10);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (24,'d',11);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (25,'d',12);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (26,'d',13);
---
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (27,'t',1);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (28,'t',2);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (29,'t',3);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (30,'t',4);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (31,'t',5);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (32,'t',6);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (33,'t',7);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (34,'t',8);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (35,'t',9);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (36,'t',10);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (37,'t',11);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (38,'t',12);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (39,'t',13);
--
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (40,'p',1);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (41,'p',2);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (42,'p',3);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (43,'p',4);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (44,'p',5);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (45,'p',6);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (46,'p',7);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (47,'p',8);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (48,'p',9);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (49,'p',10);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (50,'p',11);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (51,'p',12);
INSERT INTO NAIPES (id_naipe, palo, numero)
VALUES (52,'p',13);

INSERT INTO bddpruebas.ALMACENES
 (nombre_almacen, telefono)
VALUES('Almacenes pepe','677-895824');


INSERT INTO almacenes (`id_almacen`, `nombre_almacen`, `telefono`) VALUES (NULL, 'Almacenes pepe', '677-895824');

INSERT INTO almacenes
 (nombre_almacen, telefono)
VALUES('Almacen Chino Filipino','907-212587');

INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Cepillo dientes',1.00,1);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Hilo dental',2.50,1);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Papel higienico',3.50,1);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Servilletas',2.60,1);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Vaso mediano',1.50,1);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Plato hondo',1.00,1);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Plato plano',1.10,1);


INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Hilo dental',2.50,2);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Cuadro 1x2',12.50,2);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Navaja grande',32.30,2);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Cuaderno mediano',4.00,2);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Lapiz normal',1.50,2);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Lapiz blando',1.90,2);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Goma borrar Milán',2.00,2);
INSERT INTO productos
 (nombre_producto, pvp, id_almacen)
VALUES('Goma Borrar MB',1.10,2);


DELETE FROM `pruebas`.`almacenes` WHERE `almacenes`.`id_almacen` = 23;
DELETE FROM `pruebas`.`almacenes` WHERE `almacenes`.`id_almacen` = 22;
DELETE FROM `pruebas`.`almacenes` WHERE `almacenes`.`id_almacen` = 24;
DELETE FROM `pruebas`.`almacenes` WHERE `almacenes`.`id_almacen` = 6;

SELECT * 
FROM 
almacenes a 
LEFT JOIN productos p
ON a.`id_almacen` = p.`id_almacen`

	
select ... from Entity1 e1
[inner | left [outer]] join e1.entity2s e2
[inner | left [outer]] join e2.entity3s e3

ALTER TABLE `almacenes` ADD `esactivo` INT NOT NULL DEFAULT 1;

UPDATE `almacenes`
SET esactivo = 1
WHERE `almacenes`.`id_almacen`=19
		
		
 SELECT a.`id_almacen`, p.`id_producto`
 FROM almacenes a, productos p
 WHERE a.`id_almacen` = p.`id_almacen`
 ORDER BY a.`id_almacen`
 
 SELECT a.`id_almacen`, p.`id_producto`
 FROM almacenes a LEFT JOIN productos p
 ON a.`id_almacen` = p.`id_almacen`
 ORDER BY a.`id_almacen`
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		








