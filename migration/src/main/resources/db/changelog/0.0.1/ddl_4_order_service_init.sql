CREATE TABLE IF NOT EXISTS orders
(
    order_id         bigint GENERATED BY DEFAULT AS IDENTITY,
    customer_id      bigint REFERENCES customers (customer_id) ON DELETE CASCADE ON UPDATE NO ACTION,
    restaurant_id    bigint         NOT NULL,
    order_status     varchar(255)   NOT NULL DEFAULT 'NOT_ACCEPTED_YET'
        CHECK ( order_status IN ('IN_WORK', 'DONE', 'DENIED', 'NOT_ACCEPTED_YET')),
    type_of_delivery varchar(255)   NOT NULL DEFAULT 'COURIER_DELIVERY'
        CHECK ( type_of_delivery IN ('COURIER_DELIVERY', 'SELF_DELIVERY')),
    create_date      timestamptz    NOT NULL DEFAULT now(),
    order_price      numeric(12, 2) NOT NULL CHECK ( order_price > 0 ),
    courier_id       bigint         NULL REFERENCES couriers (courier_id),

    PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS order_items
(
    id         bigint GENERATED BY DEFAULT AS IDENTITY,
    order_id bigint REFERENCES orders (order_id) ON DELETE CASCADE ON UPDATE NO ACTION,
    item_id  bigint REFERENCES menu_items (item_id) ON DELETE CASCADE ON UPDATE NO ACTION,
    quantity integer        NOT NULL CHECK ( quantity > 0 ),
    price    numeric(12, 2) NOT NULL CHECK ( price > 0 ),

    PRIMARY KEY (id)
);








