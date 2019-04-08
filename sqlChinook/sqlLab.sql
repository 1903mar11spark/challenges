SELECT COUNT(*) FROM PLAYLISTTRACK;
--counts the entries so you can find out how many data entries total
--SELECT * FROM ARTIST WHERE ARTISTID = 1 --AC/DC
--SELECT ARTISTID FROM ARTIST WHERE NAME = 'AC/DC' --gets the id
--SELECT ARTISTID FROM ARTIST WHERE NAME = 'AC/DC'

--SELECT ARTISTID, NAME FROM ARTIST WHERE NAME = 'AC/DC' OR NAME = 'Queen'; --same as line 3.  gets all artists id's and names
--SELECT ARTISTID, NAME FROM ARTIST WHERE(NAME = 'AC/DC' AND ARISTID = 1) OR (NAME = 'Queen');

SELECT * FROM ARTIST WHERE NAME LIKE '%Q%'; --returns all will lower case a and uppercase A
SELECT * FROM ARTIST WHERE NAME LIKE '%__/D%'; --underscores indicate a character
SELECT * FROM ARTIST WHERE NAME LIKE 'Q%n'; --starts with Q and ends with n

SELECT * FROM ARTIST WHERE UPPER(NAME) LIKE 'A%' FETCH NEXT 5 ROWS ONLY; --upper or lower controls the case sensitive. first 5 results

SELECT * FROM ARTIST WHERE LOWER(NAME) LIKE 'a%' FETCH NEXT 50 PERCENT ROWS ONLY; --gives us half 

SELECT * FROM INVOICE;

SELECT * FROM INVOICE WHERE TOTAL > 2;
SELECT * FROM INVOICE WHERE TOTAL  BETWEEN 2 AND 10;

SELECT * FROM INVOICE WHERE TOTAL BETWEEN 2 AND 10 ORDER BY TOTAL ASC; --order smallest to biggest
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 2 AND 100 ORDER BY TOTAL DESC; --order biggest to smallest

SELECT * FROM INVOICE WHERE TOTAL NOT BETWEEN 2 AND 10 ORDER BY TOTAL ASC; --order biggest to smallest TOTAL $$$

SELECT * FROM INVOICE WHERE TOTAL BETWEEN 2 AND 10 ORDER BY TOTAL ASC, INVOICEDATE DESC; --between $2 and $10 


SELECT * FROM INVOICE WHERE TOTAL BETWEEN 2 AND 10 ORDER BY TOTAL ASC, BILLINGSTATE  DESC NULLS FIRST; --between $2 and $10 





--find albums of artists by their id)
SELECT ARTISTID FROM ARTIST WHERE NAME = 'AC/DC' OR NAME = 'Queen'; --getting id's

--applying id's to the albums table 
SELECT * FROM ALBUM WHERE ARTISTID IN(SELECT ARTISTID FROM ARTIST WHERE NAME = 'AC/DC' OR NAME = 'Queen');

SELECT * FROM TRACK WHERE ALBUMID IN  --now, give us the tracks (3)
    (SELECT ALBUMID FROM ALBUM WHERE ARTISTID IN -- all albums by AC/DC (2)
        (SELECT ARTISTID FROM ARTIST WHERE NAME = 'AC/DC')); --AC/DCS artist id (1)
        



--(SELECT * FROM PLAYLISTTRACK WHERE TRACKID IN
--(SELECT TRACKID FROM TRACK WHERE ALBUMID IN  --now, give us the tracks (3)
   -- (SELECT ALBUMID FROM ALBUM WHERE ARTISTID IN -- all albums by AC/DC (2)
     --   (SELECT ARTISTID FROM ARTIST WHERE NAME = 'AC/DC')))); --AC/DCS artist id (1)
     





--SQL HOMEWORK--SQL HOMEWORK--SQL HOMEWORK--

--2.1--
SELECT * FROM EMPLOYEE;
SELECT * FROM EMPLOYEE WHERE LOWER(LASTNAME) = 'king';
SELECT * FROM EMPLOYEE WHERE LOWER(FIRSTNAME) = 'andrew' AND REPORTSTO IS NULL;

--2.2--
SELECT TITLE FROM ALBUM ORDER BY TITLE DESC;
SELECT FIRSTNAME FROM CUSTOMER ORDER BY CITY DESC;

--2.3--

SELECT*FROM GENRE;
INSERT ALL 
INTO GENRE
VALUES (26, 'random animal noises')
INTO GENRE
VALUES (27, 'music that belongs in the garbage')
SELECT * FROM DUAL;

SELECT*FROM EMPLOYEE;
INSERT ALL 
INTO EMPLOYEE
VALUES (9, 'McLazy', 'Lazy', 'Manager of Procrastination', 1, TO_DATE('1995-04-01', 'yyyy-mm-dd'), TO_DATE('2015-04-01', 'yyyy-mm-dd'), '123 Lazy street', 'Lazyville', 'LZ', 'procrastiNATION', 'LAZ4LYF', '555-555-5555', 'fax-555-5555', 'lay_z@lz.com')
INTO EMPLOYEE
VALUES (10, 'K', 'Y2', 'Janitor', 6, TO_DATE('2000-01-01', 'yyyy-mm-dd'), TO_DATE('1999-12-31', 'yyyy-mm-dd'), '123 Crash Street', 'Internetville', 'earth', 'everyNATION', 'Y2K 555', '000.000.000.000', 'fax-555-5555', 'goodbyeElectricity@y2k.com')
SELECT * FROM DUAL;

SELECT*FROM CUSTOMER;
INSERT ALL 
INTO CUSTOMER
VALUES (60, 'Shoppy', 'McShopper', null, '123 Shopping Street', 'Shoppington', 'FL', 'USA', '53556', '555-555-5555', 'fax-555-5555', 'coupons4days@shop.mail', 4)
INTO CUSTOMER
VALUES (61, 'Jane', 'Doe', 'CIA', '123 Spy Street', 'Secretville', 'Top Secret', 'USA', 'C5I5A5', '000-000-0000', 'fax-000-0000', 'secretAgentLan@spy.mail', 5)
SELECT * FROM DUAL;

--2.4--
UPDATE CUSTOMER
SET FIRSTNAME = 'Robert', LASTNAME= 'Walter'
WHERE CustomerID = 32;

SELECT*FROM ARTIST WHERE NAME LIKE 'Cre%';
UPDATE ARTIST
SET NAME = 'CCR'
WHERE ARTISTID = 76;
SELECT*FROM ARTIST WHERE NAME LIKE 'CCR%';

--2.5--
SELECT * FROM INVOICE;
SELECT * FROM INVOICE WHERE BILLINGADDRESS LIKE 'T%';

--2.6--
SELECT * FROM INVOICE WHERE TOTAL BETWEEN 15 AND 50;
SELECT * FROM EMPLOYEE WHERE HIREDATE BETWEEN TO_DATE('20030601', 'yyyymmdd') AND TO_DATE('2004-03-01', 'yyyy-mm-dd');

--2.7--
SELECT * FROM CUSTOMER;
ALTER TABLE INVOICE DROP CONSTRAINT FK_INVOICECUSTOMERID;
DELETE FROM CUSTOMER WHERE CUSTOMERID = 32;

ALTER TABLE INVOICELINE
 DROP CONSTRAINT FK_INVOICELINEINVOICEID; 
DELETE FROM INVOICE WHERE INVOICE.CUSTOMERID = 32;

--3.1--
--current timestamp--
CREATE OR REPLACE FUNCTION getTime
RETURN TIMESTAMP WITH TIME ZONE IS
  t_CURRENT_TIMESTAMP TIMESTAMP WITH TIME ZONE;
BEGIN
    SELECT CURRENT_TIMESTAMP
    INTO t_CURRENT_TIMESTAMP
    FROM DUAL;
  RETURN t_CURRENT_TIMESTAMP;
END;
/
SELECT getTime() FROM DUAL;


--GET THE LENGTH--
SELECT LENGTH(NAME) FROM MEDIATYPE;

create or replace function getlengthmediatype (m_id IN NUMBER)
return number as
 l_name number;
begin
 SELECT length(NAME) 
 INTO l_name
 FROM MEDIATYPE
 WHERE mediatypeid = m_id;
 --mediatype_length := SELECT length(NAME) FROM MEDIATYPE WHERE mediatypeid = MEDIATYPE_ID;
 RETURN l_name;
end;
/
--3.2--
SELECT AVG(TOTAL) FROM INVOICE;
select max(unitprice) from track;

create or replace function getTotal
return number as
 i_total number;
begin
 SELECT avg(total) 
 INTO i_total
 FROM INVOICE;
 RETURN getTotal;
end;
/
SELECT getTotal FROM INVOICE;

DECLARE
 i_total number;
BEGIN
 i_total := getTotal;
 DBMS_OUTPUT.PUT_LINE('Invoice Totals Average is: ' || i_total);
 
END;
/

--2
CREATE VIEW get_most_expensive_track (NAME, UNITPRICE) AS
SELECT name, unitprice 
 FROM track
 where unitprice = (select max(unitprice) from track);

--to run 
select * from get_most_expensive_track;

--3.3--
SELECT AVG(UNITPRICE) from INVOICELINE;

create or replace function getAverage 
return number  
deterministic
as
unit number;
begin
SELECT AVG(UNITPRICE)
into unit
from INVOICELINE;
return unit;
end;
/
SELECT getAverage() FROM DUAL;

--3.4--
SELECT * FROM EMPLOYEE WHERE BIRTHDATE > TO_DATE('1968-12-31', 'yyyy-mm-dd');


CREATE OR REPLACE FUNCTION print_birthdate
RETURN SYS_REFCURSOR
IS
bd SYS_REFCURSOR;
BEGIN
    OPEN bd FOR 
    SELECT FIRSTNAME, BIRTHDATE FROM EMPLOYEE WHERE BIRTHDATE > TO_DATE('1968-12-31', 'yyyy-mm-dd');
    RETURN bd;
END;

--INVOKE THE FUNCTION
DECLARE
bd SYS_REFCURSOR;
SOME_NAME EMPLOYEE.FIRSTNAME%TYPE; 
SOME_DATE EMPLOYEE.BIRTHDATE%TYPE;
BEGIN
    bd := print_birthdate;
    LOOP
    FETCH bd INTO SOME_NAME, SOME_DATE; 
    EXIT WHEN bd%NOTFOUND;            
    DBMS_OUTPUT.PUT_LINE('name: '||SOME_NAME||', birthday: '||SOME_DATE);
    END LOOP;
    CLOSE bd;
END;

select print_birthdate from dual;

--4.1--
create or replace procedure Get_Employee_Names 
(x OUT SYS_REFCURSOR) as
begin 
 open x for
 select FirstName, LastName From Employee;
end;
/

declare 
 x SYS_REFCURSOR;
 FN EMPLOYEE.FIRSTNAME%type;
 LN EMPLOYEE.LASTNAME%type;
begin
 Get_Employee_Names(x);
 loop
 fetch x into FN, LN;
 exit when x%notfound;
 DBMS_output.put_line('first name: ' || FN || ' last name: ' || LN);
 end loop;
 close x;
end;
/


SELECT FIRSTNAME, LASTNAME FROM EMPLOYEE;
SELECT * FROM EMPLOYEE;

--4.2 (A)--

CREATE OR REPLACE PROCEDURE update_employee_info
(E_ID IN NUMBER, FN IN VARCHAR2, LN IN VARCHAR2) AS
BEGIN 
 UPDATE EMPLOYEE SET FIRSTNAME = FN, LASTNAME = LN
 WHERE EmployeeId = E_ID;
 COMMIT;
END;
/

--4.2 (B)--
SELECT a.employeeid AS "Emp_ID", a.firstname AS "Employee Name",
b.employeeid AS "manager ID", b.firstname AS "manager name"
FROM employee a, employee b 
WHERE a.reportsto = b.employeeid;

create or replace procedure Get_Employee_Manager 
(E_Id in number, M_id out number) as
begin 

 SELECT REPORTSTO
 into m_id
 FROM EMPLOYEE 
 WHERE EMPLOYEEID = E_id; 
 
end;
/

declare 
 m_id number;
begin
 Get_Employee_Manager (3, m_id);
 DBMS_output.put_line('manager id: ' || m_id);
end;
/

--4.3--

create or replace procedure Get_customername_company 
(c_id in NUMBER, FN out varchar2, LN out varchar2,CC out varchar2) as
begin 
 
 select FIRSTNAME, LASTNAME, COMPANY into FN, LN, CC from CUSTOMER where CUSTOMERID = c_id;
end;
/

declare 
 FN varchar2(100);
 LN varchar2(100);
 CC varchar2(100);
begin
 Get_customername_company ( 1 ,FN, LN, CC);
 DBMS_output.put_line('first name: ' || FN || ' last name: ' || LN || ' company: ' || CC);
end;
/


--5--
--(A)
CREATE OR REPLACE PROCEDURE delete_invoice
(I_ID IN NUMBER) AS
BEGIN
EXECUTE IMMEDIATE 'ALTER TABLE InvoiceLine DROP CONSTRAINT FK_InvoiceLineInvoiceId';
 EXECUTE IMMEDIATE 'ALTER TABLE InvoiceLine ADD CONSTRAINT FK_InvoiceLineInvoiceId FOREIGN KEY (InvoiceId) REFERENCES Invoice (InvoiceId) ON DELETE CASCADE'; 
 DELETE invoice WHERE INVOICEID = I_ID; 
 COMMIT;
END;
/

-- (B)--
CREATE OR REPLACE PROCEDURE create_new_customer
(FN IN VARCHAR2, LN IN VARCHAR2) AS
BEGIN
  INSERT INTO Customer (CustomerId, FirstName, LastName) VALUES (1, 'FN', 'LN');
  COMMIT;
END;
/


SELECT * FROM CUSTOMER;

--6.1--
--INSERT--
SELECT * FROM EMPLOYEE;

CREATE SEQUENCE SQ_EMPLOYEE_PK --I committed this, but it works--
START WITH 11
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER TR_INSERT_EMPLOYEE
AFTER INSERT ON EMPLOYEE
FOR EACH ROW
BEGIN
    INSERT INTO EMPLOYEE VALUES ('EMPLOYEEID', 'FIRSTNAME', 'LASTNAME', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
END;
/

--UPDATE--
SELECT COUNT(*) FROM ALBUM;
SELECT * FROM ALBUM;

CREATE SEQUENCE SQ_ALBUM_PK
START WITH 348
INCREMENT BY 1;
/

CREATE OR REPLACE TRIGGER TR_UPDATE_ALBUM
AFTER UPDATE ON ALBUM
FOR EACH ROW
BEGIN
    UPDATE ALBUM SET ALBUMID = SQ_ALBUM_PK.NEXTVAL;
    UPDATE ALBUM SET ARTISTID = SQ_ARTIST_PK.NEXTVAL;
END;
/

--DELETE--
CREATE OR REPLACE TRIGGER DELETE_CUSTOMER
AFTER DELETE
   ON CUSTOMER
   FOR EACH ROW
BEGIN
   -- Insert record into audit table
   INSERT INTO CUSTOMER
   ( CUSTOMERID,
     FIRSTNAME,
     LASTNAME,
     EMAIL)
   VALUES
   ( :old.CUSTOMERID||'DELETED',
     :old.FIRSTNAME||'DELETED',
     :old.LASTNAME||'DELETED',
     :old.EMAIL||'DELETED');
END;
/



--7.1--
--INNER--
SELECT invoice.invoiceID, Customer.firstName, customer.lastname
FROM invoice
INNER JOIN Customer ON invoice.CustomerID = Customer.CustomerID;

--OUTER--
SELECT customer.customerid, invoice.invoiceid, customer.firstname, customer.lastname, invoice.total
FROM customer
FULL outer JOIN invoice
ON customer.customerid = invoice.customerid;

--RIGHT--
select* from artist;

SELECT artist.name, album.title
FROM artist
right JOIN album
ON album.artistid = artist.artistid;

--CROSS--
select* from artist;
select*from album;
SELECT artist.name, album.title
FROM artist
cross JOIN album
order by asc;


--SELF--
SELECT * FROM EMPLOYEE;

SELECT e1.firstname||e1.lastname||' reports to '||e2.reportsto||e2.title
"employees and their managers"
FROM employee e1, employee e2
WHERE e1.employeeid = e2.employeeid;
  