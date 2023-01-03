INSERT INTO user_roles(id, role) VALUES (1, 'ROLE_ADMIN'), (2, 'ROLE_USER');
INSERT INTO sb_app_users(id, password, user_name) VALUES (1, '$2a$12$aSgtDNUaoqWkDit32GElvuY.XNfgyepchPxH5zOf2PXNgsAEJff92', 'admin');
INSERT INTO roles_to_users(user_id, role_id) VALUES(1,1);