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

INSERT INTO app_users (first_name, last_name, email) VALUES
('John', 'Smith', 'john.smith@example.com'),
('Emma', 'Johnson', 'emma.j@tech.org'),
('Michael', 'Brown', 'm.brown@dev.io'),
('Sarah', 'Davis', 'sarahd@collab.net'),
('David', 'Wilson', 'dwilson@project.co');

INSERT INTO projects (name, description, user_id) VALUES
('Website Redesign', 'Complete overhaul of company website', 1),
('Mobile App', 'iOS/Android fitness tracking application', 3),
('Database Migration', 'Move from legacy system to cloud', 2);

INSERT INTO tasks (title, content, project_id) VALUES
('Create wireframes', 'Design homepage and user flow', 1),
('Set up CI/CD', 'Configure Jenkins pipeline', 2),
('Schema validation', 'Verify relational integrity', 3),
('UI Kit development', 'Build reusable React components', 1),
('API integration', 'Connect backend to mobile client', 2),
('Data sanitization', 'Clean legacy customer data', 3),
('Responsive testing', 'Cross-browser compatibility check', 1),
('Push notifications', 'Implement Firebase messaging', 2);
