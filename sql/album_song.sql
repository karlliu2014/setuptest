USE rmcdb;

CREATE TABLE `album_song` (
  `albumId` 	int	NOT NULL,
  `songId` 		int NOT NULL,
  PRIMARY KEY (`albumId`,`songId`),
  KEY `FK_SONG` (`songId`),
  CONSTRAINT `FK_SONG` FOREIGN KEY (`songId`) REFERENCES `song` (`id`) ON DELETE CASCADE,
  KEY `FK_ALBUM` (`albumId`),
  CONSTRAINT `FK_ALBUM` FOREIGN KEY (`albumId`) REFERENCES `album` (`id`) ON DELETE CASCADE
);
COMMIT;