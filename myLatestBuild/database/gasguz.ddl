
    drop table if exists gasguz.GG_AUTHORIZED_USER;

    drop table if exists gasguz.GG_GAS_GRADE;

    drop table if exists gasguz.GG_GAS_PRICE;

    drop table if exists gasguz.GG_ROLE;

    drop table if exists gasguz.GG_TRANSACTION;

    drop table if exists gasguz.GG_USER;

    drop table if exists gasguz.GG_USER_GAS_AMOUNT;

    drop table if exists gasguz.GG_USER_ROLE;

    drop table if exists gasguz.GG_USER_VENDOR;

    drop table if exists gasguz.GG_VENDOR;

    drop table if exists gasguz.GG_VENDOR_LOCATION;

    create table gasguz.GG_AUTHORIZED_USER (
        ID bigint not null auto_increment,
        USER_ID bigint not null,
        FNAME varchar(255) not null,
        LNAME varchar(255) not null,
        PIN varchar(255) not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID)
    );

    create table gasguz.GG_GAS_GRADE (
        ID bigint not null auto_increment,
        NAME varchar(255) not null,
        OCTANE varchar(255) not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID)
    );

    create table gasguz.GG_GAS_PRICE (
        ID bigint not null auto_increment,
        VENDOR_LOCATION_ID bigint not null,
        GAS_GRADE_ID bigint not null,
        PRICE decimal(17,3) not null,
        LAST_ID bigint,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID)
    );

    create table gasguz.GG_ROLE (
        ID bigint not null auto_increment,
        DESCRIPTION varchar(255) not null,
        STATUS varchar(255) not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID)
    );

    create table gasguz.GG_TRANSACTION (
        ID bigint not null auto_increment,
        USER_ID bigint not null,
        VENDOR_LOCATION_ID bigint not null,
        GAS_GRADE_ID bigint not null,
        COST decimal(17,3),
        AMOUNT decimal(17,3) not null,
        TRANSACTION_TYPE varchar(255) not null,
        TRANSACTION_DATE datetime not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID)
    );

    create table gasguz.GG_USER (
        ID bigint not null auto_increment,
        USERNAME varchar(255) not null,
        PASSWORD varchar(255) not null,
        FNAME varchar(255) not null,
        LNAME varchar(255) not null,
        EMAIL varchar(255) not null,
        PHONE varchar(255) not null,
        STATUS varchar(255) not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID),
        unique (USERNAME)
    );

    create table gasguz.GG_USER_GAS_AMOUNT (
        ID bigint not null auto_increment,
        USER_ID bigint not null,
        VENDOR_LOCATION_ID bigint not null,
        GAS_GRADE_ID bigint not null,
        AMOUNT decimal(17,3) not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID),
        unique (USER_ID, VENDOR_LOCATION_ID, GAS_GRADE_ID)
    );

    create table gasguz.GG_USER_ROLE (
        ID bigint not null auto_increment,
        USER_ID bigint not null,
        ROLE_ID bigint not null,
        STATUS varchar(255) not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID),
        unique (USER_ID, ROLE_ID)
    );

    create table gasguz.GG_USER_VENDOR (
        ID bigint not null auto_increment,
        USER_ID bigint not null,
        VENDOR_ID bigint not null,
        STATUS varchar(255) not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID),
        unique (USER_ID, VENDOR_ID)
    );

    create table gasguz.GG_VENDOR (
        ID bigint not null auto_increment,
        NAME varchar(255) not null,
        EMAIL varchar(255) not null,
        PHONE varchar(255) not null,
        STATUS varchar(255) not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID)
    );

    create table gasguz.GG_VENDOR_LOCATION (
        ID bigint not null auto_increment,
        VENDOR_ID bigint not null,
        NAME varchar(255) not null,
        ADDRESS varchar(255) not null,
        PHONE varchar(255) not null,
        STATUS varchar(255) not null,
        DATE_CREATED datetime not null,
        DATE_MODIFIED datetime not null,
        primary key (ID)
    );
