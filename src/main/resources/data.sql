--USERS
insert into users (id, email,first_name,last_name, password)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'admin@example.com', 'James','Bond', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6' ), -- Password: 1234
('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'user@example.com', 'Tyler','Durden', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'), -- Password: 1234
('1c5b661f-ac5d-436f-a839-941e611dcc41', 'ronaldo@example.com', 'Cristiano', 'Ronaldo', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6') -- Password: 1234
 ON CONFLICT DO NOTHING;


--ROLES
INSERT INTO role(id, name)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', 'DEFAULT'),
('ab505c92-7280-49fd-a7de-258e618df074', 'ADMIN'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'USER')
ON CONFLICT DO NOTHING;

--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'USER_MODIFY'),
('21c942db-a275-43f8-bdd6-d048c21bf5ab', 'USER_DELETE'),
('ef4552b0-4646-434c-9a54-4d9605fd3f7f', 'BLOG_READ'),
('d4deef35-aa2b-4753-97ef-c2710c152e22', 'BLOG_CREATE'),
('cbd83ec7-f30c-4d78-8f59-0d0fa99553d4', 'BLOG_DELETE_BY_ID'),
('4148cc1f-af9d-4153-9bb6-fb31a048e714', 'BLOG_MODIFY_BY_ID')
ON CONFLICT DO NOTHING;

--assign roles to users
insert into users_role (users_id, role_id)
values ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'd29e709c-0ff1-4f4c-a7ef-09f656c390f1'),
       ('0d8fa44c-54fd-4cd0-ace9-2a7da57992de', 'd29e709c-0ff1-4f4c-a7ef-09f656c390f1'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'ab505c92-7280-49fd-a7de-258e618df074'),
       ('ba804cb9-fa14-42a5-afaf-be488742fc54', 'c6aee32d-8c35-4481-8b3e-a876a39b0c02')
 ON CONFLICT DO NOTHING;

--assign authorities to roles
INSERT INTO role_authority(role_id, authority_id)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', '2ebf301e-6c61-4076-98e3-2a38b31daf86'),
('ab505c92-7280-49fd-a7de-258e618df074', '76d2cbf6-5845-470e-ad5f-2edb9e09a868'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '21c942db-a275-43f8-bdd6-d048c21bf5ab'),
('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', 'ef4552b0-4646-434c-9a54-4d9605fd3f7f'),
--USER can only use CRUD operations on his own posts
('ab505c92-7280-49fd-a7de-258e618df074', 'ef4552b0-4646-434c-9a54-4d9605fd3f7f'),
('ab505c92-7280-49fd-a7de-258e618df074', 'd4deef35-aa2b-4753-97ef-c2710c152e22'),
('ab505c92-7280-49fd-a7de-258e618df074', 'cbd83ec7-f30c-4d78-8f59-0d0fa99553d4'),
('ab505c92-7280-49fd-a7de-258e618df074', '4148cc1f-af9d-4153-9bb6-fb31a048e714'),
--ADMIN can use CRUD operations on all the posts
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'ef4552b0-4646-434c-9a54-4d9605fd3f7f'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'd4deef35-aa2b-4753-97ef-c2710c152e22'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'cbd83ec7-f30c-4d78-8f59-0d0fa99553d4'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '4148cc1f-af9d-4153-9bb6-fb31a048e714')
 ON CONFLICT DO NOTHING;


--Add fake data to BlogPost
INSERT INTO blogpost (id, text, category, author) VALUES
('bfd33f6c-6727-4bd0-8087-72f0ff6d7eb7', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit.', 'Technology', 'ba804cb9-fa14-42a5-afaf-be488742fc54'),
('117bac62-ecc1-475a-8d98-d2fecc1ff5e7', 'Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.', 'Travel', 'ba804cb9-fa14-42a5-afaf-be488742fc54'),
('85e6dbdd-f6ae-49a7-85c3-c38190d079b6', 'Integer euismod justo at magna efficitur, vel molestie quam laoreet.', 'Food', 'ba804cb9-fa14-42a5-afaf-be488742fc54'),
('9f8f84c6-4ab1-45c4-b6ee-a54461c92002', 'Suspendisse vel risus in arcu varius auctor eget id magna.', 'Fashion', 'ba804cb9-fa14-42a5-afaf-be488742fc54'),
('a9b49925-5bbd-4baa-b473-4fb1406f2c96', 'Dies ist ein Test-Beitrag', 'Test', '1c5b661f-ac5d-436f-a839-941e611dcc41'),
('c7c1d196-a9ad-410a-8a25-af919d65045b', 'Ein weiterer Testbeitrag', 'Test', '1c5b661f-ac5d-436f-a839-941e611dcc41')
 ON CONFLICT DO NOTHING;