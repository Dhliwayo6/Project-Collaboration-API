-- CREATE DATABASE project_collab;

use project_collab;

CREATE TABLE app_users (
	id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    email VARCHAR(250) NOT NULL,
    date_created DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
);

CREATE TABLE projects (
	id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(250) UNIQUE NOT NULL,
    description VARCHAR(255) NOT NULL,
    date_created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    user_id INT,
    FOREIGN KEY(user_id) REFERENCES app_users(id)
);

CREATE TABLE tasks (
	id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(250) NOT NULL,
    content VARCHAR(250) NOT NULL,
    date_created DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    project_id INT,
    FOREIGN KEY(project_id) REFERENCES projects(id)
);
