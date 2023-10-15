INSERT INTO restaurants (restaurant_name)
VALUES ('Мак'),
       ('БугерКвин'),
       ('КФЦ');


--################# Мак ################################
--#### c 1 по 8
INSERT INTO restaurant_address (street_name, city, date_of_add, restaurant_status)
VALUES ('ул. Керченская, д. 13А', 'Нижний Новгород', '2022-08-05', 'ACTIVE'),
       ('ул. Бетанкура, д. 1', 'Нижний Новгород', '2017-03-20', 'ACTIVE'),
       ('пл. Революции, д. 5А', 'Нижний Новгород', '2004-05-17', 'ACTIVE'),
       ('наб. Нижне-Волжская, д. 2', 'Нижний Новгород', '2022-09-09', 'ACTIVE'),
       ('пл. Максима Горького', 'Нижний Новгород', '2011-08-11', 'ACTIVE'),
       ('ул. Большая Покровская, д. 82', 'Нижний Новгород', '2020-07-10', 'ACTIVE'),
       ('ш. Московское, д. 122', 'Нижний Новгород', '2008-04-05', 'ACTIVE'),
       ('пр-кт Ленина, д. 18Б', 'Нижний Новгород', '2012-01-11', 'ACTIVE');

INSERT INTO restaurants_restaurant_address
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8);

--#### c 1 по 16
INSERT INTO menu_items (item_name, item_price, item_status)
VALUES ('БигХит', 182, 'AVAILABLE'),
       ('Град', 193, 'AVAILABLE'),
       ('Гранд Де Люкс', 219, 'AVAILABLE'),
       ('Биг Спешиал', 299, 'AVAILABLE'),
       ('Чизбургер', 78, 'AVAILABLE'),
       ('Гамбургер', 65, 'AVAILABLE'),
       ('Чикенбургер', 59, 'AVAILABLE'),
       ('Чикенбургер', 59, 'AVAILABLE'),
       ('Картофель Фри мал.', 65, 'AVAILABLE'),
       ('Картофель Фри ср.', 89, 'AVAILABLE'),
       ('Картофель Фри бол.', 150, 'AVAILABLE'),
       ('Картофель Фри бол.', 150, 'AVAILABLE'),
       ('Соус', 45, 'AVAILABLE'),
       ('Кола мал.', 89, 'AVAILABLE'),
       ('Кола ср.', 99, 'AVAILABLE'),
       ('Кола бол.', 109, 'AVAILABLE');

INSERT INTO restaurants_menu_items
VALUES (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (1, 5),
       (1, 6),
       (1, 7),
       (1, 8),
       (1, 9),
       (1, 10),
       (1, 11),
       (1, 12),
       (1, 13),
       (1, 14),
       (1, 15),
       (1, 16);


--################# БугерКвин ################################
--#### c 9 по 16
INSERT INTO restaurant_address (street_name, city, date_of_add, restaurant_status)
VALUES ('пл. Революции, д. 2А', 'Нижний Новгород', '2012-07-08', 'ACTIVE'),
       ('ш. Московское, д. 12', 'Нижний Новгород', '2015-01-27', 'ACTIVE'),
       ('ул. Большая Покровская, д. 82', 'Нижний Новгород', '2011-02-25', 'ACTIVE'),
       ('ул. Бетанкура, д. 1', 'Нижний Новгород', '2014-03-03', 'ACTIVE'),
       ('пл. Максима Горького, д. 1', 'Нижний Новгород', '2014-07-11', 'ACTIVE'),
       ('пр. Ленина, д. 33', 'Нижний Новгород', '2020-07-10', 'ACTIVE'),
       ('ул. Интернациональная, д. 12', 'Бор', '2008-04-05', 'ACTIVE'),
       ('ул. Дьяконова, д. 11а', 'Нижний Новгород', '2012-01-11', 'ACTIVE');

INSERT INTO restaurants_restaurant_address
VALUES (2, 9),
       (2, 10),
       (2, 11),
       (2, 12),
       (2, 13),
       (2, 14),
       (2, 15),
       (2, 16);

--#### c 17 по 33
INSERT INTO menu_items (item_name, item_price, item_status)
VALUES ('Ангус Трюфель', 455, 'AVAILABLE'),
       ('Ангус Трюфель Двойной', 605, 'AVAILABLE'),
       ('Чикенбургер', 90, 'AVAILABLE'),
       ('Чикер Тар-Тар', 220, 'AVAILABLE'),
       ('Цезарь Кинг', 130, 'AVAILABLE'),
       ('Фиш Бургер', 160, 'AVAILABLE'),
       ('Шримп Ролл', 290, 'AVAILABLE'),
       ('Кинг Букет "Креветки"', 730, 'AVAILABLE'),
       ('Кинг Фри мал.', 90, 'AVAILABLE'),
       ('Кинг Фри ср.', 105, 'AVAILABLE'),
       ('Кинг Фри бол.', 140, 'AVAILABLE'),
       ('Воппер', 255, 'AVAILABLE'),
       ('Соус', 50, 'AVAILABLE'),
       ('Наггесты 9 шт.', 155, 'AVAILABLE'),
       ('Кола мал.', 109, 'AVAILABLE'),
       ('Кола ср.', 140, 'AVAILABLE'),
       ('Кола бол.', 180, 'AVAILABLE');

INSERT INTO restaurants_menu_items
VALUES (2, 17),
       (2, 18),
       (2, 19),
       (2, 20),
       (2, 21),
       (2, 22),
       (2, 23),
       (2, 24),
       (2, 25),
       (2, 26),
       (2, 27),
       (2, 28),
       (2, 29),
       (2, 30),
       (2, 31),
       (2, 32),
       (2, 33);

--################# КФЦ ################################
--#### c 17 по 22
INSERT INTO restaurant_address (street_name, city, date_of_add, restaurant_status)
VALUES ('пр. Ленина, д. 108', 'Нижний Новгород', '2015-07-15', 'ACTIVE'),
       ('ул. Деревообделочная, д. 8', 'Нижний Новгород', '2017-02-22', 'ACTIVE'),
       ('ул. Бетанкура, д. 1', 'Нижний Новгород', '2011-02-25', 'ACTIVE'),
       ('ул. Большая Покровская, д. 47', 'Нижний Новгород', '2013-02-13', 'ACTIVE'),
       ('пл. Максима Горького, д. 1', 'Нижний Новгород', '2014-07-11', 'ACTIVE'),
       ('пл. Минина и Пожарского, д. 11', 'Нижний Новгород', '2011-12-10', 'ACTIVE');

INSERT INTO restaurants_restaurant_address
VALUES (3, 17),
       (3, 18),
       (3, 19),
       (3, 20),
       (3, 21),
       (3, 22);

--#### c 34 по 33
INSERT INTO menu_items (item_name, item_price, item_status)
VALUES ('Баскет L 24 Острых Крылышка', 709, 'AVAILABLE'),
       ('Баскет "12 Острых Крылышек + 12 Наггетсов"', 574, 'AVAILABLE'),
       ('Баскет Дуэт Оригинальный', 494, 'AVAILABLE'),
       ('Шеф Баскет Острый', 254, 'AVAILABLE'),
       ('Всё Сразу Баскет', 209, 'AVAILABLE'),
       ('Биг Маэстро Бургер Оригинальный', 284, 'AVAILABLE'),
       ('Чизбургер', 99, 'AVAILABLE'),
       ('АйТвистер Чиз"', 79, 'AVAILABLE'),
       ('Кинг Фри мал.', 74, 'AVAILABLE'),
       ('Кинг Фри ср.', 94, 'AVAILABLE'),
       ('Кинг Фри бол.', 174, 'AVAILABLE'),
       ('Пати Бокс', 144, 'AVAILABLE'),
       ('Соус', 44, 'AVAILABLE'),
       ('Мороженое Кокос в шоколаде', 129, 'AVAILABLE'),
       ('Кола мал.', 94, 'AVAILABLE'),
       ('Кола ср.', 114, 'AVAILABLE'),
       ('Кола бол.', 139, 'AVAILABLE');

INSERT INTO restaurants_menu_items
VALUES (3, 34),
       (3, 35),
       (3, 36),
       (3, 37),
       (3, 38),
       (3, 39),
       (3, 40),
       (3, 41),
       (3, 42),
       (3, 43),
       (3, 44),
       (3, 45),
       (3, 46),
       (3, 47),
       (3, 48),
       (3, 49),
       (3, 50);

--################# Orders ################################
insert into orders (order_price, type_of_delivery, order_status)
values (2421, 'COURIER_DELIVERY', 'IN_WORK'),
       (3290, 'COURIER_DELIVERY', 'DONE');


insert into order_items (order_id, address_id, item_id, quantity)
values (1, 1, 1, 1),
       (1, 1, 2, 2),
       (1, 1, 3, 3),
       (1, 1, 4, 4);

insert into order_items (order_id, address_id, item_id, quantity)
values (2, 10, 22, 1),
       (2, 10, 23, 2),
       (2, 10, 24, 3),
       (2, 10, 25, 4);

--################# Couriers ################################
insert into couriers (phone_number, courier_status)
values (+78805535354, 'HURRIES_TO_ORDER'),
       (+78807864354, 'FREE'),
       (+78607867864, 'FIRED');

insert into coordinates (latitude, longitude)
values (63.486606, 95.569739),
       (63.498864, 95.707160);

insert into couriers_coordinates (courier_id, coordinate_id)
values (1, 1),
       (2, 2);

insert into courier_orders (courier_id, order_id)
values (1, 1),
       (3, 2);

--################# Couriers ################################
--password SHA512
insert into customers (email, username, password)
values ('cust1@mail.ru',
        'cuct1',
        'ba3253876aed6bc22d4a6ff53d8406c6ad864195ed144ab5c87621b6c233b548baeae6956df346ec8c17f5ea10f35ee3cbc514797ed7ddd3145464e2a0bab413'),
       ('cust2@mail.ru',
        'cuct2',
        'e13efc991a9bf44bbb4da87cdbb725240184585ccaf270523170e008cf2a3b85f45f86c3da647f69780fb9e971caf5437b3d06d418355a68c9760c70a31d05c7'),
       ('cust3@mail.ru',
        'cuct3',
        'fa585d89c851dd338a70dcf535aa2a92fee7836dd6aff1226583e88e0996293f16bc009c652826e0fc5c706695a03cddce372f139eff4d13959da6f1f5d3eabe');

insert into customer_addressees (city, street, house_number, house_section, house_floor)
values ('Нижний Новгород', 'Бетанкура', 2, 2, 3),
       ('Нижний Новгород', 'Керченская', 22, 2, 5),
       ('Нижний Новгород', 'Большая покровская', 13, 1, 1);

insert into customers_customer_addressees (customer_id, address_id)
values (1, 1),
       (2, 2),
       (3, 3);

insert into customer_order (customer_id, order_id)
values (1, 1),
       (2, 2);

