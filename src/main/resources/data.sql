INSERT INTO auth_authority (id, role_description) values(1, "ADMIN")
INSERT INTO auth_authority (id, role_description) values(2, "CLIENT")
INSERT INTO auth_authority (id, role_description) values(3, "FOURNISSEUR")

INSERT INTO auth_user_details(id, enabled, password, username) values (1, true, "password", "admin" )
INSERT INTO auth_user_authority(user_id, authorities_id) values(1,1) 