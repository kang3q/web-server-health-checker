-- create table urls (id bigint generated by default as identity, name varchar(50) not null, url varchar(200) not null, primary key (id));

insert into info (name, url)
values
  ('강상규', 'http://127.0.0.1:8080')
  , ('강상규', 'http://www.naver.com')
  , ('어드민', 'localhost:8080')
  , ('강상규', 'http://www.google.com')
  , ('어드민', 'http://localhost:8080');