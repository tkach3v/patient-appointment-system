insert into public.patient(uuid, full_name, birth_date) values ('2607f29e-e698-44f4-9298-f80b3d342f2c', 'Агальцов М. Г.', '1980-05-07');
insert into public.patient(uuid, full_name, birth_date) values ('31e82510-33d5-42ed-9177-9d20b648ebcd', 'Тарасова O. В.', '1999-05-03');
insert into public.patient(uuid, full_name, birth_date) values ('e2327d92-c00c-4f84-a2a1-bcf879f6b191', 'Чернышенко М. А.', '2001-10-10');
insert into public.patient(uuid, full_name, birth_date) values ('085bf5f2-2028-430a-96e3-fdac4d81d947', 'Маслов А. С.', '1994-09-10');


insert into public.doctor(uuid, full_name, birth_date) values ('acd8a77b-10f0-47b3-acc9-556fafbf97e8', 'Зайцев В. В.', '1970-02-07');
insert into public.doctor(uuid, full_name, birth_date) values ('30f98419-e9fb-4f4b-84ac-8223c3af765c', 'Тарасова O. В.', '1965-01-02');



insert into public.appointment(date, doctor_id, patient_id, start_time) values ('2022-10-29', 1, 1, '09:00:00');
insert into public.appointment(date, doctor_id, patient_id, start_time) values ('2022-10-29', 1, 2, '09:30:00');
insert into public.appointment(date, doctor_id, patient_id, start_time) values ('2022-10-29', 1, null, '10:00:00');
insert into public.appointment(date, doctor_id, patient_id, start_time) values ('2022-10-29', 1, null, '10:30:00');
insert into public.appointment(date, doctor_id, patient_id, start_time) values ('2022-10-29', 1, null, '11:00:00');









