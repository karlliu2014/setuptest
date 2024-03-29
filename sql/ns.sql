USE rmcdb;

DROP TABLE IF EXISTS SPRTELE;

CREATE TABLE `SPRTELE` (
  `SPRTELE_PIDM`             int(8) NOT NULL,
  `SPRTELE_ACTIVITY_DATE`    DATE NOT NULL,
  `SPRTELE_PHONE_NUMBER`     VARCHAR(12),
  `SPRTELE_STATUS_IND`       VARCHAR(1),
  `SPRTELE_ATYP_CODE`        VARCHAR(2)
  ) ENGINE=InnoDB DEFAULT CHARSET=latin1 
;
COMMIT;