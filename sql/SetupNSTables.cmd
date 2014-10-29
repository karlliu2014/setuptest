set path=%path%;C:\Program Files\MySQL\MySQL Server 5.5\bin

mysql -h localhost -uroot -p2014NewLife < ns.sql
mysql -h localhost -uroot -p2014NewLife < insert_ns.sql
mysql -h localhost -uroot -p2014NewLife < exec_ns.sql

pause