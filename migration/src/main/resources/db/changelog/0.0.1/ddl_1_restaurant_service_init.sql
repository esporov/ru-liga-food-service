CREATE TABLE IF NOT EXISTS restaurants
(
    restaurant_id   bigint GENERATED BY DEFAULT AS IDENTITY,
    restaurant_name varchar(255) UNIQUE NOT NULL,

    PRIMARY KEY (restaurant_id)
);

CREATE TABLE IF NOT EXISTS restaurant_address
(
    address_id    bigint GENERATED BY DEFAULT AS IDENTITY,
    restaurant_id bigint REFERENCES restaurants (restaurant_id) ON DELETE CASCADE ON UPDATE NO ACTION,
    street_name   varchar(255) NOT NULL,
    city          varchar(255) NOT NULL,
    date_of_add   timestamptz  NOT NULL DEFAULT now(),
    work_status   varchar(255) NOT NULL DEFAULT ('ACTIVE') CHECK ( work_status IN ('ACTIVE', 'INACTIVE')),

    PRIMARY KEY (address_id)
);

CREATE TABLE IF NOT EXISTS menu_items
(
    item_id          bigint GENERATED BY DEFAULT AS IDENTITY,
    restaurant_id    bigint REFERENCES restaurants (restaurant_id) ON DELETE CASCADE ON UPDATE NO ACTION,
    item_name        varchar(255)   NOT NULL,
    item_price       numeric(12, 2) NOT NULL CHECK ( item_price > 0 ),
    item_image       varchar(255)   NOT NULL,
    item_description varchar(255)   NOT NULL,
    item_status      varchar(255)   NOT NULL DEFAULT ('AVAILABLE') CHECK (item_status IN ('AVAILABLE', 'NOT_AVAILABLE')),

    PRIMARY KEY (item_id)
);





