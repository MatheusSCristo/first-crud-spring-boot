CREATE TYPE Model AS ENUM('Camisa', 'Calca', 'Vestido', 'Bone')
CREATE TABLE clothes(
    id String NOT NULL PRIMARY KEY UNIQUE,
    nome String NOT NULL ,
    price Double Precision NOT NULL,
    image String
    model Model
)