CREATE DEFINER=`appcont`@`%` PROCEDURE `listCuenta`()
BEGIN
 DECLARE cursor1 CURSOR FOR Select * from Cuentas where EmpresaId = 199 and Nivel = 1
order BY CuentaCod ASC;
OPEN cursor1;

bucle: LOOP
SELECT CuentaCod from Cuentas;
END LOOP bucle;

CLOSE cursor1;
END