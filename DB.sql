SET storage_engine=InnoDB;
drop database IF EXISTS StationeryDB;
create database StationeryDB character set utf8;
use StationeryDB;

CREATE TABLE Client(
	cltId VARCHAR(10) NOT NULL,
	cltPswd VARCHAR(10) NOT NULL,
	cltFullName VARCHAR(30) NOT NULL,
	cltTel VARCHAR(12) NOT NULL,
	deliveryAddress VARCHAR(50) NOT NULL,
	cltBounsPoint NUMERIC(6) NOT NULL,
	PRIMARY KEY(cltId)
)ENGINE = InnoDB
;

INSERT INTO Client VALUES ('c0001', '0000', "Tony Sit", "+85268795423", "Tsing Yi", 0);
INSERT INTO Client VALUES ('c0002', '1111', "Noob Cho", "+85298762341", "Sha Tin", 0);
INSERT INTO Client VALUES ('c0003', '2222', "jimmy Chan", "+85251213417", "Tsuen Wan", 0);
INSERT INTO Client VALUES ('c0004', '3333', "Peter Ho", "+85291236521", "Mong Kok", 0);
INSERT INTO Client VALUES ('c0005', '4444', "May Choi", "+85267778821", "Tsim Sha Tsui", 0);

CREATE TABLE Staff(
	staId VARCHAR(10) NOT NULL,
	staPswd VARCHAR(10) NOT NULL,
	staFullName VARCHAR(30) NOT NULL,
	staTel VARCHAR(12) NOT NULL,
	PRIMARY KEY(staId)
)ENGINE = InnoDB
;

INSERT INTO Staff VALUES ('s0001', '0000', "waisik", "+85212345678");

CREATE TABLE Product(
	productId VARCHAR(10) NOT NULL,
	productName VARCHAR(30) NOT NULL,
	productQty NUMERIC(4) NOT NULL,
	productPrice NUMERIC(5) NOT NULL,
	productImg VARCHAR(100) NOT NULL,
	PRIMARY KEY(productId)
)ENGINE = InnoDB
;

INSERT INTO Product VALUES ('p0001', 'G2', 57, '15', '../abc.');
INSERT INTO Product VALUES ('p0002', 'WEX', 75, '12', '../abc.');
INSERT INTO Product VALUES ('p0003', 'ACROBALL', 88, '14', '../abc.');
INSERT INTO Product VALUES ('p0004', 'vicuna', 96, '10', '../abc.');
INSERT INTO Product VALUES ('p0015', 'Whiteboard Marker', 67, '20', '../abc.');
INSERT INTO Product VALUES ('p0016', 'Sign Pen', 87, '18', '../abc.');

INSERT INTO Product VALUES ('p0005', 'Straightedge', 24, '5', '../abc.');
INSERT INTO Product VALUES ('p0006', 'Tiechi', 64, '20', '../abc.');
INSERT INTO Product VALUES ('p0007', 'Triangle ruler', 42, '14', '../abc.');
INSERT INTO Product VALUES ('p0029', 'T-square', 42, '20', '../abc.');

INSERT INTO Product VALUES ('p0008', 'eraser', 73, '5', '../abc.');

INSERT INTO Product VALUES ('p0009', 'Adhesive', 52, '15', '../abc.');
INSERT INTO Product VALUES ('p0026', 'Glue Stick', 48, '14', '../abc.');
INSERT INTO Product VALUES ('p0010', 'Tape Dispenser', 17, '30', '../abc.');
INSERT INTO Product VALUES ('p0024', 'Adhesive Tape', 43, '4', '../abc.');
INSERT INTO Product VALUES ('p0025', 'Double Side Tape', 23, '7', '../abc.');

INSERT INTO Product VALUES ('p0011', 'Clips holder', 42, '3', '../abc.');
INSERT INTO Product VALUES ('p0018', 'Paper Clips', 58, '4', '../abc.');
INSERT INTO Product VALUES ('p0019', 'Binder Clips', 42, '2', '../abc.');
INSERT INTO Product VALUES ('p0020', 'Clips', 34, '2', '../abc.');

INSERT INTO Product VALUES ('p0012', 'Pen Holder', 10, '20', '../abc.');

INSERT INTO Product VALUES ('p0013', 'Correction Fluid', 30, '15', '../abc.');
INSERT INTO Product VALUES ('p0014', 'Correction Tape', 30, '14', '../abc.');

INSERT INTO Product VALUES ('p0017', 'pen bag', 20, '20', '../abc.');

INSERT INTO Product VALUES ('p0021', 'Scissors', 40, '10', '../abc.');
INSERT INTO Product VALUES ('p0022', 'Cutters', 50, '6', '../abc.');
INSERT INTO Product VALUES ('p0023', 'Cutting Mat', 10, '30', '../abc.');

INSERT INTO Product VALUES ('p0027', 'Stapler', 30, '20', '../abc.');
INSERT INTO Product VALUES ('p0028', 'Punch', 30, '17', '../abc.');

CREATE TABLE ClientLog(
	cltId VARCHAR(10) NOT NULL,
	productId VARCHAR(10) NOT NULL,
	productQty NUMERIC(4) NOT NULL,
	PRIMARY KEY(cltId),
	FOREIGN KEY (productId) REFERENCES Product(productId)
)ENGINE = InnoDB
;

CREATE TABLE Category(
	productId VARCHAR(10) NOT NULL,
	category VARCHAR(30) NOT NULL,
	PRIMARY KEY(productId),
	FOREIGN KEY (productId) REFERENCES Product(productId)
)ENGINE = InnoDB
;

INSERT INTO Category VALUES ('p0001','pen');
INSERT INTO Category VALUES ('p0002','pen');
INSERT INTO Category VALUES ('p0003','pen');
INSERT INTO Category VALUES ('p0004','pen');
INSERT INTO Category VALUES ('p0015','pen');
INSERT INTO Category VALUES ('p0016','pen');

INSERT INTO Category VALUES ('p0005', 'measure');
INSERT INTO Category VALUES ('p0006', 'measure');
INSERT INTO Category VALUES ('p0007', 'measure');
INSERT INTO Category VALUES ('p0029', 'measure');

INSERT INTO Category VALUES ('p0008', 'rubber');

INSERT INTO Category VALUES ('p0009', 'adhesive');
INSERT INTO Category VALUES ('p0026', 'adhesive');
INSERT INTO Category VALUES ('p0010', 'adhesive');
INSERT INTO Category VALUES ('p0024', 'adhesive');
INSERT INTO Category VALUES ('p0025', 'adhesive');

INSERT INTO Category VALUES ('p0011', 'clip');
INSERT INTO Category VALUES ('p0018', 'clip');
INSERT INTO Category VALUES ('p0019', 'clip');
INSERT INTO Category VALUES ('p0020', 'clip');

INSERT INTO Category VALUES ('p0012', 'Pen Holder');

INSERT INTO Category VALUES ('p0013', 'corr');
INSERT INTO Category VALUES ('p0014', 'corr');

INSERT INTO Category VALUES ('p0017', 'pen bag');

INSERT INTO Category VALUES ('p0021', 'cut');
INSERT INTO Category VALUES ('p0022', 'cut');
INSERT INTO Category VALUES ('p0023', 'cut');

INSERT INTO Category VALUES ('p0027', 'binding');
INSERT INTO Category VALUES ('p0028', 'binding');

CREATE TABLE history(
	orderId VARCHAR(10) NOT NULL,
	cltId VARCHAR(10) NOT NULL,
	orderDate DATE NOT NULL,
	price VARCHAR(6) NOT NULL,
	productId VARCHAR(5) NOT NULL,
	productQty VARCHAR(4) NOT NULL,
	PRIMARY KEY(orderId),
	FOREIGN KEY (cltId) REFERENCES Client(cltId),
	FOREIGN KEY (productId) REFERENCES Product(productId)
)ENGINE = InnoDB
;
