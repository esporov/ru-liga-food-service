CREATE TABLE IF NOT EXISTS restaurants
(
    restaurant_id   bigint GENERATED BY DEFAULT AS IDENTITY,
    restaurant_name varchar(255) UNIQUE NOT NULL,

    PRIMARY KEY (restaurant_id)
);

CREATE TABLE IF NOT EXISTS restaurant_address
(
    address_id        bigint GENERATED BY DEFAULT AS IDENTITY,
    street_name       varchar(255) NOT NULL,
    city              varchar(255) NOT NULL,
    date_of_add       date         not null,
    restaurant_status varchar(50) DEFAULT ('ACTIVE'),

    PRIMARY KEY (address_id),
    CONSTRAINT restaurant_address_restaurant_status_chk
        CHECK ( restaurant_status = 'ACTIVE' OR restaurant_status = 'INACTIVE' )
);



CREATE TABLE IF NOT EXISTS menu_items
(
    item_id     bigint GENERATED BY DEFAULT AS IDENTITY,
    item_name   varchar(255) NOT NULL,
    item_price  integer      NOT NULL,
    item_status varchar(50) DEFAULT ('AVAILABLE'),

    PRIMARY KEY (item_id),
    CONSTRAINT menu_items_item_status_chk
        CHECK ( item_status = 'AVAILABLE' OR item_status = 'NOT_AVAILABLE' )
);

ALTER TABLE menu_items
    ALTER COLUMN item_status SET DEFAULT 'AVAILABLE';

CREATE TABLE IF NOT EXISTS restaurants_restaurant_address
(
    restaurant_id bigint,
    address_id    bigint,

    PRIMARY KEY (restaurant_id, address_id),
    CONSTRAINT restaurants_restaurants_restaurant_address_restaurant_id_fk
        FOREIGN KEY (restaurant_id) references restaurants (restaurant_id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT restaurant_address_restaurants_restaurant_address_address_id_fk
        FOREIGN KEY (address_id) references restaurant_address (address_id) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS restaurants_menu_items
(
    restaurant_id bigint  NOT NULL,
    item_id       integer NOT NULL,

    PRIMARY KEY (restaurant_id, item_id),
    CONSTRAINT restaurants_menu_items_restaurant_id_fk
        FOREIGN KEY (restaurant_id) references restaurants (restaurant_id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT menu_items_restaurants_item_id_fk
        FOREIGN KEY (item_id) references menu_items (item_id) ON DELETE CASCADE ON UPDATE NO ACTION
);


/*
CREATE TYPE RESTAURANT_STATUS as ENUM ('AVAILABLE', 'NOT_AVAILABLE');

CREATE TABLE IF NOT EXISTS restaurant_address
(
    address_id        bigint GENERATED BY DEFAULT AS IDENTITY,
    street_name       varchar(255)      NOT NULL,
    city              varchar(255)      NOT NULL,
    date_of_add       date              not null,
    restaurant_status RESTAURANT_STATUS NOT NULL,

    PRIMARY KEY (address_id)
);

ALTER TABLE restaurant_address
    ALTER COLUMN restaurant_status SET DEFAULT 'ACTIVE';*/








