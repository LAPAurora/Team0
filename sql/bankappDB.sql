create database bankappDB;
use bankappDB;
-- 创建用户表
CREATE TABLE User (
    UserID INT PRIMARY KEY,
    Username VARCHAR(50),
    Password VARCHAR(50),
    PhoneNumber VARCHAR(20)
);

-- 创建账户表
CREATE TABLE Account (
    AccountID INT PRIMARY KEY,
    UserID INT,
    AccountType VARCHAR(50),
    Balance DECIMAL(10, 2),
    CreateDate DATE,
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

-- 创建转账表
CREATE TABLE Transfer (
    TransferID INT PRIMARY KEY  AUTO_INCREMENT,
    SenderAccountID INT,
    ReceiverAccountID INT,
    Amount DECIMAL(8, 2),
    TransferDate DATETIME,
    FOREIGN KEY (SenderAccountID) REFERENCES Account(AccountID),
    FOREIGN KEY (ReceiverAccountID) REFERENCES Account(AccountID)
);

-- 创建支付表
CREATE TABLE Payment (
    PaymentID INT PRIMARY KEY,
    UserID INT,
    Amount DECIMAL(10, 2),
    PaymentDate DATE,
    PaymentType VARCHAR(50),
    PaymentStatus VARCHAR(50),
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

-- 创建借记卡表
CREATE TABLE DebitCard (
    CardNumber VARCHAR(16) PRIMARY KEY,
    UserID INT,
    ExpirationDate DATE,
    SecurityCode VARCHAR(3),
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);

-- 创建信用卡表
CREATE TABLE CreditCard (
    CardNumber VARCHAR(16) PRIMARY KEY,
    UserID INT,
    ExpirationDate DATE,
    CreditLimit DECIMAL(10, 2),
    CurrentDebt DECIMAL(10, 2),
    FOREIGN KEY (UserID) REFERENCES User(UserID)
);
