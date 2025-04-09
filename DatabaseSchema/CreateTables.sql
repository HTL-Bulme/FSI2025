/* Hier kommen alle Create Table Statements her
 Vorsicht: SQLite Datentypen sind beschränkt auf:
 https://sqlite.org/stricttables.html*/

CREATE TABLE IF NOT EXISTS ITEM (
    itemId TEXT PRIMARY KEY,
    name TEXT,
    itemLength INTEGER,
    itemWidth INTEGER,
    itemHeight INTEGER
) STRICT;

CREATE TABLE IF NOT EXISTS STOLOC (
    stoLocId TEXT PRIMARY KEY,
    pickSequence INTEGER
) STRICT;

ALTER TABLE ITEM ADD COLUMN pickingStoLoc TEXT REFERENCES STOLOC(stoLocId);