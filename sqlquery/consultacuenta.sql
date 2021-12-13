SELECT  t1.CuentaCod  AS lev1CuentaCod, t1.CuentaDes 
AS lev1CuentaDes, 
t2.CuentaCod as lev2CuentaCod,
t2.CuentaDes as lev2CuentaDes,
t3.CuentaCod as lev3CuentaCod,
t3.CuentaDes as lev3CuentaDes, 
t4.CuentaCod as lev4CuentaCod,
t4.CuentaDes as lev4CuentaDes,
t5.CuentaCod as lev5CuentaCod,
t5.CuentaDes as lev5CuentaDes,
t6.CuentaCod as lev6CuentaCod,
t6.CuentaDes as lev6CuentaDes	
FROM Cuentas AS t1
LEFT JOIN Cuentas AS t2 ON t2.CuentaPadre = t1.CuentaCod
LEFT JOIN Cuentas AS t3 ON t3.CuentaPadre = t2.CuentaCod
LEFT JOIN Cuentas AS t4 ON t4.CuentaPadre = t3.CuentaCod
LEFT JOIN Cuentas AS t5 ON t5.CuentaPadre = t4.CuentaCod
LEFT JOIN Cuentas AS t6 ON t6.CuentaPadre = t5.CuentaCod
WHERE t1.CuentaCod = 1
order by t1.CuentaCod, t2.CuentaCod, t3.CuentaCod,t4.CuentaCod,t5.CuentaCod,t6.CuentaCod ASC;
