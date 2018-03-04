-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL,
  name     VARCHAR(255) NOT NULL,
  surname  VARCHAR(255) NOT NULL,
  phone    VARCHAR(255) NOT NULL,
  email    VARCHAR(255) NOT NULL

)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Insert data

INSERT INTO users VALUES (1, 'qualwak', '$2b$10$ocVOh8A6KgOrdRfnONflveKyU7ziFmuvc3.Q9Ox7YD4SzSiatEEuy');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);

CREATE TABLE books (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  title    VARCHAR(255) NOT NULL,
  author   VARCHAR(255) NOT NULL,
  year     VARCHAR(255) NOT NULL,
  edition  INT          NOT NULL,
  price    INT          NOT NULL,
  copies   INT          NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE journal_articles (
  id                        INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  journal_title             VARCHAR(255)  NOT NULL,
  article_title             VARCHAR(255)  NOT NULL,
  publication_month_year    VARCHAR(255)  NOT NULL,
  author                    VARCHAR(255)  NOT NULL,
  editor                    VARCHAR(255)  NOT NULL,
  price                     INT           NOT NULL,
  copies                    INT           NOT NULL
)
  ENGINE = InnoDB;

CREATE TABLE audio_video(
  id           INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  author       VARCHAR(255) NOT NULL,
  title        VARCHAR(255) NOT NULL,
  price        INT          NOT NULL,
  copies       INT          NOT NULL
)
  ENGINE = InnoDB;