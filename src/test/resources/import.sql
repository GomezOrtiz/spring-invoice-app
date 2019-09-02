/* Populate table clients */

INSERT INTO clients (name, surname, email, created_at) VALUES ('David', 'Gómez', 'dagor@gmail.com', '2019-08-06');
INSERT INTO clients (name, surname, email, created_at) VALUES ('Lucía', 'Astray', 'lulas@gmail.com', '2019-08-04');
INSERT INTO clients (name, surname, email, created_at) VALUES ('Alfonso', 'Cerezuela', 'fons@gmail.com', '2019-07-15');
INSERT INTO clients (name, surname, email, created_at) VALUES ('Enrique', 'Álvarez de Toledo', 'henry@gmail.com', '2019-07-15');
INSERT INTO clients (name, surname, email, created_at) VALUES ('José Luis', 'Avilés', 'peplu@gmail.com', '2019-07-15');

/* Populate table products */

INSERT INTO products (name, price) VALUES ('Panasonic Pantalla LCD', 259990);
INSERT INTO products (name, price) VALUES ('Sony Camara digital DSC-W320B', 123490);
INSERT INTO products (name, price) VALUES ('Apple iPod shuffle', 1499990);
INSERT INTO products (name, price) VALUES ('Sony Notebook Z110', 37990);

/* Create some invoices */

INSERT INTO invoices (description, details, client_id, created_at) VALUES ('Factura equipos de oficina', null, 1, NOW());
INSERT INTO invoice_items (amount, invoice_id, product_id) VALUES (1, 1, 1);
INSERT INTO invoice_items (amount, invoice_id, product_id) VALUES (2, 1, 4);
INSERT INTO invoice_items (amount, invoice_id, product_id) VALUES (1, 1, 5);
INSERT INTO invoice_items (amount, invoice_id, product_id) VALUES (1, 1, 7);