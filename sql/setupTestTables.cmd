set path=%path%;C:\Program Files\MySQL\MySQL Server 5.5\bin

mysql -h localhost -uroot -p2014NewLife < company.sql
mysql -h localhost -uroot -p2014NewLife < product.sql

mysql -h localhost -uroot -p2014NewLife < insert_company_product.sql

pause