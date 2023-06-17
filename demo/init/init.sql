CREATE TABLE user_tb (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO user_tb (name) VALUES ('John');
INSERT INTO user_tb (name) VALUES ('Jane');