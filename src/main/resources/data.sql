INSERT INTO status(id, status) VALUES (900, 'OPEN');
INSERT INTO status(id, status) VALUES (901, 'CLOSED');
INSERT INTO status(id, status) VALUES (902, 'IN PROGRESS');
INSERT INTO status(id, status) VALUES (903, 'WAITING FOR CLIENT');

INSERT INTO tuser(id, username, name, lastname, email) VALUES (900, 'Fran_92', 'Francesco', 'Spinelli', 'fra.spinelli@hotmail.com');
INSERT INTO tuser(id, username, name, lastname, email) VALUES (901, 'Ghit91', 'Giorgia', 'Sangaletti', 'gio.san@gmail.com');
INSERT INTO tuser(id, username, name, lastname, email) VALUES (902, 'Qwerty78', 'Andrea', 'Ponti', 'andrea.ponti@yahoo.com');
INSERT INTO tuser(id, username, name, lastname, email) VALUES (903, 'lowercase12', 'Laura', 'Cesa', 'laura.cesa@gmail.com');
INSERT INTO tuser(id, username, name, lastname, email) VALUES (904, 'CamelCase13', 'Paola', 'Sita', 'psita@icloud.com');
INSERT INTO tuser(id, username, name, lastname, email) VALUES (905, 'username', 'Richard', 'Pellegrinelli', 'erpelle@aruba.it');
INSERT INTO tuser(id, username, name, lastname, email) VALUES (906, 'great89', 'Carol', 'Mink', 'carol_mi@me.com');

INSERT INTO task(id, name, description, statusid) VALUES (900, 'partenza macro 1', 'macro linea 1', 900);
INSERT INTO task(id, name, description, statusid) VALUES (901, 'partenza macro 2', 'macro linea 2', 900);
INSERT INTO task(id, name, description, statusid) VALUES (902, 'partenza macro 3', 'macro linea 3', 900);
INSERT INTO task(id, name, description, statusid) VALUES (903, 'partenza macro 4', 'macro linea 4', 902);
INSERT INTO task(id, name, description, statusid) VALUES (904, 'partenza macro 5', 'macro linea 5', 902);

INSERT INTO task_user(taskid, userid) VALUES (900, 900);
INSERT INTO task_user(taskid, userid) VALUES (901, 900);
INSERT INTO task_user(taskid, userid) VALUES (902, 900);
INSERT INTO task_user(taskid, userid) VALUES (903, 900);
INSERT INTO task_user(taskid, userid) VALUES (901, 904);
INSERT INTO task_user(taskid, userid) VALUES (900, 904);
INSERT INTO task_user(taskid, userid) VALUES (900, 906);
INSERT INTO task_user(taskid, userid) VALUES (903, 906);