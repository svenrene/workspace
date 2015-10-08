drop table if exists Zug;
drop table if exists Startstellung;
drop table if exists JdbcNim;

create table JdbcNim (
	id bigint not null primary key
);

create table Startstellung (
	id bigint not null,
	idx integer not null,
	anzahl integer not null,
	primary key(id, idx),
	foreign key (id) references JdbcNim(id)
);

create table Zug (
	id bigint not null,
	zugnr integer not null,
	idx integer not null,
	anzahlsteine integer not null,
	primary key(id, zugnr),
	foreign key (id) references JdbcNim(id)
);