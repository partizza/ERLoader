CREATE SCHEMA `dev` ;


create table dev.currency(
id varchar(5),
title varchar(60),
constraint currency_pk primary key (id)
);

create table dev.city(
id varchar(50),
title varchar(60),
constraint city_pk primary key (id)
);

create table dev.region(
id varchar(50),
title varchar(60),
constraint region_pk primary key (id)
);

create table dev.tp_pos(
id varchar(2),
title varchar(60),
constraint tp_pos_pk primary key (id)
);

create table dev.pos(
id varchar(50),
title varchar(60),
address varchar(260),
tp varchar(2),
city varchar(50),
region varchar(50),
constraint pos_pk primary key (id),
constraint pos_fk_tp FOREIGN key (tp) REFERENCES dev.tp_pos(id),
constraint pos_fk_city FOREIGN KEY (city) REFERENCES dev.city(id),
CONSTRAINT pos_fk_region FOREIGN KEY (region) REFERENCES dev.region(id)
);

-- exch_rates
create table dev.exch_rate(
id int not null AUTO_INCREMENT,
pos varchar(50),
currency varchar(5),
dtime TIMESTAMP not null,
br decimal(10,6),
ar decimal(10,6),
constraint exch_rate_pk primary key (id),
constraint exch_rate_fk_pos FOREIGN key (pos) REFERENCES dev.pos(id),
constraint exch_rate_fk_currency foreign key (currency) REFERENCES dev.currency(id),
constraint exch_rate_uk UNIQUE (pos,currency,dtime)
);