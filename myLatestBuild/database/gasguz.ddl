
    drop table if exists gasguz.GG_ACCOUNT;

    create table gasguz.GG_ACCOUNT (
        ID bigint not null auto_increment,
        USERNAME varchar(255) not null,
        PASSWORD varchar(255) not null,
        FNAME varchar(255) not null,
        LNAME varchar(255) not null,
        EMAIL varchar(255) not null,
        ADD_DTTM date not null,
        LASTUPDATE_DTTM date not null,
        primary key (ID),
        unique (USERNAME)
    );
