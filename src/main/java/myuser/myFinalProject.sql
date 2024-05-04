use web;
-- 測試專案user
drop table if exists myuser;

-- 建立myuser
CREATE TABLE IF NOT EXISTS myuser (
    id VARCHAR(10) PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    pwd VARCHAR(50) NOT NULL,
    dept VARCHAR(50) NOT NULL,
    title VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL,
    auth_level INT DEFAULT 0,
    create_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);



-- myuser假資料
INSERT INTO myuser (id, name, pwd, dept, title, email, auth_level) VALUES 
('00000', 'root', '12345678', '衛材庫房', 'root', 'root@test.com', 3),
('73174', '王俊傑', '12345678', '秘書室', '替代役', 'school832@gmail.com', 2),
('12345', '金一蓉', '12345678', '文書中心', '一般專員', 'school832@gmail.com', 1),
('22345', '陳二令', '12345678', '衛材庫房', '契約專員', 'r10522828@ntu.edu.tw', 2),
('34567', '張四騰', '12345678', '秘書室', '替代役', 'school832@gmail.com', -1);


INSERT INTO myuser (id, name, pwd, dept, title, email) VALUES 
('54321', '王三香', '12345678', '衛材庫房', '契約專員', 'r10522828@ntu.edu.tw');
