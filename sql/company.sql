USE rmcdb;

DROP TABLE IF EXISTS PRODUCT;
DROP TABLE IF EXISTS COMPANY	;

CREATE TABLE `COMPANY` (
  `NAME`	 	varchar(30) NOT NULL,
  `ID` 			bigint(20) 	NOT NULL AUTO_INCREMENT,
  `phone` 		varchar(12) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `UK_COMPANY_ID` (`NAME`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 
;
COMMIT;