insert into usr (id, username, password)
values (1, 'admin', '$2a$12$XASe2mlm28Fsr.aTmcUYUu.lmleftIp4iFfE2m6OIGksHI.yLFUmO');

insert into user_role (user_id, roles)
values (1, 'USER'),
       (1, 'ADMIN');