--2 	SQL Queries
--In this section you will be performing various queries against the Oracle Chinook database.
--2.1 SELECT
--Task – Select all records from the Employee table where last name is King.
SELECT * FROM EMPLOYEE WHERE UPPER(LASTNAME)='KING';
--Task – Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.
SELECT * FROM EMPLOYEE WHERE UPPER(FIRSTNAME)='ANDREW' AND REPORTSTO IS NULL;
--2.2 ORDER BY
--Task – Select all albums in Album table and sort result set in descending order by title.
SELECT * FROM ALBUM
--Task – Select first name from Customer and sort result set in ascending order by city
SELECT (FIRSTNAME) FROM CUSTOMER ORDER BY (FIRSTNAME) ASC;




--2.3 INSERT INTO
--Task – Insert two new records into Genre table 

INSERT INTO GENRE (GENREID,NAME) VALUES (26, 'Yodeling');
INSERT INTO GENRE (GENREID,NAME) VALUES (27, 'Deep House Music');
SELECT * FROM GENRE ORDER BY GENREID DESC;
--Task – Insert two new records into Employee table

INSERT INTO EMPLOYEE (EMPLOYEEID,FIRSTNAME, LASTNAME) VALUES (10, 'Corp','Shane');
INSERT INTO EMPLOYEE (EMPLOYEEID,FIRSTNAME, LASTNAME) VALUES (9, 'Flynn','Shane');
SELECT * FROM EMPLOYEE ORDER BY EMPLOYEEID DESC;
--Task – Insert two new records into Customer table
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (61,'Joffrey','Lannister', 'TheWorst@GOT.com');
INSERT INTO CUSTOMER (CUSTOMERID, FIRSTNAME, LASTNAME, EMAIL) VALUES (60, 'Ramsey', 'Bolton', 'TillYouMetHim@GOT.com');
SELECT * FROM CUSTOMER ORDER BY FIRSTNAME ASC;
--2.4 UPDATE
--Task – Update Aaron Mitchell in Customer table to Robert Walter
UPDATE CUSTOMER SET FIRSTNAME='Robert', LASTNAME='Walter' WHERE CUSTOMERID = 26;
--Task – Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	
UPDATE ARTIST SET NAME ='CCR' WHERE NAME = 'Creedence Clearwater Revival';
SELECT * FROM ARTIST ORDER BY NAME ASC;
--2.5 LIKE
--Task – Select all invoices with a billing address like “T%” 
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';
--2.6 BETWEEN
--Task – Select all invoices that have a total between 15 and 50
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
--Task – Select all employees hired between 1st of June 2003 and 1st of March 2004
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE ('20030601','YYYYMMDD') AND TO_DATE('20040301','YYYYMMDD');
--2.7 DELETE
--Task – Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
ALTER TABLE CUSTOMER DROP CONSTRAINT PK_CUSTOMER;
DELETE FROM CUSTOMER WHERE CUSTOMERID=32;
SELECT * FROM CUSTOMER ORDER BY CUSTOMERID ASC;
--3.1 System Defined Functions
--Task – Create a function that returns the current time.
SELECT TO_CHAR (SYSDATE, 'HH24:MI:SS') FROM DUAL;
--Task – create a function that returns the length of name in MEDIATYPE table
SELECT LENGTH(NAME) FROM MEDIATYPE;
--3.2 System Defined Aggregate Functions
--Task – Create a function that returns the average total of all invoices 
SELECT AVG(TOTAL) FROM INVOICE;
--Task – Create a function that returns the most expensive track
SELECT MAX(UNITPRICE) FROM TRACK;
--3.3 User Defined Scalar Functions
--Task – Create a function that returns the average price of invoiceline items in the invoiceline table
SELECT * FROM INVOICELINE;



CREATE OR REPLACE FUNCTION AVG_PRICE 
RETURN  NUMBER AS AVERAGE NUMBER; 
BEGIN  
SELECT AVG(UNITPRICE) INTO AVERAGE FROM INVOICELINE;
RETURN AVERAGE;
END;
/
SELECT AVG_PRICE FROM DUAL;

--3.4 User Defined Table Valued Functions
--Task – Create a function that returns all employees who are born after 1968.


CREATE OR REPLACE FUNCTION PRINT_OLD_PEOPLE
RETURN SYS_REFCURSOR
IS
S SYS_REFCURSOR;
BEGIN
    OPEN S FOR 
    SELECT EMPLOYEEID,FIRSTNAME,LASTNAME,BIRTHDATE FROM EMPLOYEE 
    WHERE BIRTHDATE > TO_DATE('01-01-1968','DD-MM-YYYY');
    RETURN S;
END;
/

--INVOKE THE FUNCTION
DECLARE S SYS_REFCURSOR;
OLD_ID EMPLOYEE.EMPLOYEEID%TYPE; --DECLARES SOME_ID IS THE SAME DATATYPE AS BEAR.BEAR_ID
OLD_FIRSTNAME EMPLOYEE.FIRSTNAME%TYPE;
OLD_LASTNAME EMPLOYEE.LASTNAME%TYPE;
OLD_BIRTHDATE EMPLOYEE.BIRTHDATE%TYPE;
BEGIN
    S := PRINT_OLD_PEOPLE;
    LOOP
    FETCH S INTO OLD_ID, OLD_FIRSTNAME,OLD_LASTNAME,OLD_BIRTHDATE; --GRAB VALUES IN COLUMNS OF NEXT ROW IN ACTIVE SET
    EXIT WHEN S%NOTFOUND;            --AND ASSIGN THEM TO SOME_ID, SOME_NAME
    DBMS_OUTPUT.PUT_LINE('OLD_ID: '||OLD_ID||', FIRSTNAME: '||OLD_FIRSTNAME ||'OLD_LASTNAME: '||OLD_LASTNAME ||'OLD_BIRTHDATE: ' ||OLD_BIRTHDATE);
    END LOOP;
    CLOSE S;
END;
--4.0 Stored Procedures
-- In this section you will be creating and executing stored procedures. You will be creating various types of stored procedures that take input and output parameters.
--4.1 Basic Stored Procedure
--Task – Create a stored procedure that selects the first and last names of all the employees.

create or replace procedure FULL_NAMES 
(S OUT SYS_REFCURSOR) as
begin 
    open S for
    select FirstName, LastName From Employee;
end;
/

declare 
    S SYS_REFCURSOR;
    FIRST employee.firstname%type;
    LAST employee.lastname%type;
begin
    FULL_NAMES(s);
    loop
        fetch s into FN, LN;
        exit when s%notfound;
        DBMS_output.put_line('first name: ' || FIRST || '   last name: ' || LAST);
    end loop;
    close s;
end;
/





--.2 Stored Procedure Input Parameters
--Task – Create a stored procedure that updates the personal information of an employee.
CREATE OR REPLACE PROCEDURE EMP_UPDATE
(EMP_ID NUMBER, NEW_ADDRESS IN VARCHAR2, NEW_POSTALCODE NUMBER, NEW_PHONE NUMBER) AS BEGIN
UPDATE EMPLOYEE SET ADDRESS = NEW_ADDRESS, POSTALCODE=NEW_POSTALCODE, PHONE = NEW_PHONE WHERE EMPLOYEEID=EMP_ID;
COMMIT;
END;

SELECT * FROM EMPLOYEE;
BEGIN
EMP_UPDATE(1,'COOL', 4,5);
END;
--Task – Create a stored procedure that returns the managers of an employee.
CREATE OR REPLACE PROCEDURE EMP_MANAGER (EMP_ID IN NUMBER, MAN_ID OUT NUMBER) AS
BEGIN
    SELECT REPORTSTO INTO MAN_ID FROM EMPLOYEE WHERE EMPLOYEEID = EMP_ID;
END;
/

DECLARE
MAN_ID NUMBER;
BEGIN
    EMP_MANAGER (2, MAN_ID);
    DBMS_OUTPUT.PUT_LINE('MANAGER ID IS ' || MAN_ID);
    END;
--4.3 Stored Procedure Output Parameters
--Task – Create a stored procedure that returns the name and company of a customer.
CREATE OR REPLACE PROCEDURE CUST_NAME_COMP (CUS_ID IN NUMBER, CUS_FIRSTNAME OUT VARCHAR2,CUS_LASTNAME OUT VARCHAR2, CUS_COMP OUT VARCHAR2 ) AS
BEGIN
    SELECT FIRSTNAME,LASTNAME,COMPANY INTO CUS_FIRSTNAME, CUS_LASTNAME, CUS_COMP FROM CUSTOMER WHERE CUSTOMERID = CUS_ID;
END;
/

DECLARE
CUS_FIRSTNAME VARCHAR2(100);
CUS_LASTNAME VARCHAR2(100);
CUS_COMP VARCHAR2(100);
BEGIN
    CUST_NAME_COMP (2, CUS_FIRSTNAME,CUS_LASTNAME,CUS_COMP);
    DBMS_OUTPUT.PUT_LINE('FULL NAME: ' ||CUS_FIRSTNAME || ' ' || CUS_LASTNAME || ' COMPANY: ' || CUS_COMP);
 END;
 /


--5.0 Transactions
--In this section you will be working with transactions. Transactions are usually nested within a stored procedure.
--Task – Create a transaction that given a invoiceId will delete that invoice (There may be constraints that rely on this, find out how to resolve them).

 ALTER TABLE INVOICE DROP CONSTRAINT PK_INVOICE;
 ALTER TABLE INVOICELINE ADD CONSTRAINT FK_InvoiceLineInvoiceId;
 CREATE OR REPLACE PROCEDURE DELETE_INVOICEID (INVOICE_NUM IN NUMBER) 
 IS
 BEGIN
 
    DELETE FROM INVOICE WHERE INVOICEID=INVOICE_NUM;
 END;


--6.0 Triggers
--In this section you will create various kinds of triggers that work when certain DML statements are executed on a table.
--6.1 AFTER/FOR
--Task - Create an after insert trigger on the employee table fired after a new record is inserted into the table.


CREATE SEQUENCE SQ_NEW_EMP_PK
START WITH 1000
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER NEW_EMP_RECORD
AFTER INSERT ON EMPLOYEE FOR EACH ROW
BEGIN
   SELECT SQ_NEW_EMP_PK.NEXTVAL INTO : NEW.EMPLOYEEID FROM DUAL;
END
/


--Task – Create an after update trigger on the album table that fires after a row is inserted in the table
CREATE SEQUENCE SQ_NEW_ALBUM_PK
START WITH 1000
INCREMENT BY 1;
/
CREATE OR REPLACE TRIGGER NEW_ALBUM
AFTER UPDATE ON ALBUM FOR EACH ROW
BEGIN
    SELECT SQ_NEW_ALBUM_PK.NEXTVAL INTO : NEW.ALBUM FROM DUAL;
END

--Task – Create an after delete trigger on the customer table that fires after a row is deleted from the table.
CREATE SEQUENCE SQ_DELETE_CUST_PK
START WITH 1000
INCREMENT BY 1;


CREATE OR REPLACE TRIGGER DEL_CUST
AFTER DELETE ON CUSTOMER FOR EACH ROW
BEGIN
    SELECT SQ_DELETE_CUST_PK.NEXTVAL INTO : NEW.CUSTOMERID FROM DUAL;
END;
  
--7.0 JOINS
--In this section you will be working with combining various tables through the use of joins. You will work with outer, inner, right, left, cross, and self joins.
--7.1 INNER
--Task – Create an inner join that joins customers and orders and specifies the name of the customer and the invoiceId.
SELECT FIRSTNAME, LASTNAME, INVOICEID FROM CUSTOMER INNER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;
--7.2 OUTER
--Task – Create an outer join that joins the customer and invoice table, specifying the CustomerId, firstname, lastname, invoiceId, and total.
SELECT  INVOICE.CUSTOMERID, FIRSTNAME, LASTNAME, INVOICEID, TOTAL FROM CUSTOMER FULL OUTER JOIN INVOICE ON CUSTOMER.CUSTOMERID=INVOICE.CUSTOMERID;
--7.3 RIGHT
--Task – Create a right join that joins album and artist specifying artist name and title.
SELECT NAME,TITLE FROM ALBUM RIGHT JOIN ARTIST ON ALBUM.ARTISTID=ALBUM.ALBUMID;
--7.4 CROSS
--Task – Create a cross join that joins album and artist and sorts by artist name in ascending order.
SELECT * FROM ALBUM CROSS JOIN ARTIST ORDER BY NAME ASC;
--7.5 SELF
--Task – Perform a self-join on the employee table, joining on the reportsto column.
SELECT 
EMPLOYEE E
INNER JOIN
EMPLOYEE M

SELECT 
    concat(e.firstname, e.lastname) "employee",
    concat(m.firstname, m.lastname) "MANAGER"
FROM
    employee e
INNER JOIN
    employee m ON m.employeeid = e.reportsto;