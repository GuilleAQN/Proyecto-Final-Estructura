/*Schema de la base de datos por tabla */

/* Tabla de empleados */
CREATE TABLE "empleados" (
	"id_empleado"	INTEGER NOT NULL UNIQUE,
	"nombre"	VARCHAR(40) NOT NULL,
	"apellido"	VARCHAR(40) NOT NULL,
	"cedula"	VARCHAR(11) NOT NULL,
	"direccion"	id_empleadoVARCHAR(100),
	"estado"	INT NOT NULL,
	"salario_bruto"	INT NOT NULL,
	"date_time"	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY("id_empleado")
);

/* Tabla de usuarios */
CREATE TABLE "usuarios" (
	"id_usuario"	INT NOT NULL UNIQUE,
	"nombre"	VARCHAR(40) NOT NULL,
	"contraseña"	VARCHAR(10) NOT NULL,
	"date_time"	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY("id_usuario")
);

/* Tabla de volantes */
CREATE TABLE "volante" (
	"id_volante"	INTEGER,
	"titulo"	VARCHAR(100) NOT NULL,
	"descripcion"	TEXT NOT NULL,
	"codigo_empleado"	INT,
	"date_time"	TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	FOREIGN KEY("codigo_empleado") REFERENCES "empleados"("id_empleado"),
	PRIMARY KEY("id_volante" AUTOINCREMENT)
);
