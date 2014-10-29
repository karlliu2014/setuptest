USE rmcdb;

SELECT ID INTO @songId FROM SONG WHERE name = 'Dvorak Rusalka';
SELECT ID INTO @albumId FROM ALBUM WHERE title = 'Dvorak Opera';
INSERT INTO album_song (albumId, songId)VALUES (@albumId,@songId);

SELECT ID INTO @songId FROM SONG WHERE name = 'Danny Boy';
SELECT ID INTO @albumId FROM ALBUM WHERE title = 'Dvorak Opera';
INSERT INTO album_song (albumId, songId)VALUES (@albumId,@songId);

SELECT ID INTO @songId FROM SONG WHERE name = 'Panis Angilecus';
SELECT ID INTO @albumId FROM ALBUM WHERE title = "Pavarotti's best";
INSERT INTO album_song (albumId, songId)VALUES (@albumId,@songId);

SELECT ID INTO @songId FROM SONG WHERE name = 'O Holy Night';
SELECT ID INTO @albumId FROM ALBUM WHERE title = "Pavarotti's best";
INSERT INTO album_song (albumId, songId)VALUES (@albumId,@songId);

COMMIT;