-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS supermercado;
USE supermercado;

-- Crear tabla EMPLEADO 
CREATE TABLE IF NOT EXISTS empleado (
	rut VARCHAR(10) PRIMARY KEY,
	primerNombre VARCHAR(50) NOT NULL,
	segundoNombre VARCHAR(50) NOT NULL,
	apellidoPaterno VARCHAR(50) NOT NULL,
	apellidoMaterno VARCHAR(50) NOT NULL,
	password VARCHAR(64) NOT NULL,
	isAdministrador BOOLEAN NOT NULL,
	isReporte BOOLEAN NOT NULL,
	isCaja BOOLEAN NOT NULL,
	isBodega BOOLEAN NOT NULL,
	isHabilitado BOOLEAN NOT NULL
);
-- Crear tabla CLIENTE
CREATE TABLE IF NOT EXISTS cliente (
	rut VARCHAR(10) PRIMARY KEY,
	primerNombre VARCHAR(50) NOT NULL,
	segundoNombre VARCHAR(50) NOT NULL,
	apellidoPaterno VARCHAR(50) NOT NULL,
	apellidoMaterno VARCHAR(50) NOT NULL,
	puntos INTEGER NOT NULL
);
-- Crear tabla VENTA
CREATE TABLE IF NOT EXISTS venta (
	id_venta INTEGER PRIMARY KEY,
	rut_cliente VARCHAR(10),
	rut_vendedor VARCHAR(10),
	fecha_venta DATE NOT NULL,
	monto INTEGER NOT NULL, 
	FOREIGN KEY (rut_cliente) REFERENCES cliente(rut),
	FOREIGN KEY (rut_vendedor) REFERENCES empleado(rut)	
);
-- Crear tabla PRODUCTO
CREATE TABLE IF NOT EXISTS producto (
	id_producto INTEGER PRIMARY KEY,
	nombre VARCHAR(50) NOT NULL,
	marca VARCHAR(20) NOT NULL,
	medida INTEGER NOT NULL,
	unidad_medida VARCHAR(15) NOT NULL,
	precio INTEGER NOT NULL,
	stock INTEGER NOT NULL,
	descuento INTEGER NOT NULL
);
-- Crear tabla VENTA_PRODUCTO
CREATE TABLE IF NOT EXISTS venta_producto (
	id_venta INTEGER,
	id_producto INTEGER,
	cantidad INTEGER NOT NULL,
	precio_unitario INTEGER NOT NULL,
	
	PRIMARY KEY (id_venta, id_producto),
	FOREIGN KEY (id_venta) REFERENCES venta(id_venta),
	FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);
-- Crear tabla DEVOLUCION
CREATE TABLE IF NOT EXISTS devolucion (
	id_devolución INTEGER PRIMARY KEY,
	id_venta INTEGER NOT NULL,
	fecha_devolucion DATE NOT NULL,
	monto INTEGER NOT NULL, 
	FOREIGN KEY (id_venta) REFERENCES venta(id_venta)
);

-- Insertar 40 registros PRODUCTO -- LISTO!!
-- Insertar 20 registros EMPLEADO -- LISTO!! 
-- Insertar 20 registros CLIENTE -- LISTO!!
-- Insertar 40 registros VENTA -- LISTO!!
-- Insertar registros PRODUCTO_VENTA
-- Insertar 5 registros DEVOLUCION -- to delete

-- Insertar PRODUCTO (40 registros)
INSERT INTO producto VALUES
(1, 'Arroz', 'Tucapel', 1000, 'gr', 1290, 100, 0),
(2, 'Aceite', 'Chef', 1000, 'ml', 2490, 80, 10),
(3, 'Azúcar', 'Iansa', 1000, 'gr', 990, 150, 0),
(4, 'Leche', 'Colun', 1000, 'ml', 1190, 200, 5),
(5, 'Fideos', 'Carozzi', 400, 'gr', 890, 120, 0),
(6, 'Atún', 'Robinson Crusoe', 170, 'gr', 1690, 90, 15),
(7, 'Café', 'Nescafé', 170, 'gr', 4990, 60, 0),
(8, 'Sal', 'Lobos', 1000, 'gr', 690, 100, 0),
(9, 'Mantequilla', 'Soprole', 250, 'gr', 2290, 80, 10),
(10, 'Huevos', 'Yemita', 12, 'u', 2990, 150, 0),
(11, 'Pan Molde', 'Ideal', 500, 'gr', 1990, 100, 5),
(12, 'Yogurt', 'Colun', 1000, 'ml', 1890, 120, 0),
(13, 'Queso', 'Soprole', 250, 'gr', 2890, 70, 0),
(14, 'Jamón', 'PF', 200, 'gr', 2190, 60, 10),
(15, 'Salsa Tomate', 'Malloa', 200, 'gr', 990, 100, 0),
(16, 'Mayonesa', 'Hellmanns', 500, 'gr', 2490, 90, 5),
(17, 'Detergente', 'Omo', 3000, 'gr', 5990, 80, 15),
(18, 'Papel Higiénico', 'Confort', 12, 'u', 4990, 150, 10),
(19, 'Jabón', 'Dove', 90, 'gr', 990, 100, 0),
(20, 'Shampoo', 'Head&Shoulders', 400, 'ml', 3990, 70, 0),
(21, 'Pasta Dental', 'Colgate', 90, 'gr', 1990, 120, 5),
(22, 'Cerveza', 'Cristal', 350, 'ml', 890, 200, 0),
(23, 'Bebida', 'Coca-Cola', 1500, 'ml', 1690, 180, 10),
(24, 'Jugo', 'Watts', 1500, 'ml', 1290, 150, 0),
(25, 'Galletas', 'Costa', 140, 'gr', 990, 100, 0),
(26, 'Chocolate', 'Trencito', 150, 'gr', 1490, 80, 5),
(27, 'Papas Fritas', 'Lays', 180, 'gr', 1890, 90, 0),
(28, 'Helado', 'Savory', 1000, 'ml', 4990, 60, 15),
(29, 'Cereales', 'Nestlé', 500, 'gr', 2990, 70, 0),
(30, 'Mermelada', 'Watts', 250, 'gr', 1490, 80, 0),
(31, 'Manteca', 'Astra', 250, 'gr', 1290, 100, 5),
(32, 'Harina', 'Selecta', 1000, 'gr', 990, 150, 0),
(33, 'Té', 'Supremo', 20, 'u', 1190, 120, 0),
(34, 'Lenteja', 'Banquete', 1000, 'gr', 1890, 90, 10),
(35, 'Porotos', 'Banquete', 1000, 'gr', 1990, 80, 0),
(36, 'Garbanzos', 'Banquete', 1000, 'gr', 1990, 70, 5),
(37, 'Servilletas', 'Noble', 100, 'u', 990, 200, 0),
(38, 'Lavaloza', 'Quix', 750, 'ml', 1890, 100, 15),
(39, 'Cloro', 'Clorox', 1000, 'ml', 1490, 120, 0),
(40, 'Esponjas', 'Virutex', 3, 'u', 890, 150, 0);

-- Insertar EMPLEADO (20 registros)
INSERT INTO empleado VALUES
('1-1', 'Juan', 'Pedro', 'González', 'Pérez', 'pass123', true, true, false, false, true),
('2-1', 'María', 'José', 'Sánchez', 'López', 'pass124', false, false, true, false, true),
('3-1', 'Carlos', 'Alberto', 'Muñoz', 'Silva', 'pass125', false, false, false, true, true),
('4-1', 'Ana', 'María', 'Rojas', 'Torres', 'pass126', true, true, true, false, true),
('5-1', 'Luis', 'Miguel', 'Castro', 'Morales', 'pass127', false, true, false, false, true),
('6-1', 'Paula', 'Andrea', 'Vargas', 'Reyes', 'pass128', false, false, true, false, true),
('7-1', 'Diego', 'Alejandro', 'Flores', 'Campos', 'pass129', false, false, false, true, true),
('8-1', 'Carmen', 'Gloria', 'Herrera', 'Vega', 'pass130', true, false, true, false, true),
('9-1', 'Roberto', 'Carlos', 'Mendoza', 'Ruiz', 'pass131', false, true, false, false, true),
('10-1', 'Claudia', 'Patricia', 'Núñez', 'Jiménez', 'pass132', false, false, true, false, true),
('11-1', 'Fernando', 'José', 'Araya', 'Pizarro', 'pass133', false, false, false, true, true),
('12-1', 'Marcela', 'Andrea', 'Vergara', 'Soto', 'pass134', true, true, false, false, true),
('13-1', 'Ricardo', 'Antonio', 'Miranda', 'Bravo', 'pass135', false, false, true, false, true),
('14-1', 'Patricia', 'Carolina', 'Lagos', 'Díaz', 'pass136', false, false, false, true, true),
('15-1', 'Jorge', 'Luis', 'Ortiz', 'Fuentes', 'pass137', true, true, true, false, true),
('16-1', 'Sandra', 'Beatriz', 'Espinoza', 'Ramos', 'pass138', false, true, false, false, false),
('17-1', 'Miguel', 'Ángel', 'Valenzuela', 'Cruz', 'pass139', false, false, true, false, true),
('18-1', 'Carolina', 'Isabel', 'Medina', 'Guerrero', 'pass140', false, false, false, true, true),
('19-1', 'Héctor', 'Manuel', 'Navarro', 'Romero', 'pass141', true, false, true, false, true),
('20-1', 'Verónica', 'Alejandra', 'Poblete', 'Castro', 'pass142', false, true, false, false, true);

-- Insertar CLIENTE (20 registros)
INSERT INTO cliente VALUES
('1-2', 'Pedro', 'Juan', 'Martínez', 'García', 1000),
('2-2', 'Sofía', 'Elena', 'López', 'Rodríguez', 1500),
('3-2', 'Manuel', 'José', 'Pérez', 'Fernández', 2000),
('4-2', 'Isabel', 'María', 'Gómez', 'Morales', 500),
('5-2', 'Andrés', 'Felipe', 'Torres', 'Silva', 3000),
('6-2', 'Laura', 'Cristina', 'Ramírez', 'Vargas', 1200),
('7-2', 'Gabriel', 'Eduardo', 'Castro', 'Muñoz', 800),
('8-2', 'Valentina', 'Andrea', 'Reyes', 'Herrera', 1600),
('9-2', 'Francisco', 'Javier', 'Morales', 'Flores', 2500),
('10-2', 'Catalina', 'Paz', 'Vega', 'Mendoza', 900),
('11-2', 'Rodrigo', 'Alberto', 'Jiménez', 'Núñez', 1800),
('12-2', 'Daniela', 'Fernanda', 'Pizarro', 'Araya', 2200),
('13-2', 'Antonio', 'Miguel', 'Soto', 'Vergara', 1100),
('14-2', 'Camila', 'Victoria', 'Bravo', 'Miranda', 1400),
('15-2', 'José', 'Miguel', 'Díaz', 'Lagos', 1700),
('16-2', 'Mariana', 'Ignacia', 'Fuentes', 'Ortiz', 2100),
('17-2', 'Felipe', 'Andrés', 'Ramos', 'Espinoza', 1300),
('18-2', 'Constanza', 'Belén', 'Cruz', 'Valenzuela', 1900),
('19-2', 'Sebastián', 'Matías', 'Guerrero', 'Medina', 2400),
('20-2', 'Victoria', 'Catalina', 'Romero', 'Navarro', 2800);

-- Insertar VENTA (40 registros)
INSERT INTO venta VALUES
(1, '1-2', '2-1', '2024-01-01', 15000),
(2, '2-2', '2-1', '2024-01-01', 25000),
(3, '3-2', '6-1', '2024-01-02', 18000),
(4, '4-2', '8-1', '2024-01-02', 32000),
(5, '5-2', '10-1', '2024-01-03', 45000),
(6, '6-2', '13-1', '2024-01-03', 28000),
(7, '7-2', '17-1', '2024-01-04', 19000),
(8, '8-2', '2-1', '2024-01-04', 22000),
(9, '9-2', '6-1', '2024-01-05', 33000),
(10, '10-2', '8-1', '2024-01-05', 41000),
(11, '11-2', '10-1', '2024-01-06', 27000),
(12, '12-2', '13-1', '2024-01-06', 36000),
(13, '13-2', '17-1', '2024-01-07', 29000),
(14, '14-2', '2-1', '2024-01-07', 44000),
(15, '15-2', '6-1', '2024-01-08', 23000),
(16, '16-2', '8-1', '2024-01-08', 31000),
(17, '17-2', '10-1', '2024-01-09', 38000),
(18, '18-2', '13-1', '2024-01-09', 26000),
(19, '19-2', '17-1', '2024-01-10', 34000),
(20, '20-2', '2-1', '2024-01-10', 42000),
(21, '1-2', '6-1', '2024-01-11', 21000),
(22, '2-2', '8-1', '2024-01-11', 37000),
(23, '3-2', '10-1', '2024-01-12', 43000),
(24, '4-2', '13-1', '2024-01-12', 24000),
(25, '5-2', '17-1', '2024-01-13', 35000),
(26, '6-2', '2-1', '2024-01-13', 28000),
(27, '7-2', '6-1', '2024-01-14', 39000),
(28, '8-2', '8-1', '2024-01-14', 22000),
(29, '9-2', '10-1', '2024-01-15', 46000),
(30, '10-2', '13-1', '2024-01-15', 33000),
(31, '11-2', '17-1', '2024-01-16', 27000),
(32, '12-2', '2-1', '2024-01-16', 41000),
(33, '13-2', '6-1', '2024-01-17', 25000),
(34, '14-2', '8-1', '2024-01-17', 36000),
(35, '15-2', '10-1', '2024-01-18', 44000),
(36, '16-2', '13-1', '2024-01-18', 29000),
(37, '17-2', '17-1', '2024-01-19', 32000),
(38, '18-2', '2-1', '2024-01-19', 38000),
(39, '19-2', '6-1', '2024-01-20', 45000),
(40, '20-2', '8-1', '2024-01-20', 31000);