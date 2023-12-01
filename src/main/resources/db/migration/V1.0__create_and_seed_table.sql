CREATE TABLE IF NOT EXISTS users (
    id SMALLINT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    role VARCHAR(40) NOT NULL
);

INSERT INTO users (first_name, last_name, email, role)
VALUES 
    ('Vincent', 'Kigen', 'vincentkigen@users.com', 'Backend Engineer'),
    ('Kimutai', 'Kirui', 'kimutaikirui@users.com', 'DevOps Engineer'),
    ('Jeremy', 'Mutai', 'jeremutai@users.com', 'Frontend Engineer');