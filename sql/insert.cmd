set path=%path%;C:\Program Files\MySQL\MySQL Server 5.5\bin

mysql -h localhost -uroot -p2014NewLife < delete.sql
mysql -h localhost -uroot -p2014NewLife < insert_song.sql
mysql -h localhost -uroot -p2014NewLife < insert_album.sql
pause