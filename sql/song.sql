USE rmcdb;

CREATE TABLE `song` (
  `ID` 			int		 	 NOT NULL AUTO_INCREMENT,
  `name` 		varchar(30)  NOT NULL,
  `duration` 	int			 NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_SONG_NAME` (`name`)
);
COMMIT;