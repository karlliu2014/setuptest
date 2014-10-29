USE rmcdb;

CREATE TABLE `album` (
  `ID` 			int		 	 NOT NULL AUTO_INCREMENT,
  `title` 		varchar(30)  NOT NULL,
  `artist` 		varchar(30)  NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_TITLE` (`title`)
);
COMMIT;