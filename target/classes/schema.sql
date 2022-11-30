drop table if exists subscription;
create table subscription(subscriber_id int primary key, subscriber_name varchar(100), date_subscribed varchar(100), date_returned varchar(50),book_id int)