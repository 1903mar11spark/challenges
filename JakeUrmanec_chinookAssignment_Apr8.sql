/* Start of homework assignment */

-- 2 SQL Queries --
-- 2.1 Select --
-- Task 1 Select all records from a table --

SELECT
    *
FROM 
    EMPLOYEE; 
    
-- Task 2 Select records from a table with constraints on one field --

SELECT 
    * 
FROM 
    EMPLOYEE
WHERE 
    LASTNAME = 'King'; 
    
-- Task 3 using AND operator with boolean expressions to filter the records returned --
/* IS NULL used insead of equality to construct a boolean expression*/

SELECT 
    * 
FROM 
    EMPLOYEE 
WHERE 
    FIRSTNAME = 'Andrew' AND REPORTSTO IS NULL; 

-- 2.2 ORDER BY --
-- Task one: sort by a field  -- 

SELECT 
    *
FROM 
    ALBUM 
ORDER BY 
    TITLE DESC; 
-- Task two: select one field from a table and sort results -- 

SELECT 
    FIRSTNAME
FROM 
    CUSTOMER 
ORDER BY 
    CITY ASC; 

-- 2.3 INSERT INTO -- 
-- Task 1: insert records into a table -- 

/* -- method one: where we specify each field before adding values -- 
INSERT INTO GENRE 
        (GENREID, NAME) 
VALUES 
        (26, 'New genre one'); 
INSERT INTO GENRE 
        (GENREID, NAME) 
VALUES 
        (26, 'New genre one'); 
*/

-- method two: we use insert all to say that we're filling all fields for the records -- 
/* we have to add the select from dual statement at the end with this method */ 
INSERT ALL 
INTO 
    GENRE 
VALUES 
    (26, 'Genre one')
INTO 
    GENRE 
VALUES 
    (27, 'Genre two')
SELECT * FROM DUAL;

-- Task 2: insert records into a table -- 

INSERT ALL 
INTO 
    EMPLOYEE 
VALUES 
    (9, 'Jones', 'Bob', 'IT Staff', NULL, '03-APR-1982', '03-APR-2019', '14501 Prism Circle', 'Tampa', 'FL','USA' , 'AAA BBB', '+1 (111) 111-1111', '+1 (211) 111-1111', 'jones@chinookcorp.com')
INTO 
    EMPLOYEE 
VALUES 
    (10, 'Jones', 'Jack', 'Software Developer', NULL, '04-APR-1982', '03-APR-2019', '14502 Prism Circle', 'Tampa', 'FL','USA' , 'AAA BBB', '+1 (111) 211-1111', '+1 (211) 211-1111', 'j.jones@chinookcorp.com')
SELECT * FROM DUAL;

INSERT ALL 
INTO 
    EMPLOYEE 
VALUES 
    (10, 'Jones', 'Jack', 'Software Developer', NULL, '04-APR-1982', '03-APR-2019', '14502 Prism Circle', 'Tampa', 'FL','USA' , 'AAA BBB', '+1 (111) 211-1111', '+1 (211) 211-1111', 'j.jones@chinookcorp.com')
SELECT * FROM DUAL;

UPDATE EMPLOYEE SET BIRTHDATE = TO_DATE('03-APR-1965','dd-mm-yy') WHERE EMPLOYEEID = 9; 
UPDATE EMPLOYEE SET BIRTHDATE = TO_DATE('03-APR-1967','dd-mm-yy') WHERE EMPLOYEEID = 10; 



-- Task 3: insert records into a table --
INSERT ALL 
INTO 
    CUSTOMER 
VALUES 
    (60, 'Jimmy', 'Johnson', 'Generic, Inc.','25 This St.', 'Springfield', 'FL', 'USA', 'AAA BBB','+1 (222) 111-1111', '+1 (222) 211-1111','j.johnson@gmail.com',3)
INTO 
    CUSTOMER 
VALUES 
    (61, 'Jane', 'Johnson', 'Generic, Inc.','25 This St.', 'Springfield', 'FL', 'USA', 'AAA BBB','+1 (222) 211-1111', '+1 (222) 311-1111','jane.johnson@gmail.com',4)
SELECT * FROM DUAL;

-- 2.4 Update -- 
-- Task 1: update a field in a record -- 
UPDATE 
    CUSTOMER
SET 
    FIRSTNAME = 'Robert', 
    LASTNAME = 'Walter'
WHERE 
    CUSTOMERID = 32; 
    
 -- Task 2: update a field in a record -- 
 
UPDATE 
    ARTIST
SET 
    NAME = 'CCR'
WHERE 
    ARTISTID = 76; 


--2.5 Like -- 
-- only task: select w/ wildcard -- 
SELECT 
    * 
FROM 
    INVOICE
WHERE 
    BILLINGADDRESS
LIKE 
    'T%'; 

-- 2.6 BETWEEN -- 
-- Task one: select w/ between -- 
SELECT 
    * 
FROM 
    INVOICE 
WHERE 
    TOTAL BETWEEN 15 AND 25; 

-- Task two -- 

SELECT 
    * 
FROM 
    EMPLOYEE 
WHERE 
    HIREDATE BETWEEN '01-JUN-03' AND '01-MAR-04'; 

-- 2.7 Delete -- 

DELETE FROM 
    INVOICELINE  
WHERE 
    INVOICEID = 50; 

DELETE FROM 
    INVOICE  
WHERE 
    CUSTOMERID = 32; 

DELETE FROM 
    CUSTOMER 
WHERE 
    CUSTOMERID = 32; 
   
----- 

SELECT DISTINCT INVOICEID FROM INVOICELINE WHERE INVOICEID NOT IN (
    SELECT INVOICEID FROM INVOICE); 
    
DELETE FROM 
    INVOICELINE 
WHERE 
    INVOICEID = 116; 
    
DELETE FROM 
    INVOICELINE 
WHERE 
    INVOICEID = 268; 
    
        
DELETE FROM 
    INVOICELINE 
WHERE 
    INVOICEID = 61; 
    
    
DELETE FROM 
    INVOICELINE 
WHERE 
    INVOICEID = 342; 
    
    
DELETE FROM -- DELETED with the GUI
    INVOICELINE 
WHERE 
    INVOICEID = 245; 
    
    
DELETE FROM -- DELETED with the GUI
    INVOICELINE 
WHERE 
    INVOICEID = 190; 

-- 3. SQL Functions -------
-- 3.1 System Defined Functions --- 
-- Task 1: function that returns the current time 
SELECT 
   CURRENT_TIMESTAMP
FROM
    DUAL; 

-- Task 2: function that returns the length of name in MEDIATYPE table --- 
/*
SELECT -- This snippet returns the names 
    NAME
FROM 
    MEDIATYPE 
*/
SELECT -- This snippet returns the length of each name including spaces. 
    LENGTH(NAME) "LENGTH IN CHARACTERS"
FROM 
    MEDIATYPE; 

-- 3.2 System Defined Aggregate Functions 
-- Task 1: function that returns the average total of all invoices 
SELECT
    AVG(TOTAL)
FROM 
    INVOICE; 

-- Task 2: function that returns the most expensive track 
SELECT 
    MAX(UNITPRICE) 
FROM 
    TRACK; 

-- 3.3 User Defined Scalar Funcitons 

CREATE OR REPLACE FUNCTION AVG_ILPRICE
RETURN NUMBER 
IS 
AVG_PRICE NUMBER(10,2); 
BEGIN 
    SELECT AVG(UNITPRICE) INTO AVG_PRICE
    FROM INVOICELINE; 
    RETURN AVG_PRICE; 
END; 
-- test of function VERSION 1 
EXECUTE DBMS_OUTPUT.PUT_LINE('OUTPUT TEST ' || AVG_ILPRICE); 
                                                                /*looks like the execute system is for functions 
                                                                but not for stored procedures */

-- 3.4 User Defined Table Valued Functions 
CREATE OR REPLACE FUNCTION YOUNG_EMPS
RETURN SYS_REFCURSOR 
IS S SYS_REFCURSOR;  

BEGIN 
    OPEN S FOR 
    SELECT (FIRSTNAME ||' '|| LASTNAME) NAME 
    FROM EMPLOYEE 
    WHERE BIRTHDATE >= '01-JAN-1969'; 
    RETURN S; 
END; 

-- Test for YOUNG_EMPS 
--EXECUTE DBMS_OUTPUT.PUT_LINE(YOUNG_EMPS); just for fun. didn't work 
DECLARE 
S SYS_REFCURSOR; 
SOME_EMP EMPLOYEE.FIRSTNAME%TYPE; 
BEGIN 
    S := YOUNG_EMPS; 
    LOOP 
    FETCH S INTO SOME_EMP; 
    EXIT WHEN S%NOTFOUND; 
    DBMS_OUTPUT.PUT_LINE('NAME ' || SOME_EMP); 
    END LOOP; 
    CLOSE S; 
END; 

--4.0 Stored Procedures 
--4.1 Basic Stored Procedures 
CREATE OR REPLACE PROCEDURE SP_FNLN(S OUT SYS_REFCURSOR) AS 
BEGIN
    OPEN S FOR 
    SELECT 
        (FIRSTNAME||' '||LASTNAME) 
    FROM EMPLOYEE;  
END; 

-- Test of first Stored Procedure 
DECLARE 
S SYS_REFCURSOR; 
SOME_EMP EMPLOYEE.FIRSTNAME%TYPE; 
BEGIN
    SP_FNLN(S); 
    LOOP 
    FETCH S INTO SOME_EMP; 
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(SOME_EMP); 
    END LOOP; 
    CLOSE S; 
END; 

-- 4.2 Stored Procedure Input Parameters 
-- Task 1 --- 
CREATE OR REPLACE PROCEDURE NAME_CHANGE(E_ID IN NUMBER, NEW_NAME IN EMPLOYEE.FIRSTNAME%TYPE) AS 
BEGIN 
    UPDATE EMPLOYEE
    SET FIRSTNAME = NEW_NAME
    WHERE EMPLOYEEID = E_ID; 
END; 

-- test for 4.2, task 1 --- 
DECLARE 
-- nothing to declare
BEGIN 
    NAME_CHANGE(9, 'Jake'); 
END; 

-- Task 2 --- 
CREATE OR REPLACE PROCEDURE SP_GET_MANAGERS(E_ID IN NUMBER,S OUT SYS_REFCURSOR) AS
BEGIN
    OPEN S FOR 
    SELECT 
        (E.FIRSTNAME||' '||E.LASTNAME) EMPLOYEE, 
        (M.FIRSTNAME||' '||M.LASTNAME) MANAGER 
    FROM EMPLOYEE E
    INNER JOIN EMPLOYEE M ON 
    E.REPORTSTO = M.EMPLOYEEID
    WHERE E.EMPLOYEEID = E_ID; 
END; 
-- Test for task two --- 
DECLARE 
S SYS_REFCURSOR; 
EMP_NAME EMPLOYEE.FIRSTNAME%TYPE; 
MAN_NAME EMPLOYEE.FIRSTNAME%TYPE;
BEGIN
    SP_GET_MANAGERS(8, S); 
    LOOP 
    FETCH S INTO EMP_NAME, MAN_NAME; 
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(EMP_NAME||' has '||MAN_NAME||' for a manager.'); 
    END LOOP; 
    CLOSE S; 
END; 

-- 4.3 SP to return the name and company of a customer. 

CREATE OR REPLACE PROCEDURE SP_GET_CUSTOMER(C_ID IN NUMBER,S OUT SYS_REFCURSOR) AS
BEGIN
    OPEN S FOR 
    SELECT 
        (C.FIRSTNAME||' '||C.LASTNAME) CUSTOMER, 
        C.COMPANY COMPANY
    FROM CUSTOMER C
    WHERE C.CUSTOMERID = C_ID; 
END; 

DECLARE 
S SYS_REFCURSOR; 
C_NAME CUSTOMER.FIRSTNAME%TYPE; 
C_COMP CUSTOMER.COMPANY%TYPE;
BEGIN
    SP_GET_CUSTOMER(5, S); 
    LOOP 
    FETCH S INTO C_NAME, C_COMP; 
    EXIT WHEN S%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(C_NAME||' is an associate of '||C_COMP||'.'); 
    END LOOP; 
    CLOSE S; 
END; 

--5.0 Transactions 

CREATE OR REPLACE PROCEDURE SP_DELETE_INVOICE(I_ID IN NUMBER) AS 
BEGIN 
    EXECUTE IMMEDIATE ' ALTER TABLE '||'INVOICELINE'||' DROP CONSTRAINT '||'FK_INVOICELINEIDINVOICEID'; 
    EXECUTE IMMEDIATE ' ALTER TABLE '||'INVOICELINE'||' ADD CONSTRAINT '||'FK_INVOICELINEIDINVOICEID'
    ||' FOREIGN KEY '||'(INVOICEID)'||' REFERENCES '||'INVOICE'||' (INVOICEID)' ||' ON DELETE CASCADE ';
    COMMIT; 
    DELETE FROM -- delete the record from the parent 
        INVOICE
    WHERE 
        INVOICEID = I_ID; 
    COMMIT; -- commit the delete 
    EXECUTE IMMEDIATE ' ALTER TABLE '||'INVOICELINE'||' DROP CONSTRAINT '||'FK_INVOICELINEIDINVOICEID'; 
    EXECUTE IMMEDIATE ' ALTER TABLE '||'INVOICELINE'||' ADD CONSTRAINT '||'FK_INVOICELINEIDINVOICEID'
    ||' FOREIGN KEY '||'(INVOICEID)'||' REFERENCES '||'INVOICE'||' (INVOICEID)'; 
    COMMIT; 
END;
/  
-- Test for procedure 
DECLARE 
-- nothing to declare 
BEGIN 
    SP_DELETE_INVOICE(27); 
END; 

-- 6.0 Triggers 
-- 6.1 After/ For
-- Task 1 after trigger to fire when a new record is added
CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE 
FOR EACH ROW 
BEGIN 
    DBMS_OUTPUT.PUT_LINE('A new emplyee has been added'); 
END; 
/

-- test 
INSERT INTO EMPLOYEE (EMPLOYEEID, FIRSTNAME, LASTNAME) VALUES (15, 'Dr.', 'Seus'); 

--Task 2 after trigger to fire when a record is updated
CREATE OR REPLACE TRIGGER TR_UPDATE_ABLUM
AFTER UPDATE ON ALBUM 
FOR EACH ROW 
BEGIN 
    DBMS_OUTPUT.PUT_LINE('An album record has been updated'); 
END; 
/

-- test 
UPDATE ALBUM SET TITLE = 'Balls to the Wall (BTTW)' WHERE ALBUMID = 2; 

--Task 3 after trigger to fire when a customer row is deleted
CREATE OR REPLACE TRIGGER TR_DELETE_CUSTOMER
AFTER DELETE ON CUSTOMER 
FOR EACH ROW 
BEGIN 
    DBMS_OUTPUT.PUT_LINE('A customer record has been deleted'); 
END; 
/

-- test 
UPDATE ALBUM SET TITLE = 'Balls to the Wall (BTTW)' WHERE ALBUMID = 2; 


--early on thursday morning -- 
-- 7.0 Joins --
-- 7.1 inner joins -- 

SELECT 
    CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID --NOT USING AN ALIAS 
FROM 
    CUSTOMER
INNER JOIN
    INVOICE 
ON 
    (CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID); 
    
-- 7.2 Outer join -- 

SELECT CUSTOMER.CUSTOMERID, CUSTOMER.FIRSTNAME, CUSTOMER.LASTNAME, INVOICE.INVOICEID, INVOICE.TOTAL
FROM 
    CUSTOMER
FULL JOIN 
    INVOICE 
ON 
    CUSTOMER.CUSTOMERID = INVOICE.CUSTOMERID; 

-- 7.3 Right join 
SELECT ALBUM.TITLE, ARTIST.NAME 
FROM 
   ALBUM
FULL JOIN 
   ARTIST
ON 
    ALBUM.ARTISTID = ARTIST.ARTISTID; 
     
-- 7.4 cross join 
SELECT 
    ALBUM.TITLE, ARTIST.NAME 
FROM 
   ALBUM  
CROSS JOIN 
    ARTIST
WHERE 
    ARTIST.ARTISTID = ALBUM.ARTISTID
ORDER BY ARTIST.NAME DESC; 
    
-- 7.5 self join 
SELECT 
    (E.FIRSTNAME || ' ' || E.LASTNAME) "EMPLOYEE NAME", 
    (R.FIRSTNAME || ' ' || R.LASTNAME) REPORTSTO, 
    E.TITLE "EMPLOYEE TITLE"
FROM 
    EMPLOYEE E
LEFT JOIN 
    EMPLOYEE R 
ON 
    R.EMPLOYEEID = E.REPORTSTO; 

    
