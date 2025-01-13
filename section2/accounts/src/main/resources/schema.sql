-- Creating the CUSTOMER Table
CREATE TABLE IF NOT EXISTS CUSTOMER (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100),
    email VARCHAR(100),
    mobile_number VARCHAR(20) NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_at DATE NOT NULL,
    updated_by VARCHAR(20) DEFAULT NULL
);

-- Creating the ACCOUNTS Table
CREATE TABLE IF NOT EXISTS ACCOUNTS (
    account_number INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT NOT NULL,
    account_type VARCHAR(100) NOT NULL,
    branch_address VARCHAR(100) NOT NULL,
    created_at DATE NOT NULL,
    created_by VARCHAR(20) NOT NULL,
    updated_at DATE NOT NULL,
    updated_by VARCHAR(20) DEFAULT NULL,
    FOREIGN KEY (customer_id) REFERENCES CUSTOMER(customer_id)
);
