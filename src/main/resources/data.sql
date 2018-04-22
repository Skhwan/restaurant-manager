INSERT INTO MENU VALUES ('Hawaiian Pizza', 'All-time favorite topping, Hawaiian pizza in Topical Hawaii style', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu1.jpg', 300, 'Italian,Ham,Pineapple');
INSERT INTO MENU VALUES ('Chicken Tom Yum Pizza', 'Best Marinated chicken with pineapple and mushroom on spicy lemon sauce, Thai pizza style', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu2.jpg', 300, 'Italian,Thai,Chicken,Mushroom,Hot');
INSERT INTO MENU VALUES ('Xiaolongbao', 'Chinese steamed bun', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu3.jpg', 300, 'Chinese,Pork,Recommended');
INSERT INTO MENU VALUES ('Kimchi', 'Traditional side-dish made from salted and fermented vegetables', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu4.jpg', 300, 'Korean,Radish,Cabbage');
INSERT INTO MENU VALUES ('Oolong Tea', 'Partially fermented tea grown in the Alishan area', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu5.jpg', 300, 'Hot,Non-alcohol');
INSERT INTO MENU VALUES ('Beer', 'Fantastic flavors and authentic regional appeal beer', 'https://s3-ap-southeast-1.amazonaws.com/interview.ampostech.com/backend/restaurant/menu6.jpg', 300, 'Alcohol');

INSERT INTO CUSTOMER_ORDER (BILL_NO, MENU, QUANTITY, ORDERED_TIME, CHECKED_OUT) VALUES ('1', 'Hawaiian Pizza', 1, TO_DATE('1/1/2017 10:00:00', 'DD/MM/YYYY HH24:MI:SS'), 1);
INSERT INTO CUSTOMER_ORDER (BILL_NO, MENU, QUANTITY, ORDERED_TIME, CHECKED_OUT) VALUES ('1', 'Kimchi', 2, TO_DATE('1/1/2017 10:00:00', 'DD/MM/YYYY HH24:MI:SS'), 1);
INSERT INTO CUSTOMER_ORDER (BILL_NO, MENU, QUANTITY, ORDERED_TIME, CHECKED_OUT) VALUES ('1', 'Kimchi', 1, TO_DATE('1/1/2017 11:00:00', 'DD/MM/YYYY HH24:MI:SS'), 1);
INSERT INTO CUSTOMER_ORDER (BILL_NO, MENU, QUANTITY, ORDERED_TIME, CHECKED_OUT) VALUES ('2', 'Xiaolongbao', 1, TO_DATE('1/1/2017 12:00:00', 'DD/MM/YYYY HH24:MI:SS'), 1);
INSERT INTO CUSTOMER_ORDER (BILL_NO, MENU, QUANTITY, ORDERED_TIME, CHECKED_OUT) VALUES ('2', 'Beer', 1, TO_DATE('1/1/2017 12:00:00', 'DD/MM/YYYY HH24:MI:SS'), 1);
INSERT INTO CUSTOMER_ORDER (BILL_NO, MENU, QUANTITY, ORDERED_TIME, CHECKED_OUT) VALUES ('3', 'Oolong Tea', 1, TO_DATE('1/1/2017 15:00:00', 'DD/MM/YYYY HH24:MI:SS'), 1);
INSERT INTO CUSTOMER_ORDER (BILL_NO, MENU, QUANTITY, ORDERED_TIME, CHECKED_OUT) VALUES ('3', 'Beer', 3, TO_DATE('1/1/2017 15:00:00', 'DD/MM/YYYY HH24:MI:SS'), 1);