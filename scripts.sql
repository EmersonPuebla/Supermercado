-- CREDENCIALES
-- username /// password
-- Cristian ==> Un2PalLibro 
-- Luis     ==> Serj67 
-- Emerson  ==> PanConQueso123 
-- Joaquin  ==> MostBimural8
-- Martin   ==> Martin1990
-- Catalina ==> Guiyu11
-- Alan     ==> Fish2002 
-- Susana   ==> PqSiempr3Yo

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
    username VARCHAR(50) NOT NULL,
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
	rut_vendedor VARCHAR(10) NOT NULL,
	fecha_venta DATE NOT NULL,
	metodo_pago VARCHAR(15) NOT NULL,
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
	id_venta INTEGER NOT NULL,
	id_producto INTEGER NOT NULL,
	cantidad INTEGER NOT NULL,
	precio_unitario INTEGER NOT NULL,
	descuento INTEGER DEFAULT 0 NOT NULL,
	
	PRIMARY KEY (id_venta, id_producto),
	FOREIGN KEY (id_venta) REFERENCES venta(id_venta),
	FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- SOLO SI QUEDA TIEMPO
-- Crear tabla DEVOLUCION
-- CREATE TABLE IF NOT EXISTS devolucion (
-- id_devolución INTEGER PRIMARY KEY,
-- id_venta INTEGER NOT NULL,
-- fecha_devolucion DATE NOT NULL,
-- monto INTEGER NOT NULL, 
-- FOREIGN KEY (id_venta) REFERENCES venta(id_venta)
-- );

-- Crear tabla DEVOLUCION_PRODUCTO
-- CREATE TABLE IF NOT EXISTS devolucion_producto (
-- id_devolucion INTEGER NOT NULL,
-- id_producto INTEGER NOT NULL,
-- cantidad INTEGER NOT NULL,
-- precio_unitario INTEGER NOT NULL,
-- descuento INTEGER DEFAULT 0 NOT NULL,
-- 
-- PRIMARY KEY (id_devolucion, id_producto),
-- FOREIGN KEY (id_devolucion) REFERENCES devolucion(id_devolucion),
-- FOREIGN KEY (id_producto) REFERENCES producto(id_producto)	
-- );
-- 

-- NUEVO CONTENIDO TABLAS (Basado en la rubrica)
-- Insertar 10 registros CLIENTE ✓✓
-- Insertar  5 registros EMPLEADO (usuarios === EMPLEADO) ✓✓
-- Insertar 20 registros PRODUCTO ✓✓
-- Insertar 10 registros VENTA
-- Insertar registros VENTA_PRODUCTO por cada venta (detalle venta === VENTA_PRODUCTO)

-- Insertar 10 registros CLIENTE
INSERT INTO cliente VALUES
-- RUT/ 1rNombre/    2doNombre/ 1rApellido/ 2doApellido/ Puntos
('0-1', 'Pedro',     'Juan',    'Martínez', 'García',    1000),
('0-2', 'Sofía',     'Elena',   'López',    'Rodríguez', 1500),
('0-3', 'Manuel',    'José',    'Pérez',    'Fernández', 2000),
('0-4', 'Isabel',    'María',   'Gómez',    'Morales',    500),
('0-5', 'Andrés',    'Felipe',  'Torres',   'Silva',     3000),
('0-6', 'Laura',     'Cristina','Ramírez',  'Vargas',    1200),
('0-7', 'Gabriel',   'Eduardo', 'Castro',   'Muñoz',      800),
('0-8', 'Valentina', 'Andrea',  'Reyes',    'Herrera',   1600),
('0-9', 'Francisco', 'Javier',  'Morales',  'Flores',    2500),
('1-1', 'Catalina',  'Paz',     'Vega',     'Mendoza',    900),
-- X
('1-2', 'Rodrigo',  'Alberto', 'Jiménez',  'Núñez',     1800),
('1-3', 'Daniela',  'Fernanda','Pizarro',  'Araya',     2200),
('1-4', 'Antonio',  'Miguel',  'Soto',     'Vergara',   1100),
('1-5', 'Camila',   'Victoria','Bravo',    'Miranda',   1400),
('1-6', 'José',     'Miguel',  'Díaz',     'Lagos',     1700),
('1-7', 'Mariana',  'Ignacia', 'Fuentes',  'Ortiz',     2100),
('1-8', 'Felipe',   'Andrés',  'Ramos',    'Espinoza',  1300),
('1-9', 'Constanza','Belén',   'Cruz',     'Valenzuela',1900),
('2-1', 'Sebastián','Matías',  'Guerrero', 'Medina',    2400),
('2-2', 'Victoria', 'Catalina','Romero',   'Navarro',   2800);


-- Insertar 5 registros Empleado 
INSERT INTO empleado VALUES 
-- RUT/ 1rNombre/   2do Nombre/ 1rApellido / 2doApellido/ username/      password/                                                           AdminEm/ Reporte/ Caja/  Bodega/   Habilitado?
('1-0', 'Cristian', 'Orlando',  'Garcia',   'Gutierrez',  'cgarcia',     'bfc8782c3b9efaf7bdb0363b5f5c92835510ef858de5c59133eb05570ba35dbd', true,    true,    true,   true,    true),
('2-0', 'Luis',     'Antonio',  'Alvarez',  'Requejo',    'lalvarez',    'cb9902e2db5b287fcd53344ded42a79f7bd2271f5488d876851cc80886408737', false,   true,    false, false,    true),
('3-0', 'Emerson',  'Flavio',   'Puebla',   'Diaz',       'epuebla',     '9861f2f84d77de92617b630913481d8baf70b6c4cf1fb1724eb56f59b890823e', false,   false,   true,  false,    true),
('4-0', 'Joaquin',  'Andres',   'Gonzales', 'Soto',       'jgonzales',   '6422005f97e32c218f04bea4d8639cafb15e3c540221e8bef869e014d73a5e18', false,   false,   true,  false,    true),
('5-0', 'Martin',   'Ignacio',  'Perez',    'Rojas',      'mperez',      '5f647d5bbbe7e377ac0ded9c78079af3cf6a1c52bac7413c39b266b8fb66a5e3', false,   false,   true,  false,    true),
('6-0', 'Catalina', 'Fernanda', 'Silva',    'Herrera',    'csilva',      '530485f3357ecc94d2dd5ac0496d43527b8821003787d02edc9fcc6c592f209d', false,   false,   true,  false,   false),
('7-0', 'Alan',     'Alexander','Pinto',    'Ureta',      'apinto',      '9ebed9eec702a7cdf6aca0e9ab37bdc54008785c26098e92fe1aae9a6953bcbd', false,   false,   false, true,     true),
('8-0', 'Susana',   'Paz',      'Cruz',     'Valenzuela', 'svalenzuela', 'e3412ae3150fae62da63443bc0fa9525c843771a4c187cfaddb6ce67b31762ff', false,   false,   false, false,   false);

-- Insertar 20 registros PRODUCTO 
INSERT INTO producto VALUES
-- ID/ Nombre/            Marca/            Medida/ U.Medida/ Precio/ Stock/ Descuento
(1,    'Arroz',           'Tucapel',        1000,   'gr',     1290,   100,   0),
(2,    'Aceite',          'Chef',           1000,   'ml',     2490,    80,  10),
(3,    'Azúcar',          'Iansa',          1000,   'gr',      990,   150,   0),
(4,    'Leche',           'Colun',          1000,   'ml',     1190,   200,   5),
(5,    'Fideos',          'Carozzi',         400,   'gr',      890,   120,   0),
(6,    'Atún',            'Robinson Crusoe', 170,   'gr',     1690,    90,  15),
(7,    'Café',            'Nescafé',         170,   'gr',     4990,    60,   0),
(8,    'Sal',             'Lobos',          1000,   'gr',      690,   100,   0),
(9,    'Mantequilla',     'Soprole',         250,   'gr',     2290,    80,  10),
(10,   'Huevos',          'Yemita',           12,    'u',     2990,   150,   0),
(11,   'Pan Molde',       'Ideal',           500,   'gr',     1990,   100,   5),
(12,   'Yogurt',          'Colun',          1000,   'ml',     1890,   120,   0),
(13,   'Queso',           'Soprole',         250,   'gr',     2890,    70,   0),
(14,   'Jamón',           'PF',              200,   'gr',     2190,    60,  10),
(15,   'Salsa Tomate',    'Malloa',          200,   'gr',      990,   100,   0),
(16,   'Mayonesa',        'Hellmanns',       500,   'gr',     2490,    90,   5),
(17,   'Detergente',      'Omo',            3000,   'gr',     5990,    80,  15),
(18,   'Papel Higiénico', 'Confort',          12,    'u',     4990,   150,  10),
(19,   'Jabón',           'Dove',             90,   'gr',      990,   100,   0),
(20,   'Shampoo',         'Head&Shoulders',  400,   'ml',     3990,    70,   0),
-- X
(21,   'Pasta Dental',    'Colgate',          90, 'gr',       1990,   120,   5),
(22,   'Cerveza',         'Cristal',         350, 'ml',        890,   200,   0),
(23,   'Bebida',          'Coca-Cola',      1500, 'ml',       1690,   180,  10),
(24,   'Jugo',            'Watts',          1500, 'ml',       1290,   150,   0),
(25,   'Galletas',        'Costa',           140, 'gr',        990,   100,   0),
(26,   'Chocolate',       'Trencito',        150, 'gr',       1490,    80,   5),
(27,   'Papas Fritas',    'Lays',            180, 'gr',       1890,    90,   0),
(28,   'Helado',          'Savory',         1000, 'ml',       4990,    60,  15),
(29,   'Cereales',        'Nestlé',          500, 'gr',       2990,    70,   0),
(30,   'Mermelada',       'Watts',           250, 'gr',       1490,    80,   0),
(31,   'Manteca',         'Astra',           250, 'gr',       1290,   100,   5),
(32,   'Harina',          'Selecta',        1000, 'gr',        990,   150,   0),
(33,   'Té',              'Supremo',          20,  'u',       1190,   120,   0),
(34,   'Lenteja',         'Banquete',       1000, 'gr',       1890,    90,  10),
(35,   'Porotos',         'Banquete',       1000, 'gr',       1990,    80,   0),
(36,   'Garbanzos',       'Banquete',       1000, 'gr',       1990,    70,   5),
(37,   'Servilletas',     'Noble',           100,  'u',        990,   200,   0),
(38,   'Lavaloza',        'Quix',            750, 'ml',       1890,   100,  15),
(39,   'Cloro',           'Clorox',         1000, 'ml',       1490,   120,   0),
(40,   'Esponjas',        'Virutex',           3,  'u',        890,   150,   0),
(41,   'Tortillas XL',    'PANCHO VILLA',     10,  'u',       3990,    70,   0);

-- Insertar 10 registros VENTA
INSERT INTO venta VALUES 
-- ID/ Cliente/ Vendedor/  YYYY-MM-DD/  MetodoPago/ Monto
(1,    '0-5',   '3-0',    '2024-01-18', 'Debito',   11871),
(2,    '1-4',   '5-0',    '2024-01-19', 'Efectivo',  7180),
(3,    '0-2',   '6-0',    '2024-01-19', 'Debito',    5242),
(4,    '2-1',   '6-0',    '2024-01-20', 'Credito',   3411),
(5,    '1-3',   '4-0',    '2024-01-20', 'Efectivo',  3206),

(6,    '1-4',     '3-0',    '2024-01-21', 'Debito',    1980),
(7,    '1-5',     '5-0',    '2024-01-21', 'Debito',    7232),
(8,    '1-7',     '6-0',    '2024-01-22', 'Credito',   7111),
(9,    '1-8',     '4-0',    '2024-01-22', 'Efectivo',  6809‬),
(10,   '1-4',     '3-0',    '2024-01-22', 'Efectivo',  1290);

-- Insertar registros VENTA_PRODUCTO por cada venta
INSERT INTO venta_producto VALUES
-- id_venta/ id_producto/ Cantidad/ Precio/ Descuento
(1, 21, 5, 1990, 5),
(1, 20, 2, 3990, 0),
(1, 17, 1, 5990, 0),

(2, 7,  1, 4990, 0),
(2, 14, 1, 2190, 10),

(3, 11, 1, 1990, 5),
(3, 9,  1, 2290, 10),
(3, 24, 1, 1290, 0),

(4, 23, 1, 1690, 10),
(4, 27, 2, 1890, 0),

(5, 31, 1, 1290, 5),
(5, 32, 2, 990, 0),

(6, 19, 2, 1980, 0),

(7, 28, 1, 4990, 15),
(7, 30, 1, 2990, 0),

(8, 3, 1, 990, 0),
(8, 4, 1, 1190, 5),
(8, 7, 1, 4990, 0),

(9, 2, 2, 2490, 10),
(9, 5, 1, 890, 0),
(9, 6, 1, 1690, 15),  

(10, 24, 1, 1290, 0);