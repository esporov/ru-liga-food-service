INSERT INTO restaurants (restaurant_name)
VALUES ('Мак'),
       ('БугерКвин'),
       ('КФЦ');


--################# Мак ################################
--#### c 1 по 8
INSERT INTO restaurant_address (restaurant_id, street_name, city, date_of_add)
VALUES (1, 'ул. Керченская, д. 13А', 'Нижний Новгород', '2022-08-05'),
       (1, 'ул. Бетанкура, д. 1', 'Нижний Новгород', '2017-03-20'),
       (1, 'пл. Революции, д. 5А', 'Нижний Новгород', '2004-05-17'),
       (1, 'наб. Нижне-Волжская, д. 2', 'Нижний Новгород', '2022-09-09'),
       (1, 'пл. Максима Горького', 'Нижний Новгород', '2011-08-11'),
       (1, 'ул. Большая Покровская, д. 82', 'Нижний Новгород', '2020-07-10'),
       (1, 'ш. Московское, д. 122', 'Нижний Новгород', '2008-04-05'),
       (1, 'пр-кт Ленина, д. 18Б', 'Нижний Новгород', '2012-01-11');


--#### c 1 по 16
INSERT INTO menu_items (restaurant_id, item_name, item_price, item_image, item_description)
VALUES (1, 'БигХит', 182, 'https://images.restaurant/?id=1&item-id=1', 'БигХит'),
       (1, 'Град', 193, 'https://images.restaurant/?id=1&item-id=2', 'Град'),
       (1, 'Гранд Де Люкс', 219, 'https://images.restaurant/?id=1&item-id=3', 'Гранд Де Люкс'),
       (1, 'Биг Спешиал', 299, 'https://images.restaurant/?id=1&item-id=4', 'Биг Спешиал'),
       (1, 'Чизбургер', 78, 'https://images.restaurant/?id=1&item-id=5', 'Чизбургер'),
       (1, 'Гамбургер', 45, 'https://images.restaurant/?id=1&item-id=6', 'Гамбургер'),
       (1, 'Чикенбургер', 59, 'https://images.restaurant/?id=1&item-id=7', 'Чикенбургер'),
       (1, 'Чикенбургер Двойной', 139, 'https://images.restaurant/?id=1&item-id=8', 'Чикенбургер Двойной'),
       (1, 'Картофель Фри мал.', 65, 'https://images.restaurant/?id=1&item-id=9', 'Картофель Фри мал.'),
       (1, 'Картофель Фри ср.', 89, 'https://images.restaurant/?id=1&item-id=10', 'Картофель Фри ср.'),
       (1, 'Картофель Фри бол.', 150, 'https://images.restaurant/?id=1&item-id=11', 'Картофель Фри бол.'),
       (1, 'Картофель Фри бол.', 150, 'https://images.restaurant/?id=1&item-id=12', 'Картофель Фри бол.'),
       (1, 'Соус', 45, 'https://images.restaurant/?id=1&item-id=13', 'Соус'),
       (1, 'Кола мал.', 89, 'https://images.restaurant/?id=1&item-id=14', 'Кола мал.'),
       (1, 'Кола ср.', 99, 'https://images.restaurant/?id=1&item-id=15', 'Кола ср.'),
       (1, 'Кола бол.', 109, 'https://images.restaurant/?id=1&item-id=16', 'Кола бол.');



--################# БугерКвин ################################
--#### c 9 по 16
INSERT INTO restaurant_address (restaurant_id, street_name, city, date_of_add)
VALUES (2, 'пл. Революции, д. 2А', 'Нижний Новгород', '2012-07-08'),
       (2, 'ш. Московское, д. 12', 'Нижний Новгород', '2015-01-27'),
       (2, 'ул. Большая Покровская, д. 82', 'Нижний Новгород', '2011-02-25'),
       (2, 'ул. Бетанкура, д. 1', 'Нижний Новгород', '2014-03-03'),
       (2, 'пл. Максима Горького, д. 1', 'Нижний Новгород', '2014-07-11'),
       (2, 'пр. Ленина, д. 33', 'Нижний Новгород', '2020-07-10'),
       (2, 'ул. Интернациональная, д. 12', 'Бор', '2008-04-05'),
       (2, 'ул. Дьяконова, д. 11а', 'Нижний Новгород', '2012-01-11');


--#### c 17 по 33
INSERT INTO menu_items (restaurant_id, item_name, item_price, item_image, item_description)
VALUES (2, 'Ангус Трюфель', 455, 'https://images.restaurant/?id=2&item-id=17', 'Ангус Трюфель'),
       (2, 'Ангус Трюфель Двойной', 605, 'https://images.restaurant/?id=2&item-id=18', 'Ангус Трюфель Двойной'),
       (2, 'Чикенбургер', 90, 'https://images.restaurant/?id=2&item-id=19', 'Чикенбургер'),
       (2, 'Чикер Тар-Тар', 220, 'https://images.restaurant/?id=2&item-id=20', 'Чикер Тар-Тар'),
       (2, 'Цезарь Кинг', 130, 'https://images.restaurant/?id=2&item-id=21', 'Цезарь Кинг'),
       (2, 'Фиш Бургер', 160, 'https://images.restaurant/?id=2&item-id=22', 'Фиш Бургер'),
       (2, 'Шримп Ролл', 290, 'https://images.restaurant/?id=2&item-id=23', 'Шримп Ролл'),
       (2, 'Кинг Букет "Креветки"', 730, 'https://images.restaurant/?id=2&item-id=24', 'Кинг Букет "Креветки"'),
       (2, 'Кинг Фри мал.', 90, 'https://images.restaurant/?id=2&item-id=25', 'Кинг Фри мал.'),
       (2, 'Кинг Фри ср.', 105, 'https://images.restaurant/?id=2&item-id=26', 'Кинг Фри ср.'),
       (2, 'Кинг Фри бол.', 140, 'https://images.restaurant/?id=2&item-id=27', 'Кинг Фри бол.'),
       (2, 'Воппер', 255, 'https://images.restaurant/?id=2&item-id=28', 'Воппер'),
       (2, 'Соус', 50, 'https://images.restaurant/?id=2&item-id=29', 'Соус'),
       (2, 'Наггесты 9 шт.', 155, 'https://images.restaurant/?id=2&item-id=30', 'Наггесты 9 шт.'),
       (2, 'Кола мал.', 109, 'https://images.restaurant/?id=2&item-id=31', 'Кола мал.'),
       (2, 'Кола ср.', 140, 'https://images.restaurant/?id=2&item-id=32', 'Кола ср.'),
       (2, 'Кола бол.', 180, 'https://images.restaurant/?id=2&item-id=33', 'Кола бол.');


--################# КФЦ ################################
--#### c 17 по 22
INSERT INTO restaurant_address (restaurant_id, street_name, city, date_of_add)
VALUES (3, 'пр. Ленина, д. 108', 'Нижний Новгород', '2015-07-15'),
       (3, 'ул. Деревообделочная, д. 8', 'Нижний Новгород', '2017-02-22'),
       (3, 'ул. Бетанкура, д. 1', 'Нижний Новгород', '2011-02-25'),
       (3, 'ул. Большая Покровская, д. 47', 'Нижний Новгород', '2013-02-13'),
       (3, 'пл. Максима Горького, д. 1', 'Нижний Новгород', '2014-07-11'),
       (3, 'пл. Минина и Пожарского, д. 11', 'Нижний Новгород', '2011-12-10');


--#### c 34 по 50
INSERT INTO menu_items (restaurant_id, item_name, item_price, item_image, item_description)
VALUES (3, 'Баскет L 24 Острых Крылышка', 709, 'https://images.restaurant/?id=3&item-id=34',
        'Баскет L 24 Острых Крылышка'),
       (3, 'Баскет "12 Острых Крылышек + 12 Наггетсов"', 574, 'https://images.restaurant/?id=3&item-id=35',
        'Баскет "12 Острых Крылышек + 12 Наггетсов"'),
       (3, 'Баскет Дуэт Оригинальный', 494, 'https://images.restaurant/?id=3&item-id=36', 'Баскет Дуэт Оригинальный'),
       (3, 'Шеф Баскет Острый', 254, 'https://images.restaurant/?id=3&item-id=37', 'Шеф Баскет Острый'),
       (3, 'Всё Сразу Баскет', 209, 'https://images.restaurant/?id=3&item-id=38', 'Всё Сразу Баскет'),
       (3, 'Биг Маэстро Бургер Оригинальный', 284, 'https://images.restaurant/?id=3&item-id=39',
        'Биг Маэстро Бургер Оригинальный'),
       (3, 'Чизбургер', 99, 'https://images.restaurant/?id=3&item-id=40', 'Чизбургер'),
       (3, 'АйТвистер Чиз"', 79, 'https://images.restaurant/?id=3&item-id=41', 'АйТвистер Чиз"'),
       (3, 'Кинг Фри мал.', 74, 'https://images.restaurant/?id=3&item-id=42', 'Кинг Фри мал.'),
       (3, 'Кинг Фри ср.', 94, 'https://images.restaurant/?id=3&item-id=43', 'Кинг Фри ср.'),
       (3, 'Кинг Фри бол.', 174, 'https://images.restaurant/?id=3&item-id=44', 'Кинг Фри бол.'),
       (3, 'Пати Бокс', 144, 'https://images.restaurant/?id=3&item-id=45', 'Пати Бокс'),
       (3, 'Соус', 44, 'https://images.restaurant/?id=3&item-id=46', 'Соус'),
       (3, 'Мороженое Кокос в шоколаде', 129, 'https://images.restaurant/?id=3&item-id=47',
        'Мороженое Кокос в шоколаде'),
       (3, 'Кола мал.', 94, 'https://images.restaurant/?id=3&item-id=48', 'Кола мал.'),
       (3, 'Кола ср.', 114, 'https://images.restaurant/?id=3&item-id=49', 'Кола ср.'),
       (3, 'Кола бол.', 139, 'https://images.restaurant/?id=3&item-id=50', 'Кола бол.');



--################# Couriers ################################
insert into couriers (phone_number, courier_status)
values ('+78805535354', 'HURRIES_TO_ORDER'),
       ('+78807864354', 'FREE'),
       ('+78607867864', 'FIRED');

insert into coordinates (courier_id,latitude, longitude)
values (1,63.486606, 95.569739),
       (2,63.498864, 95.707160);

--################# Customers ################################
insert into customers (customer_email, phone_number)
values ('cust1@mail.ru', '+78856785354'),
       ('cust2@mail.ru', '+78189455354'),
       ('cust3@mail.ru', '+78189411894');

insert into customer_addressees (city, street, house_number, house_section, house_floor, apartment_number)
values ('Нижний Новгород', 'Бетанкура', 2, 2, 3, 15),
       ('Нижний Новгород', 'Керченская', 22, 2, 5, 55),
       ('Нижний Новгород', 'Большая покровская', 13, 1, 1, 34);


--################# Orders ################################
insert into orders (customer_id,courier_id,restaurant_id, order_price,type_of_delivery, order_status)
values (1,1,1,2421, 'COURIER_DELIVERY', 'IN_WORK'),
       (2,3,2,3290, 'COURIER_DELIVERY', 'DONE');


insert into order_items (order_id,  item_id, quantity,price)
values (1,  1, 1,182),
       (1,  2, 2,193),
       (1,  3, 3,219),
       (1,  4, 4,299);

insert into order_items (order_id,  item_id, quantity,price)
values (2,  22, 1,160),
       (2,  23, 2,290),
       (2,  24, 3,730),
       (2, 25, 4,90);


