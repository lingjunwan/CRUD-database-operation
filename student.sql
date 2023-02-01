DROP DATABASE IF EXISTS test_webservicefsd006;
CREATE DATABASE IF NOT EXISTS test_webservicefsd006;
USE test_webservicefsd006;

DROP TABLE IF EXISTS student;
CREATE TABLE student (
    studentNo INT PRIMARY KEY AUTO_INCREMENT,
    fName VARCHAR(255) NOT NULL,
    lName VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    activeflag BOOLEAN NOT NULL
);

INSERT INTO student(studentNo, fName, lName, address, activeflag)
VALUES
(1,'Kobe', 'Bryant', 'STARS', true),
(2,'Tony', 'Parker', 'STARS', true),
(3,'Kevin', 'Durant', 'STARS', true),
(4,'Jason', 'Kid', 'STARS', true);

SELECT * FROM test_webservicefsd006.student;