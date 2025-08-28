-- Crear la base de datos
CREATE DATABASE Ecos;
USE Ecos;

-- Tabla Cliente
CREATE TABLE Cliente (
    idCliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(150),
    telefonos VARCHAR(50)
);

-- Tabla Problema
CREATE TABLE Problema (
    idProblema INT AUTO_INCREMENT PRIMARY KEY,
    fch_ini DATE NOT NULL,
    fch_fin DATE,
    estado ENUM('pendiente','concluido','cancelado') NOT NULL,
    idCliente INT NOT NULL,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente)
);

-- Tabla Activista
CREATE TABLE Activista (
    idActivista INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(50),
    fchIngreso DATE NOT NULL
);

-- Tabla intermedia Problema_Activista (NM)
CREATE TABLE Problema_Activista (
    idProblema INT NOT NULL,
    idActivista INT NOT NULL,
    PRIMARY KEY (idProblema, idActivista),
    FOREIGN KEY (idProblema) REFERENCES Problema(idProblema),
    FOREIGN KEY (idActivista) REFERENCES Activista(idActivista)
);



-- Ejercicio 1

-- Inserta 3 clientes, 2 activistas y 3 problemas con los datos que tu consideres apropiados.
INSERT INTO Cliente (nombre, direccion, telefonos) VALUES
('Pedro Picapiedra', 'Av. Roca #123, Piedradura', '555-1111'),
('Vilma Picapiedra', 'Av. Roca #123, Piedradura', '555-2222'),
('Pablo Marmol', 'Av. Hueso #456, Piedradura', '555-3333');

INSERT INTO Activista (nombre, telefono, fchIngreso) VALUES
('Gatubela', '555-4444', '2023-01-15'),
('Robin', '555-5555', '2024-02-20');

INSERT INTO Problema (fch_ini, fch_fin, estado, idCliente) VALUES
('2024-03-01', NULL, 'pendiente', 1),
('2024-04-10', '2024-04-20', 'concluido', 2),
('2024-05-15', NULL, 'cancelado', 3);

-- Asocia a los activistas con los problemas
INSERT INTO Problema_Activista (idProblema, idActivista) VALUES
(1, 1),
(2, 2);

-- Actualiza los clientes para que uno se llame John Wick y otro Tony Stark.
UPDATE Cliente SET nombre = 'John Wick' WHERE idCliente = 1;
UPDATE Cliente SET nombre = 'Tony Stark' WHERE idCliente = 2;


-- Actualiza los activistas para que uno se llame Bruce Wayne y su teléfono sea 55412355.
UPDATE Activista SET nombre = 'Bruce Wayne', telefono = '55412355' WHERE idActivista = 1;


-- Actualiza los problemas para que todos tengan fecha de este año.
UPDATE Problema SET fch_ini = '2024-01-01' WHERE idProblema = 1;
UPDATE Problema SET fch_ini = '2024-02-15' WHERE idProblema = 2;
UPDATE Problema SET fch_ini = '2024-03-20' WHERE idProblema = 3;


-- Inserta 1 problema para el cliente Bruce Wayne, fecha inicio el primer día del año en curso, estado pendiente.
INSERT INTO Cliente (nombre, direccion, telefonos) VALUES
('Bruce Wayne', 'Mansión Wayne', '123-456-7890');
SET @ultimoID = LAST_INSERT_ID();
INSERT INTO Problema (fch_ini, estado, idCliente) VALUES
(CURRENT_DATE(), 'pendiente', @ultimoID);


-- Inserta 1 problema para el cliente Bruce Wayne, periodo: la primera quincena de enero, estado concluido.
INSERT INTO Problema (fch_ini, fch_fin, estado, idCliente) VALUES
('2024-01-01', '2024-01-15', 'concluido', @ultimoID);

-- Consulta el nombre y teléfonos de los clientes que tengan al menos un problema registrado.
SELECT DISTINCT c.nombre, c.telefonos
FROM Cliente c
JOIN Problema p ON c.idCliente = p.idCliente;

-- Consulta a los activistas que están trabajando actualmente en un problema. Incluye los datos del activista y el nombre del problema.
SELECT a.nombre AS nombre_activista, a.telefono, p.idProblema
FROM Activista a
JOIN Problema_Activista pa ON a.idActivista = pa.idActivista
JOIN Problema p ON pa.idProblema = p.idProblema
WHERE p.estado = 'pendiente';

-- Consulta los problemas pendientes registrados en el mes de diciembre del 2022. Muestra los datos del problema y el nombre cliente. Además, muestra el número de días transcurridos desde la fecha de inicio.
SELECT
    p.idProblema,
    p.fch_ini,
    p.estado,
    c.nombre AS nombre_cliente,
    DATEDIFF(CURRENT_DATE(), p.fch_ini) AS dias_transcurridos
FROM Problema p
JOIN Cliente c ON p.idCliente = c.idCliente
WHERE p.estado = 'pendiente'
AND YEAR(p.fch_ini) = 2022
AND MONTH(p.fch_ini) = 12;
