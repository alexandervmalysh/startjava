\c robots;

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
    id          SERIAL          PRIMARY KEY,
    model_name  VARCHAR(50)     NOT NULL,
    mark        VARCHAR(10)     NOT NULL,
    height      NUMERIC(6,3)    NOT NULL,
    weight      NUMERIC(8,5)    NOT NULL,
    status      VARCHAR(30)     NOT NULL,
    origin      VARCHAR(30)     NOT NULL,
    launch      DATE            NOT NULL,
    kaiju_kill  INT             NOT NULL
);

\i populate.sql
\i queries.sql
