set path=%path%;C:\Program Files\MySQL\MySQL Server 5.5\bin

mysql -h localhost -uroot -p2014NewLife < create.sql
mysql -h localhost -uroot -p2014NewLife < drop.sql
mysql -h localhost -uroot -p2014NewLife < song.sql
mysql -h localhost -uroot -p2014NewLife < album.sql
mysql -h localhost -uroot -p2014NewLife < album_song.sql

mysql -h localhost -uroot -p2014NewLife < insert_song.sql
mysql -h localhost -uroot -p2014NewLife < insert_album.sql

pause