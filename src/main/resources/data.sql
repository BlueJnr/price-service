INSERT INTO BRAND(ID, NAME)
VALUES (1, 'ZARA');

INSERT INTO PRICE_LIST(ID)
VALUES (1),
       (2),
       (3),
       (4);

INSERT INTO PRODUCT(ID)
VALUES (35455);

INSERT INTO PRICE(BRAND_ID, PRICE_LIST_ID, PRODUCT_ID, START_DATE, END_DATE, PRIORITY, PRICE, CURR)
VALUES (1, 1, 35455, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 0, 35.50, 'EUR'),
       (1, 2, 35455, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 1, 25.45, 'EUR'),
       (1, 3, 35455, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 1, 30.50, 'EUR'),
       (1, 4, 35455, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 1, 38.95, 'EUR');