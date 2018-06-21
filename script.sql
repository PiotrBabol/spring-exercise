CREATE TABLE `practicedatabase`.`person` (
  `person_id`  INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) CHARACTER SET ucs2
  COLLATE ucs2_polish_ci        NOT NULL,
  `last_name`  VARCHAR(45) CHARACTER SET ucs2
  COLLATE ucs2_polish_ci        NOT NULL,
  `age`        INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`person_id`(10))
)
  ENGINE = InnoDB
  CHARSET = ucs2
  COLLATE ucs2_polish_ci;