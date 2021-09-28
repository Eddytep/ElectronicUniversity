INSERT INTO human(id, human_type, username, password)
    VALUES (nextval('hibernate_sequence'), 1,  'admin', '$2a$12$XASe2mlm28Fsr.aTmcUYUu.lmleftIp4iFfE2m6OIGksHI.yLFUmO');

INSERT INTO human_role (human_id, roles)
    VALUES (currval('hibernate_sequence'), 'ADMIN');
