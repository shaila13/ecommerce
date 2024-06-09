INSERT INTO users (user_id, user_name, first_name, last_name, email, address, cellphone, password, user_type, date_created)
VALUES (1, 'jdoe', 'John', 'Doe', 'johndoe@example.com', '123 Main St', '123-456-7890', 'password123', 'CUSTOMER', '2023-01-01 10:00:00');

INSERT INTO users (user_id, user_name, first_name, last_name, email, address, cellphone, password, user_type, date_created)
VALUES (2, 'asmith', 'Alice', 'Smith', 'alicesmith@example.com', '456 Elm St', '987-654-3210', 'password456', 'ADMIN', '2023-02-01 11:00:00');

INSERT INTO users (user_id, user_name, first_name, last_name, email, address, cellphone, password, user_type, date_created)
VALUES (3, 'bwillis', 'Bob', 'Willis', 'bobwillis@example.com', '789 Oak St', '555-666-7777', 'password789', 'CUSTOMER', '2023-03-01 12:00:00');

INSERT INTO users (user_id, user_name, first_name, last_name, email, address, cellphone, password, user_type, date_created)
VALUES (4, 'cjones', 'Carol', 'Jones', 'caroljones@example.com', '101 Pine St', '222-333-4444', 'password000', 'ADMIN', '2023-04-01 13:00:00');

INSERT INTO users (user_id, user_name, first_name, last_name, email, address, cellphone, password, user_type, date_created)
VALUES (5, 'dgreen', 'David', 'Green', 'davidgreen@example.com', '202 Cedar St', '333-444-5555', 'password111', 'CUSTOMER', '2023-05-01 14:00:00');


INSERT INTO products (product_id, code, name, description, image, price, date_created, date_updated, user_id)
VALUES (1, '3b241101-e2bb-4255-8caf-4136c566a962', 'Product A', 'Description for Product A', 'imageA.png', 29.99, '2023-01-01 10:00:00', '2023-01-01 10:00:00', 1);

INSERT INTO products (product_id, code, name, description, image, price, date_created, date_updated, user_id)
VALUES (2, '58b0d41d-ef4e-4efb-83d9-f0f9f3b8e62e', 'Product B', 'Description for Product B', 'imageB.png', 49.99, '2023-02-01 11:00:00', '2023-02-01 11:00:00', 2);

INSERT INTO products (product_id, code, name, description, image, price, date_created, date_updated, user_id)
VALUES (3, '96e91a65-b1d1-4a1c-8b1a-7b1e9b9e1e9d', 'Product C', 'Description for Product C', 'imageC.png', 19.99, '2023-03-01 12:00:00', '2023-03-01 12:00:00', 3);

INSERT INTO products (product_id, code, name, description, image, price, date_created, date_updated, user_id)
VALUES (4, 'cd3bca1a-321c-497f-947d-10bb6dfbb5c9', 'Product D', 'Description for Product D', 'imageD.png', 39.99, '2023-04-01 13:00:00', '2023-04-01 13:00:00', 4);

INSERT INTO products (product_id, code, name, description, image, price, date_created, date_updated, user_id)
VALUES (5, 'a1b2c3d4-e5f6-7a8b-9c0d-e1f2a3b4c5d6', 'Product E', 'Description for Product E', 'imageE.png', 59.99, '2023-05-01 14:00:00', '2023-05-01 14:00:00', 5);