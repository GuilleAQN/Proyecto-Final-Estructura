/* schema datos Tabla de empleados */

INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('1010', 'jose', 'dilone', '00144545614', 'caobas segunda', '1', '40000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10101', 'roberto', 'pastoriza', '00124568786', 'Gazcue', '1', '12000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10102', 'Fausto', 'Molina', '00412846947', 'Los Canelos', '1', '145000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10103', 'Felipe', 'De La Cruz', '00155684265', 'Ciudad Colonial', '1', '80000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10104', 'Fausto', 'Dilochamps', '00455668426', 'Herrera', '0', '17500');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10105', 'Karla', 'Batista', '00124664789', 'Ensanche la Fe', '0', '22500');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10106', 'Camila', 'Guerrero', '00156794228', 'Costa Verde', '1', '30000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10107', 'Loreilly', 'De la Rosa', '00479985321', 'Villas Agricolas', '1', '45000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10108', 'Elianny', 'Reyes', '00145453658', 'Los Canelos', '1', '70850');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10109', 'Angel', 'Arache', '00178965523', 'San Geronimo', '1', '12000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10110', 'Joan', 'Germiliano', '00144456266', 'Sam Carlos', '0', '100000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10111', 'Zoe', 'Cuevas', '00144455688', 'Ciudad Real I', '0', '40000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10112', 'Natalia', 'LLanos', '00134456876', 'Piantini, Apt. Maria III', '0', '45000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10113', 'Sebastian', 'Santana', '00146520035', 'Las caobas, Calle 1ra', '1', '45100');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10114', 'Enmanuel', 'De la Rosa', '00164893222', 'Los banquitos', '1', '70000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10115', 'Lucas', 'Cruz', '00722626315', 'Alamo II', '1', '60000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10116', 'Mayelin', 'Carrion', '00823366151', 'Naco, Apt. Matiasel', '1', '50000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10117', 'Marisol', 'Corripio', '00922320045', 'Caobas 2da, Calle 2da', '0', '55000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10118', 'Jimmy', 'Gonzalez', '00195632414', 'Ciudad Real II', '1', '35000');
INSERT INTO "main"."empleados" ("id_empleado", "nombre", "apellido", "cedula", "direccion", "estado", "salario_bruto") VALUES ('10119', 'Natalia', 'Bido', '00135584268', 'Prog. 27 de febrero, Ciudad Agraria', '1', '120000');

/* schema datos Tabla de usuarios */

INSERT INTO "main"."usuarios" ("nombre", "contraseña") VALUES ('admin', 'root');

/* shema datos Tabla de volantes */

INSERT INTO "main"."volante" ("titulo", "descripcion", "codigo_empleado") VALUES ('titulo', 'descripcion', '1010');
INSERT INTO "main"."volante" ("titulo", "descripcion", "codigo_empleado") VALUES ('titulo 2', 'descripcion 2', '10107');

