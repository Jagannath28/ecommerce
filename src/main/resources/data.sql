INSERT INTO users (id, name, email, password, role) VALUES (1, 'Seeker', 'seeker@example.com', '$2a$10$qQxqV1u1x1zYqF5q7Yb0cOZgV1gqf2oQdY5u6Z5E8G1XQvKj9rC6u', 'JOB_SEEKER');
INSERT INTO users (id, name, email, password, role) VALUES (2, 'Recruiter', 'recruiter@example.com', '$2a$10$qQxqV1u1x1zYqF5q7Yb0cOZgV1gqf2oQdY5u6Z5E8G1XQvKj9rC6u', 'RECRUITER');
INSERT INTO job (id, title, description, location, skills, salary, posted_at, posted_by_id) VALUES (1, 'Sample Job', 'Sample description', 'Bangalore', 'Java,Spring', 600000.0, NOW(), 2);
