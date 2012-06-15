
    drop table if exists gasguz.GG_ACCOUNT;

    create table gasguz.GG_ACCOUNT (
        ID bigint not null auto_increment,
        USERNAME varchar(255),
        PASSWORD varchar(255),
        LNAME varchar(255),
        EMAIL varchar(255),
        ADD_DTTM date,
        LASTUPDATE_DTTM date,
        primary key (ID)
    );
