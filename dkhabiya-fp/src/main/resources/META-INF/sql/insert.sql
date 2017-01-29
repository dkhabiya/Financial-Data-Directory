insert ignore into role(ROLENAME, ROLEDESC) values ("MAKER","Creates transactions.");
insert ignore into role(ROLENAME, ROLEDESC) values ("CHECKER","Authorizes transactions");

insert ignore into user(USERNAME, PASSWORD, NAME) values ("maker1", SHA2("maker1",256), "John D");
insert ignore into user(USERNAME, PASSWORD, NAME) values ("maker2", SHA2("maker2",256), "Jane Doe");
insert ignore into user(USERNAME, PASSWORD, NAME) values ("maker3", SHA2("maker3",256), "Inger B");
insert ignore into user(USERNAME, PASSWORD, NAME) values ("maker4", SHA2("maker4",256), "Micheal S");
insert ignore into user(USERNAME, PASSWORD, NAME) values ("checker1", SHA2("checker1",256), "Loki");
insert ignore into user(USERNAME, PASSWORD, NAME) values ("checker2", SHA2("checker2",256), "Hulk");
insert ignore into user(USERNAME, PASSWORD, NAME) values ("checker3", SHA2("checker3",256), "Batman");
insert ignore into user(USERNAME, PASSWORD, NAME) values ("checker4", SHA2("checker4",256), "Superman");

insert ignore into user_role(userName, roleName) values ("maker1","MAKER");
insert ignore into user_role(userName, roleName) values ("maker2","MAKER");
insert ignore into user_role(userName, roleName) values ("maker3","MAKER");
insert ignore into user_role(userName, roleName) values ("maker4","MAKER");
insert ignore into user_role(userName, roleName) values ("checker1","CHECKER");
insert ignore into user_role(userName, roleName) values ("checker2","CHECKER");
insert ignore into user_role(userName, roleName) values ("checker3","CHECKER");
insert ignore into user_role(userName, roleName) values ("checker4","CHECKER");

insert ignore into details(DETAILID, SSN, AUTHNAME, AUTHSTATUS, CITY, CREATORNAME, DATELASTMODIFIED, DRIVERSLICENCE, PASSPORTNUMBER, STATE, STATEID, STREETLINE1, STREETLINE2, ZIPCODE) values (10001, "SSN", "checker1", "A", "NYC", "maker1", curdate(), "DRIVERSLICENCE", "PASSPORTNUMBER", "New York", "STATEID", "Downtown Sixbey", "", 10001);
insert ignore into details(DETAILID, SSN, AUTHNAME, AUTHSTATUS, CITY, CREATORNAME, DATELASTMODIFIED, DRIVERSLICENCE, PASSPORTNUMBER, STATE, STATEID, STREETLINE1, STREETLINE2, ZIPCODE) values (10002, "SSN", "checker2", "A", "Westminister", "maker2", curdate(), "DRIVERSLICENCE", "PASSPORTNUMBER", "UK", "STATEID", "Margaret Street London", "", 0000);
insert ignore into details(DETAILID, SSN, AUTHNAME, AUTHSTATUS, CITY, CREATORNAME, DATELASTMODIFIED, DRIVERSLICENCE, PASSPORTNUMBER, STATE, STATEID, STREETLINE1, STREETLINE2, ZIPCODE) values (10003, "SSN", "checker3", "A", "Tokyo", "maker3", curdate(), "DRIVERSLICENCE", "PASSPORTNUMBER", "Tokyo", "STATEID", "Nishi Gotanda", "Shinagawa-ku", 1410031);
insert ignore into details(DETAILID, SSN, AUTHNAME, AUTHSTATUS, CITY, CREATORNAME, DATELASTMODIFIED, DRIVERSLICENCE, PASSPORTNUMBER, STATE, STATEID, STREETLINE1, STREETLINE2, ZIPCODE) values (10004, "SSN", "checker4", "A", "San Antonio", "maker4", curdate(), "DRIVERSLICENCE", "PASSPORTNUMBER", "Texas", "STATEID", "", "", 78201);
insert ignore into details(DETAILID, SSN, AUTHNAME, AUTHSTATUS, CITY, CREATORNAME, DATELASTMODIFIED, DRIVERSLICENCE, PASSPORTNUMBER, STATE, STATEID, STREETLINE1, STREETLINE2, ZIPCODE) values (10005, "SSN", "checker1", "A", "Odenthal", "maker1", curdate(), "DRIVERSLICENCE", "PASSPORTNUMBER", "Deutschland", "STATEID", "Postfach 1272", "", 51517);
insert ignore into details(DETAILID, SSN, AUTHNAME, AUTHSTATUS, CITY, CREATORNAME, DATELASTMODIFIED, DRIVERSLICENCE, PASSPORTNUMBER, STATE, STATEID, STREETLINE1, STREETLINE2, ZIPCODE) values (10006, "SSN", "", "U", "Odenthal", "maker1", curdate(), "DRIVERSLICENCE", "PASSPORTNUMBER", "Deutschland", "STATEID", "Postfach 1272", "", 51517);
insert ignore into details(DETAILID, SSN, AUTHNAME, AUTHSTATUS, CITY, CREATORNAME, DATELASTMODIFIED, DRIVERSLICENCE, PASSPORTNUMBER, STATE, STATEID, STREETLINE1, STREETLINE2, ZIPCODE) values (10002, "SSN", "", "U", "Odenthal", "maker2", curdate(), "DRIVERSLICENCE", "PASSPORTNUMBER", "Deutschland", "STATEID", "Postfach 1272", "", 51517);

insert ignore into customer(CUSTID, AUTHNAME, AUTHSTATUS, CREATORNAME, CUSTTITLE, CUSTTYPE, DATELASTMODIFIED, DATEOFBIRTH, DATEOFCREATION, FIRSTNAME, GENDER, LASTNAME, detailID) values (1234, "checker1", "A", "maker1", "Mr.", "Individual", curdate(), '1985-05-06', curdate(), "Jimmy", "Male", "Fallon", 10001);
insert ignore into customer(CUSTID, AUTHNAME, AUTHSTATUS, CREATORNAME, CUSTTITLE, CUSTTYPE, DATELASTMODIFIED, DATEOFBIRTH, DATEOFCREATION, FIRSTNAME, GENDER, LASTNAME, detailID) values (1235, "checker2", "A", "maker2", "Mr.", "Individual", curdate(), '1984-08-07', curdate(), "Tom", "Male", "Hiddleston", 10002);
insert ignore into customer(CUSTID, AUTHNAME, AUTHSTATUS, CREATORNAME, CUSTTITLE, CUSTTYPE, DATELASTMODIFIED, DATEOFBIRTH, DATEOFCREATION, FIRSTNAME, GENDER, LASTNAME, detailID) values (1236, "checker3", "A", "maker3", "Mr.", "Individual", curdate(), '1983-09-03', curdate(), "Itachi", "Male", "Uchiha", 10003);
insert ignore into customer(CUSTID, AUTHNAME, AUTHSTATUS, CREATORNAME, CUSTTITLE, CUSTTYPE, DATELASTMODIFIED, DATEOFBIRTH, DATEOFCREATION, FIRSTNAME, GENDER, LASTNAME, detailID) values (1237, "checker4", "A", "maker4", "Ms.", "Individual", curdate(), '1982-05-04', curdate(), "Michelle", "Female", "Rodrigeuz", 10004);
insert ignore into customer(CUSTID, AUTHNAME, AUTHSTATUS, CREATORNAME, CUSTTITLE, CUSTTYPE, DATELASTMODIFIED, DATEOFBIRTH, DATEOFCREATION, FIRSTNAME, GENDER, LASTNAME, detailID) values (1238, "checker1", "A", "maker1", "Ms.", "Individual", curdate(), '1981-10-06', curdate(), "Heidi", "Female", "Klum", 10005);
insert ignore into customer(CUSTID, AUTHNAME, AUTHSTATUS, CREATORNAME, CUSTTITLE, CUSTTYPE, DATELASTMODIFIED, DATEOFBIRTH, DATEOFCREATION, FIRSTNAME, GENDER, LASTNAME, detailID) values (1239, "", "U", "maker1", "Ms.", "Individual", curdate(), '1981-10-06', curdate(), "Heidi", "Female", "Klum", 10006);
insert ignore into customer(CUSTID, AUTHNAME, AUTHSTATUS, CREATORNAME, CUSTTITLE, CUSTTYPE, DATELASTMODIFIED, DATEOFBIRTH, DATEOFCREATION, FIRSTNAME, GENDER, LASTNAME, detailID) values (1240, "", "U", "maker2", "Ms.", "Individual", curdate(), '1981-10-06', curdate(), "Heidi", "Female", "Klum", 10002);

insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20001, "checker1", "A", "maker1", curdate(), curdate(), false, "abc1@xyz.com", true, 3024569876);
insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20002, "checker1", "A", "maker1", curdate(), curdate(), false, "abc2@xyz.com", true, 3024569845);
insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20003, "checker2", "A", "maker2", curdate(), curdate(), false, "abc3@xyz.com", true, 3024565678);
insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20004, "checker3", "A", "maker3", curdate(), curdate(), false, "abc4@xyz.com", true, 4568066556);
insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20005, "checker4", "A", "maker4", curdate(), curdate(), false, "abc5@xyz.com", true, 3345689767);
insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20006, "checker4", "A", "maker4", curdate(), curdate(), false, "abc6@xyz.com", true, 9876456789);
insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20007, "checker1", "A", "maker1", curdate(), curdate(), false, "abc7@xyz.com", true, 3456789098);
insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20008, "checker1", "A", "maker1", curdate(), curdate(), false, "abc8@xyz.com", true, 7543456989);
insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20009, "", "U", "maker1", curdate(), curdate(), false, "abc8@xyz.com", true, 7543456990);
insert ignore into preferences(PREFERENCEID, AUTHNAME, AUTHSTATUS, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, EMAILALERT, EMAILID, PHONEALERT, PHONENUMBER) values (20010, "", "U", "maker2", curdate(), curdate(), false, "abc8@xyz.com", true, 7543456991);

insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989823, "checker1", "A", 999.00, "maker1", curdate(), curdate(), "Savings", 20001);
insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989824, "checker1", "A", 888.00, "maker1", curdate(), curdate(), "Checkings", 20002);
insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989825, "checker2", "A", 777.00, "maker2", curdate(), curdate(), "Savings", 20003);
insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989826, "checker3", "A", 666.00, "maker3", curdate(), curdate(), "Savings", 20004);
insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989827, "checker4", "A", 555.00, "maker4", curdate(), curdate(), "Checkings", 20005);
insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989828, "checker4", "A", 444.00, "maker4", curdate(), curdate(), "Savings", 20006);
insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989829, "checker1", "A", 333.00, "maker1", curdate(), curdate(), "Savings", 20007);
insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989821, "checker1", "A", 222.00, "maker1", curdate(), curdate(), "Checkings", 20008);
insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989830, "", "U", 222.00, "maker1", curdate(), curdate(), "Checkings", 20009);
insert ignore into accounts(ACCOUNTID, AUTHNAME, AUTHSTATUS, BALANCE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION, TYPEOFACCOUNT, preferenceID) values (4536989831, "", "U", 222.00, "maker2", curdate(), curdate(), "Checkings", 20010);

insert ignore into customeraccounts(custId, accountID) values (1234, 4536989823);
insert ignore into customeraccounts(custId, accountID) values (1234, 4536989824);
insert ignore into customeraccounts(custId, accountID) values (1235, 4536989825);
insert ignore into customeraccounts(custId, accountID) values (1236, 4536989826);
insert ignore into customeraccounts(custId, accountID) values (1237, 4536989827);
insert ignore into customeraccounts(custId, accountID) values (1237, 4536989828);
insert ignore into customeraccounts(custId, accountID) values (1238, 4536989829);
insert ignore into customeraccounts(custId, accountID) values (1238, 4536989821);
insert ignore into customeraccounts(custId, accountID) values (1239, 4536989830);
insert ignore into customeraccounts(custId, accountID) values (1240, 4536989831);

insert ignore into cards(CARDNO, AUTHNAME, AUTHSTATUS, CARDEXPIRY, CARDTYPE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION) values(4433454534342323, "checker1", "A", curdate(), "Credit", "maker1", curdate(), curdate());
insert ignore into cards(CARDNO, AUTHNAME, AUTHSTATUS, CARDEXPIRY, CARDTYPE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION) values(4433454534346780, "checker2", "A", curdate(), "Debit", "maker2", curdate(), curdate());
insert ignore into cards(CARDNO, AUTHNAME, AUTHSTATUS, CARDEXPIRY, CARDTYPE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION) values(4433454534348908, "checker3", "A", curdate(), "Credit", "maker3", curdate(), curdate());
insert ignore into cards(CARDNO, AUTHNAME, AUTHSTATUS, CARDEXPIRY, CARDTYPE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION) values(4433454534342987, "checker4", "A", curdate(), "Debit", "maker4", curdate(), curdate());
insert ignore into cards(CARDNO, AUTHNAME, AUTHSTATUS, CARDEXPIRY, CARDTYPE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION) values(4433454534342981, "", "U", curdate(), "Debit", "maker4", curdate(), curdate());
insert ignore into cards(CARDNO, AUTHNAME, AUTHSTATUS, CARDEXPIRY, CARDTYPE, CREATORNAME, DATELASTMODIFIED, DATEOFCREATION) values(4433454534342967, "", "U", curdate(), "Debit", "maker3", curdate(), curdate());

insert ignore into accountcards(accountID, cardNo) values(4536989823, 4433454534342323);
insert ignore into accountcards(accountID, cardNo) values(4536989825, 4433454534346780);
insert ignore into accountcards(accountID, cardNo) values(4536989826, 4433454534348908);
insert ignore into accountcards(accountID, cardNo) values(4536989828, 4433454534342987);
insert ignore into accountcards(accountID, cardNo) values(4536989830, 4433454534342981);
insert ignore into accountcards(accountID, cardNo) values(4536989831, 4433454534342967);