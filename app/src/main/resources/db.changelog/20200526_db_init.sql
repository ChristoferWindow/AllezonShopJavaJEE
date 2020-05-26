
CREATE TABLE department
(
    id   BIGINT      NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE category
(
    id            BIGINT      NOT NULL,
    name          VARCHAR(50) NOT NULL,
    department_id BIGINT      NOT NULL,
    FOREIGN KEY (department_id) REFERENCES department (id),
    PRIMARY KEY (id)
);

CREATE TABLE auction
(
    id          BIGINT         NOT NULL,
    title       VARCHAR(50)    NOT NULL,
    description VARCHAR(350)   NOT NULL,
    price       DECIMAL(15, 2) NOT NULL,
    category_id BIGINT         NOT NULL,
    owner_id    BIGINT         NOT NULL,
    version     BIGINT         NOT NULL,
    FOREIGN KEY (owner_id) REFERENCES users (id),
    FOREIGN KEY (category_id) REFERENCES category (id),
    PRIMARY KEY (id)
);

CREATE TABLE parameter
(
    id   BIGINT      NOT NULL,
    name VARCHAR(50) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE auction_parameter
(
    auction_id   BIGINT      NOT NULL,
    parameter_id BIGINT      NOT NULL,
    value        VARCHAR(50) NOT NULL,
    FOREIGN KEY (auction_id) REFERENCES auction (id),
    FOREIGN KEY (parameter_id) REFERENCES parameter (id)
);

CREATE TABLE photo
(
    id         BIGINT       NOT NULL,
    url        VARCHAR(100) NOT NULL,
    auction_id BIGINT       NOT NULL,
    FOREIGN KEY (auction_id) REFERENCES auction (id),
    PRIMARY KEY (id)
);