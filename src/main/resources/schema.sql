CREATE TABLE IF NOT EXISTS notes (
    id INT AUTO_INCREMENT PRIMARY KEY,
    title varchar(50) NOT NULL,
    description varchar(50) NOT NULL,
    date varchar(50) NOT NULL
    );

INSERT INTO notes (title, description,date)
VALUES ('Магазин', 'Заехать за продуктами','2019-01-10');

INSERT INTO notes (title, description,date)
VALUES ('Авто', 'Купить незамерзайку','2019-01-10');

INSERT INTO notes (title, description,date)
VALUES ('Электричество', 'Оплатить счет по электроэнергии','2019-01-10');