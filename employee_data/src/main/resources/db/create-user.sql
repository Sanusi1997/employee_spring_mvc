DROP USER 'employee_user'@'localhost';

CREATE USER 'employee_user'@'localhost' IDENTIFIED BY 'employee123';

GRANT ALL PRIVILEGES ON employee_db.* TO 'employee_user'@'localhost'; 

FLUSH PRIVILEGES;

CREATE DATABASE IF NOT EXISTS employee_db;

CREATE DATABASE employee_db;