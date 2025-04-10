CREATE TABLE IF NOT EXISTS STOLOC (
    stoLocId CHAR(18) PRIMARY KEY,
    pickSequence INTEGER
);

CREATE TABLE IF NOT EXISTS CUSTOMER (
    customerId CHAR(13) PRIMARY KEY,
    allowedLuType CHAR(10)
);

CREATE TABLE IF NOT EXISTS ITEM (
    itemId CHAR(12) PRIMARY KEY,
    name CHAR(40),
    'length' INTEGER,
    width INTEGER,
    height INTEGER,
    pickingStoLoc CHAR(18),
    FOREIGN KEY (pickingStoLoc) REFERENCES STOLOC(stoLocId)
);

CREATE TABLE IF NOT EXISTS USER (
    userId CHAR(10) PRIMARY KEY,
    name CHAR(40)
);

CREATE TABLE IF NOT EXISTS OUTBOUNDORDER (
    orderId CHAR(10) PRIMARY KEY,
    pickingOrderId INTEGER,
    state TEXT CHECK(state IN ('NEU', 'AKTIV', 'FERTIG')),
    customerId CHAR(13),
    deliveryTime DATETIME,
    FOREIGN KEY (customerId) REFERENCES CUSTOMER(customerId)
);

CREATE TABLE IF NOT EXISTS OBO_LINE (
    orderId CHAR(10),
    lineNumber INTEGER,
    itemId CHAR(12),
    orderAmount INTEGER,
    deliveryAmount INTEGER,
    PRIMARY KEY (orderId, lineNumber),
    FOREIGN KEY (orderId) REFERENCES OUTBOUNDORDER(orderId),
    FOREIGN KEY (itemId) REFERENCES ITEM(itemId)
);

CREATE TABLE IF NOT EXISTS PICKINGORDER (
    pickingOrderId INTEGER PRIMARY KEY,
    status TEXT CHECK(status IN ('NEU', 'AKTIV', 'KOMM', 'FERTIG')),
    currentUser CHAR(10),
    startTime DATETIME,
    finishTime DATETIME,
    customerId CHAR(13),
    deliveryTime DATETIME,
    FOREIGN KEY (currentUser) REFERENCES USER(userId),
    FOREIGN KEY (customerId) REFERENCES CUSTOMER(customerId)
);

CREATE TABLE IF NOT EXISTS PICKINGORDER_LINE (
    pickingOrderId INTEGER,
    lineNumber INTEGER,
    status TEXT CHECK(status IN ('NEU', 'AKTIV', 'KOMM', 'FERTIG')),
    pickSequence INTEGER,
    stoLocId CHAR(18),
    itemId CHAR(12),
    itemName CHAR(40),
    orderAmount INTEGER,
    bookingAmount INTEGER,
    targetLuId CHAR(18),
    targetStockObject INTEGER,
    PRIMARY KEY (pickingOrderId, lineNumber),
    FOREIGN KEY (pickingOrderId) REFERENCES PICKINGORDER(pickingOrderId),
    FOREIGN KEY (stoLocId) REFERENCES STOLOC(stoLocId),
    FOREIGN KEY (itemId) REFERENCES ITEM(itemId)
);

CREATE TABLE IF NOT EXISTS LOADINGUNIT (
    luId CHAR(18) PRIMARY KEY,
    stoLocId CHAR(18),
    luType CHAR(10),
    FOREIGN KEY (stoLocId) REFERENCES STOLOC(stoLocId)
);

CREATE TABLE IF NOT EXISTS STOCKOBJECT (
    luId CHAR(18),
    stockObjectNumber INTEGER,
    itemId CHAR(12),
    itemName CHAR(40),
    amount INTEGER,
    PRIMARY KEY (luId, stockObjectNumber),
    FOREIGN KEY (luId) REFERENCES LOADINGUNIT(luId),
    FOREIGN KEY (itemId) REFERENCES ITEM(itemId)
);

CREATE TABLE IF NOT EXISTS PERFTRACK (
    perfTrackId INTEGER PRIMARY KEY,
    trackTime DATETIME,
    pickOrderId INTEGER,
    userId CHAR(10),
    pickCount INTEGER,
    duration INTEGER,
    FOREIGN KEY (pickOrderId) REFERENCES PICKINGORDER(pickingOrderId),
    FOREIGN KEY (userId) REFERENCES USER(userId)
);
