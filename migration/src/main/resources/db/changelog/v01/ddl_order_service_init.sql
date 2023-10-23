CREATE TYPE ORDER_STATUS AS ENUM ('IN_WORK', 'DONE', 'DENIED', 'NOT_ACCEPTED_YET');
CREATE TYPE DELIVERY_TYPE AS ENUM ('COURIER_DELIVERY', 'SELF_DELIVERY');

CREATE TABLE IF NOT EXISTS orders
(
    order_id         bigint GENERATED BY DEFAULT AS IDENTITY,
    order_status     ORDER_STATUS   NOT NULL DEFAULT 'NOT_ACCEPTED_YET',
    type_of_delivery DELIVERY_TYPE  NOT NULL,
    create_date      timestamptz    NOT NULL DEFAULT now(),
    order_price      numeric(12, 2) NOT NULL,

    PRIMARY KEY (order_id)
);

CREATE TABLE IF NOT EXISTS order_items
(
    order_id   bigint,
    address_id bigint,
    item_id    bigint,
    quantity   integer NOT NULL CHECK ( quantity > 0 ),

    PRIMARY KEY (order_id, address_id, item_id),
    CONSTRAINT orders_order_items_fk
        FOREIGN KEY (order_id) REFERENCES orders (order_id) ON DELETE CASCADE ON UPDATE NO ACTION,
    CONSTRAINT restaurant_address_order_items_fk
        FOREIGN KEY (address_id) REFERENCES restaurant_address (address_id),
    CONSTRAINT menu_items_order_items_fk
        FOREIGN KEY (item_id) REFERENCES menu_items (item_id)
);








