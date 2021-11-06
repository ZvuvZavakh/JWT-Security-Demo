INSERT INTO users (
    id,
    created_date,
    last_modified_date,
    first_name,
    last_name,
    email,
    password,
    is_enabled,
    is_verified
) VALUES (
    '0a818933-087d-47f2-ad83-2f986ed087eb',
    CURRENT_TIMESTAMP,
    CURRENT_TIMESTAMP,
    'John',
    'Doe',
    'qwe@asd.zxc',
    '123',
    true,
    true
) ON CONFLICT DO NOTHING;

INSERT INTO roles (id, description, role) VALUES (1, 'Administrator', 'ADMIN') ON CONFLICT DO NOTHING;
INSERT INTO roles (id, description, role) VALUES (2, 'User', 'USER') ON CONFLICT DO NOTHING;

INSERT INTO user_role(user_id, role_id) VALUES ('0a818933-087d-47f2-ad83-2f986ed087eb', 1) ON CONFLICT DO NOTHING;
