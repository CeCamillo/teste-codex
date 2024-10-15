CREATE TABLE CLIENT (
                        client_id INT PRIMARY KEY AUTO_INCREMENT,
                        name VARCHAR(100) NOT NULL,
                        email VARCHAR(100) UNIQUE NOT NULL,
                        phone VARCHAR(20)
);

CREATE TABLE PRODUCT (
                         product_id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(100) NOT NULL,
                         price DECIMAL(10, 2) NOT NULL,
                         stock_quantity INT NOT NULL
);

CREATE TABLE ORDER (
                         order_id INT PRIMARY KEY AUTO_INCREMENT,
                         client_id INT NOT NULL,
                         order_date DATE NOT NULL,
                         status VARCHAR(20) NOT NULL,
                         FOREIGN KEY (client_id) REFERENCES CLIENT(client_id)
);

CREATE TABLE ORDER_ITEM (
                            order_item_id INT PRIMARY KEY AUTO_INCREMENT,
                            order_id INT NOT NULL,
                            product_id INT NOT NULL,
                            quantity INT NOT NULL,
                            unit_price DECIMAL(10, 2) NOT NULL,
                            FOREIGN KEY (order_id) REFERENCES `ORDER`(order_id),
                            FOREIGN KEY (product_id) REFERENCES PRODUCT(product_id)
);