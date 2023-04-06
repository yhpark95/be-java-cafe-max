CREATE TABLE articles (
                         id BIGINT PRIMARY KEY AUTO_INCREMENT,
                         author VARCHAR(255) NOT NULL,
                         title VARCHAR(255) NOT NULL,
                         contents VARCHAR(1000) NOT NULL,
                         time TIMESTAMP NOT NULL
);

CREATE TABLE users (
                            user_id VARCHAR(255) PRIMARY KEY NOT NULL,
                            password VARCHAR(255) NOT NULL,
                            name VARCHAR(255) NOT NULL,
                            email VARCHAR(255) NOT NULL
);
