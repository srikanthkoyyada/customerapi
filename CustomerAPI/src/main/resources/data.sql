CREATE TABLE APIUSER(
  USERNAME VARCHAR(50) NOT NULL,
  PASSWORD VARCHAR(65) NOT NULL,
  ROLE VARCHAR(15) NOT NULL);

  

INSERT INTO APIUSER VALUES ('apiuser','$2a$10$5e3dB36HeRcozRgp8xQfw.tfD3Qsut8xu/NT9g/DSpVKg9Kzuitrq','USER');
INSERT INTO CUSTOMER(USERNAME,PASSWORD) VALUES('srikanthk','$2a$12$2671jaYKX6Jl7v33.uxhyOjnPQZnFCagSPxy/Hn4nroupC5rUSL9W');
INSERT INTO ACCOUNT(ACCOUNT_NUMBER,NAME,BALANCE,CUSTOMER_ID) VALUES('458790052498','SRIKANTH',20000.00,1);
INSERT INTO CUSTOMER_PAYEE(ACCOUNT_NUMBER,IFSC_CODE,NAME,NICK_NAME,PAYEE_ACCOUNT_NUMBER,IS_VERIFIED) VALUES('458790052498','BBI001235','KOYYADA','KK','123456879012',0);
insert into transaction(ACCOUNT_NUMBER,TRAN_AMOUNT,TRAN_DATE_TIME,TRAN_SOURCE_ACCOUNT,TRAN_TARGET_ACCOUNT,TRAN_TYPE)
values ('458790052498',1000,current_timestamp,'458790052498','123456879012','DBT');
update account set BALANCE=BALANCE-1000 where ACCOUNT_NUMBER='458790052498';
