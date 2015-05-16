DROP TABLE ACCOUNT; DROP TABLE BOOK_STOCK; DROP TABLE BOOK;

CREATE TABLE BOOK (
    ISBN         VARCHAR(50)    NOT NULL,
    BOOK_NAME    VARCHAR(100)   NOT NULL,
    PRICE        INT,
    PRIMARY KEY (ISBN)
);

CREATE TABLE BOOK_STOCK (
    ISBN     VARCHAR(50)    NOT NULL,
    STOCK    INT            NOT NULL,
    PRIMARY KEY (ISBN)
);

CREATE TABLE ACCOUNT (
    USERNAME    VARCHAR(50)    NOT NULL,
    BALANCE     INT            NOT NULL,
    PRIMARY KEY (USERNAME)
);

DELIMITER $$
CREATE TRIGGER `test_before_BOOK_STOCK_update` BEFORE UPDATE ON `BOOK_STOCK`
FOR EACH ROW
BEGIN
    IF NEW.STOCK < 0 THEN
        signal sqlstate '45000' set message_text = "MyTriggerError: Trying to insert a negative value in test_before_BOOK_STOCK_update: ";
    END IF;
END$$
CREATE TRIGGER `test_before_ACCOUNT_update` BEFORE UPDATE ON `ACCOUNT`
FOR EACH ROW
BEGIN
declare msg varchar(255);
    IF NEW.BALANCE < 0 THEN
        signal sqlstate '45000' set message_text = "MyTriggerError: Trying to insert a negative value in test_before_ACCOUNT_update: ";
    END IF;
END$$
DELIMITER ;

INSERT INTO BOOK( ISBN, BOOK_NAME, PRICE ) VALUES( '0001', 'The First Book', 30);
INSERT INTO BOOK_STOCK(ISBN, STOCK) VALUES('0001', 10) ;
INSERT INTO ACCOUNT(USERNAME, BALANCE) VALUES('user1',20);
